package com.exapmle.android.englishlearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import static com.exapmle.android.englishlearning.R.id.bottom;
import static com.exapmle.android.englishlearning.R.id.hintButton;
import static com.exapmle.android.englishlearning.R.id.list;
import static com.exapmle.android.englishlearning.R.id.nextButton;


public class WritingQuizActivity extends AppCompatActivity {
    private int difficulty;
    private int listId;
    ArrayList list = null;
    String correctAnswer;
    String correctAnswerWithSpaces;
    String userTranslatedWord;
    int questionsCounter=1;
    int counter = 0;
    int[] askedWords = new int[50];
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
        updateQuestionNumber(questionsCounter);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismissKeyboard(WritingQuizActivity.this);
                userTranslatedWord = getUserInput();
                checkAnswer(userTranslatedWord, correctAnswer);
            }
        });

        final Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((list.size()-1)==counter)
                {
                    nextButton.setText("results");
                }
                if(list.size()==counter)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    resetResults();
                    displayWordToTranslate();
                    questionsCounter++;
                    updateQuestionNumber(questionsCounter);
                }
            }
        });

        Button finishButton = (Button) findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WritingQuizActivity.this, "to results activity", Toast.LENGTH_SHORT).show();
            }
        });

        Button hintButton = (Button) findViewById(R.id.hintButton);
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayHint();
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
        int randomLang = rand.nextInt(2);
        int randomWord = rand.nextInt(list.size());

        boolean finish = false;
        while(!finish) {
            randomWord = rand.nextInt(list.size());
            if (!contains(randomWord+1)) {
                askedWords[counter] = randomWord+1;
                finish = true;
            }
        }
        counter++;

        if(randomLang==0)
        {
            Word wordObject = (Word) list.get(randomWord);
            wordToTranslate = wordObject.getEnglishWord();
            correctAnswer = wordObject.getPolishWord();
            correctAnswerWithSpaces = correctAnswer;
            correctAnswer = wordObject.getPolishWord().replaceAll("\\s","").toLowerCase();
        }
        else
        {
            Word wordObject = (Word) list.get(randomWord);
            wordToTranslate = wordObject.getPolishWord();
            correctAnswer = wordObject.getEnglishWord();
            correctAnswerWithSpaces = correctAnswer;
            correctAnswer = wordObject.getEnglishWord().replaceAll("\\s","").toLowerCase();
        }
        TextView wordToTranslateTextView = (TextView) findViewById(R.id.wordToTranslate);
        wordToTranslateTextView.setText(wordToTranslate);
    }

    private String getUserInput()
    {
        EditText translatedWordEditText = (EditText) findViewById(R.id.translatedWord);
        String translated = translatedWordEditText.getText().toString().replaceAll("\\s","").toLowerCase();
        return translated;
    }

    private void checkAnswer(String a, String b)
    {
        boolean result = a.equals(b) ? true : false;
        TextView correctOrWrongTextView = (TextView) findViewById(R.id.resultTextView);
        TextView correctAnswerTextView = (TextView) findViewById(R.id.correctAnswerText);

        if(result)
        {
            correctOrWrongTextView.setText("Correct!");
            correctOrWrongTextView.setTextColor(Color.parseColor("#00ff00"));
            correctAnswerTextView.setText("");
        }
        else
        {
            correctOrWrongTextView.setText("Wrong!");
            correctOrWrongTextView.setTextColor(Color.parseColor("#ff0000"));
            correctAnswerTextView.setText("Right answer is: "+correctAnswerWithSpaces);
        }
    }

    private void resetResults()
    {
        TextView correctOrWrongTextView = (TextView) findViewById(R.id.resultTextView);
        TextView correctAnswerTextView = (TextView) findViewById(R.id.correctAnswerText);
        EditText insideEditText = (EditText) findViewById(R.id.translatedWord);
        insideEditText.setText("");
        correctAnswerTextView.setText("");
        correctOrWrongTextView.setText("");
    }
    private void updateQuestionNumber(int number)
    {
        TextView questionNumberTextView = (TextView) findViewById(R.id.wordCounter);
        questionNumberTextView.setText(number+"/"+list.size());
    }

    private void displayHint()
    {
        char firstChar, secondChar, thirdChar;
        firstChar = correctAnswerWithSpaces.charAt(0);
        secondChar = correctAnswerWithSpaces.charAt(1);
        thirdChar = correctAnswerWithSpaces.charAt(2);


        EditText insideEditText = (EditText) findViewById(R.id.translatedWord);
        insideEditText.setText(firstChar+""+secondChar+""+thirdChar);
    }

    private boolean contains(int item) {
        for (int n : askedWords) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }



}






