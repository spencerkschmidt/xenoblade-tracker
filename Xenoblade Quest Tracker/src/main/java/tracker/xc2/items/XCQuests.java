package tracker.xc2.items;

public class XCQuests
{
	public static final XCQuest[] ARGENTUM_QUESTS = createQuests(XCArea.ARGENTUM, new XCQuest[]
	{
		new XCQuest(1, "A Real Challenge", "Zenobia", "Goldmouth Res. Dist."),
		new XCQuest(2, "Adenine's Password", "Adenine", "Goldmouth Warehouse"),
		new XCQuest(3, "Bana's Revenge", "Niranira", "Chairman's Room"),
		new XCQuest(4, "Bana's Secret Treasure", "Niranira", "Bana's Bedroom")
	});

	private static XCQuest[] createQuests(XCArea area, XCQuest... quests)
	{
		for (XCQuest quest : quests)
		{
			quest.area = area;
		}

		return quests;
	}

	public static class XCQuest
	{
		private final int questID;
		private final String name;
		private final String giver;
		private final String location;
		private XCArea area;

		public XCQuest(int questID, String name, String giver, String location)
		{
			this.questID = questID;
			this.name = name;
			this.giver = giver;
			this.location = location;
		}
	}
}