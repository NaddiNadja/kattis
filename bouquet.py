n = int(input())
pairs = []
max_right = -1
max_taken = -1

for i in range(n):
    l, r = [int(x) for x in input().split()]
    pairs.append((i-l, i, i+r))

pairs.sort(key=lambda x: x[2])
right = [0]*n

for l, i, r in pairs:
    if i > max_right and l > max_taken:
        right[i] = 1
        max_right = r
        max_taken = i

result = sum(right)
print(pairs)
print(right)
print(result)