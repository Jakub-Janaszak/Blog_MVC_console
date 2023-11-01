package pl.polsl.lab.kontroler;

import java.util.Scanner;

/**
 * Handles user input for the blog application.
 * 
 * @author Jakub Janaszak
 * @version 1.0
 */
public class Input {

    /**
     * Default constructor for the Input class.
     */
    public Input() {
    }
    
    /**
     * Reads a line of text from the console.
     * 
     * @return The input text.
     */
    public String inputConsole(){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        return text;
    }
    
    /**
     * Reads an integer from the console.
     * 
     * @return The input integer.
     */
    public int inputIntConsole(){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.nextLine();
        return number;
    }
}