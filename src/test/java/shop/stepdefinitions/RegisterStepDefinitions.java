package shop.stepdefinitions;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.targets.Target;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import shop.navigation.NavigateTo;
import shop.pages.registro.RegistroUsuarioPage;
import shop.questions.AlertasVisibles;
import shop.tasks.Registertask.IngresoDeEnCamposDeRegistroTask;
import util.CampoMapper;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static shop.pages.registro.RegistroUsuarioPage.*;


public class RegisterStepDefinitions {
    @Managed(driver = "chrome")
    WebDriver navegador;

    @Dado("{actor} está en la página de registro de la tienda")
    public void estáEnLaPáginaDeRegistroDeLaTienda(Actor actor) {
        actor.can(BrowseTheWeb.with(navegador));
        actor.wasAbleTo(NavigateTo.RegisterHomePage());

        System.out.println("paso " + actor + " está en la página de registro");
    }

    @Cuando("{actor} hace clic en el botón 'Continue'")
    public void haceClicEnElBotónContinue(Actor actor) {
        the(FIRST_NAME_FIELD_REGISTER, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de nombre");
        the(LAST_NAME_FIELD_REGISTER, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de apellido");
        the(EMAIL_FIELD_REGISTER, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de email");
        the(TELEPHONE_FIELD, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de telefono");
        the(PASSWORD_FIELD_REGISTER, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de password");
        the(CONFIRM_PASSWORD_FIELD_REGISTER, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de confirmar password");
        the(PRIVACY_POLICY_CHECKBOX, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de checkbox");
        the(BTN_YES, isVisible()).forNoMoreThan(5).seconds();
        the(CONTINUE_BUTTON, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida elemento de continue button");
        Click.on(CONTINUE_BUTTON);
        System.out.println("paso " + actor + " hace clic en Continue Y VALIDA CAMPOS ");
    }
    @Entonces ("{actor} debería ver un mensaje de error indicando en cada campo los campos son obligatorios")
    public void ValidaAlertas(Actor actor) {
        the(ALERT_FIRSTNAME_REQUIRED, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida alerta de nombre");
        the(ALERT_LASTNAME_REQUIRED, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida alerta de apellido");
        the(ALERT_EMAIL_REQUIRED, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida alerta de email");
        the(ALERT_TELEPHONE_REQUIRED, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida alerta de telefono");
        the(ALERT_PASSWORD_REQUIRED, isVisible()).forNoMoreThan(5).seconds();
        System.out.println("paso " + actor + "valida alerta de password");

    }
    @Y("{actor} completa el formulario con los siguientes datos3:")
    public void completarFormulario3(Actor actor, DataTable dataTable) {
        // El Actor obtiene la fila de datos del Scenario Outline
        Map<String, String> fila = dataTable.asMaps().get(0);

        // El Actor realiza las acciones de llenar el formulario
        for (Map.Entry<String, String> entrada : fila.entrySet()) {
            String campo = entrada.getKey();
            String valor = entrada.getValue();
            Target target = CampoMapper.obtenerCampoPorTexto(campo);

            // Si hay un valor, el Actor lo introduce; de lo contrario, solo hace clic para enfocar
            if (valor != null && !valor.isEmpty()) {
                actor.attemptsTo(
                        JavaScriptClick.on(target), // Para elementos complejos
                        Click.on(target),           // Para asegurar el foco
                        Enter.theValue(valor).into(target)
                );
            } else {
                actor.attemptsTo(
                        JavaScriptClick.on(target),
                        Click.on(target)
                );
            }
        }
        actor.attemptsTo(
                Click.on(RegistroUsuarioPage.CONTINUE_BUTTON)
        );
        actor.should(
                seeThat("las alertas visibles en pantalla son",
                        AlertasVisibles.AlertasEnPantalla(),
                        is(actor.asksFor(AlertasVisibles.AlertasEnPantalla()))
                )
        );
    }

}

