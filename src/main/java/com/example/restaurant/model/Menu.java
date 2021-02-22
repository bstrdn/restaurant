package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "menus")
public class Menu extends AbstractNamedEntity {

    @Getter
    @Setter
    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Dish> dishes;

    public Menu(Integer id, String name, String description) {
        super(id, name, description);
    }
}
