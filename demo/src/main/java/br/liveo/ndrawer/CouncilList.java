package br.liveo.ndrawer;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class CouncilList extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    ListView lv;
    ArrayList<Student> data;
    StudentAdapter adapter;

    ActionBar ab;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_council_list);


        ab=getActionBar();

//         ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
       //  ab.setTitle("hwllooo");
       //   ab.setIcon(R.drawable.mes);
        //     ab.setHomeButtonEnabled(true);
        //   ab.setIcon((R.drawable.ic_launcher));
           //  ab.setDisplayShowCustomEnabled(true);
          //   ab.setDisplayShowTitleEnabled(true);
        // ab.hide();

        // CUSTOM ACTION BAR
       // LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //     v = inflator.inflate(R.layout.actionbar, null);

         //    ab.setCustomView(v);



        lv=(ListView)findViewById(R.id.lv_studentlist_council);
        data=new ArrayList<Student>();

        Student s1=new Student("Shailender Kumar", "President", "shailenderkumar1221@gmail.com");
        Student s2=new Student("Faraz Nayyar", "Vice President", "FARAZ.NAYYAR10@GMAIL.COM");
        Student s3=new Student("Gurtej", "Vice President", "SWEET_11694@YAHOO.CO.IN");
        Student s4=new Student("Devyanshu Gupta ", "Council Head", "DEVYANSHU_ROXX@YAHOO.CO.IN" );
        Student s5=new Student("Kaustubh","Treasurer ", "KAUSTUBH94GEM@GMAIL.COM");
        Student s6=new Student("Ajay Kovid","Student Advisor ", "AJAYSIDDHARTHKOVID@GMAIL.COM");
        Student s7=new Student("Priya Garg", "Student Advisor ", "priyagarg5070@gmail.com");
        Student s8=new Student("Mukul Chaudhary", "General Secretary ", "mukul0505@gmail.com");
        Student s9=new Student("Anant Gupta ", "Joint Secretary ", "ANANT104@YAHOO.CO.IN");
        Student s10=new Student("Ujala", "Joint Secretary ", "UJALABHAMBOO91@GMAIL.COM");
        Student s101=new Student("Harman Chopra", "Chief Event Co-ordinator", "HARMAN_CHOPRA@YAHOO.CO.IN");
        Student s11=new Student( "Mukul Kumar ", "Technical Head (Core)", "mukulcj@gmail.com");
        Student s12=new Student( "Jigyasa Grover  ", "Technical Head (Software)", "Jig_gro@yahoo.com");
        Student s13=new Student("Medha Kaundal", "Corporate Head  ", "119medha@gmail.com" );
        Student s14=new Student("Pooja Kumar  ", "Corporate Head  ", "pooja_kumar781992@yahoo.co.in");
        Student s15=new Student("Maulshree", "Design Head  ", "maulshree1@gmail.com" );
        Student s16=new Student("Tushar Jairath", "Web Development Head ", "tusharjairath942gmail.com" );
        Student s17=new Student("Aakriti Goel" ,"Content Developer  ", "aakriti_goel2000@yahoo.com");
        Student s18=new Student("Prakash", "Logistics & Hospitality Head  ", "KPRAKASH.55662GMAIL.COM");
        Student s19=new Student("Rohan Gupta","Logistics & Hospitality Head  ","ROHANGUPTA962@GMAIL.COM");
        Student s20=new Student("Rishabh","PR & Publicity Head  ", "rishabhdua3@gmail.com");
        Student s21=new Student("Siddhant", "PR & Publicity Head  ", "aggarwalsid05@gmail.com");
        Student s22=new Student("Mohit Sharma", "Membership Coordinator ", "mohitdtu13@gmail.com");


        data.add(s1);
        data.add(s2);
        data.add(s3);
        data.add(s4);
        data.add(s5);
        data.add(s6);
        data.add(s7);
        data.add(s8);
        data.add(s9);
        data.add(s10);
        data.add(s101);
        data.add(s11);
        data.add(s12);
        data.add(s13);
        data.add(s14);
        data.add(s15);
        data.add(s16);
        data.add(s17);
        data.add(s18);
        data.add(s19);
        data.add(s20);
        data.add(s21);
        data.add(s22);


        LayoutInflater l=getLayoutInflater();

        adapter=new StudentAdapter(this, 0, data, l);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_council_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
