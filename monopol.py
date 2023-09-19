probs = {}
for i in range(1,7):
    for j in range(1,7):
        if i+j in probs:
            probs[i+j] += 1
        else:
            probs[i+j] = 1

n = int(input())
a = [int(x) for x in input().split()]
prob = 0
for ai in a:
    prob += probs[ai]
print(prob/36)