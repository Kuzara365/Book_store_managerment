package demo.Funtion;

import java.util.Scanner;

public class Login {
    public void SignIn(){
        System.out.println("Please enter password to login");
        Scanner scanner = new Scanner(System.in);
        String password = "Passed";
        String input = scanner.nextLine();
        String FinalLogin = "";
        for(int i = 0; i < input.length(); i++){
            char CharInString = input.charAt(i);
            if(i >= input.indexOf("P") && i <= input.indexOf("d")){
                FinalLogin += CharInString;
            }
        }
        if(FinalLogin.equals(password)){
            System.out.println("Password Correct");
        }else{
            System.out.println("Password Incorrect");
            System.exit(0);
        }
    }
}
