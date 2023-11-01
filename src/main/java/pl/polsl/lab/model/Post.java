package pl.polsl.lab.model;

/**
 * Represents a blog post with title, content, and author information.
 * 
 * @author Jakub Janaszak
 */
public class Post {

    private String title;
    private String content;
    private User author;
    private String usernameOfAuthor;

    /**
     * Constructs a new blog post.
     * 
     * @param title The title of the post.
     * @param content The content of the post.
     * @param author The author of the post.
     */
    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.usernameOfAuthor = author.getUsername();
    }

    /**
     * Gets the title of the post.
     * 
     * @return The title of the post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the post.
     * 
     * @param title The new title of the post.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the content of the post.
     * 
     * @return The content of the post.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the post.
     * 
     * @param content The new content of the post.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the author of the post.
     * 
     * @return The author of the post.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the author of the post.
     * 
     * @param author The new author of the post.
     */
    public void setAuthor(User author) {
        this.author = author;
        this.usernameOfAuthor = author.getUsername();
    }

    /**
     * Gets the username of the author.
     * 
     * @return The username of the author.
     */
    public String getUsernameOfAuthor() {
        return usernameOfAuthor;
    }
}
