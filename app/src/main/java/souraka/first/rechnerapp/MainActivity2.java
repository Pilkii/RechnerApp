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

public class MainActivity2 extends AppCompatActivity {
    public int Zahl1;
    public int Zahl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Zahl1=(int)(Math.random()*100);
        Zahl2=(int)(Math.random()*100);
        TextView textView = (TextView) findViewById(R.id.subtextView4);
        TextView textView2 = (TextView) findViewById(R.id.subtextView5);
        textView.setText(String.valueOf(Zahl1));
        textView2.setText(String.valueOf(Zahl2));
    }
    public void actionsub(View view){
        EditText et= findViewById(R.id.subEdit);

        String sTextFromET = et.getText().toString();
        if(String.valueOf(Zahl1-Zahl2).equals(sTextFromET)){
            Toast.makeText(getApplicationContext(),"Das Ergenis war richtig Souraka!", LENGTH_SHORT).show();
            SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            String staradd = sharedPreferences.getString("starttwo", "0");
            String adds=String.valueOf(Integer.valueOf(staradd)+1);
            editor.putString("starttwo",adds);
            editor.apply();
        }else{
            Toast.makeText(getApplicationContext(),"Das Ergebnis ist leider nicht richtig. Das korrekte Ergebnis lautet: "+(Zahl1-Zahl2)+". Versuche es doch erneut!", LENGTH_SHORT).show();
        }
        Zahl1=(int)(Math.random()*100);
        TextView textView = (TextView) findViewById(R.id.subtextView4);
        TextView textView2 = (TextView) findViewById(R.id.subtextView5);
        textView.setText(String.valueOf(Zahl1));
        Zahl2=(int)(Math.random()*100);
        textView2.setText(String.valueOf(Zahl2));
        et.setText("");
    }
}