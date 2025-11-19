package com.moviesApi.moviesBackend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String review;

    public Review(String review) { //LocalDateTime created, LocalDateTime updated
        this.review = review;
        // this.created = created;
        // this.updated = updated;
    }
}
