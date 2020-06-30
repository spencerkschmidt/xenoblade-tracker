package tracker.xcde.ui.view.pages;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import tracker.ui.MainFrame;
import tracker.ui.SaveManager;
import tracker.ui.view.elements.IItemView;
import tracker.xcde.items.Collectopaedia;
import tracker.xcde.items.Collectopaedia.Category;
import tracker.xcde.items.Collectopaedia.Item;
import tracker.xcde.items.DELocation;

@SuppressWarnings("serial")
public class ViewCollectopaedia extends JPanel implements IItemView
{
	private Map<DELocation, JProgressBar> progresses = new HashMap<DELocation, JProgressBar>();
	private Map<DELocation, JTable> tables = new HashMap<DELocation, JTable>();
	private JTabbedPane tabbedPane;

	public ViewCollectopaedia()
	{
		for (DELocation location : DELocation.values())
		{
			JProgressBar bar = new JProgressBar();
			bar.setStringPainted(true);
			this.progresses.put(location, bar);
			this.tables.put(location, this.createTable(location));
		}

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagLayout collectopaediaViewGBC = new GridBagLayout();
		collectopaediaViewGBC.columnWidths = new int[] {624};
		collectopaediaViewGBC.rowHeights = new int[] {600};
		collectopaediaViewGBC.columnWeights = new double[] {1.0D};
		collectopaediaViewGBC.rowWeights = new double[] {1.0D};
		this.setLayout(collectopaediaViewGBC);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints tabbedPaneGBC = new GridBagConstraints();
		tabbedPaneGBC.fill = GridBagConstraints.BOTH;
		this.add(this.tabbedPane, tabbedPaneGBC);

		for (DELocation location : DELocation.values())
		{
			this.tabbedPane.addTab(location.name, null, this.createPanelForTable(this.tables.get(location), location), null);
			this.updateTabTooltip(location);
		}
	}

	private JPanel createPanelForTable(JTable table, DELocation location)
	{
		JPanel panel = new JPanel();
		GridBagLayout layoutGBL = new GridBagLayout();
		layoutGBL.columnWidths = new int[] {624};
		layoutGBL.rowHeights = new int[] {30, 500, 30};
		layoutGBL.columnWeights = new double[] {1.0D};
		layoutGBL.rowWeights = new double[] {0.0D, 1.0D, 0.0D};
		panel.setLayout(layoutGBL);

		GridBagConstraints headerGBC = new GridBagConstraints();
		headerGBC.fill = GridBagConstraints.BOTH;
		panel.add(table.getTableHeader(), headerGBC);
		GridBagConstraints tableGBC = new GridBagConstraints();
		tableGBC.insets = new Insets(0, 0, 5, 0);
		tableGBC.fill = GridBagConstraints.BOTH;
		tableGBC.gridy = 1;
		panel.add(table, tableGBC);
		GridBagConstraints progressGBC = new GridBagConstraints();
		progressGBC.fill = GridBagConstraints.BOTH;
		progressGBC.gridy = 2;
		panel.add(this.progresses.get(location), progressGBC);
		return panel;
	}

	private JTable createTable(DELocation location)
	{
		JTable table = new JTable(Collectopaedia.getCategoryFromLocation(location).length, 12);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		String[] columns = new String[] {"Category", "", "1", "", "2", "", "3", "", "4", "", "5", "Reward"};
		var categoriesForArea = Arrays.<Category> asList(Collectopaedia.getCategoryFromLocation(location));
		Object[][] data = new Object[categoriesForArea.size()][];

		for (int i = 0; i < categoriesForArea.size(); ++i)
		{
			Category category = categoriesForArea.get(i);
			Item[] items = category.items;
			List<Object> row = new ArrayList<Object>(12);

			for (int j = 0; j < 12; ++j)
			{
				if (j != 0 && (j % 2) == 0)
					row.add(null);
				else
					row.add(false);
			}

//			JLabel label = new JLabel(category.categoryType.name().substring(0, 1) + category.categoryType.name().substring(1).toLowerCase());
			row.set(0, category.categoryType.name().substring(0, 1) + category.categoryType.name().substring(1).toLowerCase());

			for (int j = 1; j < (items.length * 2) + 1; ++j)
			{
				if ((j % 2) == 0)
				{
					row.set(j, items[(j / 2) - 1].name);
				}
			}

			row.set(11, category.reward);
			data[i] = row.toArray(new Object[row.size()]);
		}

		table.setModel(new DefaultTableModel(data, columns)
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				if (column != 0 && column != 11 && (column % 2) == 1)
				{
					if (this.getValueAt(row, column + 1) == null)
						return false;

					return true;
				}

				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex)
			{
				if (columnIndex != 0 && columnIndex != 11 && (columnIndex % 2) == 1)
					return Boolean.class;
//				else if (columnIndex == 0)
//					return JLabel.class;
				else
					return super.getColumnClass(columnIndex);
			}
		});
		TableColumnModel tableModel = table.getColumnModel();
		tableModel.getColumn(0).setPreferredWidth(40);
		table.setShowGrid(false);

		for (int i = 0; i < 12; ++i)
		{
			if ((i % 2) == 1 && i != 11)
				tableModel.getColumn(i).setPreferredWidth(5);
		}

		table.getModel().addTableModelListener(new CollectopaediaModelListener(table, location));
		int amount = 0;

		for (int column = 1; column <= 9; column += 2)
		{
			for (int row = 0; row < table.getRowCount(); ++row)
			{
				List<String> collected = SaveManager.DE_COLLECTABLES.get(location);
				String value = (String) table.getModel().getValueAt(row, column + 1);

				if (value != null)
				{
					++amount;

					if (collected.contains(value))
						table.getModel().setValueAt(true, row, column);
				}
			}
		}

		this.progresses.get(location).setMaximum(amount);
		this.updateProgressBar(this.progresses.get(location), SaveManager.DE_COLLECTABLES.get(location).size());

//		table.setDefaultRenderer(JLabel.class, new DefaultTableCellRenderer()
//		{
//			@Override
//			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
//			{
//				if (value instanceof JLabel)
//				{
//					JLabel label = (JLabel) value;
//					label.setOpaque(true);
//
//					if (isSelected)
//					{
//						label.setBackground(table.getSelectionBackground());
//						label.setForeground(table.getSelectionForeground());
//					}
//					else
//					{
//						label.setBackground(table.getBackground());
//						label.setForeground(table.getForeground());
//					}
//
//					return label;
//				}
//				else
//					return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//			}
//		});

		return table;
	}

	private void updateProgressBar(JProgressBar bar, int amount)
	{
		bar.setValue(amount);
		bar.setString(String.format("Total: %d/%d (%.0f", amount, bar.getMaximum(), ((double) amount / (double) bar.getMaximum()) * 100.0D) + "%)");
	}

	private void updateTabTooltip(DELocation location)
	{
		int max = this.progresses.get(location).getMaximum();
		int amount = SaveManager.DE_COLLECTABLES.get(location).size();
		this.tabbedPane.setToolTipTextAt(this.tabbedPane.indexOfTab(location.name), String.format("Total: %d/%d (%.0f", amount, max, ((double) amount / (double) max) * 100.0D) + "%)");
	}

	@Override
	public void reselect()
	{
		for (DELocation location : DELocation.values())
		{
			this.reselectItems(location);
		}
	}

	@Override
	public void selectAll()
	{
		int index = this.tabbedPane.getSelectedIndex();
		DELocation location = DELocation.values()[index];
		JTable table = this.tables.get(location);

		for (int column = 1; column <= 9; column += 2)
		{
			for (int row = 0; row < table.getRowCount(); ++row)
			{
				String value = (String) table.getModel().getValueAt(row, column + 1);

				if (value != null && !SaveManager.DE_COLLECTABLES.get(location).contains(value))
					SaveManager.DE_COLLECTABLES.get(location).add(value);
			}
		}

		this.reselectItems(location);
	}

	@Override
	public void unselectAll()
	{
		int index = this.tabbedPane.getSelectedIndex();
		DELocation location = DELocation.values()[index];
		JTable table = this.tables.get(location);

		for (int column = 1; column <= 9; column += 2)
		{
			for (int row = 0; row < table.getRowCount(); ++row)
			{
				String value = (String) table.getModel().getValueAt(row, column + 1);

				if (value != null)
					SaveManager.DE_COLLECTABLES.get(location).remove(value);
			}
		}

		this.reselectItems(location);
	}

	private void reselectItems(DELocation location)
	{
		JTable table = this.tables.get(location);

		for (int column = 1; column <= 9; column += 2)
		{
			for (int row = 0; row < table.getRowCount(); ++row)
			{
				List<String> collected = SaveManager.DE_COLLECTABLES.get(location);
				String value = (String) table.getModel().getValueAt(row, column + 1);

				if (value != null)
				{
					if (collected.contains(value))
						table.getModel().setValueAt(true, row, column);
					else
						table.getModel().setValueAt(false, row, column);
				}
			}
		}

		this.updateProgressBar(this.progresses.get(location), SaveManager.DE_COLLECTABLES.get(location).size());
		this.updateTabTooltip(location);

		if (SaveManager.DE_COLLECTABLES.get(location).size() == this.progresses.get(location).getMaximum())
			this.tabbedPane.setIconAt(this.tabbedPane.indexOfTab(location.name),  new ImageIcon(MainFrame.getImageResource("icons/items/crown")));
		else
			this.tabbedPane.setIconAt(this.tabbedPane.indexOfTab(location.name), null);
	}

	private class CollectopaediaModelListener implements TableModelListener
	{
		final JTable table;
		final DELocation location;

		public CollectopaediaModelListener(JTable table, DELocation location)
		{
			this.table = table;
			this.location = location;
		}

		@Override
		public void tableChanged(TableModelEvent e)
		{
			boolean checked = (Boolean) this.table.getModel().getValueAt(e.getFirstRow(), e.getColumn());
			String value = (String) this.table.getModel().getValueAt(e.getFirstRow(), e.getColumn() + 1);
			var collectables = SaveManager.DE_COLLECTABLES.get(this.location);

			if (value != null)
			{
				if (checked)
				{
					if (!collectables.contains(value))
						collectables.add(value);
				}
				else
					collectables.remove(value);

				JProgressBar bar = ViewCollectopaedia.this.progresses.get(this.location);

				if (collectables.size() == bar.getMaximum())
					ViewCollectopaedia.this.tabbedPane.setIconAt(ViewCollectopaedia.this.tabbedPane.indexOfTab(this.location.name), new ImageIcon(MainFrame.getImageResource("icons/items/crown")));
				else
					ViewCollectopaedia.this.tabbedPane.setIconAt(ViewCollectopaedia.this.tabbedPane.indexOfTab(this.location.name), null);

				ViewCollectopaedia.this.updateProgressBar(bar, collectables.size());
				ViewCollectopaedia.this.updateTabTooltip(this.location);
			}

			Comparator<String> colleectablesComparator = new Comparator<String>()
			{
				@Override
				public int compare(String name, String otherName)
				{
					Category[] categories = Collectopaedia.getCategoryFromLocation(CollectopaediaModelListener.this.location);
					int index = 0;
					int firstIndex = 0;
					int secondIndex = 0;

					for (Category category : categories)
					{
						for (int i = 0; i < category.items.length; ++i)
						{
							if (category.items[i].name.equalsIgnoreCase(name))
								firstIndex = index;

							if (category.items[i].name.equalsIgnoreCase(otherName))
								secondIndex = index;

							++index;
						}
					}

					return firstIndex > secondIndex ? 1 : (firstIndex == secondIndex ? 0 : -1);
				}
			};
			Collections.sort(SaveManager.DE_COLLECTABLES.get(this.location), colleectablesComparator);
			MainFrame.getInstance().updateSaveState(false);
		}
	}
}