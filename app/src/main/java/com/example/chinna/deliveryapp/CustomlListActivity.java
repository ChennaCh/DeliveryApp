package com.example.chinna.deliveryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustomlListActivity extends AppCompatActivity {
    ListView list;

    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress"
    };
    Integer[] imageId = {
            R.drawable.google,
            R.drawable.google,
            R.drawable.google,
            R.drawable.google,
            R.drawable.google,
            R.drawable.google
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customl_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CustomList adapter = new CustomList(CustomlListActivity.this, web, imageId);
        list=(ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(CustomlListActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }

        });
    }
}
