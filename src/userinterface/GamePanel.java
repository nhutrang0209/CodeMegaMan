package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable, KeyListener{//area to draw game, contain features in game, input...; subfr 
	
	private Thread thread;
	
	private boolean isRunning;
	
	private InputManager inputManager;
	
	
	public GamePanel() {
		inputManager = new InputManager();
	}
	
	@Override
	public void paint(Graphics g) {//
		
		g.setColor(Color.green);
		g.fillRect(0,0,GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT); //fill màn hình
	}

	public void startGame() {
		if (thread==null) {
			isRunning = true; 
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() {

		long FPS = 80;
		long period = 1000*1000000/FPS; //(ns)rest time of frames
		long beginTime;
		long sleepTime;
		
		int a = 1;
		
		beginTime = System.nanoTime();
		
		
		while(isRunning) {
			System.out.println("a = "+a);
			
			long deltaTime = System.nanoTime() - beginTime; // thời gian update
			sleepTime = period - deltaTime;
			
			
			try {
				if (sleepTime >0) Thread.sleep(sleepTime);
				else Thread.sleep(period/2); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//nhấn phím
		inputManager.processKeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {//thả phím ra
		inputManager.processKeyPressed(e.getKeyCode());
	}
}
