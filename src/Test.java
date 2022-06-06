import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        menu.getEntries().add(new MenuEntry("Registration user") {
            @Override
            public void run() {
                bank.addUser("myPassword");
            }
        });

        menu.getEntries().add(new MenuEntry("Create card for user") {
            @Override
            public void run() {
                if (bank.getUserCounter() != 0) {
                    bank.printListUsers();
                    System.out.print("Input user Id for create card: ");
                    bank.createCardForUser(scanner.nextInt());
                }else {
                    System.out.println("Users in the list dosn't exist. Perform registration users.");
                }
            }
        });

        menu.getEntries().add(new MenuEntry("Print Users List") {
            @Override
            public void run() {
                if (bank.getUserCounter() != 0){
                    bank.printListUsers();
                }else {
                    System.out.println("Users list is Empty");
                }

            }
        });

        menu.getEntries().add(new MenuEntry("Find User by Id") {
            @Override
            public void run() {
                if (bank.getUserCounter() !=0) {
                    System.out.print("Input user Id: ");
                    bank.findUserById(scanner.nextInt());
                }else {
                    System.out.println("User list Empty");
                }
            }
        });
        menu.getEntries().add(new MenuEntry("Withdrawals from card") {
            @Override
            public void run() {
                if (bank.getUserCounter() != 0) {
                    System.out.println("Choice id user for withdrawals");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User user = bank.findUserById(scanner.nextInt());
                    System.out.println("Input amount for withdrawals: ");
                    int amount = scanner.nextInt();
                    bank.withdrawalsOfUser(user, amount);
                }else {
                    System.out.println("User list Empty");
                }
            }
        });

        menu.getEntries().add(new MenuEntry("Replenish card") {
            @Override
            public void run() {
                if (bank.getUserCounter() != 0) {
                    System.out.println("Choice id user for replenish");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User user = bank.findUserById(scanner.nextInt());
                    System.out.print("Input amount: ");
                    int amount = scanner.nextInt();
                    bank.fundUser(user, amount);
                }else {
                    System.out.println("User list Empty");
                }
            }
        });

        menu.getEntries().add(new MenuEntry("Transfer money") {
            @Override
            public void run() {
                if (bank.getUserCounter() != 0) {
                    System.out.print("Choice id user from performing transfer");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User fromUser = bank.findUserById(scanner.nextInt());
                    System.out.print("Choice id user to whom money will be transfer");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User toUser = bank.findUserById(scanner.nextInt());
                    System.out.println("Input amount for transfer: ");
                    int amount = scanner.nextInt();
                    bank.transferBetweenUsers(fromUser, toUser, amount);
                }else {
                    System.out.println("User list Empty");
                }
            }
        });
        menu.run();

    }
}
