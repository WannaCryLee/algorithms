package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class BruteForce {

	public BruteForce() {
		
	}
	
	void solve(int[][] cost) {
		int size = cost.length;
		ArrayList<Integer> answers = new ArrayList<Integer>();
		int sum = 0, itr;
		
		
		ArrayList<Integer> copy = answers;
		Collections.sort(answers);
		int index = copy.indexOf(answers.get(1));
		
		System.out.print(answers.get(1) + "\n[ ");
		for (int i = 0; i < size; i++) {
			System.out.print( cost[cost.length - (index + 1)][i] + ", ");
		}
		System.out.print(" ]");
	}
	
	ArrayList<Set<Integer>> combinations(int[][] cost) {
		ArrayList<Set<Integer>> sets = new ArrayList<Set<Integer>>();
		int size = cost.length;
		int numCombo = size*size;
		Set<Integer> current = null;
		
		for (int i = 0; i < numCombo; i++) {
			for (int j = i; j < size; j++) {
				
			}
		}
		
		
		return sets;
	}
	
}
