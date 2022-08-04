package main.model;

import java.io.Serializable;

public class CharacterExample extends GameElement implements Serializable {
    private boolean right;

    public CharacterExample(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        this.right = true;
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
