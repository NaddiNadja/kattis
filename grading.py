a,b,c,d,e = list(map(int, input().split()))
score = int(input())
best = "A"
if score < a: best = "B"
if score < b: best = "C"
if score < c: best = "D"
if score < d: best = "E"
if score < e: best = "F"
print(best)