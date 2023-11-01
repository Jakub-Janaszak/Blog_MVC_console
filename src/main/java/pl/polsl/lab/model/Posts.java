package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.lab.model.Post;
import pl.polsl.lab.model.Users;
import pl.polsl.lab.model.FileHandler;

/**
 * Manages a list of posts, allowing for adding new posts, getting a list of posts, and setting the list of posts.
 * 
 * @author Jakub Janszak
 */
public class Posts {

    /**
     * List of posts.
     */
    private List<Post> postsList = new ArrayList<Post>();

    /**
     * Default constructor.
     */
    public Posts() {
    }

    /**
     * Adds a new post to the list and saves it to a file.
     * 
     * @param p The post to add.
     */
    public void addNewPost(Post p) {
        postsList.add(p);
        FileHandler fh = new FileHandler();
        fh.saveToFile("posts.txt", p.getTitle());
        fh.saveToFile("posts.txt", p.getContent());
        fh.saveToFile("posts.txt", String.valueOf(p.getAuthor().getId_user()));
    }

    /**
     * Gets the list of posts.
     * 
     * @return The list of posts.
     */
    public List<Post> getListOfPosts() {
        return postsList;
    }

    /**
     * Gets a post at a specified index.
     * 
     * @param index The index of the post.
     * @return The post at the specified index.
     */
    public Post getPost(int index) {
        return postsList.get(index);
    }

    /**
     * Sets the list of posts based on data read from a file.
     * 
     * @param users The user manager to find users by ID.
     */
    public void setListOfPosts(Users users) {
        List<String> listOfLines = new ArrayList<String>();
        FileHandler fh = new FileHandler();
        if (fh.readFromFile("posts.txt") != null) {
            listOfLines = fh.readFromFile("posts.txt");

            String title = "";
            String content = "";
            int id;

            for (int i = 0; i < listOfLines.size(); i++) {
                if (i % 3 == 0) {
                    title = listOfLines.get(i);
                } else if (i % 3 == 1) {
                    content = listOfLines.get(i);
                } else {
                    id = Integer.parseInt(listOfLines.get(i));
                    postsList.add(new Post(title, content, users.findUserById(id)));
                }
            }
        }
    }
}
