package com.cmpshomework;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int arrowBaseHeight;
        int arrowBaseWidth;
        int arrowHeadWidth;

        System.out.println("Enter arrow base height:");
        arrowBaseHeight = scnr.nextInt();

        System.out.println("Enter arrow base width:");
        arrowBaseWidth = scnr.nextInt();

        System.out.println("Enter arrow head width:");
        arrowHeadWidth = scnr.nextInt();

        while (arrowHeadWidth <= arrowBaseWidth) {
            System.out.println("Enter arrow head width:");
            arrowHeadWidth = scnr.nextInt();
        }
        for (int i = 0; i < arrowBaseHeight; i++) {
            for (int k = 0; k < arrowBaseWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = arrowHeadWidth; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
