package com.kuechelib.erecipes.ingredients.controller;

import com.kuechelib.erecipes.ingredients.service.IngredientDTO;

public class IngredientDtoMapper {

    public IngredientDTO map(CreationIngredientRequest ingredientRequest) {
        return new IngredientDTO(null, ingredientRequest.name(), ingredientRequest.attribute(), ingredientRequest.unit());
    }
    public IngredientResponse map(IngredientDTO ingredientDTO){
        return new IngredientResponse(ingredientDTO.id(), ingredientDTO.name(), ingredientDTO.attribute(), ingredientDTO.unit());

    }
}
