package du_cs.dongmatgol;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by arran on 2016-06-09.
 */
public class Membershipjoin extends Activity implements View.OnClickListener {
    private DBManger dbMgr;

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_join);
        setTitle("회원등록");

        //등록버튼 onClick() 메소드 실행
        Button btnJoin = (Button) findViewById(R.id.OKjoin);
        btnJoin.setOnClickListener(this);

        //목록버튼 onClick() 메소드 실행
        Button btnList = (Button) findViewById(R.id.Nojoin);
        btnList.setOnClickListener(this);
    }
    @Override
    public void onClick (View view) {
        //목록 버튼을 클릭한 경우
        if (view.getId() == R.id.Nojoin) {
            Intent intent = new Intent(this, Membershiplistview.class);
            //인텐트에서 지정한 엑티비티 실행
            startActivity(intent);
            //현재 엑티비티 종료
            finish();
        }
        //이름 추출
        EditText edName = (EditText) findViewById(R.id.edtname);
        String strName = edName.getText().toString();
        //id 추출
        EditText edId = (EditText) findViewById(R.id.edtid);
        String strId = edId.getText().toString();
        //pw 추출
        EditText edPw = (EditText) findViewById(R.id.edtpw);
        String strPw = edPw.getText().toString();

        dbMgr = new DBManger(this);

        SQLiteDatabase db = dbMgr.getReadableDatabase();
        /*
        Cursor cursor = db.query("memberships",  new String[]{"id"},"" , new String[]{strId}, null, null,null);
        */
        Cursor cursor = db.rawQuery("SELECT id FROM memberships WHERE id = '" + strId+"'",null);
        int recordCount = cursor.getCount();
        if (recordCount == 0){
            try {
                SQLiteDatabase sdb = dbMgr.getWritableDatabase();
                StringBuffer sql = new StringBuffer();
                sql.append("INSERT INTO memberships VALUES(");
                sql.append("'" + strName + "',");
                sql.append("'" + strId + "',");
                sql.append("'" + strPw + "');");
                sdb.execSQL(sql.toString());
            } catch (SQLiteException e) {

            } finally {
                dbMgr.close();
            }
            Intent intent = new Intent(this, Membershiplistview.class);

            //인텐트에서 지정한 엑티빝 실행
            startActivity(intent);
            //현재 엑티비티 종료
            finish();
        }
        else {
            Toast.makeText(Membershipjoin.this,"중복 아이디 입니다. 다시 입력해주세요",Toast.LENGTH_SHORT).show();
        }



    }
}