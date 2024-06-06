package demo.workwithfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class SaveToFile {
    
    public void SaveData(ArrayList<String> array){
        try{
            FileWriter filewriter = new FileWriter("AccountStorage.dat", true);
           BufferedWriter save = new BufferedWriter(filewriter);
          for(String data: array){
              save.write(data);
          }
          save.close();
          array.clear();
            System.out.println("Your account has been saved");
    }catch(IOException e){
            System.out.println("Errors to save");
    }
    }
}
