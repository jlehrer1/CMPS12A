import java.util.Scanner;

class AuthoringAssistant {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a sample text:");
        String sampleText = scnr.nextLine();
        System.out.println();
        System.out.println("You entered: " + sampleText);
        System.out.println();
        String input = printMenu(scnr);
        while (!input.equals("q")) {
            if (input.equals("c")) {
                int numNonWs = getNumOfNonWSCharacters(sampleText);
                System.out.println("Number of non-whitespace characters: " + numNonWs + "\n");
            }
            if (input.equals("w")) {
                int numWords = getNumOfWords(sampleText);
                System.out.println("Number of words: " + numWords);
                System.out.println();
            }
            if (input.equals("f")) {
                System.out.println("Enter a word or phrase to be found:");
                String wordToFind = scnr.nextLine();
                System.out.println("\"" + wordToFind + "\"" + " instances: " + findText(wordToFind, sampleText));
                System.out.println();
            }
            if (input.equals("r")) {
                System.out.println("Edited text: " + replaceExclamation(sampleText));
                System.out.println();
            }
            if (input.equals("s")) {
                System.out.println("Edited text: " + shortenSpace(sampleText));
                System.out.println();
            }
            input = printMenu(scnr);
        }
    }
    public static String printMenu(Scanner scnr) {
        System.out.println("MENU\n" +
                "c - Number of non-whitespace characters\n" +
                "w - Number of words\n" +
                "f - Find text\n" +
                "r - Replace all !'s\n" +
                "s - Shorten spaces\n" +
                "q - Quit\n" +
                "\n" +
                "Choose an option:");
        return scnr.nextLine();
    }
    public static int getNumOfNonWSCharacters(String text) {
        int num = 0;
        char[] textToChar = text.toCharArray();
        for (char aTextToChar : textToChar) {
            if (aTextToChar != ' ') {
                num++;
            }
        }
        return num;
    }

    public static int getNumOfWords(String input) {
        String trimmedText = input.trim();
        return trimmedText.isEmpty() ? 0 : trimmedText.split("\\s+").length;
    }
    public static int findText(String toFind, String input) {
        return input.split(toFind, -1).length - 1;
    }

    public static String replaceExclamation(String input) {
        return input.replaceAll("!", ".");
    }

    public static String shortenSpace(String input) {
        return input.replaceAll(" +", " ");
    }
}
