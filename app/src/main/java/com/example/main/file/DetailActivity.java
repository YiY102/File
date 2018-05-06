package com.example.main.file;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    @BindView(R.id.id_detail_text) TextView id_detail_text;
    @BindView(R.id.id_detail_text2) TextView id_detail_text2;
    @BindView(R.id.id_detail_text3) TextView id_detail_text3;
    @BindView(R.id.id_detail_back_btn) Button id_detail_back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();


        id_detail_text.setText(intent.getStringExtra("storename"));
        id_detail_text2.setText(intent.getStringExtra("storeleview"));
        id_detail_text3.setText(intent.getStringExtra("strorelocation"));



    }
    @OnClick(R.id.id_detail_back_btn)
    public void setId_detail_back_btn(View view){
        finish();
    }
}
