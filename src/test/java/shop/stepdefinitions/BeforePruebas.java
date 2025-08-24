package shop.stepdefinitions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.WebDriver;
import shop.navigation.NavigateTo;
import shop.pages.UsuarioLogeado;
import shop.tasks.LoginShopDesdeUnJson;
import shop.tasks.LoginTask;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static shop.pages.UsuarioLogeado.EDIT_ACCOUNT_BTN;
import static shop.pages.login.LoginPage.*;
import static shop.pages.login.LoginPage.MY_ACCOUNT_BTN;

public class BeforePruebas {
    @Managed(driver = "chrome")
    WebDriver navegador;

    @Dado("{actor} ingresa a la pagina del login de la tienda")
    public void ingresa_a_la_página_del_login_de_la_tienda(Actor actor) {
        actor.can(BrowseTheWeb.with(navegador));
        actor.wasAbleTo(NavigateTo.ShopLoginPage());
    }
    @Cuando("{actor} intenta iniciar sesión con los datos desde el archivo {string}")
    public void intentaIniciarSesionConLosDatosDesdeElArchivo(Actor actor, String nombreArchivo) {
        String ruta = "src/test/resources/data/" + nombreArchivo;

        try (Reader reader = new FileReader(ruta)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            Map<String, String> datos = new HashMap<>();
            datos.put("email", jsonObject.get("email").getAsString());
            datos.put("password", jsonObject.get("contrasenia").getAsString());

            actor.attemptsTo(LoginTask.conDatos(datos));

        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo JSON: " + nombreArchivo, e);
        }
    }
    @Cuando("{actor} intenta iniciar sesión con los datos desde el archivo1 {string}")
    public void intentaIniciarSesionConLosDatosDesdeElArchivo1(Actor actor, String nombreArchivo) {
        String ruta = "src/test/resources/data/" + nombreArchivo;
        actor.attemptsTo(LoginShopDesdeUnJson.conDatosDesde(ruta));
    }

    @Entonces("{actor} debería ver su cuenta iniciada correctamente")
    public void deberiaVerSuCuentaIniciadaCorrectamente(Actor actor) {
        actor.attemptsTo(
                the(UsuarioLogeado.EDIT_ACCOUNT_BTN, isVisible()).forNoMoreThan(5).seconds(),
                the(UsuarioLogeado.CHANGE_PASSWORD_BTN, isVisible()).forNoMoreThan(5).seconds()

        );
        System.out.println(actor + " valida estar logeado correctamente");
    }
}
