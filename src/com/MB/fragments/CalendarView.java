package com.MB.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CalendarView extends View{
Paint p;
	public CalendarView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		p = new Paint();
		p.setColor(Color.rgb(100, 100, 100));
	}
	@Override
	public void onDraw(Canvas c)
	{
		drawField
	}

}
