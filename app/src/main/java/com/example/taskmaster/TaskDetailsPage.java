package com.example.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class TaskDetailsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TaskDetailsPage.this, MyTask.class);
                startActivity(intent);
            }
        });
// ----------------------- task 1 ----------------- got it when the user click to button task 1 and changed the main name in page from get and set
        Intent intent1 = getIntent();
        String task1 = intent1.getExtras().getString("task");

        TextView text1 = findViewById(R.id.taskName);
        text1.setText(task1);


        //---------------------------------------




    }


}