package com.food.request;

import lombok.Data;

@Data
public class IngredientCategoryRequest {

    private String name;
    private Long restaurantId;

    public Long getRestaurantId() {
        return restaurantId;
    }
}
