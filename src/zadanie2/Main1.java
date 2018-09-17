package zadanie2;


import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int[] lottoNumbers = readLottoNumbers();
        int[] randomLottoNumbers = generateRandomLottoNumbers();
        System.out.println("Szczesliwe numery to:");
        System.out.println(Arrays.toString(randomLottoNumbers));
        compareLotto(lottoNumbers, randomLottoNumbers);

    }

    static int[] readLottoNumbers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sprawdz jak bardzo nie masz szczescia w grze Lotto nie wydajac pieniedzy!");
        int[] lottoNumbers = new int[6];
        int i = 0;
        while (lottoNumbers[5] == 0) {
            System.out.println("Podaj " + (i + 1) + " liczbe z zakresu 1-49");
            try {
                int lottoNumber = Integer.parseInt(scan.nextLine());
                if ((lottoNumber >= 1 && lottoNumber <= 49) && (!(ArrayUtils.contains(lottoNumbers, lottoNumber)))) {
                    lottoNumbers[i] = lottoNumber;
                    i++;
                } else {
                    System.out.println("Bledna liczba - pamietaj ze liczba musi zawierac sie w zakresie 1-49, oraz nie moze sie powtorzyc");
                }
            } catch (NumberFormatException e) {
                System.out.println("nie podales liczby");
            }
        }
        Arrays.sort(lottoNumbers);
        System.out.println("Twoje numery to:");
        System.out.println(Arrays.toString(lottoNumbers));
        return lottoNumbers;
    }

    static int[] generateRandomLottoNumbers() {
        Random rand = new Random();
        int[] randomLottoNumbers = new int[6];
        int i = 0;
        while (randomLottoNumbers[5] == 0) {
            int randomLottoNumber = rand.nextInt(49) + 1;
            if ((ArrayUtils.contains(randomLottoNumbers, randomLottoNumber))) {
                randomLottoNumbers[i] = randomLottoNumber;
                i++;
            }

        }
        Arrays.sort(randomLottoNumbers);
        return randomLottoNumbers;
    }

    static void compareLotto(int[] lottoNumbers, int[] randomMottoNumbers) {
        int succesfullHit = 0;
        for (int i = 0; i < lottoNumbers.length; i++) {
            if (ArrayUtils.contains(randomMottoNumbers, lottoNumbers[i])) {
                succesfullHit++;
            }
        }
        switch (succesfullHit) {
            case 3:
                System.out.println("trafiles 3");
                break;
            case 4:
                System.out.println("trafiles 4");
                break;
            case 5:
                System.out.println("trafiles 5");
                break;
            case 6:
                System.out.println("trafiles 6!!!");
                break;
            default:
                System.out.println("Nie udalo sie");
        }


    }

}
