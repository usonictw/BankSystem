package Menu;

import Controller.BankController;
import dao.UserDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGeneral {

    private ArrayList<MenuEntry> entries = new ArrayList<>();
    BankController bankController = BankController.getInstance();
    UserDAO userDAO = UserDAO.getInstance();
    private MenuBank menuBank = new MenuBank();
    private MenuAuthorization authorization = new MenuAuthorization();
    private Scanner scanner = new Scanner(System.in);
    private boolean isExit = false;

    public MenuGeneral() {
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });

        entries.add(new MenuEntry("BankSystem") {
            @Override
            public void run() {
                menuBank.run();
            }
        });

        entries.add(new MenuEntry("UserPage") {
            @Override
            public void run() {
                System.out.println("Input your Login (PhoneNumber)");
                String phoneNumber = scanner.nextLine();
                System.out.println("Input your password");
                String password = scanner.nextLine();
                if (bankController.authorization(phoneNumber, password)) {
                    System.out.println("Authorization was successful");
                    bankController.printUser(userDAO.findUserByPhone(phoneNumber));
                    authorization.run();
                }else {
                    System.out.println("There is not user with this Login and/or Password");
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
