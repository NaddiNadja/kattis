class Stack:
    def __init__(self): 
        self.top = None
        self.size = 0
    def getSize(self):
        return self.size
    def isEmpty(self):
        if self.size == 0: return True
        else: return False
    def push(self, c):
        newtop = Node(c, self.top)
        self.top = newtop
        self.size += 1
    def pop(self):
        if self.size == 0: return -1
        item = self.top.item
        self.top = self.top.next
        self.size-=1
        return item
    def peak(self):
        if self.size == 0: return -1
        return self.top.item

    class Node:
        def __init__(self, item, next):
            self.item = item
            self.next = next

w = input()
length = len(w)
stack = Stack()
balanced = True
i = 0
while i<length and balanced:
    c = w[i]
    if c == '(' or c == '[':
        stack.push(c)
    elif c == ')':
        if stack.isEmpty(): balanced = False
        elif stack.pop() != '(': balanced = False
    else:
        if stack.isEmpty(): balanced = False
        elif stack.pop() != '[': balanced = False
    i += 1

if stack.isEmpty() != True: balanced = False
if balanced: print(1)
else: print(0)
