package com.bullers.image;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.Arrays;
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
		// Initialize the kernel list
		this.kernel = new ArrayList<Double>();
		
		for(double i : manipulator) {
			kernel.add(Double.valueOf(i));
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
	 * @name getDouble array
	 * @desc Returns multi-dimensional array of this kernel
	 * @return Double array of the image kernel
	 */
	public double[][] toDoubleArray() {
		double[][] ret = new double[5][5];
		int row = 0;
		int index = 0;
		
		for(int i = 0; i < this.kernel.size(); i++) {
			if(row >= 5) break;
			if(i % 5 == 0 && i != 0) { row++; index = 0; }
			ret[row][index] = this.kernel.get(i);
			index++;
		}
		
		return ret;
	}
	
	/**
	 * @name toNative
	 * @desc Converts ImageKernel to native AWT Kernel, used in ExtendedImage class
	 * @return java.awt.image.Kernel
	 */
	public Kernel toNative() {
		float[] tmp = new float[25];
		int index = 0;
		
		for(double d : this.kernel) {
			tmp[index] = (float)d;
			index++;
		}
		
		Kernel ret = new Kernel(5,5, tmp);
		return ret;
	}
	
	/**
	 * @name print
	 * @desc Prints the kernel object to STDOUT
	 * @date June 2nd, 2016
	 */
	public void print() {
		for(double[] d : this.toDoubleArray()) {
			System.out.println(Arrays.toString(d));
		}
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
		if(name.equalsIgnoreCase("blur")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, .0625, .125, .0625, 0,
					   0, .125, .25, .125, 0,
					   0, .0625, .125, .0625, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("sharpen")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, 0, -1, 0, 0,
					   0, -1, 5, -1, 0,
					   0, 0, -1, 0, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("bottom-sobel")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, -1, -2, -1, 0,
					   0, 0, 0, 0, 0,
					   0, 1, 2, 1, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("top-sobel")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, 1, 2, 1, 0,
					   0, 0, 0, 0, 0,
					   0, -1, -2, -1, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("right-sobel")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, -1, 0, 1, 0,
					   0, -2, 0, 2, 0,
					   0, -1, 0, 1, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("outline")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, -1, -1, -1, 0,
					   0, -1, 8, -1, 0,
					   0, -1, -1, -1, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("identity")) { // this just returns the original image when applied
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, 0, 0, 0, 0,
					   0, 0, 1, 0, 0,
					   0, 0, 0, 0, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("left-sobel")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, 1, 0, -1, 0,
					   0, 2, 1, -2, 0,
					   0, 1, 0, -1, 0,
					   0, 0, 0, 0, 0);
			
		}else if(name.equalsIgnoreCase("emboss")) {
			// Return a new ImageKernel
			return new ImageKernel(
					   0, 0, 0, 0, 0,
					   0, -2, -1, 0, 0,
					   0, -1, 1, 1, 0,
					   0, 0, 1, 2, 0,
					   0, 0, 0, 0, 0);
			
		}else{
			// Kernel requested is not in database
			throw new ImageKernelNotFoundException(name + " is not a recognized ImageKernel... Someone goofed...");
		}
	}
	
}