# 📅 Sistema de Gestión de Reservas y Citas - API REST

Este proyecto es una API REST robusta desarrollada con **Spring Boot 3.4.1** para la gestión de citas y servicios. Está diseñado bajo estándares profesionales, incluyendo seguridad basada en tokens (JWT), persistencia en MySQL, contenedores Docker y pruebas automatizadas.

## 🚀 Características Principales

* **Seguridad JWT**: Autenticación y autorización mediante JSON Web Tokens.
* **Gestión de Servicios**: CRUD completo de servicios ofrecidos (Paginado).
* **Gestión de Citas**: Sistema de reserva de citas con validación de horarios para evitar duplicidad.
* **Auditoría Automática**: Registro de fechas de creación y actualización de cada entidad usando Spring Data JPA Auditing.
* **Validación de Datos**: Uso de Bean Validation (@Email, @Future, @NotBlank) para garantizar la integridad de los datos.
* **Documentación Interactiva**: Swagger UI integrada para probar los endpoints fácilmente.
* **Dockerizado**: Despliegue rápido mediante Docker y Docker Compose.
* **Tests de Integración**: Pruebas de flujo completo (Login -> Crear Servicio -> Agendar Cita).

## 🛠️ Tecnologías Utilizadas

* **Java 21**
* **Spring Boot 3.4.1**
* **Spring Security & JWT**
* **Spring Data JPA**
* **MySQL 8.0**
* **Maven**
* **Docker & Docker Compose**
* **Swagger (SpringDoc OpenAPI)**
* **JUnit 5 & Mockito**

## 📦 Instalación y Ejecución con Docker

Asegúrate de tener instalado **Docker** y **Docker Compose**.

1.  Clona el repositorio:
    ```bash
    git clone [https://github.com/tu-usuario/sistema-reservas.git](https://github.com/tu-usuario/sistema-reservas.git)
    cd sistema-reservas
    ```

2.  Levanta el entorno completo:
    ```bash
    docker-compose up --build
    ```

La API estará disponible en `http://localhost:8080`.

## 📖 Documentación de la API (Swagger)

Una vez ejecutándose la aplicación, puedes acceder a la documentación interactiva en:
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 🔐 Guía de Uso: Autenticación

Para proteger la integridad del sistema, los endpoints de creación requieren un token JWT:

1.  **Registro**: Envía un `POST` a `/api/auth/register` con un nombre de usuario y contraseña.
2.  **Login**: Envía un `POST` a `/api/auth/login` con tus credenciales.
3.  **Uso del Token**: Copia el `token` recibido y añádelo en tus peticiones en el header de autorización:
    `Authorization: Bearer <tu_token_aqui>`

## 🧪 Ejecución de Pruebas

Para validar que todo el sistema funciona correctamente:

```bash
./mvnw test
```

Los tests utilizan una base de datos H2 en memoria para asegurar que el entorno de desarrollo permanezca limpio.

📂 Estructura del Proyecto
```
config/: Configuraciones de Seguridad, JWT y Auditoría.

controller/: Endpoints de la API.

service/: Lógica de negocio y validaciones.

model/: Entidades de base de datos.

repository/: Interfaces de acceso a datos.

exception/: Manejo global de errores.
```

Proyecto desarrollado para portafolio profesional.

### Consejos adicionales para tu portafolio:
1.  **Capturas de pantalla**: Si puedes, añade una captura de pantalla de la interfaz de Swagger UI en la sección de documentación.
2.  **Badges**: Puedes añadir "badges" de GitHub al principio para mostrar que el "Build" está pasando.
3.  **Personalización**: Cambia la URL del repositorio por la tuya real.

¡Con este README y el código que tienes, tu proyecto se ve de nivel **Senior/Mid-L