s, c, k = list(map(int, input().split()))
ds = [int(x) for x in input().split()]

ds.sort()

washes = 0
cur_start = ds[0]
taken = 1

for i in range(1, s):
  if taken >= c or ds[i] - cur_start > k:
    washes += 1
    taken = 0
    cur_start = ds[i]
  taken += 1

print(washes+1)
