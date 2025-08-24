package shop.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.waits.WaitUntil.the;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.WebDriver;
import shop.navigation.NavigateTo;
import shop.pages.login.LoginPage;
import shop.tasks.LoginTask;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static shop.pages.login.LoginPage.*;

public class LoginStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver navegador;


    @Dado("{actor} ingresa a la pagina de la tienda sin registrarse")
    public void ingresarAshop(Actor actor) {
        actor.can(BrowseTheWeb.with(navegador));
        actor.wasAbleTo(NavigateTo.ShopHomePage());

        System.out.println("paso 1 - " + actor + "accede");
    }

    @Entonces("{actor} valida que 'My account' se encuentre disponible")
    public void validarMyAccountEnPantalla(Actor actor) {
        actor.attemptsTo(
                the(MY_ACCOUNT_BTN, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(MY_ACCOUNT_BTN)
        );
        System.out.println("paso 2 - " + actor + "valida elemento y ingresa a login + valida elemento de Email y Password");
    }

    @Cuando("{actor} ingresa su email y hace clic en el botón Login")
    public void validarCamposEmailYPassword(Actor actor) {
        actor.attemptsTo(
                the(EMAIL_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("francoosuna1822@gmail.com").into(EMAIL_FIELD),
                the(PASSWORD_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                the(LOGIN_BTN, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LOGIN_BTN)

        );
        System.out.println("paso 3 - " + actor + " valida elemento de Email y Password");
    }

    @Entonces("{actor} debería ver un mensaje de error de inicio de sesión")
    public void validarMensajeDeError(Actor actor) {
        actor.attemptsTo(
                the(ALERT_NOMATCHEMAILORPASSWORD, isVisible()).forNoMoreThan(5).seconds()
        );
        System.out.println("paso 4 - " + actor + " valida mensaje de error");
    }

    @Cuando("{actor} ingresa su password y hace clic en el botón Login")
    public void ingresaPasswordyclickenlogin(Actor actor) {
        actor.attemptsTo(
                the(EMAIL_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                the(PASSWORD_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("Francogamer1822").into(PASSWORD_FIELD),
                the(LOGIN_BTN, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LOGIN_BTN)
        );
        System.out.println("paso 3 - " + actor + " valida elemento de Email y Password");
    }

    @Cuando("{actor} ingresa su email y password incorrectos y hace clic en el botón Login")
    public void ingresaEmailYPasswordclickenlogin(Actor actor) {
        actor.attemptsTo(
                the(EMAIL_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("francoosuna12@gmail.com").into(EMAIL_FIELD),
                the(PASSWORD_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue("Francogamer12").into(PASSWORD_FIELD),
                the(LOGIN_BTN, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LOGIN_BTN)
        );
        System.out.println("paso 3 - " + actor + " valida elemento de Email y Password");
    }

    @Cuando("{actor} se loguea en la pagina de la tienda")
    public void loginAshop(Actor actor) {

        System.out.println("paso 3");
    }

    @Entonces("{string} valida su nombre en pantalla")
    public void validacionDeLogin(String nombre) {
        System.out.println("paso 4");
    }

    @Cuando("{actor} intenta iniciar sesión con email {string} y password {string}")
    public void intentaIniciarSesionConEmailYPassword(Actor actor, String email, String password) {
        Map<String, String> datos = new HashMap<>();
        datos.put("email", email);
        datos.put("password", password);
        actor.attemptsTo(LoginTask.conDatos(datos));
    }

}