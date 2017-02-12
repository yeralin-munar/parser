package kz.epam.main;

import kz.epam.entity.Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by munar on 2/10/17.
 */
public class SentencePart extends Entity {
    private Word word;
    private NonWord nonWord;

    public SentencePart(String sentencePart){
        sentencePartParser(sentencePart);
    }

    public void sentencePartParser(String sentencePart){
        Pattern wordPattern = Pattern.compile("([А-Яа-я]+|[- \\W\\d]+([\n]?))");
        Matcher wordMatcher = wordPattern.matcher(sentencePart);

        wordMatcher.find();
        word = new Word(wordMatcher.group(1));

        wordMatcher.find();
        nonWord = new NonWord(wordMatcher.group(1));
    }

    @Override
    public String toString(){
        return word.toString() + nonWord.toString();
    }
}
