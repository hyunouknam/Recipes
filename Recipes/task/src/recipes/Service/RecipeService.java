package recipes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.Model.Recipe;
import recipes.RecipeRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public int addRecipe(Recipe recipe) {
        recipe.setDate(LocalDateTime.now());
        return recipeRepository.save(recipe).getId();
    }

    public void updateRecipe(Recipe recipe, int id) {
        recipe.setDate(LocalDateTime.now());
        recipe.setId(id);
        recipeRepository.save(recipe);
    }

    public Optional<Recipe> getRecipe(int id) {
        return recipeRepository.findById(id);
    }

    public int deleteRecipe(int id) {
        if(recipeRepository.existsById(id)) {
            recipeRepository.delete(recipeRepository.findById(id).get());
            return 0;
        }
        return -1;
    }
}
