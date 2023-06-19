import java.util.Arrays;

public class StringSortingAlgorithm {
    public static void sortStrings(String[] firstArray, String[] secondArray, TrieST<Integer> trieST) {
        int[] valuesArray1 = calculateIntegerValues(firstArray);
        int[] valuesArray2 = calculateIntegerValues(secondArray);

        for (int i = 0; i < firstArray.length; i++) {
            if (Math.abs(valuesArray2[i] - valuesArray1[i]) % 2 != 0) {
                sortFirstArrayDirectly(firstArray, i);
            } else {
                sortFirstArrayBasedOnSecondArray(firstArray, secondArray,trieST, i);
            }
        }
    }

    public static void sortFirstArrayDirectly(String[] firstArray, int index) {
        char[] chars = firstArray[index].toCharArray();
        Arrays.sort(chars);
        firstArray[index] = new String(chars);
    }

    public static void sortFirstArrayBasedOnSecondArray(String[] firstArray, String[] secondArray, TrieST<Integer> trieST, int index) {
        String str = firstArray[index];
        String secondStr = secondArray[index];

        StringBuilder sortedStr = new StringBuilder();

        for (char c : secondStr.toCharArray()) {
            if (str.contains(String.valueOf(c))) {
                sortedStr.append(c);
            }
        }

        String[] highestPriorityChars = trieST.getHighestPriorityChars(secondArray);
        String[] leastPriorityChars = trieST.getLeastPriorityChars(secondArray);

        String highestPriorityChar = highestPriorityChars[index];
        String leastPriorityChar = leastPriorityChars[index];

        if (!sortedStr.toString().contains(highestPriorityChar) && str.contains(highestPriorityChar)) {
            sortedStr.append(highestPriorityChar);
        }

        if (!sortedStr.toString().contains(leastPriorityChar) && str.contains(leastPriorityChar)) {
            sortedStr.append(leastPriorityChar);
        }

        for (char c : str.toCharArray()) {
            if (!sortedStr.toString().contains(String.valueOf(c)) &&
                    !highestPriorityChar.contains(String.valueOf(c)) &&
                    !leastPriorityChar.contains(String.valueOf(c))) {
                sortedStr.append(c);
            }
        }

        firstArray[index] = sortedStr.toString();
    }



    public static int[] calculateIntegerValues(String[] array) {
        int[] valuesArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            char lastChar = str.charAt(str.length() - 1);
            int intValue = lastChar - 'a' + 1;
            valuesArray[i] = intValue;
        }
        return valuesArray;
    }
}
