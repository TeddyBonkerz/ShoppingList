package com.shoppinglist.errand.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoppinglist.errand.Model.Ingredient;
import com.shoppinglist.errand.Model.Recipe;
import com.shoppinglist.errand.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/{recipeId}")
    public Recipe getRecipe(@PathVariable("recipeId") String id) {
        Optional<Recipe> optionalRecipe = recipeService.getRecipe(id);
        if (optionalRecipe.isEmpty()) {
            throw new IllegalStateException("Recipe with id does not exist");
        }
        return optionalRecipe.get();
    }

    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @DeleteMapping(path = "/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") String id) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping(path = "/{recipeId}")
    public Recipe updateRecipe(@PathVariable("recipeId") String id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @PutMapping(path = "/ingredients/{recipeId}")
    public Recipe updateRecipeIngredients(@PathVariable("recipeId") String id,
                                          @RequestBody List<Ingredient> ingredients) throws JsonProcessingException {
        return recipeService.updateRecipeIngredients(id, ingredients);
    }
}
