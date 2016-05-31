package com.bullers.extra;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * @class GraphicDescription
 * @desc Provides graphic information for different
 * components in Swing, mainly used in custom components
 * @date May 30th, 2016
 */
public class GraphicDescription {

	/*
	 * @name bgColor
	 * @desc Field for the background color of a component
	 * @date May 30th, 2016
	 */
	public Color bgColor;
	
	/*
	 * @name fgColor
	 * @desc Field for the foreground color of a component
	 * @date May 30th, 2016
	 */
	public Color fgColor;
	
	/*
	 * @name bounds
	 * @desc The x, y, width, and height of a component
	 * @date May 30th, 2016
	 */
	public Rectangle bounds;
	
	/*
	 * @constructor 1
	 * @param bgColor: Background color
	 * @date May 30th, 2016
	 */
	public GraphicDescription(Color bgColor) {
		this.bgColor = bgColor;
	}
	
	/*
	 * @constructor 2
	 * @param bgColor: Background color
	 * @param fgColor: Foreground color
	 * @date May 30th, 2016
	 */
	public GraphicDescription(Color bgColor, Color fgColor) {
		this.bgColor = bgColor;
		this.fgColor = fgColor;
	}
	
	/*
	 * @constructor 3
	 * @param bgColor: Background color
	 * @param fgColor: Foreground color
	 * @param bounds: Where, and how big
	 * @date May 30th, 2016
	 */
	public GraphicDescription(Color bgColor, Color fgColor, Rectangle bounds) {
		this.bgColor = bgColor;
		this.fgColor = fgColor;
		this.bounds = bounds;
	}
	
}
