package du_cs.dongmatgol;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by yuven on 2016-06-07.
 */
public class ListViewAdapter extends BaseAdapter {
    // Varialbes 선언
    Context mContext;
    LayoutInflater inflater;
    private List<valueset> valuesetList = null;
    private ArrayList<valueset> arrayList;
    public ListViewAdapter(Context context, List<valueset> valuesetList){
        mContext = context;
        this.valuesetList=valuesetList;
        inflater=LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<valueset>();
        this.arrayList.addAll(valuesetList);
    }
    public class ViewHolder{
        TextView name;
        TextView group;
        TextView tel;
        ImageView Fimage;
        int number;
    }

    @Override
    public int getCount(){
        return valuesetList.size();
    }
    @Override
    public valueset getItem(int position){
        return valuesetList.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    public View getView(final int position, View view, final ViewGroup parent){
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_layout, null);

            //Locate the TextViews in listview_layout.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.group = (TextView) view.findViewById(R.id.group);
            holder.tel = (TextView) view.findViewById(R.id.tel);

            //Locate the ImageViews in listview_layout.xml
            holder.Fimage = (ImageView) view.findViewById(R.id.Fimage);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //set the result into Textviews
        holder.name.setText(valuesetList.get(position).getName());
        holder.group.setText(valuesetList.get(position).getGroup());
        holder.tel.setText(valuesetList.get(position).getTel());
        //set the result into ImageView
        holder.Fimage.setImageResource(valuesetList.get(position).getFimage());

        //온클릭 했을때의 실행
        //Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, MenuPage.class);

                //position 값을 전부 전달
                intent.putExtra("number",valuesetList.get(position).getNumber());
                //Pass all data name
                intent.putExtra("name",valuesetList.get(position).getName());
                //Pass all data group
                intent.putExtra("group",valuesetList.get(position).getGroup());
                //Pass all data tel
                intent.putExtra("tel",valuesetList.get(position).getTel());

                //Start Itemview Class
                mContext.startActivity(intent);
            }
        });
        return view;
    }
    //Filter Class
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        valuesetList.clear();
        if (charText.length()==0){
            valuesetList.addAll(arrayList);
        }else {
            for (valueset VS : arrayList){
                if (VS.getName().toLowerCase(Locale.getDefault()).contains(charText)){
                    valuesetList.add(VS);
                }else if (VS.getGroup().toLowerCase(Locale.getDefault()).contains(charText)) {
                    valuesetList.add(VS);}
            }
        }
    }
}

