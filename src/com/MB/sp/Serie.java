package com.MB.sp;
import java.util.Date;

public class Serie implements Comparable<Serie> {
	private String name;
	private String channel;
	private Date nextDate;
	private String country;
	private Date[] dates;
	private int season;
	private int id;
/*
 * @param n Der Name der Serie
 * @param c Der Sender der Serie
 * @param co Das Land der Serie
 * @param d Die Daten der Ausstrahlung
 * @param s Die Staffel der Serie
 * 
 * */
	public Serie(String n, String c, String co, Date[] d, int s, int id) {
		name = n;
		channel = c;
		country = co;
		dates = d;
		season = s;
		this.id= id;
		nextDate = DateHelper.getNextDate(dates);
	}

	public String getName() {
		return name;
	}

	public String getChannel() {
		return channel;
	}

	public Date getNextDate() {
		return DateHelper.getNextDate(dates);
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
	public int getID()
	{
		return id;
	}

	@Override
	public int compareTo(Serie another) {
		if(getNextDate().getTime() < another.getNextDate().getTime())
			return -1;
		if(getNextDate().getTime() > another.getNextDate().getTime())
			return 1;
		return 0;
	}
}
