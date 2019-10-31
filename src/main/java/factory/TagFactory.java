package factory;

import com.github.javafaker.Faker;
import models.Tag;

public class TagFactory {
    private static Faker faker = new Faker();
    public static Tag generateTagWithId(int id){
        Tag generated = new Tag();
        generated.setId(id);
        generated.setName(faker.name().username());
        return generated;
    }
}
