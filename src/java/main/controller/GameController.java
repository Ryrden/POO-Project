package main.controller;

import main.assistant.Position;
import main.model.GameElement;
import main.model.Player;

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
        for (int i = 1; i < elementsArray.size(); i++) {
            currentElement = elementsArray.get(i);
            if (player.getPosition().equals(currentElement.getPosition())) {
                if (currentElement.isCollectable()) {
                    elementsArray.remove(currentElement);
                    player.gainOnePoint();
                }
                if (currentElement.isPassable() && currentElement.isMortal()) {
                    elementsArray.remove(currentElement);
                }
            }
        }
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
