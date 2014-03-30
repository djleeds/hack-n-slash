package com.hitthebits.hacknslash;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MapReplaceAllTest {
    private Map<String, Integer> scores;

    @Before
    public void setup() {
        scores = Factory.createScores();
    }

    @Test
    public void java7Approach() {
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() < 500) {
                entry.setValue(entry.getValue() + 500);
            }
        }
        assertAllScoresAreGreaterThanOrEqualTo500();
    }

    @Test
    public void java8Approach() {
        scores.replaceAll((name, score) -> score < 500 ? score + 500 : score);
        assertAllScoresAreGreaterThanOrEqualTo500();
    }

    private void assertAllScoresAreGreaterThanOrEqualTo500() {
        for (int score : scores.values()) {
            assertTrue(score >= 500);
        }
    }
}
