package main.model;

import main.assistant.Constants;

import java.io.Serializable;


public class Player extends GameElement implements Serializable, Movel {
    private int life = 5;
    private int points = 0;
    private int direction = -1;

    public Player(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
    }

    public void gainOnePoint() {
        this.points++;
    }

    public void loseOneLife(){
        this.life--;
    }

    @Override
    public void autoDraw() {
        super.autoDraw();;
    }

    public void backToLastPosition() {
        this.position.back();
    }

    public int getLife() {
        return life;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean moveUp() {
        direction = Constants.UP;
        return this.position.moveUp();
    }

    @Override
    public boolean moveDown() {
        direction = Constants.DOWN;
        return this.position.moveDown();
    }

    @Override
    public boolean moveRight() {
        direction = Constants.RIGHT;
        return this.position.moveRight();
    }

    @Override
    public boolean moveLeft() {
        direction = Constants.LEFT;
        return this.position.moveLeft();
    }

    public int getDirection() {
        return direction;
    }
}
