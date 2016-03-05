package br.liveo.ndrawer.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Chetan on 7/20/2015.
 */
public class InternetReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        boolean isConnected = netInfo != null && netInfo.isConnected();

        if (isConnected) {
            //Log.i("NET", "connecte" + isConnected);

            //Toast.makeText(context, "Internet Available", Toast.LENGTH_SHORT).show();

             Intent i=new Intent();

            //to start service
             i.setClass(context, MyinternetService.class);
            context.startService(i);

            //    Intent i2=new Intent();
            //   i2.setClass(context, MainActivity.class);
//            context.startActivity(i2);




        }

        else
        {
           // Toast.makeText(context, "Internet UnAvailable", Toast.LENGTH_SHORT).show();
         //   Log.i("NET", "not connecte" + isConnected);
        }

        //Toast.makeText(context, "Recieved Broadcast", Toast.LENGTH_LONG).show();

    }
}

