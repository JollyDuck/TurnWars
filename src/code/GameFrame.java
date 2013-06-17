package code;
import javax.swing.*;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameTable gTable;

	public GameFrame( String title ) {
	
		super( title );
		gTable = new GameTable();
		add( gTable );
	}
	
	public static void main( String[] args ) {
	
		GameFrame gFrame = new GameFrame("TestFrame");
		gFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gFrame.pack();
		gFrame.setVisible(true);
		gFrame.setResizable(false);
	}
}
