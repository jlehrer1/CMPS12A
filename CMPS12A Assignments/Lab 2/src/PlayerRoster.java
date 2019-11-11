import java.util.Scanner;

class PlayerRoster {
    public static void main(String args[]) {
        int[] jerseyNumbers = new int[5];
        int[] ratingNumbers = new int[5];
        Scanner scnr = new Scanner(System.in);
        String message = "MENU\nu - Update player rating\na - Output players above a rating\n" +
                "r - Replace player\no - Output roster\nq - Quit\n\nChoose an option:";
        getInitialPlayerInfo(scnr, jerseyNumbers, ratingNumbers);
        System.out.println(message);
        String input = scnr.next();

        while (!input.equals("q")) {
            if (input.equals("o")) {
                printRoster(jerseyNumbers, ratingNumbers);
            }
            if (input.equals("u"))
                updatePlayerRating(scnr, jerseyNumbers, ratingNumbers);
            if (input.equals("a"))
                outputPlayersAboveRating(scnr, jerseyNumbers, ratingNumbers);
            if (input.equals("r"))
                replacePlayer(scnr, jerseyNumbers, ratingNumbers);
            System.out.println(message);
            input = scnr.next();
        }
    }

    public static void replacePlayer(Scanner scnr, int[] jerseyNumbers, int[] ratingNumbers) {
        System.out.println("Enter a jersey number:");
        int oldJersey = scnr.nextInt();
        for (int i = 0; i < jerseyNumbers.length; i++) {
            if (jerseyNumbers[i] == oldJersey) {
                System.out.println("Enter a new jersey number:");
                int newJersey = scnr.nextInt();
                System.out.println("Enter a rating for the new player:");
                int newRating = scnr.nextInt();
                System.out.println();
                jerseyNumbers[i] = newJersey;
                ratingNumbers[i] = newRating;
                oldJersey = 0;
            }
        }
        if (oldJersey != 0)
            System.out.println();
    }

    public static void outputPlayersAboveRating(Scanner scnr, int[] jerseyNumbers, int[] ratingNumbers) {
        System.out.println("Enter a rating:");
        int rating = scnr.nextInt();
        System.out.println();
        System.out.println("ABOVE " + rating);
        for (int i = 0; i < ratingNumbers.length; i++) {
            if (ratingNumbers[i] > rating) {
                System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNumbers[i] + ", Rating: " + ratingNumbers[i]);
            }
        }
        System.out.println();
    }

    public static void printRoster(int[] jerseyNumbers, int[] ratingNumbers) {
        System.out.println("ROSTER");
        for (int j = 0; j < jerseyNumbers.length; j++) {
            System.out.println("Player " + (j + 1) + " -- Jersey number: " + jerseyNumbers[j] + ", Rating: " + ratingNumbers[j]);
        }
        System.out.println();
    }

    public static void getInitialPlayerInfo(Scanner scnr, int[] jerseyNumbers, int[] ratingNumbers) {
        int i = 1;
        while (i <= 5) {
            System.out.println("Enter player " + i + "'s jersey number:");
            jerseyNumbers[i - 1] = scnr.nextInt();
            System.out.println("Enter player " + i + "'s rating:");
            if (i != 5)
                System.out.println();
            ratingNumbers[i - 1] = scnr.nextInt();
            i++;
        }
        System.out.println();
        printRoster(jerseyNumbers, ratingNumbers);
    }

    public static void updatePlayerRating(Scanner scnr, int[] jerseyNumbers, int[] ratingNumbers) {
        System.out.println("Enter a jersey number:");
        int jerseyToSearch = scnr.nextInt();
        System.out.println("Enter a new rating for the player:");
        int newRating = scnr.nextInt();
        for (int i = 0; i < jerseyNumbers.length; i++) {
            if (jerseyNumbers[i] == jerseyToSearch) {
                ratingNumbers[i] = newRating;
            }
        }
        System.out.println();
    }
}

