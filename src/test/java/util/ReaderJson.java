package shop.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ReaderJson {

    public static Map<String, String> readUserData(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Validar campos requeridos
            validateRequiredFields(jsonObject, "nombre", "apellido", "email", "contrasenia");

            // Mapear todos los campos del JSON
            Map<String, String> userData = new HashMap<>();
            userData.put("nombre", jsonObject.get("nombre").getAsString());
            userData.put("apellido", jsonObject.get("apellido").getAsString());
            userData.put("email", jsonObject.get("email").getAsString());
            userData.put("contrasenia", jsonObject.get("contrasenia").getAsString());

            return userData;
        }
    }

    public static Map<String, String> readLoginData(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            validateRequiredFields(jsonObject, "email", "contrasenia");

            Map<String, String> loginData = new HashMap<>();
            loginData.put("email", jsonObject.get("email").getAsString());
            loginData.put("password", jsonObject.get("contrasenia").getAsString());
            loginData.put("nombre", jsonObject.get("nombre").getAsString());
            loginData.put("apellido", jsonObject.get("apellido").getAsString());
            return loginData;
        }
    }

    private static void validateRequiredFields(JsonObject jsonObject, String... fields) {
        for (String field : fields) {
            if (!jsonObject.has(field)) {
                throw new IllegalArgumentException("Campo requerido '" + field + "' no encontrado en el JSON");
            }
        }
    }
}