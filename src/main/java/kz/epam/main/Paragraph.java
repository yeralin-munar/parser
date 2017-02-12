package kz.epam.main;

import kz.epam.entity.Entity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by munar on 2/10/17.
 */
public class Paragraph extends Entity {
    private ArrayList<Sentence> sentences = new ArrayList<Sentence>();

    public Paragraph(String paragraph){
        parserParagraph(paragraph);
    }

    private void parserParagraph(String paragraph){
        Pattern sentencePattern = Pattern.compile("([\\w\\s\\d[\\W&&[^.!?]]]+[.!?]+[\\s]?[\n]?)");
        Matcher sentenceMatcher = sentencePattern.matcher(paragraph);

        while (sentenceMatcher.find()){
            sentences.add(new Sentence(sentenceMatcher.group(1)));
        }
    }

    @Override
    public String toString(){
        String sentencesString = "";
        for (Sentence sentence: sentences){
            sentencesString += sentence;
        }

        return sentencesString;
    }
}
