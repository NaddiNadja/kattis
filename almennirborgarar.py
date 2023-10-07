n, m = [int(x) for x in input().split()]
ts = [int(x) for x in input().split()]

benni = m+1

min = ts[0]
max = ts[0]

for t in ts: # O(n)
    if t < min: min = t
    if t > max: max = t

def howmanyburgerscanwemake(limit): 
    sum = 0
    for t in ts:
        sum += limit // t
    return sum

def binarysearch(lo, hi): # O(log ti)
    while lo < hi:
        mid = (hi + lo) // 2
        bunger = howmanyburgerscanwemake(mid)
        if bunger > m: hi = mid
        else: lo = mid+1
    return lo

print(int(binarysearch(0, (max*benni))))