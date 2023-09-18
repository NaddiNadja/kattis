import sys

n,q = input().split()
ls = [0]*int(n)
ftree = [0]*(len(ls)+1)

def fenwicksum(pos):
    i = pos + 1
    total = 0
    while i > 0:
        total += ftree[i]
        i -= (i & -i)
    return total

def fenwickadd(pos, val):
    i = pos + 1
    while i < len(ftree):
        ftree[i] += val
        i += (i & -i)

for inp in sys.stdin:
    query = inp.split()
    if query[0] == '+':
        ls[int(query[1])] += int(query[2])
        fenwickadd(int(query[1]),int(query[2]))
    else:
        print(str(fenwicksum(int(query[1])-1)))