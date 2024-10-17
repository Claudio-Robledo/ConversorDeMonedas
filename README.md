
# Conversor de Monedas en Java -  Challenge Back End ONE

Este proyecto es un conversor de monedas que utiliza una API externa para obtener tasas de cambio actualizadas. El programa permite convertir entre diferentes monedas utilizando tasas de cambio en tiempo real, brindando una interfaz simple en la terminal para que el usuario seleccione la conversión deseada.

## Funcionalidades

- **Conversión entre diversas monedas**:
  - Dólar estadounidense (USD) ⇔ Peso argentino (ARS)
  - Dólar estadounidense (USD) ⇔ Real brasileño (BRL)
  - Dólar estadounidense (USD) ⇔ Peso colombiano (COP)
  - Dólar estadounidense (USD) ⇔ Euro (EUR)
  - Dólar estadounidense (USD) ⇔ Yen japonés (JPY)
  - Y más por añadir en el futuro.
  
- **Historial de Conversiones**: El programa rastrea y muestra el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.
  
- **Registros con Marca de Tiempo**: Cada conversión realizada incluye una marca de tiempo que indica cuándo se realizó, para un seguimiento detallado.

- **Manejo de errores** para casos de monedas no soportadas.

## Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación principal.
- **HttpClient**: Para realizar solicitudes HTTP y obtener datos de la API.
- **Gson**: Biblioteca para deserializar los datos JSON de la API a objetos Java.
- **ExchangeRate-API**: API externa para obtener tasas de cambio de monedas en tiempo real.
- **java.time.LocalDateTime**: Para capturar y mostrar la marca de tiempo de las conversiones.

## Configuración del Entorno

### Requisitos previos

1. Tener instalado [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Instalar [Maven](https://maven.apache.org/) (opcional, pero recomendado).
3. Tener acceso a la API de [ExchangeRate-API](https://www.exchangerate-api.com/), y generar una clave API.

### Dependencias

El proyecto utiliza la biblioteca Gson para el manejo de JSON. Si utilizas Maven, puedes añadir la dependencia en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
```

Si no utilizas Maven, puedes descargar el archivo JAR de Gson desde [aquí](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6) y añadirlo manualmente al proyecto.

## Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

### `Principal.java`

Contiene el menú principal donde el usuario puede elegir la conversión que desea realizar entre las opciones disponibles. Después de seleccionar una opción, se solicita el monto a convertir, y se realiza la conversión utilizando la API de ExchangeRate. Además, ahora permite ver el historial de conversiones y registrar las marcas de tiempo de las conversiones realizadas.

### `ConsultaMoneda.java`

Esta clase se encarga de realizar la consulta a la API de tasas de cambio. Utiliza `HttpClient` para realizar una solicitud GET y obtiene el resultado en formato JSON, que luego es transformado en un objeto `Moneda` utilizando la biblioteca Gson.

### `Moneda.java`

Es un record que modela la respuesta de la API de conversión de monedas. Contiene los datos resultantes de la conversión, como el valor original, la tasa de conversión y el valor final convertido. Además, se sobrescribe el método `toString` para mostrar los resultados de forma legible para el usuario.

## Uso del Conversor de Monedas

1. Al ejecutar el programa, el usuario verá un menú con opciones de conversión de monedas.
2. Elige una opción (1-10) para realizar la conversión deseada.
3. Introduce el valor que quieres convertir.
4. El programa consultará la API para obtener la tasa de conversión y mostrará el valor convertido.
5. El historial de conversiones se puede visualizar seleccionando la opción 11 del menú.

### Ejemplo de uso:

```
**************************************************************
Sea bienvenido/a el Conversor de Moneda =]

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Dólar =>> Euro
8) Euro =>> Dólar
9) Dólar =>> Yen japonés
10) Yen japonés =>> Dólar
11) Ver historial de conversiones
12) Salir
Elija una opción válida:

**************************************************************

Ingrese el valor que desea convertir:
100
El valor 100 [USD] corresponde al valor final =>>> 28700.0 [ARS] 
Fecha y hora: 2024-10-16T14:55:12.123
```

## Autores

- [Claudio Robledo]
