package com.bullers.screen;

import java.awt.Toolkit;

/*
 * @class Screen
 * @desc Provides useful information about the screen
 * @date May 30th, 2016
 */
public class Screen {

	/*
	 * @name getWidth
	 * @desc Returns the width of the screen
	 * @date May 30th, 2016
	 */
	public static int getWidth() {
		return (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	}
	
	/*
	 * @name getHeight
	 * @desc Returns the height of the screen
	 * @date May 30th, 2016
	 */
	public static int getHeight() {
		return (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	
}
