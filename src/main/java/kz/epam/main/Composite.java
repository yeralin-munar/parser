package kz.epam.main;

/**
 * @author Yeralin Munar
 * date: 2/20/17
 */
public interface Composite {
    void addElement(Composite composite);
    void removeElement(Composite composite);
    Composite getElement(int index);
}
