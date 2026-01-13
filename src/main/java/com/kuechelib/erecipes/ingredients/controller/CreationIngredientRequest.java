package com.kuechelib.erecipes.ingredients.controller;

public record CreationIngredientRequest(
        String name, String attribute, MeasurementUnit unit) {}
