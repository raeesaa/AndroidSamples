package com.example.samplesqllitedbwithtouchlistener;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Point;

public class Database extends SQLiteOpenHelper {
	
	private static final String POINTS_TABLE = "points";
	private static final String COL_ID = "id";
	private static final String COL_X = "x";
	private static final String COL_Y = "y";

	public Database(Context context) {
		super(context, "note.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql = String.format("create table %s(%s integer primary key, %s integer not null, %s integer not null)", POINTS_TABLE, COL_ID, COL_X, COL_Y);
		
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public void storePoints(List<Point> points)
	{
		SQLiteDatabase db = getWritableDatabase();
		
		db.delete(POINTS_TABLE, null, null);
		
		int i = 1;
		for(Point point : points)
		{
			ContentValues values = new ContentValues();
			
			values.put(COL_ID, i);
			values.put(COL_X, point.x);
			values.put(COL_Y, point.y);
			
			db.insert(POINTS_TABLE, null, values);
			
			i++;
		}
		
		
		
		db.close();
	}
	
	public List<Point> getPoints()
	{
		List<Point> points = new ArrayList<Point>();
		
		SQLiteDatabase db = getReadableDatabase();
		String sql = String.format("select %s, %s from %s order by %s", COL_X, COL_Y, POINTS_TABLE, COL_ID);
		Cursor cursor= db.rawQuery(sql, null);
		while(cursor.moveToNext())
		{
			int x = cursor.getInt(0);
			int y = cursor.getInt(1);
			
			points.add(new Point(x,y));
		}
		
		
		db.close();
		
		return points;
	}

}
