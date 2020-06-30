package tracker.xcde.items;

public enum DELocation
{
	COLONY_9("Colony 9",					81, 14, 1,	4),
	TEPHRA_CAVE("Tephra Cave",				13, 0,	1,	0),
	BIONIS_LEG("Bionis' Leg",				38, 2,	0,	24),
	COLONY_6("Colony 6",					67, 20, 0,	8),
	ETHER_MINE("Ether Mine"),
	SATORL_MARSH("Satorl Marsh",			23, 0, 	0,	1),
	MAKNA_FOREST("Makna Forest",			10, 0,	0,	0),
	FRONTIER_VILLAGE("Frontier Village",	84, 6,	0,	7),
	ERYTH_SEA("Eryth Sea",					19, 3,	1,	0),
	ALCAMOTH("Alcamoth",					56, 4,	1,	55),
	HIGH_ENTIA_TOMB("High Entia Tomb"),
	VALAK_MOUNTAIN("Valak Mountain",		14, 1,	1,	0),
	SWORD_VALLEY("Sword Valley",			4,  0,	0,	4),
	GALAHAD_FORTRESS("Galahad Fortress",	4,	0,	0,	0),
	FALLEN_ARM("Fallen Arm",				30, 0,	0,	5),
	MECHONIS_FIELD("Mechonis Field",		9,	0,	0,	4),
	CENTRAL_FACTORY("Central Factory",		9,	0,	1,	4),
	AGNIRATHA("Agniratha",					17,	0,	0,	14),
	BIONIS_INTERIOR("Bionis' Interior"),
	PRISON_ISLAND("Prison Island",			2,	0,	0,	0),
	OTHER("Other",							0,	0,	0,	0);
	public final String name;
	final int totalQuests;
	final int mutallyExlusive;
	final int missable;
	final int timed;

	DELocation(String name)
	{
		this(name, 0, 0, 0, 0);
	}

	DELocation(String name, int total, int mutual, int missable, int timed)
	{
		this.name = name;
		this.totalQuests = total;
		this.mutallyExlusive = mutual;
		this.missable = missable;
		this.timed = timed;
	}

	public int getTotalQuest()
	{
		return this.totalQuests;
	}

	public static DELocation getByName(String name)
	{
		for (DELocation l : values())
		{
			if (l.name.equalsIgnoreCase(name))
				return l;
		}

		return DELocation.COLONY_9;
	}
}