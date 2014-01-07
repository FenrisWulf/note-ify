package postIt.note.dat;

/**
 * Contains all of the data that a note has when saved/loaded. Essentially a
 * Java object representation of the JSON objects described in data.txt
 * 
 * @author DavidNichol
 * 
 */
public class NoteInfo {
	/**
	 * The text a post it has
	 */
	private String text;

	/**
	 * The x coordinate of the post it
	 */
	private int x;

	/**
	 * The y coordinate of the post it
	 */
	private int y;

	/**
	 * The width of the post it
	 */
	private int width;

	/**
	 * The height of the post it
	 */
	private int height;

	/**
	 * A number corresponding to a specific color for the post it.
	 */
	private int color;

	/**
	 * Constructor
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public NoteInfo(String text, int x, int y, int width, int height, int color) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	/**
	 * Returns the post it text
	 * 
	 * @return the post it text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the post it text
	 * 
	 * @param text
	 *            The text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the x coordinate
	 * 
	 * @return The x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X coordinate
	 * 
	 * @param x
	 *            The coordinate to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y coordinate
	 * 
	 * @return The coordinate to get
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate
	 * 
	 * @param y
	 *            The coorindate to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the width
	 * 
	 * @return The width of the note
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width
	 * 
	 * @param width
	 *            The width of the note
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height of the note
	 * 
	 * @return The height of the note
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * sets the height of the note
	 * 
	 * @param height
	 *            The height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the color of the note
	 * 
	 * @return An integer corresponding to a specific color for the note.
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Setter for the collor
	 * 
	 * @param color
	 *            An integer representing a color to set.
	 */
	public void setColor(int color) {
		this.color = color;
	}

}
