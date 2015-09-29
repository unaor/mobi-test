package com.uri.mobi.service;

/**
 * Service responsible for formatting a given number. 
 * @author unaor
 *
 */
public interface NumberPrettifier {
	
	public static final long MEGA = 1000000;
	public static final long GIGA = 1000000000;
	public static final long TERA = 1000000000000l;
	
	/**		
	 * Method is responsible to receive a number and format it
	 * @param numberToPrettify - The number to prettify
	 * @return prettified version of the number
	 */
	public String prettify(float numberToPrettify);

}
