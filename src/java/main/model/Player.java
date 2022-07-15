package main.model;

import java.io.Serializable;

public class Player extends GameElement implements Serializable {
    public Player(String  imgNamePNG) {
        super(imgNamePNG);
    }

    public void backToLastPosition(){
        this.position.back();
    }
}
