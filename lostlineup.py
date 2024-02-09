n = int(input())
ds = list(map(int, input().split()))

out = [0]*n
out[0] = 1

for i in range(n-1):
  index = ds[i] + 1
  out[index] = i+2

print(" ".join([str(x) for x in out]))