package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String genre;
    private Integer issueNumber;
    private Integer releaseYear;
    private Double price;

    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false) 
    private Publisher publisher;


    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    public Publisher getPublisher() {
        return this.publisher;
    }

  
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Integer getIssueNumber() { return issueNumber; }
    public void setIssueNumber(Integer issueNumber) { this.issueNumber = issueNumber; }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
