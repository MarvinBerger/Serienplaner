package com.MB.fragments;

import java.util.Calendar;

import android.view.View.*;

import java.util.GregorianCalendar;

import com.MB.sp.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalendarView extends LinearLayout implements OnTouchListener{
	private final int TOP_BORDER=50;
	private final String[] DAY_STRINGS = new String[]{"SO", "MO", "DI", "MI", "DO", "FR", "SA"}; 
Paint p;
int calendarHeight;
int width;
int infoHeight;
TextView tv;
Tag[] tage = new Tag[35];
RectF[] rects = new RectF[35];
	public CalendarView(Context context) {
		super(context);
		setWillNotDraw(false);
		// TODO Auto-generated constructor stub
		init();
		Log.i("CalendarView", "Init");
		
		
	}
	private void init()
	{
		p = new Paint();
		p.setColor(Color.rgb(100, 100, 100));
		
		Calendar g = GregorianCalendar.getInstance();
		g.set(Calendar.DAY_OF_MONTH, 1);
		int start = g.get(Calendar.DAY_OF_WEEK);
		Log.i("START", start+"");
		//switch(start){case Calendar.SUNDAY: start=}
		for(int i=0; i<tage.length; i++)
			if(i+1<start)
				tage[i]= new Tag(-1, false);
			else if(i-start+1<g.getActualMaximum(Calendar.DAY_OF_MONTH))
				tage[i] = new Tag(i-start+2, false);
			else 
				tage[i]= new Tag(-1, false);
		invalidate();
		Log.i("Tage LENGTH", width+"");
		this.setOnTouchListener(this);
		
		tage[12].setEvent(true);
		tage[17].setEvent(true);
		tage[22].setEvent(true);
	
		
	}
	@Override
	public void onDraw(Canvas c)
	{	
		
		width = this.getWidth();
		calendarHeight = width/7*5;
		infoHeight = this.getHeight()-calendarHeight-TOP_BORDER;
		int zeile =0;
		p.setTextSize(30);
		p.setColor(Color.BLACK);
		for(int i=0; i<7; i++)
		{
			c.drawText(DAY_STRINGS[i], i*width/7+(width/14)-20, 30, p);
		}
		for(int i=0; i<tage.length; i++){
			p.setColor(Color.rgb(100,100,100));
			int korrektur = 20;
			if(tage[i].toString().length()==1)
				korrektur=10;
			if(i%7==0)
				zeile ++;
			RectF rect = new RectF((width/7)*(i%7),(zeile-1)*calendarHeight/5+TOP_BORDER, width/7*((i%7)+1),(zeile)*calendarHeight/5+TOP_BORDER) ;
			if(rects[i]==null)
				rects[i]=rect;
			
			if(tage[i].isFocused()){
			c.drawOval(rect,p );
			p.setColor(Color.WHITE);
			}else if(tage[i].isEvent())
				p.setColor(Color.RED);
			
			c.drawText(tage[i].toString(), rect.centerX()-korrektur, rect.centerY()-korrektur+25, p);
			p.setColor(Color.BLACK);
			c.drawLine(0, calendarHeight+50, width, calendarHeight+50, p);
			Log.i("Koords:", (width/7)*(i%7)+"  "+zeile*calendarHeight/5+"  "+ width/7*((i%7)+1)+"  "+zeile+1*calendarHeight/5 );
		}
			
	}
	private class Tag
	{
		int zahl;
		boolean event;
		boolean focus;
		public Tag(int i, boolean termin)
		{
			zahl =i;
			event = termin;
			focus = false;
		}
		@Override
		public String toString()
		{
			if(zahl==-1)
				return "";
			else
				return ""+zahl;
		}
		public String getInfo()
		{
			return "Hier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\nHier stehen die Termine!\n";
		}
		public boolean isEvent(){
			return event;
		}
		public boolean isFocused(){
		return focus;
		}
		public void setFocus(boolean b)
		{
			focus = b;
		}
		public void setEvent(boolean b)
		{
			event = b;
		}
	}
	private void clearTage()
	{
		for(Tag t : tage)
		{
			t.setFocus(false);
		}
	}
	private void initTextView()
	{
		LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = vi.inflate(R.layout.infoscreen, null);

		// fill in any details dynamically here
		tv = (TextView) v.findViewById(R.id.textView1);
		

		tv.setWidth(width);
		tv.setHeight(infoHeight);
		tv.setX(0);
		tv.setY(calendarHeight+50);
		tv.setTextColor(Color.BLACK);
		// insert into main view
				
				addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
				
	}
	public void showInfo(Tag t)
	{
		if(tv==null)
		{
			initTextView();
		}
		tv.setText(t.getInfo());
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		for(int i=0; i<rects.length; i++)
		{
			if(event.getX()>rects[i].left && event.getX() < rects[i].right && event.getY()>rects[i].top && event.getY()<rects[i].bottom){
				clearTage();
				tage[i].setFocus(true);
				showInfo(tage[i]);
				invalidate();
				break;
			}
			
		}
		return false;
	}
	

}
