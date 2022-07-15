package main;

import main.controller.Screen;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Screen screen = new Screen();
            screen.loadPhase(1);
            screen.setVisible(true);
            screen.createBufferStrategy(2);
            screen.go();
        });
    }
}
