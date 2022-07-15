package main.gamePhase;

import main.model.GameElement;
import main.model.HudBarScenery;

import java.util.ArrayList;

public class GamePhase {
    private ArrayList<GameElement> obstacle;
    private ArrayList<GameElement> enemies;
    private ArrayList<GameElement> collectibles;
    private ArrayList<GameElement> finalChest;
    private ArrayList<GameElement> hudBar;
    private final boolean isFinalChestVisible = false;

    public GamePhase(ArrayList<GameElement> obstacle, ArrayList<GameElement> enemies, ArrayList<GameElement> collectibles, ArrayList<GameElement> finalChest) {
        this.obstacle = obstacle;
        this.enemies = enemies;
        this.collectibles = collectibles;
        this.finalChest = finalChest;
        this.hudBar = new ArrayList<>();
        for (int line = 0; line <= 10; line++) {
            if (line == 1)
                hudBar.add(new HudBarScenery(line, 11, "hudBar/heart.png"));
            if (line == 4)
                hudBar.add(new HudBarScenery(line, 11, "hudBar/unglyJavaLogo.png"));
            else
                hudBar.add(new HudBarScenery(line, 11, "hudBar/blackBackground.png"));
        }
    }

    public ArrayList<GameElement> getObstacle() {
        return obstacle;
    }

    public ArrayList<GameElement> getEnemies() {
        return enemies;
    }

    public ArrayList<GameElement> getCollectibles() {
        return collectibles;
    }

    public ArrayList<GameElement> getFinalChest() {
        return finalChest;
    }

    public ArrayList<GameElement> getHudBar() {
        return hudBar;
    }

    public boolean isFinalChestVisible() {
        return isFinalChestVisible;
    }
}
