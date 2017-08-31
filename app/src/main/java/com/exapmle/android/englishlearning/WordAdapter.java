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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;
import static com.exapmle.android.englishlearning.R.color.backgroundApp;

/**
 * Created by mikig on 24.08.2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int background;
    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects, int colorRes) {
        super(context, 0, objects);
        background = colorRes;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null)
        {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView listName = listItem.findViewById(R.id.list_name_text_view);
        listName.setText(currentWord.getListName());

        View dificultyColorText = (View) listItem.findViewById(R.id.difficultyColorText);
        View dificultyColorImage = (View) listItem.findViewById(R.id.difficultyColorImage);
        View dificultyColorLayout = (View) listItem.findViewById(R.id.difficultyColorLayout);

        int color = ContextCompat.getColor(getContext(), background);

        dificultyColorText.setBackgroundColor(color);
        dificultyColorImage.setBackgroundColor(color);
        dificultyColorLayout.setBackgroundColor(color);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.listImage);
        imageView.setImageResource(currentWord.getImageResId());

        return listItem;
    }
}
