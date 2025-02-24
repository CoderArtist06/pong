package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean upPressed, downPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    	
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            upPressed = true;
            // System.out.println("UP premuto");
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            downPressed = true;
            // System.out.println("DOWN premuto");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            upPressed = false;
            // System.out.println("UP rilasciato");
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            downPressed = false;
            // System.out.println("DOWN rilasciato");
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }
}
