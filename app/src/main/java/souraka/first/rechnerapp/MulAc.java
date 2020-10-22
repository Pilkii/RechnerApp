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

public class MulAc extends AppCompatActivity {
    public int Zahl1;
    public int Zahl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul);
        Zahl1=(int)(Math.random()*10);
        Zahl2=(int)(Math.random()*10);
        TextView textView = (TextView) findViewById(R.id.Multex5);
        TextView textView2 = (TextView) findViewById(R.id.Multex6);
        textView.setText(String.valueOf(Zahl1));
        textView2.setText(String.valueOf(Zahl2));
    }

    public void actionsmul(View view){
        EditText et= findViewById(R.id.ErgebnisMul);

        String sTextFromET = et.getText().toString();
        if(String.valueOf(Zahl1*Zahl2).equals(sTextFromET)){
            Toast.makeText(getApplicationContext(),"Sehr schön. Wenn du dich anstrengst schaffst du auch die nächste!", LENGTH_SHORT).show();
            SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            String staradd = sharedPreferences.getString("starthree", "0");
            String addm=String.valueOf(Integer.valueOf(staradd)+1);
            editor.putString("starthree",addm);
            editor.apply();
        }else{
            Toast.makeText(getApplicationContext(),"Das Ergebnis ist leider nicht richtig. Das korrekte Ergebnis lautet: "+(Zahl1*Zahl2)+". Versuche es doch erneut!", LENGTH_SHORT).show();
        }
        Zahl1=(int)(Math.random()*10);
        TextView textView = (TextView) findViewById(R.id.Multex6);
        TextView textView2 = (TextView) findViewById(R.id.Multex5);
        textView.setText(String.valueOf(Zahl1));
        Zahl2=(int)(Math.random()*10);
        textView2.setText(String.valueOf(Zahl2));
        et.setText("");

    }
}