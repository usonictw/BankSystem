package Controller;

import dao.UserDAO;
import entity.Bank;
import entity.Card;
import entity.User;

import java.util.*;

public class BankController {

    private static BankController INSTANCE;

    public static BankController getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new BankController();
        }
        return INSTANCE;
    }

    private BankController() {

    }

    private Bank PrivatBank = new Bank("PrivatBank", 3.5F);
    private Bank AlfaBank = new Bank("AlfaBank", 4.0F);
    private Bank AgricoleBank = new Bank("AgricoleBank", 3.0F);

    private List<Card> cards = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Map<String, String> loginUsers = new HashMap<>();
    private UserDAO userDAO = UserDAO.getInstance();

    public boolean authorization(String phoneNumber, String password) {
        boolean flag = false;
        Set<Map.Entry<String, String>> loginPassword = loginUsers.entrySet();
        for (Map.Entry<String, String> pair :
                loginPassword) {
            if (phoneNumber.equals(pair.getKey()) && password.equals(pair.getValue())) {
                flag = true;
            }
        }
        return flag;
    }

    public void userRegistration() {
        System.out.println("Enter users data: ");
        User user = new User();
        Card card = new Card();
        long id = 1;
        if (userDAO.getListObject().isEmpty()) {
            user.setUser(id);
            user.setCard(card);
            if (userDAO.checkRegistration(user)) {
                userDAO.save(user);
            }
        } else {
            id++;
            user.setUser(id);
            user.setCard(card);
            if (userDAO.checkRegistration(user)) {
                userDAO.save(user);
            }
        }
        System.out.println("User Registration Successful");
        loginUsers.put(user.getInfo().getUserPhoneNumber(), user.getInfo().getPassword());
    }

    public void createCardForUser(long userId) {
        Card card = new Card();
        card.chooseCard(scanner);
        card.createCard(userId);
        System.out.print("Enter initial card deposit: ");
        card.setBalance(scanner.nextInt());
        userDAO.findById(userId).setCard(card);
    }

    public void printListUsers() {
        if (!userDAO.getListObject().isEmpty()) {
            System.out.println("Users list: ");
            int item = 1;
            for (User u : userDAO.getListObject()) {
                System.out.print(item + ". ");
                System.out.println("id: " + u.getId() + ", " + "Name: " + u.getInfo().getName() + ", " +
                        "Surname: " + u.getInfo().getSurname() + ", " + "City: " + u.getInfo().getAddressUser().getCity() +
                        ", " + "Street: " + u.getInfo().getAddressUser().getStreet() + ", " + "Building: " +
                        u.getInfo().getAddressUser().getBuilding() + ", " +
                        "Flat number: " + u.getInfo().getAddressUser().getFlat() + ", " + "Phone number: "
                        + u.getInfo().getUserPhoneNumber()+ ", " + "Type of Card: " + u.getCard().getCardType() + ", " + "Card number: "
                        + u.getCard().getCardNumber() + ", " + "Balance: " + u.getCard().getBalance());
                item++;
            }

        } else {
            System.out.println("Users list Empty");
        }
        System.out.println();
    }

    public void printUser(User user) {

        System.out.println("id: " + user.getId() + ", " + "Name: " + user.getInfo().getName() + ", " +
                "Surname: " + user.getInfo().getSurname() + ", " + "City: " + user.getInfo().getAddressUser().getCity() +
                ", " + "Street: " + user.getInfo().getAddressUser().getStreet() + ", " + "Building: " +
                user.getInfo().getAddressUser().getBuilding() + ", " +
                "Flat number: " + user.getInfo().getAddressUser().getFlat() + ", " + "Phone number: "
                + user.getInfo().getUserPhoneNumber()+ ", " + "Type of Card: " + user.getCard().getCardType() + ", " + "Card number: "
                + user.getCard().getCardNumber() + ", " + "Balance: " + user.getCard().getBalance());

    }

    public void withdrawalsOfUser(User user, int amount) {
        if (amount <= 0) {
            System.out.println("You input withdrawal the amount 0 or less than 0  ");
        }
        if (user.getCard().getBalance() > amount && (amount + amount * PrivatBank.getBankCommission()) < user.getCard().getBalance()) {
            user.getCard().setBalance((long) (user.getCard().getBalance() - (amount + (amount * PrivatBank.getBankCommission()) / 100)));
            System.out.println("Withdrawals Success");
        } else if (user.getCard().getBalance() < amount) {
            System.out.println("Withdrawal the amount exceeds limit. Maximum withdrawal amount:" + user.getCard().getBalance());
        } else if ((amount + amount * PrivatBank.getBankCommission()) > user.getCard().getBalance()) {
            System.out.println("Withdrawal the amount including commission exceeds your BAlANCE. Your balance: " + user.getCard().getBalance());

        }

    }

    public void fundUser(User user, int amount) {
        if (amount <= 0) {
            System.out.println("You input Funding amount 0 or less than 0  ");
        } else {
            user.getCard().setBalance(user.getCard().getBalance() + amount);
        }
    }

    public void transferBetweenUsers(User fromUser, User toUser, int amount) {
        withdrawalsOfUser(fromUser, amount);
        fundUser(toUser, amount);
    }

    public Bank getPrivatBank() {
        return PrivatBank;
    }

    public Bank getAlfaBank() {
        return AlfaBank;
    }

    public Bank getAgricoleBank() {
        return AgricoleBank;
    }

    public Map<String, String> getLoginUsers() {
        return loginUsers;
    }
}
