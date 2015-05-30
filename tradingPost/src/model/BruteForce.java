package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BruteForce {

	public BruteForce() {
		
	}
	
	void solve(int[][] cost) {
		int size = cost.length;
		
		Combo combinations = new Combo(size);
		
		Set<Set<Integer>> combos = combinations.getCombo();
		List<List<Integer>> listCombo = new ArrayList<List<Integer>>();
		
		for (Set<Integer> comb : combos) {
			List<Integer> list = new ArrayList<Integer>(comb);
			listCombo.add(list);
		}
		
		
		int[] sums = getSums(listCombo, cost);
		
		int index = getSmallestSumIndex(sums);
		
		System.out.println("Index: " + index);
		
		List<Integer> answer = listCombo.get(index);
		
		System.out.println("Cheapest Cost!");
		System.out.println("______________\n");
		
		System.out.print("[ ");
		for (int i = 0; i < answer.size() - 1; i++) {
			System.out.print(answer.get(i) + ", ");
		}
		System.out.print(answer.get(answer.size() - 1) + " ] Cost: " + sums[index] + "\n");
		
	}
	
	int[] getSums(List<List<Integer>> combo, int[][] cost) {
		int[] sums = new int[combo.size()];
		int sumIndex = 0;
		int col = 0;
		int row = 0;
		
		for (List<Integer> aCombo : combo) {
			for (int i = 0; i < aCombo.size() - 1; i++) {
				row = aCombo.get(i) - 1;
				col = aCombo.get(i + 1) - 1;
				sums[sumIndex] += cost[row][col];
			} 
			sumIndex++;
		}

		return sums;
	}
	
	int getSmallestSumIndex(int[] sums) {
		int index = 0;
		
		for (int i = 1; i < sums.length; i++) {
			if (sums[index] > sums[i]){
				index = i;
			}
		}
		return index;
	}
	
}
