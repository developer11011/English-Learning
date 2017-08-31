package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ChooseDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_difficulty);

        LinearLayout difficultyA = (LinearLayout) findViewById(R.id.difficultyA);
        LinearLayout difficultyB = (LinearLayout) findViewById(R.id.difficultyB);
        LinearLayout difficultyC = (LinearLayout) findViewById(R.id.difficultyC);
        LinearLayout difficultyOwnLists = (LinearLayout) findViewById(R.id.difficultyOwnLists);

        difficultyA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DifficultyAActivity.class);
                startActivity(intent);
            }
        });

        difficultyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DifficultyBActivity.class);
                startActivity(intent);
            }
        });

        difficultyC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DifficultyCActivity.class);
                startActivity(intent);
            }
        });

        difficultyOwnLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getApplicationContext(), DifficultyOwmListsActivity.class);
                startActivity(intent);*/
                Toast.makeText(ChooseDifficultyActivity.this, "Ta opcja jest jeszcze w budowie!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
