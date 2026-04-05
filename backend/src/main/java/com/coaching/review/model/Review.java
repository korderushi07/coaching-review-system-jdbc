package com.coaching.review.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "review_id")
    private int id;

    @Column(name = "coaching_name")
    private String coachingName;

    @Column(name = "faculty_name")
    private String facultyName;

    private int rating;
    private String review;

    @Column(name = "student_name")
    private String studentName;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCoachingName() { return coachingName; }
    public void setCoachingName(String coachingName) { this.coachingName = coachingName; }
    public String getFacultyName() { return facultyName; }
    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
}