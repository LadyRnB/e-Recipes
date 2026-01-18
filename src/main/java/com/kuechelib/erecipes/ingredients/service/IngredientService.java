package com.kuechelib.erecipes.ingredients.service;

import com.kuechelib.erecipes.ingredients.repository.IngredientEntity;
import com.kuechelib.erecipes.ingredients.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private final IngredientEntityMapper mapper = new IngredientEntityMapper();

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientDTO createIngredient(IngredientDTO newIngredientDTO){
        IngredientEntity ingredientEntity = ingredientRepository.save(mapper.map(newIngredientDTO));
        return mapper.map(ingredientEntity);
    }


}
