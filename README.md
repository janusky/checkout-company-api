#  checkout-api

API de sistema de configuración checkout para empresas.

## Objetivos

* Permitir que diferentes empresas clientes creen y gestionen sus propias sesiones de checkout.
* Cada empresa cliente debe tener su propio identificador único y debe ser capaz de personalizar la información asociada a sus sesiones de checkout.

## Contenido

- Sesión con x509 (SSL)
- Documentación con OpenAPI 3
- Cache en servicios
- Registro de log con ticked id para errores
- Persistencia en modelo relacional (JPA)
- Auditoría con @EnableJpaAuditing (package `audit`)

### Directorios

1. `/src/` contiene el código fuente del backend
1. `/config/` contiene las plantillas de los archivos de configuración para los distintos ambientes

### Tecnologías

- Java 17
- [Spring Boot 3](https://spring.io/blog/2022/05/24/preparing-for-spring-boot-3-0) (Security, Web, JPA, Cache)
- Authentication x509 (SSL)
- PostgreSQL (database)
- [Maven 3](https://maven.apache.org/)
- [Lombok](https://projectlombok.org)
- [OpenAPI 3](https://spec.openapis.org/oas/v3.1.0)

## Uso

//TODO

