package demo.Funtion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exist {
    public boolean CheckExist(String checkDataInput){
        boolean check = false;
        try(BufferedReader readFile = new BufferedReader(new FileReader("AccountStorage.dat"))){
            String CheckData;
            ArrayList<String> array = new ArrayList<>();
            while((CheckData = readFile.readLine()) != null){
                 array.add(CheckData);
            }
            
            all:
            for(String data: array){
                String[] wordIndata = data.split(", ");
                int elementCount = 0;
                for(String element: wordIndata){
                    if(checkDataInput.equals(element)){
                        check = true;
                        break all;
                    }else{
                        check = false;
                        elementCount++;
                    }
                    if(elementCount == 3){
                        break;
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Fail to read file.");
        }
        return check;
    }
    
    public void Search(String showData){
        try(BufferedReader read = new BufferedReader(new FileReader("AccountStorage.dat"))){
            ArrayList<String> array = new ArrayList<>();
            String findData;
            while((findData = read.readLine()) != null){
                 array.add(findData);
            }
            String username = "";
            String firstname = "";
            String lastname = "";
            String password = "";
            String phone = "";
            String email = "";
            
            for(String data: array){
                if(data.contains(showData)){
                    String[] splitData = data.split(", ");
                    for(int i = 0; i < splitData.length; i++){
                        findData = splitData[i];
                        switch (i) {
                            case 0:
                                username = findData;
                                break;
                            case 1:
                                firstname = findData;
                                break;
                            case 2:
                                lastname = findData;
                                break;
                            case 3:
                                password = findData;
                                break;
                            case 4:
                                phone = findData;
                                break;
                            case 5:
                                email = findData;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            
         System.out.println("+" + "-".repeat(125) + "+"); 
         System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "Username", "First name", "Last name", "Password", "Phone number", "Email");
         System.out.println("-".repeat(127));
         for(int i = 0; i < 6; i++){
             switch(i){
                 case 0:
                     System.out.printf("|%-20s|", username);
                     break;
                     
                 case 1:
                     System.out.printf("%-20s|", firstname);
                     break;
                     
                 case 2:
                     System.out.printf("%-20s|", lastname);
                     break;
                     
                 case 3:
                     System.out.printf("%-20s|", password);
                     break;
                     
                 case 4:
                     System.out.printf("%-20s|", phone);
                     break;
                     
                 case 5:
                     System.out.printf("%-20s|\n", email);
                     break;
             }
         }
         System.out.println("+" + "-".repeat(125) + "+");
        }catch(IOException e){
            System.out.println("Fail to read file.");
        }
    }
}
