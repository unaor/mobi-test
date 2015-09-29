package com.uri.mobi.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
/*		
 * Class that implements the prettify method.
 */
public class NumberPrettifierImpl implements NumberPrettifier {

	private final DecimalFormat df = new DecimalFormat();

	public NumberPrettifierImpl() {
		df.setMaximumFractionDigits(1);
		df.setGroupingUsed(false);
	}

	public String prettify(float numberToPrettify) {
		// first lets evaluate the number size
		BigDecimal number = new BigDecimal(numberToPrettify);
		if (isLessThanMega(number)) {
			// TODO: optimize to check if decimal digits exists, if no we can
			// return the number without formatting
			return df.format(number);
			//lets check if its a really big number (TERA)
		} else if (isMoreThanTeraNumber(number)) {
			return formatTeraNumber(number);
			//lets see if its in the MEGA range
		} else if (isMegaNumber(number)) {
			return formatMegaNumber(number);
		} else{
			return formatGigaNumber(number);
		}
		
	}

	private boolean isLessThanMega(BigDecimal number) {
		// TODO : change to private and use reflection for testing.
		if (number.longValue() / NumberPrettifier.MEGA > 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isMoreThanTeraNumber(BigDecimal number) {
		if (number.longValue() / NumberPrettifier.TERA < 1) {
			return false;
		} else {
			return true;
		}

	}

	private String formatTeraNumber(BigDecimal number) {

		float choppedNumber = number.floatValue() / NumberPrettifier.TERA;
		String formattedNumber = df.format(choppedNumber);
		return formattedNumber + "T";
	}

	private boolean isMegaNumber(BigDecimal number) {
		if (number.longValue() / NumberPrettifier.MEGA > 0 && number.longValue() / NumberPrettifier.GIGA < 1) {
			return true;
		} else {
			return false;
		}
	}

	private String formatMegaNumber(BigDecimal number) {

		float choppedNumber = number.floatValue() / NumberPrettifier.MEGA;
		String formattedNumber = df.format(choppedNumber);
		return formattedNumber + "M";
	}
	
	private String formatGigaNumber(BigDecimal number) {

		float choppedNumber = number.floatValue() / NumberPrettifier.GIGA;
		String formattedNumber = df.format(choppedNumber);
		return formattedNumber + "B";
	}

}
