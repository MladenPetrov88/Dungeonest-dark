import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        List<String> rooms = new ArrayList<>();

        int health = 100;
        int coins = 0;
        int roomCount = 1;

        for (int i = 0; i < input.length; i++) {
            rooms.add(input[i]);
        }

        for (int i = 0; i < rooms.size(); i++) {
            String[] temp = rooms.get(i).split(" ");
            String firstCommand = temp[0];

            if (firstCommand.equals("potion")) {
                int bonus = Integer.parseInt(temp[1]);
                if (health + bonus < 100) {
                    System.out.printf("You healed for %d hp.%n", bonus);
                    health += bonus;
                } else {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                }
                System.out.printf("Current health: %d hp.%n", health);
                roomCount++;
            }

            if (firstCommand.equals("chest")) {
                System.out.printf("You found %d coins.%n", Integer.parseInt(temp[1]));
                coins+= Integer.parseInt(temp[1]);
                roomCount++;
            }

            if (!firstCommand.equals("chest") && !firstCommand.equals("potion")) {
                health -= Integer.parseInt(temp[1]);
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", firstCommand);
                    roomCount++;
                } else {
                    System.out.printf("You died! Killed by %s.%n", firstCommand);
                    System.out.printf("Best room: %d",roomCount);
                    break;
                }
            }

        }

        if (health > 0) {
            System.out.printf("You've made it!%nCoins: %d%nHealth: %d", coins,health);
        }

    }
}
