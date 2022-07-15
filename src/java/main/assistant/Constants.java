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
    public static final int RESOLUTION = 12;
    public static final int PERIOD = 80;
    public static final String PATH = File.separator + "imgs" + File.separator;
    public static final int TIMER_BOMB = 10;
}
