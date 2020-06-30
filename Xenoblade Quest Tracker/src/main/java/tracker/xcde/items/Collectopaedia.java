package tracker.xcde.items;

import tracker.xcde.items.Collectopaedia.Item.ItemType;

public class Collectopaedia
{
	public static final Category[] COLONY_9_CATEGORIES	= createCategories(DELocation.COLONY_9, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Sweet Wasabi", "Cool Potato", "Red Lettuce", "Chewy Radish"},			"Quick Step III"),
		new Category(ItemType.FRUIT, new String[] 		{"Dance Apple", "Black Kiwi"}, 											"Agility Up II"),
		new Category(ItemType.FLOWER, new String[]		{"Strong Dandelion", "Moon Flower"},									"Poison Defence III"),
		new Category(ItemType.BUG, new String[]			{"Prairie Dragonfly", "Giant Hornet", "White Beetle", "Sorrow Beetle"}, "Regnas Gauntlets"),
		new Category(ItemType.PARTS, new String[]		{"Blue Chain", "Rabbit Diode"},											"Ether Up II"),
		new Category(ItemType.STRANGE, new String[]		{"Plate Snow", "Rainbow Zirconia"},										"Strength Up II")
	});
	public static final Category[] TEPHRA_CAVE_CATEGORIES = createCategories(DELocation.TEPHRA_CAVE, new Category[]
	{
		new Category(ItemType.FRUIT, new String[]		{"Clear Almond", "Bright Fig", "Dark Grape"},							"Lightning Attack II"),
		new Category(ItemType.FLOWER, new String[]		{"Insanity Mint", "Night Tulip"},										"Poison Defence II"),
		new Category(ItemType.ANIMAL, new String[]		{"Shin Newt", "Cave Rat", "Shin Gecko", "Happy Rabbit"},				"HP Up II"),
		new Category(ItemType.BUG, new String[]			{"Brown Butterfly", "Gold Caterpillar", "Rumble Stonefly"},				"Slow Resist II"),
		new Category(ItemType.NATURE, new String[]		{"Kneecap Rock", "Confusion Ivy", "Clarity Moss"},						"Attack Plus II"),
		new Category(ItemType.STRANGE, new String[]		{"Leaf Mystery", "Steel Silk"},											"Attack Stability II")
	});
	public static final Category[] BIONIS_LEG_CATEGORIES = createCategories(DELocation.BIONIS_LEG, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Hot Taro", "Juicy Broccoli", "Spicy Cabbage", "Hard Lotus"},							"Pelt Top"),
		new Category(ItemType.FRUIT, new String[]		{"Sour Gooseberry", "Red Durian", "Walnut Grape", "Humming Plum"},						"Paralysis II"),
		new Category(ItemType.BUG, new String[]			{"White Ladybird", "Hill Firefly", "Moth Crawler", "Queen Locust", "Fire Tarantula"},	"Grand Gauntlets"),
		new Category(ItemType.NATURE, new String[]		{"Mat Ice", "Bluesky Bark", "Pione Stone"},												"Bind Resist II"),
		new Category(ItemType.PARTS, new String[]		{"Rusty Bolt", "Winding Gear"},															"Strength Up II"),
		new Category(ItemType.STRANGE, new String[]		{"Gold Dust Illusion", "Devious Gravity", "White Songbird", "Death Bangle"},			"Pelt Bottoms")
	});
	public static final Category[] COLONY_6_CATEGORIES = createCategories(DELocation.COLONY_6, new Category[]
	{
		new Category(ItemType.FLOWER, new String[]		{"Cute Orchid", "Sirius Anemone", "Spirit Clematis"},					"Auto-Atk Stealth II"),
		new Category(ItemType.ANIMAL, new String[]		{"Pyro Lizard", "Amblygon Turtle", "Dobercorgi"},						"Paralysis Resist II"),
		new Category(ItemType.STRANGE, new String[]		{"Verdant Eternity", "White Night Rod"},								"Ether Def Up II")
	});
	public static final Category[] ETHER_MINE_CATEGORIES = createCategories(DELocation.ETHER_MINE, new Category[]
	{
		new Category(ItemType.ANIMAL, new String[]		{"Light Bat", "Black Frog", "Yellow Cat"},								"Back Atk Plus II"),
		new Category(ItemType.BUG, new String[]			{"Black Beetle", "Rubber Mantis", "Mystery Firefly"},					"Bleed Defence III"),
		new Category(ItemType.NATURE, new String[]		{"Charcoal Leg", "Ether Pebble", "Rumble Coal"},						"Recovery Up II"),
		new Category(ItemType.PARTS, new String[]		{"Black Chip", "Ready Coil"},											"Topple Up II"),
		new Category(ItemType.STRANGE, new String[]		{"Love Crane", "Fire Abron"},											"Muscle Up II")
	});
	public static final Category[] SATORL_MARSH_CATEGORIES = createCategories(DELocation.SATORL_MARSH, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Blue Turnip", "Cute Parsnip", "Poisonous Gourd", "Humming Cabbage"},					"Nopol Gear"),
		new Category(ItemType.FLOWER, new String[]		{"Sunflower Rogue", "Merry Coronation", "Ether Rose", "Orb Daisy", "Forget-You-Not"},	"Jungle Shoes"),
		new Category(ItemType.ANIMAL, new String[]		{"Chimera Rabbit", "Venom Platypus", "Humming Cat"},									"Lock-On Resist II"),
		new Category(ItemType.NATURE, new String[]		{"Mist Tree", "Lemon Stone", "Feather Leaf", "Water Log", "Wool Rock"},					"Nopol Gauntlets"),
		new Category(ItemType.PARTS, new String[]		{"Blue Gear Shard", "Rumble Part"},														"Strength Up II"),
		new Category(ItemType.STRANGE, new String[]		{"Pauper's Cup", "Happy Carnival", "Dawn Dice"},										"Haste II")
	});
	public static final Category[] MAKNA_FOREST_CATEGORIES = createCategories(DELocation.MAKNA_FOREST, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Schorl Mushroom", "Kelp Mushroom", "Honey Rhubarb"},					"Sleep Resist III"),
		new Category(ItemType.FRUIT, new String[]		{"Dark Mango", "Pure Cherry", "Bitter Kiwi", "Juicy Grape"},			"Sky Gloves"),
		new Category(ItemType.FLOWER, new String[]		{"Enigma Lotus", "Humming Nettle", "Princess Daffodil", "Black Iris"},	"Blaze Defence III"),
		new Category(ItemType.ANIMAL, new String[]		{"Ash Fox", "Soft Sea Cucumber", "Fossil Monkey", "Venomous Lizard"},	"Sky Shoes"),
		new Category(ItemType.BUG, new String[]			{"Scarlet Ladybird", "Shield Bug", "Hades Beetle", "Benign Cricket"},	"Slow III"),
		new Category(ItemType.STRANGE, new String[]		{"Lemonade Sky", "Forest of Gossip", "Gravel Disk"},					"Debuff Plus II")
	});
	public static final Category[] FRONTIER_CATEGORIES = createCategories(DELocation.FRONTIER_VILLAGE, new Category[]
	{
		new Category(ItemType.FRUIT, new String[]		{"Spicy Nut", "Crimson Citrus"},										"Strength Up III"),
		new Category(ItemType.BUG, new String[]			{"Rainbow Bug", "Empress Beetle"},										"Weapon Power II"),
		new Category(ItemType.STRANGE, new String[]		{"Rumble Box", "Black Panel"},											"Agility Up III")
	});
	public static final Category[] ERYTH_CATEGORIES = createCategories(DELocation.ERYTH_SEA, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Pink Asparagus", "Tropical Radish", "Dolphin Carrot", "Gold Burdock"},				"Critical Up II"),
		new Category(ItemType.FLOWER, new String[]		{"Sea Berry", "Despair Clover", "Doomsday Poppy", "Night Lily", "Razor Teasel"},		"Mithril Armour"),
		new Category(ItemType.ANIMAL, new String[]		{"Sea Frog", "Mane Cat"},																"Aerial Cloak II"),
		new Category(ItemType.NATURE, new String[]		{"White Tail", "Marine Marble",	"Oil Branch", "Dilemma Rock"},							"Mithril Leggings"),
		new Category(ItemType.STRANGE, new String[]		{"High Violet", "Steel Hauyne"},														"Ether Up III")
	});
	public static final Category[] ALCAMOTH_CATEGORIES = createCategories(DELocation.ALCAMOTH, new Category[]
	{
		new Category(ItemType.FRUIT, new String[]		{"Cool Lemon", "Heart Peach"},											"Blaze Plus III"),
		new Category(ItemType.FLOWER, new String[]		{"Mystic Dahlia", "Stardrop"},											"Muscle Up III"),
		new Category(ItemType.STRANGE, new String[]		{"Ha Ha Ha", "Thunder Atmos"},											"Paralysis Resist III")
	});
	public static final Category[] HIGH_ENTIA_TOMB_CATEGORIES = createCategories(DELocation.HIGH_ENTIA_TOMB, new Category[]
	{
		new Category(ItemType.BUG, new String[]			{"Green Earwig", "Blue Ladybird"},										"Ether Up III"),
		new Category(ItemType.PARTS, new String[]		{"White Tube", "Green Diode", "Spiral Lamp"},							"Electric Plus III"),
		new Category(ItemType.STRANGE, new String[]		{"Tasty Sausage", "Macro Passion"},										"Ether Def Up III")
	});
	public static final Category[] VALAK_CATEGORIES = createCategories(DELocation.VALAK_MOUNTAIN, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Sour Radish", "Ice Cabbage", "Girl Courgette", "Amethyst Vanilla"},					"Heavy Boots"),
		new Category(ItemType.FRUIT, new String[]		{"Ether Plum", "Fire Apple", "Ruby Mangosteen", "Sour Grape"},							"Chill Defence III"),
		new Category(ItemType.FLOWER, new String[]		{"Fortune Mallow", "Black Peony", "Fatal Belladonna"},									"Confuse Resist III"),
		new Category(ItemType.ANIMAL, new String[]		{"Wet Rat", "Ice Monkey", "Crystal Frog", "Mud Squirrel"},								"Aura Heal II"),
		new Category(ItemType.NATURE, new String[]		{"Gypsum Branch", "Black Ash", "Emerald Snow", "Rabbit Stone", "Broom Icicle"}, 		"Heavy Gear"),
		new Category(ItemType.STRANGE, new String[]		{"Frost Glass", "Large Handcuffs"},														"Chill Plus III")
	});
	public static final Category[] SWORD_VALLEY_CATEGORIES = createCategories(DELocation.SWORD_VALLEY, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Fire Pepper", "Meaty Carrot", "Bitter Broccoli"},										"Good Footing III"),
		new Category(ItemType.FRUIT, new String[]		{"Bitter Melon", "Citron Gooseberry", "Juicy Melon", "Amethyst Melon"},					"HP Steal III"),
		new Category(ItemType.FLOWER, new String[]		{"Jujube Silver", "Black Blossom", "Abyss Heather", "Delerium Foxglove"},				"Auto-Heal Up III"),
		new Category(ItemType.PARTS, new String[]		{"Gold Condenser", "Purple Lamp", "Crimson Gear"},										"First Attack Plus III"),
		new Category(ItemType.STRANGE, new String[]		{"Red Frontier", "Darkness Bottle", "Bud of Eternity"},									"Art Seal Resist III")
	});
	public static final Category[] GALAHAD_CATEGORIES = createCategories(DELocation.GALAHAD_FORTRESS, new Category[]
	{
		new Category(ItemType.BUG, new String[]			{"Wheel Lurker", "Ultramarine Ant"},									"Terrain Defence II"),
		new Category(ItemType.PARTS, new String[]		{"Locust Spring", "Art Core Coil", "Tail Antenna"},						"Agility Down III"),
		new Category(ItemType.STRANGE, new String[]		{"Hunger Crash", "Splish Splash"},										"Ether Up III")
	});
	public static final Category[] FALLEN_ARM_CATEGORIES = createCategories(DELocation.FALLEN_ARM, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Sour Turnip", "Golden Beetroot"},										"Muscle Up IV"),
		new Category(ItemType.FRUIT, new String[]		{"White Plum", "Ice Kiwi Fruit", "Spicy Papaya", "Large Mango"},		"Heat Sink III"),
		new Category(ItemType.ANIMAL, new String[]		{"Oil Oyster", "Dark Fish", "Ether Penguin", "Rainbow Slug"},			"Gemini Boots"),
		new Category(ItemType.NATURE, new String[]		{"Poisonous Coral", "Poison Ivy", "Amber Leaf"}, 						"Blaze Defence IV"),
		new Category(ItemType.PARTS, new String[]		{"Warning Lamp", "Digital Filament"},									"Muscle Up IV"),
		new Category(ItemType.STRANGE, new String[]		{"Star Cute", "Summer Star"},											"Strength Up IV")
	});
	public static final Category[] MECHONIS_FIELD_CATEGORIES = createCategories(DELocation.MECHONIS_FIELD, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Juicy Steakplant", "Acerola Pea", "Energy Aubergine", "Sweet Pepper"},				"Taurus Arms"),
		new Category(ItemType.FLOWER, new String[]		{"Azure Hollyhock", "Utopia Crocus"},													"Agility Up IV"),
		new Category(ItemType.BUG, new String[]			{"Scarlet Crawler", "Shiny Scarab", "Water Boatman"},									"Daze Up IV"),
		new Category(ItemType.NATURE, new String[]		{"Ivy Nest", "Mossy Panel", "Bronze Wood"},												"First Attack Plus III"),
		new Category(ItemType.PARTS, new String[]		{"Retro Diode", "Modern Blue Gear", "Snow Transistor"}, 								"Lightning Attack IV"),
		new Category(ItemType.STRANGE, new String[]		{"Tweet Tweet", "Flame Frame"},															"Fall Defence IV")
	});
	public static final Category[] CENTRAL_FACTORY_CATEGORIES = createCategories(DELocation.CENTRAL_FACTORY, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Meaty Potato", "Blue Root"},											"Strength Up IV"),
		new Category(ItemType.ANIMAL, new String[]		{"Prism Centipede", "Cable Mouse", "Oil Fox"},							"Blaze Defence IV"),
		new Category(ItemType.BUG, new String[]			{"Dew Beetle", "Glider Cockroach"},										"Ether Up IV"),
		new Category(ItemType.NATURE, new String[]		{"White Styrene", "Black Styrene", "Blood Oil"},						"Lock-On Resist IV"),
		new Category(ItemType.PARTS, new String[]		{"Angel Engine X", "Leaf Coil", "Warrior Screw"},						"Talent Boost III"),
		new Category(ItemType.STRANGE, new String[]		{"Smoke Cylinder", "Sacred Panther", "Parts Noble"},					"Arts Heal IV")
	});
	public static final Category[] AGNIRATHA_CATEGORIES = createCategories(DELocation.AGNIRATHA, new Category[]
	{
		new Category(ItemType.FRUIT, new String[]		{"Juicy Blueberry", "Sweet Lime", "Spicy Banana"},						"Auto-Heal Up III"),
		new Category(ItemType.FLOWER, new String[]		{"Lewisia Silver", "Freesia Cyst", "Bellflower Crystal"},				"Topple Resist IV"),
		new Category(ItemType.BUG, new String[]			{"Electric Cricket", "Scissor Bug"},									"Ether Def Up IV"),
		new Category(ItemType.NATURE, new String[]		{"Missing Tree", "Fortune Feather"},									"Ether Def Down IV"),
		new Category(ItemType.PARTS, new String[]		{"Fancy Bolt", "Blue Light Amp", "Fairy Tale Diode", "Grape Spring"},	"Daze Resist IV"),
		new Category(ItemType.STRANGE, new String[]		{"Eryth Blue", "Dramatic Night"},										"Tension Swing III")
	});
	public static final Category[] BIONIS_INTERIOR_CATEGORIES = createCategories(DELocation.BIONIS_INTERIOR, new Category[]
	{
		new Category(ItemType.VEGETABLE, new String[]	{"Sarsaparilla", "Black Liver Bean"},									"Haste V"),
		new Category(ItemType.ANIMAL, new String[]		{"Blood Worm", "Azure Mouse", "Happy Duck"},							"Aggro Down IV"),
		new Category(ItemType.STRANGE, new String[]		{"Tap Tap Tap", "High Entia Jewel"},									"Strength Down V")
	});
	public static final Category[] PRISON_ISLAND_CATEGORIES = createCategories(DELocation.PRISON_ISLAND, new Category[]
	{
		new Category(ItemType.FRUIT, new String[]		{"Dry Lemon", "Death Lychee", "Hell Raspberry", "Deadly Kiwi"},			"Break V"),
		new Category(ItemType.ANIMAL, new String[]		{"Dancing Squirrel", "Lightning Weasel", "Angry Monkey"},				"Good Footing V"),
		new Category(ItemType.BUG, new String[]			{"Senorita Scarab", "Emperor Beetle"},									"Agility Up V"),
		new Category(ItemType.NATURE, new String[]		{"Absurd Branch", "Insanity Moss"},										"Strength Up V"),
		new Category(ItemType.PARTS, new String[]		{"White Cover", "Modern Resistor", "Green Cam", "Strong Screw"},		"Ledios Cuisses"),
		new Category(ItemType.STRANGE, new String[]		{"Blue Glow", "Blue Blood"},											"Ether Up V")
	});
	public static final Category[] OTHER_CATEGORIES = createCategories(DELocation.OTHER, new Category[]
	{
		new Category(ItemType.BUG, new String[]			{"Minute Mantis", "Love Beetle"},										"AP Up V"),
		new Category(ItemType.PARTS, new String[]		{"Golden Cog", "Angel Engine Y", "Thunder Compass"},					"EXP Up V"),
		new Category(ItemType.STRANGE, new String[]		{"Coin of Fortune", "Love Source"},										"Critical Up V")
	});

	public static Category[] getCategoryFromLocation(DELocation location)
	{
		switch (location)
		{
		case COLONY_9:
			return COLONY_9_CATEGORIES;
		case TEPHRA_CAVE:
			return TEPHRA_CAVE_CATEGORIES;
		case BIONIS_LEG:
			return BIONIS_LEG_CATEGORIES;
		case COLONY_6:
			return COLONY_6_CATEGORIES;
		case ETHER_MINE:
			return ETHER_MINE_CATEGORIES;
		case SATORL_MARSH:
			return SATORL_MARSH_CATEGORIES;
		case MAKNA_FOREST:
			return MAKNA_FOREST_CATEGORIES;
		case FRONTIER_VILLAGE:
			return FRONTIER_CATEGORIES;
		case ERYTH_SEA:
			return ERYTH_CATEGORIES;
		case ALCAMOTH:
			return ALCAMOTH_CATEGORIES;
		case HIGH_ENTIA_TOMB:
			return HIGH_ENTIA_TOMB_CATEGORIES;
		case VALAK_MOUNTAIN:
			return VALAK_CATEGORIES;
		case SWORD_VALLEY:
			return SWORD_VALLEY_CATEGORIES;
		case GALAHAD_FORTRESS:
			return GALAHAD_CATEGORIES;
		case FALLEN_ARM:
			return FALLEN_ARM_CATEGORIES;
		case MECHONIS_FIELD:
			return MECHONIS_FIELD_CATEGORIES;
		case CENTRAL_FACTORY:
			return CENTRAL_FACTORY_CATEGORIES;
		case AGNIRATHA:
			return AGNIRATHA_CATEGORIES;
		case BIONIS_INTERIOR:
			return BIONIS_INTERIOR_CATEGORIES;
		case PRISON_ISLAND:
			return PRISON_ISLAND_CATEGORIES;
		case OTHER:
			return OTHER_CATEGORIES;
		default:
			return null;
		}
	}

	private static Category[] createCategories(DELocation location, Category... categories)
	{
		for (Category category : categories)
		{
			category.location = location;
		}

		return categories;
	}

	public static class Category
	{
		public final ItemType categoryType;
		public final Item[] items;
		public final String reward;
		private DELocation location;

		private Category(ItemType type, String[] items, String reward)
		{
			this.categoryType = type;
			Item[] actualItems = new Item[items.length];

			for (int i = 0; i < actualItems.length; ++i)
			{
				actualItems[i] = new Item(items[i], type, location);
			}

			this.items = actualItems;
			this.reward = reward;
		}
	}

	public static class Item
	{
		public final String name;
		private DELocation location;
		private ItemType type;

		private Item(String name)
		{
			this.name = name;
		}

		private Item(String name, ItemType type, DELocation location)
		{
			this.name = name;
			this.location = location;
			this.type = type;
		}

		public DELocation getLocation()
		{
			return this.location;
		}

		public ItemType getType()
		{
			return this.type;
		}

		public static enum ItemType
		{
			VEGETABLE,
			FRUIT,
			FLOWER,
			ANIMAL,
			BUG,
			NATURE,
			PARTS,
			STRANGE
		}
	}
}