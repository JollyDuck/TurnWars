package code;

public abstract class Tile extends Printable {

	public void setPosition(int x, int y, int lineSpacing) {
		myPosition.x = x * lineSpacing;
		myPosition.y = y * lineSpacing;
	}
	/**
	 * 
	 * @return an int based on how many move points needed to cross. Returns 300
	 *         if 'impassable'.
	 */
	public int movementCost(Tile t) {
		int type = t.imageID;
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
