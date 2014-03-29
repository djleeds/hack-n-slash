package com.hitthebits.hacknslash;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListRemoveIfTest {
    List<Player> players;

    @Before
    public void setup() {
        players = Factory.createPlayers();
        applySomeDamage();
    }

    private void applySomeDamage() {
        players.get(0).decreaseHealth(101);
        players.get(1).decreaseHealth(50);
        players.get(2).decreaseHealth(160);
        players.get(3).decreaseHealth(20);
        players.get(4).decreaseHealth(40);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void java7Approach_enhancedForLoop() {
        for (Player player : players) {
            if (player.isDead()) {
                players.remove(player);
            }
        }
    }

    @Test
    public void java7Approach_iterator() {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isDead()) {
                iterator.remove();
            }
        }
        assertEquals(3, players.size());
    }

    @Test
    public void java7Approach_reverseIndex() {
        for (int i = players.size() - 1; i >= 0; i--) {
            if (players.get(i).isDead()) {
                players.remove(i);
            }
        }
        assertEquals(3, players.size());
    }

    @Test
    public void java8Approach() {
        players.removeIf(p -> p.isDead());
        assertEquals(3, players.size());
    }
}
