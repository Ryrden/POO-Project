package main.gamePhase;

import main.model.GameElement;

import java.util.ArrayList;

public abstract class GamePhase {
    private ArrayList<GameElement> obstacle;
    private ArrayList<GameElement> enemys;
    private ArrayList<GameElement> collectibles;
    private ArrayList<GameElement> finalChest;
    private final boolean isFinalChestVisible = false;

    public GamePhase(ArrayList<GameElement> obstacle, ArrayList<GameElement> enemys, ArrayList<GameElement> collectibles, ArrayList<GameElement> finalChest) {
        this.obstacle = obstacle;
        this.enemys = enemys;
        this.collectibles = collectibles;
        this.finalChest = finalChest;
    }

    public abstract void drawPhase();
    public

    public ArrayList<GameElement> getObstacle() {
        return obstacle;
    }

    public ArrayList<GameElement> getEnemys() {
        return enemys;
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
