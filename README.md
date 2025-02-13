# Ruleta-Java

Este proyecto ha sido desarrollado como parte de la asignatura de Programación.<br>
Consiste en un juego de ruleta implementado en Java, donde los jugadores intentan adivinar frases ocultas.

## Características

- **Configuración de jugadores y paneles**  
  Para modificar el número de jugadores y paneles, ajusta las variables `jugadores` y `paneles` en el código fuente según tus necesidades.

- **Inicio del juego**  
  Al ejecutar el programa, se te solicitará que introduzcas la frase deseada y una pista que ayudará a los jugadores a adivinarla.


## Cómo ejecutar

1. Clona este repositorio: `git clone https://github.com/Verito03/Ruleta-Java.git`
2. Abre el proyecto en tu IDE de Java preferido (Eclipse, IntelliJ, NetBeans, etc.).
3. Ejecuta la clase `Main`.

## Instrucciones de uso

*Este programa simula un juego de ruleta para varios jugadores*.<br>
El juego consiste en *adivinar una frase oculta propuesta por el presentador*.<br>
Los jugadores ganan puntos al acertar letras y resolver el panel completo.

## Cómo Jugar

1.  **Inicio del Juego:**
    *   El programa pedirá al presentador que ingrese una frase y una pista para esa frase.
    *   Se mostrará la frase oculta, donde las letras se representan con asteriscos (`*`) y los espacios se mantienen.

2.  **Turno del Jugador:**
    *   El programa mostrará un mensaje indicando a qué jugador le toca el turno.
    *   Se simulará el giro de la ruleta y se mostrará el valor obtenido.
    *   El jugador tendrá dos opciones:
        *   **Resolver**: Intentar adivinar la frase completa.
        *   **Letra**: Elegir una letra para revelar en el panel.

3.  **Resolver el Panel:**
    *   Si el jugador elige "Resolver", deberá ingresar la frase que cree que está oculta.
    *   Si la respuesta es correcta, el jugador ganará puntos según el valor de la ruleta.
    *   Si la respuesta es incorrecta, el jugador perderá su turno.

4.  **Elegir una Letra:**
    *   Si el jugador elige "Letra", deberá ingresar una letra.
    *   Si la letra está en la frase oculta, se revelarán todas las instancias de esa letra en el panel.
    *   Si la letra no está en la frase, el jugador perderá su turno.

5.  **Quiebra:**
    *   Si el valor de la ruleta es "Quiebra", el jugador perderá todos sus puntos acumulados y su turno.

6.  **Fin del Juego:**
    *   El juego continúa hasta que se completan todas las rondas o hasta que un jugador adivina la frase completa.
    *   Al final del juego, se mostrará un mensaje indicando el ganador y su puntuación.

*PARA CAMBIAR EL NÚMERO DE JUGADORES Y EL NÚMERO DE PANELES,<BR> HAY QUE CAMBIAR EL NÚMERO DE LAS VARIABLES **STATIC** EN EL MAIN*
