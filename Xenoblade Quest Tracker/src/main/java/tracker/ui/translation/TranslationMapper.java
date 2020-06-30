package tracker.ui.translation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import tracker.ui.MainFrame;

public class TranslationMapper
{
	private final Map<String, String> mappedTranslations = new HashMap<String, String>();
	public final String language;

	public TranslationMapper(String languageName)
	{
		this.language = languageName;
	}

	private String getTranslatedValue(String key)
	{
		String s = this.mappedTranslations.get(key);
		return s == null ? key : s;
	}

	public String formatString(String message, Object... arguments)
	{
		String translatedValue = this.getTranslatedValue(message);

		try
		{
			return String.format(translatedValue, arguments);
		}
		catch (IllegalFormatException e)
		{
			return "Couldn't translate " + message;
		}
	}

	public void loadTranslations()
	{
		try
		{
			Properties properties = new Properties();
			properties.load(new InputStreamReader(new FileInputStream(new File(MainFrame.getResource("lang/" + this.language + ".lang").toURI())), StandardCharsets.UTF_8));

			for (Entry<Object, Object> entry : properties.entrySet())
			{
				this.mappedTranslations.put((String) entry.getKey(), (String) entry.getValue());
			}

			properties.clear();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}