import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
	private static long getPisanoPeriod(long m){
		
	    BigInteger previous = new BigInteger("0");
	    BigInteger current = new BigInteger("1");
	    BigInteger tmp_current = new BigInteger("1");
	    BigInteger M = BigInteger.valueOf(m);
	    
	  
		int i = 0;
		while(!( i > 0 && previous.equals(BigInteger.ZERO) && current.equals(BigInteger.ONE))){
			tmp_current = current;
			current = (current.add(previous)).mod(M);
			previous = tmp_current;
			i++;
			
		}
		
		
		return i;
	}
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;
        
        long period = getPisanoPeriod(m);
        //System.out.println("period " + period);
        
        long remainder = n % period;
        //System.out.println("remainder " + remainder);
        if(remainder == 0) return 0;
        if(remainder == 1) return 1;
        BigInteger previous = new BigInteger("0");
        BigInteger current = new BigInteger("1");
        BigInteger tmp_current = new BigInteger("1");
        BigInteger M = BigInteger.valueOf(m);;
       

        for (long i = 2; i <= remainder ; i++) {
            tmp_current = current;
            //current = (current.add(previous));
            current = (current.add(previous)).mod(M);
            previous = tmp_current;
            
        }

        return current.mod(M).longValue();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
