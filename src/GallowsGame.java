import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GallowsGame {
    private static String[] createDictionary() throws IOException {
        String filePath = "src/words.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String[] dictionary = new String[100];

        for (int i = 0; reader.ready(); i++) {
            String word = reader.readLine();
            dictionary[i] = word;
        }

        reader.close();

        return dictionary;
    }

    private static String createMask(String word) {
        String result = "";
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += "*";
        }

        return result;
    }

    private static void printGallows(int mistakesCount) {
        switch (mistakesCount) {
            case 0:
                System.out.println("------");
                System.out.println("|/");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 1:
                System.out.println("------");
                System.out.println("|/  |");
                System.out.println("|   0");
                System.out.println("|");
                System.out.println("|");
                break;
            case 2:
                System.out.println("------");
                System.out.println("|/  |");
                System.out.println("|   0");
                System.out.println("|   |");
                System.out.println("|");
                break;
            case 3:
                System.out.println("------");
                System.out.println("|/  |");
                System.out.println("|   0");
                System.out.println("|  /|");
                System.out.println("|");
                break;
            case 4:
                System.out.println("------");
                System.out.println("|/  |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|");
                break;
            case 5:
                System.out.println("------");
                System.out.println("|/  |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|  /");
                break;
            case 6:
                System.out.println("------");
                System.out.println("|/  |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|  / \\");
                break;
        }
    }

    public static void startGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dictionary = createDictionary();

        while (true) {
            System.out.println("Вы хотите начать игру? (Д/Н)");
            String input = reader.readLine();

            if (input.equals("Д")) {
                int mistakesCount = 0;
                String word = dictionary[(int) (Math.random() * dictionary.length)];
                String mask = createMask(word);

                System.out.println(mask);
                printGallows(mistakesCount);

                System.out.println("введите букву");
                String letter = reader.readLine();
                if (letter.contains(word)) {

                }

            } else if (input.equals("Н")) {
                break;
            } else {
                System.out.println("Неверный ввод, введите Д или Н");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        startGame();
    }
}

