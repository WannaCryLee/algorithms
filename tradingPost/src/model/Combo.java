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
    	
    	//result = permute(array);
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
    
    public List<List<Integer>> permute(int[] numbers) {
        // we use a list of lists rather than a list of arrays 
        // because lists support adding in the middle
        // and track current length
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        // Add an empty list so that the middle for loop runs
        permutations.add(new ArrayList<Integer>());

        for ( int i = 0; i < numbers.length; i++ ) {
            // create a temporary container to hold the new permutations 
            // while we iterate over the old ones
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            for ( List<Integer> permutation : permutations ) {
                for ( int j = 0, n = permutation.size() + 1; j < n; j++ ) {
                    List<Integer> temp = new ArrayList<Integer>(permutation);
                    temp.add(j, numbers[i]);
                    current.add(temp);
                }
            }
            permutations = new ArrayList<List<Integer>>(current);
        }

        return permutations;
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
          //System.out.println(aResult.toString()+", ");
        }
        return result;
      }
}