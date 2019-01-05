
package info.ziang.scs.entity;

public class Book {

    private String name;

    private double price;

    private String author;

    private String publisher;

    /**
     * Default constructure must be reserved.
     * Service Comsumer MAY use.
     */
    public Book(){
        super();
    }

    public Book(String name, int price, String author, String publisher) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}