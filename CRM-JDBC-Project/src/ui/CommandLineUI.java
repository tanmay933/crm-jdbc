// CommandLineUI.java
package ui;

import dao.*;
import model.*;

import java.util.*;
import java.text.SimpleDateFormat;

public class CommandLineUI {
    private final Scanner scanner = new Scanner(System.in);
    private final UserDAO userDAO = new UserDAO();
    private final AccountDAO accountDAO = new AccountDAO();
    private final LeadDAO leadDAO = new LeadDAO();
    private final OpportunityDAO opportunityDAO = new OpportunityDAO();
    private final InteractionDAO interactionDAO = new InteractionDAO();
    private final TaskDAO taskDAO = new TaskDAO();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void start() {
        while (true) {
            System.out.println("\n=== CRM MENU ===");
            System.out.println("1. Add User");
            System.out.println("2. List Users");
            System.out.println("3. Add Account");
            System.out.println("4. Add Lead");
            System.out.println("5. Add Opportunity");
            System.out.println("6. Add Interaction");
            System.out.println("7. Add Task");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> addUser();
                    case 2 -> listUsers();
                    case 3 -> addAccount();
                    case 4 -> addLead();
                    case 5 -> addOpportunity();
                    case 6 -> addInteraction();
                    case 7 -> addTask();
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addUser() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        userDAO.addUser(new User(0, name, email));
        System.out.println("User added.");
    }

    private void listUsers() {
        List<User> users = userDAO.getAllUsers();
        users.forEach(u -> System.out.println(u.getUserId() + ": " + u.getName() + " (" + u.getEmail() + ")"));
    }

    private void addAccount() {
        System.out.print("Account name: ");
        String name = scanner.nextLine();
        System.out.print("Contact email: ");
        String email = scanner.nextLine();
        System.out.print("Contact phone: ");
        String phone = scanner.nextLine();
        accountDAO.addAccount(new Account(0, name, email, phone));
        System.out.println("Account added.");
    }

    private void addLead() throws Exception {
        System.out.print("Lead name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Created date (yyyy-MM-dd): ");
        Date createdAt = sdf.parse(scanner.nextLine());
        leadDAO.addLead(new Lead(0, name, email, phone, createdAt, false, null));
        System.out.println("Lead added.");
    }

    private void addOpportunity() throws Exception {
        System.out.print("Account ID: ");
        int accId = Integer.parseInt(scanner.nextLine());
        System.out.print("Stage: ");
        String stage = scanner.nextLine();
        System.out.print("Value: ");
        double value = Double.parseDouble(scanner.nextLine());
        System.out.print("Expected close date (yyyy-MM-dd): ");
        Date closeDate = sdf.parse(scanner.nextLine());
        System.out.print("Created date (yyyy-MM-dd): ");
        Date createdAt = sdf.parse(scanner.nextLine());
        opportunityDAO.addOpportunity(new Opportunity(0, accId, stage, value, closeDate, createdAt, false));
        System.out.println("Opportunity added.");
    }

    private void addInteraction() throws Exception {
        System.out.print("Account ID: ");
        int accId = Integer.parseInt(scanner.nextLine());
        System.out.print("Type (Call/Email/Meeting/Note): ");
        String type = scanner.nextLine();
        System.out.print("Details: ");
        String details = scanner.nextLine();
        interactionDAO.addInteraction(new Interaction(0, accId, type, details, new Date()));
        System.out.println("Interaction added.");
    }

    private void addTask() throws Exception {
        System.out.print("Assigned to user ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Account ID (optional, press Enter to skip): ");
        String accInput = scanner.nextLine();
        Integer accId = accInput.isEmpty() ? null : Integer.parseInt(accInput);
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Due date (yyyy-MM-dd): ");
        Date dueDate = sdf.parse(scanner.nextLine());
        taskDAO.addTask(new Task(0, userId, accId, desc, dueDate, false));
        System.out.println("Task added.");
    }
}
