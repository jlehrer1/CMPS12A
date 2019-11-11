import java.util.Scanner;
class Narges {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine();
        String narges = "narges";
        boolean doesContain = true;
        int index = 0;

        for (char character : narges.toCharArray()) {
            index = input.indexOf(character, index);
            if (index == -1)
                doesContain = false;
        }
        if (doesContain)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
