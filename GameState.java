
// MEMENTO
class GameState {
    private int level;
    private int position;
    private int health;
    private int score;

    public GameState(int level, int position, int health, int score) {
        this.level = level;
        this.position = position;
        this.health = health;
        this.score = score;
    }

    public int getLevel() { return level; }
    public int getPosition() { return position; }
    public int getHealth() { return health; }
    public int getScore() { return score; }
}
