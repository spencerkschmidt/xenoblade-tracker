package tracker.xc2.ui.view.pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tracker.ui.view.elements.FilterSearchBar;
import tracker.ui.view.elements.IItemView;
import tracker.xc2.items.XCArea;

@SuppressWarnings("serial")
public class ViewXCQuests extends JPanel implements IItemView
{
	private JTextField searchBar;

	public ViewXCQuests()
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

		this.searchBar = new JTextField();
		this.searchBar.setDocument(new FilterSearchBar(this));
//		this.searchBar.getDocument().addDocumentListener(new DocumentListenerSearchBar(this.searchBar, this.achievementsTable));
		GridBagConstraints searchBarGBC = new GridBagConstraints();
		searchBarGBC.insets = new Insets(0, 0, 5, 0);
		searchBarGBC.gridheight = 1;
		searchBarGBC.fill = GridBagConstraints.BOTH;
		searchBarGBC.gridx = 0;
		searchBarGBC.gridy = 0;
		this.add(this.searchBar, searchBarGBC);
	}

	private JTable createQuestForArea(XCArea area)
	{
		return null;
	}

	@Override
	public void reselect() {}

	@Override
	public void selectAll() {}

	@Override
	public void unselectAll() {}
}