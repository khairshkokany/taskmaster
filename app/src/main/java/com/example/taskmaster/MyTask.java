package com.example.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task);

        Button button = findViewById(R.id.AddTask);
// toolbar jamal
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTask.this , AddTask.class);
                startActivity(intent);
            }
        });

            Button button1 = findViewById(R.id.AllTasks);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(MyTask.this , AllTask.class);
                    startActivity(intent1);
                }
            });

        Button button2 = findViewById(R.id.task1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTask.this , TaskDetailsPage.class);
                String task1 = "This Is Task 1 Nothing Is Here Go To Task 2 Please .! ";
                intent.putExtra("task" , task1);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.task2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTask.this , TaskDetailsPage.class);
                String task2 = "Umm Can You Go Out Please I'm So Busy Ty :) ";
                intent.putExtra("task" , task2);
                startActivity(intent);
            }
        });
            Button button4 = findViewById(R.id.task3);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent4 = new Intent(MyTask.this , TaskDetailsPage.class);
                    String task3 = "Umm After You Finshed From Task 1 and 2 You Come To Me ? , Please Get Out And Don't let Me See U Again :)";
                    intent4.putExtra("task" , task3);
                    startActivity(intent4);
                }
            });
            Button button5 = findViewById(R.id.Settings);
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent5 = new Intent(MyTask.this , Settings.class);
                    startActivity(intent5);
                }
            });


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("username","hello user");

        TextView user = findViewById(R.id.username);
        user.setText("Welcome "  +  username);



    }
}