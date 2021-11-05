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

    public int addRecipe(Recipe recipe) {
        counter++;
        recipe.setId(counter);
        recipeRepository.save(recipe);
        return counter;
    }

    public Optional<Recipe> getRecipe(int id) {
        return recipeRepository.findById(id);
    }
}
