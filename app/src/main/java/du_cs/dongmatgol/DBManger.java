package du_cs.dongmatgol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arran on 2016-06-09.
 */
public class DBManger extends SQLiteOpenHelper {
    public DBManger(Context context){
        super(context, "myDB",null,1);
    }
    @Override
    public  void onCreate (SQLiteDatabase db) {
        //테이블 생성 (이미 생성된 경우 생성되지않음)
        db.execSQL("create table memberships (name text, id text, pw text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        //TODO Auto-generated method stub
        //존재하는 DB와 버젼이 다른 경우
    }
}
