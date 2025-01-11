/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snakegame;

import View.ventana;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author jason
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            ventana v = new ventana(480, 360);
            File file = new File("src/resources/serpiente.png");
            BufferedImage icon = ImageIO.read(file);
            
            ImageIcon image = new ImageIcon(icon);
            v.setVisible(true);
            v.setLocationRelativeTo(null);
            v.setResizable(false);
            v.setTitle("Snake Game con Java");

            v.setIconImage(image.getImage());

            v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
