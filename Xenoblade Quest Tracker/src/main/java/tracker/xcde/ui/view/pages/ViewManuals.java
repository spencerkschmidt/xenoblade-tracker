package tracker.xcde.ui.view.pages;

import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
import tracker.xcde.items.Manuals;
import tracker.xcde.items.Manuals.Manual;
import tracker.xcde.items.Manuals.ManualType;

@SuppressWarnings("serial")
public class ViewManuals extends JPanel implements IItemView
{
	private JTable manualsTable;
	private JComboBox characterBox;
	private JComboBox manualsBox;
	private JTextField searchBar;

	public ViewManuals()
	{
		this.setBorder(new EmptyBorder(5, 5, 0, 5));
		GridBagLayout manualsViewGBC = new GridBagLayout();
		manualsViewGBC.columnWidths = new int[] {395, 10, 395};
		manualsViewGBC.rowHeights = new int[] {30, 34, 500};
		manualsViewGBC.columnWeights = new double[] {1.0D, 0.0D, 1.0D};
		manualsViewGBC.rowWeights = new double[] {0.0D, 0.0D, 1.0D};
		this.setLayout(manualsViewGBC);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints scrollPaneGBC = new GridBagConstraints();
		scrollPaneGBC.insets = new Insets(0, 0, 5, 0);
		scrollPaneGBC.gridwidth = 3;
		scrollPaneGBC.fill = GridBagConstraints.BOTH;
		scrollPaneGBC.gridx = 0;
		scrollPaneGBC.gridy = 2;
		this.add(scrollPane, scrollPaneGBC);

		String[] columns = new String[] {"Name", "Type", "Character", "Collected"};
		var manuals = Arrays.<Manual> asList(Manuals.ALL_MANUALS);
		Object[][] data = new Object[manuals.size()][];

		for (int i = 0; i < manuals.size(); ++i)
		{
			Manual manual = manuals.get(i);
			List<Object> row = Arrays.asList(manual.name, manual.type.name, manual.character, false);
			data[i] = row.toArray(new Object[row.size()]);
		}

		this.manualsTable = new CustomTable();
		this.manualsTable.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				JTable table = (JTable) e.getSource();
				Point point = e.getPoint();
				int row = table.rowAtPoint(point);

				if (e.getClickCount() == 2 && table.getSelectedRow() != -1)
				{
					ManualType type = ManualType.getFromName((String) table.getValueAt(row, 1));

					if (type == ManualType.ADVANCED)
					{
						JDialog dialog = new JDialog(MainFrame.getInstance(), "Obtained From", Dialog.ModalityType.DOCUMENT_MODAL);
						dialog.setResizable(false);
						dialog.setBounds(0, 0, 300, 300);
						dialog.setLocationRelativeTo(null);
						JScrollPane scrollpane = new JScrollPane();
						JTextArea dropsTextArea = new JTextArea();
						Manual manual = Manuals.getManualFromName(type, (String) table.getValueAt(row, 0));
						String obtained = "";
						String[] obtainedSplit = manual.obtainedFrom;

						for (int i = 0; i < obtainedSplit.length - 1; ++i)
						{
							obtained += obtainedSplit[i] + "\n";
						}

						obtained += obtainedSplit[obtainedSplit.length - 1];
						dropsTextArea.setText(obtained);
						dropsTextArea.setFocusable(false);
						scrollpane.setBounds(0, 0, 300, 300);
						scrollpane.setViewportView(dropsTextArea);
						dialog.getContentPane().add(scrollpane);
						dialog.setVisible(true);
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		this.manualsTable.setModel(new ManualsModel(data, columns));
		this.manualsTable.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(this.manualsTable);
		this.characterBox = new JComboBox(new String[] {"All", "Shulk", "Reyn", "Sharla", "Dunban", "Melia", "Riki", "Fiora"});
		this.manualsBox = new JComboBox(new String[] {"All", "Advanced", "Master"});
		this.characterBox.addActionListener(e ->
		{
			List<Manual> manualsFiltered = manuals;

			if (this.characterBox.getSelectedItem() != null)
			{
				String manualType = (String) this.manualsBox.getSelectedItem();
				String character = (String) this.characterBox.getSelectedItem();
				ManualType type = ManualType.getFromName(manualType);

				if (!character.equals("All"))
				{
					if (!manualType.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type && m.character.equalsIgnoreCase(character)).collect(Collectors.toList());
					else
						manualsFiltered = manualsFiltered.stream().filter(m -> m.character.equalsIgnoreCase(character)).collect(Collectors.toList());
				}
				else
				{
					if (!manualType.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type).collect(Collectors.toList());
				}

				int size = manualsFiltered.size();
				Object[][] newData = new Object[size][];

				for (int i = 0; i < size; ++i)
				{
					Manual manual = manualsFiltered.get(i);
					List<Object> row = Arrays.asList(manual.name, manual.type.name, manual.character);
					newData[i] = row.toArray(new Object[row.size()]);
				}

				this.manualsTable.setModel(new ManualsModel(newData, columns));
				this.manualsTable.setRowSorter(new TableItemSorter<TableModel>(this.manualsTable.getModel()));

				for (int i = 0; i < size; ++i)
				{
					String manualName = (String) this.manualsTable.getModel().getValueAt(i, 0);
					ManualType typeRow = ManualType.getFromName((String) manualsTable.getModel().getValueAt(i, 1));

					if (typeRow == ManualType.ADVANCED && SaveManager.ADVANCED_MANUALS.contains(Manuals.getManualFromName(ManualType.ADVANCED, manualName)))
						this.manualsTable.getModel().setValueAt(true, i, 3);
					else if (typeRow == ManualType.MASTER && SaveManager.MASTER_MANUALS.contains(Manuals.getManualFromName(ManualType.MASTER, manualName)))
						this.manualsTable.getModel().setValueAt(true, i, 3);
				}

				this.manualsTable.getModel().addTableModelListener(new ManualsTableModelListener(this.manualsTable, this.characterBox, this.manualsBox));

				if (!this.searchBar.getText().isEmpty())
				{
					String filter = ViewManuals.this.searchBar.getText();
					TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) ViewManuals.this.manualsTable.getRowSorter();

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
		this.manualsBox.addActionListener(e ->
		{
			List<Manual> manualsFiltered = manuals;

			if (this.characterBox.getSelectedItem() != null)
			{
				String manualTypeString = (String) this.manualsBox.getSelectedItem();
				String characterString = (String) this.characterBox.getSelectedItem();
				ManualType type = ManualType.getFromName(manualTypeString);

				if (!manualTypeString.equals("All"))
				{
					if (!characterString.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type && m.character.equalsIgnoreCase(characterString)).collect(Collectors.toList());
					else
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type).collect(Collectors.toList());
				}
				else
				{
					if (!characterString.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.character.equalsIgnoreCase(characterString)).collect(Collectors.toList());
				}

				int size = manualsFiltered.size();
				Object[][] newData = new Object[size][];

				for (int i = 0; i < size; ++i)
				{
					Manual manual = manualsFiltered.get(i);
					List<Object> row = Arrays.asList(manual.name, manual.type.name, manual.character);
					newData[i] = row.toArray(new Object[row.size()]);
				}

				this.manualsTable.setModel(new ManualsModel(newData, columns));
				this.manualsTable.setRowSorter(new TableItemSorter<TableModel>(this.manualsTable.getModel()));

				for (int i = 0; i < size; ++i)
				{
					String manualName = (String) this.manualsTable.getModel().getValueAt(i, 0);
					ManualType manualType = ManualType.getFromName((String) this.manualsTable.getModel().getValueAt(i, 1));

					if (manualType == ManualType.ADVANCED && SaveManager.ADVANCED_MANUALS.contains(Manuals.getManualFromName(ManualType.ADVANCED, manualName)))
						this.manualsTable.getModel().setValueAt(true, i, 3);
					else if (manualType == ManualType.MASTER && SaveManager.MASTER_MANUALS.contains(Manuals.getManualFromName(ManualType.MASTER, manualName)))
						this.manualsTable.getModel().setValueAt(true, i, 3);
				}

				this.manualsTable.getModel().addTableModelListener(new ManualsTableModelListener(this.manualsTable, this.characterBox, this.manualsBox));

				if (!this.searchBar.getText().isEmpty())
				{
					String filter = ViewManuals.this.searchBar.getText();
					TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) ViewManuals.this.manualsTable.getRowSorter();

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

		GridBagConstraints characterBoxGBC = new GridBagConstraints();
		characterBoxGBC.insets = new Insets(0, 0, 5, 0);
		characterBoxGBC.fill = GridBagConstraints.BOTH;
		characterBoxGBC.gridx = 0;
		characterBoxGBC.gridy = 1;
		this.add(characterBox, characterBoxGBC);
		GridBagConstraints manualsGBC = new GridBagConstraints();
		manualsGBC.insets = new Insets(0, 0, 5, 0);
		manualsGBC.fill = GridBagConstraints.BOTH;
		manualsGBC.gridx = 2;
		manualsGBC.gridy = 1;
		this.add(this.manualsBox, manualsGBC);
		this.manualsTable.getModel().addTableModelListener(new ManualsTableModelListener(this.manualsTable, this.characterBox, this.manualsBox));
		this.manualsTable.setRowSorter(new TableItemSorter<TableModel>(this.manualsTable.getModel()));

		for (int i = 0; i < this.manualsTable.getRowCount(); ++i)
		{
			String manualName = (String) manualsTable.getModel().getValueAt(i, 0);
			ManualType type = ManualType.getFromName((String) this.manualsTable.getValueAt(i, 1));

			if (type == ManualType.ADVANCED && SaveManager.ADVANCED_MANUALS.contains(Manuals.getManualFromName(ManualType.ADVANCED, manualName)))
				this.manualsTable.getModel().setValueAt(true, i, 3);
			else if (type == ManualType.MASTER && SaveManager.MASTER_MANUALS.contains(Manuals.getManualFromName(ManualType.MASTER, manualName)))
				this.manualsTable.getModel().setValueAt(true, i, 3);
		}

		this.searchBar = new JTextField();
		this.searchBar.setDocument(new FilterSearchBar(this));
		this.searchBar.getDocument().addDocumentListener(new DocumentListenerSearchBar(this.searchBar, this.manualsTable));
		GridBagConstraints searchBarGBC = new GridBagConstraints();
		searchBarGBC.insets = new Insets(0, 0, 5, 0);
		searchBarGBC.gridwidth = 3;
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
		if (this.manualsBox != null && this.characterBox != null && this.manualsTable != null)
		{
			var manualsFiltered = Arrays.<Manual> asList(Manuals.ALL_MANUALS);

			if (this.characterBox.getSelectedItem() != null && this.manualsBox.getSelectedItem() != null)
			{
				String manualType = (String) this.manualsBox.getSelectedItem();
				String character = (String) this.characterBox.getSelectedItem();
				ManualType type = ManualType.getFromName(manualType);

				if (!character.equals("All"))
				{
					if (!manualType.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type && m.character.equalsIgnoreCase(character)).collect(Collectors.toList());
					else
						manualsFiltered = manualsFiltered.stream().filter(m -> m.character.equalsIgnoreCase(character)).collect(Collectors.toList());
				}
				else
				{
					if (!manualType.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type).collect(Collectors.toList());
				}

				for (int i = 0; i < manualsFiltered.size(); ++i)
				{
					this.manualsTable.getModel().setValueAt(false, i, 3);
					String manualName = (String) this.manualsTable.getModel().getValueAt(i, 0);
					ManualType typeRow = ManualType.getFromName((String) this.manualsTable.getModel().getValueAt(i, 1));

					if (typeRow == ManualType.ADVANCED && SaveManager.ADVANCED_MANUALS.contains(Manuals.getManualFromName(ManualType.ADVANCED, manualName)))
						this.manualsTable.getModel().setValueAt(true, i, 3);
					else if (typeRow == ManualType.MASTER && SaveManager.MASTER_MANUALS.contains(Manuals.getManualFromName(ManualType.MASTER, manualName)))
						this.manualsTable.getModel().setValueAt(true, i, 3);
				}
			}
		}
	}

	/**
	 * Sets all of the items in the current view to be selected.
	 */
	@Override
	public void selectAll()
	{
		if (this.manualsBox.getSelectedItem() != null)
		{
			String manualType = (String) this.manualsBox.getSelectedItem();
			ManualType type = ManualType.getFromName(manualType);

			if (!manualType.equalsIgnoreCase("All"))
			{
				if (type == ManualType.ADVANCED)
					Arrays.<Manual> asList(Manuals.ADVANCED_MANUALS).stream().filter(m -> !SaveManager.ADVANCED_MANUALS.contains(m)).forEach(SaveManager.ADVANCED_MANUALS::add);
				else if (type == ManualType.MASTER)
					Arrays.<Manual> asList(Manuals.MASTER_MANUALS).stream().filter(m -> !SaveManager.MASTER_MANUALS.contains(m)).forEach(SaveManager.MASTER_MANUALS::add);
			}
			else
			{
				for (Manual manual : Manuals.ALL_MANUALS)
				{
					if (manual.type == ManualType.ADVANCED)
					{
						if (!SaveManager.ADVANCED_MANUALS.contains(manual))
							SaveManager.ADVANCED_MANUALS.add(manual);
					}
					else if (manual.type == ManualType.MASTER)
					{
						if (!SaveManager.MASTER_MANUALS.contains(manual))
							SaveManager.MASTER_MANUALS.add(manual);
					}
				}
			}
		}

		this.reselect();
	}

	/**
	 * Sets all of the items in the current view to be unselected.
	 */
	@Override
	public void unselectAll()
	{
		if (this.manualsBox.getSelectedItem() != null)
		{
			String manualType = (String) this.manualsBox.getSelectedItem();
			ManualType type = ManualType.getFromName(manualType);

			if (!manualType.equalsIgnoreCase("All"))
			{
				if (type == ManualType.ADVANCED)
					Arrays.<Manual> asList(Manuals.ADVANCED_MANUALS).forEach(SaveManager.ADVANCED_MANUALS::remove);
				else if (type == ManualType.MASTER)
					Arrays.<Manual> asList(Manuals.MASTER_MANUALS).forEach(SaveManager.MASTER_MANUALS::remove);
			}
			else
			{
				for (Manual manual : Manuals.ALL_MANUALS)
				{
					if (manual.type == ManualType.ADVANCED)
						SaveManager.ADVANCED_MANUALS.remove(manual);
					else if (manual.type == ManualType.MASTER)
						SaveManager.MASTER_MANUALS.remove(manual);
				}
			}
		}

		this.reselect();
	}

	private class ManualsModel extends DefaultTableModel
	{
		private ManualsModel(Object[][] data, Object[] columnNames)
		{
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column)
		{
			return column == 3;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			if (columnIndex == 3)
				return Boolean.class;
			else
				return super.getColumnClass(columnIndex);
		}
	}

	private class ManualsTableModelListener implements TableModelListener
	{
		final JTable table;
		final JComboBox charactersBox;
		final JComboBox manualsBox;

		public ManualsTableModelListener(JTable table, JComboBox charactersBox, JComboBox manualsBox)
		{
			this.table = table;
			this.charactersBox = charactersBox;
			this.manualsBox = manualsBox;
		}

		@Override
		public void tableChanged(TableModelEvent e)
		{
			if (!(this.table.getSelectedRow() == -1))
			{
				int row = this.table.convertRowIndexToModel(this.table.getSelectedRow());
				boolean checked = (Boolean) this.table.getModel().getValueAt(row, 3);
				String selectedCharacter = (String) this.charactersBox.getSelectedItem();
				String selectedManuals = (String) this.manualsBox.getSelectedItem();
				List<Manual> manualsFiltered = Arrays.asList(Manuals.ALL_MANUALS);

				if (!selectedCharacter.equals("All"))
				{
					if (!selectedManuals.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == ManualType.getFromName(selectedManuals) && m.character.equalsIgnoreCase(selectedCharacter)).collect(Collectors.toList());
					else
						manualsFiltered = manualsFiltered.stream().filter(m -> m.character.equalsIgnoreCase(selectedCharacter)).collect(Collectors.toList());
				}
				else if (!selectedManuals.equals("All"))
				{
					ManualType type = ManualType.getFromName(selectedManuals);

					if (!selectedCharacter.equals("All"))
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type && m.character.equalsIgnoreCase(selectedCharacter)).collect(Collectors.toList());
					else
						manualsFiltered = manualsFiltered.stream().filter(m -> m.type == type).collect(Collectors.toList());
				}

				Manual manual = manualsFiltered.get(row);

				if (checked)
				{
					if (manual.type == ManualType.ADVANCED)
						SaveManager.ADVANCED_MANUALS.add(manual);
					else
						SaveManager.MASTER_MANUALS.add(manual);
				}
				else
				{
					if (manual.type == ManualType.ADVANCED)
						SaveManager.ADVANCED_MANUALS.remove(manual);
					else
						SaveManager.MASTER_MANUALS.remove(manual);
				}

				MainFrame.getInstance().updateSaveState(false);
			}
		}
	}
}