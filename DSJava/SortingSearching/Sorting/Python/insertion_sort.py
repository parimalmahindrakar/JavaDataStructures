from print_list import print_list

def insertion_sort(arr):
    length = len(arr)
    for i in range(1, length):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j = j - 1
            
        arr[j + 1] = key

if __name__ == '__main__':
    arr = [3, 5, 2, 1, 4]
    print('Before sorting: ')
    print_list(arr)
    print('After sorting: ')
    insertion_sort(arr)
    print_list(arr)
