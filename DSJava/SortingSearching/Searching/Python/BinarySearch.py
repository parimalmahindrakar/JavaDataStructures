def binary_search(arr, left, right, element):
    if right >= left:
        mid = left + (right - left) // 2

        if arr[mid] == element:
              return mid

        if arr[mid] >  element:
            return binary_search(arr, left, mid - 1, element)

        return binary_search(arr, mid + 1, right, element)

    return -1

if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 777]
    index = binary_search(arr, 0, len(arr) - 1, 777)
    print(index)
    index = binary_search(arr, 0, len(arr) - 1, 888)
    print(index)



