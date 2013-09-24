package com.uvg.mapa;

import com.uvg.ar.R;
import com.uvg.mapa.db.DBUtilities;
import com.uvg.mapa.db.MapDB;
import com.uvg.mapa.db.model.Building;
import com.uvg.mapa.gui.Identifier;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class MapActivity extends Activity implements LocationListener {

	private static final String TAG = MapActivity.class.getSimpleName();
	
	LocationManager locationManager;
	
	MainPanel mainPanel;
	
	MapDB mapdb;
	
	Building[] buildings;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //requesting to turn the title OFF
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //making it full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        mainPanel = new MainPanel(this.getApplicationContext());
        
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        
        mapdb = new MapDB(this.getApplicationContext());

        mapdb.open();
        
        buildings = DBUtilities.constructBuildings(this, mapdb.fetchAllBuildings());
        if(buildings != null)
	        for(int i = 0; i < buildings.length; i++){
	        	buildings[i].setRooms(DBUtilities.constructRooms(this, 
	        			mapdb.fetchAllBuildingRooms(buildings[i].getId())));
	        	if(buildings[i].getRooms() != null)
		        	for(int j = 0; j < buildings[i].getRooms().length; j++)
		        		buildings[i].getRooms()[j].setCatedraticos(DBUtilities.constructCatedraticos(this,
		        				mapdb.fetchAllCatedraticosPerRoom(buildings[i].getRooms()[j].getId())));
	        }
       
        mapdb.close();
        
        mainPanel.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				for(int i = 0; i < buildings.length; i++){
					if(buildings[i].checkCoordinates(event.getX(), event.getY())){
						displayBuilding(buildings[i]);
					}
				}
				return true;
			}
        });
        
        //set our MainGamePanel as the View
        setContentView(mainPanel);
    }
    
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    }
    
    @Override
    protected void onStop(){
    	super.onStop();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean displayBuilding(Building building){
		return false;	
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		mainPanel.update(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		mainPanel.setOnline(false);
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		mainPanel.setOnline(true);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
