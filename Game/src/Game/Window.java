package Game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Creates the  Window for the Game */
	public Window (int witdh, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(witdh, height));
		frame.setMaximumSize(new Dimension(witdh, height));
		frame.setMinimumSize(new Dimension(witdh, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Window starts at Center
		frame.add(game); // adds Game into the Frame
		frame.setVisible(true);
		game.start();
	}


}
