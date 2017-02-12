package kz.epam.main;

import kz.epam.entity.Entity;

/**
 * Created by munar on 2/10/17.
 */
public class Letter extends Entity {
    private char letter;

    public Letter(char letter){
        this.letter = letter;
    }

    @Override
    public String toString(){
        return Character.toString(letter);
    }
}
