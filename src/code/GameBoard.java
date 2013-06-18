package code;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class GameBoard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
	int lineSpacing;
	public static Tile[][] tiles;
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char NONE = ' ';
	Image sprites;
	ResHandle res;
	Point topLeft;
	float[] scales = { 1f, 1f, 1f, 0.5f };
	float[] offsets = new float[4];

	public GameBoard(int width, int height) {

		this.width = width;
		this.height = height;
		lineSpacing = 32;
		res = new ResHandle();
		topLeft = new Point();

		// box is an array that stores the positions of the units.
		tiles = new Tile[3200 / lineSpacing][height / lineSpacing];
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[x].length; y++) {
				double i = Math.random();
				System.out.println(i);
				Tile r;
				if (i > 0.5) {
					r = new EmptyTile();
				} else
					r = new TreeTile();
				tiles[x][y] = r;
				r.setPosition(x, y, lineSpacing);
				r.myImage = res.imageReturn(r.imageID);
			}
		}
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);

	}

	/**
	 * Calls the printTile function for every tile in tiles[][].
	 * 
	 * @param g
	 */
	private void printTiles(Graphics g) {
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[x].length; y++) {
				tiles[x][y].printMe(g, topLeft);
			}
		}
	}

	public void updateTopLeft(int dir) {
		switch (dir) {
		case 2:
			topLeft.y = topLeft.y + 32;
			break;
		case 4:
			topLeft.x = topLeft.x + 32;
			break;
		case 8:
			topLeft.y = topLeft.y - 32;
			break;
		case 6:
			topLeft.x = topLeft.x - 32;
		default:
			break;
		}
	}

	public Graphics2D alphaMe(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.5f));
		return g2d;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		printTiles(g);
		alphaMe(g).drawImage(res.moveBox, 0, 0, null);
	}

}
