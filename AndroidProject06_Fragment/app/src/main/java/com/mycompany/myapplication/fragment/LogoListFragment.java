package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.content.LogoList;
import com.mycompany.myapplication.dto.Food;
import com.mycompany.myapplication.dto.Logo;

import java.util.ArrayList;
import java.util.List;

public class LogoListFragment extends Fragment {
    private static final String TAG = "LogoListFragment";
    private ListView listView;
    private List<Logo> list = new ArrayList<>();
    private ItemAdapter itemAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listView = (ListView) inflater.inflate(R.layout.fragment_logo_list, container, false);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i=1; i<=10; i++) {
            Logo logo = new Logo();
            logo.setLno(i);
            logo.setLname("로고"+i);
            logo.setLphoto(getResources().getIdentifier("logo"+i, "drawable", getContext().getPackageName()));
            logo.setLstar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));

            addItem(logo);
        }

    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Logo logo = (Logo) itemAdapter.getItem(position);
            Log.i(TAG, logo.getLname());
        }
    };
    class ItemAdapter extends BaseAdapter {

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
