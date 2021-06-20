package du_cs.dongmatgol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by yuven on 2016-06-07.
 */
public class RandomPage extends Activity {
    String name;
    String group;
    String tel;
    int number;
    int Fimage;
    MainPage MP = (MainPage)MainPage.mainPageActivity;
    public static Activity RandomActivity;
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randompage);
        MP.finish();
        RandomActivity = RandomPage.this;
        Intent rnd = getIntent();
        name = rnd.getStringExtra("Rname");
        group = rnd.getStringExtra("Rgroup");
        tel = rnd.getStringExtra("Rtel");
        number = rnd.getIntExtra("Rnumber",number);


        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(RandomPage.this, RandomMenuPage.class);

                //position 값을 전부 전달
                intent.putExtra("RRnumber",number);
                //Pass all data name
                intent.putExtra("RRname",name);
                //Pass all data group
                intent.putExtra("RRgroup",group);
                //Pass all data tel
                intent.putExtra("RRtel",tel);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        }, 3000);
    }
}




