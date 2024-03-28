package com.javamavericks.health_recommendation.model.diet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javamavericks.health_recommendation.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="nutritional_info")
@Getter
@Setter
public class NutritionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int calories;
    private String protein;
    private String carbohydrates;
    private String fat;
    private String fiber;

    @JsonIgnore
    @OneToOne(mappedBy = "nutritionalInfo")
    private Diet diet;
}
