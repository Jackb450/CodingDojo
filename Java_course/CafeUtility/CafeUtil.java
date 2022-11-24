import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        System.out.println("----------------");
        System.out.println("1. Streak Goal");
        int GetStreakGoal = 0;
        for (int i = 0; i <= 10; i++) {
            GetStreakGoal = GetStreakGoal + i;
        }
        System.out.println("Streak: " + GetStreakGoal);
        System.out.println("----------------");
        System.out.println("2. Price Total");
        double GetOrderTotal = 0;
        double[] prices = {1.99, 2.55, .79, 3.49, 3.99};
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Item " + (i + 1) + ": $" + prices[i]);
            GetOrderTotal = GetOrderTotal + prices[i];
        }
        System.out.println("Total: $" + GetOrderTotal);
        System.out.println("----------------");
        System.out.println("3. Menu Display");
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("Drip Coffee");
        menuItems.add("Cappuccino");
        menuItems.add("Latte");
        menuItems.add("Mocha");
        System.out.println(menuItems);
        System.out.println("----------------");
        System.out.println("4. Add Customer");
        ArrayList<String> Customer = new ArrayList<String>();
        Customer.add("Miz");
        Customer.add("Ian");
        Customer.add("Paddy");
        Customer.add("Ronaldo");
        System.out.println("Please enter your name: " + String userName = System.console().readLine());
        System.out.println("Hello, " + userName);
        System.out.println("There are " + Customer.size() + " people in front of you");
        Customer.add(userName);
        System.out.println("Customer list: " + Customer);
        System.out.println("----------------");
    }
}