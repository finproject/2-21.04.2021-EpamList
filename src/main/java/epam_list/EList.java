package epam_list;

/**
 * @author Evgeny Borisov
 */

//todo you can use only array []
public interface EList {
    void add(Object o);
    int size();

    boolean remove(int i);


    //bonus
    boolean remove(Object o);

    Object get(int index);


    void printAllContext();
}
