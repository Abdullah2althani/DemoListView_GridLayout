package com.go_m.demolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Adapter_Contact_item> listnewsData = new ArrayList<Adapter_Contact_item>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView listView = (GridView) findViewById(R.id.ListView_mainLayout);


        //add data and view it
        listnewsData.add(new Adapter_Contact_item(R.drawable.dose_img_0, "Capsule "));
        listnewsData.add(new Adapter_Contact_item(R.drawable.dose_img_1, "Capsule1 "));
        listnewsData.add(new Adapter_Contact_item(R.drawable.dose_img_2, "Capsule2 "));

        myadapter = new MyCustomAdapter(listnewsData);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Adapter_Contact_item adapterView = listnewsData.get(position);
                TextView eventName = (TextView) view.findViewById(R.id.DoseName);
                String s = (String) eventName.getText();
                Toast.makeText(getApplicationContext(), s + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void Adding_new_MedicineItem(View view) {
        listnewsData.add(new Adapter_Contact_item(R.drawable.dose_img_1, "developer new"));
        myadapter.notifyDataSetChanged();
    }

    //display news list
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<Adapter_Contact_item> listnewsDataAdpater;

        public MyCustomAdapter(ArrayList<Adapter_Contact_item> listnewsDataAdpater) {
            this.listnewsDataAdpater = listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_contact, null);

            final Adapter_Contact_item s = listnewsDataAdpater.get(position);

            ImageView image = (ImageView) myView.findViewById(R.id.img);
            image.setImageResource(s.ImgID);

            TextView name = (TextView) myView.findViewById(R.id.DoseName);
            name.setText(s.OptionName);

            return myView;
        }

    }
}
