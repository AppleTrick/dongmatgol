package du_cs.dongmatgol;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by yuven on 2016-06-07.
 */
public class Viewpageradapter extends PagerAdapter {
    LayoutInflater inflater;

    public Viewpageradapter(LayoutInflater inflater){
        // TODO Auto-generated constructor stub
        this.inflater = inflater;
    }
    @Override
    public int getCount(){
        // TODO Auto-generated constructor stub
        return 3;   // 이미지 개수 리턴
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){

        View view = null;
        view=inflater.inflate(R.layout.viewpager_layout,null);
        ImageView img =(ImageView)view.findViewById(R.id.img_viewpager);
        img.setImageResource(R.drawable.title_01+position);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        // TODO Auto-generated method stub
        container.removeView((View)object);
    }
    @Override
    public boolean isViewFromObject(View v, Object obj){
        // TODO Auto-generated method stub
        return v==obj;
    }
}
