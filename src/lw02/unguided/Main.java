package lw02.unguided;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> requests = new LinkedList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

         while (scanner.hasNext()) {
            String name = scanner.next();
            String bookTitle = scanner.next();
            requests.add(new String[]{name, bookTitle});
        }
        scanner.close();

        LinkedList<String[]> book = new LinkedList<>();
         for (String[] t : requests) {
            boolean found = false;

            for (String[] c : book) {
                if (c[0].equals(t[0])) {
                    found = true;
                }
            }
            
            if (!found) {
                book.add(new String[]{t[0], "0"});
            }


        LinkedList<String[]> members = new LinkedList<>();
        for (String[] req : requests) {
            boolean found2 = false;
            
            for (String[] m : members) {
                if (m[0].equals(req[0])) {
                    found2 = true;
                }
            }
            
            if (!found2) {
                members.add(new String[]{req[0], "0"});
            }
        }

        Queue<String[]> queue = new LinkedList<>();
        while (!requests.isEmpty()) {
            queue.add(requests.poll());
        }

         Stack<String[]> failed = new Stack<>();

         
        while (!queue.isEmpty()) {
            String[] current = queue.poll();
            String name = current[0];
            String bookTitle = current[1];

            int stock = 0;
            String[] currentBook = null;
            
            for (String[] b : book) {
                if (b[0].equals(bookTitle)) {
                    stock = Integer.parseInt(b[1]);
                    currentBook = b;
                    }
                }
                
            }
        }
    }
}
        
