import java.util.Scanner;

public class InfoUser {
    private String name;
    private String surname;
    private AddressUser addressUser;

    public InfoUser() {

    }

    void setInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = sc.nextLine();
        System.out.println("Enter surname: ");
        this.surname = sc.nextLine();
        addressUser = new AddressUser();
        addressUser.SetAddress(sc);
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

    @Override
    public String toString() {
        return "InfoUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addressUser=" + addressUser +
                '}';
    }
}
