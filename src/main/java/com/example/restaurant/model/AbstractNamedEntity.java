package com.example.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "description", nullable = false)
    private String description;

    protected AbstractNamedEntity(Integer id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
