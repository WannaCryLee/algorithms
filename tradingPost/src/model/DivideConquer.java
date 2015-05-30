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
		
		System.out.print("Cheapest Price: " + price + "\nSolution: [ 1, ");
		for (int i = 0; i < solution.size() - 1; i++) {
			System.out.print(solution.get(i) + ", ");
		}
		System.out.print(size + " ]");
	}

	//TODO: Fix list. It is saving every post and sum instead of just a branches post and sum
	List<Integer> helperSolution(int[][] cost, int post, int depth) {
		List<Integer> postSum = new ArrayList<Integer>();
		postSum.add(0); //Initializes sum to 0
		if (post >= size - 1) {
			postSum.add(post+1);
			addWeight(postSum, cost, depth, post);
			return postSum;
		} else {
			//postSum.add(post+1);
			List<Integer> switchBoat = new ArrayList<Integer>();
			switchBoat.add(-1); //Out of bounds node
			List<Integer> stayInBoat = helperSolution(cost, post + 1, depth);
			if ((depth + post) < size) {
				switchBoat = helperSolution(cost, post + 1, depth + post);
				addWeight(switchBoat, cost, depth, post);
				switchBoat.add(post+1);
			}
			//addWeight(stayInBoat, cost, depth, post);
			
			
			if (stayInBoat.get(0) + postSum.get(0) < switchBoat.get(0) + postSum.get(0) && switchBoat.get(0) != -1) {
				syncSum(postSum, stayInBoat);
				return postSum;
			} else {
				syncSum(postSum, switchBoat);
				return postSum;
			}
		}
		
	}
	
	void syncSum(List<Integer> postSum, List<Integer> child) {
		for (int i = 0; i < child.size(); i++) {
			if (i == 0) {
				int prev = postSum.remove(0);
				postSum.add(i, prev + child.get(0));
			} else {
				if (!postSum.contains(child.get(i))) {
					postSum.add(child.get(i));
				}
			}
		}
	}
	
	void addWeight(List<Integer> list, int[][] cost, int depth, int post) {
		int prev = list.remove(0);
		list.add(0, prev + cost[depth][post]);
	}
	
	
}
