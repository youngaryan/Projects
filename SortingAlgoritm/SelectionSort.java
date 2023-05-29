public class SelectionSort {
    public static void main(String[] args) {
        int[] sort = new int[]{3,2,8,1,12,3};
        selectionSort(sort);
        for (int i : sort)
            System.out.print(i+"  ");
    }

    private static void selectionSort(int[] sort) {
        for (int i = 0; i < sort.length-1; i++) {
            int min_index = i;
            for (int j = i+1; j < sort.length; j++) {
                if (sort[min_index]  >sort[j]){
                    min_index = j;
                }
            }
            int temp = sort[i]; ;
            sort[i] = sort[min_index];
            sort[min_index] = temp;
        }
    }
}
