import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chetan on 7/18/2015.
 */
public class NoteSquliteOpenHelper extends SQLiteOpenHelper {

    public static final String NOTE="note";
    public static final String NOTE_INFO="note_info";
    public int check_currentstreak=1;
    public static final String _ID="id";
    public static final String 
DATABASE="squlitenote";

    public NoteSquliteOpenHelper(Context context) {
        super(context, DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+NOTE+" ( "+ _ID + " INTEGER PRIMARY KEY, "+ NOTE_INFO + " TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
