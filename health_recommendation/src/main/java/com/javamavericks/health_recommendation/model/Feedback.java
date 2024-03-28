package com.javamavericks.health_recommendation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="feedback")
@Getter
@Setter
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private FeedBackEnum diet;

    @Enumerated(value = EnumType.STRING)
    private FeedBackEnum exercise;

    @Enumerated(value = EnumType.STRING)
    private FeedBackEnum sleep;

    @Column(name = "mental_health")
    @Enumerated(value = EnumType.STRING)
    private FeedBackEnum mentalHealth;

    @JsonIgnore
    @OneToOne(mappedBy = "feedback")
    private User user;

}
