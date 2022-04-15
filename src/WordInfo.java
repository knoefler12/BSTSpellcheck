//101398801
public class WordInfo {
    private String word;
    private String meaning;

    public WordInfo(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return "[word='" + word + '\'' +
                ", meaning='" + meaning + "\']";
    }
}
