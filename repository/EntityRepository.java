package repository;

import domain.Identifiable;

//import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.ListIterator;

public class EntityRepository<T extends Identifiable> implements Repository<T> {

    private ArrayList<T> list;

    public EntityRepository() {
        list = new ArrayList<>();
    }

    @Override
    public boolean add(T obj) {
        if (list.contains(obj))
            return false;
        else {
            list.add(obj);
            return true;
        }
    }

    @Override
    public boolean remove(T obj) {
        if (list.contains(obj)) {
            list.remove(obj);
            return true;
        } else
            return false;
    }

    @Override
    public ArrayList<T> getAll() {
        return list;
    }

    public void setAll(ArrayList<T> temp) {
        list = (ArrayList<T>) temp;
    }

    @Override
    public T get(String id) {
        for (T obj : list)
            if (obj.getID().equals(id))
                return obj;
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        String result = "";
        for (T obj : list)
            result += obj.toString() + "\n";
        return result;
    }
}
