package recipes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.Model.Recipe;
import recipes.RecipeRepository;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    int counter = 0;

    public String addRecipe(Recipe recipe) {
        counter++;
        recipe.setId(String.valueOf(counter));
        recipeRepository.save(recipe);
        return String.valueOf(counter);
    }

    public Optional<Recipe> getRecipe(String id) {
        return recipeRepository.findById(id);
    }
}
