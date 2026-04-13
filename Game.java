
// ORIGINATOR
public class Game {
    private int level = 1;
    private int position = 0;
    private int health = 100;
    private int score = 0;

    public void play() {
        position += 10;
        score += 5;
        System.out.println("Mario moved forward!");

        if (position >= 50) {
            levelUp();
        }
    }

    public void takeDamage() {
        health -= 20;
        System.out.println("Mario took damage!");

        if (health <= 0) {
            System.out.println("Mario died!");
        }
    }

    private void levelUp() {
        if (level < 3) {
            level++;
            position = 0;
            System.out.println("Level Up! Now Level " + level);
        } else {
            System.out.println("Game Completed!");
        }
    }

    // SAVE STATE
    public GameState save() {
        System.out.println("Game Saved!");
        return new GameState(level, position, health, score);
    }

    // RESTORE STATE
    public void restore(GameState state) {
        this.level = state.getLevel();
        this.position = state.getPosition();
        this.health = state.getHealth();
        this.score = state.getScore();
        System.out.println("Game Restored!");
    }

    public void showStatus() {
        System.out.println("Level: " + level +
                " | Position: " + position +
                " | Health: " + health +
                " | Score: " + score);
    }
}
