package main.model.enemys;

import main.assistant.Constants;
import main.assistant.Drawing;
import main.model.Enemy;
import main.model.EnemyAttackExample;

public class Haskell extends Enemy {
    private int intervalCounter;

    public Haskell(int posX, int posY,String imgNamePNG) {
        super(posX,posY,imgNamePNG);
        this.intervalCounter = 0;
    }

    @Override
    public void autoDraw() {
        super.autoDraw();

        this.intervalCounter++;
        if(this.intervalCounter == Constants.TIMER_BOMB){
            this.intervalCounter = 0;
            EnemyAttackExample attackExample = new EnemyAttackExample(position.getPosX(),position.getPosY()+1,"fire.png");
            Drawing.getScene().addCharacter_(attackExample);
        }
    }
}