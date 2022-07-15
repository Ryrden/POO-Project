package main.gamePhase;

import main.model.Player;

public class HudBar  {
    static HudBar hudBar = null;

    private int life = 5;
    private int points = -1;

    private HudBar() {
    }

    public static HudBar getInstance() {
        if (hudBar == null) {
            hudBar = new HudBar();
        }
        return hudBar;
    }

    public void updatePoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public int getLife() {
        return life;
    }

    public void updateLife(int life) {
        this.life = life;
    }
}
