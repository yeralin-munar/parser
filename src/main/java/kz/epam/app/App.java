package kz.epam.app;

import kz.epam.file.Reader;
import kz.epam.file.Writer;
import kz.epam.main.Part;
import kz.epam.service.TextParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Yeralin Munar
 * date: 2/10/17
 */
public class App {
    public static void main(String[] args) throws IOException {

        TextParser textParser = new TextParser();
        Reader reader = new Reader();
        Writer writer = new Writer();
        String file = reader.getFile("text.txt");

        Part text = textParser.parse(file);
        writer.writeToFile(text.toString());


        Path path1 = Paths.get("text.txt");
        byte[] textFile = Files.readAllBytes(path1);

        Path path2 = Paths.get("mytext.txt");
        byte[] myTextFile = Files.readAllBytes(path2);

        System.out.println(textFile.length);
        System.out.println(myTextFile.length);


    }
}
