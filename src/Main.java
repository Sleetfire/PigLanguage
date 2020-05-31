import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ввелите слово или предложение на английском, чтобы перевести его на Поросячью латынь:");
        Scanner a = new Scanner(System.in);
        String sentence = a.nextLine();
        String [] word1 = sentence.split("\\s");

        for (int i = 0; i < word1.length; i++) {
            boolean test = word1[i].matches("^(?i:[^aeiouy]).*");

            char [] word2 = new char[1];
            char [] word3 = new char[1];

            if (test) {
                word1[i].getChars(0, 1, word2, 0);
                word1[i] = removeCharAt(word1[i], 0);
                boolean test2 = word1[i].matches("^(?i:[^aeiouy]).*");
                if (test2) {
                    word1[i].getChars(0, 1, word3, 0);
                    word1[i] = removeCharAt(word1[i], 0);
                    word1[i] = word1[i] + String.valueOf(word2[0]) + String.valueOf(word3[0]) + "ay";
                } else word1[i] = word1[i] + String.valueOf(word2[0]) + "ay";;

                System.out.print(word1[i] + " ");

            } else {
                word1[i] = word1[i] + "ay";
                System.out.print(word1[i] + " ");
            }

        }

    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
