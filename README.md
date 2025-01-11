# Snake Game en Java

Este proyecto es una implementación del clásico juego Snake utilizando Java y Swing. El juego permite al usuario controlar una serpiente que debe alimentarse de manzanas, incrementando su longitud con cada comida. El objetivo es evitar chocar con las paredes o consigo misma.

## Características

- Movimiento de la serpiente controlado por las teclas de dirección (flechas).
- Generación aleatoria de la manzana dentro del panel.
- Crecimiento de la serpiente al comer una manzana.
- Detección de colisión con las paredes y consigo misma.
- Uso de `JPanel`, `JLabel`, y `Timer` para la lógica y el renderizado del juego.

## Requisitos del sistema

- **Java Development Kit (JDK)** 17
- **IDE recomendado:** NetBeans, IntelliJ IDEA o Eclipse
- **Sistema operativo:** Windows, macOS o Linux

## Instalación y ejecución

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/JeysonhT/SnakeGameWithJava.git
   ```
2. Abre el proyecto en tu IDE preferido.
3. Compila y ejecuta la clase principal `SnakeGame.java`.

## Estructura del proyecto

```
|-- src
|   |-- resources
|   |   |-- serpiente(1).png
|   |   |-- manzana.png
|   |-- Snake.java
|   |-- apple.java
|   |-- Ventana.java
|   |-- SnakeGame.java
```

- **Snake.java**: Clase que representa la serpiente, contiene la cabeza y el cuerpo.
- **apple.java**: Clase que representa la manzana.
- **Ventana.java**: Clase de la ventana de swing que maneja la interfaz gráfica y la lógica del juego.

## Controles del juego

- **Flecha arriba:** Mover la serpiente hacia arriba.
- **Flecha abajo:** Mover la serpiente hacia abajo.
- **Flecha izquierda:** Mover la serpiente hacia la izquierda.
- **Flecha derecha:** Mover la serpiente hacia la derecha.

## Mejoras futuras

- Agregar niveles de dificultad.
- Agregar efectos de sonido.
- Permitir reiniciar el juego tras perder.

## Contribución

Las contribuciones son bienvenidas. Si deseas mejorar el juego o agregar nuevas características, sigue estos pasos:

1. Haz un fork de este repositorio.
2. Crea una rama nueva para tu función o mejora: `git checkout -b mejora-nueva`.
3. Realiza tus cambios y haz un commit: `git commit -m 'Agrega nueva función'`.
4. Envía un pull request.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).

---

¡Gracias por jugar Snake Game! Si te gustó el proyecto, no olvides darle una estrella en GitHub :star:

