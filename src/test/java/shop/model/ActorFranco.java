package shop.model;

public class ActorFranco {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String contrasenia;

    public ActorFranco(String nombre, String apellido, String email, String contrasenia) {
        this.nombre = "Franco";
        this.apellido = "Osuna";
        this.email = "Francoosuasdasd@gmail.com";
        this.contrasenia = "123456789";
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
