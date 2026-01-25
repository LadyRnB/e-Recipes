package com.kuechelib.erecipes.ingredients.service;

import com.kuechelib.erecipes.ingredients.repository.IngredientEntity;

public class IngredientEntityMapper {
    public IngredientEntity mapDtoToEntity(IngredientDTO ingredientDTO){
        return new IngredientEntity(ingredientDTO.id(), ingredientDTO.name(), ingredientDTO.attribute(), ingredientDTO.unit());
    }

    public IngredientDTO mapEntityToDto(IngredientEntity ingredientEntity){
        return new IngredientDTO(ingredientEntity.getId(), ingredientEntity.getName(), ingredientEntity.getAttribute(), ingredientEntity.getUnit());
    }

}
