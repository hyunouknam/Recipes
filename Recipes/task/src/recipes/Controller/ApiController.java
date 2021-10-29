package recipes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import recipes.Model.Recipe;

@Controller(value = "/api")
public class ApiController {

    @PostMapping(path = "/recipe")
    public void postRecipe(Recipe recipe){

    }

    @GetMapping(path = "/recipe")
    public Recipe getRecipe(){

    }
}
