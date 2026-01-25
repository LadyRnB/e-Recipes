package com.kuechelib.erecipes.ingredients.service;

import com.kuechelib.erecipes.ingredients.controller.CreationIngredientRequest;
import com.kuechelib.erecipes.ingredients.repository.IngredientEntity;
import com.kuechelib.erecipes.ingredients.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.util.ClassUtils.ifPresent;

@Service
public class IngredientService {
    private final IngredientEntityMapper mapper = new IngredientEntityMapper();

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientDTO createIngredient(IngredientDTO newIngredientDTO){
        IngredientEntity ingredientEntity = ingredientRepository.save(mapper.mapDtoToEntity(newIngredientDTO));
        return mapper.mapEntityToDto(ingredientEntity);
    }

    public Optional<IngredientDTO> findIngredientById(Long ingredientId){
        return ingredientRepository.findById(ingredientId)
                .map(ingredientEntity -> mapper.mapEntityToDto(ingredientEntity));
    }

    public void deleteIngredientById(Long ingredientId){
        ingredientRepository.deleteById(ingredientId);
    }

    public Optional<IngredientDTO> updateIngredient(IngredientDTO ingredientDTO){
        if(ingredientRepository.existsById(ingredientDTO.id())){
            return Optional.ofNullable(mapper.mapEntityToDto(ingredientRepository.save(mapper.mapDtoToEntity(ingredientDTO))));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<IngredientDTO> partiallyUpdateIngredient(IngredientDTO ingredientDTO) {
        return ingredientRepository.findById(ingredientDTO.id())
                .map(ingredientEntity -> updateIngEntityUsingIngDto(ingredientDTO, ingredientEntity))
                .map(ingredientEntity -> ingredientRepository.save(ingredientEntity))
                .map(ingredientEntity -> mapper.mapEntityToDto(ingredientEntity));
    }

    private IngredientEntity updateIngEntityUsingIngDto(IngredientDTO ingredientDTO, IngredientEntity ingredientEntity) {
        if(Objects.nonNull(ingredientDTO.id())){
            ingredientEntity.setId(ingredientDTO.id());
        }
        if (Objects.nonNull(ingredientDTO.name())){
            ingredientEntity.setName(ingredientDTO.name());
        }
        if(Objects.nonNull(ingredientDTO.attribute())){
            ingredientEntity.setAttribute(ingredientDTO.attribute());
        }
        if(Objects.nonNull(ingredientDTO.unit())){
            ingredientEntity.setUnit(ingredientDTO.unit());
        }
        return ingredientEntity;
    }
}
