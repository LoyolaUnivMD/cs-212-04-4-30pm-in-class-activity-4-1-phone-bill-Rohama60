import java.text.DecimalFormat;
import java.util.Scanner;

public class phoneBill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter the package type
        System.out.println("Enter the package type (Green, Blue, or Purple): ");
        String packageType = input.nextLine();
        // Prompt the user to enter the data usage
        System.out.println("Enter the data used: ");
        double dataUsed = input.nextDouble();
        // Prompt the user to enter if they have a coupon or not
        System.out.println("Has a coupon? (true or false): ");
        boolean hasCoupon = input.nextBoolean();
//Calculate the final amount due by calling the calculateBill method with the package type, data used, and coupon as parameters
        double finalAmount = calculateBill(packageType, dataUsed, hasCoupon);
        System.out.println("The final amount due is: $" + finalAmount);
    }

    public static double calculateBill(String packageType, double dataUsed, boolean hasCoupon) {
        // Format the final amount to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");

        // Calculate the total cost based on the package type, data used, and coupon

        if (packageType.equalsIgnoreCase("Green")) {
            double baseCost = 49.99;
            double dataAllowance = 2;
            double additionalCost = 15;

            // Apply coupon and calculate final amount
            if (hasCoupon && ((baseCost + dataUsed * additionalCost) >= 75)) {
                return Double.parseDouble(df.format((baseCost + Math.max(0, dataUsed - dataAllowance) * additionalCost) - 20));
            } else {
                return Double.parseDouble(df.format(baseCost + Math.max(0, dataUsed - dataAllowance) * additionalCost));
            }
        } else if (packageType.equalsIgnoreCase("Blue")) {
            double baseCost = 70;
            double dataAllowance = 4;
            double additionalCost = 10;
            //Calculate final amount for Blue package
            return Double.parseDouble(df.format(baseCost + Math.max(0, dataUsed - dataAllowance) * additionalCost));
        } else if (packageType.equalsIgnoreCase("Purple")) {
            // Fixed cost for purple package
            return Double.parseDouble(df.format(99.95));
        } else {
            // For Invalid package
            return -1;
        }
    }
}