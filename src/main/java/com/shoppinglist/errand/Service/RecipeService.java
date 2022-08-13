package com.shoppinglist.errand.Service;

import com.shoppinglist.errand.Model.Recipe;
import com.shoppinglist.errand.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }
    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }
}
