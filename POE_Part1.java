/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part1;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class POE_Part1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login userLogin = new Login();
            
            System.out.println("=== USER REGISTRATION ===");
            
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            userLogin.setFirstName(firstName);
            
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            userLogin.setLastName(lastName);
            
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            userLogin.setUsername(username);
           
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            userLogin.setPassword(password);
            
            System.out.print("Enter cell phone number (+27 format): ");
            String cellNumber = scanner.nextLine();
            userLogin.setCellPhoneNumber(cellNumber);
            
            String registrationStatus = userLogin.registerUser();
            System.out.println("\n" + registrationStatus + "\n");
            
            if (registrationStatus.equals("User registered successfully.")) {
                System.out.println("=== USER LOGIN ===");
                
                System.out.print("Enter username: ");
                String loginUsername = scanner.nextLine();
                
                System.out.print("Enter password: ");
                String loginPassword = scanner.nextLine();
                
                boolean loginSuccess = userLogin.loginUser(loginUsername, loginPassword);
                String loginMessage = userLogin.returnLoginStatus(loginSuccess);
                
                System.out.println("\n" + loginMessage);
            } else {
                System.out.println("Registration failed. Please restart the application and try again.");
            }
        }
    }
}

    

