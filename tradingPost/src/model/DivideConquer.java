package model;

import java.util.Set;

public class DivideConquer {
	
	public DivideConquer() {
		
	}
	
	Set<Integer> solution(int[][] cost) {
		
	}
	
	int helperSolution(int post, int[][] cost) {
		
		if (post == cost.length - 1)
			return cost[post][post];
		return cost[post][post] + helperSolution(post + 1, cost);
		
	}
	
	
}
