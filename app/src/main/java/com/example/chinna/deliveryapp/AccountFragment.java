package com.example.chinna.deliveryapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;


public class AccountFragment extends Fragment {
    TextView pincode;
    Fragment f;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_account, container, false);
//        Context context= getActivity().getApplicationContext();
        SharedPreferences preferences = this.getActivity().getSharedPreferences("app",Context.MODE_PRIVATE);
        String name = preferences.getString("ename",null);
        pincode = (TextView) v.findViewById(R.id.pincode);
        pincode.setText(name);

        return v;
    }

}