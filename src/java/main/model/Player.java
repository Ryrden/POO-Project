package main.model;

import java.io.Serializable;

public class Player extends GameElement implements Serializable {
    public Player(int posX,int posY,String  imgNamePNG) {
        super(posX, posY, imgNamePNG);
    }

    public void backToLastPosition(){
        this.position.back();
    }
}
