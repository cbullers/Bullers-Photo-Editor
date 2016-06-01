package com.bullers.image;

import java.util.List;

/**
 * @class ImageKernel
 * @desc The key part in the image modifying algorithm, provides instructions in pixel manipulation.
 * @date May 30th, 2016
 */
public class ImageKernel {

	/**
	 * @name kernel
	 * @desc List that has all doubles to multiply nearby pixels, in order
	 * from 0-24
	 * @date June 1st, 2016
	 */
	public List<Double> kernel;
	
	/**
	 * @constructor 1
	 * @desc Give it all values for a kernel
	 * @date June 1st, 2016
	 */
	public ImageKernel(double... manipulator) {
		for(double i : manipulator) {
			kernel.add(i);
		}
	}
	
	/**
	 * @constructor 2
	 * @desc Takes a list and sets the kernel to that
	 * @date June 1st, 2016
	 */
	public ImageKernel(List<Double> list) {
		kernel = list;
	}
	
	/**
	 * @name get
	 * @param name
	 * @desc Gets an image kernel that is a defined thing, idk?
	 * @date June 1st, 2016
	 * @throws ImageKernelNotFoundException if the string is not found.
	 */
	public static ImageKernel get(String name) throws ImageKernelNotFoundException {
		// Switch for the name
		if(name.equalsIgnoreCase("gaussian-blur")) {
			// Create the List that will hold the values
			//List<Double> tmp = new ArrayList<Double>();
			
			
			return new ImageKernel();
		}else if(name.equalsIgnoreCase("sharpen")) {
			
		}else if(name.equalsIgnoreCase("bottom-sobel")) {
			
		}else if(name.equalsIgnoreCase("top-sobel")) {
			
		}else if(name.equalsIgnoreCase("right-sobel")) {
			
		}else if(name.equalsIgnoreCase("outline")) {
			
		}else if(name.equalsIgnoreCase("identity")) {
			
		}else if(name.equalsIgnoreCase("left-sobel")) {
			
		}else if(name.equalsIgnoreCase("emboss")) {
			
		}else{
			// Kernel requested is not in database
			throw new ImageKernelNotFoundException(name + " is not a recognized ImageKernel... Someone goofed...");
		}
		
		// And whack it to em
		return null;
	}
	
}