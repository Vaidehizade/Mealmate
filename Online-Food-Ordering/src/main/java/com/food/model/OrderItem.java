package com.food.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.food.model.Foods;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     //many orders have same food
    @ManyToOne
    private Foods foods;

    private int quantity;

    private Long totalPrice;

    private List<String> ingredients;
}
