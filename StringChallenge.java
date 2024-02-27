
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringChallenge {

    public static String romanToShort(String str) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(romanLetters[i], values[i]);
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && map.get(str.substring(i, i + 2)) != null) {
                result = result + map.get(str.substring(i, i + 2));
                i++;
            } else {
                result = result + map.get(str.substring(i, i + 1));
            }
        }
        System.out.println("Input: " + str + " Number: " + result);


        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (result >= values[i]) {
                result = result - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }


    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a old Roman number: ");
        String romanToShort = romanToShort(s.nextLine());
        System.out.println("Shorter: " + romanToShort);
    }
}
