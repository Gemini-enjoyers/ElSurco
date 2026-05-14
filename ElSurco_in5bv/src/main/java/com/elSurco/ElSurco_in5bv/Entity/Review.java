package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Ratings") // <-- Aquí le decimos que use la tabla Ratings de la BD
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRating") // El ID en la BD se llama idRating
    private Integer idReview;

    @Column(name = "ratingScore", nullable = false) // Mapeado a la BD
    private Integer reviewScore;

    @Column(name = "ratingComment", columnDefinition = "TEXT")
    private String reviewComment;

    @Column(name = "ratingDate", insertable = false, updatable = false)
    private LocalDate reviewDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    public Review() {}

    public Integer getIdReview() { return idReview; }
    public void setIdReview(Integer idReview) { this.idReview = idReview; }
    public Integer getReviewScore() { return reviewScore; }
    public void setReviewScore(Integer reviewScore) { this.reviewScore = reviewScore; }
    public String getReviewComment() { return reviewComment; }
    public void setReviewComment(String reviewComment) { this.reviewComment = reviewComment; }
    public LocalDate getReviewDate() { return reviewDate; }
    public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}