package com.kuechelib.erecipes.ingredients.repository;

import com.kuechelib.erecipes.ingredients.controller.MeasurementUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ingredients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String attribute;
    @Enumerated(EnumType.STRING)
    private MeasurementUnit unit;


}
