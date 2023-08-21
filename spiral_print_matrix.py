# python3 program for the above approach
import pdb

def spiralOrder(matrix):
    ans = []

    if (len(matrix) == 0):
      return ans

    n = len(matrix)
    m = len(matrix[0])




    return ans


# Driver code
if __name__ == "__main__":
	a = [[1, 2, 3, 4],
		[5, 6, 7, 8],
		[9, 10, 11, 12],
		[13, 14, 15, 16]]

	# Function call
	for x in spiralOrder(a):
		print(x, end=" ")
	print()
