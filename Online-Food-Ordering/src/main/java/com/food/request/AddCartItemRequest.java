package com.food.request;

import java.util.List;

public class AddCartItemRequest {
    private Long foodId;
    private int quantity;
    private List<String> ingredients;
}
