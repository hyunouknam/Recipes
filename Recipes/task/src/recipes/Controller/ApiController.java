package recipes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.Model.Recipe;

@RestController
public class ApiController {

    Recipe currentRecipe;

    @PostMapping(path = "/api/recipe")
    public void postRecipe(@RequestBody Recipe recipe){
        currentRecipe = new Recipe(recipe.getName(), recipe.getDescription(), recipe.getIngredients(), recipe.getDirections());
    }

    @GetMapping(path = "/api/recipe")
    public Recipe getRecipe(){
        return currentRecipe;
    }


}
