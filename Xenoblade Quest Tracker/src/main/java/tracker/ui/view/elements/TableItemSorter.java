package tracker.ui.view.elements;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableItemSorter<M extends TableModel> extends TableRowSorter<M>
{
	public TableItemSorter(M model)
	{
		super(model);
	}

	@Override
	public boolean isSortable(int column)
	{
		return false;
	}
}