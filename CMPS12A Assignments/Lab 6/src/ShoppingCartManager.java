import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Customer's Name:");
        String name = scnr.nextLine();
        System.out.println("Enter Today's Date:");
        String date = scnr.nextLine();
        System.out.println();

        System.out.println("Customer Name: " + name);
        System.out.println("Today's Date: " + date);
        System.out.println();
        ShoppingCart person = new ShoppingCart(name, date);
        String main = printMenu(person, scnr);
    }
    public static String printMenu(ShoppingCart person, Scanner scnr) {
        System.out.println("MENU\n" +
                "a - Add item to cart\n" +
                "d - Remove item from cart\n" +
                "c - Change item quantity\n" +
                "i - Output items' descriptions\n" +
                "o - Output shopping cart\n" +
                "q - Quit\n" +
                "\n" +
                "Choose an option:");
        String input = scnr.next();
        while (!input.equals("q")) {
            if (input.equals("o")) {
                System.out.println("OUTPUT SHOPPING CART");
                if (person.getNumItemsInCart() == 0) {
                    System.out.println(person.getCustomerName() + "'s Shopping Cart - " + person.getDate());
                    System.out.println("Number of Items: 0");
                    System.out.println();
                    System.out.println("SHOPPING CART IS EMPTY");
                    System.out.println();
                    System.out.println("Total: $0");
                    System.out.println();
                } else {
                    person.printTotal();
                    System.out.println();
                }
            }
            if (input.equals("i")) {
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                person.printDescriptions();
            }
            if (input.equals("a")) {
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                scnr.nextLine();
                String itemName = scnr.nextLine();
                System.out.println("Enter the item description:");
                String itemDescription = scnr.nextLine();
                System.out.println("Enter the item price:");
                int itemPrice = scnr.nextInt();
                System.out.println("Enter the item quantity:");
                int itemQuantity = scnr.nextInt();
                System.out.println();
                ItemToPurchase itemToAdd = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
                person.addItem(itemToAdd);
            }
            if (input.equals("d")) {
                System.out.println("REMOVE ITEM FROM CART\n" +
                        "Enter name of item to remove:");
                scnr.nextLine();
                String nameToRemove = scnr.nextLine();
                person.removeItem(nameToRemove);
            }
            if (input.equals("c")) {
                System.out.println("CHANGE ITEM QUANTITY\n" +
                        "Enter the item name:");
                scnr.nextLine();
                String nameToModify = scnr.nextLine();
                System.out.println("Enter the new quantity:");
                int newQuantity = scnr.nextInt();
                ItemToPurchase temp = new ItemToPurchase();
                temp.setName(nameToModify);
                temp.setQuantity(newQuantity);
                person.modifyItem(temp);
            }
            while (!(input.equals("a") || input.equals("d") || input.equals("c") || input.equals("i") || input.equals("o") || input.equals("q"))) {
                System.out.println("Choose an option:");
                input = scnr.next();
            }
            if (!input.equals("q")) {
                System.out.println("MENU\n" +
                        "a - Add item to cart\n" +
                        "d - Remove item from cart\n" +
                        "c - Change item quantity\n" +
                        "i - Output items' descriptions\n" +
                        "o - Output shopping cart\n" +
                        "q - Quit\n" +
                        "\n" +
                        "Choose an option:");
                input = scnr.next();
            }
        }
        return input;
    }
}
