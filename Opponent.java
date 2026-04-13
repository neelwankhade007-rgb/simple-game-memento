import java.util.*;

class Opponent {
    private String type;
    private int health;
    private int maxHealth;
    private int attackPower;
    private static Random random = new Random();

    public Opponent(String type) {
        this.type = type;

        switch (type) {
            case "A":
                maxHealth = 60;
                attackPower = 8;
                break;
            case "B":
                maxHealth = 80;
                attackPower = 6;
                break;
            case "C":
                maxHealth = 50;
                attackPower = 10;
                break;
            case "D":
                maxHealth = 100;
                attackPower = 5;
                break;
            case "E":
                maxHealth = 70;
                attackPower = 7;
                break;
        }

        this.health = maxHealth;
    }

    // Copy constructor (for Memento)
    public Opponent(Opponent o) {
        this.type = o.type;
        this.health = o.health;
        this.maxHealth = o.maxHealth;
        this.attackPower = o.attackPower;
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        System.out.println(type + " took " + dmg + " damage (HP: " + health + ")");
    }

    public int attack() {
        return attackPower + random.nextInt(3); // slight randomness
    }

    public boolean isDead() {
        return health <= 0;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return type + " (HP: " + health + "/" + maxHealth + ")";
    }
}