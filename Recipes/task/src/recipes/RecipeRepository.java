package recipes;

import org.springframework.data.repository.CrudRepository;
import recipes.Model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
