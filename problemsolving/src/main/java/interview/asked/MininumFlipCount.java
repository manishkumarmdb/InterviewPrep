package interview.asked;

import java.util.Arrays;

/*
 * There are N coins, each showing either heads or tails.
 * Make the coins to form a sequence of alternating heads or tails.
 * What is the minimum number of flip count to make alternative sequence?
 */
public class MininumFlipCount {

    public int minimumFlipCount(int[] A) {
        int result = 0;
        int length = A.length;
        System.out.println("A:" + Arrays.toString(A));
        // first solution
        int bFlipCount = 0;
        int cFlipCount = 0;
        int[] B = new int[length];
        int[] C = new int[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0)
                B[i] = 1;
            if (i % 2 == 1)
                C[i] = 1;
            if (A[i] != B[i])
                bFlipCount++;
            if (A[i] != C[i])
                cFlipCount++;
        }
        System.out.println("B:" + Arrays.toString(B));
        System.out.println("C:" + Arrays.toString(C));
        result = Math.min(bFlipCount, cFlipCount);
        System.out.println("Minimum flip count: " + result);

        // optimize solution
        int changesWithLeading0 = 0;
        int changesWithLeading1 = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] == 1 - (i % 2)) {
                changesWithLeading1++;
            }
            if (A[i] == i % 2) {
                changesWithLeading0++;
            }
        }
        result = Math.min(changesWithLeading0, changesWithLeading1);
        System.out.println(
                "changesWithLeading0: " + changesWithLeading0 +
                        "\nchangesWithLeading1: " + changesWithLeading1
        );

        return result;
    }

    public static void main(String[] args) {
        MininumFlipCount obj = new MininumFlipCount();
        int[] A = {0,1,0,1,1,1,1,0,0,0,0,1,1,0,0,1};
        // int[] A = {1,1,1,0,0,0};
        System.out.println(obj.minimumFlipCount(A));
    }
}
