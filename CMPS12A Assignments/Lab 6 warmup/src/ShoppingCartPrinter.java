import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class ShoppingCartPrinter {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        String name1, name2;
        int price1, price2;
        int quant1, quant2;

        int totalCost = 0;
        System.out.println("Item 1");
        System.out.println("Enter the item name:");
        name1 = scnr.nextLine();
        System.out.println("Enter the item price:");
        price1 = scnr.nextInt();
        System.out.println("Enter the item quantity:");
        quant1 = scnr.nextInt();
        totalCost += price1 * quant1;

        System.out.println();
        scnr.nextLine();

        System.out.println("Item 2");
        System.out.println("Enter the item name:");
        name2 = scnr.nextLine();
        System.out.println("Enter the item price:");
        price2 = scnr.nextInt();
        System.out.println("Enter the item quantity:");
        quant2 = scnr.nextInt();
        totalCost += price2 * quant2;

        System.out.println();
        System.out.println("TOTAL COST");
        System.out.println(name1 + " " + quant1 + " @ $" + price1 + " = $" + quant1 * price1);
        System.out.println(name2 + " " + quant2 + " @ $" + price2 + " = $" + quant2 * price2);
        System.out.println();
        System.out.println("Total: $" + totalCost);

    }
}
