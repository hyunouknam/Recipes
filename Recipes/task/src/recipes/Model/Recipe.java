package recipes.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Recipe {
    String name;
    String description;
    String ingredients;
    String directions;
}
