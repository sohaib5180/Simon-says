/*
 *Name: Sohaib Hussain
 *Date: 13th April 2018
 */
package finalproject1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This Class take the array of integers and the pathname of the file and
 * transfers the integers into the file.
 * @author Sohaib Hussain
 */
public class ToFile {
    private int score;
    private String username;
    private final String Pathname;
    private boolean append;
    /**
     * @param username the initial username given by the user
     * @param score the initial integer of the score
     * @param Pathname the absolute/relative pathway to a file
     * @param append true or false, if it is appended
     */
    public ToFile(int score,String username,String Pathname,boolean append){
        this.username=username;
        this.score=score;
        this.Pathname= Pathname;
        this.append = append;
    }
    /**
    * This method simply sends the array of integers to a file whose pathway is
    * given in as an argument in this class.
    * @exception FileNotFoundException for if the file is not found
    */
    public void send() throws FileNotFoundException, IOException{
        File f1 = new File(Pathname + "/" + username +".txt");
        if(f1.exists()){
            FileOutputStream fOut = new FileOutputStream(f1,append);
            try(DataOutputStream dOut = new DataOutputStream(fOut)){
                dOut.writeUTF(username); dOut.writeInt(score);              
            }      
        }
        else{
            if(f1.createNewFile()){
                FileOutputStream fOut = new FileOutputStream(f1,append);
                try(DataOutputStream dOut = new DataOutputStream(fOut)){
                dOut.writeUTF(username); dOut.writeInt(score);   
               }    
            }   
             else{
               System.out.println("Unable to create the file");
             }
        
                         
    }
    }
    
}
