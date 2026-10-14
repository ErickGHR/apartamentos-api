# Apartamentos

Este proyecto permite administrar un servicio de renta de apartamentos. Incluye clientes, propiedades, unidades disponibles, reservaciones, pagos, reseñas y notificaciones. Además de la API REST, tiene páginas sencillas hechas con Thymeleaf para revisar la información desde el navegador.

## Requisitos

- Java 21.
- MySQL 8 o una versión compatible.
- Git, solamente si se va a clonar el repositorio.

Maven no se instala por separado porque el proyecto incluye Maven Wrapper.

## Descargar y ejecutar en Windows

```powershell
git clone https://github.com/ErickGHR/apartamentos-api.git
cd apartamentos-api
.\run-local.ps1
```

El script solicita la contraseña local de MySQL y no la guarda en el repositorio. La base `apartamentos` se crea automáticamente si el usuario tiene permiso.

También se puede iniciar manualmente:

```powershell
$env:DB_USER="root"
$env:DB_PASSWORD="TU_CONTRASEÑA"
.\mvnw.cmd spring-boot:run
```

La aplicación abre en `http://localhost:8000`. La API utiliza rutas bajo `/api` y la vista web se abre directamente en `http://localhost:8000`.

## Funciones principales

- Registro y consulta de clientes.
- Administración de propiedades y unidades rentables.
- Control de disponibilidad y reservaciones.
- Registro, confirmación y reembolso de pagos.
- Reseñas, imágenes y notificaciones.
- Búsquedas de propiedades por tipo y por propietario.

```text
GET /api/propiedades/tipo/{tipo}
GET /api/propiedades/propietario/{idPropietario}
```

En `postman/Apartamentos.postman_collection.json` está la colección con el orden necesario para registrar los datos y obtener capturas.

## Pruebas automáticas

```powershell
.\mvnw.cmd test
```

Para detener la aplicación se usa `Ctrl + C`.
