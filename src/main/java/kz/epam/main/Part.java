package kz.epam.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeralin Munar
 * date: 2/20/17
 */
public class Part implements Composite{
    private List<Composite> parts = new ArrayList<Composite>();

    public Part(){

    }

    public void addElement(Composite composite) {
        parts.add(composite);
    }

    public void removeElement(Composite composite) {
        parts.remove(composite);
    }

    public Composite getElement(int index) {
        return parts.get(index);
    }

    @Override
    public String toString(){
        String text = "";
        for (Composite part: parts){
            text += part;
        }
        return text;
    }
}
