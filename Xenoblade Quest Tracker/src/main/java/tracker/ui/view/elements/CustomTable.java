package tracker.ui.view.elements;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class CustomTable extends JTable
{
	public CustomTable() {}

	public CustomTable(int numRows, int numColumns)
	{
		super(numRows, numColumns);
	}

	@Override
	public String getToolTipText(MouseEvent event)
	{
		String tooltip = null;
		Point point = event.getPoint();
		int column = this.columnAtPoint(point);
		int row = this.rowAtPoint(point);
		Rectangle cellBounds = this.getCellRect(row, column, false);
		Object value = this.getValueAt(row, column);

		if (value instanceof String)
		{
			String tipValue = (String) this.getValueAt(row, column);
			Component component = this.prepareRenderer(this.getCellRenderer(row, column), row, column);

			if (component.getPreferredSize().width > cellBounds.width)
				tooltip = tipValue;
		}

		return tooltip;
	}

	@Override
	public Font getFont()
	{
		return new Font("Tahoma", Font.PLAIN, 14);
	}

	@Override
	public int getRowHeight()
	{
		return 22;
	}
}