# Conversor de Moneda

Este es un proyecto de Java que permite convertir valores entre diferentes monedas utilizando una API externa para obtener las tasas de cambio actuales.

## Descripción

El proyecto se compone de tres clases principales:
- **Principal**: Maneja la interacción con el usuario y la entrada de datos.
- **Conversor**: Realiza la solicitud a la API y la conversión de moneda.
- **Moneda**: Representa las características de una moneda, como nombre y código ISO.

## Características

- Conversión en tiempo real de Dólares, Euros, Pesos Colombianos, Soles Peruanos, Pesos Mexicanos y Reales Brasileños.
- Interfaz de línea de comandos simple para introducir la cantidad y las monedas de origen y destino.
- Manejo de errores y validación de entradas de usuario.

## Instalación

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/JAVISU007/conversor_de_moneda.git

2. Navega a la carpeta del proyecto:

cd conversor_de_moneda

3. Importa el proyecto en tu IDE de preferencia (IntelliJ IDEA, Eclipse, etc.).

Uso

1. Ejecuta la clase Principaldesde tu IDE o con un comando de Java:

java -cp out/production/conversor_de_moneda com.conversor.moneda.Principal

2. Introduzca la cantidad a convertir y seleccione las monedas de origen y destino según las instrucciones.
3. Visualiza el resultado de la conversión en la consola.

Ejemplo de ejecución

Ingresa la cantidad a convertir: 100
Ingresa la moneda de origen (USD, EUR, COP, PEN, MXN, BRL): USD
Ingresa la moneda de destino (USD, EUR, COP, PEN, MXN, BRL): EUR
100 Dólares equivalen a 91.75 Euros


Dependencias

Java 11 o superior.
Librerías:
Gsonpara el análisis de JSON.
HttpClientpara realizar solicitudes HTTP.


## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar, por favor haz un "fork" del repositorio, realiza tus cambios en una rama y envía un "pull request". Para más detalles, consulta la [guía de contribución](https://docs.github.com/es/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests).

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
