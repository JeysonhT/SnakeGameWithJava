/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.Snake;
import models.apple;

/**
 *
 * @author jason
 */
public class ventana extends JFrame {

    private JPanel panel;
    private Snake snake;
    private apple papple;
    private String direccion = "DOWN";
    private int minX = 0;
    private int maxX;
    private int minY = 0;
    private int maxY;
    private Random random;
    int delay;

    private int score = 0;
    JLabel labelScore;

    public ventana(int width, int heigth) throws FileNotFoundException {
        this.setSize(new Dimension(width, heigth));
        maxX = width - 30;
        maxY = heigth - 60;
        initComponets();
        initKeyListener();
        moverSnake();
    }

    private void initComponets() throws FileNotFoundException {
        random = new Random();
        panel = new JPanel();
        panel.setSize(this.getSize());
        panel.setLayout(null);

        File file = new File("src/resources/greenSquare(1).png");

        ImageIcon image = new ImageIcon(file.getPath());
        //crear la cabeza de la serpiente
        JLabel head = new JLabel(image);
        head.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        //añado la cabeza de la serpiente a el objeto serpiente
        snake = new Snake(head);

        //Creo la manzana
        File pathApple = new File("src/resources/redSquare(1).png");
        ImageIcon appleImage = new ImageIcon(pathApple.getPath());

        JLabel appleLabel = new JLabel(appleImage);
        appleLabel.setBounds(this.getWidth() / 2, this.getHeight() / 2,
                appleImage.getIconWidth(), appleImage.getIconHeight());

        papple = new apple(appleLabel);

        //Añado el label de la puntuacion
        labelScore = new JLabel("Puntos: " + score);
        labelScore.setBounds(20, 10, 100, 30);

        //añadiendo los componentes
        panel.add(snake.gethead());
        panel.add(papple.getApple());
        panel.add(labelScore);

        //agregar el panel al frame
        this.add(panel);
    }

    private void initKeyListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_UP && !"DOWN".equals(direccion)) {
                    direccion = "UP";
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN && !"UP".equals(direccion)) {
                    direccion = "DOWN";
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT && !"RIGHT".equals(direccion)) {
                    direccion = "LEFT";
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && !"LEFT".equals(direccion)) {
                    direccion = "RIGHT";
                }
            }
        });
    }

    private void moverSnake() {
        delay = 150;
        Timer timer = new Timer(delay, null);
        int[] position = {0, 0};

        int paso = 10;
        timer.addActionListener((e) -> {

            switch (direccion) {
                case "UP" ->
                    position[1] -= paso;
                case "DOWN" ->
                    position[1] += paso;
                case "LEFT" ->
                    position[0] -= paso;
                case "RIGHT" ->
                    position[0] += paso;
                default ->
                    position[1] += paso;
            }
            //Se mueve primero todo el cuerpo y luego la cabeza en cada iteracion
            for (int i = snake.getBody().size() - 1; i > 0; i--) {
                snake.getBody().get(i).setLocation(snake.getBody().get(i - 1).getLocation());
            }
            snake.gethead().setLocation(position[0], position[1]);
            //se repinta el panel
            panel.revalidate();
            panel.repaint();
            //Evaluacion de la comida y el crecimiento
            if (snake.gethead().getLocation().equals(papple.getApple().getLocation())) {
                // se crea la proxima parte del cuerpo

                // primero se busca la imagen
                File pathSquare = new File("src/resources/greenSquare(1).png");
                // se crea el objeto de la imagen
                ImageIcon squareImage = new ImageIcon(pathSquare.getPath());

                // se añade la imagen a una etiqueta que representa la cabeza y las partes cuerpo
                JLabel squareLabel = new JLabel(squareImage);
                // se le asigna la posicion del ultimo elemento anterior del cuerpo de la serpiente
                Point lastLocation = new Point(snake.getBody().getLast().getLocation());
                squareLabel.setLocation(lastLocation);

                // se le asignan el tamaño y posicion en el panel
                squareLabel.setBounds(lastLocation.x, lastLocation.y,
                        squareImage.getIconWidth(), squareImage.getIconHeight());

                // se añade al cuerpo de la serpiente
                snake.addBody(squareLabel);

                // se añade este nuevo elemento del cuerpo al panel
                panel.add(snake.getBody().getLast());

                // se suma la puntuacion y se actualiza el texto de la misma
                score++;
                labelScore.setText("Puntos: " + score);

                panel.revalidate();
                panel.repaint();

                // se mueve la manzana de lugar
                int x = random.nextInt((maxX - minX) / 10) * 10 + minX;
                int y = random.nextInt((maxY - minY) / 10) * 10 + minY;
                papple.getApple().setLocation(x, y);
                
            }

            //Comprobamos en cada iteracion si la cabeza de la serpiente a chocado con la pared o con ella misma
            //decir si perdio o no.
            //1. comprobacion con la pared
            if (snake.gethead().getLocation().x == this.getSize().width - 20 || snake.gethead().getLocation().y == this.getSize().height - 50
                    || snake.gethead().getLocation().x < 0 | snake.gethead().getLocation().y < 0) {
                // se detiene el bucle
                timer.stop();
                JOptionPane.showMessageDialog(this, "la serpiente choco con la pared, has perdido; \nPuntos: " + score);

            } else {
                // comprobacion con ella misma
                if (snake.getBody().size() > 2) {
                    for (int i = 1; i < snake.getBody().size(); i++) {
                        if (snake.gethead().getLocation().equals(snake.getBody().get(i).getLocation())) {
                            // se detiene el bucle
                            timer.stop();
                            JOptionPane.showMessageDialog(this, "la serpiente choco con ella misma, has perdido; \nPuntos: " + score);

                        }
                    }
                }
            }
        });

        timer.start();
    }
}
