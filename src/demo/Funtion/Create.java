package demo.Funtion;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Create {
    Scanner scanner = new Scanner(System.in);
    public void CreateAccount(ArrayList array){
        String username = Username();
        String firstname = Firstname();
        String lastname = Lastname();
        String password = Password();
        Confirm(password);
        String phone = Phone();
        String email = Email();
        
        SaveToList(username, firstname, lastname, password, phone, email, array);
        Review(array);
        
    }
    
    public String Updatenew(){
        ArrayList<String> array = new ArrayList<>();
        String username = Username();
        String firstname = Firstname();
        String lastname = Lastname();
        String password = Password();
        Confirm(password);
        String phone = Phone();
        String email = Email();
        
      return username + ", " + firstname + ", " + lastname + ", " + password + ", " + phone + ", " + email + "\n";  
}
    
    private String Username(){
        int countError = 0;
        String username = "";
        while(true){
            if(countError == 3){
                System.exit(0);
            }
            System.out.println("\nRule for entering username: ");
            System.out.println("1. Input is not existed in file.");
            System.out.println("2. Input at least 5 characters and no more than 15 character.");
            System.out.println("Please enter your username: ");
            String input = scanner.nextLine();
            try{
                BufferedReader readFile = new BufferedReader(new FileReader("AccountStorage.dat"));
                ArrayList<String> array = new ArrayList<>();
                String read;
                while((read = readFile.readLine()) != null){
                    array.add(read);
                }
                boolean FindExist = false;
                for(String element: array){
                    String[] data = element.split(", ");
                    if(data[0].equals(input)){
                        FindExist = true;
                        break;
                    }
                }
                if(FindExist == true){
                    System.out.println("Your username is already exist in file.");
                    countError++;
                }else{
                    if(input.length() >= 5 && input.length() <= 15){
                        System.out.println("Your new username is approved.");
                        username = input;
                        break;
                    }else{
                        System.out.println("Your length of input is unapproved.");
                        countError++;
                    }
                }
            }catch(IOException e){
                System.out.println("Can't read file.");
            }
        }
        return username;
    }
    
    private String Firstname(){
        String firstname = "";
        int countError = 0;
        
        while(true){
            if(countError == 3){
                System.exit(0);
            }
            System.out.println("\nRule for entering first name: ");
            System.out.println("1. First name has maximum 8 characters and at least 2 characters.");
            System.out.println("2. Just only Alphabet character is acceptable.");
            System.out.print("Please enter your first name: ");
            String CheckTheName = scanner.nextLine();
            if(CheckTheName.length() <= 8 && CheckTheName.length() >= 2){
                int countChar = 0;
                for(int i = 0; i < CheckTheName.length(); i++){
                    char CharInName = CheckTheName.charAt(i);
                    if(Character.isLetter(CharInName)){
                        countChar++;
                    }
                }
                if(countChar == CheckTheName.length()){
                    System.out.println("Your first name is approved.");
                    firstname = CheckTheName;
                    break;
                }
            }else{
                System.out.println("Length of first name is unacceptable.");
                countError++;
            }
        }
        return firstname;
    }
    
    private String Lastname(){
        String lastname = "";
        int countError = 0;
        
        while(true){
            if(countError == 3){
                System.exit(0);
            }
            System.out.println("\nRule for entering last name: ");
            System.out.println("1. Last name has maximum 8 characters and at least 2 characters.");
            System.out.println("2. Just only Alphabet character is acceptable.");
            System.out.print("Please enter your last name: ");
            String CheckTheName = scanner.nextLine();
            if(CheckTheName.length() <= 8 && CheckTheName.length() >= 2){
                int countChar = 0;
                for(int i = 0; i < CheckTheName.length(); i++){
                    char CharInName = CheckTheName.charAt(i);
                    if(Character.isLetter(CharInName)){
                        countChar++;
                    }
                }
                if(countChar == CheckTheName.length()){
                    System.out.println("Your last name is approved.");
                    lastname = CheckTheName;
                    break;
                }
            }else{
                System.out.println("Length of last name is unacceptable.");
                countError++;
            }
        }
        return lastname;
    }
    
    private String Password(){
        String password = "";
        int countError = 0;
        
        while(true){
            if(countError == 3){
                System.exit(0);
            }
        System.out.println("\nRule for entering password.");
        System.out.println("1.Password must has at least 6 characters.");
        System.out.println("2. No space in password.");
        System.out.println("3. Password should have at least 1 lower character, 1 upper character, 1 number, 1 symbol.");
        System.out.print("Please enter the password: ");
        String CheckPass = scanner.nextLine();
        if(CheckPass.length() < 6){
            System.out.println("Your password needs at least 6 characters.");
            countError++;
        }else{
            int reliable = 0;
            int lower = 0;
            int upper = 0;
            int number = 0;
            int symbol = 0;
            
            for(int i = 0; i < CheckPass.length(); i++){
                char charPass = CheckPass.charAt(i);
                if(Character.isDigit(charPass)){
                    number++;
                }else if(Character.isLetter(charPass)){
                    if(Character.isUpperCase(charPass)){
                        upper++;
                    }else{
                        lower++;
                    }
                }else{
                    symbol++;
                }
            }
            
            if(lower > 0){
                reliable++;
            }
            if(upper > 0){
                reliable++;
            }
            if(lower > 0){
                reliable++;
            }
            if(symbol > 0){
                reliable++;
            }
            
            if(reliable <= 1){
                System.out.println("Your password is weak. Want to enter again? Click 'Y' for yes, other is no.");
                String ConfirmPass = scanner.nextLine();
                if(!ConfirmPass.equals("Y")){
                    password = CheckPass;
                    break;
                }
            }else if(reliable == 2){
                System.out.println("Your password is quite weak. Want to enter again? Click 'Y' for yes, other is no.");
                String ConfirmPass = scanner.nextLine();
                if(!ConfirmPass.equals("Y")){
                    password = CheckPass;
                    break;
                }
            }else if(reliable == 3){
                System.out.println("Your password is quite strong. Want to enter again? Click 'Y' for yes, other is no.");
                String ConfirmPass = scanner.nextLine();
                if(!ConfirmPass.equals("Y")){
                    password = CheckPass;
                    break;
                }
            }else{
                System.out.println("Your password is strong. Your password is approved.");
                password = CheckPass;
                break;
            }
        }
       }  
        return password;
    }
    
    private void Confirm(String password){
        while(true){
            System.out.println("\nConfirm Password.");
            System.out.println("Enter 'Stop' to exit the program.");
            System.out.print("Please confirm your password: ");
            String confirm = scanner.nextLine();
            if(confirm.equals(password)){
                System.out.println("Password confirmed.");
                break;
            }else if(confirm.equals("Stop") || confirm.equals("stop")){
                System.exit(0);
            }
        }
    }
    
    private String Phone(){
        int countError = 0;
        String phone = "";
        while(true){
         if(countError == 3){
                System.exit(0);
            }   
        System.out.println("\nRule for entering phone number:");
        System.out.println("1. Input has at least 8 characters.");
        System.out.println("2. All character must be number.");
        System.out.println("3. No space.");
        System.out.print("Please enter phone number: ");
        String CheckPhone = scanner.nextLine();
        if(CheckPhone.length() < 8){
            countError++;
            System.out.println("Input must at least 8 characters.");
        }else{
            if(CheckPhone.contains(" ")){
                countError++;
                System.out.println("Password must has no space.");
            }else{
                int countCharError = 0;
                for(int i = 0; i < CheckPhone.length(); i++){
                    char CharPhone = CheckPhone.charAt(i);
                    if(!Character.isDigit(CharPhone)){
                        countCharError++;
                    }
                }
                if(countCharError > 0){
                    System.out.println("All character must be number.");
                }else{
                    System.out.println("Your phone number is approved.");
                    phone = CheckPhone;
                    break;
                }
            }
        }
        
        }   
        
        return phone;
    }
    
    private String Email(){
        String email = "";
        int countError = 0;
        while(true){
            if(countError == 3){
                System.exit(0);
            }
        System.out.println("\nEmail must following standard format.");
        System.out.print("Please enter your email: ");
        String CheckMail = scanner.nextLine();
        String regex = "^\\w+[a-zA-Z0-9]*@\\w+mail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(CheckMail);
        if(matcher.find()){
            System.out.println("Your email is approved.");
            email = CheckMail;
            break;
        }else{
            System.out.println("Your email is unapproved.");
            countError++;
        }
        }
        return email;
    }
    
    private void Review(ArrayList array){
            for(Object data : array){
                System.out.println(data);
            }
    }
    
    private void SaveToList(String username, String firstname, String lastname, String password, String phone, String email, ArrayList array){
        System.out.println("\nThank you, your information will be saved in the list.");
            array.add(username + ", " + firstname + ", " + lastname + ", " + password + ", " + phone + ", " + email + "\n");
    }
}
