# ¿Cómo crear el login? Spring Boot 3 + Spring Security 6 + JWT Authentication de Ivana Soledad [link a video](https://www.youtube.com/watch?v=nwqQYCM4YT8&t=3420s)


Aplicación realizada siguiendo el tutorial del video de youtube de Ivana Soledad. 

La aplicación tiene tres endpoint:
1. auth/login: para logearse a la aplicación es necesario el username y el password. Devuelve si se ha logeado con los credenciales correcto un token para usar.
2. auth/register: endpoint que sirve para registrar un nuevo usuario. Devuelve un token para usar.
3. api/v1/demo: endpoint protegido que solo es accesible si tiene un token valido.


Se hecha falta profundizar en el tema de ROLE. En el tutorial se define dos roles (ADMIN, USER) pero los recursos solo verifican que los token sean valido. No entrando en el tema de roles.



