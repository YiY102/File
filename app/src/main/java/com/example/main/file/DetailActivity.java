package com.example.main.file;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Main on 2018-04-20.
 */

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.detail_name) TextView detail_name;
    @BindView(R.id.detail_review) TextView detail_review;
    @BindView(R.id.detail_location) TextView detail_location;
    @BindView(R.id.detail_writetime) TextView detail_writetime;

    @BindView(R.id.detail_score) TextView detail_score;
    @BindView(R.id.score_tv) TextView score_tv;
    @BindView(R.id.score_tv2) TextView score_tv2;
    @BindView(R.id.id_detail_back_btn) Button id_detail_back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        ButterKnife.bind(this);

        Typeface misaeng = Typeface.createFromAsset(getAssets(), "fonts/misaeng.ttf");
        Typeface dongrami = Typeface.createFromAsset(getAssets(), "fonts/dongrami.ttf");
        Typeface solmee = Typeface.createFromAsset(getAssets(), "fonts/solmee.ttf");
        detail_name.setTypeface(solmee);
        detail_name.setSingleLine(true);
        detail_review.setTypeface(misaeng);
        detail_review.setMovementMethod(new ScrollingMovementMethod());
        detail_writetime.setTypeface(solmee);
        detail_score.setTypeface(misaeng);
        score_tv.setTypeface(misaeng);
        score_tv2.setTypeface(misaeng);





        Intent intent = getIntent();
        detail_name.setText(intent.getStringExtra("storename"));
        detail_review.setText(intent.getStringExtra("storereview"));
        detail_location.setText(intent.getStringExtra("strorelocation"));
        detail_writetime.setText(intent.getStringExtra("writetime"));
        detail_score.setText(intent.getStringExtra("storescore"));


    }
    @OnClick(R.id.id_detail_back_btn)
    public void setId_detail_back_btn(View view){
        finish();
    }
}
