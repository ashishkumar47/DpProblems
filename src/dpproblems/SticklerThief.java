package dpproblems;


//Approach 1 is using recursion which gives TLE for long input.
//Approach 2 is using Memoization.
//Approach 3 is using Bottom up approach.

public class SticklerThief {

	static int helperMemo(int a[], int start, int n, int[] dp) {
		if (start >= n) {
			return 0;
		}
		if (dp[start] > 0)
			return dp[start];
		int t1 = helperMemo(a, start + 1, n, dp);
		int t2 = helperMemo(a, start + 2, n, dp) + a[start];
		dp[start] = Math.max(t1, t2);
		return Math.max(t1, t2);
	}

	static public int FindMaxSumMemo(int arr[], int n) {
		// Your code here
		int start = 0;
		int[] dp = new int[n + 1];
		return helperMemo(arr, start, n, dp);
	}

	static int helperRecursion(int a[], int start, int n) {
		if (start >= n) {
			return 0;
		}
		int t1 = helperRecursion(a, start + 1, n);
		int t2 = helperRecursion(a, start + 2, n) + a[start];
		return Math.max(t1, t2);
	}

	static int FindMaxSumRecursion(int arr[], int n) {
		// Your code here
		int start = 0;
		return helperRecursion(arr, start, n);
	}

	static int FindMaxSumDp(int arr[], int n) {
		// Your code here
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return arr[0];
		if (arr.length == 2)
			return Math.max(arr[0], arr[1]);
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			int t1 = arr[i] + dp[i - 2];
			int t2 = dp[i - 1];
			dp[i] = Math.max(t1, t2);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
