package postIt.model;

import postIt.note.dat.NoteInfo;

/**
 * Adapter between model and the controller
 * 
 * @author DavidNichol
 * 
 */
public interface IPostItModelToControllerAdapter {

	/**
	 * Adds a post it to the controller
	 * 
	 * @param newPostIt
	 *            The post it to add
	 */
	public void addPostIt(NoteInfo newPostIt);

}
