package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class StandardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        LinearLayout learn = (LinearLayout) findViewById(R.id.LearnStandard);
        LinearLayout quiz = (LinearLayout) findViewById(R.id.QuizStandard);

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseDifficultyActivity.class);
                startActivity(intent);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseDifficultyActivity.class);
                intent.putExtra("isQuiz", true);
                startActivity(intent);
            }
        });


    }
}
