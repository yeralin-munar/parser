package kz.epam.main;

import kz.epam.entity.Entity;

import java.util.ArrayList;

/**
 * Created by munar on 2/10/17.
 */
public class NonWord extends Entity {
    private ArrayList<Symbol> symbols = new ArrayList<Symbol>();

    public NonWord(String nonWord){
        addSymbols(nonWord);
    }

    private void addSymbols(String nonWord){
        for (char symbol: nonWord.toCharArray()){
            symbols.add(new Symbol(symbol));
        }
    }

    @Override
    public String toString(){
        String symbolsString = "";
        for (Symbol symbol: symbols){
            symbolsString += symbol;
        }
        return symbolsString;
    }
}
