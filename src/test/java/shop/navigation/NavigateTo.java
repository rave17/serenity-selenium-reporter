package shop.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable ShopHomePage() {
        return Task.where("{0} abre la pagina de la tienda",
                Open.browserOn().the(ShopHomePage.class));
    }
    public static Performable RegisterHomePage() {
        return Task.where("{0} abre la pagina de registro",
                Open.browserOn().the(RegisterHomePage.class));
    }
    public static Performable ShopLoginPage() {
        return Task.where("{0} abre la pagina de login",
                Open.browserOn().the(ShopLoginPage.class));
    }
}
