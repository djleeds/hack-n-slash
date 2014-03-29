package com.hitthebits.hacknslash;

public class Player {
    private final String name;
    private int health;

    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    public void increaseHealth(int amount) {
        health += amount;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public String toString() {
        return String.format("[%s: %d]", name, health);
    }
}
