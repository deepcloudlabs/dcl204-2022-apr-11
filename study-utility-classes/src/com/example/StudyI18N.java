package com.example;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyI18N {

	public static void main(String[] args) {
		//                           "base name" is messages  
		// i18n -> ResourceBundle -> messages_tr_TR.properties
		//                           messages_en_US.properties
		//                           messages_en_UK.properties
		Locale tr = Locale.US; //new Locale("tr", "TR");
		ResourceBundle resourceBundle = ResourceBundle.getBundle("messages",tr);
		var message = resourceBundle.getString("label.generate.time");
		var formatter = new MessageFormat(message); 
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dateTimeFormatter = 
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(tr);
		var time = dateTimeFormatter.format(now);
		System.out.println(formatter.format(new Object[] {time}));
	}

}
