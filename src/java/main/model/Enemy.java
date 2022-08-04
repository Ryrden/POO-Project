package main.model;

import java.io.Serializable;

public class Enemy extends GameElement implements Serializable {
    public Enemy(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        setIsPassable(true);
        setIsMortal(true);
    }
}
