package main.controller;

import main.assistant.Position;
import main.gamePhase.HudBar;
import main.model.GameElement;
import main.model.Player;
import main.model.scene.Chest;

import java.util.ArrayList;

public class GameController {
    public void drawAll(ArrayList<GameElement> characterArrayList) {
        for (int i = characterArrayList.size() - 1; i >= 0; i--) {
            characterArrayList.get(i).autoDraw();
        }
    }

    public void processAll(ArrayList<GameElement> elementsArray) {
        Player player = (Player) elementsArray.get(0);
        GameElement currentElement;
        HudBar hudBar = HudBar.getInstance();
        if (player.getPoints() >= getMinimunPointsToClearLeve (elementsArray)){
            Chest chest = getChest(elementsArray);
            if(chest.isOpen() == false) {
                chest.setOpen(true);
            }
            if(chest.isOpen() & player.getPosition().equals(chest.getPosition())){
                elementsArray.clear();
            }
        }
        for (int i = 1; i < elementsArray.size(); i++) {
            currentElement = elementsArray.get(i);
            if (player.getPosition().equals(currentElement.getPosition())) {
                if (currentElement.isCollectable()) {
                    elementsArray.remove(currentElement);
                    player.gainOnePoint();
                    hudBar.updatePoints(player.getPoints());
                }
                if (currentElement.isPassable() && currentElement.isMortal()) {
                    elementsArray.remove(currentElement);
                }
                if (currentElement.isMortal()) {
                    player.loseOneLife();
                    hudBar.updateLife(player.getLife());
                    if (player.getLife() <= 0) {
                        elementsArray.remove(player);
                    }
                }

            }
        }
    }

    public int getMinimunPointsToClearLeve(ArrayList<GameElement> elementsArray) {
        int minimunPoints = 0;
        for (int i = 0; i < elementsArray.size(); i++) {
            if (elementsArray.get(i).isCollectable()) {
                minimunPoints++;
            }
        }
        return minimunPoints;
    }

    Chest getChest(ArrayList<GameElement> elementsArray){
        Chest chest;
        for (GameElement element:
             elementsArray) {
            try {
                chest = (Chest) element;
                return chest;
            }
            catch(Exception e){
                continue;
            }
        }
        return null;
    }

    /*Retorna true se a posicao p é válida para Lolo com relacao a todos os personagens no array*/
    public boolean isValidPosition(ArrayList<GameElement> characterArrayList, Position position) {
        GameElement characterTemp;
        for (int i = 1; i < characterArrayList.size(); i++) {
            characterTemp = characterArrayList.get(i);
            if (!characterTemp.isPassable() && characterTemp.getPosition().equals(position))
                return false;
        }
        return true;
    }
}
