import java.util.Arrays;

public class problem6 {

    // ================= LINEAR SEARCH =================
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index: " + i + ", Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear: Not found, Comparisons: " + comparisons);
        return -1;
    }

    // ================= BINARY SEARCH (INSERTION POINT) =================
    public static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Binary Found at index: " + mid + ", Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Insertion Point: " + low + ", Comparisons: " + comparisons);
        return low; // position where element can be inserted
    }

    // ================= FLOOR =================
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // ================= CEILING =================
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        // Linear search (unsorted simulation)
        linearSearch(risks, 30);

        // Ensure sorted for binary operations
        Arrays.sort(risks);

        // Binary insertion point
        binaryInsertionPoint(risks, 30);

        // Floor and Ceiling
        int floorVal = floor(risks, 30);
        int ceilVal = ceiling(risks, 30);

        System.out.println("Floor(30): " + floorVal);
        System.out.println("Ceiling(30): " + ceilVal);
    }
}
