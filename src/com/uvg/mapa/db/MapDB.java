package com.uvg.mapa.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Simple notes database access helper class. Defines the basic CRUD operations
 * for the notepad example, and gives the ability to list all notes as well as
 * retrieve or modify a specific note.
 * 
 * This has been improved from the first version of this tutorial through the
 * addition of better error handling and also using returning a Cursor instead
 * of using a collection of inner classes (which is less scalable and not
 * recommended).
 */
public class MapDB{

    private static final String DATABASE_NAME = "MapDB";
    
    /**Alarm table creation*/
    private static final String DATABASE_TABLE_BUILDINGS = "buildings";

	public static final String KEY_ROWID = "_id";
	public static final String KEY_LR_LATITUDE = "lr_latitude";
	public static final String KEY_LR_LONGITUDE = "lr_longitude";
	public static final String KEY_UL_LATITUDE = "ul_latitude";
	public static final String KEY_UL_LONGITUDE = "ul_longitude";
	public static final String KEY_NAME = "name";

    private static final String[] buildingComposition = new String[] {KEY_ROWID, KEY_LR_LATITUDE,
    	KEY_LR_LONGITUDE, KEY_UL_LATITUDE, KEY_UL_LONGITUDE, KEY_NAME};

    private static final String DATABASE_BUILDINGS_CREATE =
    		"CREATE TABLE "+ DATABASE_TABLE_BUILDINGS + " ("+
			KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			KEY_LR_LATITUDE + " INTEGER NOT NULL, " +
			KEY_LR_LONGITUDE + " INTEGER NOT NULL, " +
			KEY_UL_LATITUDE + " INTEGER NOT NULL, " +
			KEY_UL_LONGITUDE + " INTEGER NOT NULL, " +
			KEY_NAME + " TEXT);";
    
    /**Nap table creation*/
    private static final String DATABASE_TABLE_ROOMS = "rooms";  
	
	public static final String KEY_BUILDING_ID = "building_id";
	public static final String KEY_CODE = "code";
	public static final String KEY_PURPOSE = "purpose";
	public static final String KEY_DEPARTMENT = "department";
    
    private static final String DATABASE_ROOMS_CREATE =
    		"CREATE TABLE "+ DATABASE_TABLE_ROOMS + " ("+
			KEY_ROWID + " INTEGER PRIMARY KEY, " +
			KEY_BUILDING_ID + " INTEGER PRIMARY KEY, " +
			KEY_CODE + " TEXT, " +
			KEY_DEPARTMENT + " TEXT, " +
			KEY_PURPOSE + " TEXT);";
    
    private static final String INITIALIZING_ROOMS = 
    		"INSERT INTO "+ DATABASE_TABLE_ROOMS+ " ("+
    		KEY_ROWID+","+KEY_BUILDING_ID+","+KEY_CODE+","+KEY_PURPOSE+") "+
    		"VALUES ('0','0','0','0');";
    
    public static final String[] roomsComposition = new String[] {KEY_ROWID,
        KEY_BUILDING_ID, KEY_CODE, KEY_PURPOSE};
    
    private static final String DATABASE_TABLE_CATEDRATICOS = "catedraticos";  
    
	public static final String KEY_ROOM_ID = "room_id";
	
    private static final String DATABASE_CATEDRATICOS_CREATE =
    		"CREATE TABLE "+ DATABASE_TABLE_CATEDRATICOS + " ("+
			KEY_ROWID + " INTEGER PRIMARY KEY, " +
			KEY_ROOM_ID + " INTEGER NOT NULL, " +
			KEY_NAME + " TEXT, " +
			KEY_DEPARTMENT + " TEXT);";
    
    private static final String INITIALIZING_CATEDRATICOS = 
    		"INSERT INTO "+ DATABASE_TABLE_CATEDRATICOS+ " ("+
    		KEY_ROWID+","+KEY_ROOM_ID+","+KEY_NAME+","+KEY_DEPARTMENT+") "+
    		"VALUES ('0','0','','0','0','0');";
    
    public static final String[] catedraticosComposition = new String[] {KEY_ROWID,
    	KEY_ROOM_ID, KEY_NAME, KEY_DEPARTMENT};
    
    private static final String TAG = "NotesDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    
    private static final int DATABASE_VERSION = 2;

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_BUILDINGS_CREATE);
            db.execSQL(DATABASE_ROOMS_CREATE);
            db.execSQL(DATABASE_CATEDRATICOS_CREATE);
            db.execSQL(INITIALIZING_ROOMS);
            db.execSQL(INITIALIZING_CATEDRATICOS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS notes");
            onCreate(db);
        }
    }

    /**
     * Constructor - takes the cont	ext to allow the database to be
     * opened/created
     * 
     * @param ctx the Context within which to work
     */
    public MapDB(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * Open the notes database. If it cannot be opened, try to create a new
     * instance of the database. If it cannot be created, throw an exception to
     * signal the failure
     * 
     * @return this (self reference, allowing this to be chained in an
     *         initialization call)
     * @throws SQLException if the database could be neither opened or created
     */
    public MapDB open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }
    
    //--------------------SEARCH QUERIES FOR BUILDINGS------------------------------------------------------------

    public Cursor searchBuilding(String name) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_BUILDINGS, buildingComposition, KEY_NAME+" like " + "'%"+name+"%'" + 0, 
            		null, null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    public Cursor fetchBuilding(int id) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_BUILDINGS, buildingComposition, KEY_ROWID + "=" + id, null,
                    null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchAllBuildings() {
        return mDb.query(DATABASE_TABLE_BUILDINGS, buildingComposition, null, null, null, null, null);
    }
    
    //--------------------SEARCH QUERIES FOR ROOMS------------------------------------------------------------
    
    public Cursor searchRoomByPurpose(String purpose) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_ROOMS, roomsComposition, KEY_PURPOSE+" like " + "'%"+purpose+"%'" + 0, 
            		null, null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    public Cursor searchRoomByDepartment(String department) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_ROOMS, roomsComposition, KEY_DEPARTMENT+" like " + "'%"+department+"%'" + 0, 
            		null, null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    public Cursor searchRoomByCode(String code) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_ROOMS, roomsComposition, KEY_CODE+" like " + "'%"+code+"%'" + 0, 
            		null, null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    public Cursor fetchRoom(int id) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_ROOMS, roomsComposition, KEY_ROWID + "=" + id, null,
                    null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchAllBuildingRooms(int building_id) {
    	Cursor mCursor =

                mDb.query(true, DATABASE_TABLE_ROOMS, roomsComposition, KEY_BUILDING_ID + "=" + building_id, null,
                        null, null, null, null);
            
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
    }
    
    //--------------------SEARCH QUERIES FOR CATEDRATICOS------------------------------------------------------------
    
    public Cursor searchCatedraticoByName(String name) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_CATEDRATICOS, catedraticosComposition, 
            		KEY_NAME+" like " + "'%"+name+"%'" + 0, 
            		null, null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    public Cursor searchCatedraticoByDepartment(String department) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_CATEDRATICOS, catedraticosComposition, 
            		KEY_DEPARTMENT+" like " + "'%"+department+"%'" + 0, 
            		null, null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    
    public Cursor fetchCatedratico(int id) throws SQLException {
        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE_CATEDRATICOS, catedraticosComposition, KEY_ROWID + "=" + id, null,
                    null, null, null, null);
        
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor fetchAllCatedraticosPerRoom(int room_id) {
    	Cursor mCursor =

                mDb.query(true, DATABASE_TABLE_CATEDRATICOS, catedraticosComposition, KEY_ROOM_ID + "=" + room_id, null,
                        null, null, null, null);
            
        if (mCursor != null) {
        	mCursor.moveToFirst();
        }
        return mCursor;
    }
}