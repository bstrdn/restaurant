package com.example.restaurant.service;

import com.example.restaurant.model.Dish;
import com.example.restaurant.model.Order;
import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.repository.OrderRepository;
import com.example.restaurant.to.OrderTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DishRepository dishRepository;

    public OrderTo createOrder(Integer[] dishIds) {
        Order newOrder = new Order();
        int orderCost = 0;
        int orderCookingTime = 0;
        List<Dish> dishes = new ArrayList<>();
        for (Integer dishId : dishIds) {
            try {
                Dish dish = dishRepository.getOne(dishId);
                orderCost += dish.getPrice();
                orderCookingTime += dish.getTimeCooking();
                dishes.add(dish);
            } catch (Exception e) {
                log.error("dishes with id {} not found", dishId);
            }
        }
        newOrder.setOrderCost(orderCost);
        newOrder.setCookingTime(orderCookingTime);
        newOrder.setOrderList(dishes);
        orderRepository.save(newOrder);

        return new OrderTo(newOrder.getId(), orderCost, orderCookingTime, newOrder.getCreationTime());
    }
}
