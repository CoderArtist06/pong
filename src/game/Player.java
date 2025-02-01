package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x, y, width, height;
	private String name;

	public Player(int x, int y, int width, int height, String name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	}
	
	public void draw(Graphics g) { 
		g.setColor(Color.WHITE); 
		g.fillRect(x, y, width, height); 
	}
	
	// Metodi per aggiornare la posizione del giocatore 
	public void move(int dy, int screenHeight) {
        // Calcola i limiti superiori e inferiori in base all'altezza della finestra
        int minY = 30;  // Limite superiore (0 pixel)
        int maxY = screenHeight - height;  // Limite inferiore (altezza della finestra meno l'altezza del giocatore)

        // Aggiorna la posizione solo se non esce dai limiti
        if (y + dy >= minY && y + dy <= maxY) {
            y += dy;  // Muovi solo se dentro i limiti
        }
    }

	// Getter e setter per le proprietà del giocatore
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
