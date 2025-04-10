###### Librería de validaciones para un Login

Esta librería en Java tiene como objetivo facilitar la *gestión de sesiones* y la *validación de contraseñas* dentro de un sistema de login. Fue diseñada para integrarse fácilmente en proyectos que requieren un control básico pero eficiente de usuarios activos y cambios de contraseña. Proporciona una implementación sencilla y reutilizable para desarrolladores que buscan herramientas rápidas para manejar sesiones y validar credenciales.

---

### Explicación del código

#### Clase SessionManager

Encargada de administrar las sesiones activas de usuarios.

- **Map<String, SesionActiva> sesiones**: estructura que almacena las sesiones activas por usuario.
- **TIEMPO_INACTIVIDAD**: define el tiempo (en milisegundos) que puede estar inactiva una sesión antes de cerrarse automáticamente.
- **iniciarSesion(String usuario)**: inicia una nueva sesión para el usuario.
- **registrarActividad(String usuario)**: reinicia el temporizador de inactividad cuando el usuario realiza alguna acción.
- **sesionActiva(String usuario)**: retorna true si el usuario tiene una sesión activa.
- **cerrarSesion(String usuario)**: cierra la sesión activa del usuario.
- **programarCierrePorInactividad(String usuario)**: programa una tarea que revisa constantemente la actividad del usuario y cierra la sesión si excede el tiempo de inactividad.

#### Métodos adicionales de validación

- **esContraseñaDiferente(String usuario, String nuevaContraseña, ArrayList<String> lista)**: compara la nueva contraseña con la actual y verifica si son diferentes.
- **obtenerContraseña(String usuario, ArrayList<String> lista)**: obtiene la contraseña actual de un usuario dado.
- **usuarioExiste(String usuario, ArrayList<String> lista)**: verifica si el usuario está registrado en la lista.

> *Nota:* La lista usuariosYContraseñas contiene datos en formato intercalado: nombre, contraseña, nombre, contraseña...

---

### Instrucciones para importar el .jar en otro proyecto

Si ya descargaste el archivo .jar de esta librería, sigue estos pasos para usarlo en tu proyecto:

1. Abre tu proyecto en *NetBeans* o en tu IDE favorito.
2. En el panel del proyecto, haz clic derecho en *Bibliotecas* (Libraries) > selecciona *Agregar archivo JAR/Carpeta* (Add JAR/Folder).
3. Busca y selecciona el archivo .jar que descargaste.
4. Haz clic en *Aceptar* para agregarlo a tu proyecto.
5. Ahora ya puedes importar y utilizar las clases y métodos de la librería directamente desde tu código Java:


---

### Enlace al video explicativo en YouTube

[https://youtu.be/RjkmQMBGqsM](https://youtu.be/RjkmQMBGqsM) 
