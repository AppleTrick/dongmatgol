package du_cs.dongmatgol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yuven on 2016-06-07.
 */
public class RandomMenuPage extends Activity {
    RandomPage RP = (RandomPage)RandomPage.RandomActivity;
    //값들을 선언해준다.
    TextView txtname;
    TextView txtgroup;
    TextView txttel;
    ImageView imFimage;
    ImageView imPrice;
    String name;
    String group;
    String tel;
    int F_Real_image[];
    int number;
    int Price[];

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menupagedesign);
        RP.finish();
        
        Price = new int[]{
                R.drawable.bongus_price,R.drawable.hansot_price,R.drawable.shallom_price,R.drawable.jungjin_price,
                R.drawable.mungdond_price,R.drawable.via246_price,R.drawable.alchon_price,R.drawable.oni_price,
                R.drawable.isac_price,R.drawable.bobzip_price,R.drawable.misun_price,R.drawable.alang_price,
                R.drawable.momstouch_price,R.drawable.avec_price,R.drawable.goodfish_price,R.drawable.ujung_price,
                R.drawable.jonson_price
        };

        F_Real_image=new int[] {
                R.drawable.bongus_real,R.drawable.hansot_real,R.drawable.shallome_real,R.drawable.jungjin_real,
                R.drawable.mungdond_real,R.drawable.via246_real,R.drawable.alchon_real,R.drawable.onigiri_real,
                R.drawable.isac_real,R.drawable.bobzip_real,R.drawable.misun_real,R.drawable.alang_real,
                R.drawable.momstouch_real,R.drawable.avec_real,R.drawable.goodfish_real,R.drawable.ujungbu_real,
                R.drawable.jonson_real
        };
        //리스트뷰 어뎁터에서 인텐트 값을 받아온다.
        Intent i = getIntent();

        number = i.getIntExtra("RRnumber",number);
        name = i.getStringExtra("RRname");                    //name의 값을 가지고와서 name에 저장
        group = i.getStringExtra("RRgroup");                  //group의 값을 가지고와서 group에 저장
        tel = i.getStringExtra("RRtel");                      //tel의 값을 가지고 와서 tel에 저장


        txtname=(TextView) findViewById(R.id.name);
        txtgroup=(TextView) findViewById(R.id.group);
        txttel=(TextView) findViewById(R.id.tel);
        imFimage=(ImageView) findViewById(R.id.F_R_image);
        imPrice=(ImageView) findViewById(R.id.price);

        txtname.setText(name);                          //txtname에 name의 값을 세팅
        txtgroup.setText(group);                        //txtgroup에 group의 값의 세팅
        txttel.setText(tel);                            //txttel에 tel의 값을 세팅
        imFimage.setImageResource(F_Real_image[number]);              //imFimage에 Fimage 값을 세팅
        imPrice.setImageResource(Price[number]);        //
    }
    @Override                           //창희야 수고해
    public void onBackPressed(){        //창희야 수고해
        super.onBackPressed();          //창희야 수고해
        Intent BRM_intent = new Intent(RandomMenuPage.this,MainPage.class);     //창희야 수고해
        startActivity(BRM_intent);          //창희야 수고해
        overridePendingTransition(0,0);         //창희야 수고해
    }
}