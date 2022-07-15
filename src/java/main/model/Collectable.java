package main.model;

import java.io.Serializable;

public class Collectable extends GameElement implements Serializable {
    public Collectable(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        setIsPassable(true);
        setIsMortal(true);
    }
}
