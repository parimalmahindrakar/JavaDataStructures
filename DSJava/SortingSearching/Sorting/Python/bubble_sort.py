
def bubble_sort(arr):
    length = len(arr)
    for i in range(length):
        for j in range(length - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

def print_list(list_):
    for i in list_:
        print(i, end=" ")
    print()

if __name__ == '__main__':
    arr = [3, 5, 2, 1, 4]
    print('Before sorting: ')
    print_list(arr)
    print('After sorting: ')
    bubble_sort(arr)
    print_list(arr)
