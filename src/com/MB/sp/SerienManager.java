package com.MB.sp;
import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class SerienManager extends SQLiteOpenHelper{
	//Tabelle
	private final static String SERIEN_TABELLE ="CREATE TABLE IF NOT EXISTS `serientable` (`name` TEXT, `country` TEXT,`dates` TEXT,`channel` TEXT, `season` INT) ";
	//Konstanten
private final static String NAME = "serien";
private final static String ALLE_SERIEN ="SELECT * FROM `serientable`";
// Instanz Variabel
private static SerienManager sm;
	private SerienManager(Context context) {
		super(context, NAME, null, 2);
	}
	public static SerienManager getInstance(Context c)
	{
		if(sm==null)
			sm = new SerienManager(c);
		return sm;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		this.getWritableDatabase().execSQL(SERIEN_TABELLE);

	}
	public Serie[] getSeries()
	{
		Cursor c = this.getReadableDatabase().rawQuery(ALLE_SERIEN, null);
		c.moveToFirst();
		Serie[] out = new Serie[c.getCount()];
		int index =0;
		do
		{
			Date[] d = new Date[c.getString(2).split(";").length];
			for(int i=0; i<d.length; i++)
				d[i]= new Date(Long.parseLong(c.getString(2).split(";")[i])*1000);
			
			out[index++] = new Serie(c.getString(0), c.getString(3), c.getString(1),d, c.getInt(4));
		}while(c.moveToNext());
		return out;
	}
	public void addSerie(Serie s)
	{
		this.getWritableDatabase().execSQL("SQL");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
		
	}

}
