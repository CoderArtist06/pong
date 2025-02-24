package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int x, y;
    private int dx = 4, dy = 4;
    private int radius = 15;

    public Ball(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update(int panelWidth, int panelHeight) {
        // Movimento
        x += dx;
        y += dy;

        // Collisione con i bordi dello schermo
        if (x <= 0 || x >= panelWidth - radius) dx = -dx;
        if (y <= 0 || y >= panelHeight - radius) dy = -dy;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, radius, radius);
    }

    // Getter e Setter (se servono)
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getRadius() { return radius; }
}
