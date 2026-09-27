package lw02.prelab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // 1. Read file word-by-word into a LinkedList
        LinkedList<String[]> transactions = new LinkedList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        
        while (scanner.hasNext()) {
            String name = scanner.next();
            String type = scanner.next();
            String amount = scanner.next();
            transactions.add(new String[]{name, type, amount});
        }
        scanner.close();

        // 2. Create customer list with an initial balance of "0"
        LinkedList<String[]> customers = new LinkedList<>();
        for (String[] t : transactions) {
            boolean found = false;
            
            for (String[] c : customers) {
                if (c[0].equals(t[0])) {
                    found = true;
                }
            }
            
            if (!found) {
                customers.add(new String[]{t[0], "0"});
            }
        }

        // 3. Move everything to a Queue
        Queue<String[]> queue = new LinkedList<>();
        while (!transactions.isEmpty()) {
            queue.add(transactions.poll());
        }

        // 4. Process the Queue & save failed withdrawals to a Stack
        Stack<String[]> failed = new Stack<>();

        while (!queue.isEmpty()) {
            String[] current = queue.poll();
            String name = current[0];
            String type = current[1];
            int amount = Integer.parseInt(current[2]);

            // Find the right customer and update their balance
            for (String[] c : customers) {
                if (c[0].equals(name)) {
                    int balance = Integer.parseInt(c[1]);

                    if (type.equals("DEPOSIT")) {
                        c[1] = String.valueOf(balance + amount);
                    } else if (type.equals("WITHDRAW")) {
                        if (amount > balance) {
                            failed.push(current);
                        } else {
                            c[1] = String.valueOf(balance - amount);
                        }
                    }
                }
            }
        }

        // 5. Print final results exactly as requested
        System.out.println("=== Final Balances ===");
        for (String[] c : customers) {
            System.out.println(c[0] + ": " + c[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!failed.isEmpty()) {
            String[] f = failed.pop();
            System.out.println(f[0] + " " + f[1] + " " + f[2]);
        }
    }
}
