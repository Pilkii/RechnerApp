package souraka.first.rechnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Munzen extends AppCompatActivity {
    public String Ecc="0";
    public String Ccc="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munzen);
        this.loadSetting();

    }

    private void loadSetting()  {
       ImageView[] Munten=new ImageView[9];
        Munten[0]=(ImageView) findViewById(R.id.imageView15);
        Munten[1]=(ImageView) findViewById(R.id.imageView22);
        Munten[2]=(ImageView) findViewById(R.id.imageView17);
        Munten[3]=(ImageView) findViewById(R.id.imageView20);
        Munten[4]=(ImageView) findViewById(R.id.imageView9);
        Munten[5]=(ImageView) findViewById(R.id.imageView21);
        Munten[6]=(ImageView) findViewById(R.id.imageView23);
        Munten[7]=(ImageView) findViewById(R.id.imageView30);
        Munten[8]=(ImageView) findViewById(R.id.imageView24);
        int Zahl1=(int)(Math.random()*5)+4;
        int Ec=0;int Cc=0;
        for (int i=0;i<9;i++){
            if (i<Zahl1){
                int Zahl2=(int)(Math.random()*8);
                if (Zahl2==0){
                    Munten[i].setImageResource(R.drawable.guu);
                    Munten[i].setVisibility(View.VISIBLE);
                    Cc+=1;
                }else if(Zahl2==1){
                    Munten[i].setImageResource(R.drawable.zweient);
                    Munten[i].setVisibility(View.VISIBLE);
                    Cc+=2;
                }else if (Zahl2==2){
                    Munten[i].setImageResource(R.drawable.funfent);
                    Munten[i].setVisibility(View.VISIBLE);
                    Cc+=5;
                }else if(Zahl2==3){
                    Munten[i].setImageResource(R.drawable.zehnent);
                    Munten[i].setVisibility(View.VISIBLE);
                    Cc+=10;
                }else if (Zahl2==4){
                    Munten[i].setImageResource(R.drawable.zwanzigent);
                    Munten[i].setVisibility(View.VISIBLE);
                    Cc+=20;
                }else if(Zahl2==5){
                    Munten[i].setImageResource(R.drawable.funfzigent);
                    Munten[i].setVisibility(View.VISIBLE);
                    Cc+=50;
                }else if(Zahl2==6){
                    Munten[i].setImageResource(R.drawable.einuro);
                    Munten[i].setVisibility(View.VISIBLE);
                    Ec++;
                }else {
                    Munten[i].setImageResource(R.drawable.zweiuro);
                    Munten[i].setVisibility(View.VISIBLE);
                    Ec+=2;
                }
            }else{
                Munten[i].setVisibility(View.INVISIBLE);
            }
        }
        Ec+=Cc/100;
        Cc%=100;
        Ecc=String.valueOf(Ec);
        Ccc=String.valueOf(Cc);
    }
    public void comparr(android.view.View app) {
        EditText cCedit= findViewById(R.id.ergebnisAdd2);
        EditText eCedit= findViewById(R.id.ergebnisAdd);
        String sTextFromET1 = cCedit.getText().toString();
        String sTextFromET2 = eCedit.getText().toString();
        if (Ccc.equals(sTextFromET1)&&Ecc.equals(sTextFromET2)){
            Toast.makeText(getApplicationContext(),"Weiter so! Das Ergebnis stimmt!", LENGTH_SHORT).show();
            SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            String staradd = sharedPreferences.getString("starfive", "0");
            String addc=String.valueOf(1+Integer.valueOf(staradd));
            editor.putString("starfive",addc);
            editor.apply();

        }else{
            Toast.makeText(getApplicationContext(),"Das Ergebnis ist leider nicht richtig. Korrekt wäre, dass du "+Ecc+" Euro und "+Ccc+" Cent siehst. Versuche es doch erneut!", LENGTH_SHORT).show();
        }
        this.loadSetting();
        cCedit.setText("");
        eCedit.setText("");
    }
}