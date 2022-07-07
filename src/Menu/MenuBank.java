package Menu;

import Controller.BankController;
import dao.UserDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuBank {

    private ArrayList<MenuEntry> entries = new ArrayList<>();
    private BankController bank = BankController.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private boolean isExit = false;

    public MenuBank() {
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });

        entries.add(new MenuEntry("Registration user") {
            @Override
            public void run() {
                bank.userRegistration();
            }
        });

        entries.add(new MenuEntry("Create card for user") {
            @Override
            public void run() {
                bank.printListUsers();
                System.out.print("Input user Id for create card: ");
                bank.createCardForUser(scanner.nextInt());
            }
        });

        entries.add(new MenuEntry("Print Users List") {
            @Override
            public void run() {
                bank.printListUsers();
            }
        });

        entries.add(new MenuEntry("Find user by Id") {
            @Override
            public void run() {
                System.out.print("Input user Id: ");

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
