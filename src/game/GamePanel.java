package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Player player;
    private Ball ball;
    private KeyHandler keyHandler;
    private Thread gameThread;
    private final int FPS = 60;

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();
        setBackground(Color.BLACK);

        keyHandler = new KeyHandler(); // Gestore input player
        addKeyListener(keyHandler);   // Aggiungiamo il KeyListener

        player = new Player(0, 0, 20, 100, "Player");
        player.setKeyHandler(keyHandler); // Passiamo il KeyHandler al Player

        ball = new Ball(getWidth() / 2, getHeight() / 2);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int X = getWidth() - 50;
                int Yplayer = (getHeight() / 2) - 35;
                player.setX(X);
                player.setY(Yplayer);

                // Centra la pallina quando la finestra viene ridimensionata
                int centerX = (getWidth() / 2) - (ball.getRadius() / 2);
                int centerY = (getHeight() / 2) - (ball.getRadius() / 2);
                ball.setX(centerX);
                ball.setY(centerY);
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
        ball.update(getWidth(), getHeight()); // La pallina si aggiorna ogni frame
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        ball.draw(g); // Disegna la pallina
    }
}
