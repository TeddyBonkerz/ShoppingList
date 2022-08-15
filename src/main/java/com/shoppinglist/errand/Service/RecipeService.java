package com.shoppinglist.errand.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppinglist.errand.Model.Ingredient;
import com.shoppinglist.errand.Model.Recipe;
import com.shoppinglist.errand.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> getRecipe(String id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(String id) {
       boolean exists =  recipeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Recipe does not exist");
        }
        recipeRepository.deleteById(id);
    }

    @Transactional
    public Recipe updateRecipe(String id, Recipe recipe) {
        Recipe oldRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Recipe does not exist"
                ));

        if(recipe.getName() != null && !Objects.equals(oldRecipe.getName(), recipe.getName())){
            oldRecipe.setName(recipe.getName());
        }
        if(recipe.getDescription() != null && !Objects.equals(oldRecipe.getDescription(), recipe.getDescription())){
            oldRecipe.setDescription(recipe.getDescription());
        }

        return oldRecipe;
    }

    @Transactional
    public Recipe updateRecipeIngredients(String id, List<Ingredient> ingredients) throws JsonProcessingException {
        Recipe oldRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Recipe does not exist"
                ));
        ObjectMapper mapIngredientsToJsonString = new ObjectMapper();
        String ingredientsString = mapIngredientsToJsonString.writeValueAsString(ingredients);
        oldRecipe.setIngredients(ingredientsString);

        return oldRecipe;
    }
}
