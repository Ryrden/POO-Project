package main.model;

import java.io.Serializable;


public class Player extends GameElement implements Serializable {
    private int life = 5;
    private int points = -1;

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

}
