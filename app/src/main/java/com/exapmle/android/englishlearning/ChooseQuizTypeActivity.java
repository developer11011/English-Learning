package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseQuizTypeActivity extends AppCompatActivity {
    int difficulty;
    int listId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_quiz_type);

        LinearLayout writingQuiz = (LinearLayout) findViewById(R.id.quizWriting);
        LinearLayout ABCDQuiz = (LinearLayout) findViewById(R.id.quizABCD);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            difficulty = bundle.getInt("difficulty");
            listId = bundle.getInt("position");
        }

        WordLists wordLists = new WordLists();
        switch (difficulty)
        {
            case 1:
                wordLists.getEasyList(listId);
                int color = ContextCompat.getColor(getApplicationContext(), R.color.difficultyEasy);
                writingQuiz.setBackgroundColor(color);
                ABCDQuiz.setBackgroundColor(color);
                break;
            case 2:
                wordLists.getMediumList(listId);
                int color1 = ContextCompat.getColor(getApplicationContext(), R.color.difficultyMedium);
                writingQuiz.setBackgroundColor(color1);
                ABCDQuiz.setBackgroundColor(color1);
                break;
            case 3:
                 wordLists.getHardList(listId);
                int color2 = ContextCompat.getColor(getApplicationContext(), R.color.difficultyHard);
                writingQuiz.setBackgroundColor(color2);
                ABCDQuiz.setBackgroundColor(color2);
                break;
        }

        TextView textView = (TextView) findViewById(R.id.forWithList);
        textView.setText("Choose quiz type for "+wordLists.getCategoryName());
        getSupportActionBar().setTitle("Quiz type - "+wordLists.getCategoryName());

        writingQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WritingQuizActivity.class);
                intent.putExtra("difficulty", difficulty);
                intent.putExtra("listId", listId);
                startActivity(intent);
            }
        });

        ABCDQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
