package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Printable {
	protected Image myImage;
	protected Point myPosition;
	
	public void createPosition(){
		myPosition = new Point();
	}

	public void printMe(Graphics g){
		g.drawImage(myImage, myPosition.x, myPosition.y, null);
	}
	public void setPosition(int x, int y){
		myPosition.x=x;
		myPosition.y=y;
	}
}
