/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.JLabel;

/**
 *
 * @author jason
 */
public class apple {

    private final JLabel position;

    public apple(JLabel position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        position.setLocation(x, y);
    }

    public JLabel getApple() {
        return position;
    }
}
