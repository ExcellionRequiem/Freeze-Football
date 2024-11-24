
Repositorio para la práctica en grupo de Juegos en Red (URJC 2024/2025). Un juego en red competitivo y caótico de dos jugadores estilo arcade en el que dos jugadores con muñecos cabezones intentan meterse goles el uno al otro pateando el balón y dándole cabezazos, con powerups para evitar la repetitividad del juego y referencias al mundo del fútbol.
 ***************

1	EQUIPO E INTEGRANTES

	Monica Varas García

	 	Correo oficial: m.varas.2019@alumnos.urjc.es
	
		Cuenta GitHub: https://github.com/M0nica13
![image](https://github.com/user-attachments/assets/11624791-81f1-4729-9219-6a7e013ab312)

		


 
	Sergio Delgado López
 
 		Correo oficial: s.delgado.2021@alumnos.urjc.es

		Cuenta GitHub:https://github.com/seergiio03
![image](https://github.com/user-attachments/assets/8178ad5d-392d-4edb-a923-01568fd1309e)

		



	Alberto Caro Candón

 		Correo oficial: a.caro.2020@alumnos.urjc.es
	
		Cuenta GitHub: https://github.com/AlbertoCaro24
  
![image](https://github.com/user-attachments/assets/c2dc52e0-13db-4ee1-975d-c591670d33b9)

		



	Arturo Carretero Aguado
 
 		Correo oficial: a.carretero.2022@alumnos.urjc
	
		Cuenta GitHub: https://github.com/ExcellionRequiem
![image](https://github.com/user-attachments/assets/d3b8819c-1806-4588-937f-0e89ad9d3cd7)

		


*****************

2	HISTORIAL DE REVISIONES


Arte:

Se han añadido nuevas interfaces tales cómo la pantalla de selección de personaje con el que jugar, así mismo ya no son prototipos si no que son las interfaces definitivas, así mismo se han realizado todos los botones que estas requerían.

Respecto al estilo visual se ha definido el definitivo, siendo este 2D básico cartoon, se han realizado los escenarios y los sprites de los personajes.


Implementación: 
 
Durante la fase 2 se ha implementado el juego en código, incluyendo colisionadores a todos los objetos durante el propio juego, el uso de colisionadores escondidos para mantener las alturas de los objetos, los menús básicos, y la selección de personaje entre 2 escenas mediante un índice numérico. Se quiso hacer también una barra deslizante para controlar el volumen del juego, pero no se pudo averiguar un método correcto para su implementación y por tanto se dejó para futuras fases.

******************

3	INTRODUCCIÓN

Este es el documento de diseño de Freeze Football. Este escrito tiene como objetivo principal plasmar los elementos que debe incluir el videojuego propuesto.

3.1	CONCEPTO DEL JUEGO

	Freeze Football es un videojuego de estilo arcade de fútbol para dos jugadores en una pantalla 2D. Involucra jugadores con cabezas grandes y cuerpos pequeños que juegan en duelos uno contra uno. El objetivo 	principal es marcar goles al adversario utilizando patadas y cabezazos, mientras se evita que el contrario también lo haga.


	3.2	CARACTERÍSTICAS PRINCIPALES

	El juego se basa en los siguientes pilares:

		•	Jugabilidad arcade: El juego es sencillo de aprender y difícil de dominar. Los controles son fáciles de entender, ya que el jugador puede mover al personaje presionando las teclas de 			izquierda a derecha y saltando, con un cuarto botón para disparar.

		•	Estilo de juego 1vs1: Se juega en partidos de uno contra uno, donde los jugadores controlan a un personaje con una cabeza grande y un cuerpo pequeño, y deben marcar goles en la portería 		contraria.

		•	Diversidad de personajes: Los jugadores pueden elegir entre una amplia variedad de personajes, que generalmente representan diferentes equipos, esto es puramente estético.

		•	Sencillez y Adicción: Aunque el concepto es sencillo, la mecánica rápida y la competencia entre jugadores hacen que el juego sea muy adictivo y divertido, ideal para partidas rápidas y 		competiciones casuales.

3.3	GÉNERO

	Freeze Football se clasifica dentro del género de juegos deportivos, específicamente en la subcategoría de fútbol arcade, con una jugabilidad sencilla, acción rápida y un enfoque en la diversión y la 	competitividad en lugar de la simulación realista.



3.4	PROPÓSITO Y PÚBLICO OBJETIVO

El propósito principal de Freeze Football es ofrecer a través de una jugabilidad simple y directa, entretenimiento en sesiones cortas, perfectas para jugadores que desean acción rápida y desafíos inmediatos. 

Al mismo tiempo, el juego introduce un toque de humor y exageración con sus personajes de cabezas grandes, lo que lo hace atractivo tanto para jugadores casuales como para aquellos que disfrutan de un enfoque más creativo del fútbol.

Freeze Football está dirigido a jugadores de todas las edades, por ello se apuesta por un sistema de partidas cortas, intensas y rápidas.

3.5	JUGABILIDAD

Cada partido de Freeze Football ofrece una variedad de mecánicas y estrategias para ganar el partido. Para ello nos valdremos de los siguientes elementos:

•	Movimiento: Los jugadores se mueven horizontalmente por el campo usando flechas o teclas. El personaje puede moverse rápidamente hacia la izquierda o derecha, y saltar para alcanzar balones aéreos o evitar ataques. Con el espacio o la p, el personaje pega una patada.

•	Mejoras: Los jugadores podrán recibir “power-ups” temporalmente durante los partidos (será agregado próximamente).
	Portería más grande o pequeña
	Más salto

3.6	ALCANCE

El objetivo principal es desarrollar un sistema de juego sólido al que podamos introducir más y mejor contenido. En primera instancia se desarrollará contenidos básicos que serán ampliados en un futuro.



4.	MECÁNICAS DE JUEGO

4.1	JUGABILIDAD

•	Controles locales: A la hora de jugar dos jugadores en la misma pantalla, cada jugador tendrá distintas teclas de movimiento y disparo designadas:

	En el caso del jugador 1, las teclas de movimiento serán “W”, “A”,”D”, y la de disparo el “Espacio”.

	En el caso del jugador 2, las teclas de movimiento serán “➡️”, “⬅️” , “⬆️” ,y  la de disparo la “P”.


•	Controles multijugador: En cuanto a las partidas en línea, se pretende que ambos jugadores jueguen desde su respectivo dispositivo con los controles locales del jugador 1.






