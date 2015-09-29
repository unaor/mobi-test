package com.uri.mobi.service;

public interface NumberPrettifier {
	
	public static final long MEGA = 1000000;
	public static final long GIGA = 1000000000;
	public static final long TERA = 1000000000000l;
	
	public String prettify(float numberToPrettify);

}
