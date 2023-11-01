package pl.polsl.lab.kontroler;
import pl.polsl.lab.kontroler.Input;
import pl.polsl.lab.model.User;
import pl.polsl.lab.model.Users;
import pl.polsl.lab.model.Post;
import pl.polsl.lab.model.Posts;
import pl.polsl.lab.widok.Output;
import pl.polsl.lab.model.FileHandler;


import java.util.ArrayList;
import java.util.List;
/**
 * Represents the main control logic of the Blog application.
 * 
 * @author Jakub Janszak
 */
public class Blog {
    
    private User loggedUser;
    Input inp = new Input();
    Output outp = new Output();
    
    /**
     *
     */
    public Blog() {
    }
    
    /**
     * Method to create test users for the application.
     */
    public void createUsersTest(){
    Input input = new Input();
    Output output = new Output();
    Users users = new Users();
    String username;
    String password;
        
        
        
    output.consoleWriteLine("Podaj dane użytkownaika 1: ");
        
    username = input.inputConsole();
    password = input.inputConsole();
     
    try{
    users.addNewUser(new User(0, username, password));
    }
    catch (BlogException e) {
        output.consoleWriteLine("Błąd: " + e.getMessage());
    }    
    //---
        
    output.consoleWriteLine("Podaj dane użytkownaika 2: ");
        
    username = input.inputConsole();
    password = input.inputConsole();
     
    try{
        users.addNewUser(new User(1, username, password));
    }
    catch (BlogException e) {
        output.consoleWriteLine("Błąd: " + e.getMessage());
    }    
    output.displayAllUsersData(users);
    }
    
    
    /**
     * Method to create a new user based on user input.
     * 
     * @param users The Users object to add the new user to.
     * @return The newly created user.
     */
    User createUser(Users users){
        Input input = new Input();
    Output output = new Output();
    
    String username;
    String password;
        
        
    output.consoleWriteLine("REJESTRACJA");    
    output.consoleWriteLine("Podaj dane użytkownika.");
    output.consoleWriteLine("Nick: ");
    username = input.inputConsole();
    output.consoleWriteLine("Hasło: ");
    password = input.inputConsole();
        
    User newUser = new User(users.getListOfUsers().size(), username, password);
    output.consoleWriteLine("\n Utworzono nowe konto! \n");
    return newUser;
    }
    
    
     /**
     * Method to log in a user based on user input.
     * 
     * @param users The Users object to search for the user.
     */
    void loginUser(Users users){
    Input input = new Input();
    Output output = new Output();
    
    String username;
    String password;
        
    output.consoleWriteLine("LOGOWANIE");    
    output.consoleWriteLine("Podaj dane użytkownaika.");
    output.consoleWriteLine("Nick: ");
    username = input.inputConsole();
    
    User user = users.findUserByUsername(username);
    
    if(user == null){
        output.consoleWriteLine("Nie ma użytkowanika o takim nicku.");
        return;
    }
    
    output.consoleWriteLine("Hasło: ");
    password = input.inputConsole();
    
    if(user.getPassword().equals(password)){
        output.consoleWriteLine("Zalogowano pomyślnie!");
        loggedUser = user;
    }
    else{
        output.consoleWriteLine("Błędne hasło.");
    }
    }
    
    
    /**
     * Method to create a new post based on user input.
     * 
     * @param posts The Posts object to add the new post to.
     */
    void createPost(Posts posts){
        Input input = new Input();
        Output output = new Output();
        String title;
        String content;
        
        output.consoleWriteLine("TWORZENIE POSTU");
        output.consoleWrite("Tytuł: ");
        title = input.inputConsole();
        output.consoleWriteLine("Treść: ");
        content = input.inputConsole();
        
        posts.addNewPost(new Post(title,content,loggedUser));
        
    }
    
    /**
     * Main menu method to handle user interaction.
     */
    void menu(){
        Input input = new Input();
        Output output = new Output();
        Users users = new Users();
        Posts posts = new Posts();
        posts.setListOfPosts(users);
        int choice, choice2;
    
        
        do{
        output.displayMainMenu();
        choice = input.inputIntConsole();
            
        switch(choice){
            case 1:{
                loginUser(users);
                if(loggedUser != null){
                do{
                   output.displaySideMenu();
                   choice2 = input.inputIntConsole(); 
                   switch(choice2){
                       case 1:
                           output.displayAllPosts(posts);
                           break;
                       case 2:
                           createPost(posts);
                           break;
                       case 0:{
                           loggedUser = null;
                           output.consoleWriteLine("Wylogowano");
                       }
                       break;
                }
                   
                }while(choice2 != 0);
                }
            }
                break;
            case 2:
                try{
                    users.addNewUser(createUser(users));
                }
                catch (BlogException e) {
                    output.consoleWriteLine("Błąd: " + e.getMessage());
                }
                
                break;
            case 0:
                output.consoleWriteLine("Wyjście z programu");
                break;
        }
        }while(choice != 0);
    }
    
    /**
     * Method to start the execution of the Blog application.
     */
    public void run(){
        menu();
    }
}
