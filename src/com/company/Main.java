package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader_message = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader_range = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Podaj przesuniecie");
            String range = reader_range.readLine();
            if(checkRange(range)){
                System.out.println("Wpisz wiadomosc...");
                String message = reader_message.readLine();
                System.out.println("Zaszyfrowana wiadomość to: " + encryptmessage(normalizemessage(message),getRange(range)));
            }else{
                System.out.println("Odleglosc mozesz podac tylko w liczkach calkowitych");
            }
        }
    }

    public static Integer getRange(String a){
            return parseInt(a);
    }
    //Funkcja przekształcająca przesunięcie w stringu a na typ int

    public static  boolean checkRange(String a){
        if(Pattern.matches("^[0-9]*$",a)==true){
            return true;
        }else {
            return false;
        }
    }
    //Funkcja sprawdzająca czy wprowadzone przesuniecie jest cyfra

    public static String normalizemessage(String a){
        StringBuilder sb = new StringBuilder();
        int L = a.length();
        char[] aa = a.toCharArray();
        for (int i = 0; i < L; i++)
        {
            switch (aa[i]){
                case 'ą': sb.append('a'); break;
                case 'ć': sb.append('c'); break;
                case 'ę': sb.append('e'); break;
                case 'ł': sb.append('l'); break;
                case 'ń': sb.append('n'); break;
                case 'ó': sb.append('o'); break;
                case 'ś': sb.append('s'); break;
                case 'ź': sb.append('z'); break;
                case 'ż': sb.append('z'); break;
                case 'Ą': sb.append('A'); break;
                case 'Ć': sb.append('C'); break;
                case 'Ę': sb.append('E'); break;
                case 'Ł': sb.append('L'); break;
                case 'Ń': sb.append('N'); break;
                case 'Ó': sb.append('O'); break;
                case 'Ś': sb.append('S'); break;
                case 'Ź': sb.append('Z'); break;
                case 'Ż': sb.append('Z'); break;
                default: sb.append(aa[i]); break;
            }
        }
        String normalmessage = sb.toString();
        return normalmessage;
    }
    //Metoda zastepujace polskie znaki literami

    public static String encryptmessage(String a,Integer b){
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char letter = a.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                letter = (char) ((letter - 'a' + b) % ('z' - 'a' + 1) + 'a');
            } else if (letter >= 'A' && letter <= 'Z') {
                letter = (char) ((letter - 'A' + b) % ('Z' - 'A' + 1) + 'A');
            }
            encryptedMessage.append(letter);
        }
        return encryptedMessage.toString();
    }
    //Funkcja szyfrujaca wiadomosc
}





