import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class QuickSort {
	
	public static int comparisons = 0;
	
	private static int medianOfThree(ArrayList<Integer> list, int left, int right) {
		// TODO Auto-generated method stub
		SortedMap<Integer, Integer> sm = new TreeMap<Integer, Integer>();
		sm.put(list.get(left), left);
		sm.put(list.get(right), right );
		int mid = (right + left)/2;
		sm.put(list.get(mid), mid);
		Collection<Integer> values = sm.values();
	    Integer[] results = values.toArray(new Integer[values.size()]);
		
		
		return results[1];
	}
	
	private static int partition(ArrayList<Integer> list, int left, int right) {
		// TODO Auto-generated method stub
		
		int pivot = medianOfThree(list, left, right);
		pivot = right;
		 
		Collections.swap(list, left, pivot);
		
		int i = left + 1;
		
		int pivotElement = list.get(left);
		for(int j = left + 1; j <= right; j++){
			if(list.get(j) < pivotElement){
				Collections.swap(list, i, j);
				i++;
			}
		Collections.swap(list, left, i-1);	
			
		}

		return i-1;
	}
	
	private static void quickSort(ArrayList<Integer> list, int left, int right) {
		// TODO Auto-generated method stub
		
		if(left >= right) return ;
		comparisons += right - left;
		int p = partition(list, left, right);
		if(p > 0){
			quickSort(list, left, p-1);
		}
		if(p < list.size()){
			quickSort(list, p+1, right);
		}
		
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ArrayList<Integer> list = new ArrayList<Integer>();
		
		File file = new File("/Users/marilynwaldman/numbers.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            list.add(sc.nextInt()); 
	            
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    //System.out.println(list.size());
	    quickSort(list, 0, list.size() -1 );
	    System.out.println(comparisons);
	 }

	
	 
	

}
