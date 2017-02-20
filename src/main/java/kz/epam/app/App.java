package kz.epam.app;

import kz.epam.main.Part;
import kz.epam.service.TextParser;


/**
 * Created by munar on 2/10/17.
 */
public class App {
    public static void main(String[] args) {

        TextParser textParser = new TextParser();
        Part text = textParser.parse("text.txt");

        System.out.println(text);

    }
}
