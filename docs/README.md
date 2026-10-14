# Apartamentos

En este proyecto hice una API para administrar un servicio de renta de apartamentos. Se pueden registrar clientes, propiedades, unidades, reservaciones, pagos y disponibilidad. También dejé unas vistas sencillas con Thymeleaf para poder revisar los datos desde el navegador.

## Cómo lo puse a funcionar

Primero se necesita tener MySQL iniciado. El proyecto usa el usuario indicado en `DB_USER` y la contraseña de `DB_PASSWORD`; esos datos no se guardan en GitHub.

En Windows se puede usar el script incluido, que pregunta la contraseña:

```text
.\run-local.ps1
```

La aplicación abre en `http://localhost:8000`.

## Orden que usé para probarlo

1. Registrar un cliente.
2. Dar de alta una propiedad.
3. Agregar una unidad a esa propiedad.
4. Registrar la disponibilidad.
5. Crear una reservación.
6. Guardar el pago.
7. Agregar la reseña o la notificación.

Los id se van tomando de las respuestas que devuelve cada `POST`.

## Consultas de propiedades

Además de consultar todas las propiedades o una por su id, agregué estas dos búsquedas:

```text
GET /api/propiedades/tipo/{tipo}
GET /api/propiedades/propietario/{idPropietario}
```

La primera busca por el tipo de propiedad y la segunda muestra las propiedades que pertenecen a un cliente propietario.

## Ejemplo con curl

Ejemplo para crear un cliente:

```bash
curl -X POST http://localhost:8000/api/clientes \\
  -H 'Content-Type: application/json' \\
  -d '{"tipo":"PROPIETARIO","nombres":"Ana","apellidos":"López","email":"ana@example.com","password":"Temporal123"}'
```

## Datos que se llenan solos

- Los id de los registros.
- Las fechas de registro, creación, envío o reseña.
- El `importeTotal` de la reservación, cuando no se manda en la petición.
- La referencia del pago y el cliente relacionado con la reservación.
- La fecha del pago cuando se confirma.
