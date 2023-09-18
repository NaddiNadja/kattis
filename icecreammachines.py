# Indexed PQ stolen from 
# https://medium.com/@me.khoshpasand/indexed-priority-queue-explained-with-the-python-implementation-5f55edd7cdf0
class IndexedMinPQ:
    def __init__(self,N):
        self.N = N
        self.key = [None for i in range(self.N)]
        self.pq = [None for i in range(self.N+1)]
        self.qp =[None for i in range(self.N)]
        self.total = 0

    def insert(self,i,key):
        assert type(i) is int
        if i >= self.N:
            raise IndexError('index is out of the range of IndexedMinPQ.')
        if self.key[i] is not None:
            raise IndexError('index is already in the IndexedMinPQ.')
        self.total += 1
        self.key[i] = key
        self.pq[self.total] = i
        self.qp[i] = self.total
        self.__swim(self.total)

    def __swim(self,i):
        parent_i = i//2

        while parent_i > 0 :
            key = self.key[self.pq[i]]
            parent_key = self.key[self.pq[parent_i]]
            if parent_key < key:
                break
            self.pq[i], self.pq[parent_i] = self.pq[parent_i], self.pq[i]
            self.qp[self.pq[i]] , self.qp[self.pq[parent_i]] = self.qp[self.pq[parent_i]],self.qp[self.pq[i]]
            i = parent_i
            parent_i = i // 2

    def deleteMin(self):
        if not self.isEmpty():
            out = self.pq[1]
            self.key[self.pq[1]] = None
            self.qp[self.pq[1]] = None
            self.pq[1] = self.pq[self.total]
            self.qp[self.pq[1]] = 1
            self.pq[self.total] = None
            self.total -= 1
            self.__sink(1)
            return out
        raise IndexError('IndexedMinPQ is Empty')

    def __sink(self,i):
        child_i = i * 2
        if child_i <= self.total:
            key = self.key[self.pq[i]]
            child_key = self.key[self.pq[child_i]]
            other_child = child_i + 1
            if other_child <= self.total:
                other_child_key =  self.key[self.pq[other_child]]
                if other_child_key < child_key:
                    child_i = other_child
                    child_key = other_child_key
            if child_key < key:
                self.pq[i], self.pq[child_i] = self.pq[child_i], self.pq[i]
                self.qp[self.pq[i]], self.qp[self.pq[child_i]] = self.qp[self.pq[child_i]], self.qp[self.pq[i]]
                self.__sink(child_i)

    def isEmpty(self):
        return self.total == 0

    def decreaseKey(self,i,key):
        if i<0 or i> self.N:
            raise IndexError('index i is not in the range')
        if self.key[i] is None:
            raise IndexError('index i is not in the IndexedMinPQ')
        assert type(i) is int
        assert key < self.key[i]
        self.key[i] = key
        self.__swim(self.qp[i])

    def increaseKey(self,i,key):
        if i<0 or i> self.N:
            raise IndexError('index i is not in the range')
        if self.key[i] is None:
            raise IndexError('index i is not in the IndexedMinPQ')
        assert type(i) is int
        assert key > self.key[i]
        self.key[i] = key
        self.__sink(self.qp[i])


PRINT = False
n, m, k = [int(x) for x in input().split()]

lines = []
indices = {}
for i in range(m): indices[i] = []

for i in range(n): 
    icecreamflavor = int(input())-1
    lines.append(icecreamflavor)
    indices[icecreamflavor].append(i)

if PRINT: print(indices)

pq = IndexedMinPQ(m)
inmachine = [False for _ in range(m)]
amountofmachinesinuse = 0

sum = 0
for i in range(n):
    icecream = lines[i]

    if PRINT: print("inmachine", inmachine)

    if inmachine[icecream]: 
        indices[icecream].pop(0)
        if len(indices[icecream]) > 0:
            nextIndex = indices[icecream][0]
            if PRINT: print(f'{icecream} is decreased to value {(-nextIndex, icecream)}')
            pq.decreaseKey(icecream, -nextIndex)
        continue

    sum += 1
    
    if amountofmachinesinuse < k:
        indices[icecream].pop(0)
        nextIndex = indices[icecream][0]
        if PRINT: print(f'{icecream} is inserted with value {(-nextIndex, icecream)}')
        pq.insert(icecream, -nextIndex)
        amountofmachinesinuse += 1
        inmachine[icecream] = True
        continue

    # all machines are in use
    
    if not pq.isEmpty():
        fif = pq.deleteMin()  
        inmachine[fif] = False

    if PRINT: print(f'{icecream} flavor indices: {indices[icecream]}')
    indices[icecream].pop(0)
    inmachine[icecream] = True
    if len(indices[icecream]) > 0:
        nextIndex = indices[icecream][0]
        if PRINT: print(f'{icecream} is inserted with value {(-nextIndex, icecream)}')
        pq.insert(icecream, -nextIndex)

print(sum)
        
        