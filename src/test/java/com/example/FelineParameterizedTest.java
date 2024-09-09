package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private Feline feline;

    private final int getKittensParam;
    private final int getKittensExpectedResult;

    public FelineParameterizedTest (int getKittensParam, int getKittensExpectedResult) {
        this.getKittensParam = getKittensParam;
        this.getKittensExpectedResult = getKittensExpectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][] {
                {3, 3},
                {100, 100},
                {0, 0}
        };
    }

    @Test
    public void testGetKittensWithParam() {
        feline = new Feline();
        int actualResult = feline.getKittens(getKittensParam);
        assertEquals(getKittensExpectedResult, actualResult);
    }

}