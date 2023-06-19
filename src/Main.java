import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first array from the user
        System.out.println("First Array: ");
        String[] firstArray = scanner.nextLine().split(" ");

        // Read the second array from the user
        System.out.println("Second Array: ");
        String[] secondArray = scanner.nextLine().split(" ");

        // Create a TrieST object
        TrieST<Integer> trie = new TrieST<>();

        // Insert the strings of the second array into the trie
        for (String str : secondArray) {
            trie.put(str, 1); // We can use any dummy value here, as it's not used in this example
        }

        // Sort the strings in the first array based on the second array
        StringSortingAlgorithm.sortStrings(firstArray, secondArray, trie);

        // Print the sorted first array
        System.out.println("Sorted Array: ");
        for (String str : firstArray) {
            System.out.print(str + " ");
        }
    }

   
}
