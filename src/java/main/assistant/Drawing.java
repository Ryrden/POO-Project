package main.assistant;

import main.controller.Screen;

import java.io.Serializable;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Drawing implements Serializable {
    static Screen scene;
    public static void setScene(Screen aScene) {
        scene = aScene;
    }

    public static Screen getScene() {
        return scene;
    }

    public static Graphics getScreenGraphics() {
        return scene.getGraphicsBuffer();
    }

    public static void draw(ImageIcon iImage, int posX, int posY) {
        iImage.paintIcon(scene,getScreenGraphics(),posY * Constants.CELL_SIDE, posX * Constants.CELL_SIDE);
    }
}
