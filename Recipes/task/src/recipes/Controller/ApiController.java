package recipes.Controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.Model.Recipe;
import recipes.Service.RecipeService;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    RecipeService recipeService;

    @PostMapping(path = "/api/recipe/new")
    public ResponseEntity postRecipe(@Valid @RequestBody Recipe recipe) {
        return new ResponseEntity<>(Map.of("id", recipeService.addRecipe(recipe)), HttpStatus.OK);
    }

    @PutMapping(path = "/api/recipe/{id}")
    public ResponseEntity putRecipe(@Valid @RequestBody Recipe recipe, @PathVariable int id) {
        if(recipeService.getRecipe(id).isPresent()){
            recipeService.updateRecipe(recipe, id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/api/recipe/{id}")
    public ResponseEntity getRecipe(@PathVariable int id) {
        if(recipeService.getRecipe(id).isPresent()){
            return new ResponseEntity<>(recipeService.getRecipe(id).get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/api/recipe/search")
    public ResponseEntity searchRecipe(@RequestParam(required = false) String category, @RequestParam(required = false) String name) {
        if(StringUtils.isNotEmpty(category) && StringUtils.isEmpty(name)) {
            return new ResponseEntity<>(recipeService.searchCategory(category), HttpStatus.OK);
        } else if (StringUtils.isEmpty(category) && StringUtils.isNotEmpty(name)) {
            return new ResponseEntity<>(recipeService.searchContainingName(name), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping(path = "/api/recipe/{id}")
    public ResponseEntity deleteRecipe(@PathVariable int id) {
        if(recipeService.deleteRecipe(id) == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
