package tracker.xcde.ui.view.pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.Collections;
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
import tracker.xcde.items.Achievements;
import tracker.xcde.items.Achievements.Achievement;
import tracker.xcde.items.Achievements.Achievement.AchievementType;

@SuppressWarnings("serial")
public class ViewAchievements extends JPanel implements IItemView
{
	private JTable achievementsTable;
	private JComboBox achievementsBox;
	private JProgressBar recordProgress;
	private JProgressBar trialProgress;
	private JTextField searchBar;

	public ViewAchievements()
	{
		this.setBorder(new EmptyBorder(5, 5, 0, 5));
		GridBagLayout achievementsViewGBC = new GridBagLayout();
		achievementsViewGBC.columnWidths = new int[] {624};
		achievementsViewGBC.rowHeights = new int[] {30, 34, 410, 25, 25};
		achievementsViewGBC.columnWeights = new double[] {1.0D};
		achievementsViewGBC.rowWeights = new double[] {0.0, 0.0, 1.0D, 0.0D, 0.0D};
		this.setLayout(achievementsViewGBC);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints scrollPaneGBC = new GridBagConstraints();
		scrollPaneGBC.insets = new Insets(0, 0, 5, 0);
		scrollPaneGBC.fill = GridBagConstraints.BOTH;
		scrollPaneGBC.gridx = 0;
		scrollPaneGBC.gridy = 2;
		this.add(scrollPane, scrollPaneGBC);

		String[] columns = new String[] {"Award", "Type", "Details", "EXP", "Completed"};
		var achievements = Arrays.<Achievement> asList(Achievements.ACHIEVEMENTS);
		Object[][] data = new Object[achievements.size()][];

		for (int i = 0; i < achievements.size(); ++i)
		{
			Achievement achievement = achievements.get(i);
			List<Object> row = Arrays.asList(achievement.name, achievement.type.name, achievement.details, achievement.xpReward, false);
			data[i] = row.toArray(new Object[row.size()]);
		}

		this.achievementsTable = new CustomTable();
		this.achievementsTable.setModel(new AchievementsModel(data, columns));
		this.achievementsTable.getTableHeader().setReorderingAllowed(false);
		this.achievementsTable.setRowSorter(new TableItemSorter<TableModel>(this.achievementsTable.getModel()));
		scrollPane.setViewportView(this.achievementsTable);
		this.achievementsBox = new JComboBox(new String[] {"All", "Trials", "Records"});
		this.achievementsBox.addActionListener(e ->
		{
			List<Achievement> achievementsFiltered = achievements;

			if (this.achievementsBox.getSelectedItem() != null)
			{
				String selected = (String) this.achievementsBox.getSelectedItem();

				if (!selected.equals("All"))
					achievementsFiltered = achievements.stream().filter(a -> a.type == AchievementType.getFromType(selected)).collect(Collectors.toList());

				int size = achievementsFiltered.size();
				Object[][] newData = new Object[size][];

				for (int i = 0; i < size; ++i)
				{
					Achievement achievement = achievementsFiltered.get(i);
					List<Object> row = Arrays.asList(achievement.name, achievement.type.name, achievement.details, achievement.xpReward, false);
					newData[i] = row.toArray(new Object[row.size()]);
				}

				this.achievementsTable.setModel(new AchievementsModel(newData, columns));
				this.achievementsTable.setRowSorter(new TableItemSorter<TableModel>(this.achievementsTable.getModel()));

				for (int i = 0; i < size; ++i)
				{
					if (SaveManager.ACHIEVEMENTS.contains(this.achievementsTable.getModel().getValueAt(i, 0)))
						this.achievementsTable.getModel().setValueAt(true, i, 4);
				}

				this.achievementsTable.getModel().addTableModelListener(new AchievementsTableModelListener(this.achievementsTable, this.achievementsBox));

				if (!this.searchBar.getText().isEmpty())
				{
					String filter = ViewAchievements.this.searchBar.getText();
					TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) ViewAchievements.this.achievementsTable.getRowSorter();

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
		this.add(this.achievementsBox, comboBoxGBC);
		this.achievementsTable.getModel().addTableModelListener(new AchievementsTableModelListener(this.achievementsTable, this.achievementsBox));

		for (int i = 0; i < this.achievementsTable.getRowCount(); ++i)
		{
			if (SaveManager.ACHIEVEMENTS.contains(this.achievementsTable.getModel().getValueAt(i, 0)))
				this.achievementsTable.getModel().setValueAt(true, i, 4);
		}

		this.recordProgress = new JProgressBar(0, 150);
		this.trialProgress = new JProgressBar(0, 50);
		this.recordProgress.setStringPainted(true);
		this.trialProgress.setStringPainted(true);
		this.updateRecordProgress();
		this.updateTrialProgress();
		GridBagConstraints recordsGBC = new GridBagConstraints();
		recordsGBC.insets = new Insets(0, 0, 5, 0);
		recordsGBC.gridheight = 1;
		recordsGBC.fill = GridBagConstraints.BOTH;
		recordsGBC.gridx = 0;
		recordsGBC.gridy = 3;
		this.add(this.recordProgress, recordsGBC);
		GridBagConstraints trialsGBC = new GridBagConstraints();
		trialsGBC.insets = new Insets(0, 0, 5, 0);
		trialsGBC.gridheight = 1;
		trialsGBC.fill = GridBagConstraints.BOTH;
		trialsGBC.gridx = 0;
		trialsGBC.gridy = 4;
		this.add(this.trialProgress, trialsGBC);

		this.searchBar = new JTextField();
		this.searchBar.setDocument(new FilterSearchBar(this));
		this.searchBar.getDocument().addDocumentListener(new DocumentListenerSearchBar(this.searchBar, this.achievementsTable));
		GridBagConstraints searchBarGBC = new GridBagConstraints();
		searchBarGBC.insets = new Insets(0, 0, 5, 0);
		searchBarGBC.gridheight = 1;
		searchBarGBC.fill = GridBagConstraints.BOTH;
		searchBarGBC.gridx = 0;
		searchBarGBC.gridy = 0;
		this.add(this.searchBar, searchBarGBC);
	}

	public void reselect()
	{
		if (this.achievementsBox != null && this.achievementsTable != null)
		{
			List<Achievement> achievementsFiltered = Arrays.asList(Achievements.ACHIEVEMENTS);

			if (this.achievementsBox.getSelectedItem() != null)
			{
				String selected = (String) this.achievementsBox.getSelectedItem();

				if (!selected.equals("All"))
					achievementsFiltered = achievementsFiltered.stream().filter(a -> a.type == AchievementType.getFromType(selected)).collect(Collectors.toList());

				for (int i = 0; i < achievementsFiltered.size(); ++i)
				{
					this.achievementsTable.getModel().setValueAt(false, i, 4);

					if (SaveManager.ACHIEVEMENTS.contains(this.achievementsTable.getModel().getValueAt(i, 0)))
						this.achievementsTable.getModel().setValueAt(true, i, 4);
				}
			}
		}

		this.updateRecordProgress();
		this.updateTrialProgress();
	}

	@Override
	public void selectAll()
	{
		if (this.achievementsBox.getSelectedItem() != null)
		{
			String itemSelected = (String) this.achievementsBox.getSelectedItem();

			if (!itemSelected.equalsIgnoreCase("All"))
			{
				Arrays.<Achievement> asList(Achievements.ACHIEVEMENTS).stream()
					.filter(a -> a.type == AchievementType.getFromType(itemSelected) && !SaveManager.ACHIEVEMENTS.contains(a.name))
					.map(a -> a.name).forEach(SaveManager.ACHIEVEMENTS::add);
			}
			else
			{
				Arrays.<Achievement> asList(Achievements.ACHIEVEMENTS).stream()
					.filter(a -> !SaveManager.ACHIEVEMENTS.contains(a.name))
					.map(a -> a.name).forEach(SaveManager.ACHIEVEMENTS::add);
			}
		}

		this.reselect();
	}

	@Override
	public void unselectAll()
	{
		if (this.achievementsBox.getSelectedItem() != null)
		{
			String itemSelected = (String) this.achievementsBox.getSelectedItem();

			if (!itemSelected.equalsIgnoreCase("All"))
			{
				Arrays.<Achievement> asList(Achievements.ACHIEVEMENTS).stream()
					.filter(a -> a.type == AchievementType.getFromType(itemSelected))
					.map(a -> a.name).forEach(SaveManager.ACHIEVEMENTS::remove);
			}
			else
				Arrays.<Achievement> asList(Achievements.ACHIEVEMENTS).stream().map(a -> a.name).forEach(SaveManager.ACHIEVEMENTS::remove);
		}

		this.reselect();
	}

	private void updateRecordProgress()
	{
		int recordsCount = (int) SaveManager.ACHIEVEMENTS.stream().filter(s -> Achievements.getFromName(s).type == AchievementType.RECORD).count();
		this.recordProgress.setString("Records: " + recordsCount + "/150 (" + String.format("%.2f", ((double) recordsCount / 150.0D) * 100.0D) + "%)");
		this.recordProgress.setValue(recordsCount);
	}

	private void updateTrialProgress()
	{
		int trialsCount = (int) SaveManager.ACHIEVEMENTS.stream().filter(s -> Achievements.getFromName(s).type == AchievementType.TRIAL).count();
		this.trialProgress.setString("Trials: " + trialsCount + "/50 (" + String.format("%.2f", ((double) trialsCount / 50.0D) * 100.0D) + "%)");
		this.trialProgress.setValue(trialsCount);
	}

	private class AchievementsModel extends DefaultTableModel
	{
		private AchievementsModel(Object[][] data, Object[] columnNames)
		{
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column)
		{
			return column == 4;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			if (columnIndex == 4)
				return Boolean.class;
			else
				return super.getColumnClass(columnIndex);
		}
	}

	private class AchievementsTableModelListener implements TableModelListener
	{
		final JTable table;
		final JComboBox comboBox;

		public AchievementsTableModelListener(JTable table, JComboBox comboBox)
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
				boolean checked = (Boolean) this.table.getModel().getValueAt(row, 4);
				String selectedType = (String) this.comboBox.getSelectedItem();
				List<Achievement> achievementsFiltered = Arrays.asList(Achievements.ACHIEVEMENTS);

				if (!selectedType.equalsIgnoreCase("All"))
					achievementsFiltered = achievementsFiltered.stream().filter(a -> a.type == AchievementType.getFromType(selectedType)).collect(Collectors.toList());

				Achievement achievement = achievementsFiltered.get(row);
				String name = achievement.name;

				if (checked && !SaveManager.ACHIEVEMENTS.contains(name))
					SaveManager.ACHIEVEMENTS.add(name);
				else if (!checked)
					SaveManager.ACHIEVEMENTS.remove(name);

				Collections.sort(SaveManager.ACHIEVEMENTS, (a, b) -> Achievements.getFromName(a).type.ordinal() > Achievements.getFromName(b).type.ordinal() ? -1 : 1);

				if (achievement.type == AchievementType.RECORD)
					ViewAchievements.this.updateRecordProgress();
				else
					ViewAchievements.this.updateTrialProgress();

				MainFrame.getInstance().updateSaveState(false);
			}
		}
	}
}