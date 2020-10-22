package souraka.first.rechnerapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class Additionsac extends AppCompatActivity {
    public int Zahl1;
    public int Zahl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additionsac);
        Zahl1=(int)(Math.random()*100);
        TextView textView = (TextView) findViewById(R.id.Zahl1Add);
        TextView textView2 = (TextView) findViewById(R.id.Zahl2Add);
        textView.setText(String.valueOf(Zahl1));
        Zahl2=(int)(Math.random()*100);
        textView2.setText(String.valueOf(Zahl2));


    }


    public void actions(View view){


       EditText et= findViewById(R.id.ErgebnisAdd);

        String sTextFromET = et.getText().toString();
        if(String.valueOf(Zahl1+Zahl2).equals(sTextFromET)){
            Toast.makeText(getApplicationContext(),"Sehr gut gemacht Souraka!", LENGTH_SHORT).show();
            SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            String staradd = sharedPreferences.getString("starrone", "0");
            String addc=String.valueOf(Integer.valueOf(staradd)+1);
            editor.putString("starrone",addc);
            editor.apply();
        }else{
            Toast.makeText(getApplicationContext(),"Das Ergebnis ist leider nicht richtig. Das korrekte Ergebnis lautet: "+(Zahl1+Zahl2)+". Versuche es doch erneut!", LENGTH_SHORT).show();
        }
       Zahl1=(int)(Math.random()*100);
        TextView textView = (TextView) findViewById(R.id.Zahl1Add);
        TextView textView2 = (TextView) findViewById(R.id.Zahl2Add);
        textView.setText(String.valueOf(Zahl1));
        Zahl2=(int)(Math.random()*100);
        textView2.setText(String.valueOf(Zahl2));
        et.setText("");
    }
}
