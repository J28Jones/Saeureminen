package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
		
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH =640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running=false; 
	private Handler handler;
	 /*
	  * 
	  * Constructor
	  * 
	  * 
	  * */
	
	public Game () {
		new Window(WIDTH, HEIGHT, "SäureminenTycoon",this);
		handler = new Handler(); 
	}
	
	/*
	 * functions
	 * */
	//Starts the game sets running on true. 
	public synchronized void start() {
		thread= new Thread(this);
		thread.start();
		running=true;
	}
	//Stops the game and prints an error 
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*runs the Game 
	 *DO NOT TOUCH* 
	 * */
	public void run () {
		long lastTime = System.nanoTime();
		double amountofTicks=60.0; 
		double ns = 1000000000/ amountofTicks;
		double delta=0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			//checks if enough time has passed to perform a logic Tick
			while(delta >= 1) {
				step();
				delta--;
			}
			if (running)
				render();
			frames++;
			if(System.currentTimeMillis()-timer > 1000) {
				timer+=1000;
				System.out.println("Fps: "+frames);
				frames = 0; 
			}
		}
		stop();
	}
	/*updates the Graphics of the Game*/
	private void render() {
		BufferStrategy bs =this.getBufferStrategy();
		if (bs ==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	//performs a logical step of the game 
	private void step() {
		handler.step();
	}

	public static void main(String args[]) {
		new Game();
	}
}
