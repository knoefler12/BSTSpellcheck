//101398801
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        WordArray wordArray = new WordArray();
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        String menuLine = "-----------------------------------------------------";
        boolean loopOn = true;

        wordArray.loadIntoArray("wordlist.txt");
        dictionary.loadSortedArrayToBST(wordArray);

        while(loopOn){
            System.out.println(menuLine);
            System.out.println("1 - Add new word");
            System.out.println("2 - Delete word");
            System.out.println("3 - Get meaning");
            System.out.println("4 - Dictionary List");
            System.out.println("5 - Spell check a file");
            System.out.println("6 - Exit");
            System.out.print("Enter number: ");

            int menuChoice=0;
            if(scanner.hasNextInt()) {
                menuChoice = scanner.nextInt();
            }
            scanner.nextLine();

            switch (menuChoice){
                case 1:
                    System.out.println(menuLine);
                    System.out.print("Enter new word: ");
                    String newWord = scanner.nextLine();
                    System.out.print("Enter new words meaning: ");
                    String meaning = scanner.nextLine();
                    dictionary.add(newWord,meaning);
                    break;

                case 2:
                    System.out.println(menuLine);
                    System.out.print("Enter word to delete: ");
                    String wordToDelete = scanner.nextLine();
                    dictionary.delete(wordToDelete);
                    break;

                case 3:
                    System.out.println(menuLine);
                    System.out.print("Enter word to get a meaning: ");
                    String word = scanner.nextLine();
                    String meaningFromWord = dictionary.getMeaning(word);
                    if(meaningFromWord!=null){
                        System.out.println(meaningFromWord);
                    }
                    else{
                        System.out.println("Word not found!");
                    }
                    break;

                case 4:
                    System.out.println(menuLine);
                    dictionary.printDictionary();
                    System.out.println(menuLine);
                    System.out.println("There are currently "+dictionary.getCount()+" words in the dictionary");
                    break;

                case 5:
                    System.out.println(menuLine);
                    System.out.print("Enter name of your file to spellcheck, without file type \n: ");
                    String fileName = scanner.nextLine();
                    System.out.println("File to spell check: "+fileName+".txt");
                    System.out.println(menuLine);

                    Scanner fileScanner = new Scanner(new File(fileName+".txt"));
                    while (fileScanner.hasNextLine()){
                        String wordInFile = fileScanner.next().trim().replaceAll
                                ("[^a-zA-Z]","").toLowerCase();
                        if(!dictionary.exists(wordInFile) && wordInFile!=""){
                            System.out.println("word: "+wordInFile+", does not exist");
                        }
                    }
                    break;


                case 6:
                    System.out.println(menuLine);
                    loopOn = false;
                    break;
            }
        }
    }
}
