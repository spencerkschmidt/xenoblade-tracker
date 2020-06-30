package tracker.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import tracker.logging.Logger;
import tracker.xcde.items.DELocation;
import tracker.xcde.items.DEQuests;
import tracker.xcde.items.DEQuests.DEQuest;
import tracker.xcde.items.HeartToHearts.HeartToHeart.Affinity;
import tracker.xcde.items.Manuals;
import tracker.xcde.items.Manuals.Manual;
import tracker.xcde.items.Manuals.ManualType;
import tracker.xcde.ui.view.pages.ViewAffinity;

public class SaveManager
{
	private static final Logger LOGGER = new Logger("File Managing");
	private static final int CURRENT_SAVE_VERSION = 2;

	// ==================================== Xenoblade Chronicles Definitive Edition Tracking Items ====================================
	/**
	 * <p>A mapping between an {@link Integer} and a {@link DEQuest}. The map is stored as a {@link LinkedHashMap} to allow the mapping to be reordered based
	 * on the {@code Integer} keys.</p>
	 * 
	 * <p>The {@code Integer} key is the unique ID number of the {@code DEQuest} that it is mapped to.</p>
	 */
	public static LinkedHashMap<Integer, DEQuest> defintiveCompletedQuests = new LinkedHashMap<Integer, DEQuest>();
	/**
	 * A {@link List} of {@link String} objects that are the names of all of the Unique Monsters that have been defeated in
	 * Xenoblade Chronicles Definitive Edition.
	 */
	public static final List<String> DE_UNIQUE_MONSTERS = new ArrayList<String>();
	/**
	 * A {@code List} of {@code Manual} objects that contains all of the Advanced Manuals that have been collected.
	 */
	public static final List<Manual> ADVANCED_MANUALS = new ArrayList<Manual>();
	/**
	 * A {@code List} of {@code Manual} objects that contains all of the Master Manuals that have been collected.
	 */
	public static final List<Manual> MASTER_MANUALS = new ArrayList<Manual>();
	/**
	 * A {@code List} of {@code String} objects that are the names of all Records and Trials that have been achieved.
	 */
	public static final List<String> ACHIEVEMENTS = new ArrayList<String>();
	/**
	 * <p>A LinkedHashMap that contains a mapping between {@code Location} and {@code List<String>}. The map is stored as a {@code LinkedHashMap} to allow the
	 * mapping to be reordered based on the {@code Location} keys.</p>
	 * 
	 * <p>The {@code Location} is the area in which the collectables have been collected, and {@code List<String>} contains the names of all of the items in
	 * the {@code Location} that have been collected.</p>
	 */
	public static final Map<DELocation, List<String>> DE_COLLECTABLES = new LinkedHashMap<DELocation, List<String>>();
	/**
	 * 
	 */
	public static final List<String> DE_HEART_TO_HEARTS = new ArrayList<String>();
	/**
	 * 
	 */
	public static final Map<String, Map<String, Affinity>> AFFINITIES = new LinkedHashMap<String, Map<String, Affinity>>();

	// ==================================== Xenoblade Chronicles Definitive Edition: Future Connected Tracking Items ====================================
	// ==================================== Xenoblade Chronicles 2 Tracking Items ====================================
	/**
	 * <p>A {@link List} of {@link Integer} objects that are all the quests in Xenoblade Chronicles 2 that have been completed..</p>
	 * 
	 * <p>The {@code Integer} key is the quest ID number of the {@link XCQuest} that it is mapped to.</p>
	 */
	public static List<Integer> xenoblade2CompletedQuests = new ArrayList<Integer>();
	// ==================================== Xenoblade Chronicles 2: Torna ~ The Golden Country Tracking Items ====================================
	// ==================================== Xenoblade Chronicles X Tracking Items ====================================
	
	/**
	 * The option on whether or not to autosave after every change.
	 */
	public static Property doAutosave = new Property(false);
	/**
	 * <p>The option on whether or not the view used for the quests will be a list view or table view.</p>
	 * 
	 * <p>If {@code useOldQuests} is true, then the list view will be used, otherwise, the table view will be used.</p>
	 */
//	public static boolean useOldQuests = false;

	/**
	 * <p>The maximum number of recent files to keep track of.</p>
	 */
	public static Property maxNumberOfRecents = new Property(5);
	/**
	 * 
	 */
	public static Property keepTrackRecents = new Property(true);

	public static Property currentLanguage = new Property("en_CA");
	/**
	 * The {@code File} that has been selected or created to save all the contents of items that have been completed.
	 */
	public static File selectedSaveFile;

	private static final File RECENT_FILES = new File("./recentfiles.txt");
	private static final File CONFIG_FILE = new File("./config.txt");

	private SaveManager() {}

	static
	{
		// Put all of the named location into the keys so that they do not have to be initialized elsewhere.
		for (DELocation location : DELocation.values())
		{
			DE_COLLECTABLES.put(location, new ArrayList<String>());
			LOGGER.log(String.format("Initializing the area '%s' for collectables.", location.name));
		}
	}

	/**
	 * TODO: Add a SAVE VERSION to allow for backwards compatibility for when Future Connected things are added.
	 * The current save format looks like this:
	 * 
	 * 	{
	 * 		"completed_quests": [],
	 * 		"unique_monsters": [],
	 * 		"manuals": {
	 * 			"advanced_manuals": [],
	 * 			"master_manuals": []
	 *		},
	 *		"achievements": [],
	 *		"collectables": {
	 *			"Colony 9": [],
	 *			"Tephra Cave": [],
	 *			"Bionis' Leg": [],
	 *			"Colony 6": [],
	 *			"Ether Mine": [],
	 *			"Satorl Marsh": [],
	 *			"Makna Forest": [],
	 *			"Frontier Village": [],
	 *			"Eryth Sea": [],
	 *			"Alcamoth": [],
	 *			"High Entia Tomb": [],
	 *			"Valak Mountain": [],
	 *			"Sword Valley": [],
	 *			"Galahad Fortress": [],
	 *			"Fallen Arm": [],
	 *			"Mechonis Field": [],
	 *			"Central Factory": [],
	 *			"Agniratha": [],
	 *			"Bionis' Interior": [],
	 *			"Prison Island": []
	 *		}
	 * 	}
	 * 
	 * The new save format will look like:
	 * 
	 * 	{
	 * 		"version": 1,
	 * 		"completed_quests": [],
	 * 		"unique_monsters": [],
	 * 		"manuals": {
	 * 			"advanced_manuals": [],
	 * 			"master_manuals": []
	 *		},
	 *		"achievements": [],
	 *		"collectables": {
	 *			"Colony 9": [],
	 *			"Tephra Cave": [],
	 *			"Bionis' Leg": [],
	 *			"Colony 6": [],
	 *			"Ether Mine": [],
	 *			"Satorl Marsh": [],
	 *			"Makna Forest": [],
	 *			"Frontier Village": [],
	 *			"Eryth Sea": [],
	 *			"Alcamoth": [],
	 *			"High Entia Tomb": [],
	 *			"Valak Mountain": [],
	 *			"Sword Valley": [],
	 *			"Galahad Fortress": [],
	 *			"Fallen Arm": [],
	 *			"Mechonis Field": [],
	 *			"Central Factory": [],
	 *			"Agniratha": [],
	 *			"Bionis' Interior": [],
	 *			"Prison Island": []
	 *		},
	 *		"heart_to_hearts": [],
	 *		"appearances": []
	 * 	}
	 * 
	 *	and after adding Future Connected & Xenoblade Chronicles 2 & Torna ~ The Golden Country
	 *  
	 *  {
	 * 		"version": 2,
	 * 		"definitive_edition": {
	 * 			"completed_quests": [],
	 * 			"unique_monsters": [],
	 * 			"manuals": {
	 * 				"advanced_manuals": [],
	 * 				"master_manuals": []
	 *			},
	 *			"achievements": [],
	 *			"collectables": {
	 *				"Colony 9": [],
	 *				"Tephra Cave": [],
	 *				"Bionis' Leg": [],
	 *				"Colony 6": [],
	 *				"Ether Mine": [],
	 *				"Satorl Marsh": [],
	 *				"Makna Forest": [],
	 *				"Frontier Village": [],
	 *				"Eryth Sea": [],
	 *				"Alcamoth": [],
	 *				"High Entia Tomb": [],
	 *				"Valak Mountain": [],
	 *				"Sword Valley": [],
	 *				"Galahad Fortress": [],
	 *				"Fallen Arm": [],
	 *				"Mechonis Field": [],
	 *				"Central Factory": [],
	 *				"Agniratha": [],
	 *				"Bionis' Interior": [],
	 *				"Prison Island": []
	 *			},
	 *			"heart_to_hearts": [],
	 *			"appearances": []
	 * 		},
	 * 		"future_connected": {
	 * 			"completed_quests": [],
	 * 			"unique_monsters": [],
	 * 			"manuals": [],
	 *			"achievements": [],
	 *			"collectables": {},
	 *			"quiet_moments": []
	 * 		},
	 * 		"xenoblade_2": {
	 * 			"completed_quests": [],
	 * 			"unique_monsters": [],
	 * 			"heart_to_hearts": [],
	 * 			"deeds": [],
	 * 			"merc_missions": [],
	 * 			"costumes": []
	 * 		},
	 * 		"torna": {
	 * 			"completed_quests": [],
	 * 			"unique_monsters": [],
	 * 			"heart_to_hearts": []
	 * 		}
	 *  }
	 */

	/**
	 * <p>A helper method to add the {@code Quest} to the {@code completedQuestsMapping}.</p>
	 * 
	 * <p>This will map the quest's unique id to the given quest in the {@code completedQuestsMapping}.</p>
	 * 
	 * @param quest The quest to add to the mapping.
	 */
	public static void addQuest(DEQuest quest)
	{
		defintiveCompletedQuests.put(quest.getUniqueID(), quest);
	}

	/**
	 * <p>A helper method to remove the {@code Quest} from the {@code completedQuestsMapping}.</p>
	 * 
	 * <p>This will remove the quest that matches the quest's unique id from the {@code completedQuestsMapping}.</p>
	 * 
	 * @param quest The quest to remove from the mapping.
	 */
	public static void removeQuest(DEQuest quest)
	{
		defintiveCompletedQuests.remove(quest.getUniqueID());
	}

	public static void updateCharactersAffinities(ViewAffinity.Character... charactersToUpdate)
	{
		for (ViewAffinity.Character character : charactersToUpdate)
		{
			AFFINITIES.put(character.name, character.getAllAfinities());
		}
	}

	/**
	 * Will set the '{@code selectedSaveFile}' to the given file and then will write to that file, creating it if it does not exist.
	 * 
	 * @param file The file to save the completed items to, in Json format.
	 * @param autoSave Whether the action doing the saving is an autosave. This makes it so that the console doesn't output the saving output every autosave.
	 */
	public static void saveToFileWithJSON(File file, boolean autoSave)
	{
		String name = file.getAbsolutePath();
		String[] z = name.split("\\.");

		if (z.length < 2 || !z[1].equalsIgnoreCase("json"))
			file = new File(z[0] + ".json");

		selectedSaveFile = file;
		Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
		JsonObject mainObject = new JsonObject();
		mainObject.add("version", new JsonPrimitive(CURRENT_SAVE_VERSION));

		JsonObject definitiveObject = new JsonObject();
		JsonArray deQuests = new JsonArray();
		defintiveCompletedQuests.keySet().forEach(deQuests::add);

		JsonArray deUniques = new JsonArray();
		DE_UNIQUE_MONSTERS.forEach(deUniques::add);
		definitiveObject.add("completed_quests", deQuests);
		definitiveObject.add("unique_monsters", deUniques);

		JsonObject manuals = new JsonObject();
		JsonArray advanced = new JsonArray();

		for (Manual m : ADVANCED_MANUALS)
		{
			advanced.add(m.name);
		}

		JsonArray master = new JsonArray();

		for (Manual m : MASTER_MANUALS)
		{
			master.add(m.name);
		}

		manuals.add("advanced_manuals", advanced);
		manuals.add("master_manuals", master);
		definitiveObject.add("manuals", manuals);

		JsonArray achievements = new JsonArray();
		ACHIEVEMENTS.forEach(achievements::add);
		definitiveObject.add("achievements", achievements);

		JsonObject deCollectablesObject = new JsonObject();

		for (DELocation location : DE_COLLECTABLES.keySet())
		{
			JsonArray items = new JsonArray();
			var collectables = DE_COLLECTABLES.get(location);
			collectables.forEach(items::add);
			deCollectablesObject.add(location.name, items);
		}

		definitiveObject.add("collectables", deCollectablesObject);

		JsonArray deHeartToHearts = new JsonArray();
		DE_HEART_TO_HEARTS.forEach(deHeartToHearts::add);
		definitiveObject.add("heart_to_hearts", deHeartToHearts);

		JsonObject affinitiesObject = new JsonObject();

		for (Entry<String, Map<String, Affinity>> entry : AFFINITIES.entrySet())
		{
			String nameCharacter = entry.getKey();
			JsonObject characterObject = new JsonObject();

			for (Entry<String, Affinity> affinity : entry.getValue().entrySet())
			{
				characterObject.add(affinity.getKey(), new JsonPrimitive(affinity.getValue().name()));
			}

			affinitiesObject.add(nameCharacter, characterObject);
		}

		definitiveObject.add("affinities", affinitiesObject);
		mainObject.add("definitive_edition", definitiveObject);

		JsonObject xc2Object = new JsonObject();
		JsonArray xc2Quests = new JsonArray();
		xenoblade2CompletedQuests.forEach(xc2Quests::add);
		xc2Object.add("completed_quests", xc2Quests);
		mainObject.add("xenoblade_2", xc2Object);

		try (FileWriter writer = new FileWriter(selectedSaveFile))
		{
			gson.toJson(mainObject, writer);
			writer.flush();

			if (!autoSave)
				LOGGER.log("Successfully saved to " + selectedSaveFile);
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to write to the save file!");
			e.printStackTrace();
		}
	}

	/**
	 * <p>Will read the given {@code File} as a Json formatted file.</p>
	 * 
	 * <p>This clears all lists and maps that are used to store the completed items.</p>
	 * 
	 * @param fileToRead The file that is in Json format to read from.
	 */
	public static Result readFromFileWithJSON(File fileToRead)
	{
		selectedSaveFile = fileToRead;
		clearSavedItems();

		try (BufferedReader reader = new BufferedReader(new FileReader(selectedSaveFile)))
		{
			Gson gson = new Gson();
			JsonObject mainObject = gson.fromJson(reader, JsonObject.class);

			if (mainObject.has("version") && mainObject.get("version").getAsInt() < CURRENT_SAVE_VERSION)
				return Result.OUTDATED;

			// ====== START DEFINITIVE EDITION ========
			JsonObject definitiveObject = mainObject.get("definitive_edition").getAsJsonObject();
			JsonElement completedQuestsElement = definitiveObject.get("completed_quests");

			if (completedQuestsElement != null)
			{
				List<Integer> questIDs = gson.fromJson(completedQuestsElement, new TypeToken<List<Integer>>() {}.getType());

				for (Integer id : questIDs)
				{
					defintiveCompletedQuests.put(id, DEQuests.getQuestFromID(id));
				}

				LOGGER.log("Loaded the completed quests. " + defintiveCompletedQuests.size() + " quests are complete.");
			}
			else
			{
				LOGGER.warn("The completed quests object was missing from the save file!");
			}

			JsonElement uniqueMonstersElement = definitiveObject.get("unique_monsters");

			if (uniqueMonstersElement != null)
			{
				List<String> uniqueNames = gson.fromJson(uniqueMonstersElement, new TypeToken<List<String>>() {}.getType());
				uniqueNames.forEach(DE_UNIQUE_MONSTERS::add);
				LOGGER.log("Loaded the unique monsters defeated. " + DE_UNIQUE_MONSTERS.size() + " defeated uniques.");
			}
			else
			{
				LOGGER.warn("The unique monsters object was missing from the save file!");
			}

			JsonElement manualsElement = definitiveObject.get("manuals");

			if (manualsElement != null)
			{
				JsonObject manualsObject = gson.fromJson(manualsElement, JsonObject.class);
				JsonElement advancedManualsElement = manualsObject.get("advanced_manuals");

				if (advancedManualsElement != null)
				{
					List<String> advancedManuals = gson.fromJson(advancedManualsElement, new TypeToken<List<String>>() {}.getType());
					advancedManuals.stream().map(s -> Manuals.getManualFromName(ManualType.ADVANCED, s)).forEach(ADVANCED_MANUALS::add);
					LOGGER.log("Loaded advanced manuals. " + advancedManuals.size() + " advanced manuals obtained.");
				}
				else
				{
					LOGGER.warn("No advanced manuals were found in the save file!");
				}

				JsonElement masterManualsElement = manualsObject.get("master_manuals");

				if (masterManualsElement != null)
				{
					List<String> masterManuals = gson.fromJson(masterManualsElement, new TypeToken<List<String>>() {}.getType());
					masterManuals.stream().map(s -> Manuals.getManualFromName(ManualType.MASTER, s)).forEach(MASTER_MANUALS::add);
					LOGGER.log("Loaded master manuals. " + masterManuals.size() + " master manuals obtained.");
				}
				else
				{
					LOGGER.warn("No master manuals were found in the save file!");
				}
			}
			else
			{
				LOGGER.warn("The manuals object was missing from the save file!");
			}

			JsonElement achievementsElement = definitiveObject.get("achievements");

			if (achievementsElement != null)
			{
				List<String> achievements = gson.fromJson(achievementsElement, new TypeToken<List<String>>() {}.getType());
				achievements.forEach(ACHIEVEMENTS::add);
				LOGGER.log(String.format("Loaded the achievements completed. %d acheivements completed.", ACHIEVEMENTS.size()));
			}
			else
			{
				LOGGER.warn("The achievements object was missing from the save file!");
			}

			JsonElement collectablesElement = definitiveObject.get("collectables");

			if (collectablesElement != null)
			{
				JsonObject collectablesObject = collectablesElement.getAsJsonObject();

				for (DELocation location : DE_COLLECTABLES.keySet())
				{
					List<String> collectables = gson.fromJson(collectablesObject.get(location.name), new TypeToken<List<String>>() {}.getType());
					collectables.forEach(DE_COLLECTABLES.get(location)::add);
					LOGGER.log("Loaded " + collectables.size() + " collectables for the area " + location.name);
				}
			}
			else
			{
				LOGGER.warn("The collectables object was missing from the file!");
			}

			JsonElement hthElements = definitiveObject.get("heart_to_hearts");

			if (hthElements != null)
			{
				List<String> heartToHearts = gson.fromJson(hthElements, new TypeToken<List<String>>() {}.getType());
				heartToHearts.forEach(DE_HEART_TO_HEARTS::add);
				LOGGER.log("Loaded the heart-to-hearts viewed. " + DE_HEART_TO_HEARTS.size() + " heart-to-hearts viewed.");
			}
			else
			{
				LOGGER.warn("The heart-to-hearts object was missing from the save file!");
			}

			JsonElement affinitiesElement = definitiveObject.get("affinities");

			if (affinitiesElement != null)
			{
				Map<String, Map<String, Affinity>> affinityMappings = gson.fromJson(affinitiesElement, new TypeToken<Map<String, Map<String, Affinity>>>() {}.getType());

				for (Entry<String, Map<String, Affinity>> entries : affinityMappings.entrySet())
				{
					LOGGER.log("Loading " + entries.getKey() + "'s Affinities");

					for (Entry<String, Affinity> affinities : entries.getValue().entrySet())
					{
						LOGGER.log("Has " + affinities.getValue() + " with " + affinities.getKey());
					}

					AFFINITIES.put(entries.getKey(), entries.getValue());
				}
			}

			// ====== START XENOBLADE CHRONICLES 2 ========

			JsonObject xc2Object = mainObject.get("xenoblade_2").getAsJsonObject();
			JsonElement xc2CompletedQuests = xc2Object.get("completed_quests");

			if (xc2CompletedQuests != null)
			{
				List<Integer> questIDs = gson.fromJson(xc2CompletedQuests, new TypeToken<List<Integer>>() {}.getType());
				questIDs.forEach(xenoblade2CompletedQuests::add);
				LOGGER.log("Loaded the completed xenoblade 2 quests. " + xenoblade2CompletedQuests.size() + " quests are complete.");
			}
			else
			{
				LOGGER.warn("The completed xenoblade 2 quests object was missing from the save file!");
			}

			LOGGER.log("Successfully loaded the file '" + fileToRead + "'");
			return Result.SUCCESS;
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to load the save file '" + fileToRead + "'");
			e.printStackTrace();
			return Result.FAILED;
		}
	}

	/**
	 * This will convert the save file from Save Version 1 to Save Version 2 by creating a temporary file that is written to, then replacing the old file.
	 * 
	 * @return SUCCESS if the file is successfully converted to Save Version 2, otherwise, FAILED.
	 */
	public static Result convertSaveFile()
	{
		String name = selectedSaveFile.getAbsolutePath();
		String[] z = name.split("\\.");
		Path newPath = Paths.get(z[0] + ".temp.json");
		Path oldPath = Paths.get(name);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (BufferedReader reader = new BufferedReader(new FileReader(selectedSaveFile)); FileWriter writer = new FileWriter(new File(newPath.toUri())))
		{
			JsonObject newMainObject = new JsonObject();
			JsonObject oldMainObject = gson.fromJson(reader, JsonObject.class);
			int version = -1;

			if (oldMainObject.has("version"))
			{
				version = oldMainObject.get("version").getAsInt();
				oldMainObject.remove("version");
			}

			JsonPrimitive versionPrimitive = new JsonPrimitive(2);
			newMainObject.add("version", versionPrimitive);
			newMainObject.add("definitive_edition", oldMainObject);

			gson.toJson(newMainObject, writer);
			writer.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Result.FAILED;
		}

		try
		{
			Files.delete(Paths.get(oldPath.toUri()));
			Files.move(newPath, newPath.resolveSibling(name));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Result.FAILED;
		}

		return Result.SUCCESS;
	}

	/**
	 * Clears all of the mappings and lists that contain all of the items that have been selected.
	 */
	public static void clearSavedItems()
	{
		defintiveCompletedQuests.clear();
		DE_UNIQUE_MONSTERS.clear();
		ADVANCED_MANUALS.clear();
		MASTER_MANUALS.clear();
		ACHIEVEMENTS.clear();
		DE_HEART_TO_HEARTS.clear();
		AFFINITIES.clear();

		for (DELocation location : DE_COLLECTABLES.keySet())
		{
			DE_COLLECTABLES.get(location).clear();
		}
	}

	/**
	 * Saves the {@code opened} list to a file.
	 * 
	 * @param opened The list of all files that have been opened.
	 */
	public static void saveRecentFiles(List<String> opened)
	{
		try
		{
			Path pathToFile = Paths.get(RECENT_FILES.toURI());
			Files.write(pathToFile, opened, Charset.defaultCharset());
			LOGGER.log("Successfully saved the recently opened files to '" + RECENT_FILES.getCanonicalPath() + "'");
		}
		catch (IOException e)
		{
			LOGGER.error("Failed to savedto the recent files file! '" + RECENT_FILES.getAbsolutePath() + "'");
			e.printStackTrace();
		}
	}

	/**
	 * Attempts to load the recent files list to the {@code opened} list upon the program being opened.
	 * 
	 * @param opened The list to write all recent files to.
	 */
	public static void tryLoadRecentFiles(List<String> opened)
	{
		try
		{
			Files.lines(RECENT_FILES.toPath()).forEach(opened::add);
			LOGGER.log("Successfully loaded the recent files.");
		}
		catch (NoSuchFileException e)
		{
			LOGGER.warn("Failed to load the recentfiles.txt as it does not exist!");
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to load recentfiles.txt.");
			e.printStackTrace();
		}
	}

	/**
	 * When the recent files are cleared, the file that stores all the recently opened files is deleted.
	 */
	public static void deleteRecentFiles()
	{
		try
		{
			Path path = Paths.get(RECENT_FILES.toURI());

			if (Files.exists(path))
			{
				Files.delete(path);
				LOGGER.log("Deleted the recentfiles.txt");
			}
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to delete recentfiles.txt");
			e.printStackTrace();
		}
	}

	/**
	 * Writes all the settings to the configuration file.
	 */
	public static void writeToConfigurationFile()
	{
		try (PrintWriter writer = new PrintWriter(new FileWriter(CONFIG_FILE)))
		{
			writer.println("# The option for toggling the autosave feature.");
			writer.println("autosave=" + doAutosave.getAsBoolean());
			writer.println("# The option for toggling if recent files will be kept track of.");
			writer.println("keepTrackRecents=" + keepTrackRecents.getAsBoolean());
			writer.println("# The maximum number of recent files to keep in history.");
			writer.println("maxNumberOfRecents=" + maxNumberOfRecents.getAsInt());
			writer.print("language=" + currentLanguage.getAsString());
//			writer.print("oldQuests=" + useOldQuests);
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to write to the configuration file!");
			e.printStackTrace();
		}
	}

	/**
	 * Reads the configuration files to read the settings.
	 */
	public static void readConfigurationFile()
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE)))
		{
			String s = "";

			while ((s = reader.readLine()) != null)
			{
				if (!s.startsWith("#"))
				{
					String[] mappings = s.split("=");
					String key = mappings[0];
					String value = mappings[1];
					LOGGER.log("Reading line in configuration file.");
					LOGGER.log("Key: " + key + ", Value: " + value);

					if (key.equalsIgnoreCase("autosave"))
						doAutosave.setProperty(value.equalsIgnoreCase("true"));

					if (key.equalsIgnoreCase("keepTrackRecents"))
						keepTrackRecents.setProperty(value.equalsIgnoreCase("true"));

					if (key.equalsIgnoreCase("maxNumberOfRecents"))
						maxNumberOfRecents.setProperty(Integer.valueOf(value));

					if (key.equalsIgnoreCase("language"))
						currentLanguage.setProperty(value);

//					if (key.equalsIgnoreCase("oldQuests"))
//						useOldQuests = value.equalsIgnoreCase("true");
				}
			}
		}
		catch (FileNotFoundException e)
		{
			LOGGER.warn("Configuration file was not found.");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to read configuration file!");
			e.printStackTrace();
		}
	}

	public static void setProperty(Property property, Object value)
	{
		property.setProperty(value);
	}

	public static class Property
	{
		final Object defaultValue;
		Object currentValue;

		private Property(Object defaultValue)
		{
			this.defaultValue = defaultValue;
			this.currentValue = defaultValue;
		}

		protected void setProperty(Object object)
		{
			this.currentValue = object;
		}

		public boolean getDefaultAsBoolean()
		{
			return (Boolean) this.defaultValue;
		}

		public int getDefaultAsInt()
		{
			return (Integer) this.defaultValue;
		}

		public String getDefaultAsString()
		{
			return (String) this.defaultValue;
		}

		public boolean getAsBoolean()
		{
			return (Boolean) this.currentValue;
		}

		public int getAsInt()
		{
			return (Integer) this.currentValue;
		}

		public String getAsString()
		{
			return (String) this.currentValue;
		}

		public boolean isDefault()
		{
			return this.currentValue.equals(this.defaultValue);
		}
	}

	public static enum Result
	{
		OUTDATED,
		FAILED,
		SUCCESS;
	}
}