package com.pingcrm;

import com.pingcrm.tests.LoginTests;

public class AppTest 
{
    public static void main(String[] args) throws InterruptedException {
        
        LoginTests loginTests = new LoginTests();
        loginTests.canUserLoginWithPostiveInputs();
    }
}
