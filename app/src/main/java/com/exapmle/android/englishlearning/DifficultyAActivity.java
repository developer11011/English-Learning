package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DifficultyAActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        ArrayList<Word> listsNames = new ArrayList<Word>();
        listsNames.add(new Word("At the airport", R.drawable.plane_image));

        WordAdapter theAdapter = new WordAdapter(this, listsNames, R.color.difficultyEasy);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(theAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), DisplayFinalListActivity.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("withDifficulty", 1);
                startActivity(intent);
            }
        });


    }
}
