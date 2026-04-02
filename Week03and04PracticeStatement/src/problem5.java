import java.util.Arrays;

public class problem5 {

    // ================= LINEAR SEARCH =================
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i + ", Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not found, Comparisons: " + comparisons);
        return -1;
    }

    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                lastIndex = i;
            }
        }

        System.out.println("Linear Last Index: " + lastIndex + ", Comparisons: " + comparisons);
        return lastIndex;
    }

    // ================= BINARY SEARCH =================
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found Index: " + mid + ", Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found, Comparisons: " + comparisons);
        return -1;
    }

    // Count occurrences using binary search
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    private static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear search (unsorted)
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // Sort for binary search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // Binary search
        binarySearch(logs, "accB");

        // Count occurrences
        int count = countOccurrences(logs, "accB");
        System.out.println("Count of accB: " + count);
    }
}