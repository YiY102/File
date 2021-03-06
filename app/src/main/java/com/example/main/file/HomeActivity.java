package com.example.main.file;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.file.DB.DbManager;
import com.example.main.file.Model.Content;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.content_listview)  ListView content_listview;
    @BindView(R.id.listAdd_btn)    Button listAdd_btn;
    @BindView(R.id.titlebar)    TextView titlebar;
    ArrayList<Content>HomeArraylist = new ArrayList<>();
    ListViewAdapter listViewAdapter;
    Content content;
    DbManager dbManager;
    Cursor cursor;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ButterKnife.bind(this);
        Typeface titlefont = Typeface.createFromAsset(getAssets(), "fonts/baemin.ttf");
        titlebar.setTypeface(titlefont);
        //db생성완료
        dbManager = new DbManager(
                HomeActivity.this,"FoodStore.db",null,1);


        listViewAdapter = new ListViewAdapter(HomeArraylist,HomeActivity.this,dbManager);
        content_listview.setAdapter(listViewAdapter);
        content_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Content item = HomeArraylist.get(i);

              Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("storename",item.getName());
                intent.putExtra("storereview",item.getReview());
                intent.putExtra("strorelocation",item.getLocation());
                intent.putExtra("writetime",item.getTime());
                intent.putExtra("storescore",item.getScore());


                startActivity(intent);



            }
        });




    }//oncreate끝

    @OnClick(R.id.listAdd_btn)
    public void setListAdd_btn(View view){
        Intent listadd = new Intent(getApplicationContext(),InputActivity.class);
        startActivityForResult(listadd,0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==0) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                String review = data.getStringExtra("review");
                String location= data.getStringExtra("location");
                String time = data.getStringExtra("time");
                String score = data.getStringExtra("score");



                content = new Content(name,review,location,time,score);
                dbManager.insertData(name,review,location,time,score);



                HomeArraylist.add(content);
                listViewAdapter = new ListViewAdapter(HomeArraylist, HomeActivity.this,dbManager);

                content_listview.setAdapter(listViewAdapter);


            }
        }
    }




}
