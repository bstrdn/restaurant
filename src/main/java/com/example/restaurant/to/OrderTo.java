package com.example.restaurant.to;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@ToString
@AllArgsConstructor
public class OrderTo {

    private Integer id;

    private Integer orderCost;

    private Integer cookingTime;

    private LocalDateTime creationTime;
}
