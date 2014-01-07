package postIt.note.view;

import postIt.note.dat.NoteInfo;

/**
 * Factory abstraction for creating post its.
 * 
 * @author DavidNichol
 * 
 */
public class PostItFactory {
	/**
	 * The factory singleton instance
	 */
	public static final PostItFactory factoryInstance = new PostItFactory();

	private PostItFactory() {

	}

	/**
	 * Creates a post it
	 * 
	 * @param info
	 *            The information for the post it being created
	 * @return A new post it based on the corresponding information.
	 */
	public PostItNote make(NoteInfo info) {
		return new PostItNote(info);
	}
}
