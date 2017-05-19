Realizado por: Manuel Efraín Japón Gualán

El siguiente codigo brinda una solucion para el siguiente problema: Administración de Temas de Conferencia 

Estás planeando una gran conferencia de programación y has recibido muchas propuestas que han pasado el proceso inicial de revisión. Ahora estás teniendo dificultades para que quepan en los espacios de tiempo previstos para el día del evento. ¡Hay muchas posibilidades! Entonces, has decidido escribir un programa que te ayude.
 

La conferencia está dividida en varias temáticas. Cada temática tiene una sesión en la mañana y otra en la tarde.
Cada sesión contiene múltiples charlas.
Las sesiones de la mañana empiezan a las 9 AM y deben terminar a las 12 del medio día, para el almuerzo.
Las sesiones de la tarde empiezan a la 1 PM y deben terminar a tiempo para el evento social.
El evento social no puede empezar antes de las 4:00 ni después de las 5:00.
Ninguno de los títulos de las charlas contienen números.
La duración de todas las charlas está dada en minutos (no horas). También puede tratarse de una charla corta de 5 minutos (lightning).
Los presentadores serán muy puntuales así que no hay necesidad de programar descansos entre las sesiones.
 

Ten en cuenta que dependiendo de cómo resuelves el problema tu solución puede producir diferentes combinaciones u ordenaciones de las charlas en las temáticas, esto es aceptable. No tienes que duplicar exactamente el resultado de ejemplo proporcionado a continuación.
 

Entrada de Ejemplo:
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min
Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min
 

Salida de ejemplo:
Temática 1:
09:00AM Writing Fast Tests Against Enterprise Rails 60min
10:00AM Overdoing it in Python 45min
10:45AM Lua for the Masses 30min
11:15AM Ruby Errors from Mismatched Gem Versions 45min
12:00PM Lunch
01:00PM Ruby on Rails: Why We Should Move On 60min
02:00PM Common Ruby Errors 45min
02:45PM Pair Programming vs Noise 45min
03:30PM Programming in the Boondocks of Seattle 30min
04:00PM Ruby vs. Clojure for Back-End Development 30min
04:30PM User Interface CSS in Rails Apps 30min
05:00PM Networking Event
 

Temática 2:
09:00AM Communicating Over Distance 60min
10:00AM Rails Magic 60min
11:00AM Woah 30min
11:30AM Sit Down and Write 30min
12:00PM Lunch
01:00PM Accounting-Driven Development 45min
01:45PM Clojure Ate Scala (on my project) 45min
02:30PM A World Without HackerNews 30min
03:00PM Ruby on Rails Legacy App Maintenance 60min
04:00PM Rails for Python Developers lightning
05:00PM Networking Event


INSTRUCCIONES PARA COMPILAR EL CODIGO:
========================================

1. Descomprimir la carpeta twtest
2. En consola, dirigirse al directorio twtest/src (cd twtest/src/)
3. Ejecutar el comando: javac test/main/Main.java 



INSTRUCCIONES PARA EJECUTAR EL CODIGO:
========================================
   Ubicado en el directorio twtest/src, y una vez compilado ejecutar el comando:
1. java test/main/Main ruta_del_archivo
	
	donde ruta_del_archivo es la ruta absoluta del archivo que contiene el listado de charlas.


EXPLICACIÓN DE LA SOLUCIÓN PROPUESTA:
=====================================

Dado un listado de charlas, lo que mi solución propone
es encontrar el máximo número de charlas que se pueden dictar
en los tiempos establecidos.

Para ello, lo que se hizo, primero fue crear las clases necesarias
que me permitan representar: una Charla, una Sesion y una Tematica.
Luego, una vez definida estas clases se procede a crear un listado de Charlas,
estas se las ordenar de menor ha mayor en función del tiempo de duración del mismo.

Luego, una vez ordenados los mismos, se procede ha buscar los grupos
tales que la suma de sus tiempos nos den 180 minutos (PARA EL CASO DE LA MAÑANA)
o que la suma este entre 180 y 240 minutos (PARA EL CASO DE LA TARDE).

El modo en el que se buscan los grupos, es iterando de uno en uno por cada charla,
y por cada charla se itera de nuevo por el resto de items que le siguen, estos se suman;
y si la suma resultante genera 180 o esta entre 180 y 240, entonces se considera como un grupo
válido para ser analizado posteriormente.

Luego una vez identificados los grupos, se selecciona de entre todos ellos, el grupo con 
el máximo numero de elementos, con estos grupos se crean las "SESIONES" de la mañana
y la tarde y con estos a su vez se crean tematicas.