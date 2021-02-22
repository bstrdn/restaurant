package com.example.restaurant.service;

import com.example.restaurant.model.Dish;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Set<Dish> getAllDishes(Integer id) {
        return repository.getOne(id).getDishes();
    }
}
