package entity;

import java.util.Objects;
import java.util.Scanner;

public class InfoUser {
    private String name;
    private String surname;
    private String userPhoneNumber;
    private AddressUser addressUser;
    private String password;

    public InfoUser() {

    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void setInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = sc.nextLine();
        System.out.println("Enter surname: ");
        this.surname = sc.nextLine();
        System.out.println("Enter phone number: ");
        setUserPhoneNumber(sc.nextLine());
        System.out.println("Enter Password: ");
        setPassword(sc.nextLine());
        addressUser = new AddressUser();
//        addressUser.SetAddress(sc);



    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public AddressUser getAddressUser() {
        return addressUser;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "entity.InfoUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addressUser=" + addressUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoUser infoUser = (InfoUser) o;
        return getName().equals(infoUser.getName()) && getSurname().equals(infoUser.getSurname()) && getUserPhoneNumber().equals(infoUser.getUserPhoneNumber()) && getAddressUser().equals(infoUser.getAddressUser()) && password.equals(infoUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getUserPhoneNumber(), getAddressUser(), password);
    }
}
