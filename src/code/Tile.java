package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Tile {
	protected Image tileImage;
	protected Point tilePosition;
	protected int tileType;

	/*
	 * Tile type 1: grass; Tile type 2: tree; Tile type 3: rocks;
	 */

	/**
	 * Loads the image in the given URL path.
	 * 
	 * @param s
	 *            The resource image URL i.e. "/res/miw_sprites.png"
	 * @return tileImage - the image found
	 * 
	 * @author James
	 */
	
	public void print(Graphics g){
		
	}
	
	public void tileImage(String s) {
		java.net.URL imageURL = GameBoard.class.getResource(s);
		try {
			tileImage = ImageIO.read(imageURL);
			System.out.println("win loading " + s);
		} catch (IOException e) {
			System.out.println("fail loading " + s);
		}
	}

	/**
	 * 
	 * @return an int based on how many move points needed to cross. Returns 300
	 *         if 'impassable'.
	 */
	public int movementCost(Tile t) {
		int type = t.tileType;
		switch (type) {
		case 1:
			return 1;
		case 2:
			return 2;
		default:
			return 300;
		}
	}
}
