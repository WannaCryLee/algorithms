package model;

import java.util.List;

public class BruteForce {

	public BruteForce() {
		
	}
	
	void solve(int[][] cost) {
		int size = cost.length;
		
		Combo combinations = new Combo(size);
		
		List<List<Integer>> combos = combinations.getCombo();
		
		int[] sums = getSums(combos, cost);
		
		System.out.println("Sums");
		for (int i = 0; i < sums.length; i++) {
			System.out.print(sums[i] + ", ");
		}
		
		int index = getSmallestSumIndex(sums);
		
		System.out.println("Index: " + index);
		
		List<Integer> answer = combos.get(index);
		
		System.out.println("Cheapest Cost!");
		System.out.println("______________\n");
		
		System.out.print("[ ");
		for (int i = 0; i < answer.size() - 1; i++) {
			System.out.print(answer.get(i) + ", ");
		}
		System.out.print(answer.get(answer.size() - 1) + " ]\n");
		
	}
	
	int[] getSums(List<List<Integer>> combo, int[][] cost) {
		int[] sums = new int[combo.size()];
		int sumIndex = 0;
		int col = 0;
		int row = 0;
		
		for (List<Integer> aCombo : combo) {
			for (int i = 0; i < aCombo.size() - 2; i++) {
				row = aCombo.get(i);
				col = aCombo.get(i + 1);
				sums[sumIndex] += cost[row][col];
			} 
			if (sums[sumIndex] != 0)
				sumIndex++;
		}

		return sums;
	}
	
	int getSmallestSumIndex(int[] sums) {
		int index = 0;
		
		for (int i = 1; i < sums.length; i++) {
			if (sums[i] != 0 && sums[index] > sums[i]){
				index = i;
			}
		}
		
		return index;
	}
	
}
