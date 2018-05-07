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
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;

public class InputActivity extends AppCompatActivity {

    @BindView(R.id.AreaSpinner)    Spinner AreaSpinner;
    @BindView(R.id.storename_tv)    TextView storename_tv;
    @BindView(R.id.storename_etv)    EditText storename_etv;
    @BindView(R.id.location_tv)    TextView location_tv;
    @BindView(R.id.storefood_tv)    TextView storefood_tv;
    @BindView(R.id.review_tv)    TextView review_tv;
    @BindView(R.id.review_etv)    EditText review_etv;
    @BindView(R.id.img0)    ImageView img0;
    @BindView(R.id.imgAdd_btn)    Button imgAdd_btn;
    @BindView(R.id.write_suc)    Button write_suc;
    @BindView(R.id.WriteTime)    TextView WriteTime;

    String storescore;
    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String formatDate = sdfNow.format(date);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        ButterKnife.bind(this);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/baemin.ttf");

        storename_tv.setTypeface(font1);
        location_tv.setTypeface(font1);
        storefood_tv.setTypeface(font1);
        review_tv.setTypeface(font1);
//지역스피너
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
//커스텀라디오버튼
        RadioRealButtonGroup group2 = (RadioRealButtonGroup) findViewById(R.id.radioRealButtonGroup_2);
        group2.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
            //Toast.makeText(InputActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
                if (position==0){
                    storescore = "좋음";
                }else if (position==1){
                    storescore = "중간";
                }else if(position==2){
                    storescore = "나쁨";
                }
            }
        });


    }//oncreate 끝

    @OnClick(R.id.imgAdd_btn)
    public void setImgAdd_btn(View view) {


    }
    @OnClick(R.id.write_suc)
    public void setWrite_suc(View view) {
        String name = storename_etv.getText().toString();
        String review = review_etv.getText().toString();
        String location = AreaSpinner.getSelectedItem().toString();
        String time = formatDate;

        Intent homeintent = getIntent();
        homeintent.putExtra("name",name);
        homeintent.putExtra("review",review);
        homeintent.putExtra("location",location);
        homeintent.putExtra("time",time);
        homeintent.putExtra("score",storescore);
        setResult(RESULT_OK,homeintent);
        finish();



    }
}