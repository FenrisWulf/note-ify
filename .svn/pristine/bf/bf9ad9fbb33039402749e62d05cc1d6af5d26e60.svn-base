package postIt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import postIt.note.dat.NoteInfo;
import postIt.note.view.PostItFactory;
import postIt.note.view.PostItNote;

/**
 * The view of this post it. Contains the frame of the entire screen, the greyed
 * out background, and all of the post its.
 * 
 * Contains all of the key and mouse listeners for user input.
 * 
 * @author DavidNichol
 * 
 */
public class PostItView extends JFrame implements KeyListener {
	/**
	 * Auto-generated serial ID
	 */
	private static final long serialVersionUID = 8624308573128186916L;

	/**
	 * How dark the background gets when it fades in.
	 */
	private static final float MAX_OPACTIY = 0.75f;

	/**
	 * The speed the screen fades in
	 */
	private final int FADE_SPEED = 8;

	/**
	 * Booleans checking wheter specific keys are held down
	 */
	private boolean ctrlDown;
	private boolean altDown;
	private boolean nDown;
	private boolean mDown;
	private boolean rightDown;
	private boolean leftDown;

	/**
	 * Adapter between the view and controller
	 */
	private IPostItViewToControllerAdapter adapter;

	/**
	 * A list of all post its
	 */
	private ArrayList<PostItNote> postItList;

	/**
	 * The post it currently being clicked on
	 */
	private PostItNote selectedPostIt;

	/**
	 * The layered pane all of the post its are drawn on
	 */
	private JLayeredPane layeredBkgPanel;

	/**
	 * The last post it that was selected.
	 */
	private PostItNote lastSelectedPostIt;

	/**
	 * Constructor
	 * 
	 * @param adapter
	 *            The adapter between the view and the controller
	 * @param notes
	 *            Data containing all of the inital notes to display on the
	 *            screen.
	 */
	public PostItView(IPostItViewToControllerAdapter adapter,
			ArrayList<NoteInfo> notes) {
		this.adapter = adapter;
		postItList = new ArrayList<PostItNote>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start();
		addNewPostIts(notes);

	}

	/**
	 * Add a list of post its to the screen
	 * 
	 * @param notes
	 *            The post its to add
	 */
	private void addNewPostIts(ArrayList<NoteInfo> notes) {
		for (NoteInfo note : notes) {
			addPostIt(note);
		}
	}

	/**
	 * Add the mouse/key listeners to the component Called whenever adding a new
	 * post it. So every post it has all of the correct listeners
	 * 
	 * @param component
	 *            The component to add the listeners to.
	 */
	private void addListeners(JComponent component) {
		component.addKeyListener(this);

		component.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				/**
				 * If the left click is made, move that note to the front of the
				 * screen.
				 */
				if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
					int screenX = e.getXOnScreen();
					int screenY = e.getYOnScreen();
					selectedPostIt = getSelectedPostIt(screenX, screenY);
					if (selectedPostIt != null) {
						lastSelectedPostIt = selectedPostIt;
						layeredBkgPanel.moveToFront(selectedPostIt);
					}
				}
				/**
				 * If the right click is made, remove that post it from the
				 * screen.
				 */
				if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
					int screenX = e.getXOnScreen();
					int screenY = e.getYOnScreen();
					PostItNote note = getSelectedPostIt(screenX, screenY);
					if (note != null) {
						postItList.remove(note);
						layeredBkgPanel.remove(note);
					}
					invalidate();

					repaint();

				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {

					selectedPostIt = null;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

	}

	/**
	 * Returns whichever post it is contained and on top of the x and y
	 * coordinates.
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @return The post it that is contained with these coordinates
	 */
	protected PostItNote getSelectedPostIt(int x, int y) {
		PostItNote result = null;
		for (PostItNote note : postItList) {
			if (note.isInside(x, y)) {
				if (result == null
						|| JLayeredPane.getLayer(result) < JLayeredPane
								.getLayer(note)) {
					result = note;
				}
			}
		}
		return result;
	}

	/**
	 * Saves the post it information to save
	 */
	private void saveData() {
		ArrayList<NoteInfo> postItInfoList = new ArrayList<NoteInfo>();
		for (PostItNote note : postItList) {
			postItInfoList.add(new NoteInfo(note.getText(),
					note.getLocation().x, note.getLocation().y,
					note.getWidth(), note.getHeight(), note.getColor()));
		}
		adapter.saveData(postItInfoList);
	}

	/**
	 * Starts the app, adds required componets.
	 */
	private void start() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveData();
			}
		});

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		setBounds(0, 0, width, height);
		JPanel _canvasPnl = new JPanel();
		_canvasPnl.setLayout(new BorderLayout(0, 0));
		setContentPane(_canvasPnl);

		layeredBkgPanel = new JLayeredPane();
		_canvasPnl.add(layeredBkgPanel, BorderLayout.CENTER);
		layeredBkgPanel.setLayout(null);
		_canvasPnl.setBackground(Color.BLACK);

		_canvasPnl.setBounds(0, 0, width, height);
		setUndecorated(true);

		this.setVisible(true);
		fadeIn();
		addKeyListener(this);
		_canvasPnl.addKeyListener(this);
		layeredBkgPanel.addKeyListener(this);
		addListeners(layeredBkgPanel);

	}

	/**
	 * Fade in the background
	 */
	private void fadeIn() {
		for (int i = 0; i < FADE_SPEED; i++) {
			setBackground(new Color(0, 0, 0, 1.0f * i / FADE_SPEED
					* MAX_OPACTIY));
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 17) {
			ctrlDown = true;
		}
		if (e.getKeyCode() == 18) {
			altDown = true;
		}
		if (e.getKeyCode() == 78) {
			nDown = true;
		}
		if (e.getKeyCode() == 77) {
			mDown = true;
		}
		if (e.getKeyCode() == 39) {
			rightDown = true;
		}
		if (e.getKeyCode() == 37) {
			leftDown = true;
		}
		checkChangeColor();
		checkCreatePostIt();
		checkClose();
	}

	/**
	 * If ctrl+m is hit, close the app
	 */
	private void checkClose() {
		if (ctrlDown && mDown) {
			saveData();
			dispose();
		}
	}

	/**
	 * Change the color if alt+right or alt+left are hit
	 */
	private void checkChangeColor() {
		if (altDown && rightDown) {
			lastSelectedPostIt.incrementColor();
		}
		if (altDown && leftDown) {
			lastSelectedPostIt.decrementColor();
		}
	}

	/**
	 * Create a new post it if ctrl+n is hit.
	 */
	private void checkCreatePostIt() {
		if (ctrlDown && nDown) {
			adapter.createPostIt();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 17) {
			ctrlDown = false;
		}
		if (e.getKeyCode() == 18) {
			altDown = false;
		}
		if (e.getKeyCode() == 77) {
			mDown = false;
		}
		if (e.getKeyCode() == 78) {
			nDown = false;
		}
		if (e.getKeyCode() == 39) {
			rightDown = false;
		}
		if (e.getKeyCode() == 37) {
			leftDown = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Add a new post it to the view
	 * 
	 * @param newPostItInfo
	 *            The information containing the post it to add.
	 */
	public void addPostIt(NoteInfo newPostItInfo) {
		PostItNote newPostIt = PostItFactory.factoryInstance
				.make(newPostItInfo);
		layeredBkgPanel.setVisible(true);
		addListeners(newPostIt);
		addListeners(newPostIt.getTextPane());
		layeredBkgPanel.add(newPostIt);
		revalidate();
		postItList.add(newPostIt);
		repaint();
		newPostIt.requestFocusInWindow();

	}
}
