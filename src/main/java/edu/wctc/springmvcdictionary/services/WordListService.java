package edu.wctc.springmvcdictionary.services;

import edu.wctc.springmvcdictionary.entity.Word;

import java.util.List;

public interface WordListService {
    List<Word> getWords();
    String getWord(String word);
    Word getDefinition(Word word);
}
