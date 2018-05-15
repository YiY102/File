package com.example.main.file.Intro;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.main.file.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018-02-21.
 */

public class Intro0 extends Fragment {

    public Intro0()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.intro0, container, false);
        ButterKnife.bind(this,layout);
        Typeface ko_font3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/baemin..ttf");


        return layout;
    }
}


