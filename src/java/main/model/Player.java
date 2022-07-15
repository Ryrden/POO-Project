package main.model;

import java.io.Serializable;

public class Player extends GameElement implements Serializable {
    private int life = 5;
    private int points = 0;
    public Player(int posX,int posY,String  imgNamePNG) {
        super(posX, posY, imgNamePNG);
    }
    public void gainOnePoint(){
        this.points++;
    }
    public void backToLastPosition(){
        this.position.back();
    }
}
