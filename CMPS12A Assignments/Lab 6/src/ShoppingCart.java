public class ShoppingCart {
    private String customerName;
    private String currentDate;
    private ItemToPurchase itemsList[] = new ItemToPurchase[100000];
    private int numItems = 0;

    ShoppingCart() {
        customerName = "none";
        currentDate = "January 1, 2016";
    }
    ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
    }

    //GETTERS
    public String getCustomerName() {
        return customerName;
    }
    public String getDate() {
        return currentDate;
    }

    //Other methods
    public void addItem(ItemToPurchase item) {
        itemsList[numItems] = item;
        numItems++;
    }
    public void removeItem(String itemName) {
        boolean flag = false;
        for (int i = 0; i < itemsList.length; i++) {
            if (itemsList[i] != null) {
                if (itemsList[i].getName().equals(itemName)) {
                    itemsList[i] = null;
                    flag = true;
                    System.out.println();
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("Item not found in cart. Nothing removed.");
            System.out.println();
        }
    }
    public void modifyItem(ItemToPurchase toModify) {
        boolean flag = false;
        for (int i = 0; i < itemsList.length; i++) {
            if (itemsList[i] != null) {
                if (itemsList[i].getName().equals(toModify.getName())) {
                    itemsList[i].setQuantity(toModify.getQuantity());
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Item not found in cart. Nothing modified.");
            System.out.println();
        }

    }
    public int getNumItemsInCart() {
        int len = 0;
        for (int i = 0; i < itemsList.length; i++) {
            if (itemsList[i] != null) {
                len += itemsList[i].getQuantity();
            }
        }
        return len;
    }
    public int getCostOfCart() {
        int totalCost = 0;
        for (int i = 0; i < itemsList.length; i++) {
            if (itemsList[i] != null)
                totalCost += itemsList[i].getPrice() * itemsList[i].getQuantity();
        }
        return totalCost;
    }
    public void printTotal() {
        int total = 0;
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart());
        System.out.println();

        for (int i = 0; i < itemsList.length; i++) {
            if (itemsList[i] != null) {
                System.out.println(itemsList[i].getName() + " " + itemsList[i].getQuantity() + " @ $" +
                        itemsList[i].getPrice() + " = $" + itemsList[i].getPrice() * itemsList[i].getQuantity());
                total += itemsList[i].getPrice() * itemsList[i].getQuantity();
            }
        }
        System.out.println();
        System.out.println("Total: $" + total);
    }
    public void printDescriptions() {
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println();

        System.out.println("Item Descriptions");
        for (int i = 0; i < itemsList.length; i++) {
            if (itemsList[i] != null)
                System.out.println(itemsList[i].getName() + ": " + itemsList[i].getDescription());
        }
        System.out.println();
    }
}
