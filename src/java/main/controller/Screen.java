package main.controller;

import main.assistant.Constants;
import main.assistant.Drawing;
import main.gamePhase.GamePhase;
import main.gamePhase.Phases;
import main.model.GameElement;
import main.model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Screen extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Player player;
    private ArrayList<GameElement> characterArray;
    private final GameController gameController = new GameController();
    private Graphics graphics;

    /**
     * Creates new form tabuleiro
     */
    public Screen() {
        Drawing.setScene(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Constants.RESOLUTION * Constants.CELL_SIDE + getInsets().left + getInsets().right,
                Constants.RESOLUTION * Constants.CELL_SIDE + getInsets().top + getInsets().bottom);

        this.setTitle("Java Battle Survivors - POO Project");
        characterArray = new ArrayList<>(100);

        /*Cria e adiciona personagens*/

        loadPhase(1);
    }

    public void loadPhase(int phaseNumber) {
        this.clearCharacters();

        player = new Player(0, 7, "caracterSprites/normalDuke.png");
        this.addCharacter_(player);

        GamePhase phase;
        switch (phaseNumber){
            case 2:
                phase = Phases.Phase2();
                break;
            default:
                phase = Phases.Phase1();
                break;
        }

        for (GameElement gameElement : phase.getObstacle()) {
            this.addCharacter_(gameElement);
        }

        for (GameElement collectible : phase.getCollectibles()) {
            this.addCharacter_(collectible);
        }

        for (GameElement enemy : phase.getEnemies()) {
            this.addCharacter_(enemy);
        }

        for (GameElement gameElement : phase.getFinalChest()) {
            this.addCharacter_(gameElement);
        }
    }


    public void addCharacter_(GameElement aCharacter) {
        characterArray.add(aCharacter);
    }

    public void removeCharacter(GameElement aCharacter) {
        characterArray.remove(aCharacter);
    }

    public void clearCharacters() {
        characterArray.clear();
    }

    public Graphics getGraphicsBuffer() {
        return graphics;
    }

    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        graphics = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        drawBackground("scenerySprites/background.png");
        if (!this.characterArray.isEmpty()) {
            this.gameController.drawAll(characterArray);
            this.gameController.processAll(characterArray);
        }

        g.dispose();
        graphics.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    private void drawBackground(String backgroundPath) {
        for (int i = 0; i < Constants.RESOLUTION; i++) {
            for (int j = 0; j < Constants.RESOLUTION; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new File(".").getCanonicalPath() + Constants.PATH + backgroundPath);
                    graphics.drawImage(newImage,
                            j * Constants.CELL_SIDE, i * Constants.CELL_SIDE, Constants.CELL_SIDE, Constants.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Constants.PERIOD);
    }

    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_C) {
            this.clearCharacters();
        } else if (key.getKeyCode() == KeyEvent.VK_L) {
            try {
                File fileData = new File("c:\\temp\\POO.zip");
                FileInputStream fileOut = new FileInputStream(fileData);
                GZIPInputStream compactor = new GZIPInputStream(fileOut);
                ObjectInputStream serializer = new ObjectInputStream(compactor);
                this.characterArray = (ArrayList<GameElement>) serializer.readObject();
                this.player = (Player) this.characterArray.get(0);
                serializer.close();
            } catch (Exception ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (key.getKeyCode() == KeyEvent.VK_S) {
            try {
                File fileData = new File("c:\\temp\\POO.zip");
                fileData.createNewFile();
                FileOutputStream fileOut = new FileOutputStream(fileData);
                GZIPOutputStream compactor = new GZIPOutputStream(fileOut);
                ObjectOutputStream serializer = new ObjectOutputStream(compactor);
                serializer.writeObject(this.characterArray);
                serializer.flush();
                serializer.close();
            } catch (IOException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (key.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp();
        } else if (key.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveDown();
        } else if (key.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft();
        } else if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight();
        }
        if (!gameController.isValidPosition(this.characterArray, player.getPosition())) {
            player.backToLastPosition();
        }

        this.setTitle("-> Cell: " + (player.getPosition().getPosX()) + ", "
                + (player.getPosition().getPosY()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado
         int x = characterArray.getX();
         int y = characterArray.getY();

         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Constants.CELL_SIDE) + ", " + (x/Constants.CELL_SIDE));

         this.player.getPosition().setPosition(y/Constants.CELL_SIDE, x/Constants.CELL_SIDE);
         */
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this codcharacterArray. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2015-1 - Adventures of lolo");
        setAutoRequestFocus(false);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
