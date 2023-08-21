class Node:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right

class BinarySearchTree:

    def construct(self, arr, low, high):
        if (low > high):
            return None

        mid = (high + low) // 2
        data = arr[mid]
        lc = self.construct(arr, low, mid - 1)
        rc = self.construct(arr, mid + 1, high)
        node = Node(data, lc, rc)
        return node

    def display(self, node):
        if node == None:
            return

        str_ = ''
        str_ += ' . ' if node.left == None else str(node.left.data)
        str_ += ' <= ' + str(node.data) + ' => '
        str_ += ' . ' if node.right == None else str(node.right.data)
        print(str_)

        self.display(node.left)
        self.display(node.right)

    def size(self, node):
        if node == None:
            return 0

        ls = self.size(node.left)
        rs = self.size(node.right)
        return ls + rs + 1

    def sum(self, node):
        if node == None:
            return 0

        ls = self.sum(node.left)
        rs = self.sum(node.right)
        total = ls + rs + node.data
        return total

    def max(self, node):
        if (node.right != None):
            return self.max(node.right)
        else:
            return node.data

    def min(self, node):
        if (node.left != None):
            return self.min(node.left)
        else:
            return node.data

    def find(self, node, data):
        if node == None:
            return False
        if data > node.data:
            return self.find(node.right, data)
        elif data < node.data:
            return self.find(node.left, data)
        else:
            return True

    def add(self, node, data):
        if node == None:
            return Node(data, None, None)

        if data > node.data:
            node.right = self.add(node.right, data)
        elif data < node.data:
            node.left = self.add(node.left, data)


if __name__ == '__main__':
    arr = [12,  25, 37, 50, 62, 75, 87]
    tree = BinarySearchTree()
    node = tree.construct(arr, 0, len(arr) - 1)
    tree.display(node)
    print('---------------------------')
    # print(tree.size(node))
    # print(tree.sum(node))
    # print(tree.min(node))
    tree.add(node, 44)
    tree.display(node)

    # print(tree.find(node, 77))








