package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
public class Dish extends AbstractNamedEntity {

    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Integer price;

    @Getter
    @Setter
    @Column(name = "time_coocking", nullable = false)
    private Integer timeCooking;

    @Getter
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Menu menu;

    @Getter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orderList")
    private List<Order> orders;

    public Dish(Integer id, String name, String description, Integer price, Integer timeCooking) {
        super(id, name, description);
        this.price = price;
        this.timeCooking = timeCooking;
    }
}
