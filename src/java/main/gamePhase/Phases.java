package main.gamePhase;

import main.model.GameElement;
import main.model.StaticObstacle;
import main.model.scene.Wall;

import java.util.ArrayList;

public class Phases {
    public static GamePhase Phase1() {

        ArrayList<GameElement> obstacles = new ArrayList<>();
        int[][] wallPositionsArray = {
                {0, 0}, {0, 2}, {0, 10}, {0, 11},
                {3, 11}, {4, 10}, {4, 11}, {5, 10},
                {7,1},{7,2},{8,2},{8,3},{9,10},{10,9}};
        for (int[] wallPosition : wallPositionsArray) {
            obstacles.add(new Wall(wallPosition[1], wallPosition[0], "scenerySprites/obstacle1.png"));
        }

        ArrayList<GameElement> enemies = new ArrayList<>();
        ArrayList<GameElement> collectables = new ArrayList<>();
        ArrayList<GameElement> finalChest = new ArrayList<>();

        return new GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest
        );
    }
}
