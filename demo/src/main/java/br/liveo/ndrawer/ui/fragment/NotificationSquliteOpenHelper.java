package br.liveo.ndrawer.ui.fragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chetan on 7/18/2015.
 */
public class NotificationSquliteOpenHelper extends SQLiteOpenHelper {




    public static final String NOTIFICATION_TABLE="note";
    public static final String NOTIFICATION="note_info";
    public static final String NOTIFICATION_DATE="note_info_date";
    public static final String NOTIFICATION_TIME="note_info_time";
    public static final String _ID="id";
    public static final String DATABASE="squlitenote";




    public NotificationSquliteOpenHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+NOTIFICATION_TABLE+" ( "+ _ID + " INTEGER PRIMARY KEY, "+ NOTIFICATION + " TEXT, " + NOTIFICATION_TIME + " TEXT, " + NOTIFICATION_DATE + " TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
