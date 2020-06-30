package tracker.ui.view.elements;

public interface IItemView
{
	/**
	 * Used for when opening a new file. Reselects all items that are in the current view that were selected from the file being opened.
	 */
	void reselect();

	/**
	 * Sets all of the items in the current view to be selected.
	 */
	void selectAll();

	/**
	 * Sets all of the items in the current view to be unselected.
	 */
	void unselectAll();
}