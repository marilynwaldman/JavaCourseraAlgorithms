import java.awt.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        TreeMap<Double, Integer> sorted = new TreeMap<Double, Integer>(Collections.reverseOrder());
        for(int i = 0; i < values.length; i++){
        	
        	sorted.put((double)(values[i])/(double)(weights[i]),i);
        }
        for (Double x : sorted.keySet()){
            //System.out.println("Key: " + x + ". Value: " + sorted.get(x));
            int Index = sorted.get(x);
            int wtMin = Math.min(capacity, weights[Index]);
            //System.out.println("wtMin " + wtMin);
            capacity -= wtMin;
            value += x * wtMin;
        }
        //write your code here

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

