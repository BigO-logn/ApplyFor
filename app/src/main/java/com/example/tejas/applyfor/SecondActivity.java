package com.example.tejas.applyfor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText hometown, age;
    TextView proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Assign();
        OnProceedClick();
    }

    private void Assign(){
        hometown=findViewById(R.id.etHomeTown);
        age=findViewById(R.id.etAge);
        proceed=findViewById(R.id.tvProceed);
    }

    private void OnProceedClick(){
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
                Validate();
                //startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
    }

    private void Validate(){
        if(hometown.getText().toString().trim().isEmpty() && !age.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Ghar kahan hai?", Toast.LENGTH_SHORT).show();
        }
        else if (!hometown.getText().toString().trim().matches("") && age.getText().toString().trim().matches("")){
            Toast.makeText(this, "What is the umar?",
                    Toast.LENGTH_SHORT).show();
        }
        else if(hometown.getText().toString().trim().matches("") && age.getText().toString().trim().matches("")){
            Toast.makeText(this, "Enter Details!", Toast.LENGTH_SHORT).show();
        }
        else{
            startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
        }
    }
    private void SaveData(){
        SharedPreferences mySPF = getSharedPreferences("My_Prefs",MODE_PRIVATE);
        SharedPreferences.Editor myEditor= mySPF.edit();
        myEditor.putString("hometown",hometown.getText().toString());
        myEditor.putString("age", age.getText().toString());
        myEditor.commit();

    }
}