package tracker.ui.translation;

public class I18n
{
	private static TranslationMapper translationMapper;

	public static void setCurrentLanguage(TranslationMapper mapper)
	{
		translationMapper = mapper;
	}

	public static String format(String untranslatedString, Object... arguments)
	{
		return translationMapper.formatString(untranslatedString, arguments);
	}
}