package main.assistant;

import java.io.File;

/**
 * @author Junio
 */
public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final int CELL_SIDE = 45;
    public static final int WIDTH_RESOLUTION = 12;
    public static final int HEIGHT_RESOLUTION = 11;
    public static final int PERIOD = 80;
    public static final String PATH = File.separator + "imgs" + File.separator;
    public static final int TIMER_BOMB = 10;

    public static final int RIGHT = 6;
    public static final int LEFT = 4;
    public static final int UP = 8;
    public static final int DOWN = 2;
}
