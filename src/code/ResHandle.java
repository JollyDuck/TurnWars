package code;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResHandle {
	public Image summerGrass, summerRock, summerTree, blueTank, redTank,
			moveBox;

	public ResHandle() {
		loadImages();

	}

	public Image imageReturn(int i) {
		switch (i) {
		case 1:
			return summerGrass;
		case 2:
			return summerTree;
		case 3:
			return summerRock;
		default:
			return summerRock;
		}
	}

	private void loadImages() {
		// Terrain
		try {
			summerGrass = ImageIO.read(GameBoard.class
					.getResource("/res/summerGrass.png"));
			System.out.println("win loading summerGrass");
		} catch (IOException e) {
			System.out.println("fail loading summerGrass");
		}
		try {
			summerTree = ImageIO.read(GameBoard.class
					.getResource("/res/summerTree.png"));
			System.out.println("win loading summerTree");
		} catch (IOException e) {
			System.out.println("fail loading summerTree");
		}
		try {
			summerRock = ImageIO.read(GameBoard.class
					.getResource("/res/summerRock.png"));
			System.out.println("win loading summerRock");
		} catch (IOException e) {
			System.out.println("fail loading summerRock");
		}

		// Movespace
		try {
			moveBox = ImageIO.read(GameBoard.class
					.getResource("/res/moveLeft.png"));
			System.out.println("win loading moveLeft");
		} catch (IOException e) {
			System.out.println("fail loading moveLeft");
		}

		// Units
		try {
			blueTank = ImageIO.read(GameBoard.class
					.getResource("/res/blueTank.png"));
			System.out.println("win loading blueTank");
		} catch (IOException e) {
			System.out.println("fail loading blueTank");
		}
		try {
			redTank = ImageIO.read(GameBoard.class
					.getResource("/res/redTank.png"));
			System.out.println("win loading redTank");
		} catch (IOException e) {
			System.out.println("fail loading redTank");
		}
	}
}
