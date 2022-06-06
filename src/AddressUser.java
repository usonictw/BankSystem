import java.util.Scanner;

public class AddressUser {

    private String city;
    private String street;
    private int building;
    private int flat;

    public AddressUser(){

    }

    void SetAddress(Scanner sc){

        System.out.println("Enter city: ");
        this.city = sc.nextLine();
        System.out.println("Enter street: ");
        this.street = sc.nextLine();
        System.out.println("Enter building: ");
        this.building = sc.nextInt();
        System.out.println("Enter flat: ");
        this.flat = sc.nextInt();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getFlat() {
        return flat;
    }

    @Override
    public String toString() {
        return "AddressUser{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", flat=" + flat +
                '}';
    }
}
