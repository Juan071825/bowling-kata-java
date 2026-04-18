package edu.teamrocket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ScoreCardTest {

    @ParameterizedTest
    @CsvSource({
        "XXXXXXXXXXXX, 300",        
        "12345123451234512345, 60",
        "9-9-9-9-9-9-9-9-9-9-, 90",
        "9-3561368153258-7181, 82",
        "9-3/613/815/-/8-7/8-, 121",
        "X9-9-9-9-9-9-9-9-9-, 100",
        "X9-X9-9-9-9-9-9-9-, 110",
        "XX9-9-9-9-9-9-9-9-, 120",
        "XXX9-9-9-9-9-9-9-, 141",
        "9-3/613/815/-/8-7/8/8, 131",
        "5/5/5/5/5/5/5/5/5/5/5, 150",
        "9-9-9-9-9-9-9-9-9-XXX, 111",
        "8/549-XX5/53639/9/X, 149",
        "X5/X5/XX5/--5/X5/, 175",

    })
    void testScore(String input, int expected) {
        ScoreCard scoreCard = new ScoreCard(input);
        Character[][] frames = scoreCard.frameListCreator();
        int result = scoreCard.Score(frames);

        assertEquals(expected, result);
    }
}