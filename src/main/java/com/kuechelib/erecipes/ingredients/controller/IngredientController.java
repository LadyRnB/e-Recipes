package com.kuechelib.erecipes.ingredients.controller;

import com.kuechelib.erecipes.ingredients.service.IngredientDTO;
import com.kuechelib.erecipes.ingredients.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public IngredientResponse createIngredient(@RequestBody CreationIngredientRequest ingredientRequest) {
        System.out.println("The new ingredient is: " + ingredientRequest);
        IngredientDTO respondedIngredientDTO = ingredientService.createIngredient(new IngredientDTO(null, ingredientRequest.name(), ingredientRequest.attribute(), ingredientRequest.unit()));
        return new IngredientResponse(respondedIngredientDTO.id(), respondedIngredientDTO.name(), respondedIngredientDTO.attribute(), respondedIngredientDTO.unit());

    }
}
