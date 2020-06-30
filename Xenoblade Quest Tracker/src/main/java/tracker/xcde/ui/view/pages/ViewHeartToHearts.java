package tracker.xcde.ui.view.pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
import tracker.xcde.items.HeartToHearts;
import tracker.xcde.items.HeartToHearts.HeartToHeart;

@SuppressWarnings("serial")
public class ViewHeartToHearts extends JPanel implements IItemView
{
	private JTable table;
	private JComboBox<String> areaComboBox;
	private JTextField searchBar;

	public ViewHeartToHearts()
	{
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout viewLayout = new GridBagLayout();
		viewLayout.columnWidths = new int[] {624};
		viewLayout.rowHeights = new int[] {30, 34, 500};
		viewLayout.columnWeights = new double[] {1.0D};
		viewLayout.rowWeights = new double[] {0.0D, 0.0D, 1.0D};
		this.setLayout(viewLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints scrollGBC = new GridBagConstraints();
		scrollGBC.fill = GridBagConstraints.BOTH;
		scrollGBC.gridx = 0;
		scrollGBC.gridy = 2;
		this.add(scrollPane, scrollGBC);

		String[] columns = new String[] {"Name", "Area", "Location", "Characters", "Affinity", "Prerequisites", "Completed"};
		var heartToHearts = Arrays.<HeartToHeart> asList(HeartToHearts.HEART_TO_HEARTS);
		Object[][] data = new Object[heartToHearts.size()][];

		for (int i = 0; i < heartToHearts.size(); ++i)
		{
			HeartToHeart hth = heartToHearts.get(i);
			String affinityString = "icons/items/affinity_";
			
			switch (hth.affinityRequired)
			{
			case YELLOW:
				affinityString += "yellow";
				break;
			case GREEN:
				affinityString += "green";
				break;
			case BLUE:
				affinityString += "blue";
				break;
			case LAVENDER:
				affinityString += "lavender";
				break;
			case PINK:
				affinityString += "pink";
			}

			List<Object> rowData = Arrays.<Object> asList(hth.name, hth.location.name, hth.area, hth.firstPerson + " + " + hth.secondPerson, new ImageIcon(MainFrame.getImageResource(affinityString)), hth.prerequisites, false);
			data[i] = rowData.toArray(new Object[rowData.size()]);
		}

		this.table = new CustomTable();
		this.table.setModel(new HeartToHeartModel(data, columns));
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.setRowSorter(new TableItemSorter<TableModel>(this.table.getModel()));
		scrollPane.setViewportView(this.table);
		GridBagConstraints areaComboGBC = new GridBagConstraints();
		areaComboGBC.insets = new Insets(0, 0, 5, 0);
		areaComboGBC.fill = GridBagConstraints.BOTH;
		areaComboGBC.gridx = 0;
		areaComboGBC.gridy = 1;
		this.areaComboBox = new JComboBox<String>(new String[] {"All", "Colony 9", "Tephra Cave", "Bionis' Leg", "Colony 6", "Ether Mine", "Satorl Marsh", "Makna Forest", "Frontier Village",
				"Eryth Sea", "Alcamoth", "High Entia Tomb", "Valak Mountain", "Fallen Arm", "Bionis' Interior", "Prison Island"});
		this.areaComboBox.addActionListener(e ->
		{
			var hthFiltered = heartToHearts;

			if (this.areaComboBox.getSelectedItem() != null)
			{
				String areaSelected = (String) this.areaComboBox.getSelectedItem();

				if (!areaSelected.equalsIgnoreCase("All"))
					hthFiltered = heartToHearts.stream().filter(h -> h.location == DELocation.getByName(areaSelected)).collect(Collectors.<HeartToHeart> toList());


				int size = hthFiltered.size();
				Object[][] newData = new Object[size][];

				for (int i = 0; i < hthFiltered.size(); ++i)
				{
					HeartToHeart hth = hthFiltered.get(i);
					String affinityString = "icons/items/affinity_";
					
					switch (hth.affinityRequired)
					{
					case YELLOW:
						affinityString += "yellow";
						break;
					case GREEN:
						affinityString += "green";
						break;
					case BLUE:
						affinityString += "blue";
						break;
					case LAVENDER:
						affinityString += "lavender";
						break;
					case PINK:
						affinityString += "pink";
					}

					List<Object> rowData = Arrays.<Object> asList(hth.name, hth.location.name, hth.area, hth.firstPerson + " + " + hth.secondPerson, new ImageIcon(MainFrame.getImageResource(affinityString)), hth.prerequisites, false);
					newData[i] = rowData.toArray(new Object[rowData.size()]);
				}

				this.table.setModel(new HeartToHeartModel(newData, columns));
				this.table.setRowSorter(new TableItemSorter<TableModel>(this.table.getModel()));

				for (int i = 0; i < size; ++i)
				{
					if (SaveManager.DE_HEART_TO_HEARTS.contains((String) this.table.getValueAt(i, 0)))
						this.table.setValueAt(true, i, 6);
				}

				this.table.getModel().addTableModelListener(new HeartToHeartsTableModelListener(this.table, this.areaComboBox));

				if (!this.searchBar.getText().isEmpty())
				{
					String filter = ViewHeartToHearts.this.searchBar.getText();
					TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) ViewHeartToHearts.this.table.getRowSorter();

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
		this.add(this.areaComboBox, areaComboGBC);
		this.table.getModel().addTableModelListener(new HeartToHeartsTableModelListener(this.table, this.areaComboBox));

		for (int i = 0; i < this.table.getRowCount(); ++i)
		{
			if (SaveManager.DE_HEART_TO_HEARTS.contains(this.table.getModel().getValueAt(i, 0)))
				this.table.getModel().setValueAt(true, i, 6);
		}

		this.searchBar = new JTextField();
		this.searchBar.setDocument(new FilterSearchBar(this));
		this.searchBar.getDocument().addDocumentListener(new DocumentListenerSearchBar(this.searchBar, this.table));
		GridBagConstraints searchBarGBC = new GridBagConstraints();
		searchBarGBC.insets = new Insets(0, 0, 5, 0);
		searchBarGBC.gridheight = 1;
		searchBarGBC.fill = GridBagConstraints.BOTH;
		searchBarGBC.gridx = 0;
		searchBarGBC.gridy = 0;
		this.add(this.searchBar, searchBarGBC);
	}

	@Override
	public void reselect()
	{
		if (this.areaComboBox != null && this.table != null)
		{
			var hthFiltered = Arrays.<HeartToHeart> asList(HeartToHearts.HEART_TO_HEARTS);

			if (this.areaComboBox.getSelectedItem() != null)
			{
				String areaSelected = (String) this.areaComboBox.getSelectedItem();

				if (!areaSelected.equalsIgnoreCase("All"))
					hthFiltered = hthFiltered.stream().filter(h -> h.location == DELocation.getByName(areaSelected)).collect(Collectors.<HeartToHeart> toList());

				for (int i = 0; i < hthFiltered.size(); ++i)
				{
					this.table.getModel().setValueAt(false, i, 6);

					if (SaveManager.DE_HEART_TO_HEARTS.contains(this.table.getModel().getValueAt(i, 0)))
						this.table.getModel().setValueAt(true, i, 6);
				}
			}
		}
	}

	@Override
	public void selectAll()
	{
		Arrays.<HeartToHeart> asList(HeartToHearts.HEART_TO_HEARTS).stream()
			.map(h -> h.name).filter(h -> !SaveManager.DE_HEART_TO_HEARTS.contains(h)).forEach(SaveManager.DE_HEART_TO_HEARTS::add);

		this.reselect();
	}

	@Override
	public void unselectAll()
	{
		Arrays.<HeartToHeart> asList(HeartToHearts.HEART_TO_HEARTS).stream().map(h -> h.name).forEach(SaveManager.DE_HEART_TO_HEARTS::remove);
		this.reselect();
	}

	private class HeartToHeartModel extends DefaultTableModel
	{
		private HeartToHeartModel(Object[][] data, Object[] columnNames)
		{
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column)
		{
			return column == 6;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			if (columnIndex == 4)
				return ImageIcon.class;
			else if (columnIndex == 6)
				return Boolean.class;
			else
				return super.getColumnClass(columnIndex);
		}
	}

	private class HeartToHeartsTableModelListener implements TableModelListener
	{
		final JTable table;
		final JComboBox comboBox;

		public HeartToHeartsTableModelListener(JTable table, JComboBox comboBox)
		{
			this.table = table;
			this.comboBox = comboBox;
		}

		@Override
		public void tableChanged(TableModelEvent e)
		{
			if (!(this.table.getSelectedRow() == -1))
			{
				int row = this.table.convertRowIndexToModel(this.table.getSelectedRow());

				if (((TableRowSorter<TableModel>) this.table.getRowSorter()).getRowFilter() != null)
					row = this.table.getRowSorter().convertRowIndexToModel(this.table.getSelectedRow());

				boolean checked = (Boolean) this.table.getModel().getValueAt(row, 6);
				String selectedArea = (String) this.comboBox.getSelectedItem();
				var hthFiltered = Arrays.asList(HeartToHearts.HEART_TO_HEARTS);

				if (!selectedArea.equalsIgnoreCase("All"))
					hthFiltered = hthFiltered.stream().filter(u -> u.location == DELocation.getByName(selectedArea)).collect(Collectors.toList());

				String name = hthFiltered.get(row).name;

				if (checked && !SaveManager.DE_HEART_TO_HEARTS.contains(name))
					SaveManager.DE_HEART_TO_HEARTS.add(name);
				else if (!checked)
					SaveManager.DE_HEART_TO_HEARTS.remove(name);

				MainFrame.getInstance().updateSaveState(false);
			}
		}
	}
}