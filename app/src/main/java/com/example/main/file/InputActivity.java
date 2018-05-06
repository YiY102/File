package com.example.main.file;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {

    @BindView(R.id.AreaSpinner)    Spinner AreaSpinner;
    @BindView(R.id.storename_tv)    TextView storename_tv;
    @BindView(R.id.storename_etv)    EditText storename_etv;
    @BindView(R.id.location_tv)    TextView location_tv;
    @BindView(R.id.storefood_tv)    TextView storefood_tv;
    @BindView(R.id.leview_tv)    TextView leview_tv;
    @BindView(R.id.leview_etv)    EditText leview_etv;
    @BindView(R.id.img0)    ImageView img0;
    @BindView(R.id.imgAdd_btn)    Button imgAdd_btn;
    @BindView(R.id.write_suc)    Button write_suc;
    String area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        ButterKnife.bind(this);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/baemin.ttf");

        storename_tv.setTypeface(font1);
        location_tv.setTypeface(font1);
        storefood_tv.setTypeface(font1);
        leview_tv.setTypeface(font1);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        AreaSpinner.setAdapter(adapter);

        AreaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("test","선택된값은"+i);



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }//oncreate 끝

    @OnClick(R.id.imgAdd_btn)
    public void setImgAdd_btn(View view) {


    }
    @OnClick(R.id.write_suc)
    public void setWrite_suc(View view) {
        String name = storename_etv.getText().toString();
        String leview = leview_etv.getText().toString();
        String location = AreaSpinner.getSelectedItem().toString();
        Intent homeintent = getIntent();
        homeintent.putExtra("name",name);
        homeintent.putExtra("leview",leview);
        homeintent.putExtra("location",location);
        setResult(RESULT_OK,homeintent);
        finish();



    }
}