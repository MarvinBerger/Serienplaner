package com.MB.sp;
import java.util.Date;


public class DateHelper {
	public static  String[] tage = new String[]{"", "Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
	public static Date getNextDate(Date[] d)
	{
		long now = System.currentTimeMillis();
		Date next = new Date(0);
		long diff=now;
		for(Date tmp: d)
			if((tmp.getTime()-now)<diff && (tmp.getTime()-now)>0)
			{
				next = tmp;
				diff = tmp.getTime()-now;
			}
		if(next.getTime()==0)
			return null;
		return next;
	}
	public static Serie[] sortByDate(Serie[] serien)
	{
		java.util.Arrays.sort(serien);
		return serien ;
	}
}
