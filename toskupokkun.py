import sys

PRINT = False
n, T = map(int, input().split())
bags = []
longest_dim = 0
for line in sys.stdin: 
    dimensions = [int(x) for x in line.split()]
    dimensions.sort()
    if dimensions[2] > longest_dim: longest_dim = dimensions[2]
    bags.append(dimensions)

def canFit(l):
    sum = 0
    for x,y,z in bags:
        if l < y:
            if PRINT: print(f'l, {l} < y, {y}, can\'t fit')
            return (T*z, False)
        if l < z:
            if PRINT: print(f'l, {l} < z, {z}, can fit but on long side')
            sum += z
        else:
            if PRINT: print(f'l, {l} >= z, {z}, can fit it all')
            sum += x
        if sum > T: return (sum, False)
    return (sum, True)


def bisect_left(lo, hi):
    """bisect_left_ from the bisect python library"""
    besttime = T+1
    while lo < hi:
        mid = (lo + hi) // 2
        (time, cf) = canFit(mid)
        if time < besttime: besttime = time
        if not cf:
            lo = mid + 1
        else:
            hi = mid
    return (besttime, lo)

besttime, dim = bisect_left(0,longest_dim+1)
if besttime > T: print('Omogulegt!')
else: print(dim)