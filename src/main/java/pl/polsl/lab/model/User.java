package pl.polsl.lab.model;
import pl.polsl.lab.model.FileHandler;

/**
 *
 * @author Jakub Janszak
 */
public class User {
    
    /**
     * Gets the user ID.
     * 
     * @return The user ID.
     */
    public int getId_user() {
        return idUser;
    }

    /**
     * Sets the user ID.
     * 
     * @param id_user The user ID to set.
     */
    public void setId_user(int id_user) {
        this.idUser = id_user;
    }
    
    /**
     * Gets the username.
     * 
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * 
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Gets the password.
     * 
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     * Parameterized constructor to initialize user properties.
     * 
     * @param id_user   The user ID.
     * @param username  The username.
     * @param password  The password.
     */
    public User(int id_user, String username, String password) {
        this.idUser = id_user;
        this.username = username;
        this.password = password;
    }
    
    int idUser;
    String username;
    String password;
     
    
}
