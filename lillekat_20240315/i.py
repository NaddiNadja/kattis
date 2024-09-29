# Create a Node class to create a node
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None
 
# Create a LinkedList class
 
 
class LinkedList:
    def __init__(self):
      self.head = None
      self.tail = None
 
    # Method to add a node at the end of LL
    def insertAtEnd(self, data):
      new_node = Node(data)
      if self.head is None:
        self.head = new_node
      else:
        current_node = self.tail 
        current_node.next = new_node
        new_node.prev = current_node
      self.tail = new_node
 
    # Print the size of linked list
    def sizeOfLL(self):
      size = 0
      if(self.head):
        current_node = self.head
        while(current_node):
          size = size+1
          current_node = current_node.next
        return size
      else:
        return 0

s = LinkedList() 
for c in input():
  s.insertAtEnd(c)

geti = {"A": 0, "B": 1, "C": 2}

subsequences = 0

while s.head is not None:
  subsequences += 1
  has = [False, False, False]
  c = s.head
  foundnewhead = False
  while c is not None:
    if not has[geti[c.data]]:
      has[geti[c.data]] = True
      if c.prev is not None:
        c.prev.next = c.next
      else:
        s.head = c.next
      if c.next is not None:
        c.next.prev = c.prev
      else:
        s.tail = c.prev
    if all(has):
      has = [False, False, False]
    c = c.next

print(subsequences)
  
  