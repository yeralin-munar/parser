package kz.epam.service;

import kz.epam.main.Part;
import kz.epam.main.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Yeralin Munar(munar)
 * date: 2/20/17
 */
public class TextParser {
    private static String REGEX_PARAGRAPH = "(.*[\n]{1,2}|.*)";
    private static String REGEX_SENTENCE = "([\\w\\s\\d[\\W&&[^.!?]]]+[.!?\\s]+)";
    private static String REGEX_SENTENCE_PART = "(([А-Яа-яa-zA-Z])+([^\1]?[\\-\\d\\s.!?();,«»])+)";
    //private static String REGEX_WORD_SYMBOLS = "([А-Яа-я]+|[- \\W\\d]+([^\\t]+?))";

    public TextParser(){

    }

    public Part parse(String file){
        Part text;
        text = parseText(file);
        return text;
    }



    private Part parseText(String file){
        Part paragraphs = new Part();

        Pattern paragraphPattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher paragraphMatcher = paragraphPattern.matcher(file);

        while (paragraphMatcher.find()){
            Part paragraph = parseParagraph(paragraphMatcher.group(1));
            paragraphs.addElement(paragraph);
        }
        return paragraphs;
    }

    private Part parseParagraph(String paragraphText){
        Part sentences = new Part();

        Pattern sentencePattern = Pattern.compile(REGEX_SENTENCE);
        Matcher sentenceMatcher = sentencePattern.matcher(paragraphText);

        while (sentenceMatcher.find()){
            Part sentence = parseSentencePart(sentenceMatcher.group(1));
            sentences.addElement(sentence);
        }
        return sentences;
    }

    private Part parseSentencePart(String sentenceText){
        Part sentenceParts = new Part();

        Pattern sentencePartPattern = Pattern.compile(REGEX_SENTENCE_PART);
        Matcher sentencePartMatcher = sentencePartPattern.matcher(sentenceText);

        while (sentencePartMatcher.find()){
            Part sentencePart = parseSymbols(sentencePartMatcher.group(1));
            sentenceParts.addElement(sentencePart);
        }
        return sentenceParts;
    }

    private Part parseSymbols(String wordText){
        Part word = new Part();
        for (char ch: wordText.toCharArray()){
            word.addElement(new Symbol(ch));
        }
        return word;
    }

}
