package main.gamePhase;

import main.model.Collectable;
import main.model.GameElement;
import main.model.collectable.JavaCoffe;
import main.model.enemys.CPlusPlus;
import main.model.enemys.Haskell;
import main.model.scene.Chest;
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
                {1, 1}, {5, 3}, {5, 7}
        };
        for (int[] enemyPosition : enemyArray) {
            obstacles.add(new CPlusPlus(enemyPosition[0], enemyPosition[1], "caracterSprites/C++.png"));
        }

        int[][] collectableArray = {
                {1, 0}, {0, 7}, {10, 7}, {10, 8}, {0, 10}
        };
        for (int[] collectablePosition : collectableArray) {
            obstacles.add(new JavaCoffe(collectablePosition[0], collectablePosition[1], "collectableSprites/java3DCoffe.png"));
        }
        obstacles.add(new Chest(2, 5, ""));

        ArrayList<GameElement> enemies = new ArrayList<>();
        ArrayList<GameElement> collectables = new ArrayList<>();
        ArrayList<GameElement> finalChest = new ArrayList<>();

        return new
                GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest);
    }

    public static GamePhase Phase2() {
        ArrayList<GameElement> obstacles = new ArrayList<>();

        int[][] wallPositionsArray = {
                {9, 1},
                {1, 2}, {7, 2},
                {1, 3}, {3, 3}, {5, 3},
                {0, 4}, {9, 4},
                {3, 5}, {8, 5},
                {2, 7}, {4, 7}, {5, 7}, {7, 7},
                {1, 9},
                {0, 10}, {3, 10}, {8, 10},
        };
        for (int[] wallPosition : wallPositionsArray) {
            obstacles.add(new Wall(wallPosition[1], wallPosition[0], "scenerySprites/obstacle1.png"));
        }
        int[][] bushPositionsArray = {
                {1, 0}, {3, 0}, {4, 0}, {5, 0}, {7, 0},
                {3, 1}, {5, 1}, {7, 1},
                {9, 2},
                {9, 3}, {7, 3},
                {1, 4}, {5, 4},
                {2, 5}, {4, 5}, {6, 5},
                {0, 6}, {10, 6},
                {3, 7}, {6, 7}, {8, 7}, {9, 7},
                {7, 8},
                {3, 9}, {5, 9}, {6, 9}, {9, 9},
                {1, 10}, {9, 10}
        };
        for (int[] Position : bushPositionsArray) {
            obstacles.add(new Wall(Position[1], Position[0], "scenerySprites/obstacle2.png"));
        }

        ArrayList<GameElement> enemies = new ArrayList<>();

        int[][] enemyPositionsArray = {
                {4, 4}, {2, 4}
        };

        for (int[] Position : enemyPositionsArray) {
            enemies.add(new Haskell(Position[1], Position[0], "caracterSprites/Haskell.png"));
        }
        enemies.add(new CPlusPlus(6, 4, "caracterSprites/C++.png"));

        ArrayList<GameElement> collectables = new ArrayList<>();
        int[][] collectablesPositionsArray = {
                {2, 0}, {6, 0},
                {0, 5}, {5, 5},
                {10, 7},
                {6, 8},
                {0, 9},
        };

        for (int[] Position : collectablesPositionsArray) {
            collectables.add(new Collectable(Position[1], Position[0], "collectableSprites/java3DCoffe.png"));
        }


        ArrayList<GameElement> finalChest = new ArrayList<>();
        finalChest.add(new Chest(0, 0, ""));

        return new GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest);
    }

    public static GamePhase Phase3() {
        ArrayList<GameElement> obstacles = new ArrayList<>();
        int[][] wallPositionsArray = {
                {3, 0}, {8, 0},
                {3, 1}, {4, 1}, {7, 1}, {8, 1},
                {1, 3}, {2, 3}, {3, 3},
                {4, 4},
                {9, 7},
                {8, 8},
                {8, 9},
        };
        for (int[] wallPosition : wallPositionsArray) {
            obstacles.add(new Wall(wallPosition[1], wallPosition[0], "scenerySprites/obstacle1.png"));
        }
        int[][] bushPositionsArray = {
                {5, 0}, {6, 0},
                {6, 1},
                {0, 3}, {4, 3}, {5, 3}, {6, 3}, {8, 3}, {9, 3},
                {5, 4},
                {9, 7},
                {5, 8},
                {4, 9},
                {8, 10},
        };
        for (int[] Position : bushPositionsArray) {
            obstacles.add(new Wall(Position[1], Position[0], "scenerySprites/obstacle2.png"));
        }

        ArrayList<GameElement> enemies = new ArrayList<>();

        enemies.add(new CPlusPlus(0, 0, "bichinho.png"));

        ArrayList<GameElement> collectables = new ArrayList<>();
        int[][] collectablesPositionsArray = {
                {7, 0},
                {3, 2},
                {0, 4}, {2, 4},
                {1, 7},
                {9, 8},
        };

        for (int[] Position : collectablesPositionsArray) {
            enemies.add(new Collectable(Position[1], Position[0], "temer.png"));
        }


        ArrayList<GameElement> finalChest = new ArrayList<>();

        return new GamePhase(
                obstacles,
                enemies,
                collectables,
                finalChest
        );
    }
}