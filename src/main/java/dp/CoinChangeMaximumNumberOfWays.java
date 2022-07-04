package dp;

import java.util.Arrays;

public class CoinChangeMaximumNumberOfWays {
	public static void main(String[] args){
		int[] coins = new int[]{1,2,3};
		int sum = 5;
		
		int ways = maxWaysForCoinChange(coins, coins.length, sum);
		System.out.println("ways "+ways);
	
	}
	
	private static int maxWaysForCoinChange(int[] coins, int n, int sum){
		int[][] t = new int[n+1][sum+1];
		
		for(int row=0; row<=n;row++){
			for(int col=0; col<=sum; col++){
				if(row==0)
					t[row][col]= 0;
			
				if(col==0)
					t[row][col]=1;
			}
		}
		
		for(int row=1; row<=n;row++){
			for(int col=1; col<=sum; col++){
				
				int currentCoin = coins[row-1];
				int currentSum = col;
				
				if(currentCoin > currentSum)
					t[row][col] = t[row-1][col];
				else
					t[row][col] = t[row-1][col] + t[row][col-currentCoin];
			}
		}
		
		return t[n][sum];
	}
	

}