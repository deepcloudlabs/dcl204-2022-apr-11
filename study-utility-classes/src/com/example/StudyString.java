package com.example;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyString {

	public static void main(String[] args) {
		String city = "izmir";
		var tr = new Locale("tr", "TR");
		System.out.println(city.toUpperCase(tr));
        
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dateTimeFormatter = 
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.JAPAN);
		System.out.println(dateTimeFormatter.format(now));
		
		double money = 12_345.67;
		DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.JAPAN);
		System.out.println(decimalFormat.format(money));

	}

}
