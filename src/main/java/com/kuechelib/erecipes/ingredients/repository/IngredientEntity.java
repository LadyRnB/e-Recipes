package com.kuechelib.erecipes.ingredients.repository;

import com.kuechelib.erecipes.ingredients.controller.MeasurementUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String attribute;
    private MeasurementUnit unit;


}
