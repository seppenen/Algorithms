import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringChallenge {

    // This method converts a given Roman numeral to a shorter version.
    public static String romanToShort(String str) {
        // Arrays to store the values and corresponding Roman numeral letters
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // Create a HashMap to map Roman numeral letters to their values
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(romanLetters[i], values[i]);
        }

        int result = 0;
        // Iterate through the input string to convert Roman numeral to integer
        for (int i = 0; i < str.length(); i++) {
            // Check if the substring of length 2 exists in the map
            if (i + 1 < str.length() && map.get(str.substring(i, i + 2)) != null) {
                // If found, add corresponding value to result and skip next character
                result = result + map.get(str.substring(i, i + 2));
                i++;
            } else {
                // If not found, add value of current character to result
                result = result + map.get(str.substring(i, i + 1));
            }
        }
        System.out.println("Input: " + str + " Number: " + result);

        // Convert the integer result back to a shorter Roman numeral
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            // Append the corresponding Roman numeral letters to the result
            while (result >= values[i]) {
                result = result - values[i];
                roman.append(romanLetters[i]);
            }
        }
        // Return the shorter version of the Roman numeral
        return roman.toString();
    }

    public static void main(String args[]) {
        // Prompt the user to enter a Roman numeral
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an old Roman number: ");
        // Call the romanToShort method and print the result
        String romanToShort = romanToShort(s.nextLine());
        System.out.println("Shorter: " + romanToShort);
    }
}
