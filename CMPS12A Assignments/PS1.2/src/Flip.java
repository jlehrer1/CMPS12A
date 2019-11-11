import java.util.Scanner;

class Flip {
    public static void main(String[] args) {
        int num, reverse, lastDigit;
        Scanner scn = new Scanner(System.in);
        num = scn.nextInt();

        if(num < 10) {
            System.out.println(num * 100);
        } else {
            reverse = 0;
            while (num > 0) {
                lastDigit = num % 10;
                reverse = (reverse * 10) + lastDigit;
                num /= 10;
            }
            if (reverse < 10) {
                System.out.println(reverse * 100);
            } else if (reverse < 100) {
                System.out.println(reverse * 10);
            } else {
                System.out.println(reverse);
            }
        }
    }
}
