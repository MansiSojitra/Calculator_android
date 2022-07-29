package com.mansi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText et;
    Button bt[] = new Button[19];
    int id[]={R.id.btClear , R.id.btBack , R.id.btPer ,
              R.id.bt9 , R.id.bt8 , R.id.bt7 ,  R.id.btDiv,
            R.id.bt6 , R.id.bt5 , R.id.bt4,  R.id.btMul,
            R.id.bt3 , R.id.bt2 , R.id.bt1 ,  R.id.btSub,
            R.id.btDot , R.id.bt0 , R.id.btEqual ,  R.id.btSum};
    int i;
    String num="";
    int sum=0,sub=0,mul=0,div=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);

        for(i=0; i<bt.length;i++){
            bt[i] = findViewById(id[i]);
            bt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                     Button b = (Button)view;
                     String label = b.getText().toString();

                     if(label.equals("CLEAR")){
                         et.setText("0");
                         num="";
                         sum=0;
                     }
                     else if(label.equals("Back")){
                         if(num.length()>0){
                             num = num.substring(0,num.length()-1);
                             et.setText(num);
                         }
                     }
                     else if(label.equals("+")){
                         if(sum==0){
                             sum = Integer.parseInt(num);
                             num = "";
                         }
                         else{
                             sum = sum + Integer.parseInt(num);
                             num = "";
                         }

                         if(num.length()>0){
                             et.setText(""+sum);
                         }

                     }
                     else if(label.equals("-")){
                         if (sub == 0){
                             sub = Integer.parseInt(num);
                             num = "";
                         }
                         else{
                             sub = sub - Integer.parseInt(num);
                             num="";
                         }
                         et.setText(""+sub);
                     }

                     else if(label.equals("*")){
                         if (mul == 0){
                             mul = Integer.parseInt(num);
                             num = "";
                         }
                         else{
                             mul = mul * Integer.parseInt(num);
                             num="";
                         }
                         et.setText(""+mul);
                     }

                     else if(label.equals("/")){
                         if (div == 0){
                             div = Integer.parseInt(num);
                             num = "";
                         }
                         else{
                             div = div / Integer.parseInt(num);
                             num="";
                         }
                         et.setText(""+div);
                     }
                     else{
                         num = num+label;
                         et.setText(num);
                     }
                }

            });
        }



    }
}