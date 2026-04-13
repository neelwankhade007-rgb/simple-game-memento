import java.util.*;

// MAIN CLASS
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        SaveManager manager = new SaveManager();

        while (true) {
            System.out.println("\n1.Play  2.Damage  3.Save  4.Load  5.Status  6.Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    game.play();
                    break;

                case 2:
                    game.takeDamage();
                    break;

                case 3:
                    manager.addSave(game.save());
                    break;

                case 4:
                    manager.listSaves();
                    System.out.print("Enter save index: ");
                    int idx = sc.nextInt();
                    GameState state = manager.getSave(idx);
                    if (state != null) {
                        game.restore(state);
                    }
                    break;

                case 5:
                    game.showStatus();
                    break;

                case 6:
                    System.out.println("Exiting Game");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}