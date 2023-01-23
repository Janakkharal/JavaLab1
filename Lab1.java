import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        String restroName = "Brampton Hamburgers";
        System.out.println(String.format("%34s", restroName));

        String[][] table = {
                {"1.", "Veggie Burger", "\t\t$5.95"},
                {"2.", "Deluxe Veggie Burger", "$7.95"},
                {"3.", "Chicken Burger", "\t\t$6.45"},
                {"4.", "Cheese Chicken Burger", "$8.50"},
                {"5.", "Cheese Bacon Burger", "\t$9.25"},
                {"6.", "Deluxe Bacon Burger", "\t$10.95"},
                {"7.", "Healthy Organic Burger", "$12.45"},
                {"8.", "Quit", ""}
        };

        System.out.println("\t\tType of Burger\t\t\t\tPrice");
        for (String[] row : table) {
            for (String item : row) {
                System.out.print(item + "\t\t");
            }
            System.out.println();
        }
        double totalBillingAmount = 0.0;
        int customer = 0;
        while(customer < 5){
            System.out.print("Please select an item from the menu (1-8): ");
            int selection = scanner.nextInt();
            if (selection >= 1 && selection <= 7) {
                customer = customer + 1;
                System.out.println("You have selected: " + table[selection-1][1] + " for " + table[selection-1][2]);
                System.out.print("Please enter the quantity: ");
                int quantity = scanner.nextInt();
                double itemPrice = Double.parseDouble(table[selection-1][2].replace("$", ""));
                double totalPrice = itemPrice * quantity;
                double tax = (totalPrice*13)/100;
                double totalAmount = totalPrice+tax;
                if (totalAmount > 100) {
                    double discount = totalAmount * 0.10;
                    totalAmount = totalAmount - discount;
                    System.out.println("Total price for " + quantity + " " + table[selection-1][1] + "(s) is $" + df.format(totalAmount) + " including tax of $" + df.format(tax) + " and a 10% discount of $" + df.format(discount));
                }else if (totalAmount > 50) {
                    double discount = totalAmount * 0.05;
                    totalAmount = totalAmount - discount;
                    System.out.println("Total price for " + quantity + " " + table[selection-1][1] + "(s) is $" + df.format(totalAmount) + " including tax of $" + df.format(tax) + " and a 5% discount of $" + df.format(discount));
                }else{
                    System.out.println("Total price for " + quantity + " " + table[selection-1][1] + "(s) is $" + df.format(totalAmount) + " including tax of $" + df.format(tax));
                }
                totalBillingAmount += totalAmount;


            }else if (selection == 8) {
                break;
            } else {
                System.out.println("Invalid selection. Please choose a number between 1 and 8.");
            }
        }
        System.out.println("The total billing amount for all orders is $" + df.format(totalBillingAmount));
    }
}




