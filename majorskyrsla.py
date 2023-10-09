n, k = map(int, input().split())

def findIndices():
    ind = []
    cur = k
    largest_available = n-1

    while True:
        if cur <= largest_available:
            ind.append(cur)
            break
        else:
            ind.append(largest_available)
            cur -= largest_available
    return ind

lst = [None]*n
cur = n

for i in findIndices()[::-1]:
    lst[i-1] = cur
    cur -= 1

cur = 1

for i in range(n):
    if lst[i] is None:
        lst[i] = cur
        cur += 1

print(" ".join([str(x) for x in lst]))