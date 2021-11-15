package com.example.taskmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Details;
import com.amplifyframework.datastore.generated.model.Team;

import java.util.ArrayList;
import java.util.List;

public class MyTask extends AppCompatActivity {
    public static final String TAG = "Main Activity";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task);

        Button button = findViewById(R.id.AddTask);
// toolbar jamal
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MyTask.this, AddTask.class);
                            startActivity(intent);
                        }
                    });

                    Button button1 = findViewById(R.id.AllTasks);

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1 = new Intent(MyTask.this, AllTask.class);
                            startActivity(intent1);
                        }
                    });

                    Button button5 = findViewById(R.id.Settings);
                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent5 = new Intent(MyTask.this, Settings.class);
                            startActivity(intent5);
                        }
                    });

//        ArrayList<com.amplifyframework.datastore.generated.model.Details> detailsArrayList = new ArrayList<com.amplifyframework.datastore.generated.model.Details>();

//        detailsArrayList.add(new com.amplifyframework.datastore.generated.model.Details("998" , "master" , "khair shkokany","lab 33 is so bad for me " , "in progress"));
//        detailsArrayList.add(new com.amplifyframework.datastore.generated.model.Details("998" , "master" , "khair shkokany","lab 33 is so bad for me " , "in progress"));
//        detailsArrayList.add(new com.amplifyframework.datastore.generated.model.Details("998" , "master" , "khair shkokany","lab 33 is so bad for me " , "in progress"));
//        detailsArrayList.add(new com.amplifyframework.datastore.generated.model.Details("998" , "master" , "khair shkokany","lab 33 is so bad for me " , "in progress"));
//        detailsArrayList.add(new Details("Error1" , "Please Make Sure You Put a Correct Data Ty :) " , "Assigned"));
//        detailsArrayList.add(new Details("Test" , "Please Waiting We Are Checking If You Have A Error Or Not !" , "in Progress "));
//        detailsArrayList.add(new Details("Information" , "Nice Everything Is Good You Can Discover Our Application Thank You For Choosing Us " , "Complete"));

//        // here I Will Take The Recycler View
//        RecyclerView taskRec = findViewById(R.id.recyclerViewMain);
//
//        // here we will set the layout manger
//
//        taskRec.setLayoutManager(new LinearLayoutManager(this));
//
//        // here we will set the  adapter for this recycler view
//        taskRec.setAdapter(new DetailsAdapter(detailsArrayList));

                    try {
                        Amplify.addPlugin(new AWSApiPlugin());
                        Amplify.configure(getApplicationContext());
                        Log.i(TAG, "onCreate: initialized Amplify");

                    } catch (AmplifyException e) {
                        Log.e(TAG, "onCreate: Colud not initialize Amplify ", e);
                    }

//            List<com.amplifyframework.datastore.generated.model.Details> detailsList = new ArrayList<>();
//            RecyclerView alltasks = findViewById(R.id.recyclerViewMain);
//            alltasks.setLayoutManager(new LinearLayoutManager(this));
//            alltasks.setAdapter(new DetailsAdapter(detailsList));
//        Log.i(TAG, "onCreate: this is details List From RecycleView     " + detailsList);
//            Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
//                @Override
//                public boolean handleMessage(@NonNull Message message) {
//                    Log.i(TAG, "handleMessage: " + alltasks.toString());
//                    return false;
//                }
//            });

                }

        @Override
        protected void onResume() {
            super.onResume();

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String username = sharedPreferences.getString("username", "hello user");
            TextView user = findViewById(R.id.username);
            user.setText("Welcome " + username);
            String team = sharedPreferences.getString("team", "hello team");

            TextView teamName = findViewById(R.id.teamName);
            teamName.setText(team);

//        teamSeeds(sharedPreferences);
// ---------START---------- this is for room database locally -------------------
            // this is to get the database and render it in my task with recyclerView
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "database-name").allowMainThreadQueries().build();
//        TaskDao taskDao = db.taskDao();
//        List<Details> detailsList = taskDao.getAll();

//        RecyclerView taskRec = findViewById(R.id.recyclerViewMain);

            // here we will set the layout manger

//        taskRec.setLayoutManager(new LinearLayoutManager(this));
//
//        // here we will set the  adapter for this recycler view
//        taskRec.setAdapter(new DetailsAdapter(detailsList));

// ------------------- this is for room database locally ---------END----------

            getTeam();


        }

//    private void teamSeeds(SharedPreferences sharedPreferences){
//
//        String TAG = "teamSeeds";
//        List<Team> teamList = new ArrayList<>();
//        teamList.add(Team.builder().title("team1").build());
//        teamList.add(Team.builder().title("team2").build());
//        teamList.add(Team.builder().title("team3").build());
//
//        Amplify.API.mutate(ModelMutation.create(teamList.get(0)) ,
//                success -> {
//                if (success.getData().getTitle() != null) {
//                    sharedPreferences.edit().putString(String.valueOf(teamList.get(0)), success.getData().getTitle()).apply();
//
//                }
//
//                } , error -> {
//                    Log.i(TAG, "teamSeeds: errors is here " + error.toString());
//                });
//        Amplify.API.mutate(ModelMutation.create(teamList.get(1)) ,
//                success -> {
//                    if (success.getData().getTitle() != null) {
//                        sharedPreferences.edit().putString(String.valueOf(teamList.get(1)), success.getData().getTitle()).apply();
//
//                    }
//
//                } , error -> {
//                    Log.i(TAG, "teamSeeds: errors is here " + error.toString());
//                });
//        Amplify.API.mutate(ModelMutation.create(teamList.get(2)) ,
//                success -> {
//                    if (success.getData().getTitle() != null) {
//                        sharedPreferences.edit().putString(String.valueOf(teamList.get(2)), success.getData().getTitle()).apply();
//
//                    }
//
//                } , error -> {
//                    Log.i(TAG, "teamSeeds: errors is here " + error.toString());
//                });
//}



        private void getTeam () {
            List <com.amplifyframework.datastore.generated.model.Details> detailsList = new ArrayList<>();
            List <com.amplifyframework.datastore.generated.model.Details> detailsList1 = new ArrayList<>();
            SharedPreferences sharedPreferences = getSharedPreferences("My Pr" , MODE_PRIVATE);
            String TeamName = sharedPreferences.getString("TEAMID" , null);
            TextView teamName = findViewById(R.id.teamName);
            teamName.setText(TeamName);
            RecyclerView alltasks = findViewById(R.id.recyclerViewMain);
            alltasks.setLayoutManager(new LinearLayoutManager(this));
            alltasks.setAdapter(new DetailsAdapter(detailsList , this));
            Handler handler = new Handler(Looper.myLooper(), new Handler.Callback() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public boolean handleMessage(@NonNull Message message) {
                    alltasks.getAdapter().notifyDataSetChanged();
                    return false;
                }
            });



            Amplify.API.query(ModelQuery.list(com.amplifyframework.datastore.generated.model.Details.class) ,
                    response -> {
                        for (com.amplifyframework.datastore.generated.model.Details details : response.getData()) {
                            Log.i("graph of khair is here for testing ", details.getTitle());
                            detailsList.add(details);
                            Log.i(TAG, "onCreate: this is the getTeam Function Please tell me the list Array of RecyclerView " + detailsList);
//                        for (int i = 0; i < detailsList.size(); i++) {
//                            if (detailsList.get(i).getTeamId().equals(TeamName)){
////                                detailsList1.addAll(detailsList.get(i).getTitle());
//                            }
//                        }
                        }
                        handler.sendEmptyMessage(1);

                },
                error -> Log.e(TAG, "onCreate: Query failure",error )
        );


    }



//    private void recView () {
//
//
//    }



}