n, d = map(int, input().split())
ps = []
for _ in range(n):
  ps.append(int(input()))
ps.sort()
ans = 1
smallest = ps[0]
for i in range(1, n):
  if ps[i] - smallest > d:
    ans += 1
    smallest = ps[i]

print(ans)