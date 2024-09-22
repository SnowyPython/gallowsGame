public class Mask {
    private String word;
    private String wordMask;

    public Mask(String word) {
        this.word = word;
        this.wordMask = createMask(word);
    }

    public String getMask() {
        return wordMask;
    }

    public String getWord() {
        return word;
    }

    public String createMask(String word) {
        return "*".repeat(word.length());
    }

    public void editWordWithMask(char letter) {
        StringBuilder updateMask = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                updateMask.setCharAt(i, letter);
            }
        }

        wordMask = updateMask.toString();
    }
}
