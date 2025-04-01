package com.food.repository;

import com.food.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {

      List<IngredientCategory> findByRestaurantId(Long id);

}
