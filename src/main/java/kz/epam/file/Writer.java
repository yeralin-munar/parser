package kz.epam.file;

import java.io.*;

/**
 * @author Yeralin Munar
 *         date: 2/21/17
 */
public class Writer {

    public Writer(){}

    public void writeToFile(String text){
        try (java.io.Writer writer = new BufferedWriter(new OutputStreamWriter(
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
}
