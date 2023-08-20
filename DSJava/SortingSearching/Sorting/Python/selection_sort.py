from print_list import print_list

def selection_sort(arr):
    length = len(arr)
    for i in range(length - 1):
        min_index = i
        for j in range(i + 1, length):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[min_index], arr[i] = arr[i], arr[min_index]


if __name__ == '__main__':
    arr = [3, 5, 2, 1, 4]
    print('Before sorting: ')
    print_list(arr)
    print('After sorting: ')
    selection_sort(arr)
    print_list(arr)
