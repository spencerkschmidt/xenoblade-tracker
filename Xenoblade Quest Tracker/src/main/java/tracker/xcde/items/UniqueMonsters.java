package tracker.xcde.items;

import java.util.Arrays;
import java.util.List;

public class UniqueMonsters
{
	public static final UniqueMonster[] UNIQUE_MONSTERS = new UniqueMonster[]
	{
		// Colony 9 Uniques
		new UniqueMonster("Verdant Bluchal", 5, DELocation.COLONY_9, "Beach south of Anti-Air Battery 1"),
		new UniqueMonster("Evil Rhangrot", 6, DELocation.COLONY_9, "	Tephra Hill"),
		new UniqueMonster("Lake Magdalena", 6, DELocation.COLONY_9, "Under Outlook Park", "Night"),
		new UniqueMonster("Itinerant Dorothea", 6, DELocation.COLONY_9, "Cliff Lake", "Day"),
		new UniqueMonster("Speedy Ramshyde", 10, DELocation.COLONY_9, "Cliff Lake"),
		new UniqueMonster("Enchanting Grune", 13, DELocation.COLONY_9, "	Beach below Tephra Cave Entrance", "Dawn"),
		new UniqueMonster("Dark Murakmor", 18, DELocation.COLONY_9, "	Anti-Air Battery 3", "Night"),
		new UniqueMonster("Gentle Mother Armu", 37, DELocation.COLONY_9, "Agora Shore"),
		new UniqueMonster("Impenetrable Redrob", 38, DELocation.COLONY_9, "South side of Hazzai Cape", "Night"),
		new UniqueMonster("Roguish Frengel", 39, DELocation.COLONY_9, "A cave north of Cliff Lake"),
		new UniqueMonster("Gentle Rodriguez", 40, DELocation.COLONY_9, "Far north end of Agora Shore"),
		new UniqueMonster("Lakebed Orthlus", 40, DELocation.COLONY_9, "Agora Shore", "Quest Exclusive"),
		new UniqueMonster("Shadeless Matrix", 44, DELocation.COLONY_9, "	Tunnel north of Cliff Lake", "Night"),
		new UniqueMonster("Flailing Bracken", 73, DELocation.COLONY_9, "Shore north of Anti-Air Battery 2"),
		// Tephra Cave Uniques
		new UniqueMonster("Mining Patrichev", 8, DELocation.TEPHRA_CAVE, "Near the Caterpile Nest"),
		new UniqueMonster("Wallslide Gwynry", 9, DELocation.TEPHRA_CAVE, "Mag Mell Ruins"),
		new UniqueMonster("Cellar Bugworm", 10, DELocation.TEPHRA_CAVE, "Caterpile Nest"),
		new UniqueMonster("Solid Konev", 10, DELocation.TEPHRA_CAVE, "Spring of Grief", "Night"),
		new UniqueMonster("Gluttonous Eugen", 11, DELocation.TEPHRA_CAVE, "Vilia Lake"),
		new UniqueMonster("Plump Sprahda", 92, DELocation.TEPHRA_CAVE, "Path Before Bafalgar Tomb", "After Mechonis Core"),
		new UniqueMonster("Musical Vanflare", 93, DELocation.TEPHRA_CAVE, "Near Bone Corridor", "After Mechonis Core"),
		new UniqueMonster("Judicious Bunnitzol", 94, DELocation.TEPHRA_CAVE, "Forgotten Cave", "After Mechonis Core"),
		new UniqueMonster("Reckless Galdon", 95, DELocation.TEPHRA_CAVE, "Hidden Warehouse", "After Mechonis Core"),
		new UniqueMonster("Protective Torquidon", 96, DELocation.TEPHRA_CAVE, "South of Heavenly Window", "After Mechonis Core"),
		new UniqueMonster("Dazzling Tolosnia", 97, DELocation.TEPHRA_CAVE, "Southwest of Heavenly Window", "Quest Exclusive, After Mechonis Core"),
		new UniqueMonster("Erratic Goliante", 97, DELocation.TEPHRA_CAVE, "South of Heavenly Window", "After Mechonis Core"),
		new UniqueMonster("Firework Geldesia", 98, DELocation.TEPHRA_CAVE, "Arachno Queen's Nest", "Quest Exclusive, After Mechonis Core"),
		new UniqueMonster("Reckless Zanden", 98, DELocation.TEPHRA_CAVE, "Arachno Queen's Nest", "Quest Exclusive, After Mechonis Core"),
		// Bionis' Leg Uniques
		new UniqueMonster("Sniper Paramecia", 15, DELocation.BIONIS_LEG, "Southwestern part of Gaur Plain"),
		new UniqueMonster("Trainer Harmelon", 15, DELocation.BIONIS_LEG, "High hill east of Zax Guidepost"),
		new UniqueMonster("Vagrant Alfead", 16, DELocation.BIONIS_LEG, "Tirkin Headquarters"),
		new UniqueMonster("Violent Andante", 16, DELocation.BIONIS_LEG, "Viliera Hill"),
		new UniqueMonster("Napping Volfen", 17, DELocation.BIONIS_LEG, "Eastern Gaur Plain", "Rain/Thunderstorm"),
		new UniqueMonster("White Eduardo", 17, DELocation.BIONIS_LEG, "Raguel Lake", "Thunderstorm"),
		new UniqueMonster("Night Cardamon", 18, DELocation.BIONIS_LEG, "Kasharpa Falls", "Night, Clear"),
		new UniqueMonster("Clifftop Bayern", 32, DELocation.BIONIS_LEG, "Summit of Daksha Shrine"),
		new UniqueMonster("Mysterious Barnaby", 75, DELocation.BIONIS_LEG, "	Windy Cave"),
		new UniqueMonster("Field Altrich", 76, DELocation.BIONIS_LEG, "North of Crevasse Waterfall"),
		new UniqueMonster("Canyon Valencia", 78, DELocation.BIONIS_LEG, "Observation Platform", "Clear"),
		new UniqueMonster("Territorial Rotbart", 81, DELocation.BIONIS_LEG, "Gaur Plain, east of Jabos Rock Rest Area"),
		new UniqueMonster("Armoured Rockwell", 82, DELocation.BIONIS_LEG, "Under Viliera Hill", "Rain/Thunderstorm"),
		new UniqueMonster("Immovable Gonzalez", 90, DELocation.BIONIS_LEG, "Spiral Valley", "After Xord"),
		// Colony 6 Uniques
		new UniqueMonster("Graceful Holand", 19, DELocation.COLONY_6, "Splintered Path", "Rain/Thunderstorm"),
		new UniqueMonster("Drifter Jutard", 25, DELocation.COLONY_6, "Pod Depot"),
		// Ether Mine Uniques
		new UniqueMonster("Dark Kisling", 20, DELocation.ETHER_MINE, "Central Terminal"),
		new UniqueMonster("Vengeful Daulton", 22, DELocation.ETHER_MINE, "Test Pit 4"),
		new UniqueMonster("Elegant Marin", 29, DELocation.ETHER_MINE, "Glowmoss Lake"),
		// Satorl Marsh Uniques
		new UniqueMonster("Stormy Widardun", 25, DELocation.SATORL_MARSH, "Ridge west of Zaldania Waterfall", "Day"),
		new UniqueMonster("Cautious Balteid", 26, DELocation.SATORL_MARSH, "South of Poison Swamp"),
		new UniqueMonster("Amber Fischer", 27, DELocation.SATORL_MARSH, "Southeast of Altar of Fate"),
		new UniqueMonster("Tumultuous Felix", 27, DELocation.SATORL_MARSH, "The cliff southeast of the Silent Obelisk"),
		new UniqueMonster("Aggressive Cornelius", 28, DELocation.SATORL_MARSH, "Igna Territory"),
		new UniqueMonster("Swift Zektol", 28, DELocation.SATORL_MARSH, "East of Igna Territory", "Day"),
		new UniqueMonster("Sunlight Schvaik", 30, DELocation.SATORL_MARSH, "Barren Moor", "Day"),
		new UniqueMonster("Reckless Godwin", 31, DELocation.SATORL_MARSH, "In the Exile Fortress"),
		new UniqueMonster("Veteran Yozel", 83, DELocation.SATORL_MARSH, "Northeast of the Silent Obelisk", "Night, Fog"),
		new UniqueMonster("Indomitable Daulton", 85, DELocation.SATORL_MARSH, "In the Soter Ruins"),
		new UniqueMonster("Eternal Palsadia", 91, DELocation.SATORL_MARSH, "Top of the Exile Fortress", "After The Giants' Treasure"),
		new UniqueMonster("Despotic Arsene", 108, DELocation.SATORL_MARSH, "Northeast from Glowing Obelisk", "After Mechonis Core"),
		// Makna Forest Uniques
		new UniqueMonster("Agile Albatro", 33, DELocation.MAKNA_FOREST, "Beach below Bridge Three", "Clear/Heatwave"),
		new UniqueMonster("Shimmering Forte", 33, DELocation.MAKNA_FOREST, "Eks Watering Hole", "Heatwave"),
		new UniqueMonster("Elder Gragus", 34, DELocation.MAKNA_FOREST, "East of Nopon Arch", "Clear/Heatwave"),
		new UniqueMonster("Lazy Bluco", 34, DELocation.MAKNA_FOREST, "Yellow Flower Grove", "Night"),
		new UniqueMonster("Obsessive Galgaron", 35, DELocation.MAKNA_FOREST, "Hode Lair"),
		new UniqueMonster("Breezy Zolos", 37, DELocation.MAKNA_FOREST, "Windmill Pavilion"),
		new UniqueMonster("Brutal Gravar", 46, DELocation.MAKNA_FOREST, "King Agni's Tomb", "After Mystery of Makna Ruins 2"),
		new UniqueMonster("Unreliable Rezno", 96, DELocation.MAKNA_FOREST, "Center island in Great Makna Falls", "QE, Day, Not Heatwave, After Mechonis Core"),
		new UniqueMonster("Illustrious Golteuse", 98, DELocation.MAKNA_FOREST, "Precipice Bridge", "Clear/Heatwave, After Mechonis Core"),
		new UniqueMonster("Magnificent Digalus", 99, DELocation.MAKNA_FOREST, "Decayed Forest", "After Mechonis Core"),
		// Frontier Village Uniques
		new UniqueMonster("Frenzied Bana", 78, DELocation.FRONTIER_VILLAGE, "Apex Lake", "Quest Exclusive"),
		// Eryth Sea Uniques
		new UniqueMonster("Turbulent Belmo", 36, DELocation.ERYTH_SEA, "Hovering Reef 1", "Clear/Shooting Stars"),
		new UniqueMonster("Flabbergasted Jerome", 38, DELocation.ERYTH_SEA, "Island below Hovering Reef 5", "Clear/Shooting Stars"),
		new UniqueMonster("Peeling Kircheis", 38, DELocation.ERYTH_SEA, "Hovering Reef 7"),
		new UniqueMonster("Proper Bandaz", 39, DELocation.ERYTH_SEA, "Secluded Island", "Night, Shooting Stars"),
		new UniqueMonster("Tempestuous Edegia", 39, DELocation.ERYTH_SEA, "Hovering Reef 10", "Night"),
		new UniqueMonster("Subterranean Zomar", 40, DELocation.ERYTH_SEA, "Soltnar Seal Island"),
		new UniqueMonster("Cumulus Danaemos", 41, DELocation.ERYTH_SEA, "Khatorl Seal Island"),
		new UniqueMonster("Funeral Gozra", 42, DELocation.ERYTH_SEA, "Hode Refuge"),
		new UniqueMonster("Lightspeed Sonid", 44, DELocation.ERYTH_SEA, "Anu Shore"),
		new UniqueMonster("Stormy Belagon", 87, DELocation.ERYTH_SEA, "Kromar Coast"),
		new UniqueMonster("Bizarre Ragoel", 88, DELocation.ERYTH_SEA, "Anu Shore"),
		new UniqueMonster("Sacred Zagamei", 89, DELocation.ERYTH_SEA, "Hovering Reef 9"),
		new UniqueMonster("Clamorous Dablon", 92, DELocation.ERYTH_SEA, "Sleeping Dragon Isle", "Thunderstorm"),
		new UniqueMonster("Deadly Medorlo", 93, DELocation.ERYTH_SEA, "Central Seal Island", "After Mechonis Core"),
		// High Entia Tomb Uniques
		new UniqueMonster("Calm Anzabi", 38, DELocation.HIGH_ENTIA_TOMB, "Second Treasury"),
		new UniqueMonster("Furious Jozan", 96, DELocation.HIGH_ENTIA_TOMB, "Telethia Laboratory", "After Mechonis Core, Acquired High Entia Emblem"),
		// Valak Mountain Uniques
		new UniqueMonster("Conflagrant Raxeal", 45, DELocation.VALAK_MOUNTAIN, "Lava Cave", "Quest Exclusive"),
		new UniqueMonster("Glorious Buer", 45, DELocation.VALAK_MOUNTAIN, "South of the Sealed Tower"),
		new UniqueMonster("Moonlight Paimon", 46, DELocation.VALAK_MOUNTAIN, "Lava Cave"),
		new UniqueMonster("Vague Barbas", 46, DELocation.VALAK_MOUNTAIN, "Nagul Waterfall"),
		new UniqueMonster("Barbaric Sitri", 47, DELocation.VALAK_MOUNTAIN, "Antol Den"),
		new UniqueMonster("Agile Barbatos", 47, DELocation.VALAK_MOUNTAIN, "Northeast of Ignia Hill", "Night"),
		new UniqueMonster("Banquet Vassago", 48, DELocation.VALAK_MOUNTAIN, "Antol Den", "Quest Exclusive"),
		new UniqueMonster("Hidden Gamigin", 49, DELocation.VALAK_MOUNTAIN, "Southeast of Ignia Hill", "Night"),
		new UniqueMonster("North Star Gusion", 50, DELocation.VALAK_MOUNTAIN, "West edge of the Url Crevasse", "Night, Snow/Blizzard"),
		new UniqueMonster("Exposure Wolfol", 97, DELocation.VALAK_MOUNTAIN, "Lava Cave", "Acquired Magma Rock"),
		new UniqueMonster("Wandering Amon", 98, DELocation.VALAK_MOUNTAIN, "Bionis' Right Elbow", "Night"),
		new UniqueMonster("Final Marcus", 100, DELocation.VALAK_MOUNTAIN, "Three Sage Summit", "Night, Clear/Snowy"),
		new UniqueMonster("Blizzard Belgazas", 114, DELocation.VALAK_MOUNTAIN, "Great Glacier", "After Mechonis Core"),
		new UniqueMonster("Avalanche Abaasy", 120, DELocation.VALAK_MOUNTAIN, "Three Sage Summit", "Night, Blizzard, After Mechonis Core"),
		//Sword Valley Uniques
		new UniqueMonster("Prudent Purson", 49, DELocation.SWORD_VALLEY, "Dolgan Outpost", "Before end of Mechonis Field"),
		new UniqueMonster("Defective Ipos", 50, DELocation.SWORD_VALLEY, "Ether Storage Area", "Before end of Mechonis Field"),
		new UniqueMonster("Tranquil Morax", 50, DELocation.SWORD_VALLEY, "Enalda Control Base", "Before end of Mechonis Field"),
		new UniqueMonster("Fate Labolas", 51, DELocation.SWORD_VALLEY, "Port Maintenance Bay", "Before end of Mechonis Field"),
		new UniqueMonster("Benevolent Alm", 51, DELocation.SWORD_VALLEY, "Monado Wound", "Before end of Mechonis Field"),
		new UniqueMonster("Kamikaze Bune", 53, DELocation.SWORD_VALLEY, "Control Tower", "Before end of Mechonis Field"),
		new UniqueMonster("Lightning Ronove", 55, DELocation.SWORD_VALLEY, "Radio Tower", "Before end of Mechonis Field"),
		new UniqueMonster("Mischievious Naberius", 57, DELocation.SWORD_VALLEY, "3rd Gate", "Before end of Mechonis Field"),
		// Galahad Fortress Uniques
		new UniqueMonster("Glacier Acon", 52, DELocation.GALAHAD_FORTRESS, "1st Turbine Room", "Before end of Mechonis Field"),
		new UniqueMonster("Precious Retrato", 53, DELocation.GALAHAD_FORTRESS, "3rd Fuel Supply Room", "Before end of Mechonis Field"),
		new UniqueMonster("Glorious Jurom", 55, DELocation.GALAHAD_FORTRESS, "Ether Blast Furnace", "Before end of Mechonis Field"),
		// Fallen Arm Uniques
		new UniqueMonster("Evil Bathin", 54, DELocation.FALLEN_ARM, "Ether Exhaust System", "Any"),
		new UniqueMonster("Aged Leraje", 56, DELocation.FALLEN_ARM, "Radiocarpea Coast", "Night"),
		new UniqueMonster("Prosperous Zepar", 56, DELocation.FALLEN_ARM, "Jifum Beach", "Evening"),
		new UniqueMonster("Affluent Beleth", 57, DELocation.FALLEN_ARM, "5th Pulse Zone", "Any"),
		new UniqueMonster("Splendid Botis", 58, DELocation.FALLEN_ARM, "Digit 5 Beach", "Any"),
		new UniqueMonster("Powerful Eligos", 80, DELocation.FALLEN_ARM, "Digit 1", "Any"),
		new UniqueMonster("Wicked Sallos", 95, DELocation.FALLEN_ARM, "Distant Fingertip", "Clear Weather"),
		new UniqueMonster("Ancient Daedala", 105, DELocation.FALLEN_ARM, "Wreckage Beach", "After Mechonis Core"),
		// Mechonis Field Uniques
		new UniqueMonster("Amorous Arca", 57, DELocation.MECHONIS_FIELD, "Bulkhead Controls", "Before Meyneth Shrine"),
		new UniqueMonster("Infernal Crocell", 58, DELocation.MECHONIS_FIELD, "4F Main Power Switch", "Before Meyneth Shrine"),
		new UniqueMonster("Destroyer Salvacion", 59, DELocation.MECHONIS_FIELD, "2F Observation Post", "Before Meyneth Shrine"),
		new UniqueMonster("Revolutionary Bifrons", 60, DELocation.MECHONIS_FIELD, "4F Main Power Switch", "Before Meyneth Shrine"),
		new UniqueMonster("Commander Oracion", 61, DELocation.MECHONIS_FIELD, "Spent Fuel Tank", "Before Meyneth Shrine"),
		// Central Factory Uniques
		new UniqueMonster("Mild Florence", 58, DELocation.CENTRAL_FACTORY, "Landing Strip 2", "Before Mechonis Core"),
		new UniqueMonster("Faithful Lancelot", 59, DELocation.CENTRAL_FACTORY, "Control Tower", "Before Mechonis Core"),
		new UniqueMonster("Beautiful Vagul", 60, DELocation.CENTRAL_FACTORY, "Storage Depot", "Before Mechonis Core"),
		new UniqueMonster("Synchronised Gaheris", 61, DELocation.CENTRAL_FACTORY, "Central Tower Lift", "Before Mechonis Core"),
		new UniqueMonster("Balanced Palamedes", 62, DELocation.CENTRAL_FACTORY, "Central Tower Roof", "Before Mechonis Core"),
		new UniqueMonster("Sinful Lamorak", 63, DELocation.CENTRAL_FACTORY, "Tower Boarding Gate", "Before Mechonis Core"),
		new UniqueMonster("Venerable Focalor", 64, DELocation.CENTRAL_FACTORY, "Training Ground Roof", "Before Mechonis Core"),
		new UniqueMonster("Temporal Gawain", 65, DELocation.CENTRAL_FACTORY, "Control Tower", "Before Mechonis Core"),
		new UniqueMonster("Magestic Mordred", 70, DELocation.CENTRAL_FACTORY, "Face Maintenance Bay", "Before Mechonis Core"),
		// Agniratha Uniques
		new UniqueMonster("Vagabond Allocer", 63, DELocation.AGNIRATHA, "Helas Pillar", "Before Mechonis Core"),
		new UniqueMonster("Experienced Tristan", 64, DELocation.AGNIRATHA, "1st Control Platform", "Before Mechonis Core"),
		new UniqueMonster("Destructive Bors", 64, DELocation.AGNIRATHA, "Telethia Bridge", "Before Mechonis Core"),
		new UniqueMonster("Meditative Varla", 65, DELocation.AGNIRATHA, "Telethia Bridge", "Before Mechonis Core"),
		new UniqueMonster("Soothed Aglovale", 65, DELocation.AGNIRATHA, "Legislative District", "Before Mechonis Core"),
		new UniqueMonster("Sentimental Flamral", 66, DELocation.AGNIRATHA, "Judicial District", "Before Mechonis Core"),
		new UniqueMonster("Wrathful Orobas", 67, DELocation.AGNIRATHA, "Dios Pillar", "Before Mechonis Core"),
		new UniqueMonster("Wise Gremory", 68, DELocation.AGNIRATHA, "Meyneth Statue", "Before Mechonis Core"),
		// Bionis' Interior Uniques
		new UniqueMonster("Active Impulso", 72, DELocation.BIONIS_INTERIOR, "Second Lung", "After Mechonis Core"),
		new UniqueMonster("Mystical Klesida", 72, DELocation.BIONIS_INTERIOR, "Third Lung", "After Mechonis Core"),
		new UniqueMonster("Victorious Gross", 73, DELocation.BIONIS_INTERIOR, "Pars Sympathica Tower", "After Mechonis Core"),
		new UniqueMonster("Clandestine Apety", 74, DELocation.BIONIS_INTERIOR, "Second Lung", "After Mechonis Core"),
		new UniqueMonster("Officer Robusto", 75, DELocation.BIONIS_INTERIOR, "Venous Plexus", "After Mechonis Core"),
		new UniqueMonster("Vivid Anstan", 75, DELocation.BIONIS_INTERIOR, "Third Lung", "After Mechonis Core"),
		new UniqueMonster("Ghostly Mahatos", 76, DELocation.BIONIS_INTERIOR, "Terminal Nerve Tower", "After Mechonis Core"),
		new UniqueMonster("Dark King Barbarus", 77, DELocation.BIONIS_INTERIOR, "	Second Lung", "After Mechonis Core"),
		// Prison Island Uniques
		new UniqueMonster("Ageless Moabit", 75, DELocation.PRISON_ISLAND, "Damaged Transporter", "After Mechonis Core"),
		new UniqueMonster("Inferno Heinrich", 76, DELocation.PRISON_ISLAND, "Kitchen", "After Mechonis Core"),
		new UniqueMonster("Serene Imlaly", 76, DELocation.PRISON_ISLAND, "Banquet Hall", "After Mechonis Core"),
		new UniqueMonster("Cold Ageshu", 77, DELocation.PRISON_ISLAND, "Kitchen", "After Mechonis Core"),
		new UniqueMonster("Abnormal Clone Barg", 77, DELocation.PRISON_ISLAND, "First Sanctum", "After Mechonis Core"),
		new UniqueMonster("Majestic Clone Barg", 77, DELocation.PRISON_ISLAND, "Second Sanctum", "After Mechonis Core"),
		new UniqueMonster("Masterful Gigapur", 77, DELocation.PRISON_ISLAND, "Travalga Bridge", "After Mechonis Core"),
		new UniqueMonster("Fiendish Auburn", 78, DELocation.PRISON_ISLAND, "	Gravina Bridge", "After Mechonis Core")
	};

	private UniqueMonsters() {}

	static
	{
		for (int i = 0; i < UNIQUE_MONSTERS.length; ++i)
		{
			try
			{
				String s = "";

				for (int j = 0; j < UNIQUE_MONSTERS.length; ++j)
				{
					if (j != i && UNIQUE_MONSTERS[j].equals(UNIQUE_MONSTERS[i]))
					{
						s = UNIQUE_MONSTERS[j].name;
					}
				}

				if (!s.isEmpty())
					throw new ExceptionInInitializerError("Found more than one unique monster with the name: " + s);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public static UniqueMonster getByName(String name)
	{
		for (UniqueMonster uniqueMonster : UNIQUE_MONSTERS)
		{
			if (uniqueMonster.name.equals(name))
				return uniqueMonster;
		}

		return null;
	}

	public static class UniqueMonster
	{
		public final String name;
		public final DELocation area;
		public final String location;
		public final int level;
		public final String requirements;

		public UniqueMonster(String name, int level, DELocation area, String location)
		{
			this(name, level, area, location, "");
		}

		public UniqueMonster(String name, int level, DELocation area, String location, String requirements)
		{
			this.name = name;
			this.level = level;
			this.area = area;
			this.location = location;
			this.requirements = requirements;
		}

		public List<Object> getAttributes()
		{
			return Arrays.<Object> asList(name, level, area.name, location, requirements, false);
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 5;
			result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;

			if (obj == null)
				return false;

			if (this.getClass() != obj.getClass())
				return false;

			UniqueMonster other = (UniqueMonster) obj;

			if (!this.name.equalsIgnoreCase(other.name))
				return false;

			return true;
		}

		@Override
		public String toString()
		{
			return this.name;
		}
	}
}