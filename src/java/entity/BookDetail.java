/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Thanh Phuc
 */
public class BookDetail {

    private String id;
    private String image;
    private String name;
    private String author;
    private String language;
    private String type;
    private String publisher;
    private String publishing_year;
    private int amount;
    private int quantity;
    public BookDetail() {
    }

    public BookDetail(String id, String image, String name, String author, String language, String type, String publisher, int amount) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.author = author;
        this.language = language;
        this.type = type;
        this.publisher = publisher;
        this.amount = amount;
    }

    public BookDetail(String id, String image, String name, String author, String language, String type, String publisher, String publishing_year, int amount) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.author = author;
        this.language = language;
        this.type = type;
        this.publisher = publisher;
        this.publishing_year = publishing_year;
        this.amount = amount;
    }

    public BookDetail(String id, String image, String name, String author, String language, String type, String publisher, String publishing_year, int amount, int quantity) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.author = author;
        this.language = language;
        this.type = type;
        this.publisher = publisher;
        this.publishing_year = publishing_year;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishing_year() {
        return publishing_year;
    }

    public void setPublishing_year(String publishing_year) {
        this.publishing_year = publishing_year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookDetail{" + "id=" + id + ", image=" + image + ", name=" + name + ", author=" + author + ", language=" + language + ", type=" + type + ", publisher=" + publisher + ", publishing_year=" + publishing_year + ", amount=" + amount + ", quantity=" + quantity + '}';
    }
    

    
}