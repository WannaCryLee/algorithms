package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivideConquer {
	
	int size = 0;
	
	public DivideConquer() {
		
	}
	
	void solve(int[][] cost) {
		size = cost.length;
		List<Integer> solution = helperSolution(cost, 1, 0);
		int price = solution.remove(0);
		Collections.sort(solution);
		System.out.println("Divide and Conquer");
		System.out.print("Cheapest Cost: " + price + "\nSolution: [ 1, ");
		for (int i = 0; i < solution.size() - 1; i++) {
			System.out.print(solution.get(i) + ", ");
		}
		System.out.print(size + " ]\n\n");
	}

	List<Integer> helperSolution(int[][] cost, int post, int depth) {
		List<Integer> postSum = new ArrayList<Integer>();
		postSum.add(0); //Initializes sum to 0
		if (post >= size - 1) {
			postSum.add(post+1);
			addWeight(postSum, cost, depth, post);
			return postSum;
		} else {
			List<Integer> switchBoat = new ArrayList<Integer>();
			switchBoat.add(-1); //Out of bounds node
			List<Integer> stayInBoat = helperSolution(cost, post + 1, depth);
			
			switchBoat = helperSolution(cost, post + 1, post);
			addWeight(switchBoat, cost, depth, post);
			switchBoat.add(post+1);
			
			if (stayInBoat.get(0) < switchBoat.get(0) && switchBoat.get(0) != -1) {
				syncPost(postSum, stayInBoat);
				postSum.remove(0);
				postSum.add(0, stayInBoat.get(0));
				return postSum;
			} else {
				syncPost(postSum, switchBoat);
				int prev = postSum.remove(0);
				postSum.add(0, prev + switchBoat.get(0));
				return postSum;
			}
		}
		
	}
	
	void syncPost(List<Integer> postSum, List<Integer> child) {
		for (int i = 1; i < child.size(); i++) {
			if (!postSum.contains(child.get(i))) {
				postSum.add(child.get(i));
			}
		}
	}
	
	void addWeight(List<Integer> list, int[][] cost, int depth, int post) {
		int prev = list.remove(0);
		list.add(0, prev + cost[depth][post]);
	}
	
	
}
