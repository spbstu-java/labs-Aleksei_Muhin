package translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    private static final String DICT_FILE = "src/input.txt";

    private Map<String, String> myDictionary;

    public Translator() {
        myDictionary = new HashMap<>();
    }

    public void connectDict() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DICT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    String translation = parts[1].trim();
                    myDictionary.put(word, translation);
                }
            }
        } catch (IOException e) {
            System.out.println("Dictionary error!");
        }
    }

    public String translationWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        if (myDictionary.containsKey(lowerCaseWord)) {
            return myDictionary.get(lowerCaseWord);
        }
        return lowerCaseWord;
    }

    public String translate(String text) {
        StringBuilder translation = new StringBuilder();

        translation.append(translationWord(text)).append(" "); // Append a space here

        if (!translation.toString().trim().isEmpty()) {
            return translation.toString().trim();
        }

        String[] words = text.split("\\s+");
        for (String word : words) {
            String translatedWord = translationWord(word);
            translation.append(translatedWord).append(" ");
        }

        return translation.toString().trim();
    }

    public void exec() {
        connectDict(); // Removed redundant instantiation of Translator
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        String translatedText = translate(input);
        System.out.println("Translation: " + translatedText);
    }
}
