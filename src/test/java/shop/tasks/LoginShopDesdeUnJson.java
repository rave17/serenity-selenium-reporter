package shop.tasks;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step; // o net.thucydides.core.annotations.Step

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginShopDesdeUnJson implements Task {

    private final String rutaArchivo;

    public LoginShopDesdeUnJson(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static LoginShopDesdeUnJson conDatosDesde(String rutaArchivo) {
        return instrumented(LoginShopDesdeUnJson.class, rutaArchivo);
    }

    @Step("Inicia sesión con datos desde JSON")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try (Reader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            Map<String, String> datos = new HashMap<>();
            datos.put("email", jsonObject.get("email").getAsString());
            datos.put("password", jsonObject.get("contrasenia").getAsString());

            actor.attemptsTo(LoginTask.conDatos(datos));

        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo JSON: " + rutaArchivo, e);
        }
    }
}