package com.recipe_mealplan.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.recipe_mealplan.service.GroceryListService;
import com.recipe_mealplan.service.MealPlanService;
import com.recipe_mealplan.Models.RecipeIngredientDTO;
import com.recipe_mealplan.entity.MealPlan;

import java.util.List;

@Controller
 // Ensure your base URL is set here
public class GroceryListController {

    @Autowired
    private GroceryListService groceryListService;

    @GetMapping("/recipes/List/{mealPlanId}")
    public String getGroceryList(@PathVariable Long mealPlanId, Model model) {
        // Print the mealPlanId for debugging
        System.out.println("Received mealPlanId: " + mealPlanId);
        
        // Fetch the grocery list based on the mealPlanId
        List<RecipeIngredientDTO> groceryList = groceryListService.getGroceryListForMealPlan(mealPlanId);
        
        // Add the grocery list to the model for the view
        model.addAttribute("groceryList", groceryList);
        
        // Return the "recipes/List" template
        return "recipes/List"; // This is the page that will display the grocery list
    }
    



}