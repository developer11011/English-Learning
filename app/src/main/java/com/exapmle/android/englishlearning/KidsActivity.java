package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class KidsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        LinearLayout learn = (LinearLayout) findViewById(R.id.LearnKids);
        LinearLayout quiz = (LinearLayout) findViewById(R.id.QuizKids);

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Wersja dla dzieci jest jeszcze w budowie.", Toast.LENGTH_SHORT).show();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Wersja dla dzieci jest jeszcze w budowie.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
