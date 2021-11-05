package recipes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.Model.Recipe;
import recipes.Service.RecipeService;

import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    RecipeService recipeService;

    @PostMapping(path = "/api/recipe/new")
    public ResponseEntity<Map> postRecipe(@RequestBody Recipe recipe){
        return new ResponseEntity<>(Map.of("id", recipeService.addRecipe(recipe)), HttpStatus.OK);
    }

    @GetMapping(path = "/api/recipe/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable String id){
        if(recipeService.getRecipe(id).isPresent()){
            return new ResponseEntity<>(recipeService.getRecipe(id).get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


}
