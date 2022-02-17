package edu.wctc.springmvcdictionary.entity;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private static List<Word> dictionary = new ArrayList<>();

    private Dictionary(){};

    public static void addWord(Word word) {
        dictionary.add(word);
    }
    public static List<Word> getWords() {
        return dictionary;
    }
    public static Word getWord(Word word) {
        //logic that searches wordList and assigns definition to word
        return word;
    }
}
