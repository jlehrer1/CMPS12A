import java.util.Scanner;

public class Clock {
    private int hour;
    private int minute;

    public Clock() {
        hour = 0;
        minute = 0;
    }

    public Clock(int h) {
        hour = h;
        minute = 0;
    }

    public Clock(int h, int m) {
        hour = h;
        minute = m;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void incrementTimer() {
        if (minute == 59) {
            minute = 0;
            if (hour == 23) {
                hour = 0;
            } else {
                hour++;
            }
        } else {
            minute++;
        }
    }

    public void incrementTimer(int x) {
        for (int i = 0; i < x; i++) {
            incrementTimer();
        }
    }

    public void setTime(int h, int m) {
        if (m == 60 && h < 24) {
            minute = 0;
            hour = h;
        }
        if (m == 60 && h == 24) {
            minute = 0;
            hour = 0;
        }
        if (minute < 60 && h < 24) {
            minute = m;
            hour = h;
        } else {
            System.out.println("Invalid Input");
        }
    }

    public String toString() {
        String numhour0 = "";
        String numminute0 = "";
        String ampm = "PM";
        if ((hour == 0) && (minute == 0)) {
            return "12:00 AM";
        }
        if (hour < 12) {
            ampm = "AM";
        }
        if (hour > 12) {
            hour -= 12;
        }
        if (hour < 10) {
            numhour0 = "0";
        }
        if (minute < 10) {
            numminute0 = "0";
        }
        return numhour0 + hour + ":" + numminute0 + minute + " " + ampm;
    }
}
