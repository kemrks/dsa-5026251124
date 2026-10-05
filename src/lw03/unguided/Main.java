package lw03.unguided;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

    Map<String, Integer> studsEnrollment = new LinkedHashMap<>();
        int rejectOperations = 0;

        while (sc.hasNext()) {

                String operations = sc.next();
                String courseCode = sc.next();
                int quantity = sc.nextInt();
            
            if (operations.equals("REGISTER")) {
                if (studsEnrollment.containsKey(courseCode)){
                    int oldEnroll = studsEnrollment.get(courseCode);
                    int newEnroll = oldEnroll + quantity;
                    studsEnrollment.put(courseCode, newEnroll);
                } else {
                    studsEnrollment.put(courseCode, quantity);
                }
            }

            if (operations.equals("WITHDRAW")) {
                if (studsEnrollment.containsKey(courseCode)) {
                    int currentEnroll = studsEnrollment.get(courseCode);
                    if (currentEnroll >= quantity) {
                        studsEnrollment.put(courseCode, currentEnroll - quantity);
                    } else {
                        rejectOperations++;
                    }
               } else {
            rejectOperations++;
        }
    }

            if (operations.equals("CHECK")) {
                if (studsEnrollment.containsKey(courseCode)) {
                     int currentEnroll = studsEnrollment.get(courseCode);
                     if (currentEnroll > 0) {
                        System.out.println(courseCode + ": " + quantity + "students");
                        
                     } else {
                        System.out.println(courseCode + ": " + "Not Found");
                     }
                }
                
            }

        }

        System.out.println("===== Enrollment Checks =====");
       


        System.out.println("===== Final Enrollment =====");
         for (String enrollments : studsEnrollment.keySet()) {
            int finalCheck = studsEnrollment.get(enrollments);
            System.out.println(enrollments + ": " + finalCheck);
        }


        System.out.println("Failed sales: " + rejectOperations);
        



    }
}
