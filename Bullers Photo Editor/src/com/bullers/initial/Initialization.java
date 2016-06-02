package com.bullers.initial;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	public static void initializeOpeningWindow(){
		
		Window tmp = new Window(50,50,290,280,Language.getLanguage().getString("openingTitle"));
		tmp.getContentPane().setBackground(Color.darkGray);
		tmp.center();
		tmp.setResizable(false);
		tmp.addButton(10, 10, 300-35, 50, "New...", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}}, Color.lightGray);
		
		tmp.addButton(10, 70, 300-35, 50, "Open...", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}, new Color(17, 105, 68));
		
		tmp.addButton(10, 130, 300-35, 50, "Recents...", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}, new Color(159,145,179));
		
		tmp.addButton(10, 190, 300-35, 50, "Exit...", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}, new Color(158, 101, 89));
		
		// Set er up
		GraphicObjects.initialWindow = tmp;
		GraphicObjects.initialWindow.setVisible(true);
		
	}

}
