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
	public static Tile[][] box;
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char NONE = ' ';
	Graphics g;
	Image sprites;

	public GameBoard(int width, int height) {

		this.width = width;
		this.height = height;
		lineSpacing = 32;

		loadImages();
		// box is an array that stores the positions of the units.
		box = new Tile[width / lineSpacing][height / lineSpacing];
		for (int x = 0; x < box.length; x++) {
			for (int y = 0; y < box[x].length; y++) {
				double i = Math.random();
				System.out.println(i);
				Tile r;
				if (i > 0.5) {
					r = new EmptyTile();
				} else
					r = new TreeTile();
				box[x][y] = r;
			}
		}
		box[2][0] = new RockTile();
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);

	}

	public void loadImages() {
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

	public void printBox(Graphics g) {
		for (int x = 0; x < box.length; x++) {
			for (int y = 0; y < box[x].length; y++) {
				g.drawString(Character.toString(box[x][y]),
						(x * lineSpacing) + 10, (y * lineSpacing) + 10);

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
		printBox(g);

	}

}
