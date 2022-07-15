package main.model.enemys;

import main.model.GameElement;

public class CPlusPlus extends GameElement {
    public CPlusPlus(int posX, int posY,String imgNamePNG) {
        super(posX,posY,imgNamePNG);
        this.mortal = true;
    }
}
