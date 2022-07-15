package main.gamePhase;

import main.model.GameElement;
import main.model.StaticObstacle;
import main.model.scene.Wall;

import java.util.ArrayList;

public class Phases {
    public static GamePhase Phase1() {

        ArrayList<GameElement> obstacles = new ArrayList<GameElement>();

        StaticObstacle bV = new Wall(4, 4, "scenerySprites/obstacle1.png");
        obstacles.add(bV);

        ArrayList<GameElement> enemies = new ArrayList<GameElement>();
        ArrayList<GameElement> collectables = new ArrayList<GameElement>();
        ArrayList<GameElement> finalChest = new ArrayList<GameElement>();

        return new GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest
        );
    }
}
