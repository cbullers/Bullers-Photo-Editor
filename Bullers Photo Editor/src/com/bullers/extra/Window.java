package com.bullers.extra;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.bullers.graphical.CButton;
import com.bullers.graphical.ImagePane;
import com.bullers.screen.Screen;

/*
 * @class Window
 * @desc One field of a JFrame, and an arraylist of other componenets
 * on the JFrame
 * @date May 30th, 2016
 */
public class Window extends JFrame {

	/**
	 * Default Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @name components
	 * @desc List of all components that are on the @mainFrame
	 * @date May 30th, 2016
	 */
	public List<JComponent> components;
	
	/**
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
		this.setLayout(null);
		
		// Set the title
		this.setTitle(title);
		
		// All windows get same icon
		this.setIconImage(new ImageIcon(this.getClass().getResource("/resources/BPE.png")).getImage());
		
		// Initialize the component list
		components = new ArrayList<JComponent>();
	}
	
	/**
	 * @name center
	 * @desc Takes half the width of this frame, and puts it in the center of the screen, 
	 * effectively centering the frame on the screen
	 * @date May 30th, 2016
	 */
	public void center() {
		this.setLocation((Screen.getWidth()/2)-(this.getWidth()/2), (Screen.getHeight()/2)-(this.getHeight()/2));
	}
	
	/**
	 * @method addButton
	 * @desc Creates a button with desired width and height
	 * @param 
	 */
	public void addButton(int x, int y, int w, int h, String title, ActionListener listener, Color bgColor) {
		CButton b = new CButton(x,y,w,h,title,listener, bgColor);
		this.getContentPane().add(b);
	}
	
	/**
	 * @name addImage
	 * @desc Adds image to window at desired location....
	 * @param x the x pos
	 * @param y the y pos
	 * @param w the width
	 * @param h the height
	 * @param img the image itself
	 */
	public void addImage(int x, int y, int w, int h, BufferedImage img) {
		ImagePane imgPane = new ImagePane(getScaledImage(img, w, h));
		imgPane.setBounds(x,y,w,h);
		this.getContentPane().add(imgPane);
	}
	
	 /**
	 * Resizes an image using a Graphics2D object backed by a BufferedImage.
	 * @param srcImg - source image to scale
	 * @param w - desired width
	 * @param h - desired height
	 * @return - the new resized image
	 * @obtained alain.janinm (http://stackoverflow.com/users/1140748/alain-janinm) June 1st, 2016
	 */
	private BufferedImage getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
}
