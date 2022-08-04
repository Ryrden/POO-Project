package main.model;

import main.assistant.Drawing;

import java.io.Serializable;

public class EnemyAttackExample extends GameElement implements Serializable,Movel {
    public EnemyAttackExample(int posX, int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
    }

    @Override
    public void autoDraw() {
        super.autoDraw();
        if(!this.moveRight())
            Drawing.getScene().removeCharacter(this);
    }

    @Override
    public boolean moveUp() {
        return this.position.moveUp();
    }

    @Override
    public boolean moveDown() {
        return this.position.moveDown();
    }

    @Override
    public boolean moveRight() {
        return this.position.moveRight();
    }

    @Override
    public boolean moveLeft() {
        return this.position.moveLeft();
    }

    @Override
    public void backToLastPosition() {
        this.position.back();
    }
}
