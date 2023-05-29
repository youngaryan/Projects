import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sort = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            sort[i] = random.nextInt(1000);
        }
        mergeSort(sort);
        for (int i : sort)
            System.out.print(i + "  ");
    }

    private static void mergeSort(int[] sort) {
        int inputLength = sort.length;
        int middle = sort.length/2;

        if (inputLength<2)
            return;
        int[] left = new int[middle];
        int[] right = new int[inputLength - middle];

        for (int i = 0; i < middle; i++)
            left[i] = sort[i];

        for (int i = middle; i < inputLength; i++)
            right[i-middle] = sort[i];

        mergeSort(left);
        mergeSort(right);
        merge(sort,left,right);
    }

    private static void merge(int[] sort, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0, j = 0, k = 0;

        while (i<leftLength && j <rightLength) {
            if (left[i] <= right[j]){
                sort[k] = left[i];
                i++;
             }
            else {
                sort[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<leftLength){
            sort[k] = left[i];
            i++;
            k++;
        }

        while (j<rightLength){
            sort[k] = right[j];
            j++;
            k++;
        }
    }
}

