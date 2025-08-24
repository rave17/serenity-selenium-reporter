# language: es
Característica: Acceso a la tienda


  Característica: Login de usuario
  @before
  Escenario: Iniciar sesión con datos desde archivo JSON
    Dado "Serjey" ingresa a la pagina del login de la tienda
    Cuando "Serjey" intenta iniciar sesión con los datos desde el archivo1 "UsuarioCorrecto.json"
    Entonces "Serjey" debería ver su cuenta iniciada correctamente

