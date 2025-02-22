import sys

sys.setrecursionlimit(10002)

PRINT = False
n, m = map(int, input().split())
ds = list(map(int, input().split()))
dset = set(ds)
ds.sort()

def bisearch(x):
  """Return the index where to insert 
  item x in list a, assuming a is 
  sorted. For a = [10, 20, 30] and 
  x = 20, returns 1."""
  lo = 0
  hi = len(ds)
  while lo < hi:
    mid = (lo + hi) // 2
    if ds[mid] < x:
      lo = mid + 1
    else:
      hi = mid
  return lo

opt = {}

def solve(i):
  if i == 0:
    return 0
  if i in opt:
    length, coins = opt[i]
    if any(coin not in dset for coin in coins):
      del opt[i]
    else:
      return length
  if i in dset:
    return 1
  
  hi = bisearch(i)
  if hi == 0:
    return -1
  
  for j in range(hi-1, -1, -1):
    lenght = solve(i - ds[j])
    if lenght != -1:
      opt[i] = lenght + 1, [ds[j]]
      return opt[i]
  
  return -1

out = []
for line in sys.stdin:
    c, d = line.split()
    d = int(d)
    if c == "Q":
      length = solve(d)
      out.append(str(length))
    if c == "X":
      dset.remove(d)
      ds.remove(d)

print("\n".join(out))