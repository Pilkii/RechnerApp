package souraka.first.rechnerapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadGameSetting();
    }

    private void loadGameSetting()  {
        TextView addcountera=(TextView) findViewById(R.id.addcounter);
        TextView subcounter=(TextView) findViewById(R.id.subcounter);
        TextView mulcounter=(TextView) findViewById(R.id.mulcounter);
        TextView divcounter=(TextView) findViewById(R.id.divcounter);
        TextView muncounter=(TextView) findViewById(R.id.muncount);
        SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        Calendar c=Calendar.getInstance();
        String date = sharedPreferences.getString("date", "");

        String currentdate= DateFormat.getDateInstance().format(c.getTime());
        if (!(date.equals(currentdate))){

            editor.putString("starrone","0");
            editor.putString("starttwo","0");
            editor.putString("starthree","0");
            editor.putString("starfour","0");
            editor.putString("starfive","0");
            editor.putString("date",currentdate);
            addcountera.setText("0");
            subcounter.setText("0");
            mulcounter.setText("0");
            divcounter.setText("0");
            muncounter.setText("0");
        }else {

            String[] counters=new String[5]; ImageView[] sterne=new ImageView[5];
            counters[0] = sharedPreferences.getString("starrone", "0");
            counters[2] = sharedPreferences.getString("starthree", "0");
            counters[3] = sharedPreferences.getString("starfour", "0");
            counters[4] = sharedPreferences.getString("starfive", "0");
            counters[1] = sharedPreferences.getString("starttwo", "0");
            sterne[0]= (ImageView) findViewById(R.id.imageView);
            sterne[1]= (ImageView) findViewById(R.id.imageView6);
            sterne[2]= (ImageView) findViewById(R.id.imageView3);
            sterne[3]= (ImageView) findViewById(R.id.imageView5);
            sterne[4]= (ImageView) findViewById(R.id.imageView2);

            for (int i=0;i<5;i++){
                if(Integer.valueOf(counters[i])>=10){
                   sterne[i].setImageResource(R.drawable.btn_star_big_on);
                }else{
                    sterne[i].setImageResource(R.drawable.btn_star_big_off);
                }
            }
                addcountera.setText(counters[0]);
                subcounter.setText(counters[1]);
                mulcounter.setText(counters[2]);
                divcounter.setText(counters[3]);
                muncounter.setText(counters[4]);
            }


        editor.apply();


    }
    public void changecount(android.view.View app) {
        this.loadGameSetting();
    }

    public void launchad(android.view.View app){
        Intent i=new Intent(this, Additionsac.class);
        startActivity(i);
    }
    public void launchmul(android.view.View app){
        Intent i=new Intent(this, MulAc.class);
        startActivity(i);
    }
    public void launchsub(android.view.View app){
        Intent i=new Intent(this, MainActivity2.class);
        startActivity(i);
    }
    public void launchdiv(android.view.View app){
        Intent i=new Intent(this, Diffac.class);
        startActivity(i);
    }
    public void launchmun(android.view.View app){
        Intent i=new Intent(this, Munzen.class);
        startActivity(i);
    }



}