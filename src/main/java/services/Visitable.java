package services;

/**
 * Created by micro on 24.01.2017.
 */
public interface Visitable {
    public void acceptVisitor(Visitor visitor);
}
