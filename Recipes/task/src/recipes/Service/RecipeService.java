package recipes.Service;

import org.springframework.stereotype.Service;
import recipes.Model.Recipe;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {

    Map<Integer, Recipe> recipeMap = new HashMap<>();
    int counter = 0;

    public int addRecipe(Recipe recipe) {
        counter++;
        recipe.setId(counter);
        recipeMap.put(counter, recipe);
        return counter;
    }

    public Recipe getRecipe(int id) {
        return recipeMap.get(id);
    }
}
