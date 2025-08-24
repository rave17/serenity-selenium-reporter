package shop.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementosEnPantalla{
    public static Question<Boolean> enPantalla(Target elemento) {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                return elemento.resolveFor(actor).isVisible();
            }
        };
    }
}
