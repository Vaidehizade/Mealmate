package com.food.service;

import com.food.model.Category;
import com.food.model.Foods;
import com.food.model.Restaurant;
import com.food.repository.FoodRepository;
import com.food.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodServiceImp implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Foods createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        Foods foods = new Foods();
        foods.setFoodCategory(category);
        foods.setRestaurant(restaurant);
        foods.setDescription(req.getDescription());
        foods.setImages(req.getImages());
        foods.setPrice(req.getPrice());
        foods.setIngredients(req.getIngredients());
        foods.setSeasonal(req.isSeasonal());
        foods.setVegetarian(req.isVegetarian());

        Foods savedFood = foodRepository.save(foods);
        restaurant.getFoods().add(savedFood);
        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Foods foods = findFoodById(foodId);
        foods.setRestaurant(null);
        foodRepository.save(foods);
    }

    @Override
    public List<Foods> getRestaurantsFood(Long restaurantId, boolean isVegetarian, boolean isNonveg, boolean isSeasonal, String foodCategory) {
        List<Foods> foods = foodRepository.findByRestaurantId(restaurantId);
        if(isVegetarian){
            foods = filterByVegetarian(foods,isVegetarian);
        }
        if(isNonveg){
            foods = filterByNonveg(foods,isNonveg);
        }
        if(isSeasonal){
            foods = filterBySeasonal(foods,isSeasonal);
        }
        if(foodCategory!=null && !foodCategory.equals("")){
            foods = filterByCategory(foods,foodCategory);
        }

        return foods;
    }

    private List<Foods> filterByCategory(List<Foods> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory()!=null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());

    }

    private List<Foods> filterBySeasonal(List<Foods> foods, boolean isSeasonal) {
        return foods.stream().filter(food -> food.isSeasonal() == isSeasonal).collect(Collectors.toList());
    }

    private List<Foods> filterByVegetarian(List<Foods> foods, boolean isVegetarian) {

        return foods.stream().filter(food -> food.isVegetarian() == isVegetarian).collect(Collectors.toList());
    }
    
    private List<Foods> filterByNonveg(List<Foods> foods,boolean isNonveg){
       return foods.stream().filter(food ->food.isVegetarian() == false).collect(Collectors.toList());
    }
    @Override
    public List<Foods> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Foods findFoodById(long foodId) throws Exception {
        Optional<Foods> optionalFood = foodRepository.findById(foodId);

        if(optionalFood.isEmpty()){
            throw new Exception("food not exists");
        }
        return optionalFood.get();
    }

    @Override
    public Foods setAvailabilityStatus(Long foodId) throws Exception {
        Foods foods = findFoodById(foodId);
        foods.setAvailable(foods.isAvailable());
        return foodRepository.save(foods);
    }
}
