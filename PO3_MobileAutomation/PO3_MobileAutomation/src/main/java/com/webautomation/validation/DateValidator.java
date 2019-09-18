package com.webautomation.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateValidator {

	/**
	 * This function returns a boolean to validate the latest report is within the last 12 months
	 * @param dateToValidate
	 * @return
	 * @throws ParseException
	 */
	public boolean isThisDateWithin12MonthsRange(String dateToValidate) throws ParseException {

		
//		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		//Format Date from the UI ex: 08/12/2016
		SimpleDateFormat dateFromUi = new SimpleDateFormat("MM/dd/yyyy");
		
		//Reformat the Date from the UI to create the PDF file 20160812
		SimpleDateFormat downloadDate = new SimpleDateFormat("yyyyMMdd");
		
		//Reformated string to match the downloaded format Ex: 20160812
		String reformattedStr = null;
		
		//The invoice string reformated
		reformattedStr = downloadDate.format(dateFromUi.parse(dateToValidate));
		System.out.println("reformattedStr " + reformattedStr);
	    
		//Reformat the Date from the UI to create the PDF file 20160812
		String dateFormat = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);


		try {
//			Ex: of dateToValidate="20160812";
			// if not valid, it will throw ParseException
			Date date = sdf.parse(reformattedStr);

			// current date after 12 months
			Calendar currentDateAfter12Months = Calendar.getInstance();
			currentDateAfter12Months.add(Calendar.MONTH, 12);

			// current date before 12 months
			Calendar currentDateBefore12Months = Calendar.getInstance();
			currentDateBefore12Months.add(Calendar.MONTH, -12);

			/*************** verbose ***********************/
			System.out.println("\n\ncurrentDate : "	+ Calendar.getInstance().getTime());
			System.out.println("currentDateAfter12Months : " + currentDateAfter12Months.getTime());
			System.out.println("currentDateBefore12Months : " + currentDateBefore12Months.getTime());
			System.out.println("dateToValidate : " + dateToValidate);
			/************************************************/

			if (date.before(currentDateAfter12Months.getTime())	&& date.after(currentDateBefore12Months.getTime())) {

				// returns true - if date is in last 12 month range 
				return true;

			} else {
				
				return false;

			}

		} catch (ParseException e) {
			// returns false - if date is not in last 12 month range 
			e.printStackTrace();
			return false;
		}

	}

}
