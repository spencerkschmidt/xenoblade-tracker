package tracker.xcde.ui.view.pages;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import tracker.ui.CheckBoxList;
import tracker.ui.MainFrame;
import tracker.ui.SaveManager;
import tracker.ui.view.elements.IItemView;
import tracker.xcde.items.DELocation;
import tracker.xcde.items.DEQuests;
import tracker.xcde.items.DEQuests.DEQuest;
import tracker.xcde.items.DEQuests.QuestType;

@SuppressWarnings("serial")
public class ViewListQuests extends JPanel implements IItemView
{
	private static final int COLONY_9 = 0, TEPHRA_CAVE = 1, BIONIS_LEG = 2, COLONY_6 = 3,
			SATORL_MARSH = 4, MAKNA_FOREST = 5, FRONTIER_VILLAGE = 6, ERYTH_SEA = 7, ALCAMOTH = 8,
			VALAK_MOUNTAIN = 9, SWORD_VALLEY = 10, GALAHAD_FORTRESS = 11, FALLEN_ARM = 12,
			MECHONIS_FIELD = 13, CENTRAL_FACTORY = 14, AGNIRATHA = 15, PRISON_ISLAND = 16;
	private JProgressBar areaProgress;
	private JProgressBar totalProgress;
	private JTextField searchBar;
	private JTabbedPane tabbedPane;
	private JScrollPane colony9;
	private JScrollPane tephraCave;
	private JScrollPane bionisLeg;
	private JScrollPane colony6;
	private JScrollPane satorlMarsh;
	private JScrollPane maknaForest;
	private JScrollPane frontierVillage;
	private JScrollPane erythSea;
	private JScrollPane alcamoth;
	private JScrollPane valakMountain;
	private JScrollPane swordValley;
	private JScrollPane galahadFortress;
	private JScrollPane fallenArm;
	private JScrollPane mechonisField;
	private JScrollPane centralFactory;
	private JScrollPane agniratha;
	private JScrollPane prisonIsland;
	private CheckBoxList colony9List = new CheckBoxList();
	private CheckBoxList tephraCaveList = new CheckBoxList();
	private CheckBoxList bionisLegList = new CheckBoxList();
	private CheckBoxList colony6List = new CheckBoxList();
	private CheckBoxList satorlMarshList = new CheckBoxList();
	private CheckBoxList maknaForestList = new CheckBoxList();
	private CheckBoxList frontierList = new CheckBoxList();
	private CheckBoxList erythList = new CheckBoxList();
	private CheckBoxList alcamothList = new CheckBoxList();
	private CheckBoxList valakList = new CheckBoxList();
	private CheckBoxList swordValleyList = new CheckBoxList();
	private CheckBoxList galahadList = new CheckBoxList();
	private CheckBoxList fallenArmList = new CheckBoxList();
	private CheckBoxList mechonisFieldList = new CheckBoxList();
	private CheckBoxList centralFactoryList = new CheckBoxList();
	private CheckBoxList agnirathaList = new CheckBoxList();
	private CheckBoxList prisonIslandList = new CheckBoxList();
	private Map<DELocation, Integer> areaCompletionProgresses = new HashMap<DELocation, Integer>();
	private DELocation currentLocation = DELocation.COLONY_9;
	private int totalCompleted;

	public ViewListQuests()
	{
		for (DELocation loc : DELocation.values())
		{
			if (loc != DELocation.BIONIS_INTERIOR && loc != DELocation.ETHER_MINE && loc != DELocation.HIGH_ENTIA_TOMB && loc != DELocation.OTHER)
				this.areaCompletionProgresses.put(loc, 0);
		}

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout contentPaneGBC = new GridBagLayout();
		contentPaneGBC.columnWidths = new int[] {624};
		contentPaneGBC.rowHeights = new int[] {30, 480, 25, 20};
		contentPaneGBC.columnWeights = new double[] {1.0};
		contentPaneGBC.rowWeights = new double[] {0.0, 1.0, 0.0, 0.0};
		this.setLayout(contentPaneGBC);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints tabbedPaneGBC = new GridBagConstraints();
		tabbedPaneGBC.fill = GridBagConstraints.BOTH;
		tabbedPaneGBC.gridx = 0;
		tabbedPaneGBC.gridy = 1;
		this.add(this.tabbedPane, tabbedPaneGBC);

		this.colony9 = new JScrollPane();
		this.tephraCave = new JScrollPane();
		this.bionisLeg = new JScrollPane();
		this.colony6 = new JScrollPane();
		this.satorlMarsh = new JScrollPane();
		this.maknaForest = new JScrollPane();
		this.frontierVillage = new JScrollPane();
		this.erythSea = new JScrollPane();
		this.alcamoth = new JScrollPane();
		this.valakMountain = new JScrollPane();
		this.swordValley = new JScrollPane();
		this.galahadFortress = new JScrollPane();
		this.fallenArm = new JScrollPane();
		this.mechonisField = new JScrollPane();
		this.centralFactory = new JScrollPane();
		this.agniratha = new JScrollPane();
		this.prisonIsland = new JScrollPane();
		this.tabbedPane.addTab("Colony 9", null, this.colony9, null);
		this.tabbedPane.addTab("Tephra Cave", null, this.tephraCave, null);
		this.tabbedPane.addTab("Bionis' Leg", null, this.bionisLeg, null);
		this.tabbedPane.addTab("Colony 6", null, this.colony6, null);
		this.tabbedPane.addTab("Satorl Marsh", null, this.satorlMarsh, null);
		this.tabbedPane.addTab("Makna Forest", null, this.maknaForest, null);
		this.tabbedPane.addTab("Frontier Village", null, this.frontierVillage, null);
		this.tabbedPane.addTab("Eryth Sea", null, this.erythSea, null);
		this.tabbedPane.addTab("Alcamoth", null, this.alcamoth, null);
		this.tabbedPane.addTab("Valak Mountain", null, this.valakMountain, null);
		this.tabbedPane.addTab("Sword Valley", null, this.swordValley, null);
		this.tabbedPane.addTab("Galahad Fortress", null, this.galahadFortress, null);
		this.tabbedPane.addTab("Fallen Arm", null, this.fallenArm, null);
		this.tabbedPane.addTab("Mechonis Field", null, this.mechonisField, null);
		this.tabbedPane.addTab("Central Factory", null, this.centralFactory, null);
		this.tabbedPane.addTab("Agniratha", null, this.agniratha, null);
		this.tabbedPane.addTab("Prison Island", null, this.prisonIsland, null);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 12));

		this.addQuests(this.colony9List, DELocation.COLONY_9);
		this.addQuests(this.tephraCaveList, DELocation.TEPHRA_CAVE);
		this.addQuests(this.bionisLegList, DELocation.BIONIS_LEG);
		this.addQuests(this.colony6List, DELocation.COLONY_6);
		this.addQuests(this.satorlMarshList, DELocation.SATORL_MARSH);
		this.addQuests(this.maknaForestList, DELocation.MAKNA_FOREST);
		this.addQuests(this.frontierList, DELocation.FRONTIER_VILLAGE);
		this.addQuests(this.erythList, DELocation.ERYTH_SEA);
		this.addQuests(this.alcamothList, DELocation.ALCAMOTH);
		this.addQuests(this.valakList, DELocation.VALAK_MOUNTAIN);
		this.addQuests(this.swordValleyList, DELocation.SWORD_VALLEY);
		this.addQuests(this.galahadList, DELocation.GALAHAD_FORTRESS);
		this.addQuests(this.fallenArmList, DELocation.FALLEN_ARM);
		this.addQuests(this.mechonisFieldList, DELocation.MECHONIS_FIELD);
		this.addQuests(this.centralFactoryList, DELocation.CENTRAL_FACTORY);
		this.addQuests(this.agnirathaList, DELocation.AGNIRATHA);
		this.addQuests(this.prisonIslandList, DELocation.PRISON_ISLAND);
		this.colony9.setViewportView(this.colony9List);
		this.tephraCave.setViewportView(this.tephraCaveList);
		this.bionisLeg.setViewportView(this.bionisLegList);
		this.colony6.setViewportView(this.colony6List);
		this.satorlMarsh.setViewportView(this.satorlMarshList);
		this.maknaForest.setViewportView(this.maknaForestList);
		this.frontierVillage.setViewportView(this.frontierList);
		this.erythSea.setViewportView(this.erythList);
		this.alcamoth.setViewportView(this.alcamothList);
		this.valakMountain.setViewportView(this.valakList);
		this.swordValley.setViewportView(this.swordValleyList);
		this.galahadFortress.setViewportView(this.galahadList);
		this.fallenArm.setViewportView(this.fallenArmList);
		this.mechonisField.setViewportView(this.mechonisFieldList);
		this.centralFactory.setViewportView(this.centralFactoryList);
		this.agniratha.setViewportView(this.agnirathaList);
		this.prisonIsland.setViewportView(this.prisonIslandList);

		this.areaProgress = new JProgressBar();
		this.areaProgress.setMaximum(DELocation.COLONY_9.getTotalQuest());
		this.areaProgress.setStringPainted(true);
		GridBagConstraints areaProgressGBC = new GridBagConstraints();
		areaProgressGBC.insets = new Insets(0, 0, 5, 0);
		areaProgressGBC.fill = GridBagConstraints.BOTH;
		areaProgressGBC.gridx = 0;
		areaProgressGBC.gridy = 2;
		this.add(this.areaProgress, areaProgressGBC);

		this.totalProgress = new JProgressBar(0, 480);
		this.totalProgress.setStringPainted(true);
		GridBagConstraints totalProgressGBC = new GridBagConstraints();
		totalProgressGBC.fill = GridBagConstraints.BOTH;
		totalProgressGBC.gridx = 0;
		totalProgressGBC.gridy = 3;
		this.add(this.totalProgress, totalProgressGBC);

		this.tabbedPane.addChangeListener(e ->
		{
			int index = this.tabbedPane.getSelectedIndex();

			switch (index)
			{
			case COLONY_9:
				this.currentLocation = DELocation.COLONY_9;
				break;
			case TEPHRA_CAVE:
				this.currentLocation = DELocation.TEPHRA_CAVE;
				break;
			case BIONIS_LEG:
				this.currentLocation = DELocation.BIONIS_LEG;
				break;
			case COLONY_6:
				this.currentLocation = DELocation.COLONY_6;
				break;
			case SATORL_MARSH:
				this.currentLocation = DELocation.SATORL_MARSH;
				break;
			case MAKNA_FOREST:
				this.currentLocation = DELocation.MAKNA_FOREST;
				break;
			case FRONTIER_VILLAGE:
				this.currentLocation = DELocation.FRONTIER_VILLAGE;
				break;
			case ERYTH_SEA:
				this.currentLocation = DELocation.ERYTH_SEA;
				break;
			case ALCAMOTH:
				this.currentLocation = DELocation.ALCAMOTH;
				break;
			case VALAK_MOUNTAIN:
				this.currentLocation = DELocation.VALAK_MOUNTAIN;
				break;
			case SWORD_VALLEY:
				this.currentLocation = DELocation.SWORD_VALLEY;
				break;
			case GALAHAD_FORTRESS:
				this.currentLocation = DELocation.GALAHAD_FORTRESS;
				break;
			case FALLEN_ARM:
				this.currentLocation = DELocation.FALLEN_ARM;
				break;
			case MECHONIS_FIELD:
				this.currentLocation = DELocation.MECHONIS_FIELD;
				break;
			case CENTRAL_FACTORY:
				this.currentLocation = DELocation.CENTRAL_FACTORY;
				break;
			case AGNIRATHA:
				this.currentLocation = DELocation.AGNIRATHA;
				break;
			case PRISON_ISLAND:
				this.currentLocation = DELocation.PRISON_ISLAND;
				break;
			}

			this.areaProgress.setMaximum(this.currentLocation.getTotalQuest());
			this.setAreaProgress(this.areaCompletionProgresses.get(this.currentLocation));
		});

		this.searchBar = new JTextField();
		this.searchBar.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e) { filter(); }

			@Override
			public void removeUpdate(DocumentEvent e) { filter(); }

			@Override
			public void changedUpdate(DocumentEvent e) {}

			private void filter()
			{
				String filter = ViewListQuests.this.searchBar.getText();
				CheckBoxList currentBoxList = ViewListQuests.this.getListFromTabIndex(ViewListQuests.this.tabbedPane.getSelectedIndex());
				ViewListQuests.this.filterModel(currentBoxList, filter);

				if (filter.isEmpty())
				{
					var model = (DefaultListModel<JCheckBox>) currentBoxList.getModel();
					model.removeAllElements();
					var matches = new ArrayList<DEQuest>();

					for (DEQuest q : DEQuests.getQuestArray(currentLocation))
					{
						String s = q.getName().toLowerCase();

						if (!s.startsWith(filter.toLowerCase()))
						{
							for (int i = 0; i < model.getSize(); ++i)
							{
								JCheckBox box = model.getElementAt(i);

								if (box.getText().toLowerCase().startsWith(s))
									model.remove(i);
							}
						}
						else
						{
							boolean contained = false;

							for (int i = 0; i < model.getSize(); ++i)
							{
								JCheckBox box = model.getElementAt(i);

								if (box.getText().toLowerCase().startsWith(s))
									contained = true;
							}

							if (!contained)
							{
								matches.add(q);
							}
						}
					}

					Collections.sort(matches, (a, b) -> a.getUniqueID() > b.getUniqueID() ? 1 : -1);

					for (DEQuest q : matches)
					{
						ViewListQuests.this.addQuest(q, ViewListQuests.this.currentLocation, currentBoxList);
					}

					for (int i = 0; i < currentBoxList.getModel().getSize(); ++i)
					{
						JCheckBox box = (JCheckBox) currentBoxList.getModel().getElementAt(i);
						DEQuest quest = DEQuests.getQuestFromNameByLocation(ViewListQuests.this.currentLocation, box.getText());

						if (quest != null)
							box.setSelected(SaveManager.defintiveCompletedQuests.containsKey(quest.getUniqueID()));
					}
				}
			}
		});

		GridBagConstraints searchBarGBC = new GridBagConstraints();
		searchBarGBC.insets = new Insets(0, 0, 5, 0);
		searchBarGBC.fill = GridBagConstraints.BOTH;
		searchBarGBC.gridx = 0;
		searchBarGBC.gridy = 0;
		this.add(this.searchBar, searchBarGBC);
		this.searchBar.setColumns(10);
		this.setAreaProgress(this.areaProgress.getValue());
		this.setTotalProgress(this.totalCompleted);

		for (DELocation loc : DELocation.values())
		{
			if (loc != DELocation.BIONIS_INTERIOR && loc != DELocation.ETHER_MINE && loc != DELocation.HIGH_ENTIA_TOMB && loc != DELocation.OTHER)
				this.updateTabToolTip(loc);
		}
	}

	private void addQuests(CheckBoxList boxList, DELocation location)
	{
		for (DEQuest q : DEQuests.getQuestArray(location))
		{
			this.addQuest(q, location, boxList);
		}
	}

	private void addQuest(DEQuest quest, DELocation location, CheckBoxList boxList)
	{
		JCheckBox button = new JCheckBox();
		QuestType[] types = quest.getTypes();
		String s = "";

		for (QuestType t : types)
		{
			if (types.length > 1)
			{
				if (t != types[types.length - 1])
					s += t.getName() + ", " + types[types.length - 1].getName();
			}
			else
				s += t.getName();
		}

		if (quest.isMutual() && quest.getMutualQuest() != 0)
			button.setToolTipText(s + " : " + DEQuests.getQuestFromID(quest.getMutualQuest()));
		else
			button.setToolTipText(s);

		button.setFont(quest.getFont());
		button.setText(quest.getName());
		button.setBackground(quest.getColour());
		button.addItemListener(e ->
		{
			if (quest.isMutual())
			{
				if (this.currentLocation == DELocation.ALCAMOTH || this.currentLocation == DELocation.ERYTH_SEA || this.currentLocation == DELocation.VALAK_MOUNTAIN)
				{
					for (int i = 0; i < this.alcamothList.getModel().getSize(); ++i)
					{
						JCheckBox box = (JCheckBox) this.alcamothList.getModel().getElementAt(i);
						DEQuest mutualQuest = DEQuests.getQuestFromNameByLocation(DELocation.ALCAMOTH, DEQuests.getQuestFromID(quest.getMutualQuest()).getName());

						if (mutualQuest != null && box.getText().equalsIgnoreCase(mutualQuest.getName()))
							box.setSelected(e.getStateChange() == ItemEvent.SELECTED);
					}

					for (int i = 0; i < this.erythList.getModel().getSize(); ++i)
					{
						JCheckBox box = (JCheckBox) this.erythList.getModel().getElementAt(i);
						DEQuest mutualQuest = DEQuests.getQuestFromNameByLocation(DELocation.ERYTH_SEA, DEQuests.getQuestFromID(quest.getMutualQuest()).getName());

						if (mutualQuest != null && box.getText().equalsIgnoreCase(mutualQuest.getName()))
							box.setSelected(e.getStateChange() == ItemEvent.SELECTED);
					}

					for (int i = 0; i < this.valakList.getModel().getSize(); ++i)
					{
						JCheckBox box = (JCheckBox) this.valakList.getModel().getElementAt(i);
						DEQuest mutualQuest = DEQuests.getQuestFromNameByLocation(DELocation.VALAK_MOUNTAIN, DEQuests.getQuestFromID(quest.getMutualQuest()).getName());

						if (mutualQuest != null && box.getText().equalsIgnoreCase(mutualQuest.getName()))
							box.setSelected(e.getStateChange() == ItemEvent.SELECTED);
					}
				}
				else
				{
					for (int i = 0; i < boxList.getModel().getSize(); ++i)
					{
						JCheckBox box = (JCheckBox) boxList.getModel().getElementAt(i);
						DEQuest mutualQuest = DEQuests.getQuestFromNameByLocation(location, DEQuests.getQuestFromID(quest.getMutualQuest()).getName());

						if (mutualQuest != null)
						{
							if (box.getText().equalsIgnoreCase(mutualQuest.getName()))
								box.setSelected(e.getStateChange() == ItemEvent.SELECTED);
						}
					}
				}
			}

			DEQuest q = DEQuests.getQuestFromNameByLocation(location, button.getText());

			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				if (!SaveManager.defintiveCompletedQuests.containsKey(q.getUniqueID()))
				{
					this.totalCompleted++;
					SaveManager.addQuest(q);

					if (location == this.currentLocation)
						this.setAreaProgress(this.areaProgress.getValue() + 1);

					this.areaCompletionProgresses.put(location, this.areaCompletionProgresses.get(location) + 1);
				}
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED)
			{
				this.totalCompleted--;
				SaveManager.removeQuest(q);

				if (location == currentLocation)
					this.setAreaProgress(this.areaProgress.getValue() - 1);

				this.areaCompletionProgresses.put(location, this.areaCompletionProgresses.get(location) - 1);
			}

			this.setTotalProgress(this.totalCompleted);
			this.updateTabToolTip(this.currentLocation);

			// Makes sure to update the mutual quest's tooltip, and making sure that if the number of quests is put to completion, this will make sure that
			// the 'all quests complete' icon is placed/removed from the respective tabs.
			if (quest.isMutual())
				this.updateTabToolTip(DEQuests.getLocationFromQuest(DEQuests.getQuestFromID(quest.getMutualQuest())));

			SaveManager.defintiveCompletedQuests = SaveManager.defintiveCompletedQuests.entrySet().stream().sorted((a, b) -> a.getKey() > b.getKey() ? 1 : -1).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
			MainFrame.getInstance().updateSaveState(false);
		});

		button.setSize(624, 30);
		button.setVisible(true);
		((DefaultListModel<JCheckBox>) boxList.getModel()).addElement(button);
	}

	private void setTotalProgress(int value)
	{
		if (value != this.totalProgress.getValue())
			this.totalProgress.setValue(value);

		this.totalProgress.setString("Total: " + this.totalCompleted + "/480 (" + String.format("%.2f", ((double) this.totalCompleted / 480.0D) * 100.0D) + "%)");
	}

	private void setAreaProgress(int value)
	{
		if (value != this.areaProgress.getValue())
			this.areaProgress.setValue(value);

		this.areaProgress.setString("Area: " + this.areaProgress.getValue() + "/" + this.currentLocation.getTotalQuest() + " (" + String.format("%.2f", ((double) this.areaProgress.getValue() / (double) this.currentLocation.getTotalQuest()) * 100.0D) + "%)");
	}

	private void updateTabToolTip(DELocation location)
	{
		String completion = this.areaCompletionProgresses.get(location) + "/" + location.getTotalQuest() + " (" + String.format("%.2f", ((double) this.areaCompletionProgresses.get(location) / (double) location.getTotalQuest()) * 100.0D) + "%)";
		int index = this.tabbedPane.indexOfTab(location.name);
		this.tabbedPane.setToolTipTextAt(index, completion);

		if (this.areaCompletionProgresses.get(location) == location.getTotalQuest())
			this.tabbedPane.setIconAt(index, new ImageIcon(MainFrame.getImageResource("icons/items/crown")));
		else if (this.tabbedPane.getIconAt(index) != null)
			this.tabbedPane.setIconAt(index, null);
	}

	@Override
	public void reselect()
	{
		this.selectQuestsInList(this.colony9List, DELocation.COLONY_9);
		this.selectQuestsInList(this.tephraCaveList, DELocation.TEPHRA_CAVE);
		this.selectQuestsInList(this.bionisLegList, DELocation.BIONIS_LEG);
		this.selectQuestsInList(this.colony6List, DELocation.COLONY_6);
		this.selectQuestsInList(this.satorlMarshList, DELocation.SATORL_MARSH);
		this.selectQuestsInList(this.maknaForestList, DELocation.MAKNA_FOREST);
		this.selectQuestsInList(this.frontierList, DELocation.FRONTIER_VILLAGE);
		this.selectQuestsInList(this.erythList, DELocation.ERYTH_SEA);
		this.selectQuestsInList(this.alcamothList, DELocation.ALCAMOTH);
		this.selectQuestsInList(this.valakList, DELocation.VALAK_MOUNTAIN);
		this.selectQuestsInList(this.swordValleyList, DELocation.SWORD_VALLEY);
		this.selectQuestsInList(this.galahadList, DELocation.GALAHAD_FORTRESS);
		this.selectQuestsInList(this.fallenArmList, DELocation.FALLEN_ARM);
		this.selectQuestsInList(this.mechonisFieldList, DELocation.MECHONIS_FIELD);
		this.selectQuestsInList(this.centralFactoryList, DELocation.CENTRAL_FACTORY);
		this.selectQuestsInList(this.agnirathaList, DELocation.AGNIRATHA);
		this.selectQuestsInList(this.prisonIslandList, DELocation.PRISON_ISLAND);
		this.totalCompleted = 0;

		for (int i = 0; i < SaveManager.defintiveCompletedQuests.values().size(); ++i)
			++this.totalCompleted;

		this.setTotalProgress(this.totalCompleted);
	}

	private CheckBoxList getListFromTabIndex(int index)
	{
		switch (index)
		{
		case COLONY_9:
			return this.colony9List;
		case TEPHRA_CAVE:
			return this.tephraCaveList;
		case BIONIS_LEG:
			return this.bionisLegList;
		case COLONY_6:
			return this.colony6List;
		case SATORL_MARSH:
			return this.satorlMarshList;
		case MAKNA_FOREST:
			return this.maknaForestList;
		case FRONTIER_VILLAGE:
			return this.frontierList;
		case ERYTH_SEA:
			return this.erythList;
		case ALCAMOTH:
			return this.alcamothList;
		case VALAK_MOUNTAIN:
			return this.valakList;
		case SWORD_VALLEY:
			return this.swordValleyList;
		case GALAHAD_FORTRESS:
			return this.galahadList;
		case FALLEN_ARM:
			return this.fallenArmList;
		case MECHONIS_FIELD:
			return this.mechonisFieldList;
		case CENTRAL_FACTORY:
			return this.centralFactoryList;
		case AGNIRATHA:
			return this.agnirathaList;
		case PRISON_ISLAND:
			return this.prisonIslandList;
		default:
			return this.colony9List;
		}
	}

	@Override
	public void selectAll()
	{
		int index = this.tabbedPane.getSelectedIndex();
		CheckBoxList currentBoxList = this.getListFromTabIndex(index);

		for (int i =  0; i < currentBoxList.getModel().getSize(); ++i)
		{
			((JCheckBox) currentBoxList.getModel().getElementAt(i)).setSelected(true);
		}

		this.areaCompletionProgresses.put(this.currentLocation, this.currentLocation.getTotalQuest());

		for (DELocation location : DELocation.values())
		{
			if (location != DELocation.BIONIS_INTERIOR && location != DELocation.ETHER_MINE && location != DELocation.HIGH_ENTIA_TOMB && location != DELocation.OTHER)
				this.updateTabToolTip(location);
		}

		this.setAreaProgress(this.currentLocation.getTotalQuest());
	}

	@Override
	public void unselectAll()
	{
		int index = this.tabbedPane.getSelectedIndex();
		CheckBoxList currentBoxList = this.getListFromTabIndex(index);

		for (int i =  0; i < currentBoxList.getModel().getSize(); ++i)
		{
			((JCheckBox) currentBoxList.getModel().getElementAt(i)).setSelected(false);
		}

		this.areaCompletionProgresses.put(this.currentLocation, 0);

		for (DELocation location : DELocation.values())
		{
			if (location != DELocation.BIONIS_INTERIOR && location != DELocation.ETHER_MINE && location != DELocation.HIGH_ENTIA_TOMB && location != DELocation.OTHER)
				this.updateTabToolTip(location);
		}

		this.setAreaProgress(0);
	}

	private void selectQuestsInList(CheckBoxList list, DELocation location)
	{
		int areaCompletion = 0;

		for (int i = 0; i < list.getModel().getSize(); ++i)
		{
			JCheckBox box = (JCheckBox) list.getModel().getElementAt(i);
			DEQuest quest = DEQuests.getQuestFromNameByLocation(location, box.getText());

			if (quest != null)
			{
				box.setSelected(SaveManager.defintiveCompletedQuests.containsKey(quest.getUniqueID()));

				if (box.isSelected())
					++areaCompletion;
			}
		}

		this.areaCompletionProgresses.put(location, areaCompletion);
		this.updateTabToolTip(location);

		if (location == this.currentLocation)
			this.setAreaProgress(areaCompletion);
	}

	private void filterModel(CheckBoxList currentList, String filter)
	{
		DefaultListModel<JCheckBox> model = (DefaultListModel<JCheckBox>) currentList.getModel();
		var matches = new ArrayList<DEQuest>();

		for (DEQuest q : DEQuests.getQuestArray(this.currentLocation))
		{
			String s = q.getName().toLowerCase();

			if (!s.contains(filter.toLowerCase()))
			{
				for (int i = 0; i < model.getSize(); ++i)
				{
					JCheckBox box = model.getElementAt(i);

					if (box.getText().toLowerCase().contains(s))
						model.remove(i);
				}
			}
			else
			{
				boolean contained = false;

				for (int i = 0; i < model.getSize(); ++i)
				{
					JCheckBox box = model.getElementAt(i);

					if (box.getText().toLowerCase().contains(s))
						contained = true;
				}

				if (!contained)
				{
					matches.add(q);
				}
			}
		}

		Collections.sort(matches, (a, b) -> a.getUniqueID() > b.getUniqueID() ? 1 : -1);

		for (DEQuest q : matches)
		{
			this.addQuest(q, this.currentLocation, currentList);
		}

		for (int i = 0; i < currentList.getModel().getSize(); ++i)
		{
			JCheckBox box = (JCheckBox) currentList.getModel().getElementAt(i);
			DEQuest quest = DEQuests.getQuestFromNameByLocation(this.currentLocation, box.getText());

			if (quest != null)
			{
				box.setSelected(SaveManager.defintiveCompletedQuests.containsKey(quest.getUniqueID()));
			}
		}
	}
}