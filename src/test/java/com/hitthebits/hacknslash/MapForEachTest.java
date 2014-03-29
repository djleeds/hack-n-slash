package com.hitthebits.hacknslash;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapForEachTest {
    private static final String EXPECTED = "deep_web9 has a score of 20\n" +
            "Sir-Fragsalot has a score of 60\n" +
            "general_f@1lur3 has a score of 40\n" +
            "CaptainOpcode has a score of 100\n" +
            "lambda_@rity has a score of 80\n";
    private Map<String, Integer> scores;

    @Before
    public void setup() {
        scores = Factory.createScores();
    }

    @Test
    public void java7Approach() {
        final StringBuilder rendered = new StringBuilder();

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            rendered.append(String.format("%s has a score of %d\n", entry.getKey(), entry.getValue()));
        }

        assertEquals(EXPECTED, rendered.toString());
    }

    @Test
    public void java8Approach() {
        final StringBuilder rendered = new StringBuilder();

        scores.forEach((name, score) -> {
            rendered.append(String.format("%s has a score of %d\n", name, score));
        });

        assertEquals(EXPECTED, rendered.toString());
    }
}