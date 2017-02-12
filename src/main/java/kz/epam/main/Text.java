package kz.epam.main;

import kz.epam.entity.Entity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by munar on 2/10/17.
 */
public class Text extends Entity {
    private ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();

    public Text(String text){
        parserText(text);
    }

    private void parserText(String text){
        Pattern paragraphPattern = Pattern.compile("(.*[\n]{1,2}|.*)");
        Matcher paragraphMatcher = paragraphPattern.matcher(text);

        while (paragraphMatcher.find()){
            paragraphs.add(new Paragraph(paragraphMatcher.group(1)));
        }
    }

    @Override
    public String toString(){
        String paragraphsString = "";
        for (Paragraph paragraph: paragraphs){
            paragraphsString += paragraph;
        }

        return paragraphsString;
    }
}
