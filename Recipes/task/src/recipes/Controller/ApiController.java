package recipes.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.Model.Recipe;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    Map<Integer, Recipe> recipeMap = new HashMap<>();
    int counter = 0;

    @PostMapping(path = "/api/recipe/new")
    public Map postRecipe(@RequestBody Recipe recipe){
        counter++;
        recipe.setId(counter);
        recipeMap.put(counter, recipe);
        return Map.of("id", counter);
    }

    @GetMapping(path = "/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id){
        if(recipeMap.containsKey(id)) {
            return recipeMap.get(id);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }


}
