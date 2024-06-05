package demo.Funtion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Print {
    public void PrintFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("AccountStorage.dat"))){
            ArrayList<String> array = new ArrayList<String>();
            String read = "";
            while((read = reader.readLine()) != null){
                array.add(read);
            }
            String username = "";
            String firstname = "";
            String lastname = "";
            String password = "";
            String phone = "";
            String email = "";
            
            System.out.println("+" + "-".repeat(125) + "+"); 
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "Username", "First name", "Last name", "Password", "Phone number", "Email");
            System.out.println("-".repeat(127));
               
            for(String data: array){
                String[] dataElement = data.split(", ");
                for(int i = 0; i < dataElement.length; i++){
                    read = dataElement[i];
                    switch (i) {
                        case 0:
                            username = read;
                            break;
                        case 1:
                            firstname = read;
                            break;
                        case 2:
                            lastname = read;
                            break;
                        case 3:
                            password = read;
                            break;
                        case 4:
                            phone = read;
                            break;
                        case 5:
                            email = read;
                            break;
                    }
                }
                System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", username, firstname, lastname, password, phone, email);
            }
            System.out.println("+" + "-".repeat(125) + "+"); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}