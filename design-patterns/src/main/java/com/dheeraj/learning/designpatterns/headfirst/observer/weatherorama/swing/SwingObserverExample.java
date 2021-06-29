package com.dheeraj.learning.designpatterns.headfirst.observer.weatherorama.swing;

import javax.swing.*;
import java.awt.*;

public class SwingObserverExample {
    JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton button = new JButton("Should I do it?");
        button.addActionListener(event -> System.out.println("Don't do it"));
        button.addActionListener(event -> System.out.println("Do it"));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(BorderLayout.CENTER, button);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
    }

    /*class AngelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it, you might regret it");
        }
    }

    class DevilListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Com on, do it");
        }
    }*/
}
