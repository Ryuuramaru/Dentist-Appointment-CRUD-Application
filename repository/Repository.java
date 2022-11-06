package repository;

import java.util.Iterator;
import java.util.List;

public interface Repository<T> {

    // static Arra<Object> list = new LinkedList<Object>();
    // Object[] list = new Object[100];
    // static LinkedList<Appointment> appointments = new LinkedList<Appointment>();

    boolean add(T obj);

    boolean remove(T obj);

    List<T> getAll();

    T get(String id);

    Iterator<T> iterator();

    // void clear();

    // void sort();

}
