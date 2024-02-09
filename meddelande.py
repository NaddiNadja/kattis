n, m = map(int, input().split())
out = [] # there are N rows
for _ in range(n):
  s = input().replace(".", "")
  out.append(s)

print("".join(out))