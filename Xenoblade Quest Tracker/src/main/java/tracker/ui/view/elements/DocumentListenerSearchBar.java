package tracker.ui.view.elements;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DocumentListenerSearchBar implements DocumentListener
{
	private JTextField searchBar;
	private JTable table;
	private int[] columnsToCheck;

	public DocumentListenerSearchBar(JTextField searchBar, JTable table, int... columns)
	{
		this(searchBar, table);
		this.columnsToCheck = columns;
	}

	public DocumentListenerSearchBar(JTextField searchBar, JTable table)
	{
		this.searchBar = searchBar;
		this.table = table;
	}

	@Override
	public void insertUpdate(DocumentEvent e) { this.filter(); }

	@Override
	public void removeUpdate(DocumentEvent e) { this.filter(); }

	@Override
	public void changedUpdate(DocumentEvent e) {}

	private void filter()
	{
		String filter = this.searchBar.getText();
		TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) this.table.getRowSorter();

		if (filter.trim().length() == 0)
			rowSorter.setRowFilter(null);
		else
		{
			String[] delimitedSearches = filter.split("(,|&|AND)\s*");
			var filters = new ArrayList<RowFilter<Object, Object>>();

			for (String s : delimitedSearches)
			{
				if (!s.isEmpty())
				{
					if (this.columnsToCheck != null)
						filters.add(RowFilter.regexFilter("(?i)" + s.trim(), this.columnsToCheck));
					else
						filters.add(RowFilter.regexFilter("(?i)" + s.trim()));
				}
			}

			rowSorter.setRowFilter(RowFilter.orFilter(filters));
		}
	}
}