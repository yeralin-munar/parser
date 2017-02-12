package kz.epam.main;

import kz.epam.entity.Entity;

import java.util.ArrayList;

/**
 * Created by munar on 2/10/17.
 */
public class Word extends Entity {
    private ArrayList<Letter> letters = new ArrayList<Letter>();

    public Word(String word){
        addLetters(word);
    }

    private void addLetters(String word){
        for (char letter: word.toCharArray()){
            letters.add(new Letter(letter));
        }
    }

    @Override
    public String toString(){
        String lettersString = "";
        for (Letter letter: letters){
            lettersString += letter;
        }

        return lettersString;
    }
}
