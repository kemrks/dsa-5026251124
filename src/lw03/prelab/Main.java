package lw03.prelab;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        //syarat awal
        Scanner sc = new Scanner (Main.class.getResourceAsStream("playlist.txt"));
        Scanner sc2 = new Scanner (Main.class.getResourceAsStream("participants.txt"));
        Scanner sc3 = new Scanner (Main.class.getResourceAsStream("inventory.txt"));

        //logika problem 1
        List<String> playList = new LinkedList<>();
        while (sc.hasNext()) {

            String order = sc.next();

            int xdi = -1;
            if(order.equals("INSERT")){
                String idx = sc.next();
                xdi = Integer.parseInt(idx);
            }

            String songs = sc.nextLine();

            if (order.equals("ADD")) {
                playList.add(songs);
            } else if (order.equals("INSERT") && xdi != -1) {
                playList.add(xdi, songs);
            } else {
                for(int i = 0 ; i < playList.size(); i++){
                    if(playList.get(i).equals(songs)) {
                        playList.remove(i);
                        break;
                    }
                }
            }
        }
            //output problem 1
            System.out.println("===== Problem 1 =====");
            System.out.println("Total songs: " + playList.size());
            for (int i = 0 ; i < playList.size() ; i++){
                System.out.println((i+1) + " : " + playList.get(i));
            }


            //logika problem 2
            Set<String> wsParticipants = new LinkedHashSet<>();
            int counter = 0;

            while (sc2.hasNext()) {

                String peepsNames = sc2.next();

                if(!wsParticipants.contains(peepsNames)) {
                    wsParticipants.add(peepsNames);
                    System.out.println(peepsNames);
                } else {
                    counter++;
                }

            }

            // output problem 2
            System.out.println("===== Problem 2 =====");
            System.out.println("Unique participants: " + wsParticipants.size());

            int x2 = 1;
            for(String s : wsParticipants){
                System.out.println(x2 + ". " + s);
                x2++;

            }   
            System.out.println("Duplicate registrations: " + counter);

        
        //logika  problem 3
        Map<String, Integer> inventories = new LinkedHashMap<>();
        int failedSales = 0;

        while (sc3.hasNext()) {
             String plusMinus = sc3.next();
             String productsName = sc3.next();
             int quantity = sc3.nextInt();

        if (plusMinus.equals("ADD")) {
            if (inventories.containsKey(productsName)) {
                int oldStocks = inventories.get(productsName);
                int newStock = oldStocks + quantity;
                inventories.put(productsName, newStock);
            } else {
                inventories.put(productsName, quantity);
            }
        }

        if (plusMinus.equals("SELL")) {
            if (inventories.containsKey(productsName)) {
                int currentStock = inventories.get(productsName);
                if (currentStock >= quantity) {
                    inventories.put(productsName, currentStock - quantity);
                } else {
                failedSales++;  
                }
            } else {
            failedSales++;
        }
    }


        System.out.println("===== Problem 3 =====");

        for (String productName : inventories.keySet()) {
            int finalStock = inventories.get(productName);
            System.out.println(productName + ": " + finalStock);
        }

        System.out.println("Failed sales: " + failedSales);
       

           


            



            
    





      }
    }
}
