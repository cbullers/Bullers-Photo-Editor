package com.bullers.initial;

import com.bullers.extra.Window;
import com.bullers.graphical.GraphicObjects;
import com.bullers.lang.Language;

public class Initialization {

	public static void main(String[] args) {

		// Call the initial method
		initializeOpeningWindow();

	}
	
	/**
	 * @name initializeOpeningWindow
	 * @desc Inits the opening window, where it asks you what you want to do, etc...
	 * @date May 30th, 2016
	 */
	public static void initializeOpeningWindow() {
		
		Window tmp = new Window(50,50,500,300,Language.getLanguage().getString("openingTitle"));
		tmp.center();
		
		// Set er up
		GraphicObjects.initialWindow = tmp;
		GraphicObjects.initialWindow.setVisible(true);
		
	}

}
