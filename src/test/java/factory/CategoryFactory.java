package factory;

import com.github.javafaker.Faker;
import models.Category;

public class CategoryFactory {
    private static Faker faker = new Faker();
    public static Category generateCategoryWithId(int id){
        Category generated = new Category();
        generated.setId(id);
        generated.setName(faker.name().username());
        return generated;
    }
}
