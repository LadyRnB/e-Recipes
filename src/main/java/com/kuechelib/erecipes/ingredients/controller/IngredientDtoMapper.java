package com.kuechelib.erecipes.ingredients.controller;

import com.kuechelib.erecipes.ingredients.service.IngredientDTO;

public class IngredientDtoMapper {

    public IngredientDTO mapRequestToDto(CreationIngredientRequest ingredientRequest) {
        return new IngredientDTO(null, ingredientRequest.name(), ingredientRequest.attribute(), ingredientRequest.unit());
    }
    public IngredientResponse mapDtoToResponse(IngredientDTO ingredientDTO){
        return new IngredientResponse(ingredientDTO.id(), ingredientDTO.name(), ingredientDTO.attribute(), ingredientDTO.unit());

    }
    public IngredientDTO mapRequestAndIdToDto(CreationIngredientRequest ingredientRequest, Long ingredientId){
        return new IngredientDTO(ingredientId, ingredientRequest.name(), ingredientRequest.attribute(), ingredientRequest.unit());
    }
}
