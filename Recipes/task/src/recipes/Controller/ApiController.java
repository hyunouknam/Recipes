package recipes.Controller;

import org.springframework.web.bind.annotation.*;
import recipes.Model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    List<Recipe> recipeList = new ArrayList<>();
    int counter = 0;

    @PostMapping(path = "/api/recipe/new")
    public Map postRecipe(@RequestBody Recipe recipe){
        counter++;
        recipe.setId(String.valueOf(counter));
        recipeList.add(recipe);
        return Map.of("id", recipe.getId());
    }

    @GetMapping(path = "/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id){
        return recipeList.get(id - 1);
    }


}
