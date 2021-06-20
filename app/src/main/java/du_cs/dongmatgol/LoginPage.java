package du_cs.dongmatgol;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yuven on 2016-06-07.
 */
public class LoginPage extends FragmentActivity {
    public static Activity logInActivity;
    private DBManger dbMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        getWindow().setWindowAnimations(0);
        startActivity(new Intent(this, Splash.class));
        logInActivity = LoginPage.this;
        final EditText inputtext1=(EditText) findViewById(R.id.Confirm_ID);
        final EditText inputtext2=(EditText) findViewById(R.id.Confirm_Password);
        final Button btn1=(Button) findViewById(R.id.Login_BTN);
        final Button btn2=(Button) findViewById(R.id.Cr_BTN);
        final Animation fadeIn= AnimationUtils.loadAnimation(this, R.anim.fade_in);
        inputtext1.startAnimation(fadeIn);
        inputtext2.startAnimation(fadeIn);
        btn1.startAnimation(fadeIn);
        btn2.startAnimation(fadeIn);

        Button membershipbt =(Button) findViewById(R.id.Cr_BTN) ;
        membershipbt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent memintent = new Intent(LoginPage.this,Membershiplistview.class);
                //인텐트에서 지정한 엑티비티 실행
                startActivity(memintent);
                //현재 엑티비티 종료
                finish();
            }
        });
    }

    public void onClick(View view) {
        EditText Get_id = (EditText) findViewById(R.id.Confirm_ID);
        EditText Get_pass = (EditText) findViewById(R.id.Confirm_Password);
        String Type_id = Get_id.getText().toString();
        String Type_pass = Get_pass.getText().toString();
        dbMgr = new DBManger(this);
        SQLiteDatabase db = dbMgr.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, pw FROM memberships WHERE id = '" + Type_id + "' and pw='"+Type_pass+"'", null);
        int recordCount = cursor.getCount();


        Intent intent = new Intent(LoginPage.this, MainPage.class);



            if (recordCount==1) {

                    Toast.makeText(LoginPage.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

            } else
                Toast.makeText(LoginPage.this, "비밀번호를 입력 해 주세요.", Toast.LENGTH_SHORT).show();
        }

}