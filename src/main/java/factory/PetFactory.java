package factory;

import com.github.javafaker.Faker;
import models.Category;
import models.Pet;
import models.PetStatus;
import models.Tag;

import java.util.ArrayList;

public class PetFactory {

    private static Faker faker = new Faker();

    public static Pet generatePetWithId(int id){
        Tag tag = TagFactory.generateTagWithId(faker.number().numberBetween(0,99));
        Category category = CategoryFactory.generateCategoryWithId(faker.number().numberBetween(0,99));
        Pet generatedPet = new Pet();
        generatedPet.setId(id);
        generatedPet.setCategory(category);
        generatedPet.setName(faker.name().username());
        generatedPet.setPhotoUrls(new ArrayList<>());
        generatedPet.setTags(new ArrayList<Tag>() {{
            add(tag);
        }});
        generatedPet.setStatus(PetStatus.AVAILABLE);
        return generatedPet;
    }
}
