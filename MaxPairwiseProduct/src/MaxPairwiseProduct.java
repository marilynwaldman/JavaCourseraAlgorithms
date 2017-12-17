import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }
    static BigInteger getMaxPairwiseProductFast(int[] numbers) {
    	BigInteger result = BigInteger.valueOf(0);
        int n = numbers.length;
        int Index1 = -1;
        for (int i = 0; i < n; ++i) {
            if(Index1 == -1 || numbers[Index1] < numbers[i]){
            	Index1 = i;
            }
        }
        int Index2 = -1;
        for (int i = 0; i < n; ++i) {
            if((i != Index1)  && (Index2 == -1 || numbers[Index2] < numbers[i])){
            	Index2 = i;
            }
        }
        
        if(Index1 == -1 || Index2 == -1) return result;
        
        BigInteger x1 = BigInteger.valueOf(numbers[Index1]);
        BigInteger x2 = BigInteger.valueOf(numbers[Index2]);
        
        return x1.multiply(x2);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}