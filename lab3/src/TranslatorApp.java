import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TranslatorApp {
    public static void main(String[] args) {
        try {
            // Укажите полный путь к файлу dictionary.txt
            String dictionaryFilePath = "D:\\ProgramJaVa\\lab 3\\src\\dictionary.txt";

            Map<String, String> dictionary = readDictionary(dictionaryFilePath);
            String inputFile = "D:\\ProgramJaVa\\lab 3\\src\\input.txt";

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String translation = translateText(line, dictionary);
                    System.out.println(translation);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Произошла ошибка при чтении/записи файла");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Произошла ошибка при чтении словаря");
        }
    }

    private static Map<String, String> readDictionary(String filePath) throws IOException {
        Map<String, String> dictionary = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    String translation = parts[1].trim();
                    dictionary.put(word, translation);
                }
            }
        }

        return dictionary;
    }

    private static String translateText(String text, Map<String, String> dictionary) {
        String[] words = text.split("\\s+");
        StringBuilder translation = new StringBuilder();

        for (String word : words) {
            word = word.toLowerCase();
            String translatedWord = dictionary.get(word);

            if (translatedWord != null) {
                translation.append(translatedWord).append(" ");
            } else {
                translation.append(word).append(" ");
            }
        }

        return translation.toString().trim();
    }
}
