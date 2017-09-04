package com.exapmle.android.englishlearning;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;


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

    }


    public void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getApplicationWindowToken(), 0);
    }

}
