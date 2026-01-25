package com.kuechelib.erecipes.ingredients.controller;

import com.kuechelib.erecipes.ingredients.service.IngredientDTO;
import com.kuechelib.erecipes.ingredients.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientDtoMapper mapper = new IngredientDtoMapper();

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public IngredientResponse createIngredient(@RequestBody CreationIngredientRequest newIngredientRequest){
        IngredientDTO ingredientDTO = ingredientService.createIngredient(mapper.mapRequestToDto(newIngredientRequest));
        return mapper.mapDtoToResponse(ingredientDTO);
    }

    @GetMapping("{ingredientId}")
    public IngredientResponse getIngredientById(@PathVariable Long ingredientId){
        return ingredientService.findIngredientById(ingredientId)
                .map(ingredientDTO -> mapper.mapDtoToResponse(ingredientDTO))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));

    }

    @GetMapping
    public


    @DeleteMapping("{ingredientId}")
    public void deleteIngredientById(@PathVariable Long ingredientId){
        ingredientService.deleteIngredientById(ingredientId);
    }

    @PutMapping ("{ingredientId}")
    public IngredientResponse updateIngredient(@PathVariable Long ingredientId, @RequestBody CreationIngredientRequest ingredientRequest) {
        Optional<IngredientDTO> optionalIngredientDTO = ingredientService.updateIngredient(
                mapper.mapRequestAndIdToDto(ingredientRequest, ingredientId));
        if (optionalIngredientDTO.isPresent()) {
            return mapper.mapDtoToResponse(optionalIngredientDTO.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient does not exist");
        }
    }
//    Or other way:
//    @PutMapping ("{ingredientId}")
//    public IngredientResponse updateIngredient(@PathVariable Long ingredientId, @RequestBody CreationIngredientRequest ingredientRequest){
//        IngredientDTO ingredientDTO = mapper.mapRequestAndIdToDto(ingredientRequest, ingredientId);
//        return mapper.mapDtoToResponse(
//                ingredientService.updateIngredient(ingredientDTO)
//                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient does not exist"))
//        );
//    }

    @PatchMapping ("{ingredientId}")
    public IngredientResponse partiallyUpdateIngredient(@PathVariable Long ingredientId, @RequestBody CreationIngredientRequest ingredientRequest){
        return ingredientService.partiallyUpdateIngredient(mapper.mapRequestAndIdToDto(ingredientRequest, ingredientId))
                .map(ingredientDTO -> mapper.mapDtoToResponse(ingredientDTO))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient does not exist"));
    }
//    Or other way:
//    @PatchMapping("{ingredientId}")
//    public IngredientResponse partiallyUpdateIngredient(@PathVariable Long ingredientId, CreationIngredientRequest ingredientRequest) {
//        Optional<IngredientDTO> optionalIngredientDTO = ingredientService.partiallyUpdateIngredient(mapper.mapRequestAndIdToDto(ingredientRequest, ingredientId));
//        if (optionalIngredientDTO.isPresent()) {
//            return mapper.mapDtoToResponse(optionalIngredientDTO.get());
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient does not exist");
//        }
//    }

}
