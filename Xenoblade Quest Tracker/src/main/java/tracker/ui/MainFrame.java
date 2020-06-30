package tracker.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import tracker.logging.Logger;
import tracker.ui.SaveManager.Result;
import tracker.ui.view.elements.IItemView;
import tracker.xc2.ui.view.pages.ViewXCQuests;
import tracker.xcde.ui.view.pages.ViewAchievements;
import tracker.xcde.ui.view.pages.ViewAffinity;
import tracker.xcde.ui.view.pages.ViewCollectopaedia;
import tracker.xcde.ui.view.pages.ViewHeartToHearts;
import tracker.xcde.ui.view.pages.ViewListQuests;
import tracker.xcde.ui.view.pages.ViewManuals;
import tracker.xcde.ui.view.pages.ViewUniques;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	/**
	 * <p>The string that holds the current version of the program.</p>
	 * 
	 * Major version -> Only changed when very large changes are done.<br>
	 * Minor version -> Change when functionality is added in a backwards compatible manner.<br>
	 * Patch version -> Change when bug fixes are done.<br>
	 */
	private static final String VERSION = "2.0.0";
	private static final String TITLE = "Xenoblade Chronicles Tracker";
	private static final Logger LOGGER = new Logger("MainFrame");
	/** The list containing the file paths of all files that have been opened by the user. */
	private List<String> recentlyOpenedFiles = new ArrayList<String>();
	private List<IItemView> allViews = new ArrayList<IItemView>();
	/**
	 * <p>This manages the current view just for selecting all elements, or un-selecting all elements in that view.</p>
	 * 
	 * <p>For example, from the Menu option, the Select All and Unselect All options will only trigger on the currently opened view
	 * so that not every single view will have their elements unselected.</p>
	 */
	private IItemView currentlySelectedView;
	private static MainFrame theInstance;
	/** Keeps track of whether the user has saved or not to prevent the program from closing when the user prompts the close. */
	private boolean hasSaved = true;
	private JMenu recentFilesMenu;
	private JMenuItem clearRecentFiles;
	private JMenuItem openContainingFolder;
	private JMenuItem closeOption;
	private JMenuItem selectAll;
	private JMenuItem unselectAll;
	private JMenu fileMenu;

	// Definitive Edition Views
	private ViewListQuests questsViewOld;
	private ViewUniques uniquesView;
	private ViewManuals manualsView;
	private ViewAchievements achievementsView;
	private ViewCollectopaedia collectopaediaView;
	private ViewHeartToHearts heartToHeartsView;
	private ViewAffinity affinityView;
	// Xenoblade Chronicles 2 Views
	private ViewXCQuests xc2QuestsView;
	/** Used only to prevent saving with autosave enabled while opening a file, or while selecting/unselecting all. */
	private boolean shouldSave;
//	private final Map<String, TranslationMapper> translationMappers = new HashMap<String, TranslationMapper>();

	/**
	 * TODO:
	 * Add in the ability to track Xenoblade Chronicles 2 & Torna: The Golden Country items.
	 * 
	 * Xenoblade Chronicles 2 Tracking:
	 * 	- Quests
	 *  - Unique Monsters
	 *  - Costume Accessories
	 *  - Deeds
	 *  - Merc Missions
	 *  - Heart-to-Hearts
	 *  - Rare Blades?
	 *  - Trust?
	 * 
	 * Torna: The Golden Country Tracking:
	 *  - Quests
	 *  - Unique Monsters
	 *  - Trust?
	 * 
	 * TODO:
	 * Add Armour/Weapon Appearances
	 * 		Name of Item | Character | Collected
	 * 
	 * TODO:
	 * Future Connected:
	 * - Quests
	 * - Manuals
	 * - Uniques
	 * - Collectopaedia
	 * - Quiet Moments
	 */

	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			try
			{
				theInstance = new MainFrame();
				theInstance.setLocationRelativeTo(null);
				theInstance.setVisible(true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}

	private MainFrame()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

		SaveManager.readConfigurationFile();

/*		try
		{
			File file = new File(getResource("lang").toURI());
			List<File> languages = Arrays.<File> asList(file.listFiles(f -> {
				String pathName = f.getAbsolutePath();
				String[] split = pathName.split("\\.");

				if (split.length <= 2 && split[1].equalsIgnoreCase("lang"))
				{
					return true;
				}

				return false;
			}));

			for (File languageFile : languages)
			{
				String languageName = languageFile.getName().split("\\.")[0];
				TranslationMapper mapper = new TranslationMapper(languageName);
				mapper.loadTranslations();
				this.translationMappers.put(languageName, mapper);
			}
		}
		catch (URISyntaxException e2)
		{
			e2.printStackTrace();
		}

		I18n.setCurrentLanguage(this.translationMappers.get(SaveManager.currentLanguage.getAsString()));*/

		this.setTitle(String.format("%s V%s", TITLE, VERSION));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(800, 600);
		this.setMinimumSize(new Dimension(400, 300));
		this.setIconImages(Arrays.asList(new ImageIcon(getImageResource("icons/menu/icon_16x16")).getImage(), new ImageIcon(getImageResource("icons/menu/icon_32x32")).getImage(), new ImageIcon(getImageResource("icons/menu/icon_64x64")).getImage()));
		this.addWindowListener(new WindowListener()
		{
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e)
			{
				if (!MainFrame.this.hasSaved)
				{
					int result = JOptionPane.showConfirmDialog(MainFrame.this, "You have not saved! Do you still wish to exit?", "Close without saving?", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION)
						System.exit(0);
				}
				else
				{
					System.exit(0);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		this.setDropTarget(new DropTarget()
		{
			@Override
			public synchronized void dragEnter(DropTargetDragEvent dragEvent)
			{
				if (dragEvent.getTransferable().isDataFlavorSupported(DataFlavor.javaFileListFlavor))
				{
					boolean isAcceptable = false;

					try
					{
						var files = (List<File>) dragEvent.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);

						if (files.size() == 1)
						{
							File file = files.get(0);
							String name = file.getAbsolutePath();
							String[] z = name.split("\\.");

							if (z.length > 1 && z[1].equalsIgnoreCase("json"))
							{
								isAcceptable = true;
							}
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}

					if (!isAcceptable)
						dragEvent.rejectDrag();
					else
						dragEvent.acceptDrag(DnDConstants.ACTION_COPY);
				}
			}

			@Override
			public synchronized void drop(DropTargetDropEvent dropEvent)
			{
				try 
				{
					dropEvent.acceptDrop(DnDConstants.ACTION_COPY);
					var droppedFiles = (List<File>) dropEvent.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
					File file = droppedFiles.get(0);
					LOGGER.log("Dragged file from location '" + file.getAbsolutePath() + "'");
					MainFrame.this.doOpenFile(droppedFiles.get(0));
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		// ============================== BEGIN MENU BAR =====================================
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		this.fileMenu = new JMenu("File");
		menuBar.add(this.fileMenu);
		JMenuItem openOption = new JMenuItem("Open (Ctrl+O)");
		openOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		openOption.addActionListener(e ->
		{
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json", "JSON");
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setFileFilter(filter);

			if (SaveManager.selectedSaveFile != null)
				fileChooser.setCurrentDirectory(new File(SaveManager.selectedSaveFile.getPath().substring(0, SaveManager.selectedSaveFile.getPath().lastIndexOf('\\'))));

			if (fileChooser.showOpenDialog(this.getContentPane()) == JFileChooser.APPROVE_OPTION)
				this.doOpenFile(fileChooser.getSelectedFile());
		});
		openOption.setIcon(new ImageIcon(getImageResource("icons/menu/open")));
		this.fileMenu.add(openOption);

		this.openContainingFolder = new JMenuItem("Open Containing Folder");
		this.openContainingFolder.addActionListener(e ->
		{
			if (SaveManager.selectedSaveFile.exists())
			{
				try
				{
					Desktop.getDesktop().open(SaveManager.selectedSaveFile.getParentFile());
					LOGGER.log("Opening '" + SaveManager.selectedSaveFile.getParentFile() + "' in the file explorer.");
				}
				catch (Exception ex)
				{
					LOGGER.error("Couldn't open the file in the explorer!");
				}
			}
		});
		this.openContainingFolder.setIcon(new ImageIcon(getImageResource("icons/menu/open_containing")));
		this.fileMenu.add(this.openContainingFolder);
		this.openContainingFolder.setEnabled(false);

		JMenuItem saveOption = new JMenuItem("Save (Ctrl+S)");
		saveOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		saveOption.addActionListener(e -> this.doSaveFile(true));
		saveOption.setIcon(new ImageIcon(getImageResource("icons/menu/save")));
		this.fileMenu.add(saveOption);

		JMenuItem saveAsOption = new JMenuItem("Save As (Ctrl+Shift+S)");
		saveAsOption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK));
		saveAsOption.addActionListener(e -> this.doSaveFile(false));
		saveAsOption.setIcon(new ImageIcon(getImageResource("icons/menu/save_as")));
		this.fileMenu.add(saveAsOption);

		this.closeOption = new JMenuItem("Close File");
		this.closeOption.addActionListener(e ->
		{
			if (!MainFrame.this.hasSaved)
			{
				int result = JOptionPane.showConfirmDialog(MainFrame.this, "You have not saved! Do you still wish to close the file?", "Close without saving?", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION)
					SaveManager.clearSavedItems();
			}
			else
				SaveManager.clearSavedItems();

			SaveManager.selectedSaveFile = null;
			this.shouldSave = false;
			this.allViews.forEach(IItemView::reselect);
			this.shouldSave = true;
			this.updateSaveState(true);
		});
		this.closeOption.setEnabled(false);
		this.fileMenu.add(this.closeOption);

		this.recentFilesMenu = new JMenu("Recent Files");
		this.clearRecentFiles = new JMenuItem("Clear Recent Files");
		this.clearRecentFiles.addActionListener(e ->
		{
			int size = this.recentFilesMenu.getItemCount();

			for (int i = 1; i < size; ++i)
			{
				this.recentFilesMenu.remove(1);
			}

			this.recentlyOpenedFiles.clear();
			SaveManager.deleteRecentFiles();
			this.fileMenu.remove(this.recentFilesMenu);
		});

		this.recentFilesMenu.add(this.clearRecentFiles);
		JMenu settingsMenu = new JMenu("Settings");
		menuBar.add(settingsMenu);
		JMenuItem preferencesMenu = new JMenuItem("Preferences");
		settingsMenu.add(preferencesMenu);
		preferencesMenu.addActionListener(e ->
		{
			JDialog preferencesDialog = new JDialog(MainFrame.this, "Preferences", Dialog.ModalityType.DOCUMENT_MODAL);
			preferencesDialog.setSize(600, 400);
			preferencesDialog.setResizable(false);
			preferencesDialog.setLocationRelativeTo(null);
			GridBagLayout layout = new GridBagLayout();
			layout.columnWidths = new int[] {580};
			layout.rowHeights = new int[] {330, 20};
			preferencesDialog.setLayout(layout);

			GridBagConstraints settingsGBC = new GridBagConstraints();
			settingsGBC.fill = GridBagConstraints.BOTH;
			settingsGBC.gridx = 0;
			settingsGBC.gridy = 0;
			JPanel settingsPanel = new JPanel();
			settingsPanel.setLayout(new GridLayout(1, 2));

			GridBagConstraints buttonsGBC = new GridBagConstraints();
			buttonsGBC.fill = GridBagConstraints.BOTH;
			buttonsGBC.gridx = 0;
			buttonsGBC.gridy = 1;
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JPanel generalSettings = new JPanel();
			generalSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
			JCheckBox autoSaveBox = new JCheckBox("Autosave", SaveManager.doAutosave.getAsBoolean());
			autoSaveBox.setToolTipText("When enabled, the program will save after every change.");
			generalSettings.add(autoSaveBox);
			generalSettings.setBorder(BorderFactory.createTitledBorder(null, "General", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			settingsPanel.add(generalSettings);

			JPanel recentFilesSettings = new JPanel();
			recentFilesSettings.setLayout(new FlowLayout(FlowLayout.LEFT));
			JCheckBox enabledRecents = new JCheckBox("Enabled recent files", SaveManager.keepTrackRecents.getAsBoolean());
			recentFilesSettings.add(enabledRecents);
			JTextField maxRecentsField = new JTextField(String.valueOf(SaveManager.maxNumberOfRecents.getAsInt()), 20);
			maxRecentsField.setToolTipText("The maximum number of recent files that will be kept track of.");
			maxRecentsField.setBorder(BorderFactory.createTitledBorder(null, "Maximum Kept Track:", TitledBorder.ABOVE_TOP, TitledBorder.LEFT));
			((PlainDocument) maxRecentsField.getDocument()).setDocumentFilter(new DocumentFilter()
			{
				@Override
				public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
				{
					if (string.matches("\\d*"))
						super.insertString(fb, offset, string, attr);
				}

				@Override
				public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
				{
					if ((fb.getDocument().getLength() + text.length()) < 3)
					{
						if (offset == 0 && text.matches("[1-9]") || offset != 0 && text.matches("\\d"))
						{
							if (text.matches("\\d"))
								super.replace(fb, offset, length, text, attrs);
						}
					}
				}
			});
			recentFilesSettings.add(maxRecentsField);
			recentFilesSettings.setBorder(BorderFactory.createTitledBorder(null, "Recent Files History", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			settingsPanel.add(recentFilesSettings);

			JButton saveButton = new JButton("Save");
			saveButton.addActionListener(s ->
			{
				boolean autoSave = autoSaveBox.isSelected();

				if (autoSave != SaveManager.doAutosave.getAsBoolean())
				{
					LOGGER.log(autoSave ? "Enabling Autosave" : "Disabling Autosave");
					SaveManager.setProperty(SaveManager.doAutosave, autoSave);
				}

				boolean recentsEnabled = enabledRecents.isSelected();

				if (recentsEnabled != SaveManager.keepTrackRecents.getAsBoolean())
				{
					LOGGER.log((recentsEnabled ? "Will" : "Will not") + " keep track of recent files.");
					SaveManager.setProperty(SaveManager.keepTrackRecents, recentsEnabled);

					if (!recentsEnabled)
					{
						int size = this.recentFilesMenu.getItemCount();

						for (int i = 1; i < size; ++i)
						{
							this.recentFilesMenu.remove(1);
						}

						this.recentlyOpenedFiles.clear();
						SaveManager.deleteRecentFiles();
						this.fileMenu.remove(this.recentFilesMenu);
					}
				}

				if (!maxRecentsField.getText().isEmpty())
				{
					int newValue = Integer.valueOf(maxRecentsField.getText());
					int oldValue = SaveManager.maxNumberOfRecents.getAsInt();

					if (newValue != oldValue)
					{
						LOGGER.log("Changing the maximum amount of recent files from " + oldValue + " to " + newValue);
						SaveManager.setProperty(SaveManager.maxNumberOfRecents, newValue);
					}
				}

				SaveManager.writeToConfigurationFile();
				preferencesDialog.dispose();
			});
			buttonsPanel.add(saveButton);
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(c -> preferencesDialog.dispose());
			buttonsPanel.add(cancelButton);
			preferencesDialog.add(settingsPanel, settingsGBC);
			preferencesDialog.add(buttonsPanel, buttonsGBC);
			preferencesDialog.setVisible(true);
		});

		this.selectAll = new JMenuItem("Select All");
		this.selectAll.addActionListener(e ->
		{
			this.shouldSave = false;
			this.currentlySelectedView.selectAll();
			this.shouldSave = true;

			if (SaveManager.doAutosave.getAsBoolean())
				this.updateSaveState(false);
		});
		this.unselectAll = new JMenuItem("Unselect All");
		this.unselectAll.addActionListener(e ->
		{
			this.shouldSave = false;
			this.currentlySelectedView.unselectAll();
			this.shouldSave = true;

			if (SaveManager.doAutosave.getAsBoolean())
				this.updateSaveState(false);
		});
		JMenu menuMenu = new JMenu("Menu");
		menuMenu.add(this.selectAll);
		menuMenu.add(this.unselectAll);
		menuBar.add(menuMenu);
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		JMenuItem whatsNewOption = new JMenuItem("What's New");
		whatsNewOption.addActionListener(e ->
		{
			JDialog dialog = new JDialog(MainFrame.this, "What's New!", Dialog.ModalityType.DOCUMENT_MODAL);
			dialog.setSize(800, 500);
			dialog.setLocationRelativeTo(null);
			dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
			dialog.setMinimumSize(new Dimension(400, 250));
			JScrollPane scrollpane = new JScrollPane();
			JTextArea changelogText = new JTextArea();
			changelogText.setBorder(BorderFactory.createTitledBorder("Changelog"));
			changelogText.setBackground(Color.WHITE);
			changelogText.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			var text = new ArrayList<String>();
			String changelog = "";

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(getResource("changelog.txt").openStream())))
			{
				String s = "";
				
				while ((s = reader.readLine()) != null)
				{
					text.add(s);
				}
			}
			catch (Exception e1)
			{
				;
			}
			
			for (int i = 0; i < text.size() - 1; ++i)
			{
				changelog += text.get(i) + "\n";
			}

			changelog += text.get(text.size() - 1);
			changelogText.setText(changelog);
			changelogText.setEditable(false);
			changelogText.setFocusable(false);
			scrollpane.setViewportView(changelogText);

			// This makes it so that instead of the JScrollPane being scrolled slightly to the right, this will put it's horizontal scroll position back to zero.
			SwingUtilities.invokeLater(() -> scrollpane.getViewport().setViewPosition(new Point(0, scrollpane.getViewport().getViewPosition().y)));

			JButton button = new JButton("Close");
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
			button.addActionListener(buttonEvent -> dialog.dispose());
			dialog.add(scrollpane);
			dialog.add(button);
			dialog.setVisible(true);
		});
		helpMenu.add(whatsNewOption);

		// ================================= BEGIN GAME SELECTION VIEW ======================================
		JPanel definitivePanel = new JPanel();
		JPanel xenoblade2Panel = new JPanel();
		JPanel gameSelectionScreen = new JPanel();
		GridBagLayout selectionGBL = new GridBagLayout();
		selectionGBL.columnWidths = new int[] {624};
		selectionGBL.rowHeights = new int[] {100, 480};
		selectionGBL.columnWeights = new double[] {1.0D};
		selectionGBL.rowWeights = new double[] {1.0D, 1.0D};
		gameSelectionScreen.setLayout(selectionGBL);

		JLabel selectGame = new JLabel("<html><h1>Select Game</h1></html>");
		JPanel buttonsPanel = new JPanel();
		GridBagLayout buttonsGBL = new GridBagLayout();
		buttonsGBL.columnWidths = new int[] {400, 400};
		buttonsGBL.rowHeights = new int[] {200, 200};
		buttonsGBL.columnWeights = new double[] {1.0D, 1.0D};
		buttonsGBL.rowWeights = new double[] {1.0D, 1.0D};
		buttonsPanel.setLayout(buttonsGBL);

		JButton deButton = new JButton();
		GridBagConstraints deGBC = new GridBagConstraints();
		deGBC.fill = GridBagConstraints.BOTH;
		deGBC.gridx = 0;
		deGBC.gridy = 0;
		deButton.setIcon(new ImageIcon(getImageResource("icons/menu/definitive_edition_logo")));
		deButton.addActionListener(e ->
		{
			this.setContentPane(definitivePanel);
			this.revalidate();
			this.repaint();
		});
		buttonsPanel.add(deButton, deGBC);

		JButton xc2Button = new JButton();
		GridBagConstraints xc2GBC = new GridBagConstraints();
		xc2GBC.fill = GridBagConstraints.BOTH;
		xc2GBC.gridx = 0;
		xc2GBC.gridy = 1;
		xc2Button.setIcon(new ImageIcon(getImageResource("icons/menu/xenoblade_2_logo")));
		xc2Button.addActionListener(e ->
		{
			this.setContentPane(xenoblade2Panel);
			this.revalidate();
			this.repaint();
		});
		buttonsPanel.add(xc2Button, xc2GBC);

		JButton tornaButton = new JButton();
		GridBagConstraints tornaGBC = new GridBagConstraints();
		tornaGBC.fill = GridBagConstraints.BOTH;
		tornaGBC.gridx = 1;
		tornaGBC.gridy = 1;
		tornaButton.setIcon(new ImageIcon(getImageResource("icons/menu/torna_logo")));
		buttonsPanel.add(tornaButton, tornaGBC);

		gameSelectionScreen.add(selectGame);
		GridBagConstraints buttonsGBC = new GridBagConstraints();
		buttonsGBC.fill = GridBagConstraints.BOTH;
		buttonsGBC.gridy = 1;
		gameSelectionScreen.add(buttonsPanel, buttonsGBC);
		this.setContentPane(gameSelectionScreen);

		// ================================ BEGIN DEFINITIVE EDITION VIEW ==================================
		JTabbedPane definitiveTabbedPane = new JTabbedPane();
		JButton backButton = new JButton("Back to Game Selection");
		backButton.addActionListener(e ->
		{
			this.setContentPane(gameSelectionScreen);
			this.revalidate();
			this.repaint();
		});
		GridBagLayout definitiveLayout = new GridBagLayout();
		definitiveLayout.columnWidths = new int[] {624};
		definitiveLayout.rowHeights = new int[] {30, 540};
		definitiveLayout.columnWeights = new double[] {1.0D};
		definitiveLayout.rowWeights = new double[] {0.0D, 1.0D};
		definitivePanel.setLayout(definitiveLayout);
		GridBagConstraints backGBC = new GridBagConstraints();
		backGBC.fill = GridBagConstraints.BOTH;
		backGBC.gridy = 0;
		GridBagConstraints deTPGBC = new GridBagConstraints();
		deTPGBC.fill = GridBagConstraints.BOTH;
		deTPGBC.gridy = 1;

		this.collectopaediaView = new ViewCollectopaedia();
		this.questsViewOld = new ViewListQuests();
		this.uniquesView = new ViewUniques();
		this.manualsView = new ViewManuals();
		this.achievementsView = new ViewAchievements();
		this.heartToHeartsView = new ViewHeartToHearts();
		this.affinityView = new ViewAffinity();

		this.xc2QuestsView = new ViewXCQuests();
		this.allViews.addAll(Arrays.<IItemView> asList
		(
			this.questsViewOld, this.uniquesView, this.manualsView, this.achievementsView, this.collectopaediaView, this.heartToHeartsView, this.affinityView,
			this.xc2QuestsView
		));
		definitiveTabbedPane.addTab("Quests", this.questsViewOld);
		definitiveTabbedPane.addTab("Unique Monsters", this.uniquesView);
		definitiveTabbedPane.addTab("Manuals", this.manualsView);
		definitiveTabbedPane.addTab("Achievements", this.achievementsView);
		definitiveTabbedPane.addTab("Collectopaedia", this.collectopaediaView);
		definitiveTabbedPane.addTab("Heart-to-Hearts", this.heartToHeartsView);
		definitiveTabbedPane.addTab("Affinity", this.affinityView);
		definitiveTabbedPane.setIconAt(0, new ImageIcon(getImageResource("icons/menu/icon_16x16")));
		definitiveTabbedPane.setIconAt(1, new ImageIcon(getImageResource("icons/items/skull")));
		definitiveTabbedPane.setIconAt(2, new ImageIcon(getImageResource("icons/items/manual")));
		definitiveTabbedPane.setIconAt(3, new ImageIcon(getImageResource("icons/items/trophy")));
		definitiveTabbedPane.setIconAt(4, new ImageIcon(getImageResource("icons/items/collectable")));
		definitiveTabbedPane.setIconAt(5, new ImageIcon(getImageResource("icons/items/heart")));
		definitiveTabbedPane.setIconAt(6, new ImageIcon(getImageResource("icons/items/affinity")));
		definitiveTabbedPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		definitiveTabbedPane.setBackgroundAt(1, Color.RED);
		definitiveTabbedPane.addChangeListener(e ->
		{
			IItemView view = (IItemView) definitiveTabbedPane.getComponentAt(definitiveTabbedPane.getSelectedIndex());
			this.currentlySelectedView = view;
			this.selectAll.setEnabled(view != this.affinityView);

			if (view == this.affinityView)
				this.unselectAll.setText("Reset Affinity");
			else
				this.unselectAll.setText("Unselect All");
		});

		definitivePanel.add(backButton, backGBC);
		definitivePanel.add(definitiveTabbedPane, deTPGBC);

		// ============================= BEGIN XENOBLADE CHRONICLES 2 VIEW ===================================
		JTabbedPane xc2TabbedPane = new JTabbedPane();
		GridBagLayout xc2Layout = new GridBagLayout();
		xc2Layout.columnWidths = new int[] {624};
		xc2Layout.rowHeights = new int[] {30, 540};
		xc2Layout.columnWeights = new double[] {1.0D};
		xc2Layout.rowWeights = new double[] {0.0D, 1.0D};
		xenoblade2Panel.setLayout(xc2Layout);
		GridBagConstraints xc2TPGBC = new GridBagConstraints();
		xc2TPGBC.fill = GridBagConstraints.BOTH;
		xc2TPGBC.gridy = 1;
		JLabel labelXC2Quests = new JLabel("Quests");
		labelXC2Quests.setPreferredSize(new Dimension(60, 30));
		labelXC2Quests.setIcon(new ImageIcon(getImageResource("icons/menu/icon_16x16")));
		xc2TabbedPane.addTab("Quests", this.xc2QuestsView);
		xc2TabbedPane.setTabComponentAt(0, labelXC2Quests);
		xc2TabbedPane.addChangeListener(e ->
		{
			IItemView view = (IItemView) xc2TabbedPane.getComponentAt(xc2TabbedPane.getSelectedIndex());
			this.currentlySelectedView = view;
		});

		JButton xc2BackButton = new JButton("Back to Game Selection");
		xc2BackButton.addActionListener(e ->
		{
			this.setContentPane(gameSelectionScreen);
			this.revalidate();
			this.repaint();
		});
		GridBagConstraints xc2BackGBC = new GridBagConstraints();
		xc2BackGBC.fill = GridBagConstraints.BOTH;
		xc2BackGBC.gridy = 0;
		xenoblade2Panel.add(xc2BackButton, xc2BackGBC);
		xenoblade2Panel.add(xc2TabbedPane, xc2TPGBC);

		SaveManager.tryLoadRecentFiles(this.recentlyOpenedFiles);
		this.currentlySelectedView = this.questsViewOld;

		if (this.recentlyOpenedFiles.size() > 0)
			this.fileMenu.add(this.recentFilesMenu);

		if (!this.recentlyOpenedFiles.isEmpty())
		{
			this.recentFilesMenu.addSeparator();

			for (String s : this.recentlyOpenedFiles)
			{
				JMenuItem recentFile = new JMenuItem(s);
				recentFile.addActionListener(e1 -> this.doOpenFile(new File(this.recentlyOpenedFiles.get(this.recentlyOpenedFiles.indexOf(recentFile.getText())))));
				this.recentFilesMenu.add(recentFile);
			}
		}
	}

	/**
	 * Finds the resource at the given <code>location</code>.
	 * 
	 * @param location The file location of the resource.
	 * 
	 * @return The {@code URL} to the resource if it can be found.
	 */
	public static URL getResource(String location)
	{
		return MainFrame.class.getClassLoader().getResource(location);
	}

	/**
	 * Finds the resource URL of an image by appending '.png' to the end of <code>location</code>.
	 * 
	 * @param The file location of the image.
	 * 
	 * @return The {@code URL} to the image resource if it can be found.
	 */
	public static URL getImageResource(String location)
	{
		return getResource(location + ".png");
	}

	/**
	 * <p> This will update the current save state when selecting items in the menus. This will update the window's title to have an asterisk if the user
	 * has not saved, but will it if they have. </p>
	 * 
	 * <p> If the user has autosaving enabled, then this will not update the window's title, but will instead save the file after each item is changed.</p>
	 * 
	 * @param saveState Whether the user has saved or not.
	 */
	public void updateSaveState(boolean saveState)
	{
		if (!SaveManager.doAutosave.getAsBoolean() || SaveManager.selectedSaveFile == null)
		{
			this.hasSaved = saveState;
			String title = String.format("%s V%s", TITLE, VERSION);

			if (!saveState)
				title += "*";

			this.setTitle(title);
		}
		else if (SaveManager.selectedSaveFile != null)
		{
			if (!this.hasSaved)
				this.setTitle(String.format("%s V%s", TITLE, VERSION));

			// This makes sure that if autosave was enabled after having selected an item, it will still make sure that the flag is updated to
			// allow the user to close the window without a "has not saved" prompt.
			this.hasSaved = true;


			// Making sure that, since loading a file will make calls to this method, having a flag keep track of when a file is being opened, prevents the file from saving while opening.
			if (!saveState && this.shouldSave)
			{
				SaveManager.saveToFileWithJSON(SaveManager.selectedSaveFile, true);
			}
		}
	}

	/**
	 * When a user opens a file, this adds the location of that file to a list of all recently opened files.
	 * 
	 * @param file The file location to add to the list of all files that have been opened by the user.
	 */
	private void addRecentlyOpenedFile(File file)
	{
		// Do not add any recent files if the option to keep track of them is disabled.
		if (!SaveManager.keepTrackRecents.getAsBoolean())
			return;

		String path = file.getPath();
		int maxNumRecents = SaveManager.maxNumberOfRecents.getAsInt();

		if (!this.recentlyOpenedFiles.contains(path))
		{
			if (this.recentlyOpenedFiles.size() >= maxNumRecents)
			{
				this.recentlyOpenedFiles.set(maxNumRecents - 1, path);
			}
			else
				this.recentlyOpenedFiles.add(path);
		}

		int size = this.recentFilesMenu.getItemCount();

		// In order to reorganize all of the recent items in the list, remove all of them.
		for (int i = 1; i < size; ++i)
		{
			this.recentFilesMenu.remove(1);
		}

		// Reorganize the list so that the recently opened file will be moved to index zero. This makes it so that if a user reopens a file, it will be moved to the top of the list.
		while (this.recentlyOpenedFiles.indexOf(path) != 0)
		{
			int index = this.recentlyOpenedFiles.indexOf(path);
			Collections.swap(this.recentlyOpenedFiles, index, index - 1);
		}

		this.recentFilesMenu.addSeparator();

		for (String s : this.recentlyOpenedFiles)
		{
			JMenuItem recentFile = new JMenuItem(s);
			recentFile.addActionListener(e1 -> this.doOpenFile(new File(this.recentlyOpenedFiles.get(this.recentlyOpenedFiles.indexOf(recentFile.getText())))));
			this.recentFilesMenu.add(recentFile);
		}

		SaveManager.saveRecentFiles(this.recentlyOpenedFiles);

		// Because the recent files menu is removed when the files are cleared, this checks to make sure that it has not been re-added, so that it can be re-added.
		if (this.fileMenu.getItemCount() < 5)
			this.fileMenu.add(this.recentFilesMenu);
	}

	/**
	 * Handles the opening of a file when the user prompts the opening menu item.
	 * 
	 * @param file The file that the user selected.
	 */
	private void doOpenFile(File file)
	{
		this.shouldSave = false;
		SaveManager.Result readResult = SaveManager.readFromFileWithJSON(file);

		if (readResult == Result.SUCCESS)
		{
			this.allViews.forEach(IItemView::reselect);
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
			this.addRecentlyOpenedFile(file);
			this.openContainingFolder.setEnabled(true);
			this.closeOption.setEnabled(true);
			// Makes sure that if the user opens a file after having made changes in an already open file, it will allow the user to close the window without a prompt after opening a new file.
			this.updateSaveState(true);
		}
		else if (readResult == Result.FAILED)
		{
			this.displayDialog("Failed to open file!", "The program could not opened the selected file!");
		}
		else if (readResult == Result.OUTDATED)
		{
			JDialog dialog = new JDialog(this, "Outdated Save File", Dialog.ModalityType.DOCUMENT_MODAL);
			dialog.setSize(500, 150);
			dialog.setLocationRelativeTo(null);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] {240, 20, 240};
			gridBagLayout.rowHeights = new int[] {120, 30};
			gridBagLayout.columnWeights = new double[] {1.0D, 0.0D, 1.0D};
			gridBagLayout.rowWeights = new double[] {1.0D, 0.0D};
			dialog.setLayout(gridBagLayout);

			GridBagConstraints warningGBC = new GridBagConstraints();
			warningGBC.insets = new Insets(2, 4, 0, 3);
			warningGBC.gridwidth = 3;
			warningGBC.fill = GridBagConstraints.BOTH;
			warningGBC.gridx = 0;
			warningGBC.gridy = 0;
			JTextPane warningText = new JTextPane();
			StyledDocument doc = warningText.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			warningText.setBorder(BorderFactory.createTitledBorder("Update file?"));
			warningText.setBackground(Color.WHITE);
			warningText.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			warningText.setText("The file you are trying to load uses an outdated save format! Would you like to update it's format to the new format? Keep in mind that this will prevent the save file from working on older version of this program!");
			warningText.setEditable(false);
			warningText.setFocusable(false);

			GridBagConstraints confirmGBC = new GridBagConstraints();
			confirmGBC.insets = new Insets(0, 5, 5, 0);
			confirmGBC.fill = GridBagConstraints.BOTH;
			confirmGBC.gridx = 0;
			confirmGBC.gridy = 1;
			JButton confirmButton = new JButton("Confirm");
			confirmButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
			confirmButton.addActionListener(buttonEvent -> 
			{
				if (SaveManager.convertSaveFile() == Result.SUCCESS)
					this.doOpenFile(file);
				else
					this.displayDialog("Error!", "Failed to convert the selected file!");

				dialog.dispose();
			});

			GridBagConstraints cancelGBC = new GridBagConstraints();
			cancelGBC.insets = new Insets(0, 0, 5, 5);
			cancelGBC.fill = GridBagConstraints.BOTH;
			cancelGBC.gridx = 2;
			cancelGBC.gridy = 1;
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setAlignmentX(Component.LEFT_ALIGNMENT);
			cancelButton.addActionListener(buttonEvent -> dialog.dispose());
			dialog.add(warningText, warningGBC);
			dialog.add(confirmButton, confirmGBC);
			dialog.add(cancelButton, cancelGBC);
			dialog.setVisible(true);
		}

		this.shouldSave = true;
	}

	/**
	 * Displays a simple {@link JDialog} box that has a {@link JTextArea} and a confirm button that only closes the window.
	 * 
	 * @param title The title to display on the {@link JDialog}.
	 * @param message The message to display within the {@link JDialog}.
	 */
	private void displayDialog(String title, String message)
	{
		JDialog dialog = new JDialog(this, title, Dialog.ModalityType.DOCUMENT_MODAL);
		dialog.setSize(300, 120);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

		JTextPane warningText = new JTextPane();
		warningText.setBorder(BorderFactory.createEtchedBorder());
		warningText.setBackground(Color.WHITE);
		warningText.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		warningText.setText(message);
		warningText.setEditable(false);
		warningText.setFocusable(false);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirmButton.addActionListener(buttonEvent -> dialog.dispose());
		dialog.add(warningText);
		dialog.add(confirmButton);
		dialog.setVisible(true);
	}

	/**
	 * Handles the saving of the file when the user prompts saving or save-as.
	 * 
	 * @param normalSave If this is prompted by the Save option, it is a normal save. If it is from Save-As, this is not a normal save.
	 */
	private void doSaveFile(boolean normalSave)
	{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json", "JSON");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);

		if (SaveManager.selectedSaveFile != null)
			fileChooser.setCurrentDirectory(new File(SaveManager.selectedSaveFile.getPath().substring(0, SaveManager.selectedSaveFile.getPath().lastIndexOf('\\'))));

		if (SaveManager.selectedSaveFile != null && normalSave)
		{
			LOGGER.log("File already exists, saving to '" + SaveManager.selectedSaveFile + "'");
			SaveManager.saveToFileWithJSON(SaveManager.selectedSaveFile, false);
		}
		else
		{
			LOGGER.log("Prompting select file for saving.");

			if (fileChooser.showSaveDialog(this.getContentPane()) == JFileChooser.APPROVE_OPTION)
			{
				if (fileChooser.getSelectedFile().exists())
				{
					int result = JOptionPane.showConfirmDialog(this.getContentPane(), "This file already exists. Do you wish to overwrite it?", "Overwrite?", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION)
						SaveManager.saveToFileWithJSON(fileChooser.getSelectedFile(), false);
				}
				else
					SaveManager.saveToFileWithJSON(fileChooser.getSelectedFile(), false);

				this.addRecentlyOpenedFile(fileChooser.getSelectedFile());
			}
		}

		this.openContainingFolder.setEnabled(true);
		this.closeOption.setEnabled(true);
		this.updateSaveState(true);
	}

	/**
	 * @return This returns the single instance of the MainFrame Class.
	 */
	public static MainFrame getInstance()
	{
		return theInstance;
	}
}