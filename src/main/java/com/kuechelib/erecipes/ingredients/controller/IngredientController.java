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

    private final IngredientDtoMapper mapper = new IngredientDtoMapper();

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public IngredientResponse createIngredient(@RequestBody CreationIngredientRequest newIngredientRequest){
        IngredientDTO ingredientDTO = ingredientService.createIngredient(mapper.map(newIngredientRequest));
        return mapper.map(ingredientDTO);
    }
}
