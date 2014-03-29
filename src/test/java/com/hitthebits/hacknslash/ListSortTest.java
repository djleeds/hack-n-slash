package com.hitthebits.hacknslash;

import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ListSortTest {
    List<Player> players;

    @Before
    public void setup() {
        players = Factory.createPlayers();
        applySomeDamage();
    }

    private void applySomeDamage() {
        int damage = 10 * players.size();

        for (Player player : players) {
            player.decreaseHealth(damage);
            damage -= 10;
        }
    }

    @Test
    public void java7Approach() {
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(final Player o1, final Player o2) {
                return Integer.signum(o2.getHealth() - o1.getHealth());
            }
        });
        assertDescendingSequence();
    }

    @Test
    public void java8Approach() {
        players.sort((o1, o2) -> Integer.signum(o2.getHealth() - o1.getHealth()));
        assertDescendingSequence();
    }

    private void assertDescendingSequence() {
        int lastAmount = players.get(0).getHealth();
        for (Player player : players) {
            assertTrue(player.getHealth() <= lastAmount);
            lastAmount = player.getHealth();
        }
    }
}
