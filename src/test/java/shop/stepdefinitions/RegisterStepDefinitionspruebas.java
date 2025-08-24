package shop.stepdefinitions;

import io.cucumber.datatable.DataTable;
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
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import shop.navigation.NavigateTo;
import shop.pages.registro.RegistroUsuarioPage;
import shop.questions.AlertasVisibles;
import shop.tasks.Registertask.IngresoDeEnCamposDeRegistroTask;
import util.CampoMapper;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.hamcrest.Matchers.is;
import static shop.pages.registro.RegistroUsuarioPage.*;


public class RegisterStepDefinitionspruebas {
    @Y("{actor} completa el formulario con los siguientes datos:")
    public void completarFormulario(Actor actor, DataTable dataTable) {
        List<Map<String, String>> filas = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> fila : filas) {
            String campo = fila.get("campo");
            String valor = fila.get("valor");

            Target target = CampoMapper.obtenerCampoPorTexto(campo);

            actor.attemptsTo(
                    JavaScriptClick.on(target),
                    Click.on(target),
                    Enter.theValue(valor).into(target),
                    WaitUntil.the(target, isVisible()).forNoMoreThan(5).seconds()
            );
        }
    }
    @Cuando("{actor} completa el formulario de registro")
    public void completarFormularioRegistro(Actor actor) {
        actor.attemptsTo(
                IngresoDeEnCamposDeRegistroTask.completarFormulario()
        );
    }

}

