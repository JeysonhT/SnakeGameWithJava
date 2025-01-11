/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snakegame;

import View.ventana;
import java.io.FileNotFoundException;
import javax.swing.WindowConstants;

/**
 *
 * @author jason
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ventana v = new ventana(480, 360);
            v.setVisible(true);
            v.setLocationRelativeTo(null);
            v.setResizable(false);
            v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
