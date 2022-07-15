package main.controller;

import main.assistant.Constants;
import main.assistant.Drawing;
import main.model.GameElement;
import main.model.Player;
import main.model.CharacterExample;
import main.model.EnemyExample;

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
    private GameController gameController = new GameController();
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
        player = new Player("caracterSprites/java.png");
        player.setPosition(0, 7);
        this.addCharacter_(player);

        CharacterExample characterExample = new CharacterExample("caracterSprites/python.png");
        characterExample.setPosition(3, 3);
        this.addCharacter_(characterExample);

        CharacterExample characterExampleH2 = new CharacterExample("caracterSprites/C++.png");
        characterExampleH2.setPosition(6, 6);
        this.addCharacter_(characterExampleH2);

        CharacterExample characterExampleH3 = new CharacterExample("caracterSprites/Fortran.png");
        characterExampleH3.setPosition(2, 9);
        this.addCharacter_(characterExampleH3);

        EnemyExample bV = new EnemyExample("caracterSprites/Haskell.png");
        bV.setPosition(9, 1);
        this.addCharacter_(bV);
    }


    public void addCharacter_(GameElement aCharacter) {
        characterArray.add(aCharacter);
    }

    public void removeCharacter(GameElement aCharacter) {
        characterArray.remove(aCharacter);
    }

    public Graphics getGraphicsBuffer() {
        return graphics;
    }

    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        graphics = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        drawBackground();
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

    private void drawBackground() {
        for (int i = 0; i < Constants.RESOLUTION; i++) {
            for (int j = 0; j < Constants.RESOLUTION; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new File(".").getCanonicalPath() + Constants.PATH + "bricks.png");
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
            this.characterArray.clear();
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

        this.setTitle("-> Cell: " + (player.getPosition().getPosY()) + ", "
                + (player.getPosition().getPosX()));

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
