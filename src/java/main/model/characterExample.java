package main.model;

import java.io.Serializable;

public class characterExample extends Character_ implements Serializable {
    private boolean right;

    public characterExample(String imgNamePNG) {
        super(imgNamePNG);
        right = true;
    }
    public void autoDraw(){
        if(right)
            this.setPosition(position.getPosX(), position.getPosY()+1);
        else
            this.setPosition(position.getPosX(), position.getPosY()-1);

        super.autoDraw();
        right = !right;
    }
}
