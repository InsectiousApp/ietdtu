package br.liveo.ndrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

/**
 * Created by Chetan on 6/29/2015.
 */
public class StudentAdapter extends ArrayAdapter<Student> {


    int[] profile_pic_list={R.drawable.president, R.drawable.vicepresifaraz, R.drawable.vicepresigurtej, R.drawable.councilheaddevyanshu, R.drawable.treasurerkaustubh, R.drawable.counciladviserajaykovid, R.drawable.counciladviserpriyagarg, R.drawable.gensecmukul, R.drawable.jointsecanant, R.drawable.jointsecujala, R.drawable.chiefeventcoordinatorharman , R.drawable.techniheadcoremukul, R.drawable.techniheadsoftjigyasa, R.drawable.corpoheadmedha, R.drawable.corpoheadpoojakumar, R.drawable.designheadmaulshree, R.drawable.webdheadtusharjairath, R.drawable.contentdevaakriti, R.drawable.logisticshospprakash, R.drawable.logisticshosprohan, R.drawable.prpublicityrishabh, R.drawable.prpublicitysiddhanth, R.drawable.membershipcouncilmohit, R.drawable.ic_council, R.drawable.ic_council, R.drawable.ic_council, R.drawable.ic_council};

    List<Student> objects;
    Context context;
    LayoutInflater l;
    TextView tv_listdata, tv_listdata_post, tv_listdata_mail;
    ImageView carview_profilepic;

    public StudentAdapter(Context context, int resource, List<Student> objects, LayoutInflater l) {
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
            v=l.inflate(R.layout.council_list_data, null);
        }

        tv_listdata=(TextView)v.findViewById(R.id.list_data_tv);
        tv_listdata_post=(TextView)v.findViewById(R.id.list_data_tv_rank);
        tv_listdata_mail=(TextView)v.findViewById(R.id.list_data_tv_mail);
      //  tv_listdata2=(TextView)v.findViewById(R.id.list_data_tv2);
        carview_profilepic=(ImageView)v.findViewById(R.id.iv_carview);

       final Student s1=objects.get(position);
        Student s2 = null;

        carview_profilepic.setImageResource(profile_pic_list[position]);

        tv_listdata.setText(s1.name);
       // tv_listdata.setTypeface(EasyFonts.robotoThin(context));

        tv_listdata.setTypeface(EasyFonts.caviarDreams(context));

        tv_listdata_mail.setText(s1.mail);
       // tv_listdata_mail.setTypeface(EasyFonts.caviarDreams(context));

        tv_listdata_post.setText(s1.post);
        // tv_listdata.setTypeface(EasyFonts.robotoThin(context));

       // tv_listdata_post.setTypeface(EasyFonts.caviarDreams(context));




//        if(position!=9) {
//            s2 = objects.get(position+1);
//
//        }

        return v;
    }
}
