# language: es
  Característica: Validar el login incorrecto en la tienda
    Como un usuario no registrado
    Quiero validar el login incorrecto en la tienda
    Para asegurarme de que no puedo acceder a mi cuenta sin registrarme


    @loginincorrecto1
    Escenario: Ingresa al login de la tienda solo con email y le da al boton de login
      Dado "Franco" ingresa a la pagina de la tienda sin registrarse
      Entonces "Franco" valida que 'My account' se encuentre disponible
      Cuando "Franco" ingresa su email y hace clic en el botón Login
      Entonces "Franco" debería ver un mensaje de error de inicio de sesión

    @loginincorrecto
    Escenario: Ingresa al login de la tienda solo con password y le da al boton de login
      Dado "Franco" ingresa a la pagina de la tienda sin registrarse
      Entonces "Franco" valida que 'My account' se encuentre disponible
      Cuando "Franco" ingresa su password y hace clic en el botón Login
      Entonces "Franco" debería ver un mensaje de error de inicio de sesión

    @loginincorrecto
    Escenario: Ingresa al login de la tienda con email y password incorrectos y le da al boton de login
      Dado "Franco" ingresa a la pagina de la tienda sin registrarse
      Entonces "Franco" valida que 'My account' se encuentre disponible
      Cuando "Franco" ingresa su email y password incorrectos y hace clic en el botón Login
      Entonces "Franco" debería ver un mensaje de error de inicio de sesión

    @loginincorrecto
    Escenario: Ingresa al login de la tienda con email y password incorrectos y le da al boton de login
      Dado "Franco" ingresa a la pagina de la tienda sin registrarse
      Entonces "Franco" valida que 'My account' se encuentre disponible
      Cuando "Franco" ingresa su email y password incorrectos y hace clic en el botón Login
      Entonces "Franco" debería ver un mensaje de error de inicio de sesión


    @loginincorrecto2
    Escenario: Ingresa al login de la tienda con email y password incorrectos y le da al boton de login
    Dado "Franco" ingresa a la pagina de la tienda sin registrarse
    Entonces "Franco" valida que 'My account' se encuentre disponible
    Cuando "Franco" intenta iniciar sesión con email "<email>" y password "<password>"
    Entonces "Franco" debería ver un mensaje de error de inicio de sesión

    Ejemplos:
    | email    | password  |
    | franco   | franco123 |
    | franco@  |           |
    |          | franco123 |

