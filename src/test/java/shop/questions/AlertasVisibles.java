package shop.questions;

import net.serenitybdd.screenplay.Question;
import shop.pages.registro.RegistroUsuarioPage;

import java.util.ArrayList;
import java.util.List;

public class AlertasVisibles {
    public static Question<List<String>> AlertasEnPantalla() {
        return actor -> {
            List<String> alertas = new ArrayList<>();

            if (RegistroUsuarioPage.ALERT_FIRSTNAME_REQUIRED.resolveFor(actor).isVisible()) {
                alertas.add("First Name must be between 1 and 32 characters!");
            } else {
                alertas.add("No se encontró la alerta de First Name.");
            }

            if (RegistroUsuarioPage.ALERT_LASTNAME_REQUIRED.resolveFor(actor).isVisible()) {
                alertas.add("Last Name must be between 1 and 32 characters!");
            } else {
                alertas.add("No se encontró la alerta de Last Name.");
            }

            if (RegistroUsuarioPage.ALERT_EMAIL_REQUIRED.resolveFor(actor).isVisible()) {
                alertas.add("E-Mail Address does not appear to be valid");
            } else {
                alertas.add("No se encontró la alerta de Email.");
            }

            if (RegistroUsuarioPage.ALERT_PASSWORD_REQUIRED.resolveFor(actor).isVisible()) {
                alertas.add("Password must be between 4 and 20 characters!");
            } else {
                alertas.add("No se encontró la alerta de Password.");
            }

            if (RegistroUsuarioPage.ALERT_CONFIRM_PASSWORD_REQUIRED.resolveFor(actor).isVisible()) {
                alertas.add("Confirm Password must be between 4 and 20 characters!");
            } else {
                alertas.add("No se encontró la alerta de Confirm Password.");
            }

            if (RegistroUsuarioPage.ALERT_TELEPHONE_REQUIRED.resolveFor(actor).isVisible()) {
                alertas.add("Telephone must be between 3 and 32 characters!");
            } else {
                alertas.add("No se encontró la alerta de Telephone.");
            }

            return alertas;
        };
    }
}
