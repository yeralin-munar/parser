package kz.epam.main;

/**
 * Created by munar on 2/20/17.
 */
public interface Composite {
    public void addElement(Composite composite);
    public void removeElement(Composite composite);
    public Composite getElement(int index);
}
