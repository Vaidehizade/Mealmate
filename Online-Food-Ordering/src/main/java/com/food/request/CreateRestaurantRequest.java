package com.food.request;

import com.food.model.Address;
import com.food.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {
    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<String> images;

    public Address getAddress()
    {
        return this.address;
    }

    public ContactInformation getContactInformation(){
        return this.contactInformation;
    }

    public String getCuisineType(){
        return this.cuisineType;
    }

    public String getDescription()
    {
        return this.description;
    }

    public List<String> getImages() {
        return images;
    }

    public String getName(){
        return name;
    }
    public String getOpeningHours(){
        return openingHours;
    }
}
