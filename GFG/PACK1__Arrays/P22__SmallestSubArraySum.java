package PACK1__Arrays;

class SmallestSubArraySum
{
	// Returns length of smallest subarray with sum greater than x.
	// If there is no subarray with given sum, then returns n+1
	static int smallestSubWithSum(int arr[], int n, int x)
	{
		// Initialize length of smallest subarray as n+1
		int min_len = n + 1;

		// Pick every element as starting point
		for (int start = 0; start < n; start++)
		{
			// Initialize sum starting with current start
			int curr_sum = arr[start];

			// If first element itself is greater
			if (curr_sum > x)
				return 1;

			// Try different ending points for curremt start
			for (int end = start + 1; end < n; end++)
			{
				// add last element to current sum
				curr_sum += arr[end];

				// If sum becomes more than x and length of
				// this subarray is smaller than current smallest
				// length, update the smallest length (or result)
				if (curr_sum > x && (end - start + 1) < min_len)
					min_len = (end - start + 1);
			}
		}
		return min_len;
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		int arr1[] = {1, 4, 45, 6, 10, 19};
		int x = 51;
		int n1 = arr1.length;
		int res1 = smallestSubWithSum(arr1, n1, x);
		if (res1 == n1+1)
		    System.out.println("Not Possible");
		else
		    System.out.println(res1);


	}
}

// This code has been contributed by Mayank Jaiswal
