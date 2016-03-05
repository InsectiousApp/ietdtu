package br.liveo.ndrawer.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

import br.liveo.ndrawer.R;

/**
 * Created by Chetan on 7/18/2015.
 */
public class NotificationAdapter extends ArrayAdapter<Notification> {

    List<Notification> objects;
    Context context;
    LayoutInflater l;
    TextView tv_notification, tv_notification_date, tv_notification_time;



    public NotificationAdapter(Context context, int resource, List<Notification> objects, LayoutInflater l) {
        super(context, resource, objects);

        this.context=context;
        this.objects=objects;
        this.l=l;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=convertView;

        if(v==null)
        {
            v=l.inflate(R.layout.notification_item, null);
        }

        tv_notification=(TextView)v.findViewById(R.id.tv_notification);
        tv_notification_date=(TextView)v.findViewById(R.id.tv_notification_date);
        tv_notification_time=(TextView)v.findViewById(R.id.tv_notification_time);

        //  tv_listdata2=(TextView)v.findViewById(R.id.list_data_tv2);

        final Notification s1=objects.get(position);
        Notification s2 = null;



        tv_notification.setText(s1.noti);
        // tv_listdata.setTypeface(EasyFonts.robotoThin(context));

        tv_notification.setTypeface(EasyFonts.caviarDreams(context));

        tv_notification_date.setText(s1.noti_date);
        tv_notification_time.setText(s1.noti_time);



//        if(position!=9) {
//            s2 = objects.get(position+1);
//
//        }

        return v;
    }



}
