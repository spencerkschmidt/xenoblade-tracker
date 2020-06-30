package tracker.xc2.items;

public enum XCArea
{
	ARGENTUM("Argentum",					19),
	GORMOTT("Gormott",						41),
	URAYA("Uraya",							33),
	MOR_ARDAIN("Mor Ardain",				22),
	TEMPERANTIA("Temperantia",				1),
	INDOL("Indol",							4),
	TANTAL("Tantal",						14),
	LEFTHERIA("Leftheria",					14),
	CLIFFS_OF_MORYTHA("Cliffs of Morytha",	1),
	LAND_OF_MORYTHA("Land of Morytha",		2),
	WORLD_TREE("World Tree",				1);
	final String name;
	final int totalQuests;

	XCArea(String name, int totalQuests)
	{
		this.name = name;
		this.totalQuests = totalQuests;
	}
}