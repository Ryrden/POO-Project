package main.model;

import java.io.Serializable;

public class StaticObstacle extends GameElement implements Serializable {
    public StaticObstacle(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        setIsPassable(false);
    }

}
