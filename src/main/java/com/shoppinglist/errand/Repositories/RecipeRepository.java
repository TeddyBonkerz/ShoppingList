package com.shoppinglist.errand.Repositories;

import com.shoppinglist.errand.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, String>{
}
