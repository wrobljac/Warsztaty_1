package zadanie3;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Wybierz liczbe od 1 do 1000, a ja zgadne jaka to liczba w 10 probach");
        int xmin = 1, xmax = 1000, tryCount = 1;

        String hint = " ";
        while (!(hint.equals("trafiles"))) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Czy twoja liczba to: " + compGuess(xmin, xmax) + "?");
            System.out.println("Napisz: trafiles , wiecej lub mniej");
            hint = scan.nextLine();
            switch (hint) {
                case "wiecej":
                    xmin = compGuess(xmin, xmax);
                    tryCount++;
                    break;
                case "mniej":
                    xmax = compGuess(xmin, xmax);
                    tryCount++;
                    break;
                case "trafiles":
                    System.out.println("Zgadlem twoja liczbe w " + tryCount + " probach");
                    break;
                default:
                    System.out.println("Nie rozumiem co napisales - moze popelniles blad podczas pisania? \nNapisz: trafiles , wiecej lub mniej");
            }

        }


    }

    static int compGuess(int xmin, int xmax) {
        return (xmin + xmax)/2;
    }
}
