package userinterface;

import java.awt.event.KeyEvent;

public class InputManager {// nhận diện phím vào
	public void processKeyPressed(int keyCode) {
		switch(keyCode) {
		
			case KeyEvent.VK_UP: 
				System.out.println("You press UP");
				System.out.println("You release UP");
				break;
			case KeyEvent.VK_DOWN: break;
			case KeyEvent.VK_LEFT: break;
			case KeyEvent.VK_RIGHT: break;
			case KeyEvent.VK_A: break; 
		}
	}
}
