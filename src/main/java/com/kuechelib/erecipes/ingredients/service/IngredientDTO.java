package com.kuechelib.erecipes.ingredients.service;

import com.kuechelib.erecipes.ingredients.controller.MeasurementUnit;

public record IngredientDTO(Long id, String name, String attribute, MeasurementUnit unit) {}
