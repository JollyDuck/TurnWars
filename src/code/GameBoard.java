package code;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
	int lineSpacing;
	public static Tile[][] tiles;
	public static Moveable[][] units;
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char NONE = ' ';
	public static boolean drawMoveable;
	Image sprites;
	ResHandle res;
	Point topLeft;
	Point mousePos;
	Footman man;

	public GameBoard(int width, int height) {

		this.width = width;
		this.height = height;
		lineSpacing = 32;
		res = new ResHandle();
		topLeft = new Point();
		mousePos = new Point();
		man = new Footman();
		drawMoveable = false;

		// box is an array that stores the positions of the units.
		tiles = new Tile[3200 / lineSpacing][height / lineSpacing];
		units = new Moveable[3200 / lineSpacing][height / lineSpacing];

		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[x].length; y++) {
				double i = Math.random();
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
		units[5][5] = man;
		man.myImage = res.redTank;
		man.setPosition(5, 5, lineSpacing);

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

	private void printMovesLeft(Graphics g, Moveable entity) {
		int max = entity.currentMove * 2 + 1;
		Tile[][] movesLeft = new Tile[max][max];
		for (int x = 0; x < max; x++) {
			for (int y = 0; y < max; y++) {

				MoveLeftTile r = new MoveLeftTile();
				movesLeft[x][y] = r;
				r.setMyImage(res.moveBox);
				r.setPosition((entity.myPosition.x / lineSpacing)
						- entity.currentMove + x,
						(entity.myPosition.y / lineSpacing)
								- entity.currentMove + y, lineSpacing);
				if (movesLeft[x][y] != null)
					movesLeft[x][y].printMe(alphaMe(g), topLeft);
			}
		}
	}

	private void printUnits(Graphics g) {
		for (int x = 0; x < units.length; x++) {
			for (int y = 0; y < units[x].length; y++) {
				if (units[x][y] != null)
					units[x][y].printMe(g, topLeft);
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

	/**
	 * Returns a Graphics g at half alpha.
	 * 
	 * @param g
	 *            Graphics g
	 * @return g2d
	 */
	private Graphics2D alphaMe(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.5f));
		return g2d;
	}

	private void checkDrawMoveable(Graphics g, int mousePosX, int mousePosY) {
		if (units[(mousePosX - topLeft.x) / lineSpacing][(mousePosY - topLeft.y)
				/ lineSpacing] != null) {
			Moveable entity = units[(mousePosX - topLeft.x) / lineSpacing][(mousePosY - topLeft.y)
					/ lineSpacing];
			System.out.println(entity);
			printMovesLeft(g, entity);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		printTiles(g);
		printUnits(g);
		checkDrawMoveable(g, mousePos.x, mousePos.y);
	}

}
