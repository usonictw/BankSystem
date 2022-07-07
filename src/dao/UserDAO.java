package dao;

import Controller.BankController;
import entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    private static UserDAO INSTANCE;

    private UserDAO() {
    }

    public static UserDAO getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new UserDAO();
        }
        return INSTANCE;
    }

    public boolean checkRegistration(User user) {
        boolean flag = true;
        Iterator<User> iterator = getListObject().iterator();
        int quantityDigit = 10;
        if (user.getInfo().getUserPhoneNumber().length() != quantityDigit) {
            flag = false;
            System.out.println("Phone number must contain 10 digits: For example 0967543231");
        }
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getInfo().getUserPhoneNumber().equals(user.getInfo().getUserPhoneNumber())) {
                flag = false;
                System.out.println("User with phone number " + user.getInfo().getUserPhoneNumber() + " exists");
            }
        }
        return flag;
    }

    public User findUserByPhone(String phoneNumber) {
        User user = null;
        List<User> users = getListObject();
        for (User u : users) {
            if (u.getInfo().getUserPhoneNumber().contains(phoneNumber)) {
                user = u;
                break;
            } else {
                System.out.println("User with " + phoneNumber + " dose not exists");
            }
        }
        return user;
    }

    public List<User> findBySurname(String surname) {
        List<User> usersMatchSurname = new ArrayList<>();
        List<User> users = getListObject();
        for (User u : users) {
            if (u.getInfo().getSurname().equals(surname)) {
                usersMatchSurname.add(u);
            } else {
                System.out.println("User with " + surname + " dose not exists");
            }
        }
        return usersMatchSurname;
    }

    public User findById(long userId){
        User user = null;
        List<User> users = getListObject();
        for (User u :
                users) {
            if (u.getId() == userId){
                user = u;
            }
        }
        return user;
    }


    public boolean isExistUser(String phoneNumber) {
        boolean flag = false;
        List<User> users = getListObject();
        for (User u : users) {
            if (u.getInfo().getUserPhoneNumber().equals(phoneNumber)) {
                flag = true;
            } else {
                System.out.println("User with " + phoneNumber + " dose not exists");
            }
        }
        return flag;
    }
}
