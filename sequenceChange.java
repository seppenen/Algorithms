import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


/
public class Main {
    public static void main(String[] args) {
        int[] array = {3, 5, 8, 1, 14, 3};
        int[] array1 = {3, 5, 6, 9, 14, 23};
        int[] array2 = {3, 5, 8, 8, 14, 14};
        int[] array3 = {14, 9, 8, 5, 3, 1};
        int[] array4 = {14, 9, 8, 5, 3, 1};
        int[] array5 = {8, 8, 8, 8, 8, 8};

        System.out.println("Result for array: " + reduceArray(array));
        System.out.println("Result for array1: " + reduceArray(array1));
        System.out.println("Result for array2: " + reduceArray(array2));
        System.out.println("Result for array3: " + reduceArray(array3));
        System.out.println("Result for array4: " + reduceArray(array4));
        System.out.println("Result for array5: " + reduceArray(array5));
    }

      /**
      * Performs a bitwise OR operation between different bitmask patterns
      * representing various sequence change patterns in an array of integers.
      * Returns a value according to the mask found in the table,
      * if the mask matches one of the patterns, otherwise returns -1.
      *
      * @param arr An array of integers.
      * @return A value according to the found mask or -1 if no mask is found.
      */

    public static int reduceArray(int[] arr) {
        Map<Integer, Integer> mask = new HashMap<>();
        mask.put(0b010, 5);
        mask.put(0b001, 3);
        mask.put(0b100, 1);
        mask.put(0b011, 4);
        mask.put(0b110, 2);

        int acc = 0;
        int[] subArray = Arrays.copyOfRange(arr, 1, arr.length); // Cutting first element
        for (int i = 0; i < subArray.length; i++) {
            acc |= (1 << Math.signum(subArray[i] - arr[i]) + 1);
        }

        return mask.getOrDefault(acc, -1);
    }
}
