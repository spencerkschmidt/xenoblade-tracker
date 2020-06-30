package tracker.xcde.ui.view.pages;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import tracker.ui.MainFrame;
import tracker.ui.SaveManager;
import tracker.ui.view.elements.IItemView;
import tracker.xcde.items.HeartToHearts.HeartToHeart.Affinity;

@SuppressWarnings("serial")
public class ViewAffinity extends JPanel implements IItemView
{
	private Character currentSelectedCharacter;
	private JButton centerPerson;
	private JButton topPerson;
	private JButton rightTopPerson;
	private JButton leftTopPerson;
	private JButton leftBottomPerson;
	private JButton rightBottomPerson;
	private JButton bottomPerson;
	private Map<String, Character> allCharacters = new LinkedHashMap<String, Character>();
	private List<Pair<String, Character>> shownCharacters = new ArrayList<Pair<String, Character>>();
	private Map<String, ImageIcon> characterImages = new HashMap<String, ImageIcon>();
	private BufferedImage yellowAffinity;
	private BufferedImage greenAffinity;
	private BufferedImage blueAffinity;
	private BufferedImage lavenderAffinity;
	private BufferedImage pinkAffinity;
	private boolean isOverCenter;
	private boolean isOverTop;
	private boolean isOverTopRight;
	private boolean isOverBottomRight;
	private boolean isOverBottom;
	private boolean isOverBottomLeft;
	private boolean isOverTopLeft;

	// TODO: When updating one character's affinity, make sure it updates the other character's affinity as well, otherwise only one person will have their affinity set!

	public ViewAffinity()
	{
		String[] allCharacterNames = new String[] {"Shulk", "Reyn", "Fiora", "Sharla", "Dunban", "Melia", "Riki"};

		for (String s : allCharacterNames)
		{
			this.characterImages.put(s, new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + s.toLowerCase())));
			this.allCharacters.put(s, new Character(s));
		}

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42};
		layout.rowHeights = new int[] {46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46};
		layout.columnWeights = new double[] {1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D};
		layout.rowWeights = new double[] {1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D};
		this.setLayout(layout);

		GridBagConstraints centrePersonBGC = new GridBagConstraints();
		centrePersonBGC.fill = GridBagConstraints.BOTH;
		centrePersonBGC.gridx = 7;
		centrePersonBGC.gridy = 6;
		this.add(this.centerPerson = this.createButton(), centrePersonBGC);
		this.centerPerson.addActionListener(e ->
		{
			String[] allNames = this.allCharacters.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toList()).toArray(String[]::new);

			for (int i = 0; i < allNames.length; ++i)
			{
				if (allNames[i].equalsIgnoreCase(this.currentSelectedCharacter.name))
				{
					this.updateShownCharacters(this.shownCharacters.get(i % (allNames.length - 1)).second);
					break;
				}
			}
		});

		GridBagConstraints topPersonGBC = new GridBagConstraints();
		topPersonGBC.fill = GridBagConstraints.BOTH;
		topPersonGBC.gridx = 7;
		topPersonGBC.gridy = 1;
		this.add(this.topPerson = this.createButton(), topPersonGBC);
		this.topPerson.addActionListener(e -> this.updateAffinityWithCharacter(this.shownCharacters.get(0).first));

		GridBagConstraints rightTopPersonBGC = new GridBagConstraints();
		rightTopPersonBGC.fill = GridBagConstraints.BOTH;
		rightTopPersonBGC.gridx = 13;
		rightTopPersonBGC.gridy = 4;
		this.add(this.rightTopPerson = this.createButton(), rightTopPersonBGC);
		this.rightTopPerson.addActionListener(e -> this.updateAffinityWithCharacter(this.shownCharacters.get(1).first));

		GridBagConstraints rightBottomPersonBGC = new GridBagConstraints();
		rightBottomPersonBGC.fill = GridBagConstraints.BOTH;
		rightBottomPersonBGC.gridx = 13;
		rightBottomPersonBGC.gridy = 8;
		this.add(this.rightBottomPerson = this.createButton(), rightBottomPersonBGC);
		this.rightBottomPerson.addActionListener(e -> this.updateAffinityWithCharacter(this.shownCharacters.get(2).first));

		GridBagConstraints bottomPersonBGC = new GridBagConstraints();
		bottomPersonBGC.fill = GridBagConstraints.BOTH;
		bottomPersonBGC.gridx = 7;
		bottomPersonBGC.gridy = 11;
		this.add(this.bottomPerson = this.createButton(), bottomPersonBGC);
		this.bottomPerson.addActionListener(e -> this.updateAffinityWithCharacter(this.shownCharacters.get(3).first));

		GridBagConstraints leftBottomPersonBGC = new GridBagConstraints();
		leftBottomPersonBGC.fill = GridBagConstraints.BOTH;
		leftBottomPersonBGC.gridx = 1;
		leftBottomPersonBGC.gridy = 8;
		this.add(this.leftBottomPerson = this.createButton(), leftBottomPersonBGC);
		this.leftBottomPerson.addActionListener(e -> this.updateAffinityWithCharacter(this.shownCharacters.get(4).first));

		GridBagConstraints leftTopPersonBGC = new GridBagConstraints();
		leftTopPersonBGC.fill = GridBagConstraints.BOTH;
		leftTopPersonBGC.gridx = 1;
		leftTopPersonBGC.gridy = 4;
		this.add(this.leftTopPerson = this.createButton(), leftTopPersonBGC);
		this.leftTopPerson.addActionListener(e -> this.updateAffinityWithCharacter(this.shownCharacters.get(5).first));

		try
		{
			this.yellowAffinity = ImageIO.read(MainFrame.getImageResource("icons/items/affinity_yellow"));
			this.greenAffinity = ImageIO.read(MainFrame.getImageResource("icons/items/affinity_green"));
			this.blueAffinity = ImageIO.read(MainFrame.getImageResource("icons/items/affinity_blue"));
			this.lavenderAffinity = ImageIO.read(MainFrame.getImageResource("icons/items/affinity_lavender"));
			this.pinkAffinity = ImageIO.read(MainFrame.getImageResource("icons/items/affinity_pink"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		MouseListener mouseListener = new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				if (e.getSource() == centerPerson)
					isOverCenter = false;
				else if (e.getSource() == topPerson)
					isOverTop = false;
				else if (e.getSource() == rightTopPerson)
					isOverTopRight = false;
				else if (e.getSource() == rightBottomPerson)
					isOverBottomRight = false;
				else if (e.getSource() == bottomPerson)
					isOverBottom = false;
				else if (e.getSource() == leftBottomPerson)
					isOverBottomLeft = false;
				else if (e.getSource() == leftTopPerson)
					isOverTopLeft = false;

				repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				if (e.getSource() == centerPerson)
					isOverCenter = true;
				else if (e.getSource() == topPerson)
					isOverTop = true;
				else if (e.getSource() == rightTopPerson)
					isOverTopRight = true;
				else if (e.getSource() == rightBottomPerson)
					isOverBottomRight = true;
				else if (e.getSource() == bottomPerson)
					isOverBottom = true;
				else if (e.getSource() == leftBottomPerson)
					isOverBottomLeft = true;
				else if (e.getSource() == leftTopPerson)
					isOverTopLeft = true;

				repaint();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		};

		this.centerPerson.addMouseListener(mouseListener);
		this.topPerson.addMouseListener(mouseListener);
		this.rightTopPerson.addMouseListener(mouseListener);
		this.rightBottomPerson.addMouseListener(mouseListener);
		this.bottomPerson.addMouseListener(mouseListener);
		this.leftBottomPerson.addMouseListener(mouseListener);
		this.leftTopPerson.addMouseListener(mouseListener);
		this.updateShownCharacters(this.allCharacters.get("Shulk"));
	}

	private Character getCharacterFromName(String name)
	{
		return this.allCharacters.get(name);
	}

	/**
	 * A helper method for creating a {@link JButton} that has does not have its border, inside, and focus, painted so that
	 * they can be used for displaying the character icons only, while still being able to be clicked.
	 * 
	 * @return A {@link JButton} that has no border, that is not filled, and does not get painted when focused.
	 */
	private JButton createButton()
	{
		JButton button = new JButton();
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		return button;
	}

	/**
	 * Increases the affinity the {@code currentSelectedCharacter} has with the character given by {@code name} by one, resetting it to yellow affinity if
	 * it goes past pink. 
	 * 
	 * @param name The character to update their affinity with the {@code currentSelectedCharacter}.
	 */
	private void updateAffinityWithCharacter(String name)
	{
		int currentAffinity = this.currentSelectedCharacter.getAffinityWith(name).ordinal();
		Affinity newAffinity = Affinity.values()[(currentAffinity + 1) % Affinity.values().length];
		this.currentSelectedCharacter.setAffinityWith(name, newAffinity);
		this.getCharacterFromName(name).setAffinityWith(this.currentSelectedCharacter.name, newAffinity);
		SaveManager.updateCharactersAffinities(this.currentSelectedCharacter, this.getCharacterFromName(name));
		MainFrame.getInstance().updateSaveState(false);

		Character top = this.shownCharacters.get(0).second;
		Character rightTop = this.shownCharacters.get(1).second;
		Character rightBottom  = this.shownCharacters.get(2).second;
		Character bottom = this.shownCharacters.get(3).second;
		Character leftBottom = this.shownCharacters.get(4).second;
		Character leftTop = this.shownCharacters.get(5).second;
		this.setToolTip(top, this.topPerson);
		this.setToolTip(rightTop, this.rightTopPerson);
		this.setToolTip(rightBottom, this.rightBottomPerson);
		this.setToolTip(bottom, this.bottomPerson);
		this.setToolTip(leftBottom, this.leftBottomPerson);
		this.setToolTip(leftTop, this.leftTopPerson);
		this.repaint();
	}

	/**
	 * Updates the characters that are shown on the affinity chart, and updates the names and icons of all of the buttons.
	 * 
	 * @param character The character to be shown in the center, and the character for which affinity will be updated for.
	 */
	private void updateShownCharacters(Character character)
	{
		this.currentSelectedCharacter = character;
		this.shownCharacters.clear();

		for (Entry<String, Character> entry : this.allCharacters.entrySet())
		{
			if (!this.currentSelectedCharacter.equals(entry.getValue()))
				this.shownCharacters.add(new Pair(entry.getKey(), entry.getValue()));
		}

		Character top = this.shownCharacters.get(0).second;
		Character rightTop = this.shownCharacters.get(1).second;
		Character rightBottom  = this.shownCharacters.get(2).second;
		Character bottom = this.shownCharacters.get(3).second;
		Character leftBottom = this.shownCharacters.get(4).second;
		Character leftTop = this.shownCharacters.get(5).second;

		String centerName = this.currentSelectedCharacter.name;
		this.centerPerson.setIcon(this.characterImages.get(centerName));
		this.topPerson.setIcon(this.characterImages.get(top.name));
		this.rightTopPerson.setIcon(this.characterImages.get(rightTop.name));
		this.rightBottomPerson.setIcon(this.characterImages.get(rightBottom.name));
		this.bottomPerson.setIcon(this.characterImages.get(bottom.name));
		this.leftBottomPerson.setIcon(this.characterImages.get(leftBottom.name));
		this.leftTopPerson.setIcon(this.characterImages.get(leftTop.name));

		this.centerPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + centerName + "_hover")));
		this.topPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + top.name + "_hover")));
		this.rightTopPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + rightTop.name + "_hover")));
		this.rightBottomPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + rightBottom.name + "_hover")));
		this.bottomPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + bottom.name + "_hover")));
		this.leftBottomPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + leftBottom.name + "_hover")));
		this.leftTopPerson.setRolloverIcon(new ImageIcon(MainFrame.getImageResource("icons/items/characters/" + leftTop.name + "_hover")));
		this.setToolTip(top, this.topPerson);
		this.setToolTip(rightTop, this.rightTopPerson);
		this.setToolTip(rightBottom, this.rightBottomPerson);
		this.setToolTip(bottom, this.bottomPerson);
		this.setToolTip(leftBottom, this.leftBottomPerson);
		this.setToolTip(leftTop, this.leftTopPerson);
		this.repaint();
	}

	private void setToolTip(Character character, JButton button)
	{
		Map<String, Affinity> topAffinities = character.getAllAfinities();
		String topTooltip = "<html>Affinities:<br>";

		for (Entry<String, Affinity> entry : topAffinities.entrySet())
		{
			topTooltip += entry.getKey() + ": " + entry.getValue() + "<br>";
		}

		topTooltip += "</html>";
		button.setToolTipText(topTooltip);
	}

	@Override
	public void reselect()
	{
		Map<String, Map<String, Affinity>> affinities = SaveManager.AFFINITIES;

		for (Entry<String, Map<String, Affinity>> entry : affinities.entrySet())
		{
			Character character = this.allCharacters.get(entry.getKey());

			for (Entry<String, Affinity> affinityEntries : entry.getValue().entrySet())
			{
				character.setAffinityWith(affinityEntries.getKey(), affinityEntries.getValue());
				this.getCharacterFromName(affinityEntries.getKey()).setAffinityWith(character.name, affinityEntries.getValue());
			}
		}

		this.updateShownCharacters(this.currentSelectedCharacter);
	}

	@Override
	public void selectAll() {}

	@Override
	public void unselectAll()
	{
		Map<String, Map<String, Affinity>> affinities = SaveManager.AFFINITIES;

		for (Entry<String, Map<String, Affinity>> entry : affinities.entrySet())
		{
			Character character = this.allCharacters.get(entry.getKey());

			for (Entry<String, Affinity> affinityEntries : entry.getValue().entrySet())
			{
				character.setAffinityWith(affinityEntries.getKey(), Affinity.YELLOW);
				this.getCharacterFromName(affinityEntries.getKey()).setAffinityWith(character.name, Affinity.YELLOW);
			}

			SaveManager.updateCharactersAffinities(character);
		}

		this.updateShownCharacters(this.currentSelectedCharacter);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(167, 164, 158));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		Color lineColour = new Color(235, 232, 222);
		g2d.setColor(lineColour);
		g2d.setStroke(new BasicStroke(10.0F));
		int centerX = this.centerPerson.getX() + this.centerPerson.getWidth() / 2;
		int centerY = this.centerPerson.getY() + this.centerPerson.getHeight() / 2;
		Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
		String[] names = this.shownCharacters.stream().map(p -> p.first).collect(Collectors.toList()).toArray(String[]::new);

		for (Pair<String, Character> pairs : this.shownCharacters)
		{
			String s = pairs.first;
			BufferedImage affinityImage = null;

			switch (this.currentSelectedCharacter.getAffinityWith(s))
			{
			case YELLOW:
				affinityImage = this.yellowAffinity;
				break;
			case GREEN:
				affinityImage = this.greenAffinity;
				break;
			case BLUE:
				affinityImage = this.blueAffinity;
				break;
			case LAVENDER:
				affinityImage = this.lavenderAffinity;
				break;
			case PINK:
				affinityImage = this.pinkAffinity;
			}

			if (!s.equalsIgnoreCase(this.currentSelectedCharacter.name))
				images.put(s, affinityImage);
		}

		String[] actualCharacters = Arrays.asList(names).stream().filter(s -> !s.equalsIgnoreCase(this.currentSelectedCharacter.name)).collect(Collectors.toList()).toArray(String[]::new);

		g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
		// Center to Top
		g2d.drawString(actualCharacters[0], this.topPerson.getX() + this.topPerson.getWidth() / 2 - g2d.getFontMetrics().stringWidth(actualCharacters[0]) / 2, this.topPerson.getY() - g2d.getFontMetrics().getHeight() + 20);

		if (this.isOverTop || this.isOverCenter)
			g2d.setColor(Color.YELLOW);

		g2d.drawLine(centerX, centerY, this.topPerson.getX() + this.topPerson.getWidth() / 2, this.topPerson.getY() + this.topPerson.getHeight() / 2);
		g2d.drawImage(images.get(actualCharacters[0]), centerX - 16, (this.topPerson.getY() + centerY) / 2, 32, 32, null);
		g2d.setColor(lineColour);

		// Center to Top Left
		g2d.drawString(actualCharacters[5], this.leftTopPerson.getX() + this.leftTopPerson.getWidth() / 2 - g2d.getFontMetrics().stringWidth(actualCharacters[5]) / 2, this.leftTopPerson.getY() + this.leftTopPerson.getHeight() + g2d.getFontMetrics().getHeight() - 10);

		if (this.isOverTopLeft || this.isOverCenter)
			g2d.setColor(Color.YELLOW);

		g2d.drawLine(centerX, centerY, this.leftTopPerson.getX() + this.leftTopPerson.getWidth() / 2, this.leftTopPerson.getY() + this.leftTopPerson.getHeight() / 2);
		g2d.drawImage(images.get(actualCharacters[5]), (centerX + this.leftTopPerson.getX()) / 2, (this.leftTopPerson.getY() + centerY) / 2, 32, 32, null);
		g2d.setColor(lineColour);

		// Center to Top Right
		g2d.drawString(actualCharacters[1], this.rightTopPerson.getX() + this.rightTopPerson.getWidth() / 2 - g2d.getFontMetrics().stringWidth(actualCharacters[1]) / 2, this.rightTopPerson.getY() + this.rightTopPerson.getHeight() + g2d.getFontMetrics().getHeight() - 10);

		if (this.isOverTopRight || this.isOverCenter)
			g2d.setColor(Color.YELLOW);

		g2d.drawLine(centerX, centerY, this.rightTopPerson.getX() + this.rightTopPerson.getWidth() / 2, this.rightTopPerson.getY() + this.rightTopPerson.getHeight() / 2);
		g2d.drawImage(images.get(actualCharacters[1]), (centerX + this.rightTopPerson.getX() + (this.rightTopPerson.getWidth() / 2)) / 2, (centerY + this.rightTopPerson.getY() + (this.rightTopPerson.getHeight() / 2)) / 2 - 18, 32, 32, null);
		g2d.setColor(lineColour);

		// Center to Bottom Left
		g2d.drawString(actualCharacters[4], this.leftBottomPerson.getX() + this.leftBottomPerson.getWidth() / 2 - g2d.getFontMetrics().stringWidth(actualCharacters[4]) / 2, this.leftBottomPerson.getY() + this.leftBottomPerson.getHeight() + g2d.getFontMetrics().getHeight() - 10);

		if (this.isOverBottomLeft || this.isOverCenter)
			g2d.setColor(Color.YELLOW);

		g2d.drawLine(centerX, centerY, this.leftBottomPerson.getX() + this.leftBottomPerson.getWidth() / 2, this.leftBottomPerson.getY() + this.leftBottomPerson.getHeight() / 2);
		g2d.drawImage(images.get(actualCharacters[4]), (centerX + this.leftBottomPerson.getX()) / 2, (this.leftBottomPerson.getY() + centerY) / 2 + 10, 32, 32, null);
		g2d.setColor(lineColour);

		// Center to Bottom Right
		g2d.drawString(actualCharacters[2], this.rightBottomPerson.getX() + this.rightBottomPerson.getWidth() / 2 - g2d.getFontMetrics().stringWidth(actualCharacters[2]) / 2, this.rightBottomPerson.getY() + this.rightBottomPerson.getHeight() + g2d.getFontMetrics().getHeight() - 10);

		if (this.isOverBottomRight || this.isOverCenter)
			g2d.setColor(Color.YELLOW);

		g2d.drawLine(centerX, centerY, this.rightBottomPerson.getX() + this.rightBottomPerson.getWidth() / 2, this.rightBottomPerson.getY() + this.rightBottomPerson.getHeight() / 2);
		g2d.drawImage(images.get(actualCharacters[2]), (centerX + this.rightBottomPerson.getX() + (this.rightBottomPerson.getWidth() / 2)) / 2, (centerY + this.rightBottomPerson.getY() + (this.rightBottomPerson.getHeight() / 2)) / 2 - 10, 32, 32, null);
		g2d.setColor(lineColour);

		// Center to Bottom
		g2d.drawString(actualCharacters[3], this.bottomPerson.getX() + this.bottomPerson.getWidth() / 2 - g2d.getFontMetrics().stringWidth(actualCharacters[3]) / 2, this.bottomPerson.getY() + this.bottomPerson.getHeight() + g2d.getFontMetrics().getHeight() - 10);

		if (this.isOverBottom || this.isOverCenter)
			g2d.setColor(Color.YELLOW);

		g2d.drawLine(centerX, centerY, this.bottomPerson.getX() + this.bottomPerson.getWidth() / 2, this.bottomPerson.getY() + this.bottomPerson.getHeight() / 2);
		g2d.drawImage(images.get(actualCharacters[3]), centerX - 16, (this.bottomPerson.getY() + centerY) / 2, 32, 32, null);
		g2d.setColor(lineColour);
	}

	private static class Pair<A, B>
	{
		private final A first;
		private final B second;

		protected Pair(A f, B s)
		{
			this.first = f;
			this.second = s;
		}

		@Override
		public String toString()
		{
			return "[" + this.first + " : " + this.second + "]";
		}
	}

	public static class Character
	{
		public final String name;
		private Map<String, Affinity> affinityMap = new HashMap<String, Affinity>();

		public Character(String name)
		{
			this.name = name;
			String[] allNames = new String[] {"Shulk", "Reyn", "Fiora", "Sharla", "Dunban", "Melia", "Riki"};

			for (String s : allNames)
			{
				this.affinityMap.put(s, Affinity.YELLOW);
			}
		}

		public void setAffinityWith(String name, Affinity newAffinity)
		{
			System.out.println("This is setting " + this.name + "'s affinity with " + name + " to " + newAffinity);

			if (name.equalsIgnoreCase(this.name))
				System.out.println("Cannot update affinty with self!");
			else
				this.affinityMap.put(name, newAffinity);
		}

		public Affinity getAffinityWith(String name)
		{
			return this.affinityMap.get(name);
		}

		public void resetAffinities()
		{
			for (String s : this.affinityMap.keySet())
			{
				this.affinityMap.put(s, Affinity.YELLOW);
			}
		}

		public Map<String, Affinity> getAllAfinities()
		{
			Map<String, Affinity> affinities = new HashMap<String, Affinity>();

			for (Entry<String, Affinity> entry : this.affinityMap.entrySet())
			{
				if (!entry.getKey().equalsIgnoreCase(this.name))
					affinities.put(entry.getKey(), entry.getValue());
			}

			return affinities;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Character other = (Character) obj;

			if (name == null)
			{
				if (other.name != null)
					return false;
			}
			else if (!name.equals(other.name))
				return false;

			return true;
		}
	}
}