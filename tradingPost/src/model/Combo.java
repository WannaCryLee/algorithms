package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//Combo class
public class Combo {
	
	int size;
    
    public Combo(int setSize) {
    	size = setSize;
    }
    
    void setSize(int newSize) {
    	size = newSize;
    }
    
    Set<Set<Integer>> getCombo() {
    	Set<Set<Integer>> result = new HashSet<Set<Integer>>();
    	
    	Set<Integer> array = new TreeSet<Integer>();
    	
    	for (int i = 2; i < size; i++) {
    		array.add(i);
    	}
    	
    	result = powerSet(array);
    	
    	for (Set<Integer> combo : result) {
    		combo.add(1);
    		combo.add(size);
    	}
    	return result;
    }
    
    
    Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new TreeSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new TreeSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new TreeSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
