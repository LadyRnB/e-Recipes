package com.kuechelib.erecipes.ingredients.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IngredientService {

    public IngredientDTO createIngredient(IngredientDTO newIngredientDTO) {
    System.out.println("The ingredient that will be created is: " + newIngredientDTO);
    Long id = new Random().nextLong();
    IngredientDTO createdIngredientDTO = new IngredientDTO(id, newIngredientDTO.name(), newIngredientDTO.attribute(), newIngredientDTO.unit());
    System.out.println("The ingredient is finally created");
    return createdIngredientDTO;
}
}
