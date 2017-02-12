package kz.epam.main;

import kz.epam.entity.Entity;
import sun.jvm.hotspot.debugger.cdbg.Sym;

/**
 * Created by munar on 2/10/17.
 */
public class Symbol extends Entity {
    private char symbol;

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return Character.toString((char)symbol);
    }
}
