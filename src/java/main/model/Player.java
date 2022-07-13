package main.model;

import java.io.Serializable;

public class Player extends Character_ implements Serializable {
    public Player(String  imgNamePNG) {
        super(imgNamePNG);
    }

    public void backToLastPosition(){
        this.position.back();
    }
}
