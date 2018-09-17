package zadanie4;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        userDiceInput();
    }

    static void userDiceInput() {
        int throwNumber = 0, diceType = 0, modifier = 0;
        System.out.println("By obliczyc wartosc rzutu wpisz typ rzutu wedle instrukcji:");
        System.out.println("xDy+z");
        System.out.println("gdzie:");
        System.out.println("y – rodzaj kostek, których należy użyć (np. D6, D10)");
        System.out.println("x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny)");
        System.out.println("z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.");
        boolean properFormat = false;
        do {
            Scanner scan = new Scanner(System.in);
            String diceFormula = scan.nextLine();
            try {
                throwNumber = Integer.parseInt(diceFormula.substring(0, diceFormula.indexOf("D")));
                if (diceFormula.contains("+")) {
                    diceType = Integer.parseInt(diceFormula.substring(diceFormula.indexOf("D") + 1, diceFormula.indexOf("+")));
                    modifier = Integer.parseInt(diceFormula.substring(diceFormula.indexOf("+") + 1, diceFormula.length()));
                    properFormat=true;
                } else {
                    diceType = Integer.parseInt(diceFormula.substring(diceFormula.indexOf("D")+1, diceFormula.length()));
                    modifier = 0;
                    properFormat=true;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Musisz podac poprawna formule");
            } catch (NumberFormatException e) {
                System.out.println("x , y lub z nie za liczbami");
            }
        } while (properFormat == false);
        System.out.print("Wynik rzutu ");
        System.out.println(throwDice(throwNumber, diceType, modifier));
    }


    static int throwDice(int throwNumber, int diceType, int modifier) {
        Random rand = new Random();
        diceType = rand.nextInt(diceType) + 1;
        return throwNumber * diceType + modifier;
    }
}
