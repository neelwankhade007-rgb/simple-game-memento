import java.util.*;

// ORIGINATOR
public class Game {
    private int level = 1;
    private int position = 0;
    private int health = 150;
    private int score = 0;

    private List<Opponent> opponents;
    private Random random = new Random();

    private static final String[] TYPES = {"A", "B", "C", "D", "E"};

    public Game() {}

    public void play() {
        generateOpponents();;
    }

    // Generate 5 random opponents (can repeat)
    private void generateOpponents() {
        opponents = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String type = TYPES[random.nextInt(TYPES.length)];
            opponents.add(new Opponent(type));
        }

        System.out.println("Level " + level + " Opponents:");
        for (Opponent o : opponents) {
            System.out.println(o);
        }
    }

    // TURN SYSTEM
    public void playTurn() {
        System.out.println("\n--- PLAYER TURN ---");
        playerAttack();

        removeDeadOpponents();

        if (opponents.isEmpty()) {
            levelUp();
            System.out.println("\n--- YOU LEVELED UP! ---");
            return;
        }

        System.out.println("\n--- OPPONENT TURN ---");
        opponentsAttack();

        if (health <= 0) {
            health = 0;
            System.out.println("\n--- YOU LOSE ---");
        }
    }

    // Player attacks first opponent
    private void playerAttack() {
        if (opponents.isEmpty()) return;

        Opponent target = opponents.get(0);
        int damage = 20;

        // 5% crit chance
        if (random.nextDouble() < 0.1) {
            damage *= 2;
            System.out.println("CRITICAL HIT!");
        }

        System.out.println("Player attacks " + target.getType());
        target.takeDamage(damage);
    }

    // Opponents attack player
    private void opponentsAttack() {
        Opponent o = opponents.get(0);
        if (!o.isDead()) {
            int damage = o.attack();
            health -= damage;
            System.out.println(o.getType() + " hits you for " + damage + " damage");
        }
    }

    private void removeDeadOpponents() {
        Iterator<Opponent> it = opponents.iterator();

        while (it.hasNext()) {
            Opponent o = it.next();
            if (o.isDead()) {
                System.out.println(o.getType() + " defeated!");
                score += 20;
                it.remove();
            }
        }
    }

    private void levelUp() {
        if (level < 3) {
            level++;
            position = 0;
            System.out.println("\nLEVEL UP → " + level);
            health = 100;
            generateOpponents();
        } else {
            System.out.println("Game Completed!");
        }
    }

    // SAVE STATE
    public GameState save() {
        return new GameState(level, position, health, score, opponents);
    }

    // RESTORE STATE
    public void restore(GameState state) {
        this.level = state.getLevel();
        this.position = state.getPosition();
        this.health = state.getHealth();
        this.score = state.getScore();

        this.opponents = new ArrayList<>();
        for (Opponent o : state.getOpponents()) {
            this.opponents.add(new Opponent(o));
        }

        System.out.println("Game Restored!");
    }

    public void showStatus() {
        System.out.println("\nPlayer HP: " + health + " | Score: " + score + " | Level : " + level);
        System.out.println("Opponents:");
        for (Opponent o : opponents) {
            System.out.println(o);
        }
    }
}