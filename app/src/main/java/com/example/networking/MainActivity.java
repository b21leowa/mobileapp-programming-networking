package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    //Test commit

    private ArrayList<String> mountainList = new ArrayList<>();

    private RecyclerView recyclerView;

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonFile(this, this).execute(JSON_FILE);

        recyclerView = findViewById(R.id.recyclerView);
        MountainAdapter mountainAdapter = new MountainAdapter(mountainList);
        recyclerView.setAdapter(mountainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public void onPostExecute(String json) {
        mountainList.add(json);
        Log.d("MainActivity", json);
    }

}
