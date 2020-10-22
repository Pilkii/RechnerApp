package souraka.first.rechnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Diffac extends AppCompatActivity {
    public int Zahl1;
    public int Zahl2;
    public int Zahl3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffac);
        Zahl1=(int)(Math.random()*10);
        Zahl2=(int)(Math.random()*9)+1;
        Zahl3=Zahl1*Zahl2;
        TextView textView = (TextView) findViewById(R.id.div5);
        TextView textView2 = (TextView) findViewById(R.id.div4);
        textView.setText(String.valueOf(Zahl2));
        textView2.setText(String.valueOf(Zahl3));
    }
    public void actionsdiv(View view){
        EditText et= findViewById(R.id.ErgebnisDiv);

        String sTextFromET = et.getText().toString();
        if(String.valueOf(Zahl3/Zahl2).equals(sTextFromET)){
            Toast.makeText(getApplicationContext(),"Genau, das Ergenis stimmt. Immer weiter so!", LENGTH_SHORT).show();
            SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            String staradd = sharedPreferences.getString("starfour", "0");
            String addd=String.valueOf(Integer.valueOf(staradd)+1);
            editor.putString("starfour",addd);
            editor.apply();
        }else{
            Toast.makeText(getApplicationContext(),"Das Ergebnis ist leider nicht richtig. Das korrekte Ergebnis lautet: "+(Zahl3/Zahl2)+". Versuche es doch erneut!", LENGTH_SHORT).show();
        }
        Zahl1=(int)(Math.random()*10);
        Zahl2=(int)(Math.random()*9)+1;
        Zahl3=Zahl1*Zahl2;
        TextView textView = (TextView) findViewById(R.id.div5);
        TextView textView2 = (TextView) findViewById(R.id.div4);
        textView.setText(String.valueOf(Zahl2));
        textView2.setText(String.valueOf(Zahl3));
        et.setText("");

    }
}