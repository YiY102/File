package com.example.main.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.one)    Button one;
    @BindView(R.id.two)   Button two;
    @BindView(R.id.three)   Button three;
    @BindView(R.id.four)   Button four;
    @BindView(R.id.five)   Button five;
    @BindView(R.id.six)   Button six;
    @BindView(R.id.seven)   Button seven;
    @BindView(R.id.eight)   Button eight;
    @BindView(R.id.nine)   Button nine;
    @BindView(R.id.zero)   Button zero;
    @BindView(R.id.delete)   Button delete;
    @BindView(R.id.devision)   Button devision;
    @BindView(R.id.multi)   Button multi;
    @BindView(R.id.plus)   Button plus;
    @BindView(R.id.minus)   Button minus;
    @BindView(R.id.finish)   Button finish;
    @BindView(R.id.alldelete)   Button alldelete;
    @BindView(R.id.persent)   Button persent;
    @BindView(R.id.numbertext)    EditText numbertext;
    String firstnum;

    int value;
    int valueplus = 1;
    int valueminus = 2;
    int valuemulti = 3;
    int valuedevision =4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);



    }   //oncreate끝





    @OnClick
    public void ButttonClick(View view){
     switch (view.getId()){
         case R.id.one:
            numbertext.setText(numbertext.getText().toString()+1);
            break;
         case R.id.two:
             numbertext.setText(numbertext.getText().toString()+2);
             break;
         case R.id.three:
             numbertext.setText(numbertext.getText().toString()+3);
             break;
         case R.id.four:
             numbertext.setText(numbertext.getText().toString()+4);
             break;
         case R.id.five:
             numbertext.setText(numbertext.getText().toString()+5);
             break;
         case R.id.six:
             numbertext.setText(numbertext.getText().toString()+6);
             break;
         case R.id.seven:
             numbertext.setText(numbertext.getText().toString()+7);
             break;
         case R.id.eight:
             numbertext.setText(numbertext.getText().toString()+8);
             break;
         case R.id.nine:
             numbertext.setText(numbertext.getText().toString()+9);
             break;
         case R.id.zero:
             numbertext.setText(numbertext.getText().toString()+0);
             break;
         case R.id.delete:
             if (numbertext.getText().toString() != ""){
                 numbertext.setText("");
             }
             break;
         case R.id.devision:
             firstnum =numbertext.getText().toString();
             numbertext.setText("");
             value = valuedevision;
             break;
         case R.id.multi:

             firstnum =numbertext.getText().toString();
             numbertext.setText("");
             value = valuemulti;
             break;
         case R.id.plus:

           firstnum =numbertext.getText().toString();
           numbertext.setText("");
           value = valueplus;
             break;
         case R.id.minus:
             firstnum =numbertext.getText().toString();
             numbertext.setText("");
             value = valueminus;
             break;

         case R.id.alldelete:
            numbertext.setText("");
            firstnum = "";
            value = 0;

             break;
         case R.id.persent:

             break;

         case R.id.finish:
             if (value==valueplus){
                 numbertext.setText(""+(Integer.parseInt(firstnum)+Integer.parseInt(numbertext.getText().toString())));
                 value =0;
             }else if(value==valueminus){
                 numbertext.setText(""+(Integer.parseInt(firstnum)-Integer.parseInt(numbertext.getText().toString())));
                 value =0;
             }else if(value==valuemulti){
                 numbertext.setText(""+(Integer.parseInt(firstnum)*Integer.parseInt(numbertext.getText().toString())));
                 value =0;
             }else if(value==valuedevision){
                 numbertext.setText(""+(Integer.parseInt(firstnum)/Integer.parseInt(numbertext.getText().toString())));
                 value =0;
             }
             firstnum = numbertext.getText().toString();
             break;


     }
}

}
