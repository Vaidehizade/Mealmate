package com.food.repository;

import com.food.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Foods,Long> {

    List<Foods> findByRestaurantId(Long restaurantId);

    //query for searching food
    @Query("SELECT f FROM food f WHERE f.name LIKE %:keyword% OR f.foodCategory.name LIKE %:keyword%")
    List<Foods>searchFood(@Param("keyword") String keyword);


}
