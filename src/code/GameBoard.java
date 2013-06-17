package code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameBoard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
	int lineSpacing;
	public static char[][] box;
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char NONE = ' ';
	Graphics g;
	Image sprites;

	public GameBoard(int width, int height) {

		this.width = width;
		this.height = height;
		lineSpacing = 30;
		
		loadImages();

		box = new char[width / lineSpacing][height / lineSpacing];
		for (int x = 0; x < box.length; x++) {
			for (int y = 0; y < box[x].length; y++) {
				box[x][y] = NONE;
			}
		}
		box[2][0] = X;
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);

	}
	
	public void loadImages(){
		// Start
		java.net.URL imageURL = GameBoard.class
				.getResource("/res/miw_sprites.png");
		if (imageURL != null) {
			try {
				sprites = ImageIO.read(imageURL);
				System.out.println("win");
			} catch (IOException e) {
				System.out.println("fail");
			}
		}
		
	}

	public void paintComponent(Graphics g) {
		this.g = g;
		super.paintComponent(g);
		for (int x = lineSpacing; x <= width; x = x + lineSpacing) {
			g.drawLine(x, 0, x, height);
			g.drawLine(0, x, width, x);
		}
		g.drawImage(sprites, 50, 50, null);

	}

}
