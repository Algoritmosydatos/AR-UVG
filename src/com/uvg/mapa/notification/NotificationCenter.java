package com.uvg.mapa.notification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import android.util.Log;

public class NotificationCenter implements INotificationCenter{

	private static final String TAG = NotificationCenter.class.getSimpleName();
	
	NotificationThread thread;
	
	Queue<INotification> urgent, important;
	
	ArrayList<INotification> standard;
	
	public NotificationCenter(){
		urgent = new LinkedList<INotification>();
		important = new LinkedList<INotification>();
		
		standard = new ArrayList<INotification>();
		
		thread = new NotificationThread();
		thread.start();
	}

	public void onPause(){
		Log.d(TAG, "Notification Center pausing");
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Notification thread was shut down cleanly");
	}
	
	@Override
	public void addUrgent(INotification notification) {
		// TODO Auto-generated method stub
		urgent.add(notification);
	}

	@Override
	public void deleteUrgent(INotification notification) {
		// TODO Auto-generated method stub
		urgent.remove(notification);
	}

	@Override
	public void addImportant(INotification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImportant(INotification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStandard(INotification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStandard(INotification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllStandard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printUpdate(INotification notification) {
		// TODO Auto-generated method stub
		
	}
	
}
