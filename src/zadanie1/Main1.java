package zadanie1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100)+1;
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Zgadnij liczbe");
        while (!(input = scan.nextLine()).equals(String.valueOf(number))){
            try {
                int x = Integer.parseInt(input);
                if (x> number){
                    System.out.println("Za duzo");
                } else {
                    System.out.println("Za malo");
                }
            } catch (NumberFormatException e){
                System.out.println("To nie jest liczba");
            }
        }
        System.out.println("Zgadles !");
    }
}
