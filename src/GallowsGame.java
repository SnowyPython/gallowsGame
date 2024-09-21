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

        System.out.println("Вы хотите начать игру? (Д/Н)");
        String input = reader.readLine();
        int mistakesCount = 0;

        if (input.equals("Д")) {
            Mask.setWordAndMask(dictionary[(int) (Math.random() * dictionary.length)].toLowerCase());

            while (true) {
                System.out.println(Mask.getMask());
                printGallows(mistakesCount);
                if (!Mask.getMask().contains("*")) {
                    System.out.println("Победа ура ура!!!");
                    break;
                }

                if (mistakesCount == 6) {
                    System.out.println("Вы проиграли!");
                    break;
                }

                System.out.println("введите букву");
                char letter = reader.readLine().charAt(0);

                if (Mask.getWord().indexOf(letter) > -1) {
                    Mask.editWordWithMask(letter, Mask.getWord(), Mask.getMask());
                } else {
                    mistakesCount++;
                }
            }
        } else if (input.equals("Н")) {
            System.out.println("ладно");
        } else {
            System.out.println("Неверный ввод, введите Д или Н");
        }
    }
}


