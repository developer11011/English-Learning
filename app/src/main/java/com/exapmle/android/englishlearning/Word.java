package com.exapmle.android.englishlearning;

public class Word{
    private String mListName;
    private int mResImageId;


    private String mEnglishWord;
    private String mPolishWord;
    private String mPronunciation;


    public Word(String listName, int ResId)
    {
        mListName = listName;
        mResImageId = ResId;
    }

    public Word(String englishWord, String polishWord, String pronunciation)
    {
        mEnglishWord = englishWord;
        mPolishWord = polishWord;
        mPronunciation = pronunciation;
    }

    public String getListName()
    {
        return mListName;
    }
    public int getImageResId()
    {
        return mResImageId;
    }
    public String getEnglishWord(){ return mEnglishWord; }
    public String getPolishWord(){ return mPolishWord; }
    public String getPronunciation(){ return mPronunciation; }

}