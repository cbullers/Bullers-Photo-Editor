package com.bullers.image;

/**
 * @class ImageKernelNotFoundException
 * @desc Exception that can be thrown when an ImageKernel is not found
 * @date June 1st, 2016
 */
public class ImageKernelNotFoundException extends Exception {

	/*
	 *  Default Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @constructor 1
	 * @desc Just default constructor
	 * @date June 1st, 2016
	 */
	public ImageKernelNotFoundException() {
		super("Image kernel not found! Look at docs...");
	}
	
	/**
	 * @constructor 2
	 * @desc Custom message
	 * @date June 1st, 2016
	 */
	public ImageKernelNotFoundException(String msg) {
		super(msg);
	}
	
}
