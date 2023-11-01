/*
 * The Output class provides methods for displaying information in the console related to the Blog application.
 * It includes methods for writing lines, displaying user data, posts, menus, and lists of strings.
 */
package pl.polsl.lab.widok;
import pl.polsl.lab.model.User;
import pl.polsl.lab.model.Users;
import pl.polsl.lab.model.Post;
import pl.polsl.lab.model.Posts;

import java.util.ArrayList;
import java.util.List;

/**
 * The Output class provides methods for displaying information in the console related to the Blog application.
 * @author Jakub Janaszak
 */
public class Output {

    /**
     * Default constructor for the Output class.
     */
    public Output() {
    }
    
    /**
     * Writes a line of text to the console.
     *
     * @param text The text to be written to the console.
     */
    public void consoleWriteLine(String text){
        System.out.println(text);
    }
    
    /**
     * Writes text to the console without a newline.
     *
     * @param text The text to be written to the console.
     */
    public void consoleWrite(String text){
        System.out.print(text);
    }
    
    /**
     * Displays user data in the console.
     *
     * @param u The User object whose data is to be displayed.
     */
    public void displayUserData(User u){
    consoleWriteLine("id: "+Integer.toString(u.getId_user())+" | nazwa: "+u.getUsername()+" | hasło: "+u.getPassword());
    }
    
    /**
     * Displays all users' data in the console.
     *
     * @param us The Users object containing a list of users.
     */
    public void displayAllUsersData(Users us){
        for(int i=0; i<us.getListOfUsers().size(); i++)
        displayUserData(us.getListOfUsers().get(i));
    }
    
    /**
     * Displays post data in the console.
     *
     * @param p The Post object whose data is to be displayed.
     */
    public void displayPost(Post p){
    consoleWriteLine("autor: "+p.getUsernameOfAuthor());
    consoleWriteLine("tytuł: "+p.getTitle());
    consoleWriteLine("treść: "+p.getContent());
    }
    
    /**
     * Displays all posts in the console.
     *
     * @param p The Posts object containing a list of posts.
     */
    public void displayAllPosts(Posts p){
        consoleWriteLine("POSTY");
        for(int i=p.getListOfPosts().size()-1; i>=0; i--)
        {
            displayPost(p.getListOfPosts().get(i));
            consoleWriteLine("");
        }
    }
    
    /**
     * Displays the main menu options in the console.
     */
    public void displayMainMenu(){
        consoleWriteLine("BLOG");
        consoleWriteLine("1. Zaloguj się");
        consoleWriteLine("2. Zarejestruj się");
        consoleWriteLine("0. Wyjdz");
    }
    
    /**
     * Displays the side menu options in the console.
     */
    public void displaySideMenu(){
        consoleWriteLine("MENU");
        consoleWriteLine("1. Wyświetl blog");
        consoleWriteLine("2. Napisz post");
        consoleWriteLine("0. Wyloguj");
    }
    
    /**
     * Displays a list of strings in the console.
     *
     * @param l The list of strings to be displayed.
     */
    public void displayListOfString(List<String> l){
        for(int i=0; i<l.size(); i++)
        consoleWriteLine(l.get(i));
    }
    
}
