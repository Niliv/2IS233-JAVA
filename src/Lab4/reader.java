package Lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class reader{

    /*
     * Reads the glossary file for the specified line. 
     * The line should contain two words, the first in the original language and the second in the training language.
     * 
     * @param   line_nr   The line from which the words should be read.
     * @return            Returns the given line of words as a String.  
     */
    public static String read_word(int line_nr){
        
        String file_name = "glosor.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(file_name))){
            
            String line;
            int current_line_nr = 0;

            while((line = br.readLine()) != null){
                current_line_nr++;

                if(current_line_nr == line_nr){
                    return line;
                }

            }       

        }
        catch(IOException e){
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        return null;

    }

}