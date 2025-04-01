package com.food.service;

import com.food.model.Category;
import com.food.model.Foods;
import com.food.model.Restaurant;
import com.food.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Foods createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    void deleteFood(Long foodId) throws Exception;

    public List<Foods> getRestaurantsFood(Long restaurantId,
                                          boolean isVegetarian,
                                          boolean isNonveg, boolean isSeasonal, String foodCategory);

    public List<Foods> searchFood(String keyword);

    public Foods findFoodById(long foodId) throws Exception;

    public Foods setAvailabilityStatus(Long foodId) throws Exception;

    public Foods updateAvailabilityStatus(Long id);
}
