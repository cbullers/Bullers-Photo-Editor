package com.bullers.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;

public class ExtendedImage {

	/**
	 * @name transform
	 * @param kernel what to transform the image with
	 * @desc transforms an image with a specific kernel/matrix, doesn't work with zero center values
	 * @date June 1st, 2016
	 */
	public static BufferedImage transform(BufferedImage img, ImageKernel kernel) {
		
		// The return image
		BufferedImage ret = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		// The filter for the image
		BufferedImageOp f = new ConvolveOp(kernel.toNative(), ConvolveOp.EDGE_NO_OP, null);
		
		// Filter the image with the kernel
		f.filter(img, ret);
		
		// And ship it off
		return ret;
	}
	
	/**
	 * @name transformBAD
	 * @desc Do I get an A for effort?
	 * @param img
	 * @param kernel
	 * @return nothing, just dont try
	 * @deprecated
	 * @date June 2nd, 2016
	 */
	public static BufferedImage transformBAD(BufferedImage img, ImageKernel kernel) {
		
		// The returning image
		BufferedImage ret = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		// For easier access
		double[][] matrix = kernel.toDoubleArray();
		
		// Create color channels
		Color[][] colors = new Color[img.getWidth()][img.getHeight()];
		
		// Set them
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				
				// Get color
				colors[x][y] = new Color(img.getRGB(x, y));
				
			}
		}
		
//		for(int x = 0; x < img.getWidth(); x++) {
//			for(int y = 0; y < img.getHeight(); y++) {
//				
//				// Get values
//				ret.setRGB(x, y, colors[x][y].getRGB());
//				
//			}
//		}

		// test
//		int n = 100;
//		int[][] surrounding = new int[5][5];
//		for(int x = 0; x <= 4; x++) {
//			for(int y = 0; y <= 4; y++) {
//				surrounding[x][y] = colors[n-x][n-y].getBlue();
//			}
//		}
//		for(int[] i : surrounding) {
//			System.out.println(Arrays.toString(i));
//		}
//		
//		for(int mx = 0; mx < 5; mx++) {
//			for(int my = 0; my < 5; my++) {
//				surrounding[mx][my] *= matrix[mx][my];
//				surrounding[mx][my] /= 25;
//			}
//		}
//		
//		System.out.println();
//		for(int[] i : surrounding) {
//			System.out.println(Arrays.toString(i));
//		}
		
		
		// Calculate averages
		for(int x = 0; x < img.getWidth()-2; x++) {
			for(int y = 0; y < img.getHeight()-2; y++) {
				
				// for now, until better solution
				if(x-2 < 0 || y-2 < 0 || x+2 > img.getWidth() || y+2 > img.getHeight()) { continue; } // basically ignoring pixels out of range
				
				int newRed, newGreen, newBlue = newRed = newGreen = newBlue = 0;
				
				// Loop through the surrounding pixels
				for(int i = 2; i >= -2; i--) {
					for(int j = 2; j >= -2; j--) {
						
						// Loop through the kernel
						for(int k = 0; k < 5; k++) {
							for(int l = 0; l < 5; l++) {
								
								newRed += (colors[x-i][y-j].getRed() * matrix[k][l]);
								newBlue += (colors[x-i][y-j].getBlue() * matrix[k][l]);
								newGreen += (colors[x-i][y-j].getGreen() * matrix[k][l]);
								
							}
						}
					}
				}
				
				// Average them
				newRed /= 25;
				newGreen /= 25;
				newBlue /= 25;
				
				// Set the value
				Color newColor = new Color(newRed,newGreen,newBlue);
				ret.setRGB(x, y, newColor.getRGB());
				
			}
		}
		
		// Return it
		return ret;
		
	}
	
}
