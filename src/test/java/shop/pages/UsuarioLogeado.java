package shop.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class UsuarioLogeado {
    public static final Target EDIT_ACCOUNT_BTN = Target.the("Botón de editar cuenta")
            .located(By.xpath("//div/a[contains(., 'Edit your account information') and ./i]"));
    public static final Target CHANGE_PASSWORD_BTN = Target.the("Botón de cambiar contraseña")
            .located(By.xpath("//div/a[contains(., 'Change your password') and ./i]"));
    public static final Target MODIFY_ADDRESS_BTN = Target.the("Botón de modificar dirección")
            .located(By.xpath("//div/a[contains(., 'Modify your address book entries') and ./i]"));
    public static final Target MODIFY_WISH_LIST_BTN = Target.the("Botón de modificar lista de deseos")
            .located(By.xpath("//div/a[contains(., 'Modify your wish list') and ./i]"));
    public static final Target Subscribe_BTN = Target.the("Botón de suscripción")
            .located(By.xpath("//div/a[contains(., 'Subscribe / unsubscribe to newsletter') and ./i]"));

}
