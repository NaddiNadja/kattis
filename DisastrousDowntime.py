import sys
import math

n,k = input().split()
ls = [0]*100000
ftree = [0]*(len(ls)+1)
for inp in sys.stdin:
    i = int(inp)
    ls[i] += 1
    pos = i + 1
    while pos < len(ftree):
        ftree[pos] += 1
        pos += (pos & -pos)


def fenwicksum(pos):
    pos += 1
    sum = 0
    while pos > 0:
        sum += ftree[pos]
        pos -= (pos & -pos)
    return sum


max = 0
for i in range(1000,len(ls)):
    subsum = fenwicksum(i) - fenwicksum(i-1000)
    if subsum > max: max = subsum
k = int(k)
print(str(math.ceil(max/k)))