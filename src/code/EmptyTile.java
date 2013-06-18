package code;

import java.awt.Point;

public class EmptyTile extends Tile{
	public EmptyTile(){
		tileType=1;
		tileImage("/res/SummerGrass.png");
		tilePosition = new Point();
	}

}
