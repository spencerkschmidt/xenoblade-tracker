package tracker.xcde.ui.view.pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import tracker.ui.MainFrame;
import tracker.ui.SaveManager;
import tracker.ui.view.elements.CustomTable;
import tracker.ui.view.elements.DocumentListenerSearchBar;
import tracker.ui.view.elements.FilterSearchBar;
import tracker.ui.view.elements.IItemView;
import tracker.ui.view.elements.TableItemSorter;
import tracker.xcde.items.DELocation;
import tracker.xcde.items.UniqueMonsters;
import tracker.xcde.items.UniqueMonsters.UniqueMonster;

@SuppressWarnings("serial")
public class ViewUniques extends JPanel implements IItemView
{
	private JProgressBar uniqueProgress;
	private JTable uniquesTable;
	private JComboBox<String> areaComboBox;
	private JTextField searchBar;

	public ViewUniques()
	{
		this.setBorder(new EmptyBorder(5, 5, 0, 5));
		GridBagLayout uniquesViewGBC = new GridBagLayout();
		uniquesViewGBC.columnWidths = new int[] {624};
		uniquesViewGBC.rowHeights = new int[] {30, 34, 440, 30};
		uniquesViewGBC.columnWeights = new double[] {1.0D};
		uniquesViewGBC.rowWeights = new double[] {0.0D, 0.0D, 1.0D, 0.0D};
		this.setLayout(uniquesViewGBC);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints scrollPaneGBC = new GridBagConstraints();
		scrollPaneGBC.insets = new Insets(0, 0, 5, 0);
		scrollPaneGBC.fill = GridBagConstraints.BOTH;
		scrollPaneGBC.gridx = 0;
		scrollPaneGBC.gridy = 2;
		this.add(scrollPane, scrollPaneGBC);

		String[] columns = new String[] {"Name", "Level", "Area", "Location", "Requirements", "Completed"};
		var uniques = Arrays.<UniqueMonster> asList(UniqueMonsters.UNIQUE_MONSTERS);
		Object[][] data = new Object[uniques.size()][];

		for (int i = 0; i < uniques.size(); ++i)
		{
			List<Object> row = uniques.get(i).getAttributes();
			data[i] = row.toArray(new Object[row.size()]);
		}

		this.uniquesTable = new CustomTable();
		this.uniquesTable.setModel(new UniquesModel(data, columns));
		this.uniquesTable.getTableHeader().setReorderingAllowed(false);
		this.uniquesTable.setRowSorter(new TableItemSorter<TableModel>(this.uniquesTable.getModel()));
		scrollPane.setViewportView(this.uniquesTable);
		this.areaComboBox = new JComboBox(new String[] {"All", "Colony 9", "Tephra Cave", "Bionis' Leg", "Colony 6", "Ether Mine", "Satorl Marsh", "Makna Forest", "Frontier Village", "Eryth Sea",
				"High Entia Tomb", "Valak Mountain", "Sword Valley", "Galahad Fortress", "Fallen Arm", "Mechonis Field", "Central Factory", "Agniratha", "Bionis' Interior", "Prison Island"});
		this.areaComboBox.addActionListener(e ->
		{
			List<UniqueMonster> uniquesFiltered = uniques;

			if (this.areaComboBox.getSelectedItem() != null)
			{
				String areaSelected = (String) this.areaComboBox.getSelectedItem();

				if (!areaSelected.equals("All"))
					uniquesFiltered = uniques.stream().filter(u -> u.area == DELocation.getByName(areaSelected)).collect(Collectors.toList());

				int size = uniquesFiltered.size();
				Object[][] newData = new Object[size][];

				for (int i = 0; i < size; ++i)
				{
					List<Object> row = uniquesFiltered.get(i).getAttributes();
					newData[i] = row.toArray(new Object[row.size()]);
				}

				this.uniquesTable.setModel(new UniquesModel(newData, columns));
				this.uniquesTable.setRowSorter(new TableItemSorter<TableModel>(this.uniquesTable.getModel()));

				for (int i = 0; i < size; ++i)
				{
					if (SaveManager.DE_UNIQUE_MONSTERS.contains(uniquesTable.getModel().getValueAt(i, 0)))
						this.uniquesTable.getModel().setValueAt(true, i, 5);
				}

				this.uniquesTable.getModel().addTableModelListener(new UniquesTableModelListener(this.uniquesTable, this.areaComboBox));

				if (!this.searchBar.getText().isEmpty())
				{
					String filter = ViewUniques.this.searchBar.getText();
					TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) ViewUniques.this.uniquesTable.getRowSorter();

					try
					{
						if (filter.trim().length() == 0)
							rowSorter.setRowFilter(null);
						else
							rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filter));
					}
					catch (Exception ex)
					{
						;
					}
				}
			}
		});
		GridBagConstraints comboBoxGBC = new GridBagConstraints();
		comboBoxGBC.insets = new Insets(0, 0, 5, 0);
		comboBoxGBC.gridheight = 1;
		comboBoxGBC.fill = GridBagConstraints.BOTH;
		comboBoxGBC.gridx = 0;
		comboBoxGBC.gridy = 1;
		this.add(this.areaComboBox, comboBoxGBC);
		this.uniquesTable.getModel().addTableModelListener(new UniquesTableModelListener(this.uniquesTable, this.areaComboBox));

		for (int i = 0; i < uniquesTable.getRowCount(); ++i)
		{
			if (SaveManager.DE_UNIQUE_MONSTERS.contains(uniquesTable.getModel().getValueAt(i, 0)))
				this.uniquesTable.getModel().setValueAt(true, i, 5);
		}

		this.uniqueProgress = new JProgressBar(0, 157);
		this.uniqueProgress.setString("Total: " + SaveManager.DE_UNIQUE_MONSTERS.size() + "/157 (" + String.format("%.2f", ((double) SaveManager.DE_UNIQUE_MONSTERS.size() / 157.0D) * 100.0D) + "%)");
		this.uniqueProgress.setStringPainted(true);
		this.uniqueProgress.setValue(SaveManager.DE_UNIQUE_MONSTERS.size());
		GridBagConstraints progressBarGBC = new GridBagConstraints();
		progressBarGBC.insets = new Insets(0, 0, 5, 0);
		progressBarGBC.gridheight = 1;
		progressBarGBC.fill = GridBagConstraints.BOTH;
		progressBarGBC.gridx = 0;
		progressBarGBC.gridy = 3;
		this.add(this.uniqueProgress, progressBarGBC);

		this.searchBar = new JTextField();
		this.searchBar.setDocument(new FilterSearchBar(this));
		this.searchBar.getDocument().addDocumentListener(new DocumentListenerSearchBar(this.searchBar, this.uniquesTable));
		GridBagConstraints searchBarGBC = new GridBagConstraints();
		searchBarGBC.insets = new Insets(0, 0, 5, 0);
		searchBarGBC.gridheight = 1;
		searchBarGBC.fill = GridBagConstraints.BOTH;
		searchBarGBC.gridx = 0;
		searchBarGBC.gridy = 0;
		this.add(this.searchBar, searchBarGBC);
	}

	/**
	 * Used for when opening a new file. Reselects all items that are in the current view that were selected from the file being opened.
	 */
	@Override
	public void reselect()
	{
		if (this.areaComboBox != null && this.uniquesTable != null)
		{
			List<UniqueMonster> uniquesFiltered = Arrays.asList(UniqueMonsters.UNIQUE_MONSTERS);

			if (this.areaComboBox.getSelectedItem() != null)
			{
				String selected = (String) this.areaComboBox.getSelectedItem();

				if (!selected.equals("All"))
					uniquesFiltered = uniquesFiltered.stream().filter(u -> u.area == DELocation.getByName(selected)).collect(Collectors.toList());

				for (int i = 0; i < uniquesFiltered.size(); ++i)
				{
					this.uniquesTable.getModel().setValueAt(false, i, 5);

					if (SaveManager.DE_UNIQUE_MONSTERS.contains(this.uniquesTable.getModel().getValueAt(i, 0)))
						this.uniquesTable.getModel().setValueAt(true, i, 5);
				}
			}
		}

		this.uniqueProgress.setValue(SaveManager.DE_UNIQUE_MONSTERS.size());
		this.uniqueProgress.setString("Total: " + SaveManager.DE_UNIQUE_MONSTERS.size() + "/157 (" + String.format("%.2f", ((double) SaveManager.DE_UNIQUE_MONSTERS.size() / 157.0D) * 100.0D) + "%)");
	}

	/**
	 * Sets all of the items in the current view to be selected.
	 */
	@Override
	public void selectAll()
	{
		for (int i = 0; i < UniqueMonsters.UNIQUE_MONSTERS.length; ++i)
		{
			String name = UniqueMonsters.UNIQUE_MONSTERS[i].name;

			if (!SaveManager.DE_UNIQUE_MONSTERS.contains(name))
				SaveManager.DE_UNIQUE_MONSTERS.add(name);
		}

		this.reselect();
	}

	/**
	 * Sets all of the items in the current view to be unselected.
	 */
	@Override
	public void unselectAll()
	{
		for (int i = 0; i < UniqueMonsters.UNIQUE_MONSTERS.length; ++i)
		{
			SaveManager.DE_UNIQUE_MONSTERS.remove(UniqueMonsters.UNIQUE_MONSTERS[i].name);
		}

		this.reselect();
	}

	private class UniquesModel extends DefaultTableModel
	{
		private UniquesModel(Object[][] data, Object[] columnNames)
		{
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column)
		{
			return column == 5;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			if (columnIndex == 5)
				return Boolean.class;
			else
				return super.getColumnClass(columnIndex);
		}
	}

	private class UniquesTableModelListener implements TableModelListener
	{
		final JTable table;
		final JComboBox comboBox;

		public UniquesTableModelListener(JTable table, JComboBox comboBox)
		{
			this.table = table;
			this.comboBox = comboBox;
		}

		@Override
		public void tableChanged(TableModelEvent e)
		{
			if (!(table.getSelectedRow() == -1))
			{
				int row = this.table.convertRowIndexToModel(this.table.getSelectedRow());

				if (((TableRowSorter<TableModel>) this.table.getRowSorter()).getRowFilter() != null)
					row = this.table.getRowSorter().convertRowIndexToModel(this.table.getSelectedRow());

				boolean checked = (Boolean) this.table.getModel().getValueAt(row, 5);
				String selectedArea = (String) this.comboBox.getSelectedItem();
				List<UniqueMonster> uniquesFiltered = Arrays.asList(UniqueMonsters.UNIQUE_MONSTERS);

				if (!selectedArea.equalsIgnoreCase("All"))
					uniquesFiltered = uniquesFiltered.stream().filter(u -> u.area == DELocation.getByName(selectedArea)).collect(Collectors.toList());

				String name = uniquesFiltered.get(row).name;

				if (checked && !SaveManager.DE_UNIQUE_MONSTERS.contains(name))
					SaveManager.DE_UNIQUE_MONSTERS.add(name);
				else if (!checked)
					SaveManager.DE_UNIQUE_MONSTERS.remove(name);

				ViewUniques.this.uniqueProgress.setValue(SaveManager.DE_UNIQUE_MONSTERS.size());
				ViewUniques.this.uniqueProgress.setString("Total: " + SaveManager.DE_UNIQUE_MONSTERS.size() + "/157 (" + String.format("%.2f", ((double) SaveManager.DE_UNIQUE_MONSTERS.size() / 157.0D) * 100.0D) + "%)");
				MainFrame.getInstance().updateSaveState(false);
			}
		}
	}
}