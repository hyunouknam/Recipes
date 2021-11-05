package recipes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.Model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    Recipe currentRecipe;
    List<Recipe> recipeList = new ArrayList<>();
    int counter = 0;

    @PostMapping(path = "/api/recipe/new")
    public Map postRecipe(@RequestBody Recipe recipe){
        counter++;
        currentRecipe = recipe;
        recipeList.add(recipe);
        return Map.of("id", counter);
    }

    @GetMapping(path = "/api/recipe")
    public Recipe getRecipe(){
        return currentRecipe;
    }


}
