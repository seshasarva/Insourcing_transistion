package com.insourcing.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateHelper {
	public static Date setCurrentDate(String dateFormat, String zoneId) {
		Date currentDate = null;
		try {
			currentDate = new SimpleDateFormat(dateFormat)
					.parse(DateTimeFormatter.ofPattern(dateFormat).format(ZonedDateTime.now(ZoneId.of(zoneId))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	private DateHelper() {
		super();
	}

	public static String getIndianCurrencyFormat(String amount) {
		StringBuilder stringBuilder = new StringBuilder();
		char amountArray[] = amount.toCharArray();
		int a = 0, b = 0;
		for (int i = amountArray.length - 1; i >= 0; i--) {
			if (a < 3) {
				stringBuilder.append(amountArray[i]);
				a++;
			} else if (b < 2) {
				if (b == 0) {
					stringBuilder.append(",");
					stringBuilder.append(amountArray[i]);
					b++;
				} else {
					stringBuilder.append(amountArray[i]);
					b = 0;
				}
			}
		}
		return stringBuilder.reverse().toString();
	}

}
