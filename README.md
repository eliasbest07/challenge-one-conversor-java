# challenge-one-conversor-java

![infconve](https://user-images.githubusercontent.com/26911843/226076068-df004b19-22f3-4b63-861f-679abd75ddad.jpg)

Este es el resultado después de asumir y resolver el desafío propuesto por Alura gracias al programa de Oracle One, un conversor de monedas y temperaturas. Funciona para obtener la equivalencia de la moneda de algunos países de Latinoamérica a monedas extrajeras como el Dólar, el Euro, el Yen Japones, el Won Sur Coreano y la Libra Esterlina de Reino Unido, ingresas la cantidad y automáticamente hace la equivalencia, puede hacerse de cualquier sentido desde donde ingreses el valor en el otro lado obtienes la equivalencia, configuras para seleccionar la moneda de cualquier país de Latinoamérica disponible en este programa, también puedes modificar y guardar la tasa de cambio respectivamente. Hace uso de la api fixer.io para obtener las tasas de cambio, también guarda las tasas en una base de datos local haciendo uso de SQLite 

# Función

Pestaña Moneda
Tiene una lista de botones, cada uno es para elegir la divisa para hacer la equivalencia, las cuales son:
- USD Dolar
- EUR Euro
- JPY Yen Japones
- GBP Libra Esterlina
- KRW Won Sur Coreano 

Tiene dos Input, en los cuales se escribe la cantidad a convertir, se escribe en cualquiera de los dos y el resultado se ve reflejado en el que no se escribió, haciendo la respectiva equivalencia 
Tiene un botón de Configuraciones, en el cual está la opción de cambiar la moneda a otro país de Latinoamérica y también modificar la respectiva tasa de cambio 

Pestaña Temperatura
Se elige entre 5 tipos diferentes de medida de temperatura
-grados Celsius
-grados Fahrenheit
-grados Rankine
-grados Reaumur
-grados Kelvin

Se escribe en alguno de los dos Input, y la equivalencia se ve reflejada en el otro Input, se elegía la medida a la cual se va a hacer la conversión 

Pestaña Acerca de

Muestra el nombre del programa, una descripción general del programa, como funciona el programa, agradecimientos y 3 botones de las redes sociales del creador del programa. En la parte inferior muestro el nombre del creador del programa 


# Api fixer.io

Utilice esta api gratuita, solo que la versión gratuita ofrece 100 consultas al mes, por esa razón vi la necesidad de implementar una base de datos para que un solo usuario no este haciendo muchas consultas a la api, gracias a la formación dictada por Alura, deduje diseñar esta lógica de negocios, ya que me tome con que los recursos no son infinitos, pero si encontré alternativas validad para superar el obstáculo de no hacer muchas peticiones a la api 

# Base de datos hotdata.db

Utilice SQLite porque es una solución fácil y rápida de implementar para tener mi base de datos relacional, en la cual guardo un objeto Data el cual guarda la moneda del país de Latinoamérica seleccionada y la información de actualización de las tasas, y en otra tabla guardo una lista de objetos FactorDeConversion los cuales tiene la información de la moneda y la tasa de cambio a otra moneda 
