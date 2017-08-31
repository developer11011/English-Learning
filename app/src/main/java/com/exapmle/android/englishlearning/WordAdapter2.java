package com.exapmle.android.englishlearning;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikig on 24.08.2017.
 */

public class WordAdapter2 extends ArrayAdapter<Word> {
    private int backgroundColor;
    private int backgroundColorLight;
    int withColor=1;

    public WordAdapter2(@NonNull Context context, @NonNull List<Word> objects, int colorRes, int lightColorRes) {
        super(context, 0, objects);
        backgroundColor = colorRes;
        backgroundColorLight = lightColorRes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null)
        {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_2, parent, false);
        }
        Word currentWord = getItem(position);

        TextView englishWord = listItem.findViewById(R.id.english_text_view);
        englishWord.setText(currentWord.getEnglishWord());

        TextView polishWord = listItem.findViewById(R.id.polish_text_view);
        polishWord.setText(currentWord.getPolishWord());

        LinearLayout background = (LinearLayout) listItem.findViewById(R.id.finalListBackground);
        int color = ContextCompat.getColor(getContext(), backgroundColor);
        int lightColor = ContextCompat.getColor(getContext(), backgroundColorLight);


            if (withColor == 1) {
                background.setBackgroundColor(color);
                withColor = 2;
            } else if (withColor == 2) {
                background.setBackgroundColor(lightColor);
                withColor = 1;
            }

        return listItem;
    }
}
