package com.exapmle.android.englishlearning;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;



public class WritingQuizActivity extends AppCompatActivity {
    private int difficulty;
    private int listId;
    ArrayList list = null;
    String correctAnswer;
    String userTranslatedWord;
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


        displayWordToTranslate();

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismissKeyboard(WritingQuizActivity.this);

                userTranslatedWord = getUserInput();
                boolean isAnswerCorrect = checkAnswer(correctAnswer, userTranslatedWord);

                Toast.makeText(WritingQuizActivity.this, ""+isAnswerCorrect, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getApplicationWindowToken(), 0);
    }

    private void displayWordToTranslate()
    {
        String wordToTranslate;

        Random rand = new Random();
        int randomWord = rand.nextInt(list.size());
        int randomLang = rand.nextInt(2);
        if(randomLang==0)
        {
            Word wordObject = (Word) list.get(randomWord);
            wordToTranslate = wordObject.getEnglishWord();
            correctAnswer = wordObject.getPolishWord();
        }
        else
        {
            Word wordObject = (Word) list.get(randomWord);
            wordToTranslate = wordObject.getPolishWord();
            correctAnswer = wordObject.getEnglishWord();
        }
        TextView wordToTranslateTextView = (TextView) findViewById(R.id.wordToTranslate);
        wordToTranslateTextView.setText(wordToTranslate);
    }

    private String getUserInput()
    {
        EditText translatedWordEditText = (EditText) findViewById(R.id.translatedWord);
        String translated = translatedWordEditText.getText().toString();
        return translated;
    }

    private boolean checkAnswer(String a, String b)
    {
        return a.equals(b) ? true : false;
    }


}
