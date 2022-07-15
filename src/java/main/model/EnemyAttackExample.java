package main.model;

import main.assistant.Drawing;

import java.io.Serializable;

public class EnemyAttackExample extends GameElement implements Serializable {
    public EnemyAttackExample(String imgNamePNG) {
        super(imgNamePNG);
        this.mortal = true;
    }

    @Override
    public void autoDraw() {
        super.autoDraw();
        if(!this.moveRight())
            Drawing.getScene().removeCharacter(this);
    }
}
