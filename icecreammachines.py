import sys
# solution made in collaboration with Theis Helth Stensgaard

# Indexed PQ stolen from 
# https://medium.com/@me.khoshpasand/indexed-priority-queue-explained-with-the-python-implementation-5f55edd7cdf0
class IndexedMinPQ:
    def __init__(self,N):
        self.N = N
        self.key = [None for _ in range(self.N)]
        self.pq = [None for _ in range(self.N+1)]
        self.qp =[None for _ in range(self.N)]
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
        if i < 0 or i > self.N:
            raise IndexError('index i is not in the range')
        if self.key[i] is None:
            raise IndexError('index i is not in the IndexedMinPQ')
        assert type(i) is int
        assert key < self.key[i]
        self.key[i] = key
        self.__swim(self.qp[i])

PRINT = False
number_of_lines, total_amount_icecreams, number_of_machines = [int(x) for x in input().split()]

def readInput():
    indices = {}
    for i in range(total_amount_icecreams): # ~ 2 * 10**5, O(m)
        indices[i] = []
    
    i = 0
    lines = []
    for line in sys.stdin: # ~ 2 * 10**5, O(n)
        icecream = int(line) - 1
        lines.append(icecream)
        indices[icecream].append(i)
        i += 1
        if i == number_of_lines:
            break

    for icecream in indices: # O(m)
        indices[icecream] = indices[icecream][::-1]

    return [lines, indices]

input_lines, indices = readInput()
pq = IndexedMinPQ(total_amount_icecreams) # ~ 6 * 10**5, O(m)
inmachine = [False for _ in range(total_amount_icecreams)] # ~ 2 * 10**5, O(m)

amountofmachinesinuse = 0 # O(1)
sum = 0 # O(1)

def updatePQ(cur_icecream): # total, O(log m)
    indices[cur_icecream].pop() # O(1)
    if len(indices[cur_icecream]) > 0: # O(1)
        nextIndex = indices[cur_icecream][-1] # O(1)
        if PRINT: print(f'{cur_icecream+1} is decreased to value {-nextIndex}')
        if inmachine[cur_icecream]: pq.decreaseKey(cur_icecream, -nextIndex) # O(log m)
        else: pq.insert(cur_icecream, -nextIndex) # O(log m)
    else:
        if inmachine[cur_icecream]: pq.decreaseKey(cur_icecream, -(10**7)) # O(log m)
        else: pq.insert(cur_icecream, -(10**7)) # O(log m)

for i in range(number_of_lines): # ~ 2 * 10**5, O(n)
    cur_icecream = input_lines[i] # O(1)
    if PRINT: print(f'--- new iteration with icecream {cur_icecream+1}') 

    if PRINT: print("inmachine before:", inmachine)
    if inmachine[cur_icecream]: # O(1)
        updatePQ(cur_icecream) # O(log m)
        continue

    sum += 1 # O(1)
    
    if PRINT: print(f'amountofmachinesinuse ({amountofmachinesinuse}) < number_of_machines({number_of_machines}) = {amountofmachinesinuse < number_of_machines}')
    if amountofmachinesinuse < number_of_machines: # O(1)
        amountofmachinesinuse += 1 # O(1)
        updatePQ(cur_icecream) # O(log m)
        inmachine[cur_icecream] = True # O(1)
        continue

    # all machines are in use
    
    if PRINT: print(f'pq.isEmpty() = {pq.isEmpty()}')
    if not pq.isEmpty(): # O(1)
        fif = pq.deleteMin() # O(log m)
        if PRINT: print(f'farthest in future = {fif+1}')
        inmachine[fif] = False # O(1)

    if PRINT: print(f'{cur_icecream+1} flavor indices: {indices[cur_icecream]}')
    updatePQ(cur_icecream) # O(log m)
    inmachine[cur_icecream] = True # O(1)

print(sum)
