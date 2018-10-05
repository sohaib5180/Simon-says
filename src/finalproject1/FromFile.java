/*
 *Name: Sohaib Hussain
 *Date: 13th April 2018
 */
package finalproject1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class takes the pathway of a file and then retrieves the integers from 
 * the file and puts it into an array on integers.
 * 
 * @author Sohaib Hussain
 */
public class FromFile {
    private final String filePathname;
    /**
     * Constructor of the Class FromFile
     * 
     *@param filePathname is the absolute/relative pathway of the file.
     * @see HighScorePageController
     */
    public FromFile(String filePathname){
        this.filePathname = filePathname;
    }
    /**
     * Retrieves the integers from the file into an array. 
     * 
     *@return array of integers read from the file.
     *@throws FileNotFoundException for if the file is not found
     */
    public ArrayList<String> retrieve() throws FileNotFoundException {
        File f1= new File(filePathname);
        ArrayList<String> data= new ArrayList();
        
        File[] directoryListing = f1.listFiles();
        if((directoryListing != null)){
            for (File child : directoryListing) {
                     FileInputStream fIn = new FileInputStream(child);
                try (DataInputStream dIn = new DataInputStream(fIn)) {
                    while (true) {
                        data.add(dIn.readUTF());
                        data.add(Integer.toString(dIn.readInt()));
                    }
                } catch (IOException e) {
                    System.out.println("End of File");
                }
            }
            if(!data.isEmpty()){
                return data;
            }
            else{
                return data;
            }
        }
       else{
            return data;
        }
   }

 
}
