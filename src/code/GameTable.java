package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameTable extends JPanel implements ActionListener, ItemListener,
		MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameBoard gBoard;
	JTextArea tArea;
	JButton testB, leftB, rightB;
	JScrollPane sPane;

	int width = 1024;
	int height = 600;

	public GameTable() {

		setPreferredSize(new Dimension(width, height));
		createGUI();
	}

	private void createGUI() {

		setLayout(new BorderLayout());

		gBoard = new GameBoard(width, 384);
		gBoard.addMouseListener(this);
		add(gBoard, BorderLayout.NORTH);

		JPanel controlPanel = new JPanel();
		add(controlPanel, BorderLayout.CENTER);

		testB = new JButton("test");
		rightB = new JButton("scroll right");
		leftB = new JButton("scroll left");
		testB.addActionListener(this);
		rightB.addActionListener(this);
		leftB.addActionListener(this);
		controlPanel.add(leftB);
		controlPanel.add(testB);
		controlPanel.add(rightB);

		tArea = new JTextArea();
		tArea.setRows(10);

		sPane = new JScrollPane(tArea);
		add(sPane, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == testB) {
			tArea.setText("testing 123");
			return;
		} else if (o == leftB) {
			gBoard.updateTopLeft(4);
			tArea.setText(tArea.getText() + "\n" + gBoard.topLeft.x);
			gBoard.repaint();
		} else if (o == rightB) {
			gBoard.updateTopLeft(6);
			tArea.setText(tArea.getText() + "\n" + gBoard.topLeft.x);
			gBoard.repaint();
		}

	}

	public void itemStateChanged(ItemEvent e) {
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		gBoard.mousePos.x = mouseX;
		gBoard.mousePos.y = mouseY;
		tArea.setText(tArea.getText() + "\n" + mouseX + " " + mouseY);
		tArea.setText(tArea.getText()
				+ " contains "
				+ GameBoard.tiles[mouseX / gBoard.lineSpacing][mouseY
						/ gBoard.lineSpacing]);
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}
}
