import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GallowsGame {
    private static final int MAX_MISTAKES_COUNT = 6;

    private String[] createDictionary() throws IOException {
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

    public void startGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dictionary = createDictionary();

        System.out.println("Вы хотите начать игру? (Д/Н)");
        String input = reader.readLine();
        int mistakesCount = 0;

        if (input.equals("Д")) {
            Random random = new Random();
            String randomWord = dictionary[random.nextInt(dictionary.length)].toLowerCase();

            Mask mask = new Mask(randomWord);

            while (true) {
                System.out.println(mask.getMask());
                Gallows.printGallows(mistakesCount);

                if (checkWin(mask)) break;
                if (checkLose(mistakesCount)) break;

                System.out.println("введите букву");
                char letter = reader.readLine().charAt(0);

                if (mask.getWord().indexOf(letter) > -1) {
                    mask.editWordWithMask(letter);
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

    public boolean checkLose(int mistakesCount) {
        if (mistakesCount == MAX_MISTAKES_COUNT) {
            System.out.println("Вы проиграли!");
            return true;
        }
        return false;
    }

    public boolean checkWin(Mask mask) {
        if (!mask.getMask().contains("*")) {
            System.out.println("Победа ура ура!!!");
            return true;
        }
        return false;
    }
}


