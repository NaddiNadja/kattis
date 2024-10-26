from collections import defaultdict
k, q = list(map(int, input().split()))
solves = defaultdict(int)
for i in range(k):
  solves[i+1] = 0
for i in range(q):
  a, b = list(map(int, input().split()))
  solves[b] += 1

print(min(solves.values()))