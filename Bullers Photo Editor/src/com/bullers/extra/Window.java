package com.bullers.extra;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.bullers.screen.Screen;

/*
 * @class Window
 * @desc One field of a JFrame, and an arraylist of other componenets
 * on the JFrame
 * @date May 30th, 2016
 */
public class Window extends JFrame {

	/*
	 * Default Serial
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @name components
	 * @desc List of all components that are on the @mainFrame
	 * @date May 30th, 2016
	 */
	public List<JComponent> components;
	
	/*
	 * @constructor 1, takes 4 parameters
	 * @param x: x position on screen
	 * @param y: y position on screen
	 * @param w: width of main frame
	 * @param h: height of main frame
	 * @param title: title of the frame
	 * @date May 30th, 2016
	 */
	public Window(int x, int y, int w, int h, String title) {
		this.setBounds(x,y,w,h);
		
		// This is usually the desired effect
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the title
		this.setTitle(title);
		
		// All windows get same icon
		this.setIconImage(new ImageIcon(this.getClass().getResource("/resources/BPE.png")).getImage());
		
		// Initialize the component list
		components = new ArrayList<JComponent>();
	}
	
	/*
	 * @name center
	 * @desc Takes half the width of this frame, and puts it in the center of the screen, 
	 * effectively centering the frame on the screen
	 * @date May 30th, 2016
	 */
	public void center() {
		this.setLocation((Screen.getWidth()/2)-(this.getWidth()/2), (Screen.getHeight()/2)-(this.getHeight()/2));
	}
	
	/*
	 * @method addButton
	 * @desc Creates a button with desired width and height
	 * @param 
	 */
}
