package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    Feline feline;

    private Lion lion;

    private final boolean hasManeExpectedResult;
    private final String sex;

    public LionParameterizedTest(String sex, boolean hasManeExpectedResult) {
        this.sex = sex;
        this.hasManeExpectedResult = hasManeExpectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] parameters () {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        boolean actualResult = lion.doesHaveMane();
        assertEquals(hasManeExpectedResult, actualResult);
    }

}