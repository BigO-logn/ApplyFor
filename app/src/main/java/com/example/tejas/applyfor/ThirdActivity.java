package com.example.tejas.applyfor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    TextView result, retry, quit;
    Button newLife;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        LoadData();
        Declarations();
        OnRetry();
        OnQuit();
        OnNewLife();
    }
    private void OnNewLife()
    {
        newLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this,NewLifeActivity.class));
                Toast.makeText(ThirdActivity.this, "Good Luck!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void OnRetry(){
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mySPF=getApplicationContext().getSharedPreferences("My_Prefs", MODE_PRIVATE);
                SharedPreferences.Editor myEditor = mySPF.edit();
                myEditor.clear();
                myEditor.commit();
                Toast.makeText(getApplicationContext(), "Values Reset", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ThirdActivity.this,MainActivity.class));
            }
        });
    }
    private void OnQuit(){
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Bye Loser!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void Declarations(){
        retry= findViewById(R.id.tvretry);
        quit=findViewById(R.id.tvQuit);
        newLife=findViewById(R.id.btnNewLife);

    }
    public void LoadData(){
        SharedPreferences mySPF=getApplicationContext().getSharedPreferences("My_Prefs", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySPF.edit();
        String name= mySPF.getString("nameEntered","No Name");
        String skills=mySPF.getString("skillsEntered","No Skills");
        String hometown=mySPF.getString("hometown","No Hometown");
        String age=mySPF.getString("age","No Age");
        myEditor.commit();
        String output="We have no job for " +age +" year old " +name+ " from " +hometown+" with such nominal skills as " +skills+
                "! Thanks for trying!";

        result=findViewById(R.id.tvResult);
        result.setText(output);
    }
}
