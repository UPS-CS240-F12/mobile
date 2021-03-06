package edu.pugetsound.vichar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;
/**
 * Creates dialog whichWarns user of no network connection,
 * and allows user to connect if so desired
 * @author Nathan P
 * @version 11/11/12
 */
public class ConnectionDialog  {
	
	private AlertDialog ad; 
	private Context context; //the application context
	
	public static final int CONNECTING = 0;
	public static final int NO_CONNECTION = 1;
	
	/**
	 * Builds the connection alert dialog
	 * @param c Application context
	 */
	public ConnectionDialog(Context c, int msgCode)	{
		context = c;
		AlertDialog.Builder builder = new AlertDialog.Builder(c);
		if(msgCode == CONNECTING) {
			builder.setMessage(R.string.conn_dialog_connecting);
		} else if(msgCode == NO_CONNECTION) {
			builder.setMessage(R.string.conn_dialog);
			builder.setPositiveButton(R.string.connect, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
	        	   connectToWifi(((Dialog) dialog).getContext());
		           }
			});
		}
		
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	        	   cancel(getContext());
	           }
	       });

		
		Log.d("ConnectionDialog", "builder all set, about to create");
		ad = builder.create();
	}
	
	/**
	 * Calls default Android wifi connection manager
	 * @param c Application context
	 */
	private void connectToWifi(Context c)	{
		WifiManager wm = (WifiManager) c.getSystemService(Context.WIFI_SERVICE);
		wm.setWifiEnabled(true);
		//wait while wifi enables..
		//while(wm.isWifiEnabled()==false);
		//calls Android wifi choosing menu
		c.startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
		
	}
	
	/**
	 * "Exits" program by calling home screen
	 * @param c Application context
	 */
	private void cancel(Context c)  {
		Intent intent = new Intent(Intent.ACTION_MAIN);
 	   	intent.addCategory(Intent.CATEGORY_HOME);
 	   	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 	   	c.startActivity(intent);
	}
	
	/**
	 * Displays the dialog
	 */
	public void show()	{
		ad.show();
	}
	
	public void dismiss() {
		ad.dismiss();
	}
	
	private Context getContext()  {
		return context;
	}
}
