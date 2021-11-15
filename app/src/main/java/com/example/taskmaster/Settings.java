package com.example.taskmaster;

import static com.example.taskmaster.AddTask.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Button button = findViewById(R.id.submitUsername);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Settings.this , MyTask.class);
                EditText editText = findViewById(R.id.usernamePlanText);
                String username = editText.getText().toString();
                editor.putString("username", username);
                editor.apply();
//                startActivity(intent);

//              \


            }


        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Settings.this, MyTask.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("WrongViewCast")
    public void onclickbuttonMethod(View v) {

        RadioGroup radioGroup = findViewById(R.id.radio);

       RadioButton radioButton = findViewById(R.id.diamond);
        RadioButton radioButton1 = findViewById(R.id.master);
        RadioButton radioButton2 = findViewById(R.id.predators);



        String name = "";
        if (radioButton1.isChecked()) {
            name = "Master";
            Log.i(TAG, "onclickbuttonMethod: " + name);
        } else if (radioButton.isChecked()) {
            name = "Diamond";
            Log.i(TAG, "onclickbuttonMethod: " + name);
        } else if (radioButton2.isChecked()) {
            name = "Predators";
            Log.i(TAG, "onclickbuttonMethod: " + name);
//            editor.putString("team", radioButton.getText().toString());
        } else {
            name = "null";
            Log.i(TAG, "onclickbuttonMethod: " + name);
        }


        SharedPreferences sharedPreferences = getSharedPreferences("My Pr" , MODE_PRIVATE);

        sharedPreferences.edit().putString("TEAMID" , name).apply();
    }
}