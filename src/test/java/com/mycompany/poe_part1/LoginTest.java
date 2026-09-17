/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
     @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login();
        login.setUsername("kyl_1");
        assertTrue(login.checkUserName(), "Username should be correctly formatted.");
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login();
        login.setUsername("kyle!!!!!!!") ;
        assertFalse(login.checkUserName(), "Username should be incorrectly formatted.");
    }

    @Test
    public void testPasswordSuccess() {
        Login login = new Login();
        login.setPassword("Chse$a382");
        assertTrue(login.checkPasswordComplexity(), "Password should meet complexity requirements.");
    }

    @Test
    public void testPasswordFailure() {
        Login login = new Login();
        login.setPassword("password");
        assertFalse(login.checkPasswordComplexity(), "Password should fail complexity requirements.");
    }

    @Test
    public void testCellPhoneNumberSuccess() {
        Login login = new Login();
        login.setCellPhoneNumber("+27831234567");
        assertTrue(login.checkCellPhoneNumber(), "Cell phone number should be valid.");
    }

    @Test
    public void testCellPhoneNumberFailure() {
        Login login = new Login();
        login.setCellPhoneNumber("0831234567");
        assertFalse(login.checkCellPhoneNumber(), "Cell phone number should be invalid.");
    }
}
   
    

