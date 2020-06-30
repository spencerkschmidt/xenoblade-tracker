package tracker.xcde.items;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DEQuests
{
	public static final DEQuest[] COLONY_9 = new DEQuest[]
	{
		new DEQuest(1, "Mementos of a Lost Son", QuestType.NORMAL),
		new DEQuest(2, "The Key to a Long Life", QuestType.NORMAL),
		new DEQuest(3, "A Curry Conundrum", QuestType.NORMAL),
		new DEQuest(4, "Biscuits for a Grandson", QuestType.NORMAL),
		new DEQuest(5, "Birthday Shoes", QuestType.NORMAL),
		new DEQuest(6, "Education-Minded Suzanna", QuestType.NORMAL),
		new DEQuest(7, "Education-Crazy Suzanna", QuestType.NORMAL),
		new DEQuest(8, "Flattened Flowers", QuestType.NORMAL),
		new DEQuest(9, "Lonely Niranira", QuestType.NORMAL),
		new DEQuest(10, "The Broken Watch", QuestType.NORMAL),
		new DEQuest(11, "The Old Soldier's Test", QuestType.NORMAL),
		new DEQuest(12, "Romantic Notions of a Girl", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(13),
		new DEQuest(13, "Romantic Notions of a Boy", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(12),
		new DEQuest(14, "An Impoverished Critic", QuestType.NORMAL),
		new DEQuest(15, "Financial Planning", QuestType.NORMAL),
		new DEQuest(16, "Overworked and Underpaid", QuestType.NORMAL),
		new DEQuest(17, "Pestering Paola", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(18),
		new DEQuest(18, "Out-of-Luck Giorgio", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(17),
		new DEQuest(19, "Paola and Narine", QuestType.NORMAL),
		new DEQuest(20, "The Plan - Preparation", QuestType.NORMAL),
		new DEQuest(21, "The Plan - The Night Before", QuestType.NORMAL),
		new DEQuest(22, "The Plan - Execution", QuestType.NORMAL),
		new DEQuest(23, "A Young Captain's Request", QuestType.NORMAL),
		new DEQuest(24, "A Young Captain's Suffering", QuestType.NORMAL),
		new DEQuest(25, "A Young Captain's Rise", QuestType.NORMAL),
		new DEQuest(26, "A Young Captain's Challenge", QuestType.NORMAL),
		new DEQuest(27, "A Young Captain's Trust", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(28),
		new DEQuest(28, "A Young Captain's Revival", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(27),
		new DEQuest(29, "Pride and Courage", QuestType.NORMAL),
		new DEQuest(30, "Friendship Tokens", QuestType.NORMAL),
		new DEQuest(31, "A Big Brother's Fight", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(32),
		new DEQuest(32, "A Little Brother's Fight", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(31),
		new DEQuest(33, "A Place to Come Home to", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(34),
		new DEQuest(34, "Thawing Relations", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(33),
		new DEQuest(35, "Rocco's Heartful Request", QuestType.NORMAL),
		new DEQuest(36, "Dean's Shady Request", QuestType.NORMAL),
		new DEQuest(37, "Lillana's Sincere Request", QuestType.NORMAL),
		new DEQuest(38, "Jackson's Awakening", QuestType.NORMAL),
		new DEQuest(39, "Jackson the Cook", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(40),
		new DEQuest(40, "Jackson the Poet", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(39),
		new DEQuest(41, "Désirée's Future", QuestType.NORMAL),
		new DEQuest(42, "Betty's Gift", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(43),
		new DEQuest(43, "Désirée's Apology", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(42),
		new DEQuest(44, "The Elite Captain's Anguish", QuestType.NORMAL),
		new DEQuest(45, "Getting to Know Minnie", QuestType.NORMAL),
		new DEQuest(46, "Getting to Know Dorothy", QuestType.NORMAL),
		new DEQuest(47, "A Mysterious Light", QuestType.NORMAL),
		new DEQuest(48, "Out Like a Light?", QuestType.NORMAL),
		new DEQuest(49, "The Lost Pendant", QuestType.NORMAL),
		new DEQuest(50, "Monster Quest 1 - Part 1", QuestType.NORMAL),
		new DEQuest(51, "Monster Quest 1 - Part 2", QuestType.NORMAL),
		new DEQuest(52, "Monster Quest 1 - Part 3", QuestType.NORMAL),
		new DEQuest(53, "Monster Quest 2 - Part 1", QuestType.NORMAL),
		new DEQuest(54, "Monster Quest 2 - Part 2", QuestType.NORMAL),
		new DEQuest(55, "Monster Quest 2 - Part 3", QuestType.NORMAL),
		new DEQuest(56, "Monster Quest 3 - Part 1", QuestType.NORMAL),
		new DEQuest(57, "Monster Quest 3 - Part 2", QuestType.NORMAL),
		new DEQuest(58, "Monster Quest 3 - Part 3", QuestType.NORMAL),
		new DEQuest(59, "Monster Quest 3 - Part 4", QuestType.NORMAL),
		new DEQuest(60, "Monster Quest 4 - Part 1", QuestType.NORMAL),
		new DEQuest(61, "Monster Quest 4 - Part 2", QuestType.NORMAL),
		new DEQuest(62, "Monster Quest 4 - Part 3", QuestType.NORMAL),
		new DEQuest(63, "Challenge 1", QuestType.NORMAL),
		new DEQuest(64, "Challenge 2", QuestType.NORMAL),
		new DEQuest(65, "Challenge 3", QuestType.NORMAL),
		new DEQuest(66, "Challenge 4", QuestType.NORMAL),
		new DEQuest(67, "Material Quest 1", QuestType.NORMAL),
		new DEQuest(68, "Material Quest 2", QuestType.NORMAL),
		new DEQuest(69, "Material Quest 3", QuestType.NORMAL),
		new DEQuest(70, "Material Quest 4", QuestType.NORMAL),
		new DEQuest(71, "Collection Quest 1", QuestType.NORMAL),
		new DEQuest(72, "Collection Quest 2", QuestType.NORMAL),
		new DEQuest(73, "Collection Quest 3", QuestType.NORMAL),
		new DEQuest(74, "Collection Quest 4", QuestType.NORMAL),
		new DEQuest(75, "Search Quest 1", QuestType.NORMAL),
		new DEQuest(76, "Search Quest 2", QuestType.NORMAL),
		new DEQuest(77, "Search Quest 3", QuestType.NORMAL),
		new DEQuest(78, "Search Quest 4", QuestType.NORMAL),
		new DEQuest(79, "A Token of Friendship", QuestType.NORMAL),
		new DEQuest(80, "The Gem Man's Invention", QuestType.NORMAL),
		new DEQuest(81, "Delivering Food", QuestType.STORY)
	};
	public static final DEQuest[] TEPHRA_CAVE = new DEQuest[]
	{
		new DEQuest(82, "Missing in Action", QuestType.NORMAL),
		new DEQuest(83, "Arachno Silk Fundraising", QuestType.NORMAL),
		new DEQuest(84, "A Thank You", QuestType.NORMAL),
		new DEQuest(85, "Clear Obstructions", QuestType.NORMAL),
		new DEQuest(86, "The Book of Bafalgar", QuestType.NORMAL),
		new DEQuest(87, "The Blood of Bafalgar", QuestType.NORMAL),
		new DEQuest(88, "The Path of Bafalgar", QuestType.NORMAL),
		new DEQuest(89, "The Coffin of Bafalgar", QuestType.NORMAL),
		new DEQuest(90, "The Gratitude of Bafalgar", QuestType.NORMAL),
		new DEQuest(91, "Collection Quest 1", QuestType.NORMAL),
		new DEQuest(92, "Collection Quest 2", QuestType.NORMAL),
		new DEQuest(93, "Material Quest 1", QuestType.NORMAL),
		new DEQuest(94, "Material Quest 2", QuestType.NORMAL)
	};
	public static final DEQuest[] BIONIS_LEG = new DEQuest[]
	{
		new DEQuest(95, "Emergency Treatment", QuestType.TIMED),
		new DEQuest(96, "Being a Good Grandfather", QuestType.TIMED),
		new DEQuest(97, "A Thoughtful Idea", QuestType.TIMED),
		new DEQuest(98, "A Dash of Colour", QuestType.TIMED),
		new DEQuest(99, "Imaginations Tempered", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(100),
		new DEQuest(100, "Spirits Raised", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(99),
		new DEQuest(101, "Thieving Monsters", QuestType.TIMED),
		new DEQuest(102, "The Greedy Monster", QuestType.TIMED),
		new DEQuest(103, "Save the Girl!", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(104, "Earnest's Fibs", QuestType.NORMAL),
		new DEQuest(105, "Earnest's Mischief", QuestType.NORMAL),
		new DEQuest(106, "Earnest's Solitude", QuestType.NORMAL),
		new DEQuest(107, "The Lost Nopon", QuestType.NORMAL),
		new DEQuest(108, "With Much Gratitude", QuestType.NORMAL),
		new DEQuest(109, "With Even More Gratitude", QuestType.NORMAL),
		new DEQuest(110, "Legend of Mythical Empress", QuestType.NORMAL),
		new DEQuest(111, "A Flower for a Rose", QuestType.NORMAL),
		new DEQuest(112, "Battling Brutes", QuestType.NORMAL),
		new DEQuest(113, "Supplies for Satorl", QuestType.NORMAL),
		new DEQuest(114, "Monster Quest 1 - Part 1", QuestType.NORMAL),
		new DEQuest(115, "Monster Quest 1 - Part 2", QuestType.NORMAL),
		new DEQuest(116, "Monster Quest 1 - Part 3", QuestType.NORMAL),
		new DEQuest(117, "Monster Quest 1 - Part 4", QuestType.NORMAL),
		new DEQuest(118, "Monster Quest 2", QuestType.TIMED),
		new DEQuest(119, "Monster Quest 3 - Part 1", QuestType.TIMED),
		new DEQuest(120, "Monster Quest 3 - Part 2", QuestType.TIMED),
		new DEQuest(121, "Challenge 1 - Part 1", QuestType.TIMED),
		new DEQuest(122, "Challenge 1 - Part 2", QuestType.TIMED),
		new DEQuest(123, "Challenge 2 - Part 1", QuestType.TIMED),
		new DEQuest(124, "Challenge 2 - Part 2", QuestType.TIMED),
		new DEQuest(125, "Material Quest 1", QuestType.TIMED),
		new DEQuest(126, "Material Quest 2", QuestType.TIMED),
		new DEQuest(127, "Material Quest 3", QuestType.TIMED),
		new DEQuest(128, "Material Quest 4", QuestType.TIMED),
		new DEQuest(129, "Collection Quest 1", QuestType.TIMED),
		new DEQuest(130, "Collection Quest 2", QuestType.TIMED),
		new DEQuest(131, "Search Quest 1", QuestType.TIMED),
		new DEQuest(132, "Search Quest 2", QuestType.TIMED)
	};
	public static final DEQuest[] COLONY_6 = new DEQuest[]
	{
		new DEQuest(133, "The Road Home", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(134),
		new DEQuest(134, "To Colony 6!", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(133),
		new DEQuest(135, "Cook-Off Counter Attack!", QuestType.NORMAL),
		new DEQuest(136, "Cook-Off Comeback?", QuestType.NORMAL),
		new DEQuest(137, "Cook-Off Final Blow!", QuestType.NORMAL),
		new DEQuest(138, "Cook-Off Showdown!", QuestType.NORMAL),
		new DEQuest(139, "A Delectable Delicacy", QuestType.NORMAL),
		new DEQuest(140, "A Tantalising Treat", QuestType.NORMAL),
		new DEQuest(141, "Missing Lodger", QuestType.NORMAL),
		new DEQuest(142, "Looking for Freedom", QuestType.NORMAL),
		new DEQuest(143, "Cursed Berryjammy", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(144),
		new DEQuest(144, "Weak Berryjammy", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(143),
		new DEQuest(145, "Obstinate Berryjammy", QuestType.NORMAL),
		new DEQuest(146, "Unstoppable Berryjammy", QuestType.NORMAL),
		new DEQuest(147, "Miss Sweetness Showdown (Berryjammy)", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(148),
		new DEQuest(148, "Miss Sweetness Showdown (Ma'crish)", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(147),
		new DEQuest(149, "The Most Transparent Thing", QuestType.NORMAL),
		new DEQuest(150, "Miss Sweetness' Gratitude (Berryjammy)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(151),
		new DEQuest(151, "Miss Sweetness' Gratitude (Ma'crish)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(150),
		new DEQuest(152, "A Final Sweet Favour", QuestType.NORMAL),
		new DEQuest(153, "In Pursuit of Love", QuestType.NORMAL),
		new DEQuest(154, "The Melody of Happiness", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(155),
		new DEQuest(155, "Dream of a Poet", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(154),
		new DEQuest(156, "Family Secrets (Zel Argentis)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(157),
		new DEQuest(157, "Family Secrets (En Argentis)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(156),
		new DEQuest(158, "Betrothal Test (Zel Argentis)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(159),
		new DEQuest(159, "Betrothal Test (En Argentis)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(158),
		new DEQuest(160, "Stopping the Elopement (Zel Argentis)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(161),
		new DEQuest(161, "Stopping the Elopement (En Argentis)", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(160),
		new DEQuest(162, "A Butler's Concerns", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(163),
		new DEQuest(163, "A Maid's Concerns", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(162),
		new DEQuest(164, "Lifespan of a Machina", QuestType.NORMAL),
		new DEQuest(165, "A Poet's Concerns", QuestType.NORMAL),
		new DEQuest(166, "Delivering the Undeliverable", QuestType.NORMAL),
		new DEQuest(167, "Finding the Unfindable", QuestType.NORMAL),
		new DEQuest(168, "Odd Smoke - Investigation", QuestType.NORMAL),
		new DEQuest(169, "Odd Smoke - Resolution", QuestType.NORMAL),
		new DEQuest(170, "Homs Determination", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(171),
		new DEQuest(171, "Nopon Determination", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(170),
		new DEQuest(172, "A Gutsy Trader", QuestType.NORMAL),
		new DEQuest(173, "A Dauntless Trader", QuestType.NORMAL),
		new DEQuest(174, "Nic's Training", QuestType.NORMAL),
		new DEQuest(175, "Nic's Final Test", QuestType.NORMAL),
		new DEQuest(176, "What is Love?!", QuestType.NORMAL),
		new DEQuest(177, "What is Courage?!", QuestType.NORMAL),
		new DEQuest(178, "Matryona's Answer", QuestType.NORMAL),
		new DEQuest(179, "A Selfish Girl's Mistake", QuestType.NORMAL),
		new DEQuest(180, "Chemist's Reopening", QuestType.NORMAL),
		new DEQuest(181, "Satata's Younger Brother", QuestType.NORMAL),
		new DEQuest(182, "Rest in Peace", QuestType.NORMAL),
		new DEQuest(183, "For the Restoration", QuestType.TIMED),
		new DEQuest(184, "Making a New Path", QuestType.TIMED),
		new DEQuest(185, "Securing Provisions", QuestType.NORMAL),
		new DEQuest(186, "Proof of Status", QuestType.NORMAL),
		new DEQuest(187, "Safety First", QuestType.NORMAL),
		new DEQuest(188, "Secret Mission", QuestType.NORMAL),
		new DEQuest(189, "Replica Monado 1", QuestType.NORMAL),
		new DEQuest(190, "Replica Monado 2", QuestType.NORMAL),
		new DEQuest(191, "Replica Monado 3", QuestType.NORMAL),
		new DEQuest(192, "Replica Monado 4", QuestType.NORMAL),
		new DEQuest(193, "Replica Monado 5", QuestType.NORMAL),
		new DEQuest(194, "Melancholy Tyrea", QuestType.SURPRISE),
		new DEQuest(195, "Defend Colony 6 - Mechon", QuestType.NORMAL),
		new DEQuest(196, "Defend Colony 6 - Reptile", QuestType.NORMAL),
		new DEQuest(197, "Defend Colony 6 - Elite", QuestType.NORMAL),
		new DEQuest(198, "Defend Colony 6 - Ancient", QuestType.NORMAL),
		new DEQuest(199, "Defend Colony 6 - Demon", QuestType.NORMAL)
	};
	public static final DEQuest[] SATORL_MARSH = new DEQuest[]
	{
		new DEQuest(200, "Preventing Starvation", QuestType.NORMAL),
		new DEQuest(201, "Zazadan in Danger", QuestType.NORMAL),
		new DEQuest(202, "Zazadan Still in Danger", QuestType.NORMAL),
		new DEQuest(203, "It's All in the Mind", QuestType.NORMAL),
		new DEQuest(204, "A Mysterious Delicacy", QuestType.NORMAL),
		new DEQuest(205, "A Gift?", QuestType.TIMED),
		new DEQuest(206, "Gather Information", QuestType.SURPRISE),
		new DEQuest(207, "Kacha's Kidnapping", QuestType.NORMAL),
		new DEQuest(208, "The Giants' Key", QuestType.NORMAL),
		new DEQuest(209, "The Giants' Treasure", QuestType.NORMAL),
		new DEQuest(210, "Making Camp", QuestType.NORMAL),
		new DEQuest(211, "Monster Quest 1", QuestType.NORMAL),
		new DEQuest(212, "Monster Quest 2", QuestType.NORMAL),
		new DEQuest(213, "Monster Quest 3", QuestType.NORMAL),
		new DEQuest(214, "Monster Quest 4", QuestType.NORMAL),
		new DEQuest(215, "Challenge", QuestType.NORMAL),
		new DEQuest(216, "For a Friend", QuestType.NORMAL),
		new DEQuest(217, "A Merciful End", QuestType.NORMAL),
		new DEQuest(218, "A Release From Duty", QuestType.NORMAL),
		new DEQuest(219, "The Imperial Ceremony", QuestType.NORMAL),
		new DEQuest(220, "Imperial Ceremony Offerings", QuestType.NORMAL),
		new DEQuest(221, "The Ancient Ceremony", QuestType.STORY),
		new DEQuest(222, "Ancient Ceremony Offerings", QuestType.STORY)
	};
	public static final DEQuest[] MAKNA_FOREST = new DEQuest[]
	{
		new DEQuest(223, "Legend of the Sage", QuestType.NORMAL),
		new DEQuest(224, "Challenge of the Sage", QuestType.NORMAL),
		new DEQuest(225, "Final Challenge of the Sage", QuestType.NORMAL),
		new DEQuest(226, "Bridge Repair", QuestType.NORMAL),
		new DEQuest(227, "Monster Quest 1", QuestType.NORMAL),
		new DEQuest(228, "Monster Quest 2", QuestType.NORMAL),
		new DEQuest(229, "Monster Quest 3", QuestType.NORMAL),
		new DEQuest(230, "Monster Quest 4", QuestType.NORMAL),
		new DEQuest(231, "Challenge", QuestType.NORMAL),
		new DEQuest(232, "Mystery Girl Rescue", QuestType.STORY)
	};
	public static final DEQuest[] FRONTIER_VILLAGE = new DEQuest[]
	{
		new DEQuest(233, "Leku's Food Crisis", QuestType.NORMAL),
		new DEQuest(234, "Hunt for a Patron", QuestType.NORMAL),
		new DEQuest(235, "Heropon's Spirit", QuestType.NORMAL),
		new DEQuest(236, "Beat Kilaki to it!", QuestType.NORMAL),
		new DEQuest(237, "Lousy Lizards", QuestType.NORMAL),
		new DEQuest(238, "Popularity Premonition", QuestType.NORMAL),
		new DEQuest(239, "Making a Mixer", QuestType.NORMAL),
		new DEQuest(240, "Materials for a Mixer", QuestType.NORMAL),
		new DEQuest(241, "Decoration Makeover", QuestType.NORMAL),
		new DEQuest(242, "Hunt for a Bug-Loving Friend", QuestType.NORMAL),
		new DEQuest(243, "A Worried Bug-Lover", QuestType.NORMAL),
		new DEQuest(244, "A Tormented Bug-Lover", QuestType.NORMAL),
		new DEQuest(245, "Mushy Mushrooms", QuestType.NORMAL),
		new DEQuest(246, "Medical Advancements", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(247),
		new DEQuest(247, "Let's Make Fillings!", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(246),
		new DEQuest(248, "World's Strongest Flavour", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(249),
		new DEQuest(249, "Reversed Tastes", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(248),
		new DEQuest(250, "Sweet Seduction", QuestType.NORMAL),
		new DEQuest(251, "Ingredients For A Brew", QuestType.NORMAL),
		new DEQuest(252, "Healing the Healer", QuestType.NORMAL),
		new DEQuest(253, "Legendary Nopon Charm", QuestType.NORMAL),
		new DEQuest(254, "Mislabelling Problem", QuestType.NORMAL),
		new DEQuest(255, "Getting Bigger!", QuestType.NORMAL),
		new DEQuest(256, "Who is Bigger?", QuestType.NORMAL),
		new DEQuest(257, "Strange Noises from Below", QuestType.NORMAL),
		new DEQuest(258, "Musical Genius", QuestType.NORMAL),
		new DEQuest(259, "Things that Hum", QuestType.NORMAL),
		new DEQuest(260, "Things that Rumble", QuestType.NORMAL),
		new DEQuest(261, "Disinsectization", QuestType.NORMAL),
		new DEQuest(262, "Avenge a Mamapon's Death", QuestType.NORMAL),
		new DEQuest(263, "Dadapon in Trouble", QuestType.NORMAL),
		new DEQuest(264, "It Definitely Exist!", QuestType.NORMAL),
		new DEQuest(265, "Even In The Chief's Absence", QuestType.NORMAL),
		new DEQuest(266, "Bored Pelupelu", QuestType.NORMAL),
		new DEQuest(267, "A Gift For Miko", QuestType.NORMAL),
		new DEQuest(268, "Giant Attack!", QuestType.NORMAL),
		new DEQuest(269, "Kind Lupa's Grampypon", QuestType.NORMAL),
		new DEQuest(270, "Secret Elixer Ingredients", QuestType.NORMAL),
		new DEQuest(271, "Mystery of Makna Ruins 1", QuestType.NORMAL),
		new DEQuest(272, "Mystery of Makna Ruins 2", QuestType.NORMAL),
		new DEQuest(273, "Mystery of Makna Ruins 3", QuestType.NORMAL),
		new DEQuest(274, "Mystery of Makna Ruins 4", QuestType.NORMAL),
		new DEQuest(275, "Honouring the Nopon Sage", QuestType.NORMAL),
		new DEQuest(276, "Meeting the Nopon Sage", QuestType.NORMAL),
		new DEQuest(277, "Fixing Time Mushrooms", QuestType.NORMAL),
		new DEQuest(278, "Restoring the Capital", QuestType.NORMAL),
		new DEQuest(279, "Restoring the Capital 2", QuestType.NORMAL),
		new DEQuest(280, "Broken Ether Furnace", QuestType.NORMAL),
		new DEQuest(281, "Broken Ether Furnace 2", QuestType.NORMAL),
		new DEQuest(282, "A Memento of Daddy", QuestType.NORMAL),
		new DEQuest(283, "Pollen Orb Ingredients", QuestType.NORMAL),
		new DEQuest(284, "Secret Ingredient Hut", QuestType.NORMAL),
		new DEQuest(285, "Secret Innovation", QuestType.NORMAL),
		new DEQuest(286, "The Master's Successor", QuestType.NORMAL),
		new DEQuest(287, "Dangerous Ambition", QuestType.TIMED),
		new DEQuest(288, "Find the Kingpin", QuestType.TIMED),
		new DEQuest(289, "Adviser Hunt", QuestType.TIMED),
		new DEQuest(290, "Evidence Collection", QuestType.TIMED),
		new DEQuest(291, "Destroying the City Trade", QuestType.TIMED),
		new DEQuest(292, "Bana the Betrayer", QuestType.NORMAL),
		new DEQuest(293, "Presents for Priceless Pupils", QuestType.NORMAL),
		new DEQuest(294,"Safer Energy", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(295),
		new DEQuest(295, "Distilling Active Ingredients", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(294),
		new DEQuest(296, "Monster Quest 1 - Part 1", QuestType.NORMAL),
		new DEQuest(297, "Monster Quest 1 - Part 2", QuestType.NORMAL),
		new DEQuest(298, "Monster Quest 1 - Part 3", QuestType.NORMAL),
		new DEQuest(299, "Monster Quest 2 - Part 1", QuestType.NORMAL),
		new DEQuest(300, "Monster Quest 2 - Part 2", QuestType.NORMAL),
		new DEQuest(301, "Monster Quest 2 - Part 3", QuestType.NORMAL),
		new DEQuest(302, "Challenge 1", QuestType.NORMAL),
		new DEQuest(303, "Challenge 2", QuestType.NORMAL),
		new DEQuest(304, "Challenge 3", QuestType.NORMAL),
		new DEQuest(305, "Material Quest 1", QuestType.NORMAL),
		new DEQuest(306, "Material Quest 2", QuestType.NORMAL),
		new DEQuest(307, "Material Quest 3", QuestType.NORMAL),
		new DEQuest(308, "Material Quest 4", QuestType.NORMAL),
		new DEQuest(309, "Collection Quest 1", QuestType.NORMAL),
		new DEQuest(310, "Collection Quest 2", QuestType.NORMAL),
		new DEQuest(311, "Collection Quest 3", QuestType.NORMAL),
		new DEQuest(312, "Collection Quest 4", QuestType.NORMAL),
		new DEQuest(313, "Search Quest 1", QuestType.NORMAL),
		new DEQuest(314, "Search Quest 2", QuestType.NORMAL),
		new DEQuest(315, "Search Quest 3", QuestType.NORMAL),
		new DEQuest(316, "An Errand for the Heropon", QuestType.STORY)
	};
	public static final DEQuest[] ERYTH_SEA = new DEQuest[]
	{
		new DEQuest(317, "Trouble at the Plant", QuestType.NORMAL),
		new DEQuest(318, "Punish the Hodes", QuestType.NORMAL),
		new DEQuest(319, "Mend the Plant", QuestType.NORMAL),
		new DEQuest(320, "Hode Attack", QuestType.NORMAL),
		new DEQuest(321, "Trouble at the Lighthouse", QuestType.NORMAL),
		new DEQuest(322, "Investigating Satorl", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(338),
		new DEQuest(323, "Ancient High Entia Mystery", QuestType.NORMAL),
		new DEQuest(324, "The Missing Boy", QuestType.NORMAL),
		new DEQuest(325, "The Only Thing I Can Do", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(326),
		new DEQuest(326, "I Will Never Forget You", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(325),
		new DEQuest(327, "Secret Research", QuestType.NORMAL),
		new DEQuest(328, "Monster Quest 1", QuestType.NORMAL),
		new DEQuest(329, "Monster Quest 2", QuestType.NORMAL),
		new DEQuest(330, "Challenge", QuestType.NORMAL),
		new DEQuest(331, "Collection Quest 1", QuestType.NORMAL),
		new DEQuest(332, "Collection Quest 2", QuestType.NORMAL),
		new DEQuest(333, "Save the Worker", QuestType.STORY),
		new DEQuest(334, "Path to Prison Island", QuestType.STORY),
		new DEQuest(335, "Sister Seals", QuestType.STORY)
	};
	public static final DEQuest[] ALCAMOTH = new DEQuest[]
	{
		new DEQuest(336, "The Deciphering Machine", QuestType.TIMED),
		new DEQuest(337, "A Necessary Upgrade", QuestType.TIMED),
		new DEQuest(338, "Talia's Research", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(322),
		new DEQuest(339, "Bring Back My Son!", QuestType.TIMED),
		new DEQuest(340, "Teaching Materials", QuestType.TIMED),
		new DEQuest(341, "Brave Actions", QuestType.TIMED),
		new DEQuest(342, "Protect the Capital!", QuestType.TIMED),
		new DEQuest(343, "How Do They Feel?", QuestType.TIMED),
		new DEQuest(344, "How Do I Feel?", QuestType.TIMED),
		new DEQuest(345, "I Love You No Matter What", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(346),
		new DEQuest(346, "Together Forever", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(345),
		new DEQuest(347, "A Friend in Need", QuestType.TIMED),
		new DEQuest(348, "Preparing For Adventure", QuestType.TIMED),
		new DEQuest(349, "Preparing For Adventure 2", QuestType.TIMED),
		new DEQuest(350, "Preparing For Adventure 3", QuestType.TIMED),
		new DEQuest(351, "Adventurers in Peril", QuestType.TIMED, QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(398),
		new DEQuest(352, "Building Bridges", QuestType.TIMED),
		new DEQuest(353, "Believing Again", QuestType.TIMED),
		new DEQuest(354, "Starlight Seeker", QuestType.TIMED),
		new DEQuest(355, "Starlight Gazer", QuestType.TIMED),
		new DEQuest(356, "Back Pain", QuestType.TIMED),
		new DEQuest(357, "Looking for Gold Bugs", QuestType.TIMED),
		new DEQuest(358, "Losing the Taste of Alcohol", QuestType.TIMED),
		new DEQuest(359, "Looking for a Lost Son", QuestType.TIMED),
		new DEQuest(360, "Looking for a Lost Daughter", QuestType.TIMED),
		new DEQuest(361, "Going Out to Play", QuestType.TIMED),
		new DEQuest(362, "Getting a Member's Card", QuestType.TIMED),
		new DEQuest(363, "Vidian Rescue Mission", QuestType.SURPRISE),
		new DEQuest(364, "Monster Quest 1 - Part 1", QuestType.TIMED),
		new DEQuest(365, "Monster Quest 1 - Part 2", QuestType.TIMED),
		new DEQuest(366, "Monster Quest 1 - Part 3", QuestType.TIMED),
		new DEQuest(367, "Monster Quest 2 - Part 1", QuestType.TIMED),
		new DEQuest(368, "Monster Quest 2 - Part 2", QuestType.TIMED),
		new DEQuest(369, "Monster Quest 2 - Part 3", QuestType.TIMED),
		new DEQuest(370, "Monster Quest 3 - Part 1", QuestType.TIMED),
		new DEQuest(371, "Monster Quest 3 - Part 2", QuestType.TIMED),
		new DEQuest(372, "Monster Quest 3 - Part 3", QuestType.TIMED),
		new DEQuest(373, "Monster Quest 4 - Part 1", QuestType.TIMED),
		new DEQuest(374, "Monster Quest 4 - Part 2", QuestType.TIMED),
		new DEQuest(375, "Monster Quest 4 - Part 3", QuestType.TIMED),
		new DEQuest(376, "Challenge 1", QuestType.TIMED),
		new DEQuest(377, "Challenge 2", QuestType.TIMED),
		new DEQuest(378, "Challenge 3", QuestType.TIMED),
		new DEQuest(379, "Challenge 4", QuestType.TIMED),
		new DEQuest(380, "Material Quest 1", QuestType.TIMED),
		new DEQuest(381, "Material Quest 2", QuestType.TIMED),
		new DEQuest(382, "Material Quest 3", QuestType.TIMED),
		new DEQuest(383, "Material Quest 4", QuestType.TIMED),
		new DEQuest(384, "Collection Quest 1", QuestType.TIMED),
		new DEQuest(385, "Collection Quest 2", QuestType.TIMED),
		new DEQuest(386, "Collection Quest 3", QuestType.TIMED),
		new DEQuest(387, "Collection Quest 4", QuestType.TIMED),
		new DEQuest(388, "Search Quest 1", QuestType.TIMED),
		new DEQuest(389, "Search Quest 2", QuestType.TIMED),
		new DEQuest(390, "Search Quest 3", QuestType.TIMED),
		new DEQuest(391, "Search Quest 4", QuestType.TIMED)
	};
	public static final DEQuest[] VALAK_MOUNTAIN = new DEQuest[]
	{
		new DEQuest(392, "Chilkins and Antols", QuestType.NORMAL),
		new DEQuest(393, "Valak Mountain Research", QuestType.NORMAL),
		new DEQuest(394, "The Freezing Nopon", QuestType.NORMAL),
		new DEQuest(395, "Bad Timing", QuestType.NORMAL),
		new DEQuest(396, "Chilkin Changes", QuestType.NORMAL),
		new DEQuest(397, "The Balance of Power", QuestType.NORMAL),
		new DEQuest(398, "The Missing Partner", QuestType.MUTUALLY_EXCLUSIVE).setMutualQuest(351),
		new DEQuest(399, "The Final Giants' Ruins", QuestType.NORMAL),
		new DEQuest(400, "The Giants' Treasures", QuestType.NORMAL),
		new DEQuest(401, "Monster Quest 1", QuestType.NORMAL),
		new DEQuest(402, "Monster Quest 2", QuestType.NORMAL),
		new DEQuest(403, "Monster Quest 3", QuestType.NORMAL),
		new DEQuest(404, "Monster Quest 4", QuestType.NORMAL),
		new DEQuest(405, "The Magma Rock", QuestType.STORY)
	};
	public static final DEQuest[] SWORD_VALLEY = new DEQuest[]
	{
		new DEQuest(406, "Secure Dolgan Outpost", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(407, "Secure Enalda Control Base", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(408, "3rd Gate Front Line", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(409, "Secure the Radio Tower", QuestType.TIMED, QuestType.SURPRISE)
	};
	public static final DEQuest[] GALAHAD_FORTRESS = new DEQuest[]
	{
		new DEQuest(410, "Lift Battle", QuestType.STORY),
		new DEQuest(411, "Supply Station Battle", QuestType.STORY),
		new DEQuest(412, "Turbine Battle", QuestType.STORY),
		new DEQuest(413, "Fiora's Conviction", QuestType.STORY)
	};
	public static final DEQuest[] FALLEN_ARM = new DEQuest[]
	{
		new DEQuest(414, "Save the Machina!", QuestType.NORMAL),
		new DEQuest(415, "Eliminate the Threat!", QuestType.NORMAL),
		new DEQuest(416, "Mysterious Noises!", QuestType.NORMAL),
		new DEQuest(417, "Protect the Village", QuestType.NORMAL),
		new DEQuest(418, "Stop the Mechon Rampage!", QuestType.NORMAL),
		new DEQuest(419, "Stunted Growth", QuestType.NORMAL),
		new DEQuest(420, "Transmission Bypass", QuestType.NORMAL),
		new DEQuest(421, "The Exhaust Pump", QuestType.NORMAL),
		new DEQuest(422, "The Mini Reactor", QuestType.NORMAL),
		new DEQuest(423, "The History of Mechonis", QuestType.TIMED),
		new DEQuest(424, "The History of the Capital", QuestType.TIMED),
		new DEQuest(425, "I Want to be a Homs!", QuestType.NORMAL),
		new DEQuest(426, "Powerless", QuestType.NORMAL),
		new DEQuest(427, "Power Up!", QuestType.NORMAL),
		new DEQuest(428, "Fixing a Broken Door", QuestType.NORMAL),
		new DEQuest(429, "The Wilted Flower", QuestType.NORMAL),
		new DEQuest(430, "The Oath Sword", QuestType.NORMAL),
		new DEQuest(431, "Scheduled Inspection!", QuestType.NORMAL),
		new DEQuest(432, "A Tough Battle", QuestType.NORMAL),
		new DEQuest(433, "A Weapon Just For Me", QuestType.TIMED),
		new DEQuest(434, "Therapy", QuestType.NORMAL),
		new DEQuest(435, "Mending Memories", QuestType.NORMAL),
		new DEQuest(436, "Resolution - Father", QuestType.NORMAL),
		new DEQuest(437, "Resolution - Mother", QuestType.NORMAL),
		new DEQuest(438, "Food Delivery", QuestType.NORMAL),
		new DEQuest(439, "For My Loved One...", QuestType.TIMED),
		new DEQuest(440, "To My Loved One...", QuestType.TIMED),
		new DEQuest(441, "Reunion with Fiora", QuestType.STORY),
		new DEQuest(442, "We Made It", QuestType.STORY),
		new DEQuest(443, "Fiora's Treatment", QuestType.STORY)
	};
	public static final DEQuest[] MECHONIS_FIELD = new DEQuest[]
	{
		new DEQuest(444, "Best Boots", QuestType.TIMED),
		new DEQuest(445, "Monster Quest", QuestType.TIMED),
		new DEQuest(446, "Challenge Quest 1", QuestType.TIMED),
		new DEQuest(447, "Challenge Quest 2", QuestType.TIMED),
		new DEQuest(448, "Aiming for the Top", QuestType.STORY),
		new DEQuest(449, "Get the 3rd Lift Moving", QuestType.STORY),
		new DEQuest(450, "Opening the Bulkhead", QuestType.STORY),
		new DEQuest(451, "The High-Velocity Lift", QuestType.STORY),
		new DEQuest(452, "Need Power!", QuestType.STORY)
	};
	public static final DEQuest[] CENTRAL_FACTORY = new DEQuest[]
	{
		new DEQuest(453, "Eliminate the Backup!", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(454, "Daring Assault", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(455, "Roof Battle", QuestType.TIMED, QuestType.SURPRISE),
		new DEQuest(456, "New Weapon for Fiora", QuestType.TIMED),
		new DEQuest(457, "To the Central Tower", QuestType.STORY),
		new DEQuest(458, "Maintenence Wing Escape", QuestType.STORY),
		new DEQuest(459, "Find a Path to the Top", QuestType.STORY),
		new DEQuest(460, "Materials for a Bomb", QuestType.STORY),
		new DEQuest(461, "The Central Tower Barrier", QuestType.STORY)
	};
	public static final DEQuest[] AGNIRATHA = new DEQuest[]
	{
		new DEQuest(462, "Civil Protection 1-1", QuestType.TIMED),
		new DEQuest(463, "Civil Protection 1-2", QuestType.TIMED),
		new DEQuest(464, "Civil Protection 1-3", QuestType.TIMED),
		new DEQuest(465, "Civil Protection 2-1", QuestType.TIMED),
		new DEQuest(466, "Civil Protection 2-2", QuestType.TIMED),
		new DEQuest(467, "Civil Protection 2-3", QuestType.TIMED),
		new DEQuest(468, "Military Status 1-1", QuestType.TIMED),
		new DEQuest(469, "Military Status 1-2", QuestType.TIMED),
		new DEQuest(470, "Military Status 2-1", QuestType.TIMED),
		new DEQuest(471, "Military Status 2-2", QuestType.TIMED),
		new DEQuest(472, "Agniratha Beautification 1", QuestType.TIMED),
		new DEQuest(473, "Agniratha Beautification 2", QuestType.TIMED),
		new DEQuest(474, "Telethia Investigation 1", QuestType.TIMED),
		new DEQuest(475, "Telethia Investigation 2", QuestType.TIMED),
		new DEQuest(476, "Shrine Transport", QuestType.STORY),
		new DEQuest(477, "Pillar Verification Devices", QuestType.STORY),
		new DEQuest(478, "Save Bionis", QuestType.STORY)
	};
	public static final DEQuest[] PRISON_ISLAND = new DEQuest[]
	{
		new DEQuest(479, "Chase Dickson", QuestType.STORY),
		new DEQuest(480, "Path to the Top", QuestType.STORY)
	};
	public static final DEQuest[] ALL_QUESTS = Stream.of(COLONY_9, TEPHRA_CAVE, BIONIS_LEG, COLONY_6,
			SATORL_MARSH, MAKNA_FOREST, FRONTIER_VILLAGE, ERYTH_SEA, ALCAMOTH, VALAK_MOUNTAIN, SWORD_VALLEY,
			GALAHAD_FORTRESS, FALLEN_ARM, MECHONIS_FIELD, CENTRAL_FACTORY, AGNIRATHA, PRISON_ISLAND).flatMap(Arrays::stream).toArray(DEQuest[]::new);
	private static final Map<DELocation, DEQuest[]> locationMapping = new HashMap<DELocation, DEQuest[]>();

	static
	{
		locationMapping.put(DELocation.COLONY_9, COLONY_9);
		locationMapping.put(DELocation.TEPHRA_CAVE, TEPHRA_CAVE);
		locationMapping.put(DELocation.BIONIS_LEG, BIONIS_LEG);
		locationMapping.put(DELocation.COLONY_6, COLONY_6);
		locationMapping.put(DELocation.SATORL_MARSH, SATORL_MARSH);
		locationMapping.put(DELocation.MAKNA_FOREST, MAKNA_FOREST);
		locationMapping.put(DELocation.FRONTIER_VILLAGE, FRONTIER_VILLAGE);
		locationMapping.put(DELocation.ERYTH_SEA, ERYTH_SEA);
		locationMapping.put(DELocation.ALCAMOTH, ALCAMOTH);
		locationMapping.put(DELocation.VALAK_MOUNTAIN, VALAK_MOUNTAIN);
		locationMapping.put(DELocation.SWORD_VALLEY, SWORD_VALLEY);
		locationMapping.put(DELocation.GALAHAD_FORTRESS, GALAHAD_FORTRESS);
		locationMapping.put(DELocation.FALLEN_ARM, FALLEN_ARM);
		locationMapping.put(DELocation.MECHONIS_FIELD, MECHONIS_FIELD);
		locationMapping.put(DELocation.CENTRAL_FACTORY, CENTRAL_FACTORY);
		locationMapping.put(DELocation.AGNIRATHA, AGNIRATHA);
		locationMapping.put(DELocation.PRISON_ISLAND, PRISON_ISLAND);

		for (int i = 0; i < ALL_QUESTS.length; ++i)
		{
			try
			{
				String s = "";
				var list = getQuestsWithID(i + 1);

				for (int j = 0; j < list.size() - 1; ++j)
				{
					s += list.get(j).name + ", ";
				}
				
				s += list.get(list.size() - 1).name;

				if (list.size() > 1)
					throw new ExceptionInInitializerError("Found more than one quest with the same ID! " + s);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private static List<DEQuest> getQuestsWithID(int id)
	{
		return Arrays.asList(ALL_QUESTS).stream().filter(q -> q.uniqueID == id).collect(Collectors.toList());
	}

	public static DEQuest getQuestFromID(int id)
	{
		return getQuestsWithID(id).get(0);
	}

	public static DEQuest getQuestFromNameByLocation(DELocation location, String name)
	{
		DEQuest[] quests = locationMapping.get(location);
		Optional<DEQuest> quest = get(quests, name);

		if (quest.isEmpty())
			return null;

		return quest.get();
	}

	public static DEQuest[] getQuestArray(DELocation location)
	{
		return locationMapping.get(location);
	}

	public static DELocation getLocationFromQuest(DEQuest quest)
	{
		for (Entry<DELocation, DEQuest[]> entry : locationMapping.entrySet())
		{
			for (DEQuest q : entry.getValue())
			{
				if (q.equals(quest))
					return entry.getKey();
			}
		}

		return DELocation.OTHER;
	}

	private static Optional<DEQuest> get(DEQuest[] quests, String name)
	{
		for (DEQuest q : quests)
		{
			if (q.getName().equalsIgnoreCase(name))
				return Optional.<DEQuest> of(q);
		}

		return Optional.<DEQuest> empty();
	}

	private DEQuests() {}

	public static class DEQuest
	{
		final int uniqueID;
		final String name;
		final String giver;
		final String[] rewards;
		final QuestType[] questTypes;
		int mutualQuest;
		boolean isCompleted;

		public DEQuest(int uniqueID, String name, String giver, String[] rewards, QuestType... types)
		{
			this.uniqueID = uniqueID;
			this.name = name;
			this.giver = giver;
			this.rewards = rewards;
			this.questTypes = types;
		}

		public DEQuest(int uniqueID, String name, QuestType... types)
		{
			this(uniqueID, name, "", new String[] {""}, types);
		}

		public int getUniqueID()
		{
			return this.uniqueID;
		}

		public String getName()
		{
			return this.name;
		}

		public String getGiver()
		{
			return this.giver;
		}

		public String[] getRewards()
		{
			return this.rewards;
		}

		public Color getColour()
		{
			if (this.questTypes.length > 1)
			{
				Color color = Color.WHITE;
				var types = Arrays.asList(this.questTypes);

				if (types.contains(QuestType.TIMED))
				{
					if (types.contains(QuestType.MUTUALLY_EXCLUSIVE))
						color = new Color(10, 208, 200);
					else if (types.contains(QuestType.SURPRISE))
						color = new Color(150, 255, 150);
				}

				return color;
			}

			return this.questTypes[0].backgroundColour;
		}

		public Font getFont()
		{
			return this.questTypes[0].fontType;
		}

		public boolean isMutual()
		{
			for (QuestType type : questTypes)
			{
				if (type == QuestType.MUTUALLY_EXCLUSIVE)
					return true;
			}

			return false;
		}

		public int getMutualQuest()
		{
			return this.mutualQuest;
		}

		protected DEQuest setMutualQuest(int id)
		{
			if (id == this.uniqueID)
				System.err.println("Set mutual ID to itself, this may cause problems! ID: " + id);

			this.mutualQuest = id;
			return this;
		}

		public QuestType[] getTypes()
		{
			return questTypes;
		}

		@Override
		public String toString()
		{
			return this.getName();
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 5;
			result = prime * result + uniqueID;
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

			DEQuest other = (DEQuest) obj;

			if (this.uniqueID != other.uniqueID)
				return false;

			return true;
		}
	}

	public static enum QuestType
	{
		NORMAL("Side Quest", new Color(117, 149, 201)),
		STORY("Story", new Color(45, 96, 179)),
		TIMED("Timed", new Color(0, 128, 10)),
		MUTUALLY_EXCLUSIVE("Mutually Exclusive", new Color(110, 72, 171)),
		SURPRISE("Surprise", new Color(150, 200, 0));
		String typeName;
		Color backgroundColour;
		Font fontType;

		private QuestType(String type, Color backgroundColour)
		{
			this(type, backgroundColour, new Font("Times New Roman", Font.PLAIN, 16));
		}

		private QuestType(String type, Color backgroundColour, Font font)
		{
			this.typeName = type;
			this.backgroundColour = backgroundColour;
			this.fontType = font;
		}

		public String getName()
		{
			return this.typeName;
		}
	}
}