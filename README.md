
Repositorio para la práctica en grupo de Juegos en Red (URJC 2024/2025). Un juego en red competitivo y caótico de dos jugadores estilo arcade en el que dos jugadores con muñecos cabezones intentan meterse goles el uno al otro pateando el balón y dándole cabezazos, con powerups para evitar la repetitividad del juego y referencias al mundo del fútbol.
 
Índice
Índice	2
Índice de figuras	3
1. Equipo e integrantes	4
2. Historial de revisiones	5
3. Introducción	6
3.1. Concepto del juego	6
3.2. Características principales	6
3.3. Género	6
3.4. Propósito y público objetivo	7
3.5. Jugabilidad	7
3.6. Alcance	7
4. Mecánicas de juego	8
4.1. Jugabilidad	8
4.2. Flujo de juego	8
4.3. Movimiento y físicas	8
5. Interfaces y pantallas	9
5.1. Logotipo	9
5.2. Iconos	9
5.3. Tipografía	10
5.4. Menú principal	10
5.5. Menú de pausa	11
5.6. In game	11
5.7. Créditos	11
6. Apartado artístico	12
6.1. Estilo gráfico	12
6.2. Escenario	12
6.3. Personajes	12
6.4. Audio	13
   
1. Equipo e integrantes

Monica Varas García 
			
Correo oficial: m.varas.2019@alumnos.urjc.es
	

Cuenta GitHub: https://github.com/M0nica13


Sergio Delgado López

Correo oficial: s.delgado.2021@alumnos.urjc.es

			
Cuenta GitHub:https://github.com/seergiio03



Alberto Caro Candón

Correo oficial: a.caro.2020@alumnos.urjc.es


Cuenta GitHub: https://github.com/AlbertoCaro24



Arturo Carretero Aguado

Correo oficial: a.carretero.2022@alumnos.urjc

		
Cuenta GitHub: https://github.com/ExcellionRequiem


2. Historial de revisiones

(Se actualizará en las posteriores fases del proyecto)
*******

3. Introducción
	Este es el documento de diseño de Freeze Football. Este escrito tiene como objetivo principal plasmar los elementos que debe incluir el videojuego propuesto.

3.1 Concepto del juego
Freeze Football es un videojuego de estilo arcade de fútbol para dos jugadores en una pantalla 2D. Involucra jugadores con cabezas grandes y cuerpos pequeños que juegan en duelos uno contra uno. El objetivo principal es marcar goles al adversario utilizando patadas y cabezazos, mientras se evita que el contrario también lo haga.

3.2 Características principales
El juego se basa en los siguientes pilares:

Jugabilidad arcade: El juego es sencillo de aprender y difícil de dominar. Los controles son fáciles de entender, ya que el jugador puede mover al personaje presionando las teclas de izquierda a derecha y saltando, con un cuarto botón para disparar.

Estilo de juego 1vs1: Se juega en partidos de uno contra uno, donde los jugadores controlan a un personaje con una cabeza grande y un cuerpo pequeño, y deben marcar goles en la portería contraria.

Diversidad de personajes: Los jugadores pueden elegir entre una amplia variedad de personajes, que generalmente representan diferentes equipos, esto es puramente estético.

Sencillez y Adicción: Aunque el concepto es sencillo, la mecánica rápida y la competencia entre jugadores hacen que el juego sea muy adictivo y divertido, ideal para partidas rápidas y competiciones casuales.



3.3 Género
Freeze Football se clasifica dentro del género de juegos deportivos, específicamente en la subcategoría de fútbol arcade, con una jugabilidad sencilla, acción rápida y un enfoque en la diversión y la competitividad en lugar de la simulación realista.

3.4 Propósito y público objetivo
El propósito principal de Freeze Football es ofrecer a través de una jugabilidad simple y directa, entretenimiento en sesiones cortas, perfectas para jugadores que desean acción rápida y desafíos inmediatos. 

Al mismo tiempo, el juego introduce un toque de humor y exageración con sus personajes de cabezas grandes, lo que lo hace atractivo tanto para jugadores casuales como para aquellos que disfrutan de un enfoque más creativo del fútbol.

Freeze Football está dirigido a jugadores de todas las edades, por ello se apuesta por un sistema de partidas cortas, intensas y rápidas

3.5 Jugabilidad
Cada partido de Freeze Football ofrece una variedad de mecánicas y estrategias para ganar el partido. Para ello nos valdremos de los siguientes elementos:

Movimiento: Los jugadores se mueven horizontalmente por el campo usando flechas o teclas. El personaje puede moverse rápidamente hacia la izquierda o derecha, y saltar para alcanzar balones aéreos o evitar ataques. Con el espacio o la p, el personaje pega una patada.

Mejoras: Los jugadores podrán recibir “power-ups” temporalmente durante los partidos (será agregado próximamente).
Portería más grande o pequeña
Más salto

3.6 Alcance
El objetivo principal es desarrollar un sistema de juego sólido al que podamos introducir más y mejor contenido. En primera instancia se desarrollará contenidos básicos que serán ampliados en un futuro.

*****************

4. Mecánicas de juego
4.1 Jugabilidad
  Controles locales: A la hora de jugar dos jugadores en la misma pantalla, cada jugador tendrá distintas teclas de movimiento y disparo designadas:

  En el caso del jugador 1, las teclas de movimiento serán “W”, “A”,”D”, y la de disparo el “Espacio”.
  En el caso del jugador 2, las teclas de movimiento serán “➡️”, “⬅️” , “⬆️” ,y  la de disparo la “P”.

  Controles multijugador: En cuanto a las partidas en línea, se pretende que ambos jugadores jueguen desde su respectivo dispositivo con los controles locales del jugador 1.
  
4.2 Flujo de juego

![image](https://github.com/user-attachments/assets/3d67c9e8-2989-4799-a6b4-fc95c8d8dd27)
Descripción de la imagen: muestra el flujo de pantallas empezando por el menú principal, con opción de jugar o ir a ajustes, una vez en la pantalla de juego puedes acceder al menú de pausa y desde este volver al juego o al menú principal.


4.3 Movimientos y físicas
Dentro de los movimientos y físicas distinguimos dos tipos:

  1. Movimientos del jugador: el personaje jugable contará con los comandos de avanzar, retroceder, saltar, y patear. 

  Su movimiento será libre a lo largo del terreno jugable, y no recibirá ningún tipo de penalización o cooldown a la hora de saltar o patear repetidas veces.

  En cuanto a las físicas, ambos personajes se detectarán entre sí, chocando al moverse en direcciones opuestas o al disputar el balón. También, los personajes podrán meterse dentro de la portería, aunque no sea la estrategia más recomendable para ganar la       partida.

  2. Movimiento del balón: el balón tendrá un movimiento libre a lo largo de toda la pantalla. 

  Al inicio del juego el balón se encontrará en un punto fijo y alto en la mitad del escenario, y caerá en el medio para que los jugadores lo disputen y comience la partida. 

  En cuanto a las físicas, el balón detectará las colisiones con el cuerpo de los jugadores, desplazándose hacia la dirección donde sea enviado con un toque. Rebotará contra el suelo, los bordes de la pantalla, y el larguero y la zona superior de la portería.

  El balón reiniciará su posición a la de inicio al hacer contacto con una de las redes de las porterías, anotándose así un gol para uno de los dos jugadores. 
  
*******
5. Interfaces y pantallas

5.1 Logotipo

   ![image](https://github.com/user-attachments/assets/0832a5ba-a1b8-4d4a-aeb2-54ed331fe4f4)
   descripción de imagen: imagen del logotipo del juego.
   El logotipo de Freeze Football representa un balón de fútbol congelado, capturando la esencia del nombre del juego.

5.2 Iconos 
Apartado para mostrar los diseños e iconos finales que irán en las pantallas.

5.3 Tipografía

![image](https://github.com/user-attachments/assets/0ecda23e-0a0c-4f56-b865-3f81aad2072e)
descripción de imagen: imagen con la tipografía escogida para el juego.
Se ha decidido elegir la tipografía Crang descargada en dafont.com ya que es coherente con el estilo pixel art establecido y a pesar de su estilo pixelado es muy legible.

5.4 Menú principal

![image](https://github.com/user-attachments/assets/9acc67c6-8771-4d80-8a42-b1a7a36c6bb6)
descripción de imagen: primer diseño del menú principal

![image](https://github.com/user-attachments/assets/65db548f-d30a-4551-93fe-543d212beefd)
descripción imagen: segundo diseño del menú principal

Bocetos realizados a modo de primer diseño, mantiene un estilo sencillo. 

5.5 Menú de pausa

Interfaz sencilla donde aparecerán los botones de reanudar partida, ajustes, y salir de la partida. Se busca simplicidad y claridad para el jugador a la hora de navegar el menú.

5.6 In game

Saldrá un texto por pantalla cuando se marque un gol, cuando se llegue a los goles que marquen la condición de victoria (5/7 aún por determinar) saldrá por pantalla el texto (“¡GOL!”, “Jugador 1 gana”, respectivamente).

5.7 Créditos 

Pantalla de créditos donde aparece el nombre de los integrantes del grupo.

*******

6. Apartado artístico
   
6.1 Estilo gráfico
Freeze Football cuenta con un diseño de niveles y personajes en simple aunque detallado y cuidado. Con una amplia paleta de colores y buena imagen visual, se busca que el jugador busque explorar y jugar los distintos niveles que se implementen así como controlar a todos los personajes que estén disponibles.

6.2 Escenario

Los escenarios están ambientados en distintos campos de fútbol famosos en todo el mundo. Se pretende con el paso del tiempo agregar más escenarios jugables, partiendo de base con entre 1 a 3 estadios. La cámara será fija posicionada de frente a la pantalla, ambos jugadores tendrán una visión completa de todo el escenario.

En Freeze Football podrás elegir el escenario donde disputar partidos contra tus amigos, contando con decorados ambientados en algunos de los grandes equipos del fútbol Mundial como pueden ser F.C Barcelona, Real Madrid, o Manchester City.

![image](https://github.com/user-attachments/assets/1aec4959-ba87-4ffe-9ff9-9d62b4c347e2)
descripción imagen: imagenes de referencia para los escenarios

6.3 Personajes

El jugador tendrá la oportunidad de elegir entre diversos personajes jugables, todos ellos inspirados en conocidos jugadores profesionales de fútbol, como pueden ser Leo Messi o Cristiano Ronaldo.
Como forma de evitar el copyright y con la intención de darle un toque de creatividad y diversión a su vez, los nombres de los jugadores han sido mezclados con la temática principal del juego: el frío. Por tanto, en Freeze Football tendrás la oportunidad de jugar contra tus amigos con personajes como Fressi , Fristiano o Friolski, entre otros. 


Por el momento, únicamente estarán disponibles 4 personajes jugables, pero en el futuro la idea es añadir más jugadores para generar más variedad de opciones.  A continuación, algunos ejemplos de modelos en los que nos basaremos para la creación de nuestros personajes:

![image](https://github.com/user-attachments/assets/dff79c41-ff31-46ed-9e6d-5c9c7c0e5c8c)
descripción imagen: imagen de referencia para jugadores

6.4 Audio

El juego cuenta de inicio con una melodía ligera y amena en bucle como música de fondo, y con un efecto de sonido del público cada vez que uno de los jugadores anota un gol. Se plantea en un futuro implementar efectos de sonido al inicio de los partidos, y una melodía distintas en la pantalla del gameplay para que se diferencie de la de los menús.









