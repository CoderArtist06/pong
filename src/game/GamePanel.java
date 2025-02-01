package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private Player player;

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();
        setBackground(Color.BLACK); // Imposta lo sfondo
        
        // Inizializzazione giocatore con posizione predefinita (aggiornata dopo il resize)
        player = new Player(0, 0, 20, 100, "Player");

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int dy = 0;

                if (keyCode == KeyEvent.VK_UP) {
                    dy = -5;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    dy = 5;
                }

                player.move(dy, getHeight());
                repaint();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int X = getWidth() - 50; // Posiziona il player a destra
                int Y = (getHeight() / 2) - 35;
                player.setX(X);
                player.setY(Y);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}
