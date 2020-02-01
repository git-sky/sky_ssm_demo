package cn.com.sky.spring.ioc.aggregate_collection;

public class Book {

    private String name;
    private String author;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
    }
}