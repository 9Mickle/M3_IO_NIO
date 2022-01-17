package com.epam.task4.model;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "author", "title", "genre", "price", "publishDate", "description"})
public class Book {

    private String id;
    private String author;
    private String title;
    private String genre;
    private Double price;
    private String description;
    private Date publishDate;

    public Book() {
    }

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authors) {
        this.author = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlElement(name = "publish_date")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return  "id: " + this.id.replaceAll("\\D+", "") + "\n" +
                "author: " + this.author + "\n" +
                "title: " + this.title + "\n" +
                "genre: " + this.genre + "\n" +
                "price: " + this.price + "\n" +
                "publish_date: " + sdf.format(this.publishDate) + "\n" +
                "description: " + this.description + "\n";
    }
}
