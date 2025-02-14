package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Player player;
    private KeyHandler keyHandler;
    private Thread gameThread;
    private final int FPS = 60;

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();
        setBackground(Color.BLACK);

        keyHandler = new KeyHandler(); // Creiamo il gestore input
        addKeyListener(keyHandler);   // Aggiungiamo il KeyListener

        player = new Player(0, 0, 20, 100, "Player");
        player.setKeyHandler(keyHandler); // Passiamo il KeyHandler al Player

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int X = getWidth() - 50;
                int Y = (getHeight() / 2) - 35;
                player.setX(X);
                player.setY(Y);
            }
        });
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = (nextDrawTime - System.nanoTime()) / 1000000;
                if (remainingTime > 0) {
                    Thread.sleep((long) remainingTime);
                }
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update(getHeight()); // Il player si aggiorna ogni frame
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}
