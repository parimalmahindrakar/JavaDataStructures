import pdb

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    root = None

    def add(self, node):
        if LinkedList.root == None:
            LinkedList.root = node
            return

        temp = LinkedList.root
        while (temp.next != None):
            temp = temp.next

        temp.next = node

    def add_first(self, node):
        if LinkedList.root == None:
            LinkedList.root = node
            return

        temp = LinkedList.root
        LinkedList.root = node
        LinkedList.root.next = temp

    def add_middle(self, node):
        if LinkedList.root == None:
            LinkedList.root = node
            return

        fast = slow = LinkedList.root
        while(fast.next != None):
            # pdb.set_trace()
            slow = slow.next
            fast = fast.next.next

        node.next = slow.next
        slow.next = node

    def delete(self):
        if LinkedList.root == None:
            print('LinkedList is empty')
            return -1

        temp = LinkedList.root
        while (temp.next.next != None):
            temp = temp.next

        data = temp.next.data
        temp.next = None
        return data

    def delete_first(self):
        if LinkedList.root == None:
            print('LinkedList is empty')
            return -1

        data = LinkedList.root.data
        LinkedList.root = LinkedList.root.next
        return data

    def delete_middle(self):
        if LinkedList.root == None:
            print("Empty")
            return

        temp = fast = slow = LinkedList.root
        while(fast.next != None):
            temp = slow
            slow = slow.next
            fast = fast.next.next
        data = slow.data
        temp.next = slow.next
        return data

    def return_size(self):
        cnt = 0
        temp = LinkedList.root
        while(temp != None):
            cnt += 1
            temp = temp.next
        return cnt

    def reverse_ll(self):
        prev = next_ = None
        current = LinkedList.root

        while(current != None):
            next_ = current.next
            current.next = prev
            prev = current
            current = next_

        LinkedList.root = prev

    def print(self):
        temp = LinkedList.root
        while(temp != None):
            print(temp.data, end=' ')
            temp = temp.next
        print()

li = LinkedList()
li.add(Node(1));
li.add(Node(2));
li.add(Node(3));
li.add(Node(4));
li.add_first(Node(777))
li.add_middle(Node(888))
li.print()
# li.delete() # delete last
# li.delete_first() # delete first
# li.delete_middle() # delete middle
# li.print()
# print(li.return_size())
li.reverse_ll()
li.print()


