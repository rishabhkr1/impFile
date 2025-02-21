package com.daytona.fooddeliveryapp.service;
import com.daytona.fooddeliveryapp.repository.RestaurantRepository;
import com.daytona.fooddeliveryapp.entity.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantDAO saveRestaurant(RestaurantDAO restaurantDAO) {
        return restaurantRepository.save(restaurantDAO);
    }

    public RestaurantDAO getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }
    public List<RestaurantDAO> getAllRestaurants(){
        return restaurantRepository.findAll();
    }
}
