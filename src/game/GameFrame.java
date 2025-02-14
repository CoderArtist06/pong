package game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        GamePanel gamePanel = new GamePanel();
        KeyHandler keyHandler = new KeyHandler();
        gamePanel.addKeyListener(keyHandler);
        gamePanel.setFocusable(true);

        // Passa il keyHandler al player
        Player player = new Player(0, 0, 20, 100, "Player");
        player.setKeyHandler(keyHandler);
        gamePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int X = gamePanel.getWidth() - 50;
                int Y = (gamePanel.getHeight() / 2) - 35;
                player.setX(X);
                player.setY(Y);
            }
        });
        
        setTitle("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(683, 384);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("./img/icona.png").getImage());
        setVisible(true);
        
        add(gamePanel);
        gamePanel.startGameThread();
    }
    
}
