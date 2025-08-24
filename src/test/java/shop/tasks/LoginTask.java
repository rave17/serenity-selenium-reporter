package shop.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import shop.pages.login.LoginPage;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Map;

public class LoginTask implements Task {

    private final Map<String, String> datosLogin;

    public LoginTask(Map<String, String> datosLogin) {
        this.datosLogin = datosLogin;
    }

    public static LoginTask conDatos(Map<String, String> datosLogin) {
        return Tasks.instrumented(LoginTask.class, datosLogin);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        datosLogin.forEach((campo, valor) -> {
            if (!valor.isEmpty()) {
                System.out.println("Solo ingresa " + campo + ": " + valor);
                Target target = obtenerCampoPorNombre(campo);
                actor.attemptsTo(
                        Enter.theValue(valor).into(target)
                );
            }
        });
        actor.attemptsTo(JavaScriptClick.on(LoginPage.LOGIN_BTN));
    }

    private Target obtenerCampoPorNombre(String campo) {
        switch (campo.toLowerCase()) {
            case "email":
                return LoginPage.EMAIL_FIELD;
            case "password":
                return LoginPage.PASSWORD_FIELD;
            default:
                throw new IllegalArgumentException("Campo no soportado: " + campo);
        }
    }
}
