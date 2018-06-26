package com.example.tejas.applyfor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,skills;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssignValues();

        OnButtonClick();


    }


    public void SPFsave(){
        SharedPreferences mySPF= getSharedPreferences("My_Prefs", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySPF.edit();
        myEditor.putString("nameEntered",name.getText().toString());
        myEditor.putString("skillsEntered",skills.getText().toString());
        myEditor.commit();
    }

    private void AssignValues(){
        name=findViewById(R.id.etName);
        skills=findViewById(R.id.etSkill);
        submit=findViewById(R.id.btnSubmit);
    }

    private void OnButtonClick(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPFsave();
                Validate();
           //     startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
    private void Validate(){
        if(name.getText().toString().trim().matches("") && !skills.getText().toString().trim().matches("")){
            Toast.makeText(this, "Naam nahi to kaam nahi", Toast.LENGTH_SHORT).show();
        }
        else if (skills.getText().toString().trim().matches("") && !name.getText().toString().trim().matches("")){
            Toast.makeText(this, "Degree without skill is worth nothing. Come, Make in India!",
                    Toast.LENGTH_LONG).show();
        }
        else if(skills.getText().toString().trim().matches("") && name.getText().toString().trim().matches("")){
            Toast.makeText(this, "Enter Details!", Toast.LENGTH_SHORT).show();
        }
        else if (!skills.getText().toString().trim().matches("") && !name.getText().toString().trim().matches("")){
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }
    }


}