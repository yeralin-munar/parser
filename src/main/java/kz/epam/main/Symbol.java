package kz.epam.main;

/**
 * Created by munar on 2/10/17.
 */
public class Symbol implements Composite {
    private char symbol;

    public Symbol(){};

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    public void addElement(Composite composite) {

    }

    public void removeElement(Composite composite) {

    }

    public Composite getElement(int index) {
        return null;
    }

    @Override
    public String toString(){
        return Character.toString((char)symbol);
    }
}
