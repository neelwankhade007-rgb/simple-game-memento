import java.util.*;

// CARETAKER
public class SaveManager {
    private List<GameState> saves = new ArrayList<>();

    public void addSave(GameState state) {
        saves.add(state);
    }

    public GameState getSave(int index) {
        if (index >= 0 && index < saves.size()) {
            return saves.get(index);
        }
        System.out.println("Invalid Save Index");
        return null;
    }

    public void listSaves() {
        System.out.println("\nSaved Games:");
        for (int i = 0; i < saves.size(); i++) {
            GameState s = saves.get(i);
            System.out.println(i + " → Level " + s.getLevel()
                    + ", Pos " + s.getPosition()
                    + ", Health " + s.getHealth()
                    + ", Score " + s.getScore());
        }
    }
}