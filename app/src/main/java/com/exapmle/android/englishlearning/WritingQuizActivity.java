package com.exapmle.android.englishlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class WritingQuizActivity extends AppCompatActivity {
    private int difficulty;
    private int listId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_quiz);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            difficulty = bundle.getInt("difficulty");
            listId = bundle.getInt("listId");
        }

        WordLists wordLists = new WordLists();
        ArrayList list = null;
        switch (difficulty)
        {
            case 1:
                list = wordLists.getEasyList(listId);
                break;
            case 2:
                list = wordLists.getMediumList(listId);
                break;
            case 3:
                list = wordLists.getHardList(listId);
                break;
        }
        getSupportActionBar().setTitle("Quiz - "+wordLists.getCategoryName());

        Word xd = (Word) list.get(2);
        Toast.makeText(getApplicationContext(), ""+xd.getPolishWord(), Toast.LENGTH_LONG).show();

    }
}
