package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DifficultyBActivity extends AppCompatActivity {
    private boolean isQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        ArrayList<Word> listsNames = new ArrayList<Word>();
        listsNames.add(new Word("Crime", R.drawable.crime_image));
        listsNames.add(new Word("City slang", R.drawable.slang_image));
        listsNames.add(new Word("Medicine", R.drawable.medicines_icon));

        WordAdapter theAdapter = new WordAdapter(this, listsNames, R.color.difficultyMedium);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(theAdapter);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            isQuiz = bundle.getBoolean("isQuiz");
        }

        if(isQuiz==true)
        {
            getSupportActionBar().setTitle("Medium - quiz");
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent intent = new Intent(getApplicationContext(), ChooseQuizTypeActivity.class);
                    intent.putExtra("difficulty", 2);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
        }
        else {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent intent = new Intent(getApplicationContext(), DisplayFinalListActivity.class);
                    intent.putExtra("itemPosition", position);
                    intent.putExtra("withDifficulty", 2);
                    startActivity(intent);
                }
            });
        }

    }
}
