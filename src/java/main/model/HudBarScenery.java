package main.model;

import main.assistant.Drawing;
import main.controller.Screen;
import main.gamePhase.HudBar;

import javax.swing.*;
import java.io.Serializable;

public class HudBarScenery extends GameElement implements Serializable {
    ImageIcon numberZero = Screen.loadImage("hudBar/0.png");
    ImageIcon numberOne = Screen.loadImage("hudBar/1.png");
    ImageIcon numberTwo = Screen.loadImage("hudBar/2.png");
    ImageIcon numberThree = Screen.loadImage("hudBar/3.png");
    ImageIcon numberFour = Screen.loadImage("hudBar/4.png");
    ImageIcon numberFive = Screen.loadImage("hudBar/5.png");
    ImageIcon numberSix = Screen.loadImage("hudBar/6.png");
    ImageIcon numberSeven = Screen.loadImage("hudBar/7.png");
    ImageIcon numberEight = Screen.loadImage("hudBar/8.png");
    ImageIcon numberNine = Screen.loadImage("hudBar/9.png");
    ImageIcon numberTen = Screen.loadImage("hudBar/10.png");
    HudBar hudBar;
    public HudBarScenery(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        hudBar = HudBar.getInstance();
    }

    public void autoDraw() {
        switch (hudBar.getPoints()) {
            case 1 -> Drawing.draw(numberOne, 5, 11);
            case 2 -> Drawing.draw(numberTwo, 5, 11);
            case 3 -> Drawing.draw(numberThree, 5, 11);
            case 4 -> Drawing.draw(numberFour, 5, 11);
            case 5 -> Drawing.draw(numberFive, 5, 11);
            case 6 -> Drawing.draw(numberSix, 5, 11);
            case 7 -> Drawing.draw(numberSeven, 5, 11);
            case 8 -> Drawing.draw(numberEight, 5, 11);
            case 9 -> Drawing.draw(numberNine, 5, 11);
            case 10 -> Drawing.draw(numberTen, 5, 11);
            default -> Drawing.draw(numberZero, 5, 11);
        }
        switch(hudBar.getLife()){
            case 0 -> Drawing.draw(numberZero, 2, 11);
            case 1 -> Drawing.draw(numberOne, 2, 11);
            case 2 -> Drawing.draw(numberTwo, 2, 11);
            case 3 -> Drawing.draw(numberThree, 2, 11);
            case 4 -> Drawing.draw(numberFour, 2, 11);
            case 6 -> Drawing.draw(numberSix, 2, 11);
            case 7 -> Drawing.draw(numberSeven, 2, 11);
            case 8 -> Drawing.draw(numberEight, 2, 11);
            case 9 -> Drawing.draw(numberNine, 2, 11);
            case 10 -> Drawing.draw(numberTen, 2, 11);
            default -> Drawing.draw(numberFive, 2, 11);
        }
        Drawing.draw(this.image, this.position.getPosX(), this.position.getPosY());

    }
}
