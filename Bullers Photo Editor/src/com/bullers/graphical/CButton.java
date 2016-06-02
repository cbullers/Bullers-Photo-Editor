package com.bullers.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CButton extends JButton {

	/**
	 * Default Serial
	 */
	private static final long serialVersionUID = 1L;

	public CButton(int x, int y, int w, int h, String title, ActionListener listener, Color bgColor) {
		this.setBounds(x,y,w,h);
		this.setText(title);
		this.addActionListener(listener);
		this.setBackground(bgColor);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
