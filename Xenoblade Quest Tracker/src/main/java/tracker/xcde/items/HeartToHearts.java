package tracker.xcde.items;

import java.util.ArrayList;

import tracker.xcde.items.HeartToHearts.HeartToHeart.Affinity;

public class HeartToHearts
{
	public static final HeartToHeart[] HEART_TO_HEARTS = new HeartToHeart[]
	{
		// Colony 9
		new HeartToHeart("Sunrise in the Park", DELocation.COLONY_9, "Outlook Park", "Shulk", "Fiora", Affinity.YELLOW),
		new HeartToHeart("Overlooking the Colony", DELocation.COLONY_9, "Agora Shore", "Reyn", "Sharla", Affinity.LAVENDER, "Colony 6 reconstruction started"),
		new HeartToHeart("Enduring Friendship", DELocation.COLONY_9, "Tephra Cave Entrance", "Reyn", "Shulk", Affinity.GREEN),
		new HeartToHeart("A Heropon's Perspective", DELocation.COLONY_9, "Mechon Wreckage Site", "Riki", "Sharla", Affinity.LAVENDER, "Prison Island events"),
		new HeartToHeart("Ancient Wreckage", DELocation.COLONY_9, "Cylinder Hangar", "Melia", "Reyn", Affinity.LAVENDER, "High Entia Tomb events"),
		new HeartToHeart("Watching Over Them", DELocation.COLONY_9, "Residential District", "Dunban", "Reyn", Affinity.PINK, "Galahad Fortress events"),
		new HeartToHeart("Fiora's Cooking", DELocation.COLONY_9, "Dunban's House", "Fiora", "Reyn", Affinity.GREEN, "Mechon raid"),
		// Tephra Cave
		new HeartToHeart("Glowing in the Night", DELocation.TEPHRA_CAVE, "Spring of Grief", "Dunban", "Riki", Affinity.LAVENDER),
		new HeartToHeart("A Scene Revisited", DELocation.TEPHRA_CAVE, "Kneecap Hill", "Fiora", "Reyn", Affinity.PINK, "Mechon raid"),
		new HeartToHeart("The Legend of the Spider", DELocation.TEPHRA_CAVE, "Bone Corridor", "Reyn", "Shulk", Affinity.LAVENDER, "Mechonis Core events"),
		// Bionis' Leg
		new HeartToHeart("What's On Reyn's Mind", DELocation.BIONIS_LEG, "Inside Refugee Camp", "Reyn", "Sharla", Affinity.GREEN),
		new HeartToHeart("Heir to the Monado", DELocation.BIONIS_LEG, "Outside Refugee Camp", "Dunban", "Reyn", Affinity.GREEN),
		new HeartToHeart("Geography Lesson", DELocation.BIONIS_LEG, "Believer's Paradise", "Dunban", "Shulk", Affinity.LAVENDER),
		new HeartToHeart("Revisiting the Past", DELocation.BIONIS_LEG, "Rho Oasis", "Dunban", "Sharla", Affinity.PINK),
		new HeartToHeart("What Visions May Bring", DELocation.BIONIS_LEG, "Raguel Bridge North", "Sharla", "Shulk", Affinity.GREEN, "Ether Mine events"),
		// Colony 6
		new HeartToHeart("Strength of Heart", DELocation.COLONY_6, "West of Main Entrance", "Dunban", "Shulk", Affinity.PINK, "Nature Lv 3"),
		new HeartToHeart("One Year On", DELocation.COLONY_6, "Pod Depot", "Dunban", "Reyn", Affinity.LAVENDER),
		new HeartToHeart("Renewed Determination", DELocation.COLONY_6, "Freight Elevator", "Reyn", "Shulk", Affinity.PINK, "Mechonis Core events"),
		new HeartToHeart("Dunban's Right Arm", DELocation.COLONY_6, "Turret at Hope Farm", "Dunban", "Sharla", Affinity.LAVENDER, "Galahad Fortress events"),
		new HeartToHeart("Recovery and Reflection", DELocation.COLONY_6, "Ridge at Hope Farm", "Fiora", "Dunban", Affinity.LAVENDER, "Agniratha – Central Tower events"),
		new HeartToHeart("The Colony Reborn", DELocation.COLONY_6, "Reconstruction HQ", "Sharla", "Shulk", Affinity.PINK, "All Lv 5"),
		new HeartToHeart("Quiet Time", DELocation.COLONY_6, "Park", "Fiora", "Riki", Affinity.LAVENDER, "Special Lv 3"),
		// Ether Mine
		new HeartToHeart("A Broken Watch", DELocation.ETHER_MINE, "Mining Base", "Sharla", "Shulk", Affinity.LAVENDER),
		new HeartToHeart("A Wistful Glow", DELocation.ETHER_MINE, "Central Terminal", "Reyn", "Sharla", Affinity.PINK, "Agniratha – Meyneth Shrine events"),
		// Satorl Marsh
		new HeartToHeart("The Shimmering Marsh", DELocation.SATORL_MARSH, "Zaldania Waterfall", "Dunban", "Shulk", Affinity.GREEN),
		new HeartToHeart("High Entia History", DELocation.SATORL_MARSH, "Sororal Statues", "Dunban", "Melia", Affinity.LAVENDER, "High Entia Tomb events"),
		new HeartToHeart("Atop the Crown Tree", DELocation.SATORL_MARSH, "Crown Tree", "Riki", "Sharla", Affinity.PINK),
		// Makna Forest
		new HeartToHeart("Riki's Crazy Crystal Plan", DELocation.MAKNA_FOREST, "Eks Watering Hole", "Reyn", "Riki", Affinity.LAVENDER),
		new HeartToHeart("No Boys Allowed", DELocation.MAKNA_FOREST, "Sparkling Pool", "Melia", "Sharla", Affinity.GREEN),
		new HeartToHeart("Fallen Brethren", DELocation.MAKNA_FOREST, "Agni Tablet", "Melia", "Shulk", Affinity.GREEN),
		// Frontier Village
		new HeartToHeart("At the Pollen Works", DELocation.FRONTIER_VILLAGE, "Pollen Works", "Riki", "Shulk", Affinity.GREEN, "Leone Telethia battle"),
		new HeartToHeart("A Mysterious Sanctuary", DELocation.FRONTIER_VILLAGE, "Prophecy Hut", "Melia", "Riki", Affinity.GREEN),
		new HeartToHeart("A Day Like Any Other", DELocation.FRONTIER_VILLAGE, "Nopon Tower", "Fiora", "Melia", Affinity.LAVENDER),
		new HeartToHeart("Life's Hard for a Heropon", DELocation.FRONTIER_VILLAGE, "Riki's House", "Dunban", "Riki", Affinity.PINK, "Galahad Fortress events"),
		new HeartToHeart("Reawakened Memories", DELocation.FRONTIER_VILLAGE, "7F West of Mysterious Sanctuary", "Fiora", "Sharla", Affinity.LAVENDER),
		new HeartToHeart("True Natures", DELocation.FRONTIER_VILLAGE, "Apex Lake", "Dunban", "Melia", Affinity.GREEN, "High Entia Tomb events"),
		// Eryth Sea:
		new HeartToHeart("Flowers of Eryth Sea", DELocation.ERYTH_SEA, "Hovering Reef 2", "Riki", "Sharla", Affinity.GREEN),
		new HeartToHeart("Riki Have Question", DELocation.ERYTH_SEA, "Syrath Lighthouse", "Fiora", "Riki", Affinity.PINK),
		new HeartToHeart("A Gift for a Loved One", DELocation.ERYTH_SEA, "Ether Plant", "Dunban", "Sharla", Affinity.GREEN, "Galahad Fortress events"),
		new HeartToHeart("Fish Fly! Fish Fly!", DELocation.ERYTH_SEA, "Sleeping Dragon Isle", "Reyn", "Riki", Affinity.GREEN),
		// Alcamoth
		new HeartToHeart("Brother and Sister", DELocation.ALCAMOTH, "SE of Fountain of Hope", "Dunban", "Fiora", Affinity.GREEN),
		new HeartToHeart("Ancient Astrology", DELocation.ALCAMOTH, "West of Melfica Road", "Melia", "Sharla", Affinity.LAVENDER),
		new HeartToHeart("The Forefathers", DELocation.ALCAMOTH, "Great Hall", "Fiora", "Riki", Affinity.GREEN),
		new HeartToHeart("Melia's Imperial Villa", DELocation.ALCAMOTH, "Imperial Villa", "Fiora", "Melia", Affinity.GREEN),
		new HeartToHeart("A Breathtaking Sight", DELocation.ALCAMOTH, "Sky Terrace", "Melia", "Reyn", Affinity.PINK),
		new HeartToHeart("So Close, Yet So Far", DELocation.ALCAMOTH, "Audience Chamber", "Melia", "Shulk", Affinity.LAVENDER),
		// High Entia Tomb
		new HeartToHeart("Hopes and Plans", DELocation.HIGH_ENTIA_TOMB, "Hall of Trials", "Melia", "Shulk", Affinity.PINK, "Mechonis Core events"),
		new HeartToHeart("Echoes of Ancient Times", DELocation.HIGH_ENTIA_TOMB, "Valley of Emperors", "Melia", "Reyn", Affinity.GREEN),
		// Valak Mountain
		new HeartToHeart("In Ose Tower", DELocation.VALAK_MOUNTAIN, "Harict Chapel", "Dunban", "Riki", Affinity.GREEN),
		new HeartToHeart("A Snowy Hot Spring", DELocation.VALAK_MOUNTAIN, "Jakt Geyser", "Riki", "Shulk", Affinity.LAVENDER),
		new HeartToHeart("First Sight of Snow", DELocation.VALAK_MOUNTAIN, "War God Statue", "Fiora", "Reyn", Affinity.LAVENDER),
		// Fallen Arm
		new HeartToHeart("A Night-Time Chat", DELocation.FALLEN_ARM, "Ether Light", "Fiora", "Sharla", Affinity.GREEN),
		new HeartToHeart("A Family of Two", DELocation.FALLEN_ARM, "Junks", "Fiora", "Dunban", Affinity.PINK),
		new HeartToHeart("Overcoming the Pain", DELocation.FALLEN_ARM, "Digit 1", "Fiora", "Melia", Affinity.PINK),
		new HeartToHeart("Eternal Scars", DELocation.FALLEN_ARM, "Black Wreckage", "Dunban", "Melia", Affinity.PINK),
		new HeartToHeart("Just Like Old Times", DELocation.FALLEN_ARM, "Silver Wreckage", "Fiora", "Shulk", Affinity.LAVENDER),
		new HeartToHeart("Camping Spot", DELocation.FALLEN_ARM, "Inlet Beach", "Melia", "Riki", Affinity.LAVENDER),
		new HeartToHeart("Those Waiting for You", DELocation.FALLEN_ARM, "Distant Fingertip", "Riki", "Shulk", Affinity.PINK),
		// Bionis' Interior
		new HeartToHeart("Fiora's Body", DELocation.BIONIS_INTERIOR, "South of Spinal Nerve Tower", "Fiora", "Sharla", Affinity.PINK),
		new HeartToHeart("Kind Words", DELocation.BIONIS_INTERIOR, "West of Terminal Nerve Tower", "Melia", "Riki", Affinity.PINK),
		// Prison Island
		new HeartToHeart("Before the Final Battle", DELocation.PRISON_ISLAND, "Gondorl Cathedral", "Fiora", "Shulk", Affinity.PINK),
		new HeartToHeart("Untold Feelings", DELocation.PRISON_ISLAND, "Gravina Bridge", "Melia", "Sharla", Affinity.PINK),
		new HeartToHeart("Journey's End", DELocation.PRISON_ISLAND, "Empty Throne", "Reyn", "Riki", Affinity.PINK)
	};

	public static HeartToHeart[] getAllInLocation(DELocation location)
	{
		var allHth = new ArrayList<HeartToHeart>();

		for (HeartToHeart hth : HEART_TO_HEARTS)
		{
			if (hth.location.equals(location))
			{
				allHth.add(hth);
			}
		}

		return allHth.toArray(HeartToHeart[]::new);
	}

	public static HeartToHeart getFromName(String name)
	{
		for (HeartToHeart hth : HEART_TO_HEARTS)
		{
			if (hth.name.equalsIgnoreCase(name))
				return hth;
		}

		return null;
	}

	public static class HeartToHeart
	{
		public final String name;
		public final DELocation location;
		public final String area;
		public final String firstPerson;
		public final String secondPerson;
		public final Affinity affinityRequired;
		public final String prerequisites;

		private HeartToHeart(String name, DELocation location, String area, String first, String second, Affinity requiredAffinity)
		{
			this(name, location, area, first, second, requiredAffinity, "");
		}

		private HeartToHeart(String name, DELocation location, String area, String first, String second, Affinity requiredAffinity, String prerequisites)
		{
			this.name = name;
			this.location = location;
			this.area = area;
			this.firstPerson = first;
			this.secondPerson = second;
			this.affinityRequired = requiredAffinity;
			this.prerequisites = prerequisites;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
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

			HeartToHeart other = (HeartToHeart) obj;

			if (this.name == null)
			{
				if (other.name != null)
					return false;
			}
			else if (!this.name.equals(other.name))
				return false;

			return true;
		}



		public static enum Affinity
		{
			YELLOW,
			GREEN,
			BLUE,
			LAVENDER,
			PINK;
		}
	}
}