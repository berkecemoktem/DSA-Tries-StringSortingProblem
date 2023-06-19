import java.util.Arrays;

public class StringSortingTester {
    public static void main(String[] args) {
        // Test case 1
        String[] firstArray1 = {"dog", "honey", "apple", "rope"};
        String[] secondArray1 = {"gdbo", "bonex", "pina", "elo"};
        String[] expectedArray1 = {"gdo", "ehnoy", "ppale", "eorp"};

        testStringSorting(firstArray1, secondArray1, expectedArray1);

        // Test case 2
        String[] firstArray2 = {"forest", "water", "nick", "doze"};
        String[] secondArray2 = {"ftrki", "olis", "cim", "ipgk"};
        String[] expectedArray2 = {"eforst", "aertw", "cink", "doze"};

        testStringSorting(firstArray2, secondArray2, expectedArray2);

        // Add more test cases if needed
    }

    public static void testStringSorting(String[] firstArray, String[] secondArray, String[] expectedArray) {
        TrieST<Integer> trieST = new TrieST<>();
        // Populate the trieST instance if needed

        String[] sortedArray = Arrays.copyOf(firstArray, firstArray.length);
        StringSortingAlgorithm.sortStrings(sortedArray, secondArray, trieST);

        boolean passed = Arrays.equals(sortedArray, expectedArray);

        if (passed) {
            System.out.println("Test Passed!");
            System.out.println("Expected: " + Arrays.toString(expectedArray));
            System.out.println("Actual: " + Arrays.toString(sortedArray));
        } else {
            System.out.println("Test Failed!");
            System.out.println("Expected: " + Arrays.toString(expectedArray));
            System.out.println("Actual: " + Arrays.toString(sortedArray));
        }
    }
}
