package model;

import java.util.ArrayList;
import java.util.List;

public class DivideConquer {
	
	int size = 0;
	
	public DivideConquer() {
		
	}
	
	void solve(int[][] cost) {
		size = cost.length;
		List<Integer> sum = new ArrayList<Integer>();
		sum.add(0);
		List<Integer> solution = helperSolution(sum, cost, 0, 0);
		
		System.out.print("Cheapest Price: " + solution.get(0) + "\nSolution: [ ");
		for (int i = 1; i < solution.size() - 1; i++) {
			System.out.print(solution.get(i) + ", ");
		}
		System.out.print(solution.get(solution.size() - 1) + " ]");
	}

	//TODO: Fix list. It is saving every post and sum instead of just a branches post and sum
	List<Integer> helperSolution(List<Integer> sum, int[][] cost, int post, int depth) {
		
		if (post == size - 1 || depth == size - 1) {
			sum.add(post);
			addWeight(sum, cost, post, depth);
			return sum;
		} else {
			sum.add(post);
			List<Integer> stayInBoat = helperSolution(sum, cost, post + 1, depth);
			List<Integer> switchBoat = helperSolution(sum, cost, post, depth + 1);
			
			addWeight(stayInBoat, cost, post, depth);
			addWeight(switchBoat, cost, post, depth);
			
			if ((stayInBoat.get(0) + cost[depth][post]) < (switchBoat.get(0) + cost[depth][post]))
				return stayInBoat;
			else
				return switchBoat;
		}
		
	}
	
	void addWeight(List<Integer> list, int[][] cost, int depth, int post) {
		list.add(0, list.get(0) + cost[depth][post]);
	}
	
	
}
