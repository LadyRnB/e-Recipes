package com.kuechelib.erecipes.ingredients.controller;

import com.kuechelib.erecipes.ingredients.service.IngredientDTO;
import com.kuechelib.erecipes.ingredients.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


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
    @GetMapping("{ingredientId}")
    public IngredientResponse getIngredientById(@PathVariable Long ingredientId){
        return ingredientService.findIngredientById(ingredientId)
                .map(ingredientDTO -> mapper.map(ingredientDTO))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));

    }

}
