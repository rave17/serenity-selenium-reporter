package shop.pages.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

        public static final Target EMAIL_FIELD = Target.the("Campo de email")
                .located(By.id("input-email"));

        public static final Target PASSWORD_FIELD = Target.the("Campo de contraseña")
                .located(By.id("input-password"));

        public static final Target MY_ACCOUNT_BTN = Target.the("Botón de login")
                .located(By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span"));

        public static final Target LOGIN_BTN = Target.the("Boton 'My account'")
                .located(By.cssSelector("input.btn.btn-primary"));
        public static final Target ALERT_NOMATCHEMAILORPASSWORD = Target.the("Alerta de error")
                .located(By.xpath("//div[i[contains(@class, 'fa-exclamation-circle')] and contains(., 'Warning: No match for E-Mail Address and/or Password.')]"));
        public static final Target BTN_REGISTER = Target.the("Botón de registro")
                .located(By.xpath("//a[contains(text(), 'Register')]"));
}

