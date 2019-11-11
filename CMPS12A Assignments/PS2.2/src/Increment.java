import java.util.Scanner;

class Increment {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int previousInt = scnr.nextInt();
        int nextInt = scnr.nextInt();
        double sum = Math.abs(nextInt - previousInt);
        double count = 1;
        if (previousInt > nextInt)
            System.out.println("0.00");
        else {
            while (nextInt >= previousInt) {
                previousInt = nextInt;
                nextInt = scnr.nextInt();
                if (nextInt >= previousInt) {
                    sum += Math.abs(nextInt - previousInt);
                    count++;
                }
            }
            String formatted = String.format("%.2f", (sum / count));
            System.out.println(formatted);
        }
    }
}
