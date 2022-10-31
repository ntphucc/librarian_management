/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Vo Viet Nhan
 */
public class Author {
    private String id;
    private String author_name;

    public Author() {
    }

    public Author(String id, String author_name) {
        this.id = id;
        this.author_name = author_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", author_name=" + author_name + '}';
    }
    
}
