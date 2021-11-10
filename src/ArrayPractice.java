import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class ArrayPractice {

    public static void main(String[] args) {
        //problem1_reverse_array();
        //problem2_min_max_value();
        problem3_kth_smallest_element();
    }

    static class Pair {
        int min;
        int max;
    }

    private static void problem1_reverse_array() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};

        /**
         * Approach 1 -
         */
        int steps = 0;
        for (int i = 0; i <= nums.length / 2 - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
            steps++;
        }
        for (int i : nums) {
            System.out.printf(" %d ", i);
        }
        System.out.printf("\nNo of Steps Required %d \n-----------------------\n", steps);

        steps = 0;
        int start = 0;
        int end = nums2.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums2[start] = nums2[end];
            nums2[end] = temp;
            start++;
            end--;
            steps++;
        }

        for (int i : nums2) {
            System.out.printf(" %d ", i);
        }
        System.out.printf("\nNo of Steps Required %d \n-----------------------\n", steps);
    }

    private static void problem2_min_max_value() {
        System.out.print("\n_____Find Min & Max Value using minimum comparison____\n");
        int[] arr = new int[]{11, 22, 33, 44, 55, 66};
        int min, max;

        //Approach 1
        /*
        if (arr.length == 1) {
            min = max = arr[0];
        } else {

            // Initialize min and max value
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }

            for (int i = 2; i<arr.length; i++){
                if (arr[i] > max) {
                    max = arr[i];
                }else if (arr[i] < min){
                    min = arr[i];
                }
            }
        }
        System.out.printf("Min : %d and Max : %d",min,max);
         */

        Pair minMaxPair = getMinMax(arr, 0, arr.length - 1);
        System.out.printf("Min : %d and Max : %d", minMaxPair.min, minMaxPair.max);


    }

    private static Pair getMinMax(int[] arr, int low, int high) {
        Pair minMaxpair = new Pair();

        if (low == high) {
            minMaxpair.min = minMaxpair.max = arr[low];
            return minMaxpair;
        } else if (high == low + 1) {
            if (arr[0] < arr[1]) {
                minMaxpair.min = arr[low];
                minMaxpair.max = arr[high];
            } else {
                minMaxpair.max = arr[low];
                minMaxpair.min = arr[high];
            }
            return minMaxpair;
        } else {
            int mid = (low + high) / 2;
            Pair mml = getMinMax(arr, low, mid);
            Pair mmr = getMinMax(arr, mid + 1, high);

            if (mml.min < mmr.min) {
                minMaxpair.min = mml.min;
            } else {
                minMaxpair.min = mmr.min;
            }

            if (mml.max > mmr.max) {
                minMaxpair.max = mml.max;
            } else {
                minMaxpair.max = mmr.max;
            }

            return minMaxpair;
        }
    }

    private static void problem3_kth_smallest_element() {
        int[] arr = new int[]{11, 2, 33, 44, 55, 66};
        int k = 2;

        arr = sortArray(arr);

        System.out.printf("%d th smallest element is %d", k, arr[k-1]);
    }

    private static int[] sortArray(int[] arr) {
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

        return arr;
    }
}
