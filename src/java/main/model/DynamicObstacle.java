package main.model;

import java.io.Serializable;

public class DynamicObstacle extends GameElement implements Serializable {
    public DynamicObstacle(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        setIsPassable(false);
    }
}
