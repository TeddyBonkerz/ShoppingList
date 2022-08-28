package com.shoppinglist.errand.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Recipe object")
public class Recipe {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Schema(description = "Unique identifier for a Recipe")
    private String id;

    @Schema(description = "Name of a recipe")
    @JsonProperty(required=true)
    private String name;

    @Schema(description = "Description of recipe")
    private String description;

    @Schema(description = "Ingredients used in the recipe")
    private String ingredients;

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
