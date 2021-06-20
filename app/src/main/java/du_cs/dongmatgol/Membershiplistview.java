package du_cs.dongmatgol;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Membershiplistview extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membershiplistview);

        // 엑티비티 라벨 출력

        //고객정보르 추가할 레이아웃을 인식
        LinearLayout layout = (LinearLayout) findViewById(R.id.memberships);

        int i = 0;

        try {
            DBManger dbMgr = new DBManger(this);

            //DB 연결
            SQLiteDatabase db = dbMgr.getReadableDatabase();
            Cursor cursor = db.rawQuery(
                    "SELECT name, id, pw FROM memberships",null);
            while (cursor.moveToNext()){
                String name = cursor.getString(0);
                String id = cursor.getString(1);
                String pw = cursor.getString(2);

                LinearLayout cutmLL = new LinearLayout(this);
                cutmLL.setBackgroundColor(Color.rgb(255,61,00));
                //레이아웃에 추가할 고객정보를 위한 텍스트뷰 생성
                TextView nameTextView = new TextView(this);
                nameTextView.append(name);
                nameTextView.setTextSize(30);
                nameTextView.setTextColor(Color.rgb(0,0,0));

                // 고객성명을 레이아웃에 추가하여 출력
                layout.addView(nameTextView);

                //레이아웃에 추가할 고객id 생성
                TextView idTextView = new TextView(this);
                idTextView.append(id);
                idTextView.setTextSize(20);
                idTextView.setTextColor(Color.rgb(0,0,0));

                //고객id를 레이아웃에 추가하여 출력
                layout.addView(idTextView);

                //레이아웃에 추가할 고객id 생성
                TextView pwTextView = new TextView(this);
                pwTextView.append(pw);
                pwTextView.setTextSize(20);
                pwTextView.setTextColor(Color.rgb(0,0,0));

                //고객id를 레이아웃에 추가하여 출력
                layout.addView(pwTextView);
                i++;
            }
            if (i==0){
                TextView defaultTextView = new TextView(this);
                defaultTextView.append("등록된 고객이 없습니다. !");
                layout.addView(defaultTextView);
            }
            //리소스 반환
            cursor.close();
            dbMgr.close();
        } catch (SQLiteException e){
            TextView errorTextView = new TextView(this);
            errorTextView.append("db 접속 에러가 발생했습니다.");
            layout.addView(errorTextView);
        }
        Button btn = (Button) findViewById(R.id.button_join_form);

        // 등록버튼 클릭대기
        btn.setOnClickListener(this);
    }
    /**
     * 등록을 위해 customerRegActivity.class 구현
     */
    @Override
    public void onClick(View v){
        //등록 버튼이 클릭되었을 때
        Intent it = new Intent(this,Membershipjoin.class);
        startActivity(it);
        finish();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent ML_intent = new Intent(Membershiplistview.this,LoginPage.class);
        startActivity(ML_intent);
    }
}