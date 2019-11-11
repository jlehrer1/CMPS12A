package com.cmpshomework;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    int hour, minute, amOrPm;
        Scanner scn = new Scanner(System.in);
	    hour = scn.nextInt();
	    minute = scn.nextInt();
	    amOrPm = scn.nextInt();

	    if ((hour >= 1 && hour < 12) && amOrPm == 2) {
	        if (minute < 10)
                System.out.println(hour + 12 + ":0" + minute);
	        else
                System.out.println(hour + 12 + ":" + minute);
        } else if ((hour >= 12) && (amOrPm == 1)) {
            hour -= 12;
            if (minute < 10)
                System.out.println("0" + hour + ":0" + minute);
            else
                System.out.println("0" + hour + ":" + minute);
        } else if (hour < 10) {
	        if (minute < 10)
                System.out.println("0" + hour + ":0" + minute);
	        else
                System.out.println("0" + hour + ":" + minute);
        } else {
	        if (minute < 10)
                System.out.println(hour + ":0" + minute);
            else
                System.out.println(hour + ":" + minute);
        }
    }
}
