package main.controller;

import main.assistant.Position;
import main.model.GameElement;
import main.model.Player;

import java.util.ArrayList;

public class GameController {
    public void drawAll(ArrayList<GameElement> characterArrayList) {
        for (GameElement character_ : characterArrayList) {
            character_.autoDraw();
        }
    }

    public void processAll(ArrayList<GameElement> characterArrayList) {
        Player player = (Player) characterArrayList.get(0);
        GameElement characterTemp;
        for (int i = 1; i < characterArrayList.size(); i++) {
            characterTemp = characterArrayList.get(i);
            if (characterTemp.isPassable() && player.getPosition().equals(characterTemp.getPosition()))
                characterArrayList.remove(characterTemp);
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
