class Stack:
    def __init__(self, initsize): 
        self.stack = [[0] for i in range(initsize)]
        self.size = 0
    def getSize(self):
        return self.size
    def push(self, c):
        self.stack[self.size] = c
        self.size+=1
    def pop(self):
        if (self.size == 0): return -1
        self.size-=1
        return self.stack[self.size]
    def peak(self):
        if (self.size == 0): return -1
        return self.stack[self.size-1]

n = int(input())
st = Stack(2*n)
ls = [int(x) for x in input().split()]
st.push(ls[0])
for x in ls[1:len(ls)]:
    if (st.peak() == x): st.pop()
    else: st.push(x)
if (st.getSize() > 0): print("impossible")
else: print(2*n)