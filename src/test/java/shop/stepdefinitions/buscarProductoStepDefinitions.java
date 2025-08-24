package shop.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;


public class buscarProductoStepDefinitions {

    @Cuando("{actor} busca un producto en la tienda: {string}")
    public void buscarProducto(Actor actor, String producto) {

    }

    @Entonces("{actor} valida la informacion del producto: {string}")
    public void validarInfoDeProducto(Actor actor, String info) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(info)
        );
    }
}
