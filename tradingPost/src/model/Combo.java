package model;

import java.util.ArrayList;
import java.util.List;

public class Combo {
	
	int size;
    
    public Combo(int setSize) {
    	size = setSize;
    }
    
    void setSize(int newSize) {
    	size = newSize;
    }
    
    List<List<Integer>> getCombo() {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	List<Integer> array = new ArrayList<Integer>();
    	
    	for (int i = 2; i < size; i++) {
    		array.add(i);
    	}
    	
    	result = displaySubsets(array);
    	
    	
    	System.out.println("Printing all combinations");
    	System.out.println("_________________________");
    	
    	for (List<Integer> combo : result) {
    		System.out.print("[ ");
    		combo.add(0, 1);
    		combo.add(size);
    		for (int num : combo) {
    			System.out.print(num + ", ");
    		}
    		
    		System.out.println(" ]");
    	}
    	System.out.println();
    	
    	return result;
    }
    
    
    List<List<Integer>> displaySubsets(List<Integer> sortedInts) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = sortedInts.size();
        long combinations = 1 << n;
        for (int setNumber = 0; setNumber < combinations; setNumber++) {
          List<Integer> aResult = new ArrayList<Integer>();
          for (int digit = 0; digit < n; digit++) {
            if ((setNumber & (1<<digit)) > 0) {
              aResult.add(sortedInts.get(digit));
            }
          }
          result.add(aResult);
        }
        return result;
      }
}