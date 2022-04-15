//101398801
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordArray {
    private String[] wordArray;
    private int count;

    public String getWord(int key){
        return wordArray[key];
    }

    public WordArray(){
        count=0;
        wordArray=new String[1000];
    }

    private void add(String word){
        wordArray[count]=word;
        count++;
    }

    public void loadIntoArray(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()){
            add(scanner.nextLine().trim());
        }
    }

    public int getCount() {
        return count;
    }


}
