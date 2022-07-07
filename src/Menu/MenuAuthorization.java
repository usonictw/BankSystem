package Menu;

import Controller.BankController;
import dao.UserDAO;
import entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAuthorization {

    private ArrayList<MenuEntry> entries = new ArrayList<>();
    private UserDAO userDAO = UserDAO.getInstance();
    private BankController bank = BankController.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private boolean isExit = false;



    public MenuAuthorization() {
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });

        entries.add(new MenuEntry("Withdrawals from card") {
            @Override
            public void run() {
                if (!userDAO.getListObject().isEmpty()) {
                    System.out.println("Choice id user for withdrawals");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User user = userDAO.findById(scanner.nextInt());
                    System.out.println("Input amount for withdrawals: ");
                    int amount = scanner.nextInt();
//                    bank.withdrawalsOfUser(user, amount);
                } else {
                    System.out.println("entity.User list Empty");
                }
            }
        });

        entries.add(new MenuEntry("Replenish card") {
            @Override
            public void run() {
                if (!userDAO.getListObject().isEmpty()) {
                    System.out.println("Choice id user for replenish");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User user = userDAO.findById(scanner.nextInt());
                    System.out.print("Input amount: ");
                    int amount = scanner.nextInt();
                    bank.fundUser(user, amount);
                } else {
                    System.out.println("entity.User list Empty");
                }
            }
        });

        entries.add(new MenuEntry("Transfer money") {
            @Override
            public void run() {
                if (!userDAO.getListObject().isEmpty()) {
                    System.out.print("Choice id user from performing transfer");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User fromUser = userDAO.findById(scanner.nextInt());
                    System.out.print("Choice id user to whom money will be transfer");
                    bank.printListUsers();
                    System.out.print("Input id: ");
                    User toUser = userDAO.findById(scanner.nextInt());
                    System.out.println("Input amount for transfer: ");
                    int amount = scanner.nextInt();
                    //                  bank.transferBetweenUsers(fromUser, toUser, amount);
                } else {
                    System.out.println("entity.User list Empty");
                }
            }
        });

    }

    public void run() {
        // Бесконечный цикл, пока не нажали кнопку выход
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isExit) {
            printMenu();
            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                // Выбираем нажатый пункт меню и выполняем его код
                MenuEntry entry = entries.get(choice - 1);
                entry.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MenuGeneral menuGeneral = new MenuGeneral();
        menuGeneral.run();
    }

    private void printMenu() {
        int itemNumber = 1;
        for (int i = 0; i < entries.size(); i++) {
            System.out.println(itemNumber + ". " + entries.get(i).getTitle());
            itemNumber++;
        }
    }

    public ArrayList<MenuEntry> getEntries() {
        return entries;
    }
}
