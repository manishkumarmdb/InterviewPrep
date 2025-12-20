package interview.asked;

import java.util.Arrays;

public class BinaryStrings {

    public void generateAllBinaryString(int n, int[] A, int index) {
        if (index == n) {
            System.out.println(Arrays.toString(A));
            return;
        }
        A[index] = 0;
        generateAllBinaryString(n, A, index + 1);
        //System.out.println(Arrays.toString(A));
        A[index] = 1;
        generateAllBinaryString(n, A, index + 1);
    }

    public static void main(String[] args) {
        BinaryStrings obj = new BinaryStrings();
        int n = 4;
        int[] A = new int[n];
        obj.generateAllBinaryString(n, A, 0);
    }
}
