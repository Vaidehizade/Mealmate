package com.food.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    //many ingredients have same category
    private IngredientCategory category;

    //one restaurant have multiple
    @ManyToOne
    private Restaurant restaurant;

    private boolean inStoke = true;

}
