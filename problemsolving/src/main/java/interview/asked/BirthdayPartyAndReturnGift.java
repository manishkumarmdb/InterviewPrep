package interview.asked;

import java.io.*;

public class BirthdayPartyAndReturnGift {

    public static int findDamagedToy(int N, int T, int D) {
        // If there's only one toy, the first kid gets it.
        if (T == 1) {
            return D;
        }

        // Calculate the position of the kid receiving the last toy
        int damagedToyRecipient = (D + T - 1) % N;

        // If the remainder is 0, it means the last kid (N) receives it
        if (damagedToyRecipient == 0) {
            return N;
        } else {
            return damagedToyRecipient;
        }
    }

    public static void main(String[] args) throws IOException {

        BirthdayPartyAndReturnGift obj = new BirthdayPartyAndReturnGift();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        int D = Integer.parseInt(bufferedReader.readLine().trim());

        int result = obj.findDamagedToy(N, T, D);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
