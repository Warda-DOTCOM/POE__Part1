# POE Part 1 - User Authentication System

## Project Overview
This Java application provides a user registration and login system built as part of the Programming POE (Part 1). It has strict password complexity rules, uses South African mobile number formats only, and checks username formatting.

## Project Features & Validation Rules
* **Username Validation:** Usernames needs to contain an underscore and must be no longer than 5 characters.
* **Password Complexity:** Passwords must be at least 8 characters long and needs to contain at least one uppercase letter, one number, and one special character.
* **Cell Phone Number Validation:** Mobile numbers must follow the South African standard format  starting with `+27`
* **Unit Testing:** Automated unit test coverage implemented using JUnit 5.

## TOOLS USED
* **Language:** Java 17
* **IDE:** Apache NetBeans
* **Build Tool:** Apache Maven
* **Testing Framework:** JUnit 5 (Jupiter API)

## How to Run Tests
1. Open the project in NetBeans.
2. Ensure Maven dependencies are loaded.
3. Right-click `LoginTest.java` and select **Test File**.
