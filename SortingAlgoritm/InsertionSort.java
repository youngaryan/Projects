public class InsertionSort {
    public static void main(String[] args) {
        int[] sort = new int[]{3,2,8,1,12,3};
        insertionSort(sort);
        for (int i : sort)
            System.out.print(i+"  ");
    }

    private static void insertionSort(int[] sort) {
        for (int i = 1; i < sort.length; i++) {
            int temp = sort[i];
            int j = i - 1;
            while (j >= 0 && sort[j] > temp) {
                sort[j + 1] = sort[j];
                j--;
            }
            sort[j+1] = temp;
        }
    }
}
