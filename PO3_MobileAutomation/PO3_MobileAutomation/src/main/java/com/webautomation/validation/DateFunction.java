package com.webautomation.validation;

import java.util.Calendar;
import java.util.Date;

public class DateFunction {
	
	 
	  public java.util.Date myDate() {
		  Date validdate = null;
	    //create Calendar instance
	    Calendar now = Calendar.getInstance();
	    now.setTime(new Date());
	    for(int i=1;i<10;i++) {
	    now.add(Calendar.DATE,i+3);
	    System.out.println("Current day is : " +now.getTime()+(isWeekEnd(now.getTime())));
	    if(isWeekEnd(now.getTime())) {
	    	
	     validdate=now.getTime();
	     System.out.println("inside date function"+ validdate);
	     
	    }
	    else{
	    	validdate=now.getTime();
	    	break;
	    }
	    }
	    return validdate;
		
		
	  }
	  
	  public java.util.Date previousDate() {
			 
		    //create Calendar instance
		    Calendar now = Calendar.getInstance();
		    now.setTime(new Date());
		    now.add(Calendar.DATE, -1);
		    System.out.println("Current day is : " +now.getTime()+(isWeekEnd(now.getTime())));
			return now.getTime();
		  }
	  
	  public static boolean isWeekEnd(java.util.Date date){
	      Calendar cal = Calendar.getInstance();
	      cal.setTime(date);
	      if(isValidDate(date) && (cal.get(Calendar.DAY_OF_WEEK) ==Calendar.FRIDAY ||
	              cal.get(Calendar.DAY_OF_WEEK) ==Calendar.SATURDAY ||
	              cal.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY  ))
	              {
	    	  
	          return true;
	      }else{
	          return false;
	      }
	  }
	  
	  /*public static boolean ispublicholiday(java.util.Date date){
	      Calendar cal = Calendar.getInstance();
	      cal.setTime(date);
	      if(isValidDate(date) && (cal.get(Calendar.DAY_OF_MONTH) ==Calendar.DAY_OF_MONTH||
	              cal.get(Calendar.DAY_OF_MONTH) ==Calendar.SATURDAY ||
	              cal.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY)){
	          return true;
	      }else{
	          return false;
	      }
	  }*/

	private static boolean isValidDate(java.util.Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date(0));
	    calendar.add(Calendar.DATE, 4);
	    if(date.before(calendar.getTime())){
	        return true;
	    }else{
	        return false;
	    }
	    
	}
	public java.util.Date inValidDate() {
		 
	    //create Calendar instance
	    Calendar now = Calendar.getInstance();
	    now.setTime(new Date());
	    now.add(Calendar.DATE, 46);
	    System.out.println("Current day is : " +now.getTime()+(isWeekEnd(now.getTime())));
		return now.getTime();
	  }
	public static java.util.Date holiday() {
		 
	    //create Calendar instance
	    Calendar now = Calendar.getInstance();
	    now.setTime(new Date());
	    now.add(Calendar.DATE, 55);
	    System.out.println("Current day is : " +now.getTime()+(isWeekEnd(now.getTime())));
		return now.getTime();
	  }
	}


