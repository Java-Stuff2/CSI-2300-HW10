import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int[] arr = generateRandomArray(10000);

        System.out.println("\nChoose a sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        int choice = scanner.nextInt();
        long startTime, endTime, executionTime;

        switch (choice) {
            case 1:
                startTime = System.currentTimeMillis();
                bubbleSort(arr);
                endTime = System.currentTimeMillis();
                executionTime = endTime - startTime;
                System.out.println("\nBubble Sort took " + executionTime + " milliseconds to sort 10,000 integers.");
                break;
            case 2:
                startTime = System.currentTimeMillis();
                int n = 10000;
                mergeSort(arr, 0, n - 1);
                endTime = System.currentTimeMillis();
                executionTime = endTime - startTime;
                System.out.println("\nMerge Sort took " + executionTime + " milliseconds to sort 10,000 integers.");
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100); // Generate random integers between 0 and 99
        }
        return arr;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort implementation
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
