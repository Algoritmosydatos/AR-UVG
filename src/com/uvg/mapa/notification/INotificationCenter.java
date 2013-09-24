package com.uvg.mapa.notification;

public interface INotificationCenter {

	//Urgent notification pops in an upper layout. Does not remove other notifications.
	//Appears until touched.
	public void addUrgent(INotification notification);
	
	public void deleteUrgent(INotification notification);
	
	//Important notification pops in main layout. Removes all other notifications. 
	//Appears for 15 seconds.
	public void addImportant(INotification notification);

	public void deleteImportant(INotification notification);
	
	//Standard notification is added into standard layout. If allowed, removed when touched.
	public void addStandard(INotification notification);
	
	public void deleteStandard(INotification notification);
	
	public void deleteAllStandard();
	
	//Prints a notification to the notification layout.
	public void printUpdate(INotification notification);
	
}
