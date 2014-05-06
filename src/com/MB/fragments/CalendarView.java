package com.MB.fragments;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class CalendarView extends View{
	private final double HEIGHT_PERCENT=0.7;
Paint p;
int calendarHeight;
int width;
int infoHeight;
Tag[] tage = new Tag[35];
	public CalendarView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
		
	}
	private void init()
	{
		p = new Paint();
		p.setColor(Color.rgb(100, 100, 100));
		calendarHeight = (int) (this.getHeight()*HEIGHT_PERCENT);
		infoHeight = this.getHeight()-calendarHeight;
		width = this.getWidth();
		Calendar g = GregorianCalendar.getInstance();
		g.set(Calendar.DAY_OF_MONTH, 1);
		int start = g.get(Calendar.DAY_OF_WEEK);
		//switch(start){case Calendar.SUNDAY: start=}
		for(int i=0; i<tage.length; i++)
			if(i<start)
				tage[i]= new Tag(-1, false);
			else if(i<g.getActualMaximum(Calendar.DAY_OF_MONTH))
				tage[i] = new Tag(i+1, false);
			else 
				tage[i]= new Tag(-1, false);
		
	
		
	}
	@Override
	public void onDraw(Canvas c)
	{	
		int zeile =0;
		for(int i=0; i<tage.length; i++){
			if(i%7==0)
				zeile ++;
			c.drawOval(new RectF((width/7)*(i%7),zeile*calendarHeight/5, width/7*((i%7)+1),zeile+1*calendarHeight/5 ),p );
		}
			
	}
	private class Tag
	{
		int zahl;
		boolean hatTermin;
		public Tag(int i, boolean termin)
		{
			zahl =i;
			hatTermin = termin;
		}
		@Override
		public String toString()
		{
			if(zahl==-1)
				return "";
			else
				return ""+zahl;
		}
		public boolean isEvent(){
			return hatTermin;
		}
	}

}
