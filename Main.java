import java.util.*;

// MAIN CLASS
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        SaveManager manager = new SaveManager();

        while (true) {
            System.out.println("\n1. Play   2. Load   3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            int flag = 0;

            switch (choice) {
                case 1:
                    game = new Game();
                    game.play();
                    while (true) {
                        System.out.println("\n1. Damage   2. Save   3. Status   4. Exit");
                        System.out.print("Choose: ");
                        int subchoice = sc.nextInt();
                        switch (subchoice) {
                            case 1:
                                boolean alive = game.playTurn();
                                if (!alive) {
                                    System.out.println("\n--- GAME OVER ---");
                                    System.out.println("Exiting Game...");
                                    flag = 1;
                                }
                                break;

                            case 2:
                                manager.addSave(game.save());
                                break;

                            case 3:
                                game.showStatus();
                                break;

                            case 4:
                                flag = 1;
                                break;

                            default:
                                System.out.println("Invalid choice");
                        }
                        if (flag == 1) {
                            flag = 0;
                            break;
                        }
                    }
                    break;

                case 2:
                    if (manager.listSaves()) {
                        System.out.print("Enter save index: ");
                        int idx = sc.nextInt();

                        GameState state = manager.getSave(idx);

                        if (state == null) {
                            System.out.println("\n--- INVALID SAVE INDEX ---");
                            break;
                        }

                        game.restore(state);

                        while (true) {
                            System.out.println("\n1. Damage   2. Save   3. Status   4. Exit");
                            System.out.print("Choose: ");
                            int subchoice = sc.nextInt();

                            switch (subchoice) {
                                case 1:
                                    boolean alive = game.playTurn();
                                    if (!alive) {
                                        System.out.println("\n--- GAME OVER ---");
                                        System.out.println("Exiting Game...");
                                        flag = 1;
                                    }
                                    break;

                                case 2:
                                    manager.addSave(game.save());
                                    break;

                                case 3:
                                    game.showStatus();
                                    break;

                                case 4:
                                    flag = 1;
                                    break;

                                default:
                                    System.out.println("Invalid choice");
                            }

                            if (flag == 1) {
                                flag = 0;
                                break;
                            }
                        }

                    } else {
                        System.out.println("\n--- NO SAVED GAMES FOUND ---");
                    }
                    break;

                case 3:
                    System.out.println("Exiting Game");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
