package postIt.controller;

import java.util.ArrayList;

import postIt.model.IPostItModelToControllerAdapter;
import postIt.model.PostItModel;
import postIt.note.dat.NoteInfo;
import postIt.view.IPostItViewToControllerAdapter;
import postIt.view.PostItView;

/**
 * Controller instance for this program. In charge of actually making the
 * program run.
 * 
 * @author DavidNichol
 * 
 */
public class PostItController {
	/**
	 * The view for this program, contains the grey background and all
	 * postit/input handling
	 */
	private PostItView view;

	/**
	 * The model for this program. Handles creation, deletion, and saving of the
	 * post its.
	 */
	private PostItModel model;

	/**
	 * Main method, starts the program.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		PostItController ctrl = new PostItController();
		ctrl.start();

	}

	/**
	 * Creates a new model and view, loads sticky information and displays it on
	 * the screen.
	 */
	private void start() {
		model = new PostItModel(new IPostItModelToControllerAdapter() {

			@Override
			public void addPostIt(NoteInfo newPostIt) {
				System.out.println(newPostIt);
				view.addPostIt(newPostIt);
			}
		});
		view = new PostItView(new IPostItViewToControllerAdapter() {

			@Override
			public void createPostIt() {
				model.createPostIt();
			}

			@Override
			public void saveData(ArrayList<NoteInfo> postItInfoList) {
				model.saveData(postItInfoList);
			}

		}, model.loadNotes());

	}
}
