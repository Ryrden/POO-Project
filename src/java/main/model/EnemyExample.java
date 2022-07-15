package main.model;

import main.assistant.Constants;
import main.assistant.Drawing;

import java.io.Serializable;

public class EnemyExample extends GameElement implements Serializable {
    private int intervalCounter;

    public EnemyExample(String imgNamePNG) {
        super(imgNamePNG);
        this.isPassable = false;
        this.intervalCounter = 0;
    }

    public void autoDraw() {
        super.autoDraw();

        this.intervalCounter++;
        if(this.intervalCounter == Constants.TIMER_BOMB){
            this.intervalCounter = 0;
            EnemyAttackExample attackExample = new EnemyAttackExample("fire.png");
            attackExample.setPosition(position.getPosX(),position.getPosY()+1);
            Drawing.getScene().addCharacter_(attackExample);
        }
    }
}
