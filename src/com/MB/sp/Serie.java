package com.MB.sp;
import java.util.Date;

public class Serie {
	private String name;
	private String channel;
	private Date nextDate;
	private String country;
	private Date[] dates;
	private int season;
/*
 * @param n Der Name der Serie
 * @param c Der Sender der Serie
 * @param co Das Land der Serie
 * @param d Die Daten der Ausstrahlung
 * @param s Die Staffel der Serie
 * 
 * */
	public Serie(String n, String c, String co, Date[] d, int s) {
		name = n;
		channel = c;
		country = co;
		dates = d;
		season = s;
		nextDate = DateHelper.getNextDate(dates);
	}

	public String getName() {
		return name;
	}

	public String getChannel() {
		return channel;
	}

	public Date getNextDate() {
		return nextDate;
	}

	public String getCountry() {
		return country;
	}

	public Date[] getDates() {
		return dates;
	}

	public int getSeason() {
		return season;
	}
}
