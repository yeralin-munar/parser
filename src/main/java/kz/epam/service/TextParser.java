package kz.epam.service;

import kz.epam.main.Composite;
import kz.epam.main.Part;
import kz.epam.main.Symbol;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by munar on 2/20/17.
 */
public class TextParser {
    private static String REGEX_PARAGRAPH = "(.*[^\\t]+|.*)";
    private static String REGEX_SENTENCE = "([\\w\\s\\d[\\W&&[^.!?]]]+[.!?]+[^\\t]+)";
    private static String REGEX_SENTENCE_PART = "([А-Яа-я]+[- \\s\\W\\d]+[^\\t]+)";
    //private static String REGEX_WORD_SYMBOLS = "([А-Яа-я]+|[- \\W\\d]+([^\\t]+?))";

    public TextParser(){

    }

    public Part parse(String path){
        String file = getFile(path);
        Part text = new Part();
        text = parseText(text, file);
        writeToFile(text.toString());
        return text;
    }

    private String getFile(String path){
        String text = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            text = new String(data, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    private void writeToFile(String text){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("mytext.txt"), "utf-8"))) {
            writer.write(text);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Part parseText(Part text, String file){
        Part paragraph = new Part();

        Pattern paragraphPattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher paragraphMatcher = paragraphPattern.matcher(file);

        while (paragraphMatcher.find()){
            paragraph = parseParagraph(paragraph, paragraphMatcher.group(1));
            text.addElement(paragraph);
        }
        return text;
    }

    private Part parseParagraph(Part paragraph, String paragraphText){
        Part sentence = new Part();

        Pattern sentencePattern = Pattern.compile(REGEX_SENTENCE);
        Matcher sentenceMatcher = sentencePattern.matcher(paragraphText);

        while (sentenceMatcher.find()){
            sentence = parseSentencePart(sentence, sentenceMatcher.group(1));
            paragraph.addElement(sentence);
        }
        return paragraph;
    }

    private Part parseSentencePart(Part sentence, String sentenceText){
        Part sentencePart = new Part();

        Pattern sentencePartPattern = Pattern.compile(REGEX_SENTENCE_PART);
        Matcher sentencePartMatcher = sentencePartPattern.matcher(sentenceText);

        while (sentencePartMatcher.find()){
            sentencePart = parseSymbols(sentencePart, sentencePartMatcher.group(1));
            sentence.addElement(sentencePart);
        }
        return sentence;
    }

    /*
    private Part parseWordAndSymbols(Part sentencePart, String sentencePartText){
        Part word = new Part();
        Part symbols = new Part();

        Pattern wordAndSymbolsPattern = Pattern.compile(REGEX_WORD_SYMBOLS);
        Matcher wordAndSymbolsMatcher = wordAndSymbolsPattern.matcher(sentencePartText);

        wordAndSymbolsMatcher.find();
        word = parseSymbols(word, wordAndSymbolsMatcher.group(1));
        sentencePart.addElement(word);

        wordAndSymbolsMatcher.find();
        symbols = parseSymbols(symbols, wordAndSymbolsMatcher.group(1));
        sentencePart.addElement(symbols);

        return sentencePart;
    }*/

    private Part parseSymbols(Part word, String wordText){
        for (char ch: wordText.toCharArray()){
            word.addElement(new Symbol(ch));
        }
        return word;
    }

}
