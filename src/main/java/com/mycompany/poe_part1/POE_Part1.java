/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part1;

import java.util.ArrayList;
import java.util.Scanner;

public class POE_Part1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login user = new Login();

        // Hardcoded registration data for testing the quick login flow
        user.setUsername("kyl_1");
        user.setPassword("Ch&&sec@ke99!");
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        user.setCellPhoneNumber("+27838968976");

        System.out.println("--- PLEASE LOGIN TO QUICKCHAT ---");
        System.out.print("Enter Username: ");
        String enteredUser = scanner.nextLine();
        System.out.print("Enter Password: ");
        String enteredPass = scanner.nextLine();

        // 1. Users should only be able to send messages if they have logged in successfully
        if (!user.loginUser(enteredUser, enteredPass)) {
            System.out.println("Login failed. Access denied.");
            scanner.close();
            return;
        }

        // 2. Display the welcome message
        System.out.println("\nWelcome to QuickChat.");

        int choice;
        ArrayList<Message> allMessages = new ArrayList<>();

        // 4. The application should run until the user selects 'quit' to exit
        do {
            // 3. Numeric menu choices
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Choose 1, 2, or 3: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // 5. Users define how many messages they wish to enter
                    System.out.print("How many messages would you like to enter? ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Please enter a valid number: ");
                        scanner.next();
                    }
                    int numMessages = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("\n--- Entering Message " + (i + 1) + " of " + numMessages + " ---");
                        
                        System.out.print("Enter recipient cell number (e.g., +27718693002): ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter message (max 250 characters): ");
                        String text = scanner.nextLine();

                        Message tempMsgCheck = new Message(i, recipient, text, 1);
                        // Check message length limit (max 250 characters)
                        if (!tempMsgCheck.checkMessageLength()) {
                            System.out.println("Please enter a message of less than 250 characters. (Current length: " + text.length() + ")");
                            i--; // retry current message index
                            continue;
                        }

                        // Send message options menu
                        System.out.println("\nChoose delivery action:");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message to send later");
                        System.out.print("Select option (1-3): ");
                        
                        int actionChoice = 1;
                        if (scanner.hasNextInt()) {
                            actionChoice = scanner.nextInt();
                            scanner.nextLine();
                        }

                        Message msg = new Message(i, recipient, text, actionChoice);
                        allMessages.add(msg);

                        // 7. Full details displayed after each message is sent
                        System.out.println("\n--- Message Summary ---");
                        System.out.println(msg.getMessageDetails());
                    }

                    // 6. Total number of messages accumulated and displayed
                    System.out.println("Total messages processed in this session: " + allMessages.size());
                    break;

                case 2:
                    // Option 2: Show recently sent messages (In development message)
                    System.out.println("\nComing Soon.");
                    break;

                case 3:
                    System.out.println("\nExiting QuickChat. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}