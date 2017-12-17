import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Change {
    private static int getChange(int m, Integer[] coins) {
        //write your code here
    	int num = 0;
    	
    	int Index = 0;
    	while( Index < coins.length &&  m!=0){
    		//System.out.println("coins[Index] " + coins[Index] + "  "+m);
    	    num += m / coins[Index];
     		//System.out.println("num this coin " + num);
    	    m = m % coins[Index];
    	    //System.out.println("m " + m);		
    		Index++;
    	}
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Integer [] coins = {1,5,10};
        
        Arrays.sort(coins, Collections.reverseOrder());
        //Arrays.sort(coins);
        
        
        System.out.println(getChange(m, coins));

    }
}

