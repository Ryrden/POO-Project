package main.model.scene;

import main.assistant.Drawing;
import main.controller.Screen;
import main.model.Collectable;
import main.model.DynamicObstacle;

import javax.swing.*;

public class Chest extends Collectable {
    boolean isOpen = false;
    ImageIcon chestOpen = Screen.loadImage("scenerySprite/chestOpen.png");
    ImageIcon chestClosed = Screen.loadImage("scenerySprite/chestClosed.png");
    public Chest(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        setIsPassable(false);
        setCollectable(false);
    }
    public void autoDraw() {
        if (this.isOpen()) {
            setIsPassable(true);
            Drawing.draw(chestOpen, this.position.getPosX(), this.position.getPosY());
        } else {
            Drawing.draw(chestClosed, this.position.getPosX(), this.position.getPosY());
        }
    }

    private boolean isOpen() {
        return isOpen;
    }
}

