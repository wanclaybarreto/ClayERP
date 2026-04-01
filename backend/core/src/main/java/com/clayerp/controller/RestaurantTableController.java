package com.clayerp.controller;

import com.clayerp.dto.ApiResponse;
import com.clayerp.dto.CreateRestaurantTableRequest;
import com.clayerp.dto.CreateRestaurantTableResponse;
import com.clayerp.service.RestaurantTableService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @PostMapping
    public ApiResponse<CreateRestaurantTableResponse> create(@RequestBody CreateRestaurantTableRequest crtRequest) {
        return new ApiResponse<>(true, restaurantTableService.createRestaurantTable(crtRequest));
    }

}
