package guru.springframework.controllers;

import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.impl.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;


    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage()
    {
        assertTrue("index".equals(indexController.getIndexPage(model)));
        verify(model, times(1)).addAttribute(eq("recipies"), anySet());
        verify(recipeService, times(1)).getAllRecipies();
    }
}