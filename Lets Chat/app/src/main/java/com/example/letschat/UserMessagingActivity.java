package com.example.letschat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.letschat.R;

import java.util.ArrayList;

public class UserMessagingActivity extends AppCompatActivity {

    private static final String TAG = "UserMessagingActivity";
    ListView list;

    int[] img = {R.drawable.account_circle_icon};
    String[] name = {"User","kewfgwe","jbfjwehfk","khkrfjhrbf","hdbev"};
    String[] description = {"Last Message","Last Message","Last Message","Last Message","Last Message"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_messaging);

        list=findViewById(R.id.theList);

        CustomAdapter adapter=new CustomAdapter();
        list.setAdapter(adapter);
//
//        ArrayList<String> names=new ArrayList<>();
//        names.add("sdfewefe wfgvbh");
//        names.add("sdfgvcwe ewfwevbh");
//        names.add("sdfgv cefwsevcbh");
//        names.add("scbdwe dwqdewgvbh");
//        names.add("sdwwwwfg dchdcdcvbh");
//        names.add("sdfgvbef tbrh");
//        names.add("sdfgv fqrvrtbh");
//
//        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, names);
//        list.setAdapter(adapter);

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.activity_custom_listview,null);

            ImageView imageView=view.findViewById(R.id.icon);
            TextView username=view.findViewById(R.id.username);
            TextView descript=view.findViewById(R.id.description);

            imageView.setImageResource(img[position]);
            username.setText(name[position]);
            descript.setText(description[position]);

            return view;
        }
    }
}
