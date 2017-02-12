package kz.epam.app;

import kz.epam.main.NonWord;
import kz.epam.main.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by munar on 2/10/17.
 */
public class App {
    public static void main(String[] args) throws IOException {

        String textString;

        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        try {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                if (line.equals("") == false){
                    sb.append(line);
                    sb.append("\n");
                }

                line = br.readLine();
            }
            textString = sb.toString();

        } finally {
            br.close();
        }


        Text text = new Text(textString);

        System.out.println(textString.equals(text.toString()));

    }
}
