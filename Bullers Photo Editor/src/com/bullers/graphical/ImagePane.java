package com.bullers.graphical;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePane extends JPanel {

	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @name img
	 * @desc The image to be displayed in this panel
	 * @date June 1st, 2016
	 */
	BufferedImage img;
	
	/**
	 * @constructor 1
	 * @param img the image to be put on the panel
	 * @date June 1st, 2016
	 */
	public ImagePane(BufferedImage img) {
		this.img = img;
	}
	
	
	/**
	 * @well how else do you paint it?
	 */
	protected void paintComponent(Graphics g) {
		g.drawImage(this.img, 0, 0, null);
	}
}
