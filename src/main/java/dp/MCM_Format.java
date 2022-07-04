
package dp;

public class MCM_Format {

	public static void main(String[] args) {

	}
	//Base condition 
	//- Smallest valid I/P,
	//- Invalid I/P
	public static int solve(int[] arr, int i, int j){
		
		if(i>j)  //can be different for different questions
			return 0;

		for(int k=i; k<j; k++){
			int tempAns = solve(arr, i, k) + solve(arr, k+1, j);
		}
		
		return 1;
	}
}
