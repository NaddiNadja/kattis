n = int(input())
pairs = []
max_right = -1
max_taken = -1
intervals = 0

for i in range(n):
    l, r = [int(x) for x in input().split()]
    pairs.append((max(0,i-l), i, min(n,i+r)))

pairs.sort(key = lambda x: x[2])

for l, i, r in pairs:
    if l >= max_right and i > max_right and l > max_taken:
        print("i,", i)
        max_right = r
        max_taken = i
        intervals += 1

print(intervals)