package main.model;

import main.assistant.Drawing;

import java.io.Serializable;

public class EnemyAttackExample extends GameElement implements Serializable {
    public EnemyAttackExample(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
    }

    @Override
    public void autoDraw() {
        super.autoDraw();
        if(!this.moveRight())
            Drawing.getScene().removeCharacter(this);
    }
}
