package zadanie5;

import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        String[] words = getHeaders("http://www.onet.pl/");
        createFile(words, "popular_words.txt");
        createFile(filterWords(readFile("popular_words.txt")), "filtered_popular_words.txt");


    }

    static String[] getHeaders(String url) {
        ArrayList<String> headers = new ArrayList<String>();
        Connection connect = Jsoup.connect(url);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                String line = (elem.text());
                String[] lineToArr = line.split(" ");
                lineToArr = getRidOf(lineToArr);
                for (int i = 0; i < lineToArr.length; i++) {
                    headers.add(lineToArr[i]);

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return headers.toArray(new String[0]);
    }


    static String[] getRidOf(String[] lineToArr) {
        char[] specialChar = {'!', '\\', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '/', ']', '^', '`', '{', '|', '}', '~', ','};
        for (int i = 0; i < lineToArr.length; i++) {
            for (int j = 0; j < specialChar.length; j++) {
                lineToArr[i] = lineToArr[i].replace(specialChar[j], ' ');
                lineToArr[i] = lineToArr[i].trim();
            }
        }
        return lineToArr;
    }
    static void createFile(String[] words , String fileName) {
        File file = new File(fileName);
        try (FileWriter out = new FileWriter(file, true)) {
            for (int i = 0; i <words.length; i++) {
                out.append(words[i]).append("\n");
            }

        } catch (IOException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }
    }

    static String[] readFile (String fileName){
        File file = new File(fileName);
        ArrayList<String> headers = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(file);
            headers.add(scan.nextLine());
        } catch (FileNotFoundException e){
            System.out.println("Operacja pobrania danych z pliku nie powiodla sie - plik nie istnieje");
        }
        return headers.toArray(new String[0]);
    }

    static String[] filterWords (String[] words){
        String[] filterWords = {"było", "oraz", "ponieważ", "prof", "byle"};
        ArrayList<String> headers = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < filterWords.length; j++) {
                if (words[i].length() > 3 && !(ArrayUtils.contains(words,filterWords[i]))) {
                    headers.add(words[i]);
                }
            }
        }
        return headers.toArray(new String[0]);

    }
}
