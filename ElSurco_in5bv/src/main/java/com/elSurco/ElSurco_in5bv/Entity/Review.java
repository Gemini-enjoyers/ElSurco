package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReview")
    private Integer idReview;

    @Min(value = 1, message = "Minimum score is 1")
    @Max(value = 5, message = "Maximum score is 5")
    @Column(name = "reviewScore")
    private Integer reviewScore;

    @Size(max = 200, message = "Maximum 200 characters")
    @Column(name = "reviewComment", columnDefinition = "TEXT")
    private String reviewComment;

    @NotNull(message = "Date field is required")
    @PastOrPresent(message = "Date cannot be in the future")
    @Column(name = "reviewDate")
    private LocalDate reviewDate;

    @Column(name = "idProduct")
    private Integer idProduct;

    @Column(name = "idBuyer")
    private Integer idBuyer;

    public Integer getIdReview() { return idReview; }
    public void setIdReview(Integer idReview) { this.idReview = idReview; }
    public Integer getReviewScore() { return reviewScore; }
    public void setReviewScore(Integer reviewScore) { this.reviewScore = reviewScore; }
    public String getReviewComment() { return reviewComment; }
    public void setReviewComment(String reviewComment) { this.reviewComment = reviewComment; }
    public LocalDate getReviewDate() { return reviewDate; }
    public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }
    public Integer getIdProduct() { return idProduct; }
    public void setIdProduct(Integer idProduct) { this.idProduct = idProduct; }
    public Integer getIdBuyer() { return idBuyer; }
    public void setIdBuyer(Integer idBuyer) { this.idBuyer = idBuyer; }
}