import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoard extends JPanel {

	int width, height;
	int lineSpacing;
	public static char[][] box;
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char NONE = ' ';
	Graphics g;
	Image sprites;

	public GameBoard(int width, int height) {

		this.width = width;
		this.height = height;
		lineSpacing = 30;
		try {
			sprites = ImageIO.read(new File("src/miw_sprites.png"));
			System.out.println("loaded successfuly");
		} catch (IOException e) {
			System.out.println("FAIL");
		}
		box = new char[width / lineSpacing][height / lineSpacing];
		for (int x = 0; x < box.length; x++) {
			for (int y = 0; y < box[x].length; y++) {
				box[x][y] = NONE;
			}
		}
		box[2][0] = X;
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.WHITE);

	}

	public void paintComponent(Graphics g) {
		this.g = g;
		super.paintComponent(g);
		for (int x = lineSpacing; x <= width; x = x + lineSpacing) {
			g.drawLine(x, 0, x, height);
			g.drawLine(0, x, width, x);
		}
		g.drawImage(sprites, 50, 50, null);
		
	}
	
	public void printClickedToBox(){
		g.drawLine(50, 50, 150, 150);
		
	}
}
