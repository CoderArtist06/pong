package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x, y, width, height;
    private String name;
    private final int speed = 8; // Velocità aumentata
    private KeyHandler keyHandler;

    public Player(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public void setKeyHandler(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    public void update(int panelHeight) {
        if (keyHandler != null) {
            if (keyHandler.isUpPressed() && y > 0) {
                y -= speed;
            }
            if (keyHandler.isDownPressed() && y + height < panelHeight) {
                y += speed;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
