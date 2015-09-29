package com.uri.mobi.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

public class PretiffierTest {
	
	NumberPrettifierImpl numberPrettifier = new NumberPrettifierImpl();
	
	@Test
	public void decimalFormatTest(){
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		//df rounds up by default
		
		float number = 30.654f;
		assertEquals(String.valueOf(30.7), df.format(number));
		
	}
	
	@Test
	public void isNumberBiggerThanMega(){
		BigDecimal number  = new BigDecimal(300);
		assertTrue(numberPrettifier.isLessThanMega(number));
		number = new BigDecimal(65000);
		assertTrue(numberPrettifier.isLessThanMega(number));
		number = new BigDecimal(650000);
		assertTrue(numberPrettifier.isLessThanMega(number));
		number = new BigDecimal(6500000);
		assertFalse(numberPrettifier.isLessThanMega(number));
		
	}
	
	@Test
	public void prettifySmallNumber(){
		
		assertEquals("32.8", numberPrettifier.prettify(32.765765f));
		assertEquals("32.7", numberPrettifier.prettify(32.735765f));
		assertEquals("32", numberPrettifier.prettify(32.00654f));
		assertEquals("999999.3", numberPrettifier.prettify(999999.326f));
		assertEquals("999999.9", numberPrettifier.prettify(999999.966f));
		
	}
	
	@Test
	public void prettifyTeraNumber(){
		assertEquals("1.3T", numberPrettifier.prettify(1280000000000.876f));
		assertEquals("12.8T", numberPrettifier.prettify(12800070000000.876f));
	}
	
	@Test
	public void isMegaNumber(){
		BigDecimal number  = new BigDecimal(2000000);
		assertTrue(numberPrettifier.isMegaNumber(number));
		number  = new BigDecimal(2000000.76575);
		assertTrue(numberPrettifier.isMegaNumber(number));
		number  = new BigDecimal(20000000);
		assertTrue(numberPrettifier.isMegaNumber(number));
		number  = new BigDecimal(200000000);
		assertTrue(numberPrettifier.isMegaNumber(number));
		number  = new BigDecimal(2000000000);
		assertFalse(numberPrettifier.isMegaNumber(number));
	}
	
	@Test
	public void prettifyMegaNumber(){
		assertEquals("1.3M", numberPrettifier.prettify(1280000f));
		assertEquals("12.8M", numberPrettifier.prettify(12800070.876f));
	}
	
	@Test
	public void testAllCases(){
		assertEquals("1.3", numberPrettifier.prettify(1.2668f));
		assertEquals("123456", numberPrettifier.prettify(123456f));
		assertEquals("1.2M", numberPrettifier.prettify(1234567f));
		assertEquals("1.3M", numberPrettifier.prettify(1284567f));
		assertEquals("11.3M", numberPrettifier.prettify(11284567f));
		assertEquals("112.1M", numberPrettifier.prettify(112084567f));
		assertEquals("1B", numberPrettifier.prettify(1020845670f));
		assertEquals("11.1B", numberPrettifier.prettify(11070845670f));
		assertEquals("113.1B", numberPrettifier.prettify(113070845670f));
		assertEquals("1T", numberPrettifier.prettify(1013070845670f));
		assertEquals("11T", numberPrettifier.prettify(11013070845670f));
		assertEquals("113.4T", numberPrettifier.prettify(113383070845670f));
	}

}
