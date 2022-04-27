package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    //Test commit

    private ArrayList<Mountain> mountainList = new ArrayList<>();

    private RecyclerView recyclerView;
    MountainAdapter mountainAdapter;

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);



        recyclerView = findViewById(R.id.recyclerView);
        mountainAdapter = new MountainAdapter(this, mountainList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mountainAdapter);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Mountain>>() {}.getType();
        ArrayList<Mountain> fetchedMountainList = gson.fromJson(json, type);
        mountainList.addAll(fetchedMountainList);
        mountainAdapter.notifyDataSetChanged();
        Log.d("MainActivity", json);
    }

}
