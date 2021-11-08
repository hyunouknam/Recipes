package recipes;

import org.springframework.data.repository.CrudRepository;
import recipes.Model.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    public List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);
}
