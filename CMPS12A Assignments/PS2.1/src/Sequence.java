import java.util.Scanner;

class Sequence {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int first = scnr.nextInt();
        int second = scnr.nextInt();
        int third = scnr.nextInt();
        int listLength = scnr.nextInt();
        int[] list = new int[listLength];
        list[0] = first;
        list[1] = second;
        list[2] = third;
        int conditionOne = second - first;
        int conditionTwo = third - second;
        for (int i = 3; i < listLength; i += 2) {
            for (int k = 4; k < listLength; k += 2)
                list[k] = list[k - 1] + conditionTwo;
            list[i] = list[i - 1] + conditionOne;
        }
        for (int i = 4; i < listLength; i += 2) {
            list[i] = list[i - 1] + conditionTwo;
        }
        for (int items : list) {
            System.out.print(items + " ");
        }
    }
}
