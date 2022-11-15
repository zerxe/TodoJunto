package todojunto.model;

/**
 *
 * @author Adolfo Morales Colmenares
 */
public class Book {

    private int code;
    private String title;
    private String author;
    private String publisher;
    private String subject;
    private String status;

    public Book() {
    }

    public Book(int code, String title, String author, String publisher, String subject, String status) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.subject = subject;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
