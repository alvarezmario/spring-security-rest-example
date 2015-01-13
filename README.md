# spring-security-rest-example

Ejemplo que muestra como asegurar un API REST en Spring 4 usando Spring Session y Spring Boot. De esta forma la autenticacion funciona con tokens que se envian en un header. Este ejemplo esta basado en el ejemplo de la documentacion de Spring Session sobre REST.

Para probar el servicio, primero descargarse el proyecto y despues ejecutar: `mvn spring-boot:run` 
A continuacion ejecutar en una consola `curl -i -X GET http://localhost:8080/ -u user:password` (En la consola de Windows no funciona el comando curl, para probar el API REST, se puede instalar una extension en Firefox o Chrome) En los headers que devuelve el servidor hay uno que se llama `x-auth-token` y contiene el token que hay que enviar a continuacion siempre para que el servidor nos reconozca autenticado. 
Una consulta de ejemplo seria: `curl -i -X GET http://localhost:8080/ -H "x-auth-token:  a593111a-89fe-4d48-bfef-01ee10d8727d"` cambiando este token por el que recibes cuando te autenticas con el comando anterior. 


