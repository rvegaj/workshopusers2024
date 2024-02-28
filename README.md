# workshopusers-nisum
Se desarrolla api que permite crear usuarios teniendo en cuenta los siguientes criterios
- Se debe validar que no exista un usuasrio con el mismo email
- El email de cumplir con una expresion regular estandar
- La constraseña debe cumplir con una expresión regular establecida y configurable
- Al crear el usuario se debe visualizar el Id autogenerado, la fecha de creación , last_login, si está activo, un toke generado mediante UUID y almacenado en base de datos (H2)
- Se ejecutan validaciones como que el email cumpla un estandar válido con dominio y no pueden haber campos vacios, la contraseña tiene las siguientes políticas:
    Minimo 8 caracteres
    Maximo 15
    Al menos una letra mayúscula
    Al menos una letra minucula
    Al menos un dígito
    No espacios en blanco
    Al menos 1 caracter especial
  La expresión regular está parametrizada en un enumerador enlazado una utilidad (Ver diagrama)

  Las tecnologías utilizadas son:
  - Java 11, Spring Boot, OpenID (Swagger 3.0), Base de datos H2, JPA, Maven 3.8, Lombok, Mockito

  Se debe descargar el código y descargar las dependiencias y ejecutar.

  La url del servicio es:

http://localhost:8080/api/v1/user/ - POST. El request utilizado es el enviado en el documento del ejercicio.
La URL de la consola H2 es:
http://localhost:8080/h2-console/ con los paramteros de conexión de archivo application.yml del servicio
- La base de datos se carga en memoria cuando el servicio inicia
La Url del swagger es:
http://localhost:8080/swagger-ui/index.html


  

Los diagramas se encuentra en la carpeta main/resource/static/diagram
  
