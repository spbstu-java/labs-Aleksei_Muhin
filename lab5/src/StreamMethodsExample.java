import java.util.*;
import java.util.stream.Collectors;

public class StreamMethodsExample {

    public static double calculateAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static List<String> transformAndAddPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> uniqueSquares(List<Integer> numbers) {
        Map<Integer, Long> frequencyMap = numbers.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        return numbers.stream()
                .filter(n -> frequencyMap.get(n) == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLetter(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastElementOrThrowException(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    public static int sumEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static Map<Character, String> convertToMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1), (existing, replacement) -> existing));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        // Примеры использования методов:
        double average = calculateAverage(numbers);
        System.out.println("Average: " + average);

        List<String> transformedStrings = transformAndAddPrefix(strings);
        System.out.println("Transformed Strings: " + transformedStrings);

        List<Integer> uniqueSquares = uniqueSquares(numbers);
        System.out.println("Unique Squares: " + uniqueSquares);

        List<String> filteredAndSortedStrings = filterAndSortByLetter(strings, 'b');
        System.out.println("Filtered and Sorted Strings: " + filteredAndSortedStrings);

        List<String> emptyList = Collections.emptyList();
        try {
            String lastElement = getLastElementOrThrowException(emptyList);
            System.out.println("Last Element: " + lastElement);
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        int[] integerArray = {1, 2, 3, 4, 5};
        int sumOfEvenNumbers = sumEvenNumbers(integerArray);
        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbers);

        Map<Character, String> stringMap = convertToMap(strings);
        System.out.println("String Map: " + stringMap);
    }
}
