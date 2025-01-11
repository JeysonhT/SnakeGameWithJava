/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.LinkedList;
import javax.swing.JLabel;

/**
 *
 * @author jason
 */
public class Snake {

    private LinkedList<JLabel> body;

    public Snake(JLabel head) {
        body = new LinkedList<>();

        body.add(head);
    }

    public JLabel gethead() {
        return body.getFirst();
    }

    public void setHead(JLabel head) {
        body.set(0, head);
    }

    public void addBody(JLabel segmento) {
        body.add(segmento);
    }

    public LinkedList<JLabel> getBody() {
        return body;
    }

}
