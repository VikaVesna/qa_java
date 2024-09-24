package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class LionTest {

    @Mock
    Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testGetKittens() {
        int expectedResult = 1;
        when(feline.getKittens()).thenReturn(expectedResult);
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test (expected = Exception.class)
    public void testGetKittensThrowsException() throws Exception{
        lion = new Lion("Детеныш", feline);
    }


    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        when(feline.getFood("Хищник")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        lion.getFood();
    }

}