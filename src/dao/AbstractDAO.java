package dao;

import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> {

    private List<T> listObject = new ArrayList<>();

    public void save(T object) {
        if (object == null) {
            System.out.println("Object is " + object + "." + " Create object.");
        } else if (listObject.contains(object)) {
            System.out.println("Object " + object + " already exist in list.");
        }else {
            listObject.add(object);
        }
    }

    public void delete(T object) {
        if (listObject.isEmpty()){
            System.out.println("List is empty.");
        }else if (listObject.contains(object)){
            listObject.remove(object);
        }else {
            System.out.println(object + " does not exist.");
        }

    }

    public List<T> getListObject(){

        return listObject;
    }


}
