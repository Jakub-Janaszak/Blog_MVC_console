package pl.polsl.lab.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.lab.kontroler.BlogException;

/**
 * Handles file operations, including saving content to a file and reading content from a file.
 * 
 * @author Jakub Janszak
 */
public class FileHandler {
    
    /**
     * Saves content to a file.
     * 
     * @param nameOfFile The name of the file to save to.
     * @param content The content to be saved.
     */
    public void saveToFile(String nameOfFile, String content) {
        try {
            File file = new File(nameOfFile);

            FileWriter fileWriter = new FileWriter(file, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);
            bufferedWriter.newLine(); 

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Reads content from a file.
     * 
     * @param nameOfFile The name of the file to read from.
     * @return A list of lines read from the file.
     */
    public List<String> readFromFile(String nameOfFile) {
        File file = new File(nameOfFile);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                List<String> listOfLines = new ArrayList<String>();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    listOfLines.add(line);
                }
                
                bufferedReader.close();
                return listOfLines;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.err.println("File " + nameOfFile + " does not exist.");
            return null;
        }
    }
}
