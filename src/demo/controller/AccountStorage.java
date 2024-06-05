package demo.controller;


import java.util.ArrayList;
import java.util.Scanner;

import demo.Funtion.ChangeData;
import demo.Funtion.Create;
import demo.Funtion.Exist;
import demo.Funtion.Login;
import demo.Funtion.Request;
import demo.Funtion.Print;
import demo.workwithfile.SaveToFile;

public class AccountStorage {
  
    public static void main(String[] args) {       
        ArrayList<String> array = new ArrayList<>();
        Create create = new Create();
        Exist exist = new Exist();
        ChangeData change = new ChangeData();
        Login login = new Login();
        login.SignIn();
      int exit = 0;
      while(exit < 3){
      Request request = new Request();
      request.Menu();
      
      Scanner scanner = new Scanner(System.in);
      String ChooseNumber = scanner.nextLine();
      
      switch(ChooseNumber){
          case "1":
              System.out.println("Create user account.");
              create.CreateAccount(array);
              break;
              
          case "2":
              System.out.println("Check exist user.");
              System.out.print("Please enter input your username, first name, last name to check: ");
              String checkexist = scanner.nextLine();
              boolean check = exist.CheckExist(checkexist);
              if(check == true){
                System.out.println("User exists.");
            }else if(check == false){
                System.out.println("Not Found Users.");
            }
              break;
              
          case "3":
              System.out.println("Search user information by name.");
              System.out.print("Please enter input your username, first name, last name to check to search: ");
              String search = scanner.nextLine();
              boolean CheckExist = exist.CheckExist(search);
              if(CheckExist == true){
                  exist.Search(search);
              }else{
                  System.out.println("Your input is not found.");
              }
              break;
              
          case "4":
              System.out.println("Update user.");
              while(true){
                  System.out.println("Enter 'exit' to exit");
                  System.out.print("Please enter username, first name, last name to start update: ");
                  String input = scanner.nextLine();
                  if(input.equals("exit")){
                      break;
                  }
                  boolean nameExist = exist.CheckExist(input);
                  if(nameExist == true){
                      System.out.println("Choose your option to update. 'U' for change data, 'D' for delete data.");
                      String option = scanner.nextLine();
                      if(option.equals("U")){
                          change.UpdateData(input);
                          break;
                      }else if(option.equals("D")){
                          change.DeleteData(input);
                          break;
                      }else{
                          System.out.println("Please type your name again.");
                      }
                  }else{
                      System.out.println("Name Not Found.");
                  }
              }
              break;
              
          case "5":
              System.out.println("Save account to file.");
              if(array.isEmpty()){
                  System.out.println("There is nothing to save.");
              }else{
              SaveToFile saveFile = new SaveToFile();
              saveFile.SaveData(array);
              }
              break;
              
          case "6":
              System.out.println("Print list user from file.");
               Print print = new Print();
               print.PrintFile();
              break;
              
          case "7":
              System.out.println("Quit");
              System.exit(0);
              
          default:
              System.out.println("Not a choice");
              exit++;
      }
     }

      
    }
}
