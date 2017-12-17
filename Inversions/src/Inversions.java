
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inversions {
	
	private static long merge(int[] a, int[] b, int left, int mid, int right){
		long numberOfInversions = 0;
		//System.out.println("left " + left + " mid " + mid + " right " + right);
		for(int i= 0 ; i < a.length; i++){
			b[i] = a[i];
			
		}
		
		int leftPtr = left;
		int rightPtr = mid+1;
		int Index = left;
		while(leftPtr <= mid && rightPtr <=right){
			
			if(b[leftPtr] <= b[rightPtr]){
				a[Index] = b[leftPtr];
				leftPtr++;
			} else {
				a[Index] = b[rightPtr];
				
				rightPtr++;
				numberOfInversions = numberOfInversions + mid + 1 -leftPtr ;
			}	
			Index++;
		}
		while(leftPtr <= mid){
			a[Index] = b[leftPtr];
			leftPtr++;
			Index++;
		}
		while(rightPtr <= right){
			a[Index] = b[rightPtr];
			rightPtr++;
			Index++;
		}
		return numberOfInversions;
	}

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left  ) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        
        numberOfInversions += getNumberOfInversions(a, b, ave +1, right);
        numberOfInversions += merge(a,b,left, ave, right);
        return numberOfInversions;
    }

    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("/Users/marilynwaldman/Downloads/file1.txt");
        Scanner scanner = new Scanner(file);
       

        int n = 100000;
        int[] a = new int[n];
      
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}
