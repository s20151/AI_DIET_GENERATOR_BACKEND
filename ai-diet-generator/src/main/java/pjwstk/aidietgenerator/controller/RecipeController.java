package pjwstk.aidietgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pjwstk.aidietgenerator.entity.Ingredient;
import pjwstk.aidietgenerator.entity.Nutrition;
import pjwstk.aidietgenerator.entity.Recipe;
import pjwstk.aidietgenerator.repository.IngredientRepository;
import pjwstk.aidietgenerator.repository.NutritionRepository;
import pjwstk.aidietgenerator.repository.RecipeRepository;
import pjwstk.aidietgenerator.request.RecipeRequest;
import pjwstk.aidietgenerator.service.RecipeService;
import pjwstk.aidietgenerator.view.RecipeView;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;
    private final NutritionRepository nutritionRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository, NutritionRepository nutritionRepository, IngredientRepository ingredientRepository){
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
        this.nutritionRepository = nutritionRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/{id}")
    public RecipeView findRecipeById(@PathVariable(value = "id") long recipeId,  HttpServletResponse response){
        return recipeService.view(recipeId, response);
    }

    @PostMapping("/add")
    @Transactional
    public void addRecipe(@RequestBody RecipeRequest recipeRequest, HttpServletResponse response){
        recipeService.addRecipe(recipeRequest, response);
    }

}