# Modelo:

## Educacion
La clase Educacion representa un objeto de educación en el portafolio del usuario.

### atributos
- id (long): identificador único generado automáticamente.
- usuario (Usuario): usuario al que pertenece esta educación.
- titulo (String): título de la educación.
- imagen (String): URL de la imagen relacionada con la educación.
- tiempoDesde (Date): fecha de inicio de la educación.
- tiempoHasta (Date): fecha de finalización de la educación.
- Actualmente (Boolean): indica si el usuario todavía está estudiando en esta educación.
- descripcion (String): descripción de la educación.

### Metodos
- setter & getter

## Proyecto

Clase que representa un proyecto en el portfolio.

### atributos

- `id` (int): identificador único del proyecto.
- `usuario` (Usuario): usuario al que pertenece el proyecto.
- `imagenProyecto` (String): ruta a la imagen del proyecto.
- `titulo` (String): título del proyecto.
- `descripcion` (String): descripción del proyecto (máximo 5000 caracteres).
- `tecnologias` (List<String>): lista de tecnologías utilizadas en el proyecto.
- `url` (String): URL del proyecto.
- `urlRepositorio` (String): URL del repositorio del proyecto.

### Metodos
- setter & getter

## Clase SkillCategory

### atributos

- `id` (long): identificador de la categoría.
- `habilidades` (List<String>): lista de habilidades que pertenecen a la categoría.
- `usuario` (Usuario): referencia al usuario propietario de la categoría.
- `nombre` (String): nombre de la categoría.

### Metodos
- setter & getter

## Class SobreMi

Esta clase representa la información sobre el usuario.

### atributos
- `id` - identificador único del objeto SobreMi (tipo: long)
- `usuario` - el usuario al que pertenece esta información (tipo: Usuario)
- `imagenPerfil` - ruta de la imagen del perfil del usuario (tipo: String)
- `bannerImagen` - ruta de la imagen del banner del usuario (tipo: String)
- `descripcion` - descripción sobre el usuario (tipo: String, longitud máxima: 1000 caracteres)

### Metodos
- getter & setter


# Clase: Usuario

La clase Usuario representa un usuario en el sistema. Contiene información personal del usuario como nombre, correo electrónico y contraseña, así como información relacionada con la experiencia laboral, educación, proyectos y habilidades.

### Atributos:

- `id` (tipo: long): ID único del usuario.
- `experiencias` (tipo: List<Experiencia>): Lista de experiencias laborales del usuario.
- `proyectos` (tipo: List<Proyecto>): Lista de proyectos del usuario.
- `educaciones (tipo: List<Educacion>): Lista de educaciones del usuario.
- `categoriasHabilidad` (tipo: List<SkillCategory>): Lista de categorías de habilidades del usuario.
- `redSocial` (tipo: List<RedSocial>): Lista de perfiles de redes sociales del usuario.
- `sobreMi` (tipo: SobreMi): Objeto SobreMi que contiene información de perfil del usuario.
- `email` (tipo: String): Correo electrónico del usuario.
- `nombre` (tipo: String): Nombre del usuario.
- `contraseña` (tipo: String): Contraseña del usuario.
- `estaLoggeado` (tipo: Boolean): Indica si el usuario está actualmente conectado al sistema.

### Metodos
- getter & setter


## Controladores y Endpoints

### AuthUser

Este controlador maneja la autenticación de usuarios. Contiene 1 endpoint:

- `/login` (POST): toma un objeto JSON con correo electrónico y contraseña del usuario y devuelve un JWT si la autenticación es exitosa.

### Controller

Este controlador define varias rutas acerca del usuario:

- `/getUser/{id}` (GET): devuelve un objeto Usuario correspondiente al id proporcionado.
- `/addUser` (POST): guarda un objeto Usuario en la base de datos.
- `/aboutMe` (POST): guarda un objeto SobreMi en la base de datos. El comentario indica que este método debe ser eliminado.
- `/aboutMe` (GET): devuelve el objeto SobreMi guardado en la base de datos.
- `/updateAboutMe` (PUT): actualiza el objeto SobreMi en la base de datos. La solicitud debe contener un encabezado Authorization con un token JWT válido para autenticar al usuario.

### Educacion

Este controlador maneja solicitudes HTTP relacionadas con la educación del usuario. Contiene los siguientes endpoints:

- `POST /addEducation`: recibe una solicitud POST con un objeto JSON en el cuerpo de la solicitud que representa una nueva educación que se agregará al perfil del usuario. Verifica la validez de un token JWT en el encabezado de autorización de la solicitud.
- `GET /getEducation/{id}`: recibe una solicitud GET con una identificación de educación en la URL. Llama al servicio getEducation para recuperar la educación correspondiente a la identificación.
- `GET /getAllEducation`: recibe una solicitud GET sin ningún parámetro. Llama al servicio getAllEducations para recuperar todas las educaciones del usuario y las devuelve en el cuerpo de la respuesta como una lista de objetos JSON.
- `DELETE /deleteEducation/{id}`: recibe una solicitud DELETE con una identificación de educación en la URL. Verifica la validez de un token JWT en el encabezado de autorización de la solicitud.
- `PUT /updateEducation/{id}`: recibe una solicitud PUT con una identificación de educación en la URL y un objeto JSON en el cuerpo de la solicitud que representa una educación actualizada. Verifica la validez de un token JWT en el encabezado de autorización de la solicitud.

### Proyecto

Este controlador maneja solicitudes HTTP relacionadas con los proyectos del usuario. Contiene los siguientes puntos finales:

- `POST /addProyect`: Agrega un proyecto al portfolio. Requiere un body con el objeto Proyecto y el header Authorization con un token JWT válido.
- `GET /getProyect/{id}`: Obtiene un proyecto del portfolio por su id.
- `GET /getAllProyects`: Obtiene todos los proyectos del portfolio.
- `DELETE /deleteProyect/{id}`: Elimina un proyecto del portfolio por su id. Requiere el header Authorization con un token JWT válido.
- `PUT /updateProyect/{id}`: Actualiza un proyecto del portfolio por su id. Requiere un body con el objeto Proyecto y el header Authorization con un token JWT válido.

### Habilidades

Este controlador administra las categorías de habilidades. Los endpoints disponibles son:

- `GET /getSkillCategory/{id}`: Obtiene una categoría de habilidad por su ID.
- `GET /getAllSkillCategories`: Obtiene todas las categorías de habilidades.
- `POST /addSkillCategory`: Agrega una nueva categoría de habilidad. La solicitud incluye un cuerpo de solicitud JSON con los detalles de la categoria.
- `DELETE /deleteSkillCategory/{id}`: Elimina una categoría de habilidad por su ID. También se espera que la solicitud incluya un encabezado de autorización JWT válido.
- `PUT /updateSkillCategory/{id}`: Actualiza una categoría de habilidad existente por su ID. Se espera que la solicitud incluya un cuerpo de solicitud JSON con los detalles actualizados de la categoría de habilidad. También se espera que la solicitud incluya un encabezado de autorización JWT válido.
