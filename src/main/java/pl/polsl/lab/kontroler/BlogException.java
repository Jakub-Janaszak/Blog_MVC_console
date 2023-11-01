package pl.polsl.lab.kontroler;

/**
 * Custom exception class for handling blog-related exceptions.
 * Extends the base Exception class.
 * 
 * @author Jakub Janaszak
 * @version 1.0
 */
public class BlogException extends Exception {

    /**
     * Constructor for the BlogException class.
     * 
     * @param message
     */
    public BlogException(String message) {
        super(message);
    }
}