package shop.model;

public class ActorUsuario {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String contrasenia;
    private final String confirmarContrasenia;
    private final String telefono;

    public ActorUsuario(String nombre, String apellido, String email, String contrasenia, String confirmarContrasenia, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.confirmarContrasenia = confirmarContrasenia;
        this.telefono = telefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public String getConfirmarContrasenia() {
        return this.confirmarContrasenia;
    }

    public String getTelefono() {
        return this.telefono;
    }
}
