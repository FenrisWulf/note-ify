package postIt.note.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import postIt.note.dat.NoteInfo;

/**
 * A GUI instance of a post it to be displayed on the screen
 * 
 * @author DavidNichol
 * 
 */
public class PostItNote extends JInternalFrame {

	/**
	 * Auto generated serial ID for the post it
	 */
	private static final long serialVersionUID = 3159494906460844606L;

	/**
	 * Constants describing colors of the post tis
	 */
	private static final int YELLOW = 0;
	private static final int PINK = 1;
	private static final int CYAN = 2;
	private static final int ORANGE = 3;
	private static final int WHITE = 4;

	/**
	 * An integer corrseponding to one of the above constants
	 */
	private int color;

	/**
	 * The text pane within this frame instance
	 */
	private JTextPane textPane;

	/**
	 * Color of the post it
	 * 
	 * @return The post it's color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Setter for the color
	 * 
	 * @param color
	 *            THe color to set
	 */
	public void setColor(int color) {
		this.color = color;
		setBkgColor();
	}

	/**
	 * Sets the text for the text pane
	 * 
	 * @param text
	 *            The text to set
	 */
	public void setText(String text) {
		textPane.setText(text);
	}

	/**
	 * Gets the text for the text pane
	 * 
	 * @return The text written in the text pane
	 */
	public String getText() {
		return textPane.getText();
	}

	/**
	 * Get the textpane for this frame
	 * 
	 * @return The text pane.
	 */
	public JComponent getTextPane() {
		return textPane;
	}

	/**
	 * Sets the color for the textpane
	 */
	private void setBkgColor() {
		switch (color) {
		case YELLOW:
			textPane.setBackground(Color.YELLOW);
			break;
		case PINK:
			textPane.setBackground(Color.PINK);
			break;
		case CYAN:
			textPane.setBackground(Color.CYAN);
			break;
		case ORANGE:
			textPane.setBackground(Color.ORANGE);
			break;
		case WHITE:
			textPane.setBackground(Color.WHITE);
			break;
		default: // If something weird happened, set the color to yellow.
			textPane.setBackground(Color.YELLOW);
			color = YELLOW;
		}
	}

	/**
	 * Constructor
	 * 
	 * @param noteInfo
	 *            The information used to define this post it's initial
	 *            properties.
	 */
	public PostItNote(NoteInfo noteInfo) {
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(true);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		setVisible(true);

		color = noteInfo.getColor();
		setBkgColor();

		int width = noteInfo.getWidth();
		int height = noteInfo.getHeight();
		Point coordinate = new Point(noteInfo.getX(), noteInfo.getY());
		setText(noteInfo.getText());
		setLocation(coordinate);
		setBounds(coordinate.x, coordinate.y, width, height);
	}

	/**
	 * Sets the color to the next color
	 */
	public void incrementColor() {
		color++;
		if (color > WHITE) {
			color = YELLOW;
		}
		setBkgColor();
	}

	/**
	 * Sets the color to the previous color
	 */
	public void decrementColor() {
		color--;
		if (color < YELLOW) {
			color = WHITE;
		}
		setBkgColor();
	}

	/**
	 * Checks if the x and y coordinates are within this frame instance. So I
	 * think there should be something like this in a JComponent already but I
	 * can't find it?
	 * 
	 * @param x
	 *            The x coordinate to check
	 * @param y
	 *            The y coordinate to check
	 * @return True if the x and y are within the bounds of this frame.
	 */
	public boolean isInside(int x, int y) {
		Point coordinate = getLocation();
		int width = getWidth();
		int height = getHeight();
		if (coordinate.x <= x && coordinate.x + width >= x && coordinate.y <= y
				&& coordinate.y + height >= y) {
			return true;
		}
		return false;
	}

}
