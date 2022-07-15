package main.gamePhase;

import main.model.GameElement;

import java.util.ArrayList;

public class GamePhase {
    private ArrayList<GameElement> obstacle;
    private ArrayList<GameElement> enemies;
    private ArrayList<GameElement> collectibles;
    private ArrayList<GameElement> finalChest;
    private final boolean isFinalChestVisible = false;

    public GamePhase(ArrayList<GameElement> obstacle, ArrayList<GameElement> enemies, ArrayList<GameElement> collectibles, ArrayList<GameElement> finalChest) {
        this.obstacle = obstacle;
        this.enemies = enemies;
        this.collectibles = collectibles;
        this.finalChest = finalChest;
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

    public boolean isFinalChestVisible() {
        return isFinalChestVisible;
    }
}
