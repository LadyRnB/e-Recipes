package com.kuechelib.erecipes.ingredients.controller;


public record IngredientResponse(long ingredientId, String name, String attribute, MeasurementUnit unit) {}
