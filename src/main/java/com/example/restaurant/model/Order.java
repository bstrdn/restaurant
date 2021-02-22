package com.example.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractBaseEntity {

    @Getter
    @Setter
    @Column(name = "order_cost")
    private Integer orderCost;

    @Getter
    @Setter
    @Column(name = "cooking_time")
    private Integer cookingTime;

    @Getter
    @Column(name = "creation_time")
    private LocalDateTime creationTime = LocalDateTime.now();

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_dishes",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")})
    private List<Dish> orderList;

    public Order(Integer id, Integer orderCost) {
        super(id);
        this.orderCost = orderCost;
    }
}
