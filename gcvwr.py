g, t, n = list(map(int, input().split()))
trailerweight = (g-t) * 0.9
w = list(map(int, input().split()))
for i in w:
    trailerweight -= i
print(int(trailerweight))
