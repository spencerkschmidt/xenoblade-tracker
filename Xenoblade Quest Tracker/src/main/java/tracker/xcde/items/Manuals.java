package tracker.xcde.items;

import java.util.Arrays;
import java.util.stream.Stream;

public class Manuals
{
	public static final Manual[] ADVANCED_MANUALS = new Manual[]
	{
		// Shulk's Manuals
		new Manual(ManualType.ADVANCED, "Slit Edge", "Shulk", new String[] {"Despotic Arsene (8.1%)", "Indomitable Daulton (5%)", "Magnis Ardun (5%)", "Panasowa Arachno (4.7%)", "Sonicia Gogol (4.7%)", "Caura Balgas (1.9%)", "M37/EAGER (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Back Slash", "Shulk", new String[] {"Final Marcus (7.3%)", "Veteran Yozel (5%)", "Mystical Klesida (2.1%)", "General Arachno (5%)", "Vilae Arachno (4.7%)", "M55/DREAD (1.9%)", "Uragano Nebula (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Light Heal", "Shulk", new String[] {"Flailing Bracken (8.8%)", "Vagabond Allocer (4.1%)", "Veteran Yozel (2.3%)", "Carbon Tude (8.8%)", "Throne Sardi (8.8%)", "Offensive/FOUND (3.1%)", "General Arachno (2.3%)", "Vilae Arachno (2.1%)", "M55/DREAD (0.9%)", "Uragano Nebula (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Shaker Edge", "Shulk", new String[] {"Canyon Valencia (14%)", "Arel Telethia (13%)", "Femuny Wisp (13%)", "Jada Arachno (13%)", "Babeli Barg (5.4%)"}),
		new Manual(ManualType.ADVANCED, "Air Slash", "Shulk", new String[] {"Territorial Rotbart (14%)", "North Star Gusion (4.1%)", "Mild Florence (3.6%)", "Banquet Vassago (2.2%)", "Hidden Gamigin (2.2%)", "Admiral Arachno (14%)", "Rhoen Quadwing (13%)", "Defensive/SHAME  (5.4%)", "Fiume Nebula (5.4%)", "M97/CYCLE (5.4%)", "Offensive/HONEY (3.7%)", "Offensive/SCOUT (3.7%)", "M55/GRACE (2.5%)", "Aura Antol (2.4%)", "Rius Antol (2.4%)", "M87 Prototype (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Shadow Eye", "Shulk", new String[] {"Avalanche Abaasy (7.7%)", "Bizarre Ragoel (4.7%)", "Victorious Gross (2.1%)", "Gluttony Gogol (5%)", "Sloth Gogol (5%)", "M56/UNION (1.9%)", "Sanjibal Behemoth (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Battle Soul", "Shulk", new String[] {"Musical Vanflare (8.1%)", "Sentimental Flamral (4.1%)", "Bizarre Ragoel (2.1%)", "Eryth Rhana (8.8%)", "Opulent Flamii (8.8%)", "Young Brog (8.8%)", "M88/WORST (3.1%)", "Sloth Gogol (2.3%)", "M56/UNION (0.9%)", "Sanjibal Behemoth (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Stream Edge", "Shulk", new String[] {"Judicious Bunnitzol (8.8%)", "Experienced Tristan (4.1%)", "Powerful Eligos (2.5%)", "Evil Bathin (0.9%)", "Goldi Kromar (8.8%)", "Tored Ageshu (3.6%)", "M67/SONAR (3.1%)", "Tempest Vang (2.3%)", "M37/WITCH (1.3%)", "M67/RADAR (0.9%)", "Chimai Selua (0.7%)"}),
		// Reyn's Manuals
		new Manual(ManualType.ADVANCED, "Hammer Beat", "Reyn", new String[] {"Blizzard Belgazas (7.3%)", "Powerful Eligos (5.4%)", "Officer Robusto (2.1%)", "Satorl Rhogul (5%)", "Tempest Vang (5%)", "M67/RADAR (1.9%)", "Chimai Selua (1.5%)"}),
		new Manual(ManualType.ADVANCED, "Wild Down", "Reyn", new String[] {"Ancient Daedala (8.1%)", "Vivid Anstan (5.7%)", "Exposure Wolfol (1.8%)", "Baelfael Gogol (5%)", "Royal Caterpile (5%)", "Gigas Telethia (2.7%)"}),
		new Manual(ManualType.ADVANCED, "Guard Shift (R)", "Reyn", new String[] {"Field Altrich (14%)", "Magestic Mordred (3.6%)", "Prosperous Zepar (2.4%)", "Moonlight Paimon (2.2%)", "Vague Barbas (2.2%)", "Banquet Vassago (0.8%)", "Pandora Pod (14%)", "Aora Telethia (13%)", "Jadals Arachno (13%)", "Licorne Telethia (7.6%)", "M36/SACRE (5.4%)", "M91/DOGMA (3.7%)", "M53/THANK (3.1%)", "Happiness Flier (2.4%)", "M85 Meteor Artillery (1.6%)", "Scout Unit Prototype (1.6%)", "Offensive/SCOUT (1.3%)", "Rius Antol (0.9%)"}),
		new Manual(ManualType.ADVANCED, "War Swing", "Reyn", new String[] {"Mysterious Barnaby (9.4%)", "Meditative Varla (4.1%)", "Soothed Aglovale (4.1%)", "Reckless Zanden (2.1%)", "Lahar Flamii (9.4%)", "Zeldi Kromar (8.8%)", "Gimran Egel (3.6%)", "M68/MARCH (3.1%)", "M96/AWAKE (3.1%)", "Royal Caterpile (2.3%)", "Gigas Telethia (1.2%)", "M67/REALM (.9%)"}),
		new Manual(ManualType.ADVANCED, "Sword Drive", "Reyn", new String[] {"Reckless Galdon (8.8%)", "Wrathful Orobas (4.1%)", "Immovable Gonzalez (2.3%)", "Dark Hox (9.4%)", "Trava Kromar (8.8%)", "Babel Deinos (3.6%)", "Defensive/GUARD (3.1%)", "Setor Eks (2.7%)", "Last Rhogul (2.3%)", "M67/HASTE (0.9%)", "Wool Selua (0.7%)"}),
		new Manual(ManualType.ADVANCED, "Berserker", "Reyn", new String[] {"Ghostly Mahatos (5.7%)", "Wicked Sallos (5.4%)", "Immovable Gonzalez (5%)", "Setor Eks (5.9%)", "Asha Telethia (5%)", "Last Rhogul (5%)", "M67/HASTE (1.9%)", "M67/REALM (1.9%)", "Wool Selua (1.5%)"}),
		new Manual(ManualType.ADVANCED, "Shield Bash", "Reyn", new String[] {"Active Impulso (5.7%)", "Eternal Palsadia (5%)", "Feltl Eks (5.9%)", "Baelzeb Gogol (5%)", "Greed Gogol (5%)", "Brabilam Vang (4.7%)", "Drakos Telethia (2.7%)"}),
		new Manual(ManualType.ADVANCED, "Engage", "Reyn", new String[] {"Dark King Barbarus (5.7%)", "Stormy Belagon (4.7%)", "Commander Oracion (1.6%)", "Agile Barbatos (0.8%)", "Asara Telethia (8.8%)", "Envy Sardi (5%)", "Grove Quadwing (5%)", "Glory Slobos (3.9%)", "Phoenix Telethia (2.7%)", "M68/MISER (1.9%)", "M87/GRAND (1.9%)", "Defensive/ONION (1.3%)", "M35 Prototype (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Last Stand", "Reyn", new String[] {"Clandestine Apety (5.7%)", "Illustrious Golteus (5%)", "Infernal Crocell (1.6%)", "Agile Barbatos (1.5%)", "Asara Telethia (8.8%)", "Kyel Lexos (5%)", "Leg Tokilos (5%)", "Largo Selua (1.5%)", "M66/TRICK (1.3%)", "M37 Worker Bee Unit (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Rage", "Reyn", new String[] {"Clamorous Dablon (4.7%)", "Serene Imlaly (4.1%)", "Amorous Arca (1.6%)", "Pandora Pod (5%)", "Bagrus Nebula (4.7%)", "Licorne Telethia (2.7%)", "M68/CHORD (1.3%)", "Scout Unit Prototype (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Magnum Charge", "Reyn", new String[] {"Furious Jozan (6.1%)", "Armoured Rockwell (5%)", "Frenzied Bana (4.7%)", "Cold Ageshu (4.1%)", "Destroyer Salvacion (1.6%)", "Polkan Telethia (5%)", "Dorsiar Lizard (4.7%)", "Korlba Pterix (4.7%)", "Jelly Selua (1.5%)", "M45/VIOLA (1.3%)", "Mechon M46X (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Bone Upper", "Reyn", new String[] {"Plump Sprahda (8.8%)", "Wise Gremory (4.1%)", "Eternal Palsadia (2.3%)", "Frost Nebula (9.4%)", "Lograt Kromar (8.8%)", "Gracile Nebula (3.6%)", "M108/SPADE (3.1%)", "Feltl Eks (2.7%)", "Greed Gogol (2.3%)", "Brabilam Vang (2.1%)", "Drakos Telethia (1.2%)", "M68/MISER (0.9%)", "M87/GRAND (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Dive Sobat", "Reyn", new String[] {"Dazzling Tolosnia (9.5%)", "Stormy Belagon (2.1%)", "Bulganon Nebula (8.8%)", "Resplendent Flamii (8.8%)", "Newgate Laia (3.6%)", "Envy Sardi (2.3%)", "Phoenix Telethia (1.2%)"}),
		new Manual(ManualType.ADVANCED, "Aura Burst", "Reyn", new String[] {"Indomitable Daulton (14%)", "Synchronised Gaheris (3.6%)", "Affluent Beleth (2.4%)", "Barbaric Sitri (2.2%)", "Glorious Buer (2.2%)", "Magnis Ardun (14%)", "Panasowa Arachno (13%)", "Caura Balgas (5.4%)", "M37/EAGER (5.4%)", "M76/MOIST (3.7%)", "Mass-Produced Face (3.1%)", "Tramont Wisp (2.4%)", "Offensive Seeker Unit (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Anchor Chain", "Reyn", new String[] {"Veteran Yozel (14%)", "Temporal Gawain (3.6%)", "Revolutionary Bifrons (3.1%)", "Aged Leraje (2.4%)", "General Arachno (14%)", "Vilae Arachno (13%)", "M55/DREAD (5.4%)", "Uragano Nebula (5.4%)", "M84/GRUNT (3.7%)", "M38/ESSAY (3.1%)", "M57/FAITH (2.5%)", "M56 Prototype (1.6%)", "Offensive Security Unit (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Lariat", "Reyn", new String[] {"Protective Torquidon (9.5%)", "Destructive Bors (4.1%)", "Illustrious Golteus (2.3%)", "White Hox (9.4%)", "Aora Telethia (8.8%)", "Mass-Produced Face (3.6%)", "Solare Nebula (3.6%)", "Kyel Lexos (2.3%)", "Largo Selua (0.7%)"}),
		// Sharla's Manuals
		new Manual(ManualType.ADVANCED, "Heal Bullet", "Sharla", new String[] {"Magnificent Digalus (4.7%)", "Ageless Moabit (4.1%)", "Revolutionary Bifrons (1.6%)", "Gloria Slobos (7.3%)", "Deinos Sauros (4.7%)", "M57/FAITH (1.3%)", "M56 Prototype (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Thunder Bullet", "Sharla", new String[] {"Erratic Goliante (8.8%)", "Clamorous Dablon (2.1%)","Falsel Bunniv (8.8%)", "Arel Telethia (8.8%)", "Exterminator/EMBER (3.6%)", "Obart Obart (3.6%)", "Pandora Pod (2.3%)", "Licorne Telethia (1.2%)"}),
		new Manual(ManualType.ADVANCED, "Shield Bullet", "Sharla", new String[] {"Sacred Zagamei (4.7%)", "Fiendish Auburn (4.1%)", "Mild Florence (1.9%)", "Laeklit Mammut (4.7%)", "M55/GRACE (1.3%)", "M87 Prototype (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Cure Bullet", "Sharla", new String[] {"Flailing Bracken (13%)", "Ageless Moabit (11.4%)", "Vagabond Allocer (6.1%)", "Faithful Lancelot (3.6%)", "Splendid Botis (2.4%)", "Throne Sardi (13%)", "Carbon Tude (13%)", "Deinos Sauros (13%)", "Offensive/FOUND (4.6%)", "M37/ZEBRA (3.7%)", "Offensive/LYRIC (3.1%)", "Kukukoro Flamii (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Drive Boost", "Sharla", new String[] {"Musical Vanflare (13%)", "Fiendish Auburn (11.4%)", "Sentimental Flamral (6.1%)", "Beautiful Vagul (3.6%)", "Evil Bathin (2.4%)", "Opulent Flamii (13%)", "Eryth Rhana (13%)", "Laeklit Mammut (13%)", "M88/WORST (4.6%)", "M37/WITCH (3.7%)", "M44/ANGRY (3.1%)", "Fair Piranhax (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Heal Blast", "Sharla", new String[] {"Deadly Medorlo (4.7%)", "Majestic Clone Barg (4.1%)", "Magestic Mordred (1.9%)", "Satorl Torta (5%)", "M53/THANK (1.6%)", "M85 Meteor Artillery (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Heal Round", "Sharla", new String[] {"Masterful Gigapur (4.1%)", "Synchronised Gaheris (1.9%)", "Wandering Amon (1.8%)", "Green Feris (5%)", "Mass-Produced Face (1.6%)", "Offensive Seeker Unit  (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Head Shot", "Sharla", new String[] {"Firework Geldesia (9.5%)", "Armoured Rockwell (2.3%)", "Fascia Bunniv (8.8%)", "Offensive/BRAVE (3.6%)", "Cratere Nebula (2.6%)", "Polkan Telethia (2.3%)", "Dorsiar Lizard (2.1%)", "Jelly Selua (0.7%)"}),
		new Manual(ManualType.ADVANCED, "Metal Blast", "Sharla", new String[] {"Judicious Bunnitzol (13%)", "Majestic Clone Barg (11.4%)", "Experienced Tristan (6.1%)", "Commander Oracion (4.6%)", "Balanced Palamedes (3.6%)", "Agile Barbatos (2.2%)", "Satorl Torta (14%)", "Goldi Kromar (13%)", "Tored Ageshu (5.4%)", "M67/SONAR (4.6%)", "Defensive/ONION (3.7%)", "M57/BEAST (3.1%)", "M35 Prototype (2.4%)", "Corriente Krabble (1.6%)", "Lelepago Pterix (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Aura Bullet", "Sharla", new String[] {"Mysterious Barnaby (14%)", "Masterful Gigapur (11.4%)", "Soothed Aglovale (6.1%)", "Infernal Crocell (4.6%)", "Venerable Focalor (3.6%)", "Lahar Flamii (14%)", "Green Feris (13%)", "Zeldi Kromar (13%)", "Gimran Egel (5.4%)", "M68/MARCH (4.6%)", "M66/TRICK (3.7%)", "M37 Worker Bee Unit (2.4%)", "Lampo Ponio (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Heat Bullet", "Sharla", new String[] {"Reckless Galdon (13%)", "Inferno Heinrich (11.4%)", "Wrathful Orobas (6.1%)", "Amorous Arca (4.6%)", "Destroyer Salvacion (4.6%)", "Sinful Lamorak (3.6%)", "Dark Hox (14%)", "Trava Kromar (13%)", "Babel Deinos (5.4%)", "Defensive/GUARD (4.6%)", "M108/SPADE (4.6%)", "M45/VIOLA (3.7%)", "M68/CHORD (3.7%)", "Scout Unit Prototype (2.4%)", "Mechon M46X (2.4%)", "Oros Krabble (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Head Shaker", "Sharla", new String[] {"Plump Sprahda (13%)", "Abnormal Clone Barg (11.4%)", "Wise Gremory (6.1%)", "Frost Nebula (14%)", "Sol Grady (13%)", "Gracile Nebula (5.4%)"}),
		new Manual(ManualType.ADVANCED, "Covert Stance", "Sharla", new String[] {"Canyon Valencia (9.4%)", "Affluent Beleth (0.9%)", "Glorious Buer (0.8%)", "Barbaric Sitri (0.8%)", "Admiral Arachno (9.4%)", "Arel Telethia (8.8%)", "Jada Arachno (8.8%)", "Femuny Wisp (8.8%)", "Defensive/SHAME (3.6%)", "Babeli Barg (3.6%)", "M76/MOIST (1.3%)", "Tramont Wisp (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Heal Counter", "Sharla", new String[] {"Territorial Rotbart (9.4%)", "Rhoen Quadwing (8.8%)", "M97/CYCLE (3.6%)", "Fiume Nebula (3.6%)"}),
		new Manual(ManualType.ADVANCED, "Tranquilliser", "Sharla", new String[] {"Field Altrich (9.4%)", "Aora Telethia (8.8%)", "Jadals Arachno (8.8%)", "Hanz Pod (8.8%)", "M36/SACRE (3.6)", "Randa Nebula (3.6%)"}),
		new Manual(ManualType.ADVANCED, "Cure Round", "Sharla", new String[] {"Dazzling Tolosnia (14.1%)", "Meditative Varla (6.1%)", "Revolutionary Bifrons (4.6%)", "Resplendent Flamii (13%)", "Bulganon Nebula (13%)", "Newgate Laia (5.4%)", "M96/AWAKE (4.6%)", "M57/FAITH (3.7%)", "M36/FAIRY (3.1%)", "M56 Prototype (2.4%)", "Caelum Volff (1.6%)"}),
		// Dunban's Manuals
		new Manual(ManualType.ADVANCED, "Gale Slash", "Dunban", new String[] {"Inferno Heinrich (4.1%)", "Magnificent Digalus (2.1%)", "Despotic Arsene (2%)", "Balanced Palamedes (1.9%)", "Temporal Gawain (1.9%)", "Envy Gogol (5%)", "Sonicia Gogol (2.1%)", "M38/ESSAY (1.6%)", "Lelepago Pterix (0.9%)", "Offensive Security Unit  (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Electric Gutbuster", "Dunban", new String[] {"Abnormal Clone Barg (4.1%)", "Sacred Zagamei (2.1%)", "Faithful Lancelot (1.9%)", "Final Marcus (1.8%)", "Mystical Klesida (1%)", "Sol Grady (4.7%)", "Offensive/LYRIC (1.6%)", "Kukukoro Flamii (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Peerless", "Dunban", new String[] {"Indomitable Daulton (9.4%)", "Magnis Ardun (9.4%)", "Panasowa Arachno (8.8%)", "M37/EAGER (3.6%)", "Caura Balgas (3.6%)"}),
		new Manual(ManualType.ADVANCED, "Worldly Slash", "Dunban", new String[] {"Protective Torquidon (14.1%)", "Destructive Bors (6.1%)", "Mild Florence (5.4%)", "White Hox (14%)", "Aora Telethia (13%)", "Solare Nebula (5.4%)", "M55/GRACE (3.7%)", "Offensive/DIARY (3.1%)", "M87 Prototype (2.4%)", "Prado Upa (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Battle Eye", "Dunban", new String[] {"Deadly Medorlo (2.1%)", "Beautiful Vagul (1.9%)", "Avalanche Abaasy (1.9%)", "Victorious Gross (1%)", "Gluttony Gogol (2.3%)", "M44/ANGRY (1.6%)", "Fair Piranhax (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Steel Strike", "Dunban", new String[] {"Blizzard Belgazas (1.8%)", "Officer Robusto (1%)", "Wandering Amon (0.8%)", "Satorl Rhogul (2.3%)", "Glory Slobos (1.8%)"}),
		new Manual(ManualType.ADVANCED, "Serene Heart", "Dunban", new String[] {"Vivid Anstan (2.6%)", "Ancient Daedala (2%)", "Venerable Focalor (1.9%)", "Exposure Wolfol (0.8%)", "Baelfael Gogol (2.3%)", "Lampo Ponio (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Final Flicker", "Dunban", new String[] {"Veteran Yozel (9.4%)", "General Arachno (9.4%)", "Vilae Arachno (8.8%)", "Uragano Nebula (3.6%)", "M55/DREAD (3.6%)"}),
		new Manual(ManualType.ADVANCED, "Jaws of Death", "Dunban", new String[] {"Ghostly Mahatos (2.6%)", "Wicked Sallos (2.5%)", "Sinful Lamorak (1.9%)", "Glory Slobos (7.3%)", "Asha Telethia (2.3%)", "M36/FAIRY (1.6%)", "Oros Krabble (0.9%)", "Caelum Volff (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Tempest Kick", "Dunban", new String[] {"Erratic Goliante (13%)", "Magnificent Digalus (13%)", "Magestic Mordred (5.4%)", "Banquet Vassago (1.5%)", "Arel Telethia (13%)", "Exterminator/EMBER (5.4%)", "Obart Obart (5.4%)", "M53/THANK (4.6%)", "Offensive/SCOUT (2.5%)", "M85 Meteor Artillery (2.4%)", "Rius Antol (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Heat Haze", "Dunban", new String[] {"Bizarre Ragoel (8.8%)", "Sloth Gogol (9.4%)", "M56/UNION (3.6%)", "Sanjibal Behemoth (3.6%)"}),
		new Manual(ManualType.ADVANCED, "Spirit Breath", "Dunban", new String[] {"Reckless Zanden (4.7%)", "Active Impulso (2.6%)", "Baelzeb Gogol (2.3%)", "M57/BEAST (1.6%)", "Corriente Krabble (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Soaring Tempest", "Dunban", new String[] {"Powerful Eligos (10.2%)", "Tempest Vang (9.4%)", "M67/RADAR (3.6%)", "M67/REALM (3.6%)", "Chimai Selua (2.8%)"}),
		new Manual(ManualType.ADVANCED, "Thunder", "Dunban", new String[] {"Reckless Zanden (8.8%)", "Royal Caterpile (9.4%)", "Gigas Telethia (5.1%)"}),
		new Manual(ManualType.ADVANCED, "Demon Slayer", "Dunban", new String[] {"Despotic Arsene (4.3%)", "Dark King Barbarus (2.6%)", "Grove Quadwing (2.3%)", "Asara Telethia (2.1%)"}),
		new Manual(ManualType.ADVANCED, "Blinding Blossom", "Dunban", new String[] {"Firework Geldesia (14.1%)", "Sacred Zagamei (13%)", "Mystical Klesida (5.9%)", "Synchronised Gaheris (5.4%)", "North Star Gusion (2.8%)", "Hidden Gamigin (1.5%)", "Fascia Bunniv (13%)", "Offensive/BRAVE (5.4%)", "Mass-Produced Face (4.6%)", "Offensive/HONEY (2.5%)", "Offensive Seeker Unit (2.4%)", "Aura Antol (1.6%)"}),
		// Melia's Manuals
		new Manual(ManualType.ADVANCED, "Summon Bolt", "Melia", new String[] {"Reckless Galdon (4.7%)", "Ancient Daedala (4.3%)", "Wrathful Orobas (2.2%)", "Majestic Clone Barg (1.9%)", "Dark Hox (5%)", "Trava Kromar (4.7%)", "Satorl Torta (2.3%)", "Babel Deinos (1.9%)", "Defensive/GUARD (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Summon Flare", "Melia", new String[] {"Plump Sprahda (4.7%)", "Wise Gremory (2.2%)", "Masterful Gigapur (1.9%)", "Frost Nebula (5%)", "Lograt Kromar (4.7%)", "Green Feris (2.3%)", "M108/SPADE (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Summon Ice", "Melia", new String[] {"Avalanche Abaasy (11.4%)", "Active Impulso (10.7%)", "Moonlight Paimon (0.4%)", "Vague Barbas (0.4%)", "Prosperous Zepar (0.4%)", "Baelzeb Gogol (9.4%)", "M57/BEAST (0.7%)", "M91/DOGMA (0.6%)", "Happiness Flier (0.4%)", "Corriente Krabble (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Hypnotise", "Melia", new String[] {"Dazzling Tolosnia (5.1%)", "Meditative Varla (2.2%)", "Inferno Heinrich (1.9%)", "Resplendent Flamii (4.7%)", "Bulganon Nebula (4.7%)", "Envy Gogol (2.3%)", "M96/AWAKE (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Spear Break", "Melia", new String[] {"Blizzard Belgazas (10.9%)", "Dark King Barbarus (10.7%)", "North Star Gusion (1.5%)", "Hidden Gamigin (0.8%)", "Glorious Buer (0.4%)", "Barbaric Sitri (0.4%)", "Affluent Beleth (0.4%)", "Grove Quadwing (9.4%)", "Offensive/HONEY (1.3%)", "Aura Antol (0.9%)", "M36/FAIRY (0.7%)", "M76/MOIST (0.6%)", "Tramont Wisp (0.4%)", "Caelum Volff (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Shadow Stitch", "Melia", new String[] {"Ghostly Mahatos (15.9%)", "Wicked Sallos (15.2%)", "Immovable Gonzalez (14%)", "Balanced Palamedes (5.4%)", "Splendid Botis (1.6%)", "Setor Eks (16.4%)", "Asha Telethia (14%)", "M67/HASTE (5.4%)", "Wool Selua (4.1%)", "M37/ZEBRA (2.5%)", "Lelepago Pterix (2.4%)"}),
		new Manual(ManualType.ADVANCED, "Summon Copy", "Melia", new String[] {"Protective Torquidon (5.1%)", "Destructive Bors (2.2%)", "Abnormal Clone Barg (1.9%)", "White Hox (5%)", "Aora Telethia (4.7%)", "Asara Telethia (4.7%)", "Sol Grady (2.1%)", "Mass-Produced Face (1.9%)", "Solare Nebula (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Reflection", "Melia", new String[] {"Erratic Goliante (4.7%)", "Arel Telethia (4.7%)", "Asara Telethia (4.7%)", "Falsel Bunniv (4.7%)", "Exterminator/EMBER (1.9%)", "Obart Obart (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Summon Wind", "Melia", new String[] {"Ancient Daedala (12%)", "Clandestine Apety (10.7%)", "Aged Leraje (0.4%)", "Leg Tokilos (9.4%)", "Offensive/DIARY (0.7%)", "M84/GRUNT (0.6%)", "Prado Upa (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Summon Earth", "Melia", new String[] {"Serene Imlaly (7.7%)", "Flailing Bracken (2.1%)", "Vagabond Allocer (1%)", "Splendid Botis (0.4%)", "Bagrus Nebula (8.8%)", "Throne Sardi (2.1%)", "Carbon Tude (2.1%)", "Offensive/FOUND (0.7%)", "M37/ZEBRA (0.6%)"}),
		new Manual(ManualType.ADVANCED, "Summon Aqua", "Melia", new String[] {"Frenzied Bana (8.8%)", "Cold Ageshu (7.7%)", "Musical Vanflare (2.1%)", "Sentimental Flamral (1%)", "Evil Bathin (0.4%)", "Korlba Pterix (8.8%)", "Opulent Flamii (2.1%)", "Eryth Rhana (2.1%)", "Young Brog (2.1%)", "M88/WORST (0.7%)", "M37/WITCH (0.6%)"}),
		new Manual(ManualType.ADVANCED, "Healing Gift", "Melia", new String[] {"Ageless Moabit (7.7%)", "Judicious Bunnitzol (2.1%)", "Experienced Tristan (1%)", "Soothed Aglovale (1%)", "Prosperous Zepar (0.9%)", "Moonlight Paimon (0.8%)", "Vague Barbas (0.8%)", "Infernal Crocell (0.7%)", "Commander Oracion (0.7%)", "Agile Barbatos (0.4%)", "Asara Telethia (13%)", "Deinos Sauros (8.8%)", "Lahar Flamii (2.3%)", "Goldi Kromar (2.1%)", "M91/DOGMA (1.3%)", "Happiness Flier (0.9%)", "Tored Ageshu (0.9%)", "M68/MARCH (0.7%)", "M67/SONAR (0.7%)", "Defensive/ONION (0.6%)", "M66/TRICK (0.6%)", "M35 Prototype (0.4%)", "M37 Worker Bee Unit (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Starlight Kick", "Melia", new String[] {"Fiendish Auburn (7.7%)", "Mysterious Barnaby (2.3%)", "Asara Telethia (13%)", "Laeklit Mammut (8.8%)", "Zeldi Kromar (2.1%)", "Gimran Egel (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Power Effect", "Melia", new String[] {"Active Impulso (15.9%)", "Eternal Palsadia (14%)", "Venerable Focalor (5.4%)", "Evil Bathin (1.6%)", "Feltl Eks (16.4%)", "Greed Gogol (14%)", "Baelzeb Gogol (14%)", "Brabilam Vang (13%)", "Drakos Telethia (7.6%)", "M68/MISER (5.4%)", "M37/WITCH (2.5%)", "Lampo Ponio (2.4%)"}),
		new Manual(ManualType.ADVANCED, "Burst End", "Melia", new String[] {"Majestic Clone Barg (7.7%)", "Reckless Galdon (2.1%)", "Wrathful Orobas (1%)", "Aged Leraje (0.9%)", "Amorous Arca (0.7%)", "Satorl Torta (9.4%)", "Dark Hox (2.3%)", "Trava Kromar (2.1%)", "M84/GRUNT (1.3%)", "Babel Deinos (0.9%)", "Defensive/GUARD (0.7%)", "M68/CHORD (0.6%)", "Scout Unit Prototype (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Mind Blast", "Melia", new String[] {"Firework Geldesia (5.1%)", "Fascia Bunniv (4.7%)", "Offensive/BRAVE (1.9%)", "Cratere Nebula (1.9%)"}),
		// Riki's Manuals
		new Manual(ManualType.ADVANCED, "Happy Happy", "Riki", new String[] {"Avalanche Abaasy (4.7%)", "Clandestine Apety (2.6%)", "Affluent Beleth (1.6%)", "Glorious Buer (1.5%)", "Barbaric Sitri (1.5%)", "M76/MOIST (2.5%)", "Leg Tokilos (2.3%)", "Asara Telethia (2.1%)", "Tramont Wisp (1.6%)", "Offensive/DIARY (1.6%)", "Prado Upa (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Bitey Bitey", "Riki", new String[] {"Flailing Bracken (4.7%)", "Vagabond Allocer (2.2%)", "Serene Imlaly (1.9%)", "Throne Sardi (4.7%)", "Carbon Tude (4.7%)", "Bagrus Nebula (2.1%)", "Offensive/FOUND (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Sneaky", "Riki", new String[] {"Musical Vanflare (4.7%)", "Final Marcus (3.9%)", "Sentimental Flamral (2.2%)", "Frenzied Bana (2.1%)", "Cold Ageshu (1.9%)", "Furious Jozan (1.5%)", "Opulent Flamii (4.7%)", "Eryth Rhana (4.7%)", "Young Brog (4.7%)", "Korlba Pterix (2.1%)", "M88/WORST (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Play Dead", "Riki", new String[] {"Bizarre Ragoel (13%)", "Deadly Medorlo (13%)", "Victorious Gross (5.9%)", "Temporal Gawain (5.4%)", "Prosperous Zepar (1.6%)", "Moonlight Paimon (1.5%)", "Vague Barbas (1.5%)", "Sloth Gogol (14%)", "Gluttony Gogol (14%)", "M56/UNION (5.4%)", "Sanjibal Behemoth (5.4%)", "M38/ESSAY (4.6%)", "M91/DOGMA (2.5%)", "Happiness Flier (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Lurgy", "Riki", new String[] {"Immovable Gonzalez (9.4%)", "Setor Eks (11%)", "Last Rhogul (9.4%)", "M67/HASTE (3.6%)", "Wool Selua (2.8%)"}),
		new Manual(ManualType.ADVANCED, "Hero Time", "Riki", new String[] {"Eternal Palsadia (9.4%)", "Feltl Eks (11%)", "Greed Gogol (9.4%)", "Brabilam Vang (8.8%)", "Drakos Telethia (5.1%)", "M68/MISER (3.6%)"}),
		new Manual(ManualType.ADVANCED, "Roly-Poly", "Riki", new String[] {"Stormy Belagon (8.8%)", "Envy Sardi (9.4%)", "Phoenix Telethia (5.1%)"}),
		new Manual(ManualType.ADVANCED, "Behave", "Riki", new String[] {"Illustrious Golteus (9.4%)", "Kyel Lexos (9.4%)", "Largo Selua (2.8%)"}),
		new Manual(ManualType.ADVANCED, "Riki is Angry", "Riki", new String[] {"Judicious Bunnitzol (4.7%)", "Experienced Tristan (2.2%)", "Ageless Moabit (1.9%)", "Goldi Kromar (4.7%)", "Deinos Sauros (2.1%)", "Tored Ageshu (1.9%)", "Gloria Slobos (1.8%)", "M67/SONAR (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Bedtime", "Riki", new String[] {"Clamorous Dablon (8.8%)", "Pandora Pod (9.4%)", "Licorne Telethia (5.1%)"}),
		new Manual(ManualType.ADVANCED, "You Can Do It", "Riki", new String[] {"Mysterious Barnaby (5%)", "Blizzard Belgazas (3.9%)", "Soothed Aglovale (2.2%)", "Fiendish Auburn (1.9%)", "Lahar Flamii (5%)", "Zeldi Kromar (4.7%)", "Laeklit Mammut (2.1%)", "Gimran Egel (1.9%)", "M68/MARCH (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Peekaboo", "Riki", new String[] {"Powerful Eligos (15.2%)", "Officer Robusto (5.9%)", "Wandering Amon (5.1%)", "Tempest Vang (14%)", "Satorl Rhogul (14%)", "Chimai Selua (4.1%)"}),
		new Manual(ManualType.ADVANCED, "Say Sorry", "Riki", new String[] {"Armoured Rockwell (9.4%)", "Polkan Telethia (9.4%)", "Dorsiar Lizard (8.8%)", "M87/GRAND (3.6%)", "Jelly Selua (2.8%)"}),
		new Manual(ManualType.ADVANCED, "Burninate", "Riki", new String[] {"Despotic Arsene (12%)", "Vivid Anstan (10.7%)", "Exposure Wolfol (3.4%)", "Venerable Focalor (0.9%)", "Banquet Vassago (0.4%)", "Baelfael Gogol (9.4%)", "Offensive/SCOUT (0.6%)", "Rius Antol (0.4%)", "Lampo Ponio (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Freezinate", "Riki", new String[] {"Final Marcus (10.9%)", "Ghostly Mahatos (10.%)", "Wicked Sallos (10.2%)", "Splendid Botis (0.9%)", "Sinful Lamorak (0.9%)", "North Star Gusion (0.7%)", "Hidden Gamigin (0.4%)", "Glory Slobos (10.9%)", "Asha Telethia (9.4%)", "M37/ZEBRA (1.3%)", "Offensive/HONEY (0.6%)", "Aura Antol (0.4%)", "Oros Krabble (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Tantrum", "Riki", new String[] {"Vivid Anstan (15.9%)", "Reckless Zanden (13%)", "Faithful Lancelot (5.4%)", "Beautiful Vagul (5.4%)", "Exposure Wolfol (5.1%)", "Aged Leraje (1.6%)", "Royal Caterpile (14%)", "Baelfael Gogol (14%)", "Gigas Telethia (7.6%)", "M67/RADAR (5.4%)", "M67/REALM (5.4%)", "M44/ANGRY (4.6%)", "Offensive/LYRIC (4.6%)", "M84/GRUNT (2.5%)", "Kukukoro Flamii (2.4%)", "Fair Piranhax (2.4%)"}),
		// Fiora's Manuals
		new Manual(ManualType.ADVANCED, "Double Blade", "Fiora", new String[] {"Canyon Valencia (5%)", "Furious Jozan (3.3%)", "Admiral Arachno (5%)", "Arel Telethia (4.7%)", "Femuny Wisp (4.7%)", "Jada Arachno (4.7%)", "Babeli Barg (1.9%)", "Defensive/SHAME (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Healing Energy", "Fiora", new String[] {"Dark King Barbarus (15.9%)", "Stormy Belagon (13%)", "Sinful Lamorak (5.4%)", "Commander Oracion (3.1%)", "Envy Sardi (14%)", "Grove Quadwing (14%)", "Phoenix Telethia (7.6%)", "M87/GRAND (5.4%)", "Defensive/ONION (2.5%)", "Oros Krabble (2.4%)", "M35 Prototype (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Spear Blade", "Fiora", new String[] {"Furious Jozan (9.1%)", "Masterful Gigapur (7.7%)", "Plump Sprahda (2.1%)", "Wise Gremory (1%)", "Destroyer Salvacion (0.7%)", "Green Feris (9.4%)", "Frost Nebula (2.3%)", "Lograt Kromar (2.1%)", "Gracile Nebula (0.9%)", "M108/SPADE (0.7%)", "M45/VIOLA (0.6%)", "Mechon M46X (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Cross Impact", "Fiora", new String[] {"Inferno Heinrich (7.7%)", "Dazzling Tolosnia (2.3%)", "Gloria Slobos (10.9%)", "Envy Gogol (9.4%)", "Bulganon Nebula (2.1%)", "Resplendent Flamii (2.1%)", "Newgate Laia (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Speed Shift", "Fiora", new String[] {"Territorial Rotbart (5%)", "Rhoen Quadwing (4.7%)", "Gloria Slobos (3.9%)", "Fiume Nebula (1.9%)", "M97/CYCLE (1.9%)"}),
		new Manual(ManualType.ADVANCED, "Zero Gravity", "Fiora", new String[] {"Abnormal Clone Barg (7.7%)", "Protective Torquidon (2.3%)", "Destructive Bors (1%)", "Mild Florence (0.9%)", "Sol Grady (8.8%)", "White Hox (2.3%)", "Aora Telethia (2.1%)", "Mass-Produced Face (0.9%)", "Solare Nebula (0.9%)", "M55/GRACE (0.6%)", "M87 Prototype (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Lock-On", "Fiora", new String[] {"Erratic Goliante (2.1%)", "Magestic Mordred (0.9%)", "Arel Telethia (2.1%)", "Falsel Bunniv (2.1%)", "Exterminator/EMBER (0.9%)", "Obart Obart (0.9%)", "M53/THANK (0.7%)", "M85 Meteor Artillery (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Ether Drain", "Fiora", new String[] {"Firework Geldesia (2.3%)", "Synchronised Gaheris (0.9%)", "Fascia Bunniv (2.1%)", "Cratere Nebula (0.9%)", "Offensive/BRAVE (0.9%)", "Mass-Produced Face (0.7%)", "Offensive Seeker Unit  (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Double Wind", "Fiora", new String[] {"Magnificent Digalus (8.8%)", "Canyon Valencia (2.3%)", "Temporal Gawain (0.9%)", "Sonicia Gogol (8.8%)", "Admiral Arachno (2.3%)", "Arel Telethia (2.1%)", "Femuny Wisp (2.1%)", "Jada Arachno (2.1%)", "Babeli Barg (0.9%)", "Defensive/SHAME (0.9%)", "M38/ESSAY (0.7%)", "Offensive Security Unit (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Mag Storm", "Fiora", new String[] {"Sacred Zagamei (8.8%)", "Mystical Klesida (4%)", "Territorial Rotbart (2.3%)", "Rhoen Quadwing (2.1%)", "Fiume Nebula (0.9%)"}),
		new Manual(ManualType.ADVANCED, "Shutdown", "Fiora", new String[] {"Clandestine Apety (15.9%)", "Illustrious Golteus (14%)", "Infernal Crocell (3.1%)", "Kyel Lexos (14%)", "Leg Tokilos (14%)", "M57/BEAST (4.6%)", "Largo Selua (4.1%)", "M66/TRICK (2.5%)", "Corriente Krabble (2.4%)", "M37 Worker Bee Unit (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Air Fang", "Fiora", new String[] {"Deadly Medorlo (8.8%)", "Victorious Gross (4%)", "Field Altrich (2.3%)", "Beautiful Vagul (0.9%)", "Faithful Lancelot (0.9%)", "Gluttony Gogol (9.4%)", "Aora Telethia (2.1%)", "Hanz Pod (2.1%)", "Jadals Arachno (2.1%)", "M36/SACRE (0.9%)", "M97/CYCLE (0.9%)", "Randa Nebula (0.9%)", "M44/ANGRY (0.7%)", "Offensive/LYRIC (0.7%)", "Fair Piranhax (0.4%)", "Kukukoro Flamii (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Power Drain", "Fiora", new String[] {"Officer Robusto (4%)", "Wandering Amon (3.4%)", "Indomitable Daulton (2.3%)", "Meditative Varla (1%)", "Balanced Palamedes (0.9%)", "Revolutionary Bifrons (0.7%)", "Satorl Rhogul (9.4%)", "Magnis Ardun (2.3%)", "Panasowa Arachno (2.1%)", "Caura Balgas (0.9%)", "M37/EAGER (0.9%)", "M96/AWAKE (0.7%)", "M57/FAITH (0.6%)", "Lelepago Pterix (0.4%)", "M56 Prototype (0.4%)"}),
		new Manual(ManualType.ADVANCED, "Guard Shift (F)", "Fiora", new String[] {"Clamorous Dablon (13%)", "Serene Imlaly (11.4%)", "Amorous Arca (3.1%)", "Bagrus Nebula (13%)", "Hanz Pod (13%)", "Randa Nebula (5.4%)", "M36/FAIRY (4.6%)", "M68/CHORD (2.5%)", "Caelum Volff (2.4%)"}),
		new Manual(ManualType.ADVANCED, "Second Gear", "Fiora", new String[] {"Armoured Rockwell (14%)", "Frenzied Bana (13%)", "Cold Ageshu (11.4%)", "Destroyer Salvacion (3.1%)", "Polkan Telethia (14%)", "Dorsiar Lizard (13%)", "Korlba Pterix (13%)", "Offensive/DIARY (4.6%)", "Jelly Selua (4.1%)", "M45/VIOLA (2.5%)", "Prado Upa (2.4%)", "Mechon M46X (1.6%)"}),
		new Manual(ManualType.ADVANCED, "Final Cross", "Fiora", new String[] {"Field Altrich (5%)", "Aora Telethia (4.7%)", "Hanz Pod (4.7%)", "Jadals Arachno (4.7%)", "M36/SACRE (1.9%)", "Randa Nebula (1.9%)"})
	};
	public static final Manual[] MASTER_MANUALS = new Manual[]
	{
		new Manual(ManualType.MASTER, "Slit Edge", "Shulk"),
		new Manual(ManualType.MASTER, "Back Slash", "Shulk"),
		new Manual(ManualType.MASTER, "Light Heal", "Shulk"),
		new Manual(ManualType.MASTER, "Shaker Edge", "Shulk"),
		new Manual(ManualType.MASTER, "Air Slash", "Shulk"),
		new Manual(ManualType.MASTER, "Shadow Eye", "Shulk"),
		new Manual(ManualType.MASTER, "Battle Soul", "Shulk"),
		new Manual(ManualType.MASTER, "Stream Edge", "Shulk"),
		// Reyn's Manuals
		new Manual(ManualType.MASTER, "Hammer Beat", "Reyn"),
		new Manual(ManualType.MASTER, "Wild Down", "Reyn"),
		new Manual(ManualType.MASTER, "Guard Shift (R)", "Reyn"),
		new Manual(ManualType.MASTER, "War Swing", "Reyn"),
		new Manual(ManualType.MASTER, "Sword Drive", "Reyn"),
		new Manual(ManualType.MASTER, "Berserker", "Reyn"),
		new Manual(ManualType.MASTER, "Shield Bash", "Reyn"),
		new Manual(ManualType.MASTER, "Engage", "Reyn"),
		new Manual(ManualType.MASTER, "Last Stand", "Reyn"),
		new Manual(ManualType.MASTER, "Rage", "Reyn"),
		new Manual(ManualType.MASTER, "Magnum Charge", "Reyn"),
		new Manual(ManualType.MASTER, "Bone Upper", "Reyn"),
		new Manual(ManualType.MASTER, "Dive Sobat", "Reyn"),
		new Manual(ManualType.MASTER, "Aura Burst", "Reyn"),
		new Manual(ManualType.MASTER, "Anchor Chain", "Reyn"),
		new Manual(ManualType.MASTER, "Lariat", "Reyn"),
		// Sharla's Manuals
		new Manual(ManualType.MASTER, "Heal Bullet", "Sharla"),
		new Manual(ManualType.MASTER, "Thunder Bullet", "Sharla"),
		new Manual(ManualType.MASTER, "Shield Bullet", "Sharla"),
		new Manual(ManualType.MASTER, "Cure Bullet", "Sharla"),
		new Manual(ManualType.MASTER, "Drive Boost", "Sharla"),
		new Manual(ManualType.MASTER, "Heal Blast", "Sharla"),
		new Manual(ManualType.MASTER, "Heal Round", "Sharla"),
		new Manual(ManualType.MASTER, "Head Shot", "Sharla"),
		new Manual(ManualType.MASTER, "Metal Blast", "Sharla"),
		new Manual(ManualType.MASTER, "Aura Bullet", "Sharla"),
		new Manual(ManualType.MASTER, "Heat Bullet", "Sharla"),
		new Manual(ManualType.MASTER, "Head Shaker", "Sharla"),
		new Manual(ManualType.MASTER, "Covert Stance", "Sharla"),
		new Manual(ManualType.MASTER, "Heal Counter", "Sharla"),
		new Manual(ManualType.MASTER, "Tranquilliser", "Sharla"),
		new Manual(ManualType.MASTER, "Cure Round", "Sharla"),
		// Dunban's Manuals
		new Manual(ManualType.MASTER, "Gale Slash", "Dunban"),
		new Manual(ManualType.MASTER, "Electric Gutbuster", "Dunban"),
		new Manual(ManualType.MASTER, "Peerless", "Dunban"),
		new Manual(ManualType.MASTER, "Worldly Slash", "Dunban"),
		new Manual(ManualType.MASTER, "Battle Eye", "Dunban"),
		new Manual(ManualType.MASTER, "Steel Strike", "Dunban"),
		new Manual(ManualType.MASTER, "Serene Heart", "Dunban"),
		new Manual(ManualType.MASTER, "Final Flicker", "Dunban"),
		new Manual(ManualType.MASTER, "Jaws of Death", "Dunban"),
		new Manual(ManualType.MASTER, "Tempest Kick", "Dunban"),
		new Manual(ManualType.MASTER, "Heat Haze", "Dunban"),
		new Manual(ManualType.MASTER, "Spirit Breath", "Dunban"),
		new Manual(ManualType.MASTER, "Soaring Tempest", "Dunban"),
		new Manual(ManualType.MASTER, "Thunder", "Dunban"),
		new Manual(ManualType.MASTER, "Demon Slayer", "Dunban"),
		new Manual(ManualType.MASTER, "Blinding Blossom", "Dunban"),
		// Melia's Manuals
		new Manual(ManualType.MASTER, "Summon Bolt", "Melia"),
		new Manual(ManualType.MASTER, "Summon Flare", "Melia"),
		new Manual(ManualType.MASTER, "Summon Ice", "Melia"),
		new Manual(ManualType.MASTER, "Hypnotise", "Melia"),
		new Manual(ManualType.MASTER, "Spear Break", "Melia"),
		new Manual(ManualType.MASTER, "Shadow Stitch", "Melia"),
		new Manual(ManualType.MASTER, "Summon Copy", "Melia"),
		new Manual(ManualType.MASTER, "Reflection", "Melia"),
		new Manual(ManualType.MASTER, "Summon Wind", "Melia"),
		new Manual(ManualType.MASTER, "Summon Earth", "Melia"),
		new Manual(ManualType.MASTER, "Summon Aqua", "Melia"),
		new Manual(ManualType.MASTER, "Healing Gift", "Melia"),
		new Manual(ManualType.MASTER, "Starlight Kick", "Melia"),
		new Manual(ManualType.MASTER, "Power Effect", "Melia"),
		new Manual(ManualType.MASTER, "Burst End", "Melia"),
		new Manual(ManualType.MASTER, "Mind Blast", "Melia"),
		// Riki's Manuals
		new Manual(ManualType.MASTER, "Happy Happy", "Riki"),
		new Manual(ManualType.MASTER, "Bitey Bitey", "Riki"),
		new Manual(ManualType.MASTER, "Sneaky", "Riki"),
		new Manual(ManualType.MASTER, "Play Dead", "Riki"),
		new Manual(ManualType.MASTER, "Lurgy", "Riki"),
		new Manual(ManualType.MASTER, "Hero Time", "Riki"),
		new Manual(ManualType.MASTER, "Roly-Poly", "Riki"),
		new Manual(ManualType.MASTER, "Behave", "Riki"),
		new Manual(ManualType.MASTER, "Riki is Angry", "Riki"),
		new Manual(ManualType.MASTER, "Bedtime", "Riki"),
		new Manual(ManualType.MASTER, "You Can Do It", "Riki"),
		new Manual(ManualType.MASTER, "Peekaboo", "Riki"),
		new Manual(ManualType.MASTER, "Say Sorry", "Riki"),
		new Manual(ManualType.MASTER, "Burninate", "Riki"),
		new Manual(ManualType.MASTER, "Freezinate", "Riki"),
		new Manual(ManualType.MASTER, "Tantrum", "Riki"),
		// Fiora's Manuals
		new Manual(ManualType.MASTER, "Double Blade", "Fiora"),
		new Manual(ManualType.MASTER, "Healing Energy", "Fiora"),
		new Manual(ManualType.MASTER, "Spear Blade", "Fiora"),
		new Manual(ManualType.MASTER, "Cross Impact", "Fiora"),
		new Manual(ManualType.MASTER, "Speed Shift", "Fiora"),
		new Manual(ManualType.MASTER, "Zero Gravity", "Fiora"),
		new Manual(ManualType.MASTER, "Lock-On", "Fiora"),
		new Manual(ManualType.MASTER, "Ether Drain", "Fiora"),
		new Manual(ManualType.MASTER, "Double Wind", "Fiora"),
		new Manual(ManualType.MASTER, "Mag Storm", "Fiora"),
		new Manual(ManualType.MASTER, "Shutdown", "Fiora"),
		new Manual(ManualType.MASTER, "Air Fang", "Fiora"),
		new Manual(ManualType.MASTER, "Power Drain", "Fiora"),
		new Manual(ManualType.MASTER, "Guard Shift (F)", "Fiora"),
		new Manual(ManualType.MASTER, "Second Gear", "Fiora"),
		new Manual(ManualType.MASTER, "Final Cross", "Fiora")
	};
	public static final Manual[] ALL_MANUALS = Stream.of(ADVANCED_MANUALS, MASTER_MANUALS).flatMap(Arrays::stream).toArray(Manual[]::new);

	private Manuals() {}

	public static Manual getManualFromName(ManualType type, String name)
	{
		switch (type)
		{
		case ADVANCED:
			for (Manual manual : ADVANCED_MANUALS)
			{
				if (manual.name.equalsIgnoreCase(name))
					return manual;
			}
			break;
		case MASTER:
			for (Manual manual : MASTER_MANUALS)
			{
				if (manual.name.equalsIgnoreCase(name))
					return manual;
			}
		}

		return null;
	}

	public static class Manual
	{
		public final ManualType type;
		/* The name of the manual itself. */
		public final String name;
		/* The name of the character who uses this manual. */
		public final String character;
		public final String[] obtainedFrom;

		private Manual(ManualType type, String name, String character, String... obtainedFrom)
		{
			this.type = type;
			this.name = name;
			this.character = character;
			this.obtainedFrom = obtainedFrom;
		}

		@Override
		public String toString()
		{
			return this.name + ": " + type.name + " (" + this.character + ")";
		}
	}

	public enum ManualType
	{
		ADVANCED("Advanced"),
		MASTER("Master");
		public final String name;

		private ManualType(String name)
		{
			this.name = name;
		}

		public static ManualType getFromName(String name)
		{
			if (name.equalsIgnoreCase("Master"))
				return MASTER;

			return ADVANCED;
		}
	}
}