import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mask {
    private static String word;
    private static String wordMask;

    public static String getMask() {
        return wordMask;
    }

    public static String getWord() {
        return word;
    }

    public static void setWordAndMask(String word) throws IOException {
        Mask.word = word;
        wordMask = createMask(word);
    }
    public static String createMask(String word) {
        String result = "";
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            result += '*';
        }

        return result;
    }
    public static void editWordWithMask(char l, String word, String mask) {
        char[] original = word.toCharArray();
        char[] clone = mask.toCharArray();

        for (int i = 0; i < original.length; i++) {
            if (l == original[i]) {
                clone[i] = l;
            }
        }

        String result = "";
        for (int i = 0; i < clone.length; i++) {
            result += clone[i];
        }

        wordMask = result;
    }
}
