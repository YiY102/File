package com.example.main.file.Intro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.main.file.HomeActivity;
import com.example.main.file.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018-02-21.
 */

public class Intro0 extends Fragment {

    @BindView(R.id.topText1) TextView toptext1;
    @BindView(R.id.topText2) TextView toptext2;
    @BindView(R.id.topText3) TextView toptext3;
    @BindView(R.id.topText4) TextView toptext4;


    public Intro0()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getContext().getSharedPreferences("Intro", Context.MODE_PRIVATE);
        int check = pref.getInt("check",0);
       if (check==2){
           Intent intent = new Intent(getActivity(),HomeActivity.class);
           startActivity(intent);
       }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



            RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.intro0, container, false);
            ButterKnife.bind(this, layout);
            Typeface introfont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/introfont.ttf");

            toptext1.setTypeface(introfont);
            toptext2.setTypeface(introfont);
            toptext3.setTypeface(introfont);
            toptext4.setTypeface(introfont);


            return layout;
        }


}


