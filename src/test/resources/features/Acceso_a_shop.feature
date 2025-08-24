# language: es

Característica: Acceder al Shop

@login @shop
 Escenario: Acceso correcto a shop
  Dado "Serjey" ingresa a la pagina de la tienda sin registrarse
  Entonces "Serjey" valida que 'My account' se encuentre disponible
