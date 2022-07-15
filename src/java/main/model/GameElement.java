package main.model;

import main.assistant.Constants;
import main.assistant.Drawing;
import main.assistant.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

public abstract class GameElement implements Serializable {
    protected ImageIcon image;
    protected Position position;
    protected boolean isPassable; /*Pode passar por cima?*/
    protected boolean mortal;       /*Se encostar, o Bomberman morre?*/


    protected GameElement(String imgNamePNG) {
        this.position = new Position(1, 1);
        this.isPassable = true;
        this.mortal = false;
        try {
            image = new ImageIcon(new java.io.File(".").getCanonicalPath() + Constants.PATH + imgNamePNG);
            Image img = image.getImage();
            BufferedImage bufferedImg = new BufferedImage(Constants.CELL_SIDE, Constants.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics graphics = bufferedImg.createGraphics();
            graphics.drawImage(img, 0, 0, Constants.CELL_SIDE, Constants.CELL_SIDE, null);
            image = new ImageIcon(bufferedImg);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Position getPosition() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
        diretamente sobre a posição do Personagem*/
        return position;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setIsPassable(boolean isPassable) {
        this.isPassable = isPassable;
    }

    public void autoDraw() {
        Drawing.draw(this.image, position.getPosX(), position.getPosY());
    }

    public boolean setPosition(int posX, int posY) {
        return position.setPosition(posX, posY);
    }

    public boolean moveUp() {
        return this.position.moveUp();
    }

    public boolean moveDown() {
        return this.position.moveDown();
    }

    public boolean moveRight() {
        return this.position.moveRight();
    }

    public boolean moveLeft() {
        return this.position.moveLeft();
    }
}
