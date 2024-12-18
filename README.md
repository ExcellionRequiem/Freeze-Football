
Repositorio para la práctica en grupo de Juegos en Red (URJC 2024/2025). Un juego en red competitivo y caótico de dos jugadores estilo arcade en el que dos jugadores con muñecos cabezones intentan meterse goles el uno al otro pateando el balón y dándole cabezazos, con powerups para evitar la repetitividad del juego y referencias al mundo del fútbol.


![image](https://github.com/user-attachments/assets/a9aab7f6-8884-4c2d-91f3-7bd722b51fc9)

****************


CONTENIDO

	1	EQUIPO E INTEGRANTES	
 
	2	HISTORIAL DE REVISIONES	
 
	3	INTRODUCCIÓN	
 
		3.1	CONCEPTO DEL JUEGO	
  
		3.2	CARACTERÍSTICAS PRINCIPALES	
  
		3.3	GÉNERO	
  
		3.4	PROPÓSITO Y PÚBLICO OBJETIVO	
  
		3.5	JUGABILIDAD	

		3.6	ALCANCE	
  
	4.	MECÁNICAS DE JUEGO	
 
		4.1	JUGABILIDAD
  
		4.2	FLUJO DE JUEGO	
  
		4.3	MOVIMIENTOS Y FÍSICAS	
  
	5.	INTERFACES Y PANTALLAS	
 
		5.1	LOGOTIPO	
  
		5.2	ICONOS	
  
		5.3	TIPOGRAFÍA	
  
		5.4	MENÚ PRINCIPAL	
  
		5.5	MENÚ PAUSA	
  
		5.6	PANTALLA IN GAME	

  		5.7	PANTALLA SELECIÓN DE PERSONAJE

    		5.8	AJUSTES
  
		5.9	CRÉDITOS	

    		5.10	PANTALLA RANKING Y LISTA DE USUARIOS

		5.11	PANTALLA INICIAR SESIÓN

  
  	6. 	APARTADO ARTÍSTICO
   
   		6.1	ESTILO GRÁFICO
     
     		6.2	ESCENARIO
       
       		6.3	PERSONAJES
	 
	 	6.4	AUDIO

 	7.	DIAGRAMA DE CLASES

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
	24/nov
	Se han añadido nuevas interfaces tales cómo la pantalla de selección de personaje con el que jugar, así mismo ya no son prototipos si no que son las interfaces definitivas, así mismo se han realizado todos 	los botones que estas requerían.

	Respecto al estilo visual se ha definido el definitivo, siendo este 2D básico cartoon, se han realizado los escenarios y los sprites de los personajes.

 	17/dic
  	Se ha cambiado el flujograma del juego.
	Se han añadido nuevas interfaces, botones e iconos necesarios para mostrar el inicio de sesión, ranking y la lista de usuarios conectados, así mismo se ha modificado la estética de la interfaz créditos para que la tipografía cuadrase con la del resto del juego.
	Implementación: 

	24/nov
	Durante la fase 2 se ha implementado el juego en código, incluyendo colisionadores a todos los objetos durante el propio juego, el uso de colisionadores escondidos para mantener las alturas de los objetos, los menús básicos, y la selección de personaje entre 2 escenas mediante un índice numérico. Se quiso hacer también una barra deslizante para controlar el volumen del juego, pero no se pudo averiguar un método correcto para su implementación y por tanto se dejó para futuras fases.

 	17/dic
  	Se ha hecho el diagrama de clases.
   	Durante la fase 3 se ha implementado el backend, se ha creado un archivo REST.md con todas las funcionalidades implmentadas con API REST; tales como, el registro de usuario, inicio y salida de sesión, la tabla de ranking y el chat. También se ha implementado una persistencia de datos para almacenar un usuario y una contraseña con el fin de poder recuperar información como los resultados de partidos jugados anteriormente.
    	
  	
******************

3	INTRODUCCIÓN

	Este es el documento de diseño de Freeze Football. Este escrito tiene como objetivo principal plasmar los elementos que debe incluir el videojuego propuesto.

3.1	CONCEPTO DEL JUEGO

	Freeze Football es un videojuego de estilo arcade de fútbol para dos jugadores en una pantalla 2D. Involucra jugadores con cabezas grandes y cuerpos pequeños que juegan en duelos uno contra uno. El objetivo 	principal es marcar goles al adversario utilizando patadas y cabezazos, mientras se evita que el contrario también lo haga.


	3.2	CARACTERÍSTICAS PRINCIPALES

	El juego se basa en los siguientes pilares:

		•	Jugabilidad arcade: El juego es sencillo de aprender y difícil de dominar. Los controles son fáciles de entender, ya que el jugador puede mover al personaje presionando las teclas de 	izquierda a derecha y saltando, con un cuarto botón para disparar.

		•	Estilo de juego 1vs1: Se juega en partidos de uno contra uno, donde los jugadores controlan a un personaje con una cabeza grande y un cuerpo pequeño, y deben marcar goles en la portería contraria.

		•	Diversidad de personajes: Los jugadores pueden elegir entre una amplia variedad de personajes, que generalmente representan diferentes equipos, esto es puramente estético.

		•	Sencillez y Adicción: Aunque el concepto es sencillo, la mecánica rápida y la competencia entre jugadores hacen que el juego sea muy adictivo y divertido, ideal para partidas rápidas y competiciones casuales.

3.3	GÉNERO

	Freeze Football se clasifica dentro del género de juegos deportivos, específicamente en la subcategoría de fútbol arcade, con una jugabilidad sencilla, acción rápida y un enfoque en la diversión y la competitividad en lugar de la simulación realista.



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

****************

4.	MECÁNICAS DE JUEGO


4.1	JUGABILIDAD

	•	Controles locales: A la hora de jugar dos jugadores en la misma pantalla, cada jugador tendrá distintas teclas de movimiento y disparo designadas:

			En el caso del jugador 1, las teclas de movimiento serán “W”, “A”,”D”, y la de disparo el “Espacio”.

			En el caso del jugador 2, las teclas de movimiento serán “➡️”, “⬅️” , “⬆️” ,y  la de disparo la “P”.


	•	Controles multijugador: En cuanto a las partidas en línea, se pretende que ambos jugadores jueguen desde su respectivo dispositivo con los controles locales del jugador 1.



4.2	FLUJO DE JUEGO

![Flujograma](https://github.com/user-attachments/assets/74274241-07d4-41d0-a629-d673bad7ffdf)

 	
  	descripción de imagen: imagen que explica el flujo de pantallas del juego.

4.3	MOVIMIENTOS Y FÍSICAS

	Dentro de los movimientos y físicas distinguimos dos tipos:


		1.	Movimientos del jugador: el personaje jugable contará con los comandos de avanzar, retroceder, saltar, y patear. 

		Su movimiento será libre a lo largo del terreno jugable, y no recibirá ningún tipo de penalización o cooldown a la hora de saltar o patear repetidas veces.

		En cuanto a las físicas, ambos personajes se detectarán entre sí, chocando al moverse en direcciones opuestas o al disputar el balón. También, los personajes podrán meterse dentro de la portería, aunque no sea la estrategia más recomendable para ganar la partida.
  

		2.	Movimiento del balón: el balón tendrá un movimiento libre a lo largo de toda la pantalla. 

		Al inicio del juego el balón se encontrará en un punto fijo y alto en la mitad del escenario, y caerá en el medio para que los jugadores lo disputen y comience la partida. 
	
		En cuanto a las físicas, el balón detectará las colisiones con el cuerpo de los jugadores, desplazándose hacia la dirección donde sea enviado con un toque. Rebotará contra el suelo, los bordes de la pantalla, y el larguero y la zona superior de la portería.

		El balón reiniciará su posición a la de inicio al hacer contacto con una de las redes de las porterías, anotándose así un gol para uno de los dos jugadores. 

  ****************

5.	INTERFACES Y PANTALLAS

5.1	LOGOTIPO


![FrezeeFootball_icon](https://github.com/user-attachments/assets/f4a9edb1-811e-449e-bfd1-f460d964884d)

   	El logotipo de Freeze Football representa un balón de fútbol congelado, capturando la esencia del nombre del juego.

 5.2	ICONOS Y BOTONES

 
	Los iconos son estilo minimalista 
 
![BotonPlay](https://github.com/user-attachments/assets/daa14a5f-cfa7-402e-873d-3942bbeff599)
![BotonCreditos](https://github.com/user-attachments/assets/04d0774c-26dc-49d3-81d4-9109a8fe7157)
![botonAjustes](https://github.com/user-attachments/assets/69e100b6-71f7-4044-917c-7843aa665485)
![botonSalir](https://github.com/user-attachments/assets/db2172a0-9437-45da-8c86-80d1ae0e83f8)
![BotonReanudar](https://github.com/user-attachments/assets/b0c4fc7c-16d4-4dbc-bf48-68ab83180d18)

 	Nuevos iconos y botones

![BotonIniciarSesion](https://github.com/user-attachments/assets/c2888e2c-ef41-421c-8441-9c0ff711f576)
![IconoRanking](https://github.com/user-attachments/assets/0d8d146a-2d77-473e-8b9f-7abf19a86904)
![IconoRankingBorrar](https://github.com/user-attachments/assets/536211ae-c603-4588-8585-71b84873a1c5)
![IconoSInConexion](https://github.com/user-attachments/assets/b291d3f0-9a78-4058-bf82-3db05670c7c3)
![botonRegistro](https://github.com/user-attachments/assets/2fc5cab1-6322-4280-be37-7f23ab8a3252)


5.3	TIPOGRAFÍA

![TextoJuego](https://github.com/user-attachments/assets/e9356e6f-f65a-4b60-ac30-033b71f61b4d)

	Se ha decidido elegir la tipografía Crang descargada en dafont.com ya que es coherente con el estilo 2D establecido y a pesar de su estilo pixelado es muy legible.

5.4	MENÚ PRINCIPAL

	Se ha desarrollado el diseño final para el menú a partir del diseño 1 del prototipo entregado en la anterior entrega.

![image](https://github.com/user-attachments/assets/5c86e7a6-eeeb-4f15-a7c3-31b025236584)
	
 	descripción imagen: primer diseño de menú principal, realizado en fase 1.


 ![image](https://github.com/user-attachments/assets/1be6b685-2bec-4f04-9fd0-7a9a39e799fd)
	
 	descripción imagen: diseño definitivo del menú principal.

5.5	MENÚ PAUSA

	Interfaz sencilla donde aparecerán los botones de reanudar partida y salir de la partida (que llevará al menú principal). Se busca simplicidad y claridad para el jugador a la hora de navegar el menú.

   ![image](https://github.com/user-attachments/assets/1c8ec41a-68e6-447f-af38-ecd518f5dfcd)

    	descripción imagen: diseño definitivo de menú de pausa para fase 2.


5.6	PANTALLA IN GAME

	Saldrá un texto por pantalla cuando se marque un gol, cuando se llegue a los goles que marquen la condición de victoria (5/7 aún por determinar) saldrá por pantalla el texto (“¡GOL!”, “Jugador 1 gana”, 	respectivamente).

![image](https://github.com/user-attachments/assets/37094ca2-23dc-46e4-8c7a-dd426caf386b)


5.7	PANTALLA SELECIÓN DE PERSONAJE

![image](https://github.com/user-attachments/assets/e66a727f-5af5-495e-a40c-b01b71518bed)

	descripción imagen: imagen de interfaz de selección de personajes.

5.8	PANTALLA DE AJUSTES

![image](https://github.com/user-attachments/assets/5e58449f-ab24-46fc-a989-8b453b5d81e8)

 	descripción imagen: interfas de ajustes.
 
5.9	CRÉDITOS

Pantalla de créditos donde aparece el nombre de los integrantes del grupo.

![menuCreditos](https://github.com/user-attachments/assets/3aec73b4-7e61-4899-99c1-704534decbe0)

 	descripción imagen: interfaz de créditos.

5.10	PANTALLA RANKING Y LISTA DE USUARIOS

![CapturaPantallaRanking](https://github.com/user-attachments/assets/1393a5ee-565b-4b1c-bff8-3d49eeed678d)

	descripción imagen: pantalla ranking.
 
5.11	PANTALLA INICIAR SESIÓN

![MenuInicioSesion](https://github.com/user-attachments/assets/6e713a26-2e10-4004-b1b9-b4c14b8103d5)

 	descripción imagen: pantalla de iniciar sesión.

****************
6.	APARTADO ARTÍSTICO
   
6.1	ESTILO ARTÍSTICO

	Freeze Football cuenta con un diseño de niveles y personajes con temática cartoon/animada simple aunque cuidada y detallada. Con una amplia paleta de colores y buena imagen visual, se busca que el jugador 	busque explorar y jugar los distintos niveles que se implementen así como controlar a todos los personajes que estén disponibles.


6.2	ESCENARIO
	
 	Los escenarios están ambientados en distintos campos de fútbol famosos en todo el mundo. Se pretende con el paso del tiempo agregar más escenarios jugables, partiendo de base con entre 1 a 3 estadios. La 	cámara será fija posicionada de frente a la pantalla, ambos jugadores tendrán una visión completa de todo el escenario.

	En Freeze Football podrás elegir el escenario donde disputar partidos contra tus amigos (lo implementaremos en la fase 3), contando con decorados ambientados en algunos de los grandes equipos del fútbol 	Mundial como pueden ser F.C Barcelona, Real Madrid, o Manchester City.

![image](https://github.com/user-attachments/assets/20e372bf-3465-49cb-99d3-c0f41b424232)

  	descripción imagen: escenario del campo Robalona.


   ![image](https://github.com/user-attachments/assets/b166f696-c83b-4eeb-af58-5389e9e6c705)

     	descripción imagen: escenario del campo MoneyLand.


![image](https://github.com/user-attachments/assets/39799ff4-12cd-4cbb-bd98-2db83fdb6e00)

	descripción imagen: escenario del campo Vardrid.

 

6.3	PERSONAJES

	El jugador tendrá la oportunidad de elegir entre diversos personajes jugables, todos ellos inspirados en conocidos jugadores profesionales de fútbol, como pueden ser Leo Messi o Cristiano Ronaldo.

	Como forma de evitar el copyright y con la intención de darle un toque de creatividad y diversión a su vez, los nombres de los jugadores han sido mezclados con la temática principal del juego: el frío. Por 	tanto, en Freeze Football tendrás la oportunidad de jugar contra tus amigos con personajes como Fressi , Fristiano o Friolski, entre otros. 

	Por el momento, únicamente estarán disponibles 4 personajes jugables, pero en el futuro la idea es añadir más jugadores para generar más variedad de opciones.  A continuación, algunos ejemplos de modelos en 	los que nos basaremos para la creación de nuestros personajes:

![image](https://github.com/user-attachments/assets/f4c55a4e-5ee8-4cab-9c69-aeabc11e1956)

    		descripción imagen: imagen del personaje Fronaldo.


![image](https://github.com/user-attachments/assets/0d1eab2f-e45e-4db0-8f9a-2987b47d4b89)

    		descripción imagen: imagen del personaje Friolski.


![image](https://github.com/user-attachments/assets/06344bdf-a150-4fc6-b5a8-3b6799e297f9)

  		descripción imagen: imagen del personaje Fressi.


![image](https://github.com/user-attachments/assets/5ed2d8df-74f8-4169-860e-09c4dc17bdff)

		descripción imagen: imagen del personaje Friezmann.


6.4	AUDIO

	El juego cuenta de inicio con una melodía ligera y amena en bucle como música de fondo, y con un efecto de sonido del público cada vez que uno de los jugadores anota un gol. Se plantea en un futuro 		implementar efectos de sonido al inicio de los partidos, y una melodía distintas en la pantalla del gameplay para que se diferencie de la de los menús.

******************

7.	DIAGRAMA DE CLASES

![REST drawio](https://github.com/user-attachments/assets/38fcc459-3518-4691-a221-604943411261)

		descripción imagen: imagen del diagrama de clases.
