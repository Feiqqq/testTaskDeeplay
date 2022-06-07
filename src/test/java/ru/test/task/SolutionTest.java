package ru.test.task;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {

    @Test
    public void testWhenMapCodeFromTask(){
        // when
        String mapCode = "STWSWTPPTPTTPWPP";
        String rasa = "Human";
        int expected = 10;
        // then
        int actual = Solution.getResult(mapCode,rasa);
        // should be
        assertEquals(expected,actual);
    }

    @Test
    public void testWhenMapCodeRandom(){
        // when
        String mapCode = "STWSWTPPT";
        String rasa = "Human";
        int expected = 9;
        // then
        int actual = Solution.getResult(mapCode,rasa);
        // should be
        assertEquals(expected,actual);
    }

    @Test
    public void testWhenMapCodeFromTaskAndRandomRasa(){
        // when
        String mapCode = "STWSWTPPTPTTPWPP";
        String rasa = "Swamper";
        int expected = 10;
        // then
        int actual = Solution.getResult(mapCode,rasa);
        // should be
        assertEquals(expected,actual);
    }
}
