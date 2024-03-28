package com.javamavericks.health_recommendation.model.diet;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="diet")
@Getter
@Setter
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "breakfast")
    private String breakfast;

    @Column(name = "lunch")
    private String lunch;

    @Column(name = "dinner")
    private String dinner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutritional_info_id")
    private NutritionalInfo nutritionalInfo;
}
