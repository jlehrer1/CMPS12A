import java.util.Scanner;

class Cost {
    public static void main(String[] args) {
        double carMPG;
        double distanceDriven;
        double gasPrice;
        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter the number of miles being driven (as a double): ");
        distanceDriven = scn.nextDouble();
//        System.out.println("Enter the fuel efficiency of the vehicle (as a double): ");
        carMPG = scn.nextDouble();
//        System.out.println("Enter the cost of gasoline (as a double): ");
        gasPrice = scn.nextDouble();

        double totalGasCost = (distanceDriven / carMPG) * gasPrice;
        System.out.printf("%.2f", totalGasCost);
    }
}
