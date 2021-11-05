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
    public ResponseEntity postRecipe(@RequestBody Recipe recipe){
        return new ResponseEntity<>(Map.of("id", recipeService.addRecipe(recipe)), HttpStatus.OK);
    }

    @GetMapping(path = "/api/recipe/{id}")
    public ResponseEntity getRecipe(@PathVariable int id){
        if(recipeService.getRecipe(id).isPresent()){
            return new ResponseEntity<>(recipeService.getRecipe(id).get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/api/recipe/{id}")
    public ResponseEntity deleteRecipe(@PathVariable int id) {
        if(recipeService.deleteRecipe(id) == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
