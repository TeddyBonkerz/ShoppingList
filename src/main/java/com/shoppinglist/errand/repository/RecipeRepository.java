package com.shoppinglist.errand.repository;

import com.shoppinglist.errand.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    @Override
    Optional<Recipe> findById(String id);
}
