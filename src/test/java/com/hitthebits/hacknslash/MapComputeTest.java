package com.hitthebits.hacknslash;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapComputeTest {
    private static final String PLAYER = "deep_web9";
    private static final int INITIAL_SCORE = 300;
    private static final int MULTIPLIER = 2;
    private static final int EXPECTED_SCORE = INITIAL_SCORE * MULTIPLIER;
    private Map<String, Integer> scores;

    @Before
    public void setup() {
        scores = Factory.createScores();
        scores.put(PLAYER, INITIAL_SCORE);
    }

    @Test
    public void java7Approach() {
        scores.put(PLAYER, scores.get(PLAYER) * MULTIPLIER);

        assertEquals((int)EXPECTED_SCORE, (int)scores.get(PLAYER));
    }

    @Test
    public void java8Approach() {
        scores.compute(PLAYER, (name, score) -> score * MULTIPLIER);

        assertEquals((int)EXPECTED_SCORE, (int)scores.get(PLAYER));
    }
}
