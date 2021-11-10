
/**
 * Understanding Sorting Algorithm
 * https://youtu.be/l7-f9gS8VOs
 */
public class SortingAlgorithmPractice {

    public static void main(String[] args) {
        // bubbleSort();
        // selectionSort();
        insertionSort();
    }

    private static void bubbleSort() {
        int[] arr = new int[]{11, 22, 1, 3, 10};
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArray(arr);
    }

    private static void selectionSort() {
        int[] arr = new int[]{11, 22, 3, 1};
        int minIndex;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        printArray(arr);
    }

    private static void insertionSort(){
        int[] arr = new int[] {11,22,1,10};

        int value, hole;

        for (int i = 1; i<arr.length; i++){
            value = arr[i];
            hole = i;
            while (hole > 0 && arr[hole - 1] > value){
                arr[hole] = arr[hole - 1];
                hole = hole -1;
            }
            arr[hole] = value;
        }
    }

    private static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.printf(" %d ", item);
        }
        System.out.println("\n");
    }
}
