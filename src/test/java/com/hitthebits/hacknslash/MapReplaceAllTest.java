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
            if (entry.getValue() < 50) {
                entry.setValue(entry.getValue() + 50);
            }
        }
        assertAllScoresAreGreaterThanOrEqualTo50();
    }

    @Test
    public void java8Approach() {
        scores.replaceAll((name, score) -> score < 50 ? score + 50 : score);
        assertAllScoresAreGreaterThanOrEqualTo50();
    }

    private void assertAllScoresAreGreaterThanOrEqualTo50() {
        for (int score : scores.values()) {
            assertTrue(score >= 50);
        }
    }
}
