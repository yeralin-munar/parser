package kz.epam.main;

import kz.epam.entity.Entity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by munar on 2/10/17.
 */
public class Sentence extends Entity {
    private ArrayList<SentencePart> sentenceParts = new ArrayList<SentencePart>();

    public Sentence(String sentence){
        parserSentence(sentence);
    }

    private void parserSentence(String sentence){
        Pattern sentencePartPattern = Pattern.compile("([А-Яа-я]+[- \\s\\W\\d]+[\n]?)");
        Matcher sentencePartMatcher = sentencePartPattern.matcher(sentence);

        while (sentencePartMatcher.find()){
            sentenceParts.add(new SentencePart(sentencePartMatcher.group(1)));
        }
    }

    @Override
    public String toString(){
        String sentencePartString = "";
        for (SentencePart sentencePart: sentenceParts){
            sentencePartString += sentencePart;
        }

        return sentencePartString;
    }
}
