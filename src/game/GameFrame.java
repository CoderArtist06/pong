package game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        GamePanel gamePanel = new GamePanel();
        gamePanel.setFocusable(true);
        
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
