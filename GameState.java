
// // MEMENTO
// class GameState {
//     private int level;
//     private int position;
//     private int health;
//     private int score;

//     public GameState(int level, int position, int health, int score) {
//         this.level = level;
//         this.position = position;
//         this.health = health;
//         this.score = score;
//     }

//     public int getLevel() { return level; }
//     public int getPosition() { return position; }
//     public int getHealth() { return health; }
//     public int getScore() { return score; }
// }

import java.util.*;

class GameState {
    private final int level;
    private final int position;
    private final int health;
    private final int score;
    private final List<Opponent> opponents;

    public GameState(int level, int position, int health, int score, List<Opponent> opponents) {
        this.level = level;
        this.position = position;
        this.health = health;
        this.score = score;

        this.opponents = new ArrayList<>();
        for (Opponent o : opponents) {
            this.opponents.add(new Opponent(o));
        }
    }

    public int getLevel() { return level; }
    public int getPosition() { return position; }
    public int getHealth() { return health; }
    public int getScore() { return score; }
    public List<Opponent> getOpponents() { return opponents; }
}