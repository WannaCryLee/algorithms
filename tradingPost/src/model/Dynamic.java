package model;

public class Dynamic {

	public Dynamic() {
		
		
	}
	
	int C[];
	int L[];
	
	void solve(int[][] cost) {
		C = new int[cost.length];
		L = new int[cost.length];


		//C[0] = 0;
		C[1] = 0;
		System.out.println("Cost.length: " + cost.length);
		for (int i = 2; i < cost.length; i++ ){
			C[i] = C[i - 1] + cost[i-1] [i];
			L[i] = i - 1 ;
	
			for (int j = i - 2; j > 1; j--){
				if((C[j] + cost [j][i]) < C[i]){
					C[i] = (C[j] + cost [j][i]);
					L[i] = j;
					System.out.println(i + " - " + j);
				}  
			}
		}
	
		System.out.println("Cheapest Cost of DP!");
		System.out.println("______________\n");

		Recover(L.length - 1);
		//System.out.println("<" + cost.length + ">");

		
	}
	//End of solve()

	private void Recover(int n) {
		if (n != 1){
			//System.out.print(n + "-n " );
			Recover(L[n]);
			
		}
		System.out.print(L[n] + " ");
	}
}
