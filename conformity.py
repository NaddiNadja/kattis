from collections import defaultdict
n = int(input())
combs = defaultdict(int)
max = 0
for i in range(n):
    inp = input().split()
    inp.sort()
    inp = " ".join(inp)
    combs[inp] += 1
    if combs[inp] > max: max = combs[inp]

sum = 0
for comb in combs:
    if combs[comb] == max: sum += combs[comb]
print(sum)