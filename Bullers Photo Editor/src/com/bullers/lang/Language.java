package com.bullers.lang;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

	/*
	 * @name currentLocale
	 * @desc The location, locale of the current program user
	 * @date May 30th, 2016
	 */
	static Locale currentLocale = new Locale("en","US");
	
	/*
	 * @name getLangauge
	 * @desc Returns the default language for the program
	 * @returns new Language object
	 * @date May 30th, 2016
	 */
	public static ResourceBundle getLanguage() {
		// Define the resource bundle to get language
		ResourceBundle language = ResourceBundle.getBundle("resources/Language",currentLocale);
		return language;
	}
	
}
