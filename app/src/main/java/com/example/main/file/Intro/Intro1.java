package com.example.main.file.Intro;

import android.app.Activity;
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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.main.file.HomeActivity;
import com.example.main.file.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by Administrator on 2018-02-21.
 */

public class Intro1 extends Fragment {

    @BindView(R.id.introtext1) TextView introtext1;
    @BindView(R.id.introtext2) TextView introtext2;
    @BindView(R.id.introtext3) TextView introtext3;
    @BindView(R.id.introtext4) TextView introtext4;
    @BindView(R.id.introtext5) TextView introtext5;

    public Intro1()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.intro1, container, false);
        ButterKnife.bind(this,layout);
        Typeface dongrami = Typeface.createFromAsset(getActivity().getAssets(), "fonts/dongrami.ttf");
        Typeface misaeng = Typeface.createFromAsset(getActivity().getAssets(), "fonts/misaeng.ttf");

        introtext1.setTypeface(dongrami);
        introtext2.setTypeface(misaeng);
        introtext3.setTypeface(misaeng);
        introtext4.setTypeface(misaeng);


        return layout;




    }
    @OnClick(R.id.introtext5)
    public void setIntrotext5(View view){
        SharedPreferences SPref = getContext().getSharedPreferences("Intro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = SPref.edit();
        editor.putInt("check",2);
        editor.apply();

        Intent intent = new Intent(getActivity(),HomeActivity.class);
        startActivity(intent);

    }

}