package util;
import net.serenitybdd.screenplay.targets.Target;
import shop.pages.registro.RegistroUsuarioPage;

import java.util.HashMap;
import java.util.Map;

public class CampoMapper {
    private static final Map<String, Target> campos = new HashMap<>();

    static {
        campos.put("First Name", RegistroUsuarioPage.FIRST_NAME_FIELD_REGISTER);
        campos.put("Last Name", RegistroUsuarioPage.LAST_NAME_FIELD_REGISTER);
        campos.put("Email", RegistroUsuarioPage.EMAIL_FIELD_REGISTER);
        campos.put("Telephone", RegistroUsuarioPage.TELEPHONE_FIELD);
        campos.put("Password", RegistroUsuarioPage.PASSWORD_FIELD_REGISTER);
        campos.put("Confirm Password", RegistroUsuarioPage.CONFIRM_PASSWORD_FIELD_REGISTER);
    }

    public static Target obtenerCampoPorTexto(String nombreCampo) {
        if (!campos.containsKey(nombreCampo)) {
            throw new IllegalArgumentException("Campo no encontrado: " + nombreCampo);
        }
        return campos.get(nombreCampo);
    }
}
