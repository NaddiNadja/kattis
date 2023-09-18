import sys
import math
l,w,n,r = map(int, input().split())

def dist(x1,y1,pos):
    if pos == 0:   x2, y2 = -l/2, 0
    elif pos == 1: x2, y2 = 0, w/2
    elif pos == 2: x2, y2 = 0, -w/2
    elif pos == 3: x2, y2 = l/2, 0
    return math.sqrt(abs(x1-x2)**2 + abs(y1-y2)**2)

cranelocations = []

for inp in sys.stdin:
    x,y = map(int, inp.split())
    val = 0
    for i in range(4):
        if dist(x,y,i) <= r: val += 1<<i
    cranelocations.append(val)

sol = []
covered = 0

for val in cranelocations:
    include = True
    for j in sol:
        if val & j != 0: include = False
    for j in sol:
        if val | j == val:
            include = True
            sol.remove(j)
            covered -= j
    if include: 
        sol.append(val)
        covered += val

if covered < 15: print("Impossible")
else:
    for i in sol:
        val = i
        for j in sol:
            val -= i & j
        if val == 0: sol.remove(i)
    print(len(sol))
