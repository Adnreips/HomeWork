package project1.lesson8.task01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WriteFile
 *
 * @author "Andrei Prokofiev"
 */
public class WriteFile {

    public static void main(String[] args) {

        writeUsingBufferedWriter("hello", 5);
    }

    private static void writeUsingBufferedWriter(String data, int noOfLines) {

        String file1 = "test1.txt";
        File file = new File(file1);
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = data + System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
