package tracker.xcde.items;

public class Achievements
{
	public static final Achievement[] ACHIEVEMENTS = new Achievement[]
	{
		// ============================TRIALS============================
		// Unique Monsters
		new Trial("Hunter-in-Training", "Defeat a Unique Monster.", 50),
		new Trial("Pro Hunter", "Defeat 10 Unique Monster.", 500),
		new Trial("Master Hunter", "Defeat 100 Unique Monsters.", 1500),
		// Exploring the World
		new Trial("First Steps", "Discover any Landmark.", 10),
		new Trial("A Corner of the World", "Discover 10 Landmarks.", 50),
		new Trial("Seasoned Traveller", "Discover 40 Landmarks.", 500),
		new Trial("Globetrotter", "Discover 80 Landmarks.", 1000),
		new Trial("Worldly Wise", "Discover 150 Landmarks.", 1500),
		new Trial("Explorer", "Discover a Secret Area.", 200),
		new Trial("Trailblazer", "Discover 6 Secret Areas.", 500),
		new Trial("Pioneer", "Discover 12 Secret Areas.", 1000),
		// Affinity Chart
		new Trial("Your First Friend", "Get to know a named person.", 10),
		new Trial("Friend Number Ten", "Register 10 people on the Affinity Chart.", 50),
		new Trial("Fifty Fine Friends", "Register 50 people on the Affinity Chart.", 1000),
		new Trial("Friend of the World", "Register 120 people on the Affinity Chart.", 1500),
		new Trial("The Brave Protectors", "Get to know all of the Defence Force soldiers in Colony 9.", 50),
		new Trial("Network of Knowledge", "Get to know many Nopon outside of populated areas.", 1000),
		new Trial("The Hopeful Survivors", "Get to know a lot of people in Colony 6.", 1000),
		new Trial("Know So Many Nopon", "Get to know the Nopon living in Frontier Village.", 1000),
		new Trial("Wings of Nobility", "Get to know many High Entia with small headwings.", 1000),
		new Trial("A Village of Machines", "Get to know numerous Machina in the Hidden Village.", 1000),
		// Affinity Links
		new Trial("The Strongest Tie", "Help two people form a deep affinity for one another.", 100),
		new Trial("Constellation", "Help people form an Affinity for one another 10 times.", 50),
		new Trial("Spider's Web", "Help people form an Affinity for one another 50 times.", 500),
		new Trial("Neural Network", "Help people form an Affinity for one another 100 times.", 1000),
		new Trial("Roots Across the World", "Help almost everyone form an Affinity for one another.", 30000),
		// Area Affinity
		new Trial("Colony 9 Celeb", "Achieve 3-star Affinity rating for Colony 9.", 500),
		new Trial("Colony 6 Celeb", "Achieve 3-star Affinity rating for Colony 6.", 500),
		new Trial("Honorary Nopon", "Achieve 3-star Affinity rating for Froniter Village.", 500),
		new Trial("Honorary High Entia", "Achieve 3-star Affinity rating for Alcamoth.", 500),
		new Trial("Honorary Machina", "Achieve 3-star Affinity rating for Hidden Village.", 500),
		new Trial("Local Hero", "Achieve 5-star Affinity with the people of any area.", 1000),
		new Trial("World Hero", "Achieve 5-star Affinity with everyone.", 30000),
		// Heart-to-Hearts
		new Trial("Heartwarming", "Have a Heart-to-Heart go as smoothly as possible.", 100),
		new Trial("Heartbreaking", "Have a Heart-to-Heart go as badly as possible.", 10),
		new Trial("Pouring Out Your Heart", "Have 20 Heart-to-Hearts.", 500),
		new Trial("The Heart of the Matter", "Have 40 Heart-to-Hearts.", 1000),
		new Trial("Ace of Hearts", "Have all possible Heart-to-Hearts.", 1500),
		// Quests
		new Trial("Problem Solved!", "Complete a quest.", 20),
		new Trial("Helpful Stranger", "Complete 10 quests (excluding story quests).", 100),
		new Trial("Generous Friend", "Complete 100 quests (excluding story quests).", 500),
		new Trial("Charitable Ally", "Complete 200 quests (excluding story quests).", 1000),
		new Trial("Selfless Giver", "Complete 300 quests (excluding story quests).", 50000),
		new Trial("Shaping History", "Change someone's life through your actions.", 50),
		// Colony 6 Reconstruction
		new Trial("Drawing a Crowd", "Increase population of Colony 6 to 50 people.", 500),
		new Trial("Building a Community", "Increase population of Colony 6 to 100 people.", 1000),
		new Trial("Bursting at the Seams", "Increase population of Colony 6 to 150 people.", 50000),
		new Trial("A Fixer-Upper", "Start reconstruction of Colony 6.", 200),
		new Trial("A Fix on the Solution", "Make good progress in reconstructing Colony 6.", 1000),
		new Trial("Good and Fixed", "Finish reconstructing Colony 6. Amazing!", 50000),

		// ============================RECORDS============================
		// Single Attack Damage
		new Record("Bone Breaker", "Deal 3000+ damage in a single attack.", 100),
		new Record("Rock Smasher", "Deal 25000+ damage in a single attack.", 500),
		new Record("World Shaker", "Deal 50000+ damage in a single attack.", 1000),
		// Defeating Enemies
		new Record("Beginner's Luck", "Defeat 50 enemies.", 50),
		new Record("Tough Guy, Eh?", "Defeat 200 enemies.", 200),
		new Record("No Stopping You", "Defeat 1000 enemies.", 500),
		new Record("Please! No More!", "Defeat 2000 enemies.", 1000),
		// Useless in Battle
		new Record("Time for New Glasses", "Attempt 100 attacks that miss.", 100),
		new Record("Some Help You Are!", "Win a battle without actually doing anything.", 20),
		// Enemy Categories
		new Record("Machine Mishaps", "Defeat 30 Mechon.", 100),
		new Record("Machine Mayhem", "Defeat 100 Mechon.", 500),
		new Record("Machine Meltdown", "Defeat 250 Mechon.", 1500),
		new Record("Ground Down", "Defeat 30 ground monsters.", 100),
		new Record("Ground Up", "Defeat 100 ground monsters.", 500),
		new Record("Ground to a Pulp", "Defeat 250 ground monsters.", 1500),
		new Record("Airing Grievances", "Defeat 30 aerial monsters.", 100),
		new Record("Clearing the Air", "Defeat 100 aerial monsters.", 500),
		new Record("Anti-Air Battering", "Defeat 250 aerial monsters.", 1500),
		new Record("Bug Off", "Defeat 30 insects.", 100),
		new Record("Walking Insecticide", "Defeat 100 insects.", 500),
		new Record("Elementary!", "Defeat 30 ether-based monsters.", 100),
		new Record("Braving the Elements", "Defeat 100 ether-based monsters.", 500),
		new Record("Telethia Tracker", "Defeat 30 Telethia.", 5000),
		new Record("Telethia Triumph", "Defeat 100 Telethia.", 10000),
		new Record("Fish for Compliments", "Defeat 30 monsters that live in water.", 200),
		// Visions
		new Record("Smashing!", "Smash a vision tag.", 20),
		new Record("Simply Smashing!", "Smash 100 vision tags.", 200),
		new Record("Smashing... to Pieces!", "Smash 1000 vision tags.", 500),
		new Record("Not Gonna Happen!", "Stop the future in its tracks once.", 20),
		new Record("I'll Change the Future!", "Stop the future in its tracks 20 times.", 200),
		new Record("The Future is Ours!", "Stop the future in its tracks 50 times.", 500),
		// Reviving Party Members
		new Record("Second Wind", "Revive incapacitated party members 10 times.", 20),
		new Record("Can't Keep 'em Down", "Revive incapacitated party members 100 times.", 200),
		new Record("Down But Never Out", "Revive incapacitated party members 500 times.", 500),
		// Critical Hits
		new Record("Critical Thinking", "Deliver 50 critical hits.", 50),
		new Record("Critical Condition", "Deliver 1500 critical hits.", 200),
		new Record("Critical Mass", "Deliver 5000 critical hits.", 500),
		// Battle Start Affinity
		new Record("Let's Fight!", "Achieve Battle Start Affinity once.", 10),
		new Record("Let's Go, Everyone!", "Achieve Battle Start Affinity 100 times.", 200),
		new Record("Yeah! We Can Do It!", "Achieve Battle Start Affinity 1000 times.", 500),
		// High Tension
		new Record("Turn It Up", "Enter state of High Tension once.", 20),
		new Record("Fire It Up", "Enter state of High Tension 50 times.", 200),
		new Record("Burn It Up", "Enter state of High Tension 200 times.", 500),
		// Chain Attacks
		new Record("Go Team!", "Use a chain attack once.", 20),
		new Record("Tip Top Team-Up", "Use a chain attack 50 times.", 200),
		new Record("A Team Like No Other", "Use a chain attack 200 times.", 500),
		new Record("Team With A Capital T", "Use a chain attack 1000 times.", 1000),
		new Record("Killer Combo", "Use a chain attack which deals 3000+ total damage.", 100),
		new Record("Cosmic Killer Combo", "Use a chain attack which deals 30,000+ total damage.", 500),
		new Record("Quantum Killer Combo", "Use a chain attack which deals 100,000+ total damage.", 1000),
		new Record("Chain Gang", "Perform a chain attack with 4+ links.", 50),
		new Record("Off the Chain", "Perform a chain attack with 5+ links.", 200),
		// Back Attacks
		new Record("Back-Stabber", "Perform a back attack once.", 10),
		new Record("Rear Admiral", "Perform a back attack 50 times.", 200),
		new Record("Ninja Skillz", "Attack an enemy from behind and beat it in one stike.", 50),
		// Near Death
		new Record("Jaws of Defeat", "Win a battle while on the verge of death.", 20),
		new Record("Come On, Chear Up!", "Feel the pain of being incapacitated for the first time.", 20),
		new Record("Phoenix", "Been wiped out 50 times.", 500),
		// Using Arts
		new Record("Art Practice", "Use Arts 1000 times between the entire party.", 200),
		new Record("The Art of War", "Use Arts 10,000 times between the entire party.", 1000),
		new Record("Right, Let's Do This!", "Use Shulk's Arts 100 times.", 50),
		new Record("Reyn Time, Baby!", "Use Reyn's Arts 100 times.", 50),
		new Record("I Can Beat Anyone!", "Use Fiora's Arts 100 times.", 200),
		new Record("Attack Me if You Dare!", "Use Dunban's Arts 100 times.", 500),
		new Record("Things Are Heating Up!", "Use Sharla's Arts 100 times.", 500),
		new Record("Riki Use Arts!", "Use Riki's Arts 100 times.", 500),
		new Record("Who Dares Defy Me?", "Use Melia's Arts 100 times.", 500),
		// Leveling Arts
		new Record("One Step Further", "Unlock the ability to level up a character's Arts even further.", 100),
		new Record("The Final Step", "Unlock the ability to level up a character's Arts completely.", 500),
		new Record("Art School", "Level up an Art once.", 20),
		new Record("A Work of Art", "Raise an Art to level 5.", 200),
		new Record("Perfecting the Art", "Raise an Art to maximum level.", 1000),
		new Record("Down to a Fine Art", "Raise 5 of one character's Arts to maximum level.", 1500),
		new Record("Art-to-Art", "Raise 10 of one character's Arts to maximum level.", 1500),
		new Record("State of the Art", "Raise all of one character's Arts to maximum level.", 1500),
		// Developing Skills
		new Record("Sharing the Knowledge", "Receive shared skills from every character.", 200),
		new Record("Specialist", "Fully develop one Skill Branch.", 500),
		new Record("Honest Insight", "Fully develop three of Shulk's Skill Branches.", 500),
		new Record("Raging Stalwart", "Fully develop three of Reyn's Skill Branches.", 500),
		new Record("Spirited Adventurer", "Fully develop three of Fiora's Skill Branches.", 500),
		new Record("Gallant Hero", "Fully develop three of Dunban's Skill Branches.", 500),
		new Record("Unyielding Devotion", "Fully develop three of Sharla's Skill Branches.", 500),
		new Record("Adorable Randomness", "Fully develop three of Riki's Skill Branches.", 500),
		new Record("Serene Candour", "Fully develop three of Melia's Skill Branches.", 500),
		new Record("Secret Weapon", "Fully develop any character's Skill Branches.", 1000),
		new Record("Dream Team", "Fully develop every character's Skill Branches.", 1500),
		// Burst Affinity
		new Record("Turning it Around", "Successfully achieve Burst Affinity.", 10),
		new Record("Changing Course", "Achieve Burst Affinity 300 times.", 200),
		new Record("Complete 180", "Achieve Burst Affinity 2000 times.", 500),
		// Higher Level Enemies
		new Record("Looking for Trouble", "Defeat an enemy 5 levels higher than the party leader.", 50),
		new Record("Beating the Odds", "Defeat an enemy 10 levels higher than the party leader.", 500),
		// Exact Damage
		new Record("Unlucky Sixes", "Perform an attack that deals exactly 666 damage.", 66),
		new Record("Lucky Sevens", "Perform an attack that deals exactly 777 damage.", 77),
		// Skip Travel
		new Record("Skip It", "Use skip travel once.", 10),
		new Record("Lazybones", "Use skip travel 50 times.", 100),
		// Treasure Chests
		new Record("Hunting for Treasure", "Obtain 10 Rare Treasure Chests.", 50),
		new Record("Hoarding Treasure", "Obtain 50 Rare Treasure Chests.", 500),
		new Record("Ooh, Shiny", "Obtain a Super Rare Treasure Chest.", 20),
		new Record("It Hasn't Lost its Lustre", "Obtain 10 Super Rare Treasure Chests.", 100),
		new Record("Need... More... Treasure", "Obtain 50 Super Rare Treasure Chests.", 1000),
		new Record("Treasure Trove", "Obtain 1000 Super Rare Treasure Chests.", 1000),
		// Harvesting Crystals
		new Record("Titan's Gift", "Harvest an ether crystal.", 20),
		new Record("Titan's Generosity", "Harvest ether crystals 50 times.", 200),
		new Record("Titan's Greatness", "Harvest ether crystals 500 times.", 500),
		new Record("Raring to Go", "Obtain a rare ether crystal.", 20),
		new Record("Medium Rare", "Obtain 7 rare ether crystals.", 50),
		new Record("In Rare Form", "Obtain 77 rare ether crystals.", 500),
		new Record("Crystallised Luck", "Mine a rank V ether crystal.", 500),
		// Gems and Gem Crafting
		new Record("That Hits the Slot", "Fill a gem slot.", 20),
		new Record("Truly Outrageous", "Fill all 8 possible gem slots at once for any character.", 500),
		new Record("Learning the Craft", "Practice Gem Crafting and receieve a Synergy Bonus.", 20),
		new Record("Getting Crafty", "Receieve a Synergy Bonus more than 250 times.", 500),
		new Record("Crafting Your Destiny", "Receieve a Synergy Bonus more than 500 times.", 100),
		new Record("Craftacular!", "Enter a Fever state while Gem Crafting.", 50),
		new Record("Craftstravaganza!", "Enter a Fever state 3 times.", 1500),
		new Record("Lending a Hand", "Receive a Support Bonus.", 20),
		new Record("Crafting Friendships", "Receive a Support Bonus for every character.", 1000),
		new Record("Firing on All Cylinders", "Fill up the Cylinder Gauge 9 times in one crafting session.", 2000),
		// Passing time
		new Record("Happy New Year!", "Witness the sun rising on 366th day.", 1500),
		// Falling
		new Record("Terminal Velocity", "Fall to your demise from a great height.", 20),
		new Record("Making Waves", "Fall into water from a height of 200 meters.", 50),
		// Collectopaedia
		new Record("One is Never Enough", "Record an item in the Collectopaedia.", 10),
		new Record("Collector's Mentaility", "Complete a page in the Collectopaedia.", 200),
		new Record("Stamp of Insanity", "Complete every page in the Collectopaedia.", 50000),
		// Gifts
		new Record("Study Aids", "Give Shulk 20 pieces of machinery as gifts.", 100),
		new Record("Auber the Top", "Give Reyn an Energy Aubergine as a gift.", 500),
		new Record("Aim for the Heart!", "Have Fiora give 20 gifts to Shulk.", 200),
		new Record("Thanks But No Thanks", "Give Dunban an Ether Plumb as a gift.", 500),
		new Record("Fruitful Gifts", "Give Sharla fruit as a gift 20 times.", 500),
		new Record("You May Have This", "Have Melia give 30 gifts.", 500),
		new Record("Not Just Riki Eat!", "Have Riki give insects as gifts 30 times.", 500),
		new Record("Love at First Bite", "Give Love Source as a present.", 50000),
		// Talking to People
		new Record("Ear to the Ground", "Talk to people 100 times.", 100),
		new Record("Social Butterfly", "Talk to people 1000 times.", 1000),
		new Record("Breaking the Ice", "Have a party member step into a conversation.", 10),
		new Record("Idle Chit-Chat", "Have a party member step into a conversation 50 times.", 100),
		new Record("Chatting the Day Away", "Have a party member step into a conversation 300 times.", 500),
		// Party Member Affinity
		new Record("Blossoming Friendship", "Improve the Affinity between two party members.", 50),
		new Record("Unshakable Trust", "Improve two party members' Affinity still further.", 500),
		new Record("Unbreakable Bond", "Form the deepest Affinity between two party members.", 1500),
		new Record("Get the Party Started", "Deepen the Affinity between all party members.", 8000),
		new Record("Party's in Full Swing", "Form the deepest Affinity between all party members.", 15000),
		// Trading
		new Record("Equivalent Exchange", "Successfully trade items with someone.", 20),
		new Record("Tradesman", "Trade items 20 times.", 100),
		new Record("Master Tradesman", "Trade items 100 times.", 500),
		new Record("Mysterious Mantis", "Obtain a Minute Mantis through trading.", 3000),
		new Record("Shining Impracticality", "Obtain a Golden Cog", 3000),
		new Record("Indigo Belligerence", "Obtain a Love Beetle through trading.", 3000),
		new Record("Stormy Outlook", "Obtain a Thunder Compass through trading.", 3000),
		new Record("Angelic Imitation", "Obtain a Angel Engine Y through trading.", 3000)
	};

	public static Achievement getFromName(String name)
	{
		for (Achievement achievement : ACHIEVEMENTS)
		{
			if (achievement.name.equalsIgnoreCase(name))
				return achievement;
		}

		return null;
	}

	public static class Record extends Achievement
	{
		private Record(String name, String details, int reward)
		{
			super(AchievementType.RECORD, name, details, reward);
		}
	}

	public static class Trial extends Achievement
	{
		private Trial(String name, String details, int reward)
		{
			super(AchievementType.TRIAL, name, details, reward);
		}
	}

	public static class Achievement
	{
		public final AchievementType type;
		public final String name;
		public final String details;
		public final int xpReward;

		public Achievement(AchievementType type, String name, String details, int reward)
		{
			this.type = type;
			this.name = name;
			this.details = details;
			this.xpReward = reward;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			result = prime * result + xpReward;
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

			Achievement other = (Achievement) obj;

			if (name == null)
			{
				if (other.name != null)
					return false;
			}
			else if (!name.equals(other.name))
				return false;

			return true;
		}

		@Override
		public String toString()
		{
			return this.type + "=" + this.name;
		}

		public enum AchievementType
		{
			RECORD("Records"),
			TRIAL("Trials");
			public final String name;

			AchievementType(String type)
			{
				this.name = type;
			}

			public static AchievementType getFromType(String type)
			{
				for (AchievementType at : values())
				{
					if (at.name.equalsIgnoreCase(type))
						return at;
				}

				return RECORD;
			}
		}
	}
}