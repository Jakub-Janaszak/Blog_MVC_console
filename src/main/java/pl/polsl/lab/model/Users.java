package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.List;
import pl.polsl.lab.model.User;
import pl.polsl.lab.model.FileHandler;

import pl.polsl.lab.kontroler.BlogException;

/**
 * Represents a collection of users with methods to manipulate user data.
 * 
 * @author Jakub Janszak
 */
public class Users {

    /**
     * List to store user objects.
     */
    List<User> userList = new ArrayList<User>();

    /**
     * Default constructor, initializes the list of users by reading from a file.
     */
    public Users() {
        setListOfUsers();
    }

    /**
     * Adds a new user to the list and saves it to the "users.txt" file.
     * 
     * @param u The user to add.
     * @throws BlogException If the username or password is empty.
     */
    public void addNewUser(User u) throws BlogException {
        if (u.getUsername() == null || u.getPassword() == null || u.getUsername().isEmpty() || u.getPassword().isEmpty()) {
            throw new BlogException("Username and password cannot be empty");
        }

        userList.add(u);
        FileHandler fh = new FileHandler();
        fh.saveToFile("users.txt", String.valueOf(u.idUser) + " " + u.username + " " + u.password);
    }

    /**
     * Gets the list of users.
     * 
     * @return The list of users.
     */
    public List<User> getListOfUsers() {
        return userList;
    }

    /**
     * Retrieves a specific user from the list based on the index.
     * 
     * @param index The index of the user.
     * @return The user at the specified index.
     */
    public User show_one_user(int index) {
        return userList.get(index);
    }

    /**
     * Finds a user based on their username.
     * 
     * @param username The username to search for.
     * @return The user with the specified username, or null if not found.
     */
    public User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Finds a user based on their ID.
     * 
     * @param id The ID to search for.
     * @return The user with the specified ID, or null if not found.
     */
    public User findUserById(int id) {
        for (User user : userList) {
            if (user.getId_user() == (id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Reads user data from the "users.txt" file and populates the user list.
     */
    public void setListOfUsers() {
        List<String> listOfLines = new ArrayList<String>();
        FileHandler fh = new FileHandler();
        if (fh.readFromFile("users.txt") != null) {
            listOfLines = fh.readFromFile("users.txt");

            for (int i = 0; i < listOfLines.size(); i++) {
                String[] separatedElements = listOfLines.get(i).split(" ");
                userList.add(new User(Integer.parseInt(separatedElements[0]), separatedElements[1], separatedElements[2]));
            }
        }
    }
}