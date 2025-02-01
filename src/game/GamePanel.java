package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GamePanel extends JFrame {

    private Player player;
    private int X; // Coordinate x dei giocatori
    private int Y; // Coordinate y dei giocatori

    public GamePanel() {
        // ------------------------------ Default -----------------------------
        this.setTitle("Pong"); // Titolo del frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiusura della app
        this.setLayout(new BorderLayout());
        this.setSize(683, 384); // Grandezza del frame
        setLocationRelativeTo(null);  // Centra la finestra
        ImageIcon image = new ImageIcon("./img/icona.png"); // Crea una icona Img
        this.setIconImage(image.getImage());

        // --------------------------------------------------------------------
        // ---------------------------- Aesthetics ----------------------------
        this.getContentPane().setBackground(Color.decode("#707070"));
        // --------------------------------------------------------------------
        // ------------------------------- Game -------------------------------
        // Imposta il player a destra
        X = this.getWidth();
        Y = (this.getHeight()/2)-35; // Prende l'altezza dello schermo e lo posiziona alla metà
        player = new Player(X, Y, 20, 100, "Player");

        // Movimento Player
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int dy = 0;

                // Usa i tasti su e giù per muovere il giocatore
                if (keyCode == KeyEvent.VK_UP) {
                    dy = -5; // Muovi su
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    dy = 5;  // Muovi giù
                }

                // Chiama il metodo move passando l'altezza corrente della finestra
                player.move(dy, getHeight());
                repaint();  // Rendi visibile il movimento del giocatore
            }
        });

        // Listener per il ridimensionamento della finestra
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int X = getWidth() - 50;
                player.setX(X);
                repaint();
            }
        });
        // --------------------------------------------------------------------

        this.setVisible(true); // Mostra il frame
    }

    // Metodo paint per disegnare il giocatore
    @Override
    public void paint(Graphics g) {
        super.paint(g);// Chiama il paint originale di JFrame per il rendering del contenuto base
        player.draw(g);// Disegna il giocatore
    }
}
