package demo.Funtion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ChangeData {
    
    public void UpdateData(String update){
        Create create = new Create();
          try{
              File delete = new File("AccountStorage.dat");
              File newFile = new File("Temp.dat");
             BufferedReader read = new BufferedReader(new FileReader(delete));
             BufferedWriter write = new BufferedWriter(new FileWriter(newFile));
             String FindData;
           while((FindData = read.readLine()) != null){
               if(!FindData.contains(update)){
                   write.write(FindData + System.getProperty("line.separator"));
               }else{
                   FindData = create.Updatenew();
                   write.write(FindData);
               }
           }
           write.close();
           read.close();
           
           if(delete.delete()){
               if(!newFile.renameTo(delete)){
                   System.out.println("Fail to rename");
               }
           }else{
               System.out.println("Can't delete");
           }
          }catch(IOException e){
              System.out.println("Fail to read and write to file.");
          }
    }
    
    public void DeleteData(String EraseData){
        try{
            File delete = new File("AccountStorage.dat");
            File newFile = new File("Temp.dat");
            
           BufferedReader readFile = new BufferedReader(new FileReader(delete));
           BufferedWriter writeFile = new BufferedWriter(new FileWriter(newFile));
           String FindData;
           while((FindData = readFile.readLine()) != null){
               if(!FindData.contains(EraseData)){
                   writeFile.write(FindData + System.getProperty("line.separator"));
               }
           }
           writeFile.close();
           readFile.close();
           
           if(delete.delete()){
               if(!newFile.renameTo(delete)){
                   System.out.println("Fail to rename");
               }
           }else{
               System.out.println("Can't delete");
           }
        }catch(IOException e){
            System.out.println("Fail to delete.");
        }
    }
}
