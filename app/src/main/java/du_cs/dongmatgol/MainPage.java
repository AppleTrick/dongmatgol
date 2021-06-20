package du_cs.dongmatgol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by yuven on 2016-06-07.
 */
public class MainPage extends AppCompatActivity {
    LoginPage LP = (LoginPage) LoginPage.logInActivity;
    public static Activity mainPageActivity;
    //Declare Variables
    private List<valueset> valuesetList = null;
    ListView list;
    ListView Rlist;
    ViewPager Viewlist;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] name;
    String[] group;
    String[] tel;
    int[] Fimage;
    int[] number;
    ArrayList<valueset> arraylist = new ArrayList<valueset>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpagedesign);
        LP.finish();
        mainPageActivity=MainPage.this;
        //데이터를 정의한다.
        name = new String[] {"봉구스","한솥","샬롬","정진욱 돈까스","명동찌개마을","via246","알촌","오니기리","이삭토스트",
                "밥집","미선","알랑","맘스터치","아벡데프리츠","좋은물고기","의정부부대찌개","존슨부대찌개"};

        group = new String[] {"밥버거","도시락","중화요리","돈까스","찌개","양식","알밥","일식","토스트","가정식",
                "가정식","오므라이스","햄버거","감자튀김","생선구이","찌개","찌개"};

        tel = new String[] {"031)756-7407","031)753-7579","031)721-4775","031)756-2859","031)721-1848",
                "031)758-8942","070)7768-0598","031)756-2290","031)755-5960","031)723-6062",
                "031)756-0408","031)756-9288","031)751-0027","031)757-1950","031)752-9006",
                "031)758-8939","031-752-1190"};
        Fimage = new int[] {R.drawable.bongus_main,R.drawable.hansot_main,R.drawable.shalom_main,R.drawable.jinuk_main,
                R.drawable.wonjo_main,R.drawable.via246_main,R.drawable.alchon_main,R.drawable.oni_main,
                R.drawable.isac_main,R.drawable.babjip_main,R.drawable.misun_main,R.drawable.alrang_main,
                R.drawable.moms_main,R.drawable.avec_main,R.drawable.fish_main,R.drawable.jungbu_main,
                R.drawable.jonson_main};

        number = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        //mainpagedesign.xml의 리스트뷰에 데이터를 배치한다.
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < 17; i++)
        {
            valueset VS = new valueset(name[i],group[i],tel[i],Fimage[i],number[i]);
            arraylist.add(VS);
        }

        //Pass result to ListViewAdapter Class
        adapter = new ListViewAdapter(this,arraylist);

        //Binds the Adapter to the ListView
        list.setAdapter(adapter);

        //뷰 페이저 설정
        Viewlist=(ViewPager) findViewById(R.id.pager);
        final Viewpageradapter ViewpagerADP =new Viewpageradapter(getLayoutInflater());
        Viewlist.setAdapter(ViewpagerADP);

        //fab 설정
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int rNum = (int) (Math.random()*16);
                Intent rr_intent = new Intent(MainPage.this,RandomPage.class);
                rr_intent.putExtra("Rname",name[rNum]);
                rr_intent.putExtra("Rgroup",group[rNum]);
                rr_intent.putExtra("Rnumber",number[rNum]);
                rr_intent.putExtra("Rtel",tel[rNum]);
                startActivity(rr_intent);
            }
        });
        //Locate the EditText in MainPage.xml
        editsearch = (EditText) findViewById(R.id.search);

        //Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }
}