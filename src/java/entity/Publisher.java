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
public class Publisher {
    private String id;
    private String publisher_name;

    public Publisher() {
    }

    public Publisher(String id, String publisher_name) {
        this.id = id;
        this.publisher_name = publisher_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    @Override
    public String toString() {
        return "Publisher{" + "id=" + id + ", publisher_name=" + publisher_name + '}';
    }
    
}
