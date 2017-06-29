package com.mycompany.myapplication.content;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Food;
import com.mycompany.myapplication.dto.Logo;

import java.util.ArrayList;
import java.util.List;

public class LogoList extends LinearLayout{
    private static final String TAG = ReviewList.class.getSimpleName();
    private ListView listView;
    private List<Logo> list = new ArrayList<>();
    private LogoList.ItemAdapter itemAdapter;

    public LogoList(Context context) {
        super(context);
        LayoutInflater inflater =  LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.logo_list, null);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        addView(listView);
    }
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Food food = (Food) itemAdapter.getItem(position);
            Log.i(TAG, food.getFname());
            Log.i(TAG, food.getFdesc());
        }
    };

    class ItemAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position).getLno();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                //Item UI 객체 생성(inflation)
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.logo_item, null);
            }
            //데이터 세팅
            TextView lno = (TextView) convertView.findViewById(R.id.lno);
            ImageView lphoto = (ImageView) convertView.findViewById(R.id.lphoto);
            TextView lname = (TextView) convertView.findViewById(R.id.lname);
            ImageView lstar = (ImageView) convertView.findViewById(R.id.lstar);
            Logo logo = list.get(position);
            lphoto.setImageResource(logo.getLphoto());
            lname.setText(logo.getLname());
            lstar.setImageResource(logo.getLstar());
            lno.setText(logo.getLno() + "등");

            return convertView;
        }
    }

    public void addItem(Logo item) {
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Logo item){
        list.remove(item);
        itemAdapter.notifyDataSetChanged();
    }

}
