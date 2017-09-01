package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DifficultyCActivity extends AppCompatActivity {
    private boolean isQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        ArrayList<Word> listsNames = new ArrayList<Word>();
        listsNames.add(new Word("Business words", R.drawable.buizness_image));
        listsNames.add(new Word("Human organs", R.drawable.organs_image));
        listsNames.add(new Word("Math", R.drawable.math_image));
        listsNames.add(new Word("Most useful", R.drawable.useful_image));;

        WordAdapter theAdapter = new WordAdapter(this, listsNames, R.color.difficultyHard);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(theAdapter);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            isQuiz = bundle.getBoolean("isQuiz");
        }

        if(isQuiz==true)
        {
            getSupportActionBar().setTitle("Hard - quiz");
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent intent = new Intent(getApplicationContext(), ChooseQuizTypeActivity.class);
                    intent.putExtra("difficulty", 3);
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
                    intent.putExtra("withDifficulty", 3);
                    startActivity(intent);
                }
            });
        }
    }
}
