
public class maxSubArrProblem {
    public static void main(String[] args) {
        int[] findMaxSub = new int[]{-1};
        //6

        System.out.println(maxSubArray(findMaxSub));

    }
    static int maxSubArray(int[] input){
        int maxSoFar = Integer.MIN_VALUE;
        int maxUpToHere = 0;

        for (int j : input) {
            maxUpToHere += j;

            if (maxSoFar < maxUpToHere)
                maxSoFar = maxUpToHere;

            if (maxUpToHere < 0)
                maxUpToHere = 0;
        }
        return maxSoFar;
    }
//    private static int find(int[] findMaxSub) {
//        if (findMaxSub.length<2)return findMaxSub[0];
//
//        int length = findMaxSub.length;
//        int[] left = new int[length/2];
//        int[] right = new int[length-length/2];
//
//        System.arraycopy(findMaxSub, 0, left, 0, length / 2);
//
//        if (length - length / 2 >= 0)
//            System.arraycopy(findMaxSub, length / 2, right, 0, length - length / 2);
//
//        int maxLeft = find(left);
//        int maxRight = find(right);
//
//        return merge(left,right,maxLeft,maxRight);
//    }
//
//    private static int merge( int[] left, int[] right, int maxLeft, int maxRight) {
//        int maxCross = Integer.MIN_VALUE;
//
//        int sum = 0;
//        for (int i = left.length - 1; i >= 0; i--) {
//            sum += left[i];
//            maxCross = Math.max(maxCross, sum);
//        }
//        sum = maxCross;
//        for (int j : right) {
//            sum += j;
//            maxCross = Math.max(maxCross, sum);
//        }
//
//        return Math.max(Math.max(maxLeft, maxRight), maxCross);
//    }
}