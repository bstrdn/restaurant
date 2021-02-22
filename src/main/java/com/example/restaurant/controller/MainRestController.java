package com.example.restaurant.controller;

import com.example.restaurant.model.Dish;
import com.example.restaurant.service.MenuService;
import com.example.restaurant.service.OrderService;
import com.example.restaurant.to.OrderTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequestMapping(value = MainRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MainRestController {
    static final String REST_URL = "/rest/";

    @Autowired
    MenuService menuService;
    @Autowired
    OrderService orderService;

    @GetMapping("/menu/{id}")
    public Set<Dish> getAllDishesFromMenu(@PathVariable int id) {
        log.info("getAll dishes for menu {}", id);
        return menuService.getAllDishes(id);
    }

    @GetMapping(path = "/order/makeanorder", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderTo makeAnOrder(@RequestParam(value = "id") Integer[] dishes) {
        return orderService.createOrder(dishes);
    }
}
