package main.gamePhase;

import main.model.GameElement;
import main.model.StaticObstacle;
import main.model.collectable.javaCoffe;
import main.model.enemys.CPlusPlus;
import main.model.scene.Grass;
import main.model.scene.Wall;

import java.util.ArrayList;

public class Phases {
    public static GamePhase Phase1() {

        ArrayList<GameElement> obstacles = new ArrayList<>();
        int[][] wallPositionsArray = {
                {0, 0}, {2, 0}, {9, 0}, {10, 0},
                {10, 3}, {9, 4}, {10, 4}, {9, 5},
                {1, 7}, {2, 7}, {2, 8}, {3, 8}, {9, 9}, {8, 10}};
        for (int[] wallPosition : wallPositionsArray) {
            obstacles.add(new Wall(wallPosition[0], wallPosition[1], "scenerySprites/obstacle1.png"));
        }

        int[][] grassPositionArray = {
                {3, 0}, {6, 0}, {7, 0}, {8, 0},
                {7, 1}, {8, 1}, {1, 2}, {2, 2},
                {1, 3}, {2, 3}, {10, 5}, {8, 6},
                {9, 6}, {10, 6}, {0, 8}, {1, 8},
                {0, 9}, {1, 9}, {2, 9}, {10, 9},
                {9, 10}, {10, 10}};
        for (int[] grassPosition : grassPositionArray) {
            obstacles.add(new Wall(grassPosition[0], grassPosition[1], "scenerySprites/obstacle2.png"));
        }

        int[][] grassBackgroundArray = {
                {4, 0}, {5, 0}, {5, 1},
                {6, 1}, {7, 9}, {8, 9},
                {5, 10}, {6, 10}, {7, 10}};
        for (int[] grassBackground : grassBackgroundArray) {
            obstacles.add(new Grass(grassBackground[0], grassBackground[1], "scenerySprites/backgroundAux.png"));
        }

        int[][] enemyArray = {
                {1,1},{5,3},{5,7}
        };
        for (int[] enemyPosition : enemyArray) {
            obstacles.add(new CPlusPlus(enemyPosition[0], enemyPosition[1], "caracterSprites/c++.png"));
        }

        int[][] collectableArray = {
                {1,0},{0,7},{10,7},{10,8},{0,10}
        };
        for (int[] collectablePosition : collectableArray) {
            obstacles.add(new javaCoffe(collectablePosition[0], collectablePosition[1], "collectableSprites/java3DCoffe.png"));
        }

        ArrayList<GameElement> enemies = new ArrayList<>();
        ArrayList<GameElement> collectables = new ArrayList<>();
        ArrayList<GameElement> finalChest = new ArrayList<>();

        return new
                GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest
        );
    }
}
