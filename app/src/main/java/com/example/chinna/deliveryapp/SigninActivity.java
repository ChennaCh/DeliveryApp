package com.example.chinna.deliveryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    Button bt,terms;
    EditText postalcode;

    private static int SPLASH_TUME_OUT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        postalcode = (EditText) findViewById(R.id.postalcode) ;

        bt = (Button) findViewById(R.id.go);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();
                View toastRoot = inflater.inflate(R.layout.toast, null);

                Toast toast = new Toast(getApplicationContext());
                // Set layout to toast
                toast.setView(toastRoot);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,0, 0);
                toast.setDuration(SPLASH_TUME_OUT);
                toast.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                },SPLASH_TUME_OUT);

                String name = postalcode.getText().toString();

                SharedPreferences preferences = getSharedPreferences("app",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("ename",name);
                editor.commit();





//                GifImageView gifImageView = (GifImageView) findViewById(R.id.Gif);
//                gifImageView.setGifImageResource(R.drawable.giphy);

//                LayoutInflater inflater = getLayoutInflater();
//                View toastRoot = inflater.inflate(R.layout.toast, null);
//
////                // Call toast.xml file for toast layout
////                toastRoot = gifImageView.setGifImageResource(R.drawable.giphy);
//
//                Toast toast = new Toast(getApplicationContext());
//                // Set layout to toast
//                toast.setView(toastRoot);
//                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
//                        0, 0);
//                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.show();

            }
        });

        terms = (Button) findViewById(R.id.btn);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TermsCondtions.class);
                startActivity(intent);
            }
        });

    }

}
