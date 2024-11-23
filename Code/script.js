// Seleccionar el canvas y definir su contexto
const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');

// Definir tamaño del canvas
canvas.width = 1200;
canvas.height = 550;

// Constantes globales
const gravity = 0.3;
const maxFallSpeed = 15;
const jumpPower = -7; // Potencia del salto

// Cargar las imágenes
const player1Gif = new Image();
player1Gif.src = 'player1.png'; // Ruta de la imagen del jugador 1

const player2Gif = new Image();
player2Gif.src = 'player2.png'; // Ruta de la imagen del jugador 2

const footImage = new Image();
footImage.src = 'botadefutbol.png'; // Ruta de la imagen de la bota de futbol

const backgroundImage = new Image();
backgroundImage.src = 'backgroundBarsa.png';

const ballImage = new Image();
ballImage.src = 'ball.png';

// Asegurarse de que las imágenes estén cargadas antes de iniciar el juego
let player1Ready = false;
let player2Ready = false;

player1Gif.onload = () => {
    player1Ready = true;
};

player2Gif.onload = () => {
    player2Ready = true;
};

// Clase Player
class Player {
    constructor(x, y, width, height, gif, isFacingLeft = false) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.gif = gif;
        this.velocityX = 0;
        this.velocityY = 0;
        this.isJumping = false;
        this.jumpRequested = false;
        this.kickRequested = false;
        this.isFacingLeft = isFacingLeft;
        this.kickPhase = 0; // Controla la animación del disparo (0 = no disparando, 1 = disparando)

        // Pie del jugador
        this.foot = {
            x: this.x,
            y: this.y + this.height / 2,
            width: 30,
            height: 50,
            isKicking: false,
            kickDistance: 20,
            offset: isFacingLeft ? -this.width / 2 - 0 : this.width / 2 - 15,
            direction: isFacingLeft ? -1 : 1,
        };
    }

    draw() {
        // Dibujar el jugador con la orientación adecuada
        ctx.save();
        if (this.isFacingLeft) {
            ctx.scale(-1, 1); // Refleja horizontalmente
            ctx.drawImage(
                this.gif,
                -this.x - this.width / 2,
                this.y - this.height / 2,
                this.width,
                this.height
            );
        } else {
            ctx.drawImage(
                this.gif,
                this.x - this.width / 2,
                this.y - this.height / 2,
                this.width,
                this.height
            );
        }
        ctx.restore();

        // Dibujar la bota reflejada si el jugador está mirando hacia la derecha
        if (!this.isFacingLeft) {
            ctx.save();  // Guardar el estado actual del canvas
            ctx.scale(-1, 1); // Reflejar horizontalmente (esto voltea la imagen)
        // Dibujar la bota reflejada
            ctx.drawImage(footImage, -(this.foot.x + this.foot.width / 2 + 12), this.foot.y - this.foot.height / 2 - 5, this.foot.width, this.foot.height);
            ctx.restore(); // Restaurar el estado original del canvas
    } else {
        // Dibujo normal de la bota si el jugador está mirando a la izquierda
            ctx.drawImage(footImage, this.foot.x - this.foot.width / 2 - 2, this.foot.y - this.foot.height / 2 - 5, this.foot.width, this.foot.height);
    }
}

        update() {
            if (this.y + this.height / 2 < canvas.height) {
                this.velocityY += gravity;
                this.velocityY = Math.min(this.velocityY, maxFallSpeed);
            } else {
                this.velocityY = 0;
                this.y = canvas.height - this.height / 2;
                this.isJumping = false;
            }
        
            if (!this.isJumping && this.jumpRequested) {
                this.velocityY = jumpPower;
                this.isJumping = true;
                this.jumpRequested = false;
            }
        
            this.x += this.velocityX;
            this.y += this.velocityY;
            //this.x = Math.max(this.width / 2, Math.min(this.x, canvas.width - this.width / 2));
        
            // Animación del disparo
            if (this.foot.isKicking) {
                // Incrementar el progreso del disparo
                this.kickTime += 0.1;
                if (this.kickTime < 1) {
                    this.kickPhase = Math.min(1, this.kickPhase + 0.05); // Progreso de la pierna
                } else {
                    this.kickPhase = 0; // Reiniciar animación después del disparo
                    this.foot.isKicking = false; // Termina el disparo
                }
        
                // Mover la pierna hacia adelante durante el disparo
                this.foot.x = this.x + this.foot.offset + (this.foot.direction * this.kickPhase * 30); // La pierna avanza
            } else {
                this.foot.x = this.x + this.foot.offset; // Posición normal del pie
            }
        
            this.foot.y = this.y + this.height / 2;
        }
        

    kick() {
        if (!this.foot.isKicking) {
            this.foot.isKicking = true;
            this.kickPhase = 0.1; // Inicia la animación de disparo
            this.kickTime = 0; // Restablece el tiempo del disparo
        }
    }
    

    checkFootCollision(ball) {
        if (this.foot.isKicking && this.kickPhase >= 0.5) { // Solo cuando el pie está completamente extendido
            const dx = ball.x - this.foot.x;
            const dy = ball.y - this.foot.y;
            const distance = Math.sqrt(dx * dx + dy * dy);
    
            if (distance < ball.radius + this.foot.width / 2) {
                const power = 12;
                const angle = Math.atan2(dy, dx);
                ball.velocityX += Math.cos(angle) * power;
                ball.velocityY += Math.sin(angle) * power;
                this.kickPhase = 0; // Reinicia la animación
                this.foot.isKicking = false;
            }
        }
    }
}    

// Clase Ball
class Ball {
    constructor(x, y, color) {
        this.x = x;
        this.y = y;
        this.radius = 15;
        this.color = color;
        this.velocityX = 5;
        this.velocityY = 3;
        this.friction = 0.98; // Factor de fricción para la desaceleración horizontal
        this.rotation = 0;
    }

    draw() {
        ctx.save();  // Guardar el estado del contexto

        // Mover el contexto al centro de la pelota
        ctx.translate(this.x, this.y);

        // Aplicar la rotación (convertir a radianes)
        ctx.rotate(this.rotation);

        // Dibujar la imagen del balón
        ctx.drawImage(ballImage, -this.radius, -this.radius, this.radius * 2, this.radius * 2);

        ctx.restore();  // Restaurar el estado del contexto
    }

    update() {
        // Aplicar fricción a la velocidad en X
        if (Math.abs(this.velocityX) > 0.1) { // Solo aplicar fricción si la velocidad es significativa
            this.velocityX *= this.friction;
        } else {
            this.velocityX = 0; // Detener la pelota si la velocidad es muy baja
        }

        // Aplicar gravedad
        this.velocityY += gravity;
        this.velocityY = Math.min(this.velocityY, maxFallSpeed); // Limitar la velocidad de caída

        this.x += this.velocityX;
        this.y += this.velocityY;
    
        // Control de rebote si la pelota llega a los bordes
        if (this.x + this.radius > canvas.width || this.x - this.radius < 0) {
            this.velocityX *= -2; // Rebote en los bordes laterales
        }
        if (this.y + this.radius > canvas.height) {
            this.velocityY *= -0.8; // Rebote en el suelo (menos velocidad en Y)
            this.y = canvas.height - this.radius; // Posicionar la pelota en el suelo
        }

        // Rotación de la pelota en función de su velocidad
        // La rotación es proporcional a la distancia recorrida
        this.rotation += Math.abs(this.velocityX + this.velocityY) * 0.05; // Ajusta el 0.05 para más o menos rotación

        // Mantener la rotación dentro del rango de 0 a 2 * PI (360 grados)
        if (this.rotation >= 2 * Math.PI) {
            this.rotation = 0;  // Reiniciar la rotación cuando llegue a 360 grados
        }
    }
}

// Función para dibujar el marcador
function drawScore() {
    ctx.font = '30px Arial';
    ctx.fillStyle = 'black';
    ctx.fillText(`Jugador 1: ${scorePlayer1}`, 50, 50);
    ctx.fillText(`Jugador 2: ${scorePlayer2}`, canvas.width - 200, 50);
}
// Función para dibujar las porterias
function drawGoals() {
    // Dibuja las porterías (ya las tienes definidas)
    ctx.fillStyle = 'yellow';
    ctx.fillRect(goalLeft.x, goalLeft.y, goalLeft.width, goalLeft.height);  // Portería izquierda
    ctx.fillRect(goalRight.x, goalRight.y, goalRight.width, goalRight.height);  // Portería derecha
}

function checkGoal() {
    if (ball.x + ball.radius > goalRight.x && ball.y > goalRight.y && ball.y < goalRight.y + goalRight.height) {
        scorePlayer1++;
        resetBall();
    }
    if (ball.x - ball.radius < goalLeft.x + goalLeft.width && ball.y > goalLeft.y && ball.y < goalLeft.y + goalLeft.height) {
        scorePlayer2++;
        resetBall();
    }
}

function resetBall() {
    ball.x = canvas.width / 2;
    ball.y = 100;
    ball.velocityX = 3 * (Math.random() < 0.5 ? 1 : -1);
    ball.velocityY = 3 * (Math.random() < 0.5 ? 1 : -1);
}

function checkPlayersCollision(player1, player2) {
    // Calcular la distancia entre los centros de los dos jugadores
    const dx = player2.x - player1.x;
    const dy = player2.y - player1.y;
    const distance = Math.sqrt(dx * dx + dy * dy);

    // Verificar si la distancia entre los jugadores es menor que la suma de sus radios
    const minDistance = player1.width / 2 + player2.width / 2;  // Suma de los radios (ancho / 2 de cada jugador)
    
    if (distance < minDistance) {
        // Si los jugadores colisionan, ajustar sus posiciones para evitar superposición
        const angle = Math.atan2(dy, dx);  // Calcular el ángulo entre los jugadores

        // Mover a los jugadores fuera de la colisión
        const overlap = minDistance - distance;  // Distancia de superposición
        const offsetX = Math.cos(angle) * overlap;
        const offsetY = Math.sin(angle) * overlap;

        // Ajustar las posiciones de los jugadores
        player1.x -= offsetX;
        player1.y -= offsetY;
        player2.x += offsetX;
        player2.y += offsetY;
    }
}


// Función para verificar colisiones
function checkCollision(player, ball) {
    
    // Obtener las coordenadas del rectángulo que representa al jugador
    const playerLeft = player.x;
    const playerRight = player.x + player.width;
    const playerTop = player.y - player.height;
    const playerBottom = player.y;

    // Verificar si el balón está dentro del rectángulo del jugador
    if (ball.x + ball.radius > playerLeft &&
        ball.x - ball.radius < playerRight &&
        ball.y + ball.radius > playerTop &&
        ball.y - ball.radius < playerBottom) {
        // Calcular el ángulo de colisión
        const dx = ball.x - player.x;
        const dy = ball.y - player.y;
        const angle = Math.atan2(dy, dx);

        // Actualizar las velocidades de la pelota según la dirección del jugador
        ball.velocityX = Math.cos(angle) * 5 + player.velocityX * 0.5;
        ball.velocityY = Math.sin(angle) * 5 + player.velocityY * 0.5;

        // Reducir la velocidad de la pelota al rebotar
        ball.velocityX *= 0.9;
        ball.velocityY *= 0.9;
    }
}

const player1 = new Player(100, canvas.height - 30, 60, 80, player1Gif);
const player2 = new Player(1100, canvas.height - 30, 60, 80, player2Gif, true);
const ball = new Ball(canvas.width / 2, 100, 15, 'white');

const goalLeft = { x: 0, y: canvas.height - 170, width: 70, height: 170 };
const goalRight = { x: canvas.width - 70, y: canvas.height - 170, width: 70, height: 170 };

const crossbarLeft = {
    x: 0,
    y: 380, 
    width: goalLeft.width, 
    height: 10,  
    
    // Dibujar el larguero
    draw: function() {
        ctx.fillStyle = 'blue';  // Color del larguero
        ctx.fillRect(this.x, this.y, this.width, this.height);
    },

    // Detectar colisión con la pelota
checkBallCollision: function(ball) {
    if (ball.x + ball.radius > this.x && ball.x - ball.radius < this.x + this.width) {
        if (ball.y - ball.radius < this.y && ball.y + ball.radius > this.y) {
            // Rebote en el larguero
            ball.velocityY *= -1;  // Rebote en el larguero
            ball.y = this.y - ball.radius;  // Posiciodwna la pelota en el larguero
            
            // Si la pelota se queda en la parte superior (y no está cayendo)
            if (ball.velocityY === 0) {
                // Mover la pelota horizontalmente hacia el centro del campo
                if (ball.x < canvas.width / 2) {
                    ball.velocityX = 2;  // Hacia la derecha
                } else {
                    ball.velocityX = -2;  // Hacia la izquierda
                }
            }
        }
    }
},
    // Detectar colisión con los jugadores
    checkPlayerCollision: function(player) {
        if (player.x + player.width / 2 > this.x && player.x - player.width / 2 < this.x + this.width) {
            if (player.y - player.height / 2 < this.y && player.y + player.height / 2 > this.y) {
                player.velocityY = 0;  // Detener al jugador
                player.y = this.y - player.height / 2;  // Colocar al jugador justo debajo del larguero
            }
        }
    }
};

const crossbarRight = {
    x: 1130,
    y: 380, 
    width: goalLeft.width, 
    height: 10,  
    
    // Dibujar el larguero
    draw: function() {
        ctx.fillStyle = 'blue';  // Color del larguero
        ctx.fillRect(this.x, this.y, this.width, this.height);
    },

    // Detectar colisión con la pelota
checkBallCollision: function(ball) {
    if (ball.x + ball.radius > this.x && ball.x - ball.radius < this.x + this.width) {
        if (ball.y - ball.radius < this.y && ball.y + ball.radius > this.y) {
            // Rebote en el larguero
            ball.velocityY *= -1;  // Rebote en el larguero
            ball.y = this.y - ball.radius;  // Posiciona la pelota en el larguero
            
            // Si la pelota se queda en la parte superior (y no está cayendo)
            if (ball.velocityY === 0) {
                // Mover la pelota horizontalmente hacia el centro del campo
                if (ball.x < canvas.width / 2) {
                    ball.velocityX = 2;  // Hacia la derecha
                } else {
                    ball.velocityX = -2;  // Hacia la izquierda
                }
            }
        }
    }
},
    // Detectar colisión con los jugadores
    checkPlayerCollision: function(player) {
        if (player.x + player.width / 2 > this.x && player.x - player.width / 2 < this.x + this.width) {
            if (player.y - player.height / 2 < this.y && player.y + player.height / 2 > this.y) {
                player.velocityY = 0;  // Detener al jugador
                player.y = this.y - player.height / 2;  // Colocar al jugador justo debajo del larguero
            }
        }
    }
};

let scorePlayer1 = 0;
let scorePlayer2 = 0;


// Eventos de teclado para controlar el pie y disparo
window.addEventListener('keydown', (e) => {
    // Jugador 1
    if (e.key === 'd') {
        player1.velocityX = 5;
    }
    if (e.key === 'a') {
        player1.velocityX = -5;
    }
    if (e.key === 'w' && !player1.isJumping) {
        player1.jumpRequested = true;
    }
    if (e.key === ' ') { // Tecla para disparar (barra espaciadora)
        player1.kick();
    }

    // Jugador 2
    if (e.key === 'ArrowRight') {
        player2.velocityX = 5;
    }
    if (e.key === 'ArrowLeft') {
        player2.velocityX = -5;
    }
    if (e.key === 'ArrowUp' && !player2.isJumping) {
        player2.jumpRequested = true;
    }
    if (e.key === 'p') { // Tecla para disparar (p)
        player2.kick();
    }
});

window.addEventListener('keyup', (e) => {
    if (e.key === 'd' || e.key === 'a') {
        player1.velocityX = 0;
    }
    if (e.key === 'ArrowRight' || e.key === 'ArrowLeft') {
        player2.velocityX = 0;
    }
});

// Bucle principal del juego
function updateGame() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.drawImage(backgroundImage, 0, 0, canvas.width, canvas.height);

    drawScore();
    drawGoals();
    crossbarLeft.draw();
    crossbarRight.draw();

    player1.update();
    player1.draw();
    player2.update();
    player2.draw();

    ball.update();
    ball.draw();

    checkGoal();

    // Comprobar colisión con la pelota y los jugadores
    crossbarLeft.checkBallCollision(ball);
    crossbarLeft.checkPlayerCollision(player1);
    crossbarLeft.checkPlayerCollision(player2);
    crossbarRight.checkBallCollision(ball);
    crossbarRight.checkPlayerCollision(player1);
    crossbarRight.checkPlayerCollision(player2);

    // Verificar colisiones entre el pie y el balón
    player1.checkFootCollision(ball);
    player2.checkFootCollision(ball);
    checkPlayersCollision(player1, player2);

    // Colisión general con el jugador
    checkCollision(player1, ball);
    checkCollision(player2, ball);

    requestAnimationFrame(updateGame);
}
// Iniciar el juego
updateGame();
