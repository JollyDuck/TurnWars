package code;

import java.awt.Point;

public class RockTile extends Tile {
	public RockTile() {
		tileType = 3;
		tileImage("/res/SummerRock.png");
		tilePosition = new Point();
	}
}
