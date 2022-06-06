import java.util.Arrays;
import java.util.Scanner;

public class Bank {

    final static double BANK_COMMISSION = 2;
    final static int MAX_USERS = 10_000;
    final String initPassword = "myPassword";
    private int userCounter = 0;

    User[] users = new User[MAX_USERS];
    Card[] cards = new Card[2 * MAX_USERS];
    Scanner scanner = new Scanner(System.in);

    public void addUser(String password) {
        if (password.equalsIgnoreCase(initPassword) && userCounter < MAX_USERS) {
            System.out.print("Enter users number for registration: ");
            int usersNumber = scanner.nextInt();
            for (int i = 0; i < usersNumber; i++) {
                User user = new User();
                Card card = new Card();
                System.out.println("Input info for User: " + userCounter);
                user.setUser(userCounter);
                user.setCard(card);
                users[userCounter] = user;
                userCounter++;
            }
        } else {
            System.out.println("Wrong password or exceeds users limit");
        }
    }

    public void createCardForUser(long id){
            for (int i = 0; i < userCounter; i++) {
                Card card = new Card();
                card.createCard(id);
                System.out.print("Enter initial card deposit: ");
                card.setBalance(scanner.nextInt());
                cards[i] = card;
                users[i].setCard(cards[i]);
        }
    }

    public void printListUsers() {

        if (userCounter > 0) {
            System.out.println("Users list: ");
            int item = 1;
            for (int i = 0; i < userCounter; i++) {
                System.out.print(item + ". ");
                System.out.println("id: " + users[i].getId() + ", " + "Name: " + users[i].getInfo().getName() + ", " +
                        "Surname: " + users[i].getInfo().getSurname() + ", " + "City: " + users[i].getInfo().getAddressUser().getCity() +
                        ", " + "Street: " + users[i].getInfo().getAddressUser().getStreet() + ", " + "Building: " +
                        users[i].getInfo().getAddressUser().getBuilding() + ", " +
                        "Flat number: " + users[i].getInfo().getAddressUser().getFlat() + ", " + "Card number: " + users[i].getCard().getCardNumber() +
                        ", " + "Balance: " +users[i].getCard().getBalance());
                item++;
            }
            System.out.println();

        }else {
            System.out.println("Users list Empty");
            System.out.println();
        }
    }

    public User findUserById(long id) {
        User user = null;
        boolean flag = false;
        for (int i = 0; i < userCounter; i++) {
            if (users[i].getId() == id) {
                user = users[i];
                System.out.println("Founded User: ");
                System.out.println("id: " + user.getId() + ", " + "Name: " + user.getInfo().getName() + ", " +
                        "Surname: " + user.getInfo().getSurname() + ", " + "City: " + user.getInfo().getAddressUser().getCity() +
                        ", " + "Street: " + user.getInfo().getAddressUser().getStreet() + ", " + "Building: " +
                        user.getInfo().getAddressUser().getBuilding() + ", " +
                        "Flat number: " + user.getInfo().getAddressUser().getFlat() + ", " + "Card number: " + user.getCard().getCardNumber() + ", " +
                        "Balance: " + user.getCard().getBalance());
                flag = true;
            }else if(!flag){
                System.out.println("User with id = " + id + "don't founded");
            }
        }
        return user;
    }

    public void withdrawalsOfUser(User user, int amount) {
        if (amount <= 0) {
            System.out.println("You input withdrawal the amount 0 or less than 0  ");
        }
        if(user.getCard().getBalance() > amount && (amount+amount*BANK_COMMISSION) < user.getCard().getBalance()) {
            user.getCard().setBalance((long) (amount - amount * BANK_COMMISSION / 100));
        }
        else if (user.getCard().getBalance() < amount){
            System.out.println("Withdrawal the amount exceeds limit. Maximum withdrawal amount:" + user.getCard().getBalance());
        }
        else if ((amount+amount*BANK_COMMISSION) > user.getCard().getBalance()){
            System.out.println("Withdrawal the amount including commission exceeds your BAlANCE. Your balance: "+user.getCard().getBalance());

        }

    }

    public void fundUser(User user, int amount) {
        if (amount <= 0) {
            System.out.println("You input Funding amount 0 or less than 0  ");
        }else {
            user.getCard().setBalance(amount);
        }
    }

    public void transferBetweenUsers(User fromUser, User toUser, int amount){
        withdrawalsOfUser(fromUser, amount);
        fundUser(toUser, amount);
    }

    public int getUserCounter() {
        return userCounter;
    }

}
