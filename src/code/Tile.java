package code;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Tile extends Printable {
	protected Image tileImage;
	protected int tileType;
	
	
	public void setPosition(int x, int y, int lineSpacing){
		myPosition.x = x*lineSpacing;
		myPosition.y = y*lineSpacing;
	}

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
	
	public void printTile(Graphics g){
		g.drawImage(tileImage, myPosition.x, myPosition.y, null);
	}
	
	public void tileImage(Image i){
		tileImage = i;
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
