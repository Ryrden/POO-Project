package main.model.scene;

import main.model.DynamicObstacle;
import main.model.Movel;
import main.model.Pushable;

public class RollingRock extends Pushable {
    public RollingRock(int posX,int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
    }

    @Override
    public void autoDraw() {
        super.autoDraw();
    }
}
