package com.exapmle.android.englishlearning;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.interpolator.linear;
import static android.media.CamcorderProfile.get;

public class DisplayFinalListActivity extends AppCompatActivity {
    int itemPosition;
    int withDifficulty;
    ArrayList listToDisplayPronunciation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_word_list);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            itemPosition = bundle.getInt("itemPosition");
            withDifficulty = bundle.getInt("withDifficulty");
        }
        final WordLists wordList = new WordLists();

        if(withDifficulty==1) {
                 setAdapter(wordList.getEasyList(itemPosition), wordList.getCategoryName(), R.color.difficultyEasy, R.color.difficultyEasyLight);
                 listToDisplayPronunciation = wordList.getEasyList(itemPosition);
        }

        else if(withDifficulty==2) {
                setAdapter(wordList.getMediumList(itemPosition), wordList.getCategoryName(), R.color.difficultyMedium, R.color.difficultyMediumLight);
            listToDisplayPronunciation = wordList.getMediumList(itemPosition);
        }

        else if(withDifficulty==3) {
                setAdapter(wordList.getHardList(itemPosition), wordList.getCategoryName(), R.color.difficultyHard, R.color.difficultyHardLight);
                listToDisplayPronunciation = wordList.getHardList(itemPosition);
        }

        ListView listView = (ListView) findViewById(R.id.listFinal);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {;
                Word word = (Word) listToDisplayPronunciation.get(position);
                String pronunciation = word.getPronunciation();
                Toast.makeText(getApplicationContext(), ""+pronunciation, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAdapter(ArrayList a, String title, int color, int colorLight)
    {
        WordAdapter2 theAdapter = new WordAdapter2(this, a, color, colorLight);
        ListView listView = (ListView) findViewById(R.id.listFinal);
        listView.setAdapter(theAdapter);
        getSupportActionBar().setTitle(title);
    }


}
