
def linear_search(arr, element):
    index_of_element = None
    for i in arr:
        if i == element:
            index_of_element = arr.index(i)
    return index_of_element

if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 777]
    index = linear_search(arr, 777)
    print(index)
    index = linear_search(arr, 888)
    print(index)


