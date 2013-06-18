package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Printable {
	protected Image myImage;
	protected Point myPosition;
	protected int imageID;
	
	public void createPosition(){
		myPosition = new Point();
	}
	
	public void setMyImage(Image i){
		myImage = i;
	}

	public void printMe(Graphics g, Point topLeft){
		g.drawImage(myImage, myPosition.x+topLeft.x, myPosition.y+topLeft.y, null);
	}
	public void setPosition(int x, int y){
		myPosition.x=x;
		myPosition.y=y;
	}
}
