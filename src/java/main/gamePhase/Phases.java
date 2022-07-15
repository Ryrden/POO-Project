package main.gamePhase;

import main.model.CharacterExample;
import main.model.EnemyExample;
import main.model.GameElement;

import java.util.ArrayList;

public class Phases {
    public static GamePhase Phase1() {

        ArrayList<GameElement> obstacles = new ArrayList<GameElement>();

        CharacterExample bV = new CharacterExample("scenerySprites/obstacle1.png");
        bV.setPosition(4, 4);
        obstacles.add(bV);

        ArrayList<GameElement> enemies = new ArrayList<GameElement>();
        ArrayList<GameElement> collectables = new ArrayList<GameElement>();
        ArrayList<GameElement> finalChest = new ArrayList<GameElement>();

        GamePhase phase = new GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest
        );
        return phase;
    }
}
