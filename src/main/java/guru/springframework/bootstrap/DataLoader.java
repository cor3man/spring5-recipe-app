package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(String... args) throws Exception
    {
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("The BEST guacamole! So easy to make with ripe avocados, salt, serrano chiles, cilantro and lime. Garnish with red radishes or jicama. Serve with tortilla chips. Watch how to make guacamole - it's easy!");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(20);
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setSource("Simplyrecipes");
        guacamoleRecipe.setUrl("www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n"
                + "\n" + "\n" + "\n"
                + "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n"
                + "\n" + "\n" + "\n"
                + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
                + "\n"
                + "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n"
                + "\n"
                + "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n"
                + "\n"
                + "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n"
                + "\n"
                + "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"
                + "\n" + "Variations\n" + "\n"
                + "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n"
                + "\n"
                + "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n"
                + "\n"
                + "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n"
                + "\n"
                + "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n"
                + "\n" + "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");


        Ingredient avocado = new Ingredient();
        avocado.setDescription("avocado");
        avocado.setAmount(BigDecimal.valueOf(2));
        avocado.setUom(unitOfMeasureRepository.findByDescription("Ripe").get());
        guacamoleRecipe.getIngredients().add(avocado);
        avocado.setRecipe(guacamoleRecipe);

        Ingredient kosherSalt = new Ingredient();
        kosherSalt.setDescription("Kosher salt");
        kosherSalt.setAmount(BigDecimal.valueOf(0.5));
        kosherSalt.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        guacamoleRecipe.getIngredients().add(kosherSalt);
        kosherSalt.setRecipe(guacamoleRecipe);

        Ingredient lemonJuice = new Ingredient();
        lemonJuice.setDescription("Fresh lime juice or lemon juice");
        lemonJuice.setAmount(BigDecimal.valueOf(1));
        lemonJuice.setUom(unitOfMeasureRepository.findByDescription("Tbsp").get());
        guacamoleRecipe.getIngredients().add(lemonJuice);
        lemonJuice.setRecipe(guacamoleRecipe);

        Ingredient slicedGreenOnion = new Ingredient();
        slicedGreenOnion.setDescription("Minced red onion or thinly sliced green onion");
        slicedGreenOnion.setAmount(BigDecimal.valueOf(2));
        slicedGreenOnion.setUom(unitOfMeasureRepository.findByDescription("Tbsp").get());
        guacamoleRecipe.getIngredients().add(slicedGreenOnion);
        slicedGreenOnion.setRecipe(guacamoleRecipe);

        Ingredient serranoChiles = new Ingredient();
        serranoChiles.setDescription("Serrano chiles, stems and seeds removed, minced");
        serranoChiles.setAmount(BigDecimal.valueOf(2));
        serranoChiles.setUom(unitOfMeasureRepository.findByDescription("One").get());
        guacamoleRecipe.getIngredients().add(serranoChiles);
        serranoChiles.setRecipe(guacamoleRecipe);

        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("Cilantro (leaves and tender stems), finely chopped");
        cilantro.setAmount(BigDecimal.valueOf(2));
        cilantro.setUom(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        guacamoleRecipe.getIngredients().add(cilantro);
        cilantro.setRecipe(guacamoleRecipe);

        Ingredient blackPepper = new Ingredient();
        blackPepper.setDescription("Freshly grated black pepper");
        blackPepper.setAmount(BigDecimal.valueOf(1));
        blackPepper.setUom(unitOfMeasureRepository.findByDescription("Dash").get());
        guacamoleRecipe.getIngredients().add(blackPepper);
        blackPepper.setRecipe(guacamoleRecipe);

        Ingredient tomato = new Ingredient();
        tomato.setDescription("Tomato, seeds and pulp removed, chopped");
        tomato.setAmount(BigDecimal.valueOf(0.5));
        tomato.setUom(unitOfMeasureRepository.findByDescription("Ripe").get());
        guacamoleRecipe.getIngredients().add(tomato);
        tomato.setRecipe(guacamoleRecipe);

        guacamoleRecipe.setDifficulty(Difficulty.EASY);

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("GUACAMOLE TIP: USE RIPE AVOCADOS\n"
                + "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n"
                + "\n"
                + "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");

        guacamoleNotes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacamoleNotes);

        Category mexicanCategory = categoryRepository.findByDescription("Mexican").get();
        guacamoleRecipe.getCategories().add(mexicanCategory);
        //mexicanCategory.getRecipes().add(guacamoleRecipe);
        recipeRepository.save(guacamoleRecipe);


    }
}