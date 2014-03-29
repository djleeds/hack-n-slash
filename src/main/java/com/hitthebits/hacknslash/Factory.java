package com.hitthebits.hacknslash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {
    private Factory() {
    }

    private static final String[] NAMES = {
            "CaptainOpcode",
            "lambda_@rity",
            "Sir-Fragsalot",
            "general_f@1lur3",
            "deep_web9"
    };

    public static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();

        for (String name : NAMES) {
            players.add(new Player(name));
        }

        return players;
    }

    public static Map<String, Integer> createScores() {
        Map<String, Integer> scores = new HashMap<>();
        int startingScore = 100;

        for (String name : NAMES) {
            scores.put(name, startingScore);
            startingScore -= 20;
        }

        return scores;
    }
}
