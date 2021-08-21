package com.altin.mongodbdocument;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Nested")
public class Object {
    @Id
    private String name;
    private Contact contact;
    private int stars;
    private List<String> categories;

    public Object(String name, Contact contact, int stars, List<String> categories) {
        this.name = name;
        this.contact = contact;
        this.stars = stars;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}

class Contact{
    private String phone;
    private String email;
    private List<Double> location;

    public Contact(String phone, String email, List<Double> location) {
        this.phone = phone;
        this.email = email;
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }
}
