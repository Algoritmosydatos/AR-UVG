package com.uvg.mapa.db;

import android.app.Activity;
import android.database.Cursor;

import com.uvg.mapa.db.model.Building;
import com.uvg.mapa.db.model.Room;
import com.uvg.mapa.db.model.Catedratico;


public class DBUtilities {
	
	public static Building[] constructBuildings(Activity activity, Cursor cursor){
		
		Building[] buildings = null;
		if(cursor != null){
			activity.startManagingCursor(cursor);
			buildings = new Building[cursor.getCount()];
			
			int i = 0;
			while(cursor.moveToNext()){
				buildings[i] = new Building(
						cursor.getInt(cursor.getColumnIndexOrThrow(MapDB.KEY_ROWID)),
						cursor.getString(cursor.getColumnIndexOrThrow(MapDB.KEY_NAME)),
						cursor.getDouble(cursor.getColumnIndexOrThrow(MapDB.KEY_LR_LATITUDE)),
						cursor.getDouble(cursor.getColumnIndexOrThrow(MapDB.KEY_LR_LONGITUDE)),
						cursor.getDouble(cursor.getColumnIndexOrThrow(MapDB.KEY_UL_LATITUDE)),
						cursor.getDouble(cursor.getColumnIndexOrThrow(MapDB.KEY_UL_LONGITUDE)));
				i++;
			}
		}
		
		return buildings;
	}
	
	public static Room[] constructRooms(Activity activity, Cursor cursor){
		Room[] rooms = null;
		if(cursor != null){
			activity.startManagingCursor(cursor);
			rooms = new Room[cursor.getCount()];
			
			int i = 0;
			while(cursor.moveToNext()){
				rooms[i] = new Room(
						cursor.getInt(cursor.getColumnIndexOrThrow(MapDB.KEY_ROWID)),
						cursor.getString(cursor.getColumnIndexOrThrow(MapDB.KEY_CODE)),
						cursor.getString(cursor.getColumnIndexOrThrow(MapDB.KEY_DEPARTMENT)),
						cursor.getString(cursor.getColumnIndexOrThrow(MapDB.KEY_PURPOSE)));
				i++;
			}
		}
		
		return rooms;
	}
	
	public static Catedratico[] constructCatedraticos(Activity activity, Cursor cursor){
		Catedratico[] catedraticos = null;
		if(cursor != null){
			activity.startManagingCursor(cursor);
			catedraticos = new Catedratico[cursor.getCount()];
			
			int i = 0;
			while(cursor.moveToNext()){
				catedraticos[i] = new Catedratico(
						cursor.getInt(cursor.getColumnIndexOrThrow(MapDB.KEY_ROWID)),
						cursor.getString(cursor.getColumnIndexOrThrow(MapDB.KEY_NAME)),
						cursor.getString(cursor.getColumnIndexOrThrow(MapDB.KEY_DEPARTMENT)));
				i++;
			}
		}
		
		return catedraticos;
	}
}
