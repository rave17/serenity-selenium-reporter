package shop.tasks.Registertask;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import shop.model.ActorUsuario;
import shop.pages.registro.RegistroUsuarioPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresoDeEnCamposDeRegistroTask implements Task {

    private final ActorUsuario usuario;

    public IngresoDeEnCamposDeRegistroTask() {
        // Aquí cargás los datos que querés introducir en el formulario
        this.usuario = new ActorUsuario(
                "Franco",               // nombre
                "Gonzalez",             // apellido
                "franco@g.com",         // email
                "123456789",            // teléfono
                "Test1234",             // contraseña
                "Test1234"              // confirmar contraseña
        );
    }

    public static IngresoDeEnCamposDeRegistroTask completarFormulario() {
        return Tasks.instrumented(IngresoDeEnCamposDeRegistroTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario.getNombre()).into(RegistroUsuarioPage.FIRST_NAME_FIELD_REGISTER),
                Enter.theValue(usuario.getApellido()).into(RegistroUsuarioPage.LAST_NAME_FIELD_REGISTER),
                Enter.theValue(usuario.getEmail()).into(RegistroUsuarioPage.EMAIL_FIELD_REGISTER),
                Enter.theValue(usuario.getTelefono()).into(RegistroUsuarioPage.TELEPHONE_FIELD),
                Enter.theValue(usuario.getContrasenia()).into(RegistroUsuarioPage.PASSWORD_FIELD_REGISTER),
                Enter.theValue(usuario.getConfirmarContrasenia()).into(RegistroUsuarioPage.CONFIRM_PASSWORD_FIELD_REGISTER),
                Click.on(RegistroUsuarioPage.PRIVACY_POLICY_CHECKBOX),
                WaitUntil.the(RegistroUsuarioPage.CONTINUE_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(RegistroUsuarioPage.CONTINUE_BUTTON)
        );
    }

}
